package com.giannis.match.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class MatchOddsDTO {
    private Long id;

    @NotBlank(message = "Specifier is required")
    private String specifier;

    @NotNull(message = "Odd value is required")
    @DecimalMin(value = "1.0", message = "Odd value must be at least 1.0")
    private Double odd;
}
