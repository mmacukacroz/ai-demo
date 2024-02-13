package mihael.macuka.aidemo.controller;

import mihael.macuka.aidemo.dto.UserCommand;
import mihael.macuka.aidemo.model.User;
import mihael.macuka.aidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody UserCommand userCommand) {
        return userService.saveUser(userCommand);
    }
}
