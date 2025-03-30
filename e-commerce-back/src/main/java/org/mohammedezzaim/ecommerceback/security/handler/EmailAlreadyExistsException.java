package org.mohammedezzaim.ecommerceback.security.handler;

/**
 * @author Ezzaim Mohammed
 **/

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}