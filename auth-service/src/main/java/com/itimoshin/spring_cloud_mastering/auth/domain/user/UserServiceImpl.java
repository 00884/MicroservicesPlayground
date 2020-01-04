package com.itimoshin.spring_cloud_mastering.auth.domain.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final UserRepository repository;
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(UserEntity user) {

		/*Optional<User> existing = repository.findById(user.getUsername()).blockOptional();
		existing.ifPresent(it-> {throw new IllegalArgumentException("user already exists: " + it.getUsername());});

		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);

		repository.save(user);

		log.info("new user has been created: {}", user.getUsername());*/
	}
}
