package com.suicollect.mapper;

import com.suicollect.data.model.User;
import com.suicollect.dto.request.CreateUserRequest;
import com.suicollect.dto.request.UpdateUserProfileRequest;
import com.suicollect.dto.request.UserWalletRegisterRequest;
import com.suicollect.util.EmailVerification;
import com.suicollect.dto.response.*;

public class UserMapper {
    public static User mapToUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setPassword(createUserRequest.getPassword());
        user.setEmail(EmailVerification.emailVerification(createUserRequest.getEmail()));
        user.setRole(createUserRequest.getRole());
        return user;
    }
    public static void mapToUpdateProfile(UpdateUserProfileRequest updateUserProfileRequest, User user) {
        user.setFirstName(updateUserProfileRequest.getFirstName());
        user.setLastName(updateUserProfileRequest.getLastName());
        user.setEmail(updateUserProfileRequest.getEmail());
        user.setPhoneNumber(updateUserProfileRequest.getPhoneNumber());
        user.setRole(updateUserProfileRequest.getRoles());
        user.setLocation(updateUserProfileRequest.getLocation());
        user.setProfilePicturePath(updateUserProfileRequest.getProfilePicturePath());
        user.setActive(user.isActive());
    }
    public static UpdateUserProfileResponse mapToUpdateUserProfileResponse(String token, String message) {
        UpdateUserProfileResponse updateUserProfileResponse = new UpdateUserProfileResponse();
        updateUserProfileResponse.setMessage(message);
        updateUserProfileResponse.setToken(token);
        return updateUserProfileResponse;
    }
    public static CreatedUserResponse mapToCreatedUserResponse(String jwtToken, User user, String message) {
        CreatedUserResponse createdUserResponse = new CreatedUserResponse();
        createdUserResponse.setUser(user);
        createdUserResponse.setMessage(message);
        createdUserResponse.setJwtToken(jwtToken);
        return createdUserResponse;
    }
    public static LoginResponse mapToLoginResponse(String jwtToken, String message, User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setMessage(message);
        loginResponse.setUser(user);
        loginResponse.setUserId(user.getId());
        loginResponse.setRole(user.getRole());
        return loginResponse;
    }
    public static ResetPasswordResponse mapToResetPasswordResponse(String message, String email) {
        ResetPasswordResponse resetPasswordResponse = new ResetPasswordResponse();
        resetPasswordResponse.setMessage(message);
        resetPasswordResponse.setEmail(email);
        return resetPasswordResponse;
    }
    public static UploadResponse mapToUploadResponse(String message, String cloudinaryUrl){
        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setMessage(message);
        uploadResponse.setCloudinaryUrl(cloudinaryUrl);
        return uploadResponse;
    }

    public static OTPResponse mapToOtpSentResponse(String otp, String email, String message) {
        return OTPMapper.mapToOTPResponse(otp, message, email);
    }
    public static FoundResponse mapToFoundResponse(String message, String id){
        FoundResponse foundResponse = new FoundResponse();
        foundResponse.setMessage(message);
        foundResponse.setId(id);
        return foundResponse;
    }

    public static VoiceRegistrationResponse mapToVoiceRegistrationResponse(String message, String email, String status) {
        VoiceRegistrationResponse voiceRegistrationResponse = new VoiceRegistrationResponse();
        voiceRegistrationResponse.setEmail(email);
        voiceRegistrationResponse.setMessage(message);
        voiceRegistrationResponse.setStatus(status);
        return voiceRegistrationResponse;
    }

    public static LogoutResponse mapToLogoutResponse(String message, String email) {
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setEmail(email);
        logoutResponse.setMessage(message);
        return logoutResponse;
    }

    public static VoiceAuthResponse mapToVoiceAuthResponse(String message, String email) {
        VoiceAuthResponse voiceAuthResponse = new VoiceAuthResponse();
        voiceAuthResponse.setEmail(email);
        voiceAuthResponse.setMessage(message);
        return voiceAuthResponse;
    }

    public static UserWalletResponse mapToUserWalletResponse(String message, String id, String walletAddress, boolean exists) {
        UserWalletResponse userWalletResponse = new UserWalletResponse();
        userWalletResponse.setWalletAddress(walletAddress);
        userWalletResponse.setExists(exists);
        userWalletResponse.setMessage(message);
        userWalletResponse.setUserId(id);
        return userWalletResponse;

    }
    public static User mapToUserWalletRegisterResponse(UserWalletRegisterRequest request){
        User user =  new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setProfession(request.getProfession());
        user.setWalletAddress(request.getWalletAddress());
        user.setEmail(request.getEmail());
        user.setBio(request.getBio());
        user.setSocialDiscord(request.getSocialDiscord());
        user.setSocialWebsite(request.getSocialWebsite());
        user.setSocialTwitter(request.getSocialTwitter());
        return user;
    }
    public static UserWalletRegisterResponse mapToUserWalletRegistrationResponse(User user, String message){
        UserWalletRegisterResponse response = new UserWalletRegisterResponse();
        response.setUser(user);
        response.setMessage(message);
        return response;
    }

}
