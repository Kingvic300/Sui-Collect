package com.suicollect.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZkLoginResponse {
    private boolean success;
    private String sessionToken;
    private UserProfileDto user;
    private String error; // null if success
}
