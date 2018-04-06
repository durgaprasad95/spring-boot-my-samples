package basics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import basics.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class CustomWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder customPasswordEncoder() {
		PasswordEncoder passwordEncoder = new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
		return passwordEncoder;
	}

	/* create two users: admin and user.
	 * Default USER mentioned in application.properties will be ignored.
	 * Using AuthenticationManager and inMemory allocation
	 * auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
		 .password("password").roles("ADMIN");
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder());
	}

	/* This method tells which will be accessed by what Users(NORMAL USER/ADMIN) and what pages will be loaded for all users
	 * login pages (Defaults)
	 */
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.headers().frameOptions().sameOrigin();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/").permitAll().antMatchers("/console")
				.hasAnyRole("ADMIN").anyRequest().authenticated().antMatchers("/[^console]**")
				.hasAnyRole("USER", "ADMIN").anyRequest().authenticated().and().formLogin().permitAll().and().logout()
				.permitAll();
	}

}
