package it.vidiemme.boilerplate.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.vidiemme.boilerplate.entity.Role;
import it.vidiemme.boilerplate.logged.Logging;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Logging
public class RoleRepository implements PanacheRepository<Role> {
}
