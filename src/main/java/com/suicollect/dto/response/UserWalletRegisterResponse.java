package com.suicollect.dto.response;

import com.suicollect.data.model.User;
import lombok.Data;

@Data
public class UserWalletRegisterResponse {
    private User user;
    private String message;
}
