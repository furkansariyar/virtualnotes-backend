package co.sudoers.virtualnotes.service;

import co.sudoers.virtualnotes.dto.CreateUserDto;
import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.RegistrationRequestDto;
import co.sudoers.virtualnotes.dto.UpdateUserDto;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public interface UserService {

    GetUserDto saveUser(CreateUserDto createUserDto);
    GetUserDto getUser(UUID userId);
    GetUserDto updateUser(UUID userId, UpdateUserDto updateUserDto);
    void deleteUser(UUID userId);
    String register(RegistrationRequestDto registrationRequestDto);
    ByteArrayInputStream exportNotesByUserId(UUID userId);
}
