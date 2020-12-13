package co.sudoers.virtualnotes.service;

import co.sudoers.virtualnotes.dto.CreateUserDto;
import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.UpdateUserDto;

public interface UserService {

    GetUserDto saveUser(CreateUserDto createUserDto);
    GetUserDto getUser(int userId);
    GetUserDto updateUser(int userId, UpdateUserDto updateUserDto);
    void deleteUser(int userId);
}
