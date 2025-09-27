package com.suicollect.dto.request;

import com.suicollect.data.enums.Role;
import lombok.Data;

@Data
public class RegisterUserRequest {
    private String email;
    private String otp;
    private Role role;
}
