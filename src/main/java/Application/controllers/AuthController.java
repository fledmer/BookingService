package Application.controllers;

import Application.pojo.AuthRequest;
import Application.pojo.MyUserPrincipal;
import Application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Object> addUser(@RequestBody AuthRequest authRequest) {
        userService.addUser(authRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
