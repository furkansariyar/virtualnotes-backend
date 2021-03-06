package co.sudoers.virtualnotes.controller;

import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.LoginRequestDto;
import co.sudoers.virtualnotes.dto.RegistrationRequestDto;
import co.sudoers.virtualnotes.dto.TokenResponse;
import co.sudoers.virtualnotes.entity.User;
import co.sudoers.virtualnotes.repository.UserRepository;
import co.sudoers.virtualnotes.security.JwtTokenUtil;
import co.sudoers.virtualnotes.service.UserService;
import co.sudoers.virtualnotes.service.impl.UserDetailsServiceImpl;
import co.sudoers.virtualnotes.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/token")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(value = "/api/token", description = "Account APIs")
public class AccountController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public AccountController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
                             UserService userService, UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Login Operation", response = TokenResponse.class)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequestDto request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        final User user = userDetailsService.getUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(user.getUserId(), user.getUsername(), token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "Register Operation")
    public ResponseEntity<HashMap<String, String>> register(@RequestBody RegistrationRequestDto registrationRequest)
            throws AuthenticationException {
        String response = userService.register(registrationRequest);
        HashMap<String, String> res = new HashMap<>();
        if (response.equals("ok")) {
            res.put("status", "true");
            res.put("response", response);
            return ResponseEntity.ok(res);
        }
        res.put("status", "false");
        res.put("response", response);
        return ResponseEntity.ok(res);
    }
}
