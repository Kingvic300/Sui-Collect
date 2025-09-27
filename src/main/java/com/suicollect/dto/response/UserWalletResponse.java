package com.suicollect.dto.response;

import com.suicollect.data.model.User;
import lombok.Data;
@Data
public class UserWalletResponse {
    private String message;
    private String userId;
    private String walletAddress;
    private boolean exists;
}
