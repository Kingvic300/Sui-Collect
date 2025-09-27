package com.suicollect.dto.response;

import com.suicollect.data.model.User;
import lombok.Data;

@Data
public class CreatedUserResponse {
    private User user;
    private String message;
    private String otp;
    private String jwtToken;

}
