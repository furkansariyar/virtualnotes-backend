package co.sudoers.virtualnotes.controller;

import co.sudoers.virtualnotes.dto.CreateUserDto;
import co.sudoers.virtualnotes.dto.GetTopicDto;
import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.UpdateUserDto;
import co.sudoers.virtualnotes.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "User APIs")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get User By Id", response = GetUserDto.class)
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<GetUserDto> getUser(@PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @ApiOperation(value = "Save User Operation", response = GetUserDto.class)
    @PostMapping("/saveUser")
    public ResponseEntity<GetUserDto> saveUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.saveUser(createUserDto));
    }

    @ApiOperation(value = "Update User By Id", response = GetUserDto.class)
    @PutMapping("/updateUserById/{userId}")
    public ResponseEntity<GetUserDto> updateUser(@PathVariable("userId") UUID userId,
                                                 @Valid @RequestBody UpdateUserDto updateUserDto) {
        return ResponseEntity.ok(userService.updateUser(userId, updateUserDto));
    }

    @ApiOperation(value = "Delete User By Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteUser(@PathVariable("userId") UUID userId) {
        userService.deleteUser(userId);
    }
}
