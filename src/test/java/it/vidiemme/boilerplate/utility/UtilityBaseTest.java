package it.vidiemme.boilerplate.utility;

import it.vidiemme.boilerplate.entity.Role;
import it.vidiemme.boilerplate.entity.User;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class UtilityBaseTest {

    public User objUser(Long id, String name, String surname, String email, Long roleId, String roleName,boolean isDeleted) {
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setSurname(surname);
        u.setEmail(email);
        u.setRoles(new ArrayList<>(Arrays.asList(new Role(roleId,roleName.toUpperCase()))));
        u.setCreationDatetime(LocalDateTime.now());
        u.setLastUpdateDatetime(LocalDateTime.now());
        u.setIsDeleted(isDeleted);
        if(isDeleted){
            u.setDeleteDatetime(LocalDateTime.now());
        }
        return u;
    }

    public User objCreateUser(Long id, String name, String surname, String email, Long roleId, String roleName,boolean isDeleted) {
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setSurname(surname);
        u.setEmail(email);
        u.setRoles(new ArrayList<>(Arrays.asList(new Role(roleId,roleName.toUpperCase()))));
        u.setCreationDatetime(LocalDateTime.now());
        u.setIsDeleted(isDeleted);
        if(isDeleted){
            u.setDeleteDatetime(LocalDateTime.now());
        }
        return u;
    }

    public List<User> getUsers() {
        User u1 = this.objUser(1L, "Mario", "Rossi", "mario.rossi@mail.it", 1L, "ADMIN", false);
        User u2 = this.objUser(2L, "Luigi", "Bianchi", "luigi.bianchi@mail.it", 2L, "USER", false);
        User u3 = this.objUser(3L, "Maria", "Viola", "maria.viola@mail.it", 2L, "USER", false);
        User u4 = this.objUser(4L, "Marco", "Verdi", "marco.verdi@mail.it", 2L, "USER", false);
        User u5d = this.objUser(5L, "Marino", "Rosa", "marino.rosa@mail.it", 2L, "USER", true);
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        //users.add(u5d);
        return users;
    }

}
