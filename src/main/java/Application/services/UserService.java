package Application.services;

import Application.entities.User;
import Application.exception.UserAlreadyExistsException;
import Application.pojo.AuthRequest;
import Application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(AuthRequest authRequest) {
        Optional<User> byLogin = userRepository.findByUsername(authRequest.getUsername());
        if (byLogin.isPresent()) {
            throw new UserAlreadyExistsException(String.format("User with username = %s already exists",
                    byLogin.get().getUsername()),
                    byLogin.get().getUsername()
            );
        }
        userRepository.save(
                User.builder()
                        .username(authRequest.getUsername())
                        .password(authRequest.getPassword())
                       /* .roles(Collections.singletonList(Role.builder().name("ADMIN").build()))*/
                        .build()
        );
    }
}
