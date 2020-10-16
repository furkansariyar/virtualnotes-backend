package co.sudoers.virtualnotes.service.impl;

import co.sudoers.virtualnotes.dto.CreateUserDto;
import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.UpdateUserDto;
import co.sudoers.virtualnotes.entity.User;
import co.sudoers.virtualnotes.repository.UserRepository;
import co.sudoers.virtualnotes.service.UserService;
import co.sudoers.virtualnotes.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public GetUserDto saveUser(CreateUserDto createUserDto) {
        User userCheck = userRepository.getUserByUsername(createUserDto.getUsername());
        if (userCheck != null) {
            throw new IllegalArgumentException("This username is already taken");
        }
        User user = userMapper.createUserDtoToUser(createUserDto);
        user = userRepository.save(user);
        return userMapper.userToGetUserDto(user);
    }

    @Override
    public GetUserDto getUser(int userId) {
        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new IllegalArgumentException("User Id is not exist");
        }
        return userMapper.userToGetUserDto(user);
    }

    @Override
    public GetUserDto updateUser(int userId, UpdateUserDto updateUserDto) {
        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new IllegalArgumentException("User Id is not exist");
        }
        if (updateUserDto.getFullName() != null) {
            user.setFullName(updateUserDto.getFullName());
        }
        if (updateUserDto.getUsername() != null) {
            user.setUsername(updateUserDto.getUsername());
        }
        user = userRepository.save(user);
        return userMapper.userToGetUserDto(user);
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new IllegalArgumentException("User Id is not exist");
        }
        userRepository.delete(user);
    }
}
