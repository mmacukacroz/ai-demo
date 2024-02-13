package mihael.macuka.aidemo.service;

import mihael.macuka.aidemo.dto.UserCommand;
import mihael.macuka.aidemo.model.User;

public interface UserService {
    User saveUser(UserCommand userCommand);
}
