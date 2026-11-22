package com.abdalhadi9.loyalty_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRequest(
        @NotBlank(message = "Customer name is required") String name,
        @NotBlank(message = "Email is required")@Email(message ="Invalid email format") String email,
        @Size(max = 20) String phoneNumber
) {


}

