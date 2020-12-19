package co.sudoers.virtualnotes.dto;

import lombok.Data;

@Data
public class RegistrationRequestDto {
    private String username;
    private String fullName;
    private String password;
    private String email;
}
