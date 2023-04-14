package it.vidiemme.boilerplate.repository;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import it.vidiemme.boilerplate.entity.Role;
import it.vidiemme.boilerplate.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class RepositoryPanacheFunctionalityTest {
    @InjectMock
    UserRepository userRepository;
    @InjectMock
    RoleRepository roleRepository;

    @Test
    public void userRepositoryMocking() throws Throwable {
        // Mocked classes always return a default value
        Assertions.assertEquals(0, userRepository.count());

        // Now let's specify the return value
        Mockito.when(userRepository.count()).thenReturn(23L);
        Assertions.assertEquals(23, userRepository.count());

        // Now let's change the return value
        Mockito.when(userRepository.count()).thenReturn(42L);
        Assertions.assertEquals(42, userRepository.count());

        // Now let's call the original method
        Mockito.when(userRepository.count()).thenCallRealMethod();
        Assertions.assertEquals(2, userRepository.count());

        // Check that we called it 4 times
        Mockito.verify(userRepository, Mockito.times(4)).count();

        // Mock only with specific parameters
        User u = new User();
        Mockito.when(userRepository.findById(12L)).thenReturn(u);
        Assertions.assertSame(u, userRepository.findById(12L));
        Assertions.assertNull(userRepository.findById(42L));

        // Mock throwing
        Mockito.when(userRepository.findById(12L)).thenThrow(new WebApplicationException());
        Assertions.assertThrows(WebApplicationException.class, () -> userRepository.findById(12L));



    }

    @Test
    public void roleRepositoryMocking() throws Throwable {
        // Mocked classes always return a default value
        Assertions.assertEquals(0, roleRepository.count());

        // Now let's specify the return value
        Mockito.when(roleRepository.count()).thenReturn(23L);
        Assertions.assertEquals(23, roleRepository.count());

        // Now let's change the return value
        Mockito.when(roleRepository.count()).thenReturn(42L);
        Assertions.assertEquals(42, roleRepository.count());

        // Now let's call the original method
        Mockito.when(roleRepository.count()).thenCallRealMethod();
        Assertions.assertEquals(2, roleRepository.count());

        // Check that we called it 4 times
        Mockito.verify(roleRepository, Mockito.times(4)).count();

        // Mock only with specific parameters
        Role r = new Role();
        Mockito.when(roleRepository.findById(12L)).thenReturn(r);
        Assertions.assertSame(r, roleRepository.findById(12L));
        Assertions.assertNull(roleRepository.findById(42L));

        // Mock throwing
        Mockito.when(roleRepository.findById(12L)).thenThrow(new WebApplicationException());
        Assertions.assertThrows(WebApplicationException.class, () -> roleRepository.findById(12L));

        //Now let's call the original method
        r = new Role();
        r.setId(1L);
        r.setName("ADMIN");
        Mockito.when(roleRepository.findById(1L)).thenCallRealMethod();
        Assertions.assertEquals(r.getId(), roleRepository.findById(1L).getId());
        Assertions.assertEquals(r.getName(), roleRepository.findById(1L).getName());
        Assertions.assertNull(roleRepository.findById(3L));

        // Mock only with specific parameters
        List<Role> roles = new ArrayList<>();

        r = new Role();
        r.setId(1L);
        r.setName("ADMIN");
        roles.add(r);

        r = new Role();
        r.setId(2L);
        r.setName("USER");
        roles.add(r);

        Mockito.when(roleRepository.findAll()).thenCallRealMethod();
        Assertions.assertNotSame(roles, roleRepository.findAll().list());
        Assertions.assertEquals(roles.size(), roleRepository.findAll().list().size());
        for (int i = 0; i < roles.size(); i++) {
            Assertions.assertEquals(roles.get(i).getId(), roleRepository.findAll().list().get(i).getId());
            Assertions.assertEquals(roles.get(i).getName(), roleRepository.findAll().list().get(i).getName());
        }

    }
}