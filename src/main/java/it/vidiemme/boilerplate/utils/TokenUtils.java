package it.vidiemme.boilerplate.utils;

import io.smallrye.jwt.build.Jwt;
import it.vidiemme.boilerplate.entity.User;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Collectors;

@ApplicationScoped
public class TokenUtils {
	
	@ConfigProperty(name = "org.acme.code.quarkus.jwt.duration") public Long duration;
	
    /**
     * Generate JWT token
     */
    public String generateToken(User user, Long duration) {
    	if(duration == null) {
    		duration = this.duration;
    	}
    	
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn(user.getEmail())
             //.claim("username",user.getEmail())
             //.claim("firstName",user.getName())
             //.claim("lastName",user.getSurname()).claim("id",user.getId())
             .groups(user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toSet()))
               .expiresIn(duration)
           .sign();
        return token;
    }
    
    public String generateToken(User user) {
    	return generateToken(user,this.duration);
    }
    
}