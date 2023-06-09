package org.torii.gateway.mockservice.exception;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Error {
    private  Integer code;

    private  String message;


}
