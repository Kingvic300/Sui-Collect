package com.suicollect.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileDto {
    private String id;
    private String suiAddress;
    private String name;
    private String email;
    private String picture;
}
