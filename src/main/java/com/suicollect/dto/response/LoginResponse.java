package com.suicollect.dto.response;

import com.suicollect.data.enums.Role;
import com.suicollect.data.model.User;
import lombok.Data;

@Data
public class LoginResponse {
    private User user;
    private Role role;
    private String userId;
    private String token;
    private String message;
}
