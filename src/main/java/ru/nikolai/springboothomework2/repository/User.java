package ru.nikolai.springboothomework2.repository;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    @NotBlank
    @Min(value = 2)
    @Max(10)
    private String user;

    @NotBlank
    private String password;
}
