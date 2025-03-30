package org.mohammedezzaim.ecommerceback.security.auth.controller;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.mohammedezzaim.ecommerceback.security.auth.model.AuthenticationRequest;
import org.mohammedezzaim.ecommerceback.security.auth.model.AuthenticationResponse;
import org.mohammedezzaim.ecommerceback.security.auth.model.RegistrationRequest;
import org.mohammedezzaim.ecommerceback.security.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ezzaim Mohammed
 **/
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/register/for-admin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> registerForAdmin(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException {
        service.registerForAdmin(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/activate-account")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException {
        service.activateAccount(token);
    }
}
