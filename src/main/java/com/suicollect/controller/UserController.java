    package com.suicollect.controller;

    import com.suicollect.service.UserService;
    import com.suicollect.dto.request.*;
    import com.suicollect.dto.response.*;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;

    @RestController
    @RequestMapping("/users")
    @RequiredArgsConstructor
    @CrossOrigin("*")
    public class UserController {

        private final UserService userService;

        @PostMapping("/send-verification-otp")
        public ResponseEntity<OTPResponse> sendVerificationOtp(@RequestBody CreateUserRequest request) {
            OTPResponse response = userService.sendVerificationOTP(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/register")
        public ResponseEntity<CreatedUserResponse> register(@RequestBody RegisterUserRequest request) {
            CreatedUserResponse response = userService.register(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/upload")
        public ResponseEntity<UploadResponse> uploadFile(@RequestParam("file") MultipartFile file) {
            UploadResponse response = userService.uploadFile(file);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/login")
        public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
            LoginResponse response = userService.login(loginRequest);
            return ResponseEntity.ok(response);
        }

        @PutMapping("/update-profile")
        public ResponseEntity<UpdateUserProfileResponse> updateProfile(@RequestBody UpdateUserProfileRequest request) {
            UpdateUserProfileResponse response = userService.updateProfile(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/reset-password")
        public ResponseEntity<ResetPasswordResponse> resetPassword(@RequestBody ChangePasswordRequest request) {
            ResetPasswordResponse response = userService.resetPassword(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/send-reset-otp")
        public ResponseEntity<ResetPasswordResponse> sendResetOtp(@RequestBody ResetPasswordRequest request) {
            ResetPasswordResponse response = userService.sendResetOtp(request);
            return ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<FoundResponse> findUserById(@PathVariable String id) {
            FoundResponse response = userService.findUserById(id);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/voice-signup")
        public ResponseEntity<VoiceRegistrationResponse> voiceSignup(@ModelAttribute VoiceSignupRequest request){
            VoiceRegistrationResponse response = userService.voiceSignup(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/complete-voice-registration")
        public ResponseEntity<CreatedUserResponse> completeVoiceRegistration(@RequestBody CompleteVoiceRegistrationRequest request) {
            CreatedUserResponse response = userService.completeVoiceRegistration(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/voice-login")
        public ResponseEntity<LoginResponse> voiceLogin(@ModelAttribute VoiceLoginRequest request){

            LoginResponse response = userService.voiceLogin(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/enable-voice-auth")
        public ResponseEntity<VoiceAuthResponse> enableVoiceAuthentication(@RequestParam("voiceSample") MultipartFile voiceSample) {
            EnableVoiceAuthRequest request = new EnableVoiceAuthRequest();
            request.setVoiceSample(voiceSample);

            VoiceAuthResponse response = userService.enableVoiceAuthentication(request);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/disable-voice-auth")
        public ResponseEntity<VoiceAuthResponse> disableVoiceAuthentication() {
            VoiceAuthResponse response = userService.disableVoiceAuthentication();
            return ResponseEntity.ok(response);
        }

        @PostMapping("/logout")
        public ResponseEntity<LogoutResponse> logout() {
            LogoutResponse response = userService.logout();
            return ResponseEntity.ok(response);
        }

        @PostMapping("/logout-all-devices")
        public ResponseEntity<LogoutResponse> logoutFromAllDevices() {
            LogoutResponse response = userService.logoutFromAllDevices();
            return ResponseEntity.ok(response);
        }

        @PostMapping("/enroll-voice")
        public ResponseEntity<VoiceAuthResponse> enrollVoice(@ModelAttribute VoiceEnrollRequest request) {
            return ResponseEntity.ok(userService.enrollVoiceSample(request));
        }

        @PostMapping("/verify-voice")
        public ResponseEntity<VoiceAuthResponse> verifyVoice(@ModelAttribute VoiceVerifyRequest request) {
            return ResponseEntity.ok(userService.verifyVoiceSample(request));
        }
        @PostMapping("/zklogin")
        public ResponseEntity<ZkLoginResponse> zkLogin(@RequestBody ZkLoginRequest request) {
            ZkLoginResponse response = userService.zkLogin(request);
            return ResponseEntity.ok(response);
        }
        @PostMapping("/verify-wallet")
        public ResponseEntity<UserWalletResponse> verifyUsersWallet(@RequestBody UserWalletRequest request) {
            UserWalletResponse response = userService.verifyUsersWallet(request);
            return ResponseEntity.ok(response);
        }
        @PostMapping("/register-wallet")
        public ResponseEntity<UserWalletRegisterResponse> registerWallet(@RequestBody UserWalletRegisterRequest request) {
            UserWalletRegisterResponse response = userService.registerWallet(request);
            return ResponseEntity.ok(response);
        }
    }

