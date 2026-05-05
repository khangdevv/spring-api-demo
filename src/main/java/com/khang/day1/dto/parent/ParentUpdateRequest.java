package com.khang.day1.dto.parent;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentUpdateRequest {
    private String fullName;

    @Pattern(regexp = "^(84|0[3|5789])+([0-9]{8})$", message = "Phone number must be a valid Vietnamese phone number")
    private String phoneNumber;

    @Email
    @NotNull
    private String email;

    private String address;
}
