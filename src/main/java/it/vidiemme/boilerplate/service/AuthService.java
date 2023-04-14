package it.vidiemme.boilerplate.service;

import io.quarkus.logging.Log;
import it.vidiemme.boilerplate.dto.UserResponseDTO;
import it.vidiemme.boilerplate.dto.auth.AuthRequestDTO;
import it.vidiemme.boilerplate.dto.auth.AuthResponseDTO;
import it.vidiemme.boilerplate.entity.User;
import it.vidiemme.boilerplate.repository.UserRepository;
import it.vidiemme.boilerplate.utils.TokenUtils;
import org.apache.sshd.common.config.keys.loader.openssh.kdf.BCrypt;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class AuthService {

    @Inject
	TokenUtils tokenUtils;
    
    @Inject
	UserRepository userRepository;

	@ConfigProperty(name = "org.acme.code.quarkus.jwt.duration") public Long duration;
	
	public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
		Log.infof("login for user %s", authRequestDTO.username);
		
		Optional<User> u = userRepository.findByUsername(authRequestDTO.username);

		if (!u.isPresent()) {
			return null;
		}

		User user = u.get();
		if (!authenticate(user, authRequestDTO.password)) {
			return null;
		}

		String token = tokenUtils.generateToken(user);
		return new AuthResponseDTO(token);

	}

	public boolean authenticate(User user, String password) {
		return BCrypt.checkpw(password, user.getPassword());
	}

	public UserResponseDTO profile(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (!user.isPresent()) {
			return null;
		}
		return new UserResponseDTO(user.get());
	}
}
