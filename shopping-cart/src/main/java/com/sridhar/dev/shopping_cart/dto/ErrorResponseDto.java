package com.sridhar.dev.shopping_cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String errorMsg;
    private String httpStatus;
    private OffsetDateTime timestamp;

}
