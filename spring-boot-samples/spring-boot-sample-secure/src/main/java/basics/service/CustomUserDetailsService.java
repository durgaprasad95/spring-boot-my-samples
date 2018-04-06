package basics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import basics.model.CustomUserDetails;
import basics.model.User;
import basics.repository.AuthorityRepository;
import basics.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUserName(userName);

		optionalUser.orElseThrow(() -> new UsernameNotFoundException("User with Username " + userName + " not found."));
		if (optionalUser.isPresent()) {
			optionalUser.get().setRoles(getRoles(userName));
		}

		return optionalUser.map(user -> {
			return new CustomUserDetails(user);
		}).get();
	}

	private List<GrantedAuthority> getRoles(String userName) {
		String[] roles = authorityRepository.findByCustomQuery(userName).getRoles().split(",");
		List<GrantedAuthority> listRoles = new ArrayList<GrantedAuthority>();
		int length = roles.length;
		for (int i = 0; i < length; i++) {
			listRoles.add(new SimpleGrantedAuthority(roles[i]));
			System.out.println(roles[i]);
		}
		return listRoles;
	}

}
