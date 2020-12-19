package co.sudoers.virtualnotes.service.impl;

import co.sudoers.virtualnotes.dto.CreateUserDto;
import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.RegistrationRequestDto;
import co.sudoers.virtualnotes.dto.UpdateUserDto;
import co.sudoers.virtualnotes.entity.Note;
import co.sudoers.virtualnotes.entity.User;
import co.sudoers.virtualnotes.repository.UserRepository;
import co.sudoers.virtualnotes.service.NoteService;
import co.sudoers.virtualnotes.service.UserService;
import co.sudoers.virtualnotes.util.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final NoteService noteService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, @Lazy NoteService noteService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.noteService = noteService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        // Set related notes' user value to null
        List<Note> noteList = noteService.getNotesByUserId(userId);
        for (Note note : noteList) {
            note.setUser(null);
        }
        userRepository.delete(user);
    }

    @Override
    public Boolean register(RegistrationRequestDto registrationRequestDto) {
        try {
            // Check
            User userCheck = userRepository.getUserByUsername(registrationRequestDto.getUsername());
            if (userCheck != null) {
                throw new IllegalArgumentException("This username is already exist");
            }
            userCheck = userRepository.getUserByEmail(registrationRequestDto.getEmail());
            if (userCheck != null) {
                throw new IllegalArgumentException("This Email is already exist");
            }

            User user = new User();
            user.setEmail(registrationRequestDto.getEmail());
            user.setFullName(registrationRequestDto.getFullName());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequestDto.getPassword()));
            user.setUsername(registrationRequestDto.getUsername());
            userRepository.save(user);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("REGISTRATION => ", e);
            return Boolean.FALSE;
        }
    }
}