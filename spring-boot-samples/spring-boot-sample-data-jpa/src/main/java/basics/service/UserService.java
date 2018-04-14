package basics.service;

import basics.domain.User;

public interface UserService {

	boolean validate(String username, String password) throws Exception;

	User addUser(User user);

	boolean validate(String username) throws Exception;
}
