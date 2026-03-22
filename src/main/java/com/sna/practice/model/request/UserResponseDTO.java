package com.sna.practice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long   id;
    private String username;
    private String email;
    private String fullName;   // ✅ password excluded
}