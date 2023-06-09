package org.torii.gateway.mockservice.rest.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContentRequest {


    @Size(min = 10, max = 200, message
            = "The data length must be between 10 and 200 characters")
    private String data;

}
