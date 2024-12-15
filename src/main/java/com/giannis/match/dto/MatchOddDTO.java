package com.giannis.match.dto;

import jakarta.validation.constraints.*;

public class MatchOddDTO {

    public MatchOddDTO(Long id, String specifier, Double odd) {
        this.id = id;
        this.specifier = specifier;
        this.odd = odd;
    }

    private Long id;

    @NotBlank(message = "Specifier is required")
    private String specifier;

    @NotNull(message = "Odd value is required")
    @DecimalMin(value = "1.0", message = "Odd value must be at least 1.0")
    private Double odd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Specifier is required") String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(@NotBlank(message = "Specifier is required") String specifier) {
        this.specifier = specifier;
    }

    public @NotNull(message = "Odd value is required") @DecimalMin(value = "1.0", message = "Odd value must be at least 1.0") Double getOdd() {
        return odd;
    }

    public void setOdd(@NotNull(message = "Odd value is required") @DecimalMin(value = "1.0", message = "Odd value must be at least 1.0") Double odd) {
        this.odd = odd;
    }
}
