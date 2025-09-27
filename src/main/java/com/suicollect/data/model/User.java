package com.suicollect.data.model;

import com.suicollect.data.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements UserDetails {

    @Id
    private String id;
    private String firstName;
    private String email;
    private String walletAddress;
    private String authProviderId;
    private String authProvider;
    private String picture;
    private String name;
    private String encryptedSuiPrivateKey;
    private java.util.Date lastLogin;
    private String password;
    private String phoneNumber;
    private String lastName;
    private String location;
    private String voicePrint;
    private boolean voiceAuthEnabled;
    private String profilePicturePath;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;
    private LocalDateTime lastLogoutDate;
    private LocalDateTime updatedAt;
    private String username;
    private String profession;
    private String bio;
    private String socialTwitter;
    private String socialDiscord;
    private String socialWebsite;

    private boolean isActive;

    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
