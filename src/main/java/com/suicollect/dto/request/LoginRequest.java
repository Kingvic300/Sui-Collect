package com.suicollect.dto.request;

import com.suicollect.data.enums.Role;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private Role role;
}
