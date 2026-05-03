package com.khang.day1.dto.parent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentResponse {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
}
