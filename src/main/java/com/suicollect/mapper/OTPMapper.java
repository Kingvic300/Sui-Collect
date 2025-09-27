package com.suicollect.mapper;

import com.suicollect.dto.response.OTPResponse;

public class OTPMapper {

    public static OTPResponse mapToOTPResponse(String otp, String email, String message) {
        OTPResponse response = new OTPResponse();
        response.setOtp(otp);
        response.setEmail(email);
        response.setMessage(message);
        return response;
    }
}
