package com.suicollect.dto.response;

import com.suicollect.data.model.Creator;
import com.suicollect.data.model.User;
import lombok.Data;

@Data
public class UserWalletRegisterResponse {
    private Creator user;
    private String message;
}
