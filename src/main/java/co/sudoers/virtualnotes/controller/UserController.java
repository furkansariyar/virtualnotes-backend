package co.sudoers.virtualnotes.controller;

import co.sudoers.virtualnotes.dto.CreateUserDto;
import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.UpdateUserDto;
import co.sudoers.virtualnotes.service.UserService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<GetUserDto> getUser(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<GetUserDto> saveUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.saveUser(createUserDto));
    }

    @PutMapping("/updateUserById/{userId}")
    public ResponseEntity<GetUserDto> updateUser(@PathVariable("userId") int userId,
                                                 @Valid @RequestBody UpdateUserDto updateUserDto) {
        return ResponseEntity.ok(userService.updateUser(userId, updateUserDto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }
}
