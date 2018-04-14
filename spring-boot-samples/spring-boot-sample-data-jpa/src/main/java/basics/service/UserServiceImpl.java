package basics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basics.domain.User;
import basics.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean validate(String username, String password) throws Exception {
		User tempUser = userRepository.findByUsername(username);
		if (tempUser != null) {
			if (tempUser.getPassword().equals(password)) {
				System.out.println("Logged In");
				return true;
			} else {
				throw new Exception("Password not matched.");
			}
		} else
			throw new Exception("No User is found.");
	}

	@Override
	public User addUser(User user) {
		long count = userRepository.count();
		user.setId(count + 1);
		userRepository.save(user);
		return user;
	}

}
