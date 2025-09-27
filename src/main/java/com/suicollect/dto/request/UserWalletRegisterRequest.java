package com.suicollect.dto.request;

import lombok.Data;

@Data
public class UserWalletRegisterRequest {
    private String name;
    private String username;
    private String email;
    private String profession;
    private String bio;
    private String walletAddress;
    private String socialTwitter;
    private String socialDiscord;
    private String socialWebsite;

}
