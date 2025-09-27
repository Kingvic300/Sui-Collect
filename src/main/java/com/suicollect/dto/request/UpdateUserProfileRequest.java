package com.suicollect.dto.request;

import com.suicollect.data.enums.Role;
import lombok.Data;

@Data
public class UpdateUserProfileRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String location;
    private String phoneNumber;
    private String profilePicturePath;
    private boolean isActive;
    private Role roles;
}
