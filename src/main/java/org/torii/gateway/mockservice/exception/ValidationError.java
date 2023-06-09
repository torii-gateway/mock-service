package org.torii.gateway.mockservice.exception;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ValidationError extends Error {
    private Map<String, String> errors;

    public ValidationError(Integer code, String message, Map<String, String> errors) {
        super(code, message);
        this.errors = errors;
    }
}
