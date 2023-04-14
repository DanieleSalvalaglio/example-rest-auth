package it.vidiemme.boilerplate.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.vidiemme.boilerplate.entity.User;
import it.vidiemme.boilerplate.logged.Logging;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@Logging
public class UserRepository implements PanacheRepository<User> {
    public Optional<User> findByUsername(String username) {
        return find("email", username).firstResultOptional();
    }
}
