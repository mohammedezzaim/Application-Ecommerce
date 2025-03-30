package org.mohammedezzaim.ecommerceback.security.auth.service;


import jakarta.mail.MessagingException;

import lombok.RequiredArgsConstructor;
import org.mohammedezzaim.ecommerceback.security.auth.model.AuthenticationRequest;
import org.mohammedezzaim.ecommerceback.security.auth.model.AuthenticationResponse;
import org.mohammedezzaim.ecommerceback.security.auth.model.RegistrationRequest;
import org.mohammedezzaim.ecommerceback.security.bean.UserDetailsImpl;
import org.mohammedezzaim.ecommerceback.security.bean.VerificationCode;
import org.mohammedezzaim.ecommerceback.security.dao.GrantedAuthorityImplDao;
import org.mohammedezzaim.ecommerceback.security.dao.UserDetailsImplDao;
import org.mohammedezzaim.ecommerceback.security.dao.VerificationCodeDao;
import org.mohammedezzaim.ecommerceback.security.email.EmailService;
import org.mohammedezzaim.ecommerceback.security.email.EmailTemplateName;
import org.mohammedezzaim.ecommerceback.security.handler.EmailAlreadyExistsException;
import org.mohammedezzaim.ecommerceback.security.jwt.JwtService;
import org.mohammedezzaim.ecommerceback.security.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ezzaim Mohammed
 **/

@Service
public class AuthenticationService {

    @Autowired
    private GrantedAuthorityImplDao grantedAuthorityImplDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsImplDao userDetailsImplDao;

    @Autowired
    private VerificationCodeDao verificationCodeDao;

    @Autowired
    private EmailService emailservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public AuthenticationService() {

    }

    public AuthenticationService(GrantedAuthorityImplDao grantedAuthorityImplDao, PasswordEncoder passwordEncoder, UserDetailsImplDao userDetailsImplDao, VerificationCodeDao verificationCodeDao, EmailService emailservice, AuthenticationManager authenticationManager, JwtService jwtService, String activationUrl) {
        this.grantedAuthorityImplDao = grantedAuthorityImplDao;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsImplDao = userDetailsImplDao;
        this.verificationCodeDao = verificationCodeDao;
        this.emailservice = emailservice;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.activationUrl = activationUrl;
    }

    @Value("${application.security.mailing.frontend.activation-url}")
    private String activationUrl;

    public void register(RegistrationRequest request) throws MessagingException {

        if (userDetailsImplDao.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("The email " + request.getEmail() + " is already in use.");
        }

        var userRole = grantedAuthorityImplDao.findByRole(Role.USER.name())
                .orElseThrow(() -> new IllegalArgumentException("Role USER was not initialized"));

        UserDetailsImpl user = UserDetailsImpl.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();

        userDetailsImplDao.save(user);
        sendValidationEmail(user);
    }


    public void registerForAdmin(RegistrationRequest request) throws MessagingException {

        if (userDetailsImplDao.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("The email " + request.getEmail() + " is already in use.");
        }

        var userRole = grantedAuthorityImplDao.findByRole(Role.USER.name())
                .orElseThrow(() -> new IllegalArgumentException("Role USER was not initialized"));

        var adminRole = grantedAuthorityImplDao.findByRole(Role.ADMIN.name())
                .orElseThrow(() -> new IllegalArgumentException("Role ADMIN was not initialized"));

        UserDetailsImpl user = UserDetailsImpl.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole,adminRole))
                .build();



        userDetailsImplDao.save(user);
        sendValidationEmail(user);
    }


    private void sendValidationEmail(UserDetailsImpl user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        emailservice.sendEmail(
                user.getEmail(),
                user.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activated"
        );
    }

    private String generateAndSaveActivationToken(UserDetailsImpl user) {
        // generate a token
        String generatedToken = generateActivationCode(6);
        var token = VerificationCode.builder()
                .code(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        verificationCodeDao.save(token);
        return generatedToken;
    }

    private String generateActivationCode( int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i<length; i++){
            int randomIndex = secureRandom.nextInt(characters.length()); // 0..9
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    //@Transactional
    public void activateAccount(String code) throws MessagingException {
        VerificationCode savedToken = verificationCodeDao.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("Activation tok" +
                    "en has expired. A new token has benn sent to the same mail address");
        }
        UserDetailsImpl user = userDetailsImplDao.findById(savedToken.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        user.setEnabled(true);
        userDetailsImplDao.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        verificationCodeDao.save(savedToken);
    }
    
}
