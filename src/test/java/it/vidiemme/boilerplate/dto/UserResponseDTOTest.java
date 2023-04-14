package it.vidiemme.boilerplate.dto;

import io.quarkus.test.junit.QuarkusTest;
import it.vidiemme.boilerplate.dto.UserResponseDTO;
import it.vidiemme.boilerplate.entity.Role;
import it.vidiemme.boilerplate.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@QuarkusTest
public class UserResponseDTOTest {
    @Test
    //Test generated new UserResponseDToTest
    void testUserResponseDTO() {
        UserResponseDTO userResponseDTo = new UserResponseDTO();
        userResponseDTo.setId(1L);
        userResponseDTo.setSurname("surname");
        userResponseDTo.setName("name");
        userResponseDTo.setEmail("email@demo.it");
        userResponseDTo.setRoles(new ArrayList<>(Arrays.asList(new Role(1L,"ADMIN"))));
        userResponseDTo.setCreationDatetime(LocalDateTime.now());
        userResponseDTo.setLastUpdateDatetime(LocalDateTime.now());

        Assertions.assertNotNull(userResponseDTo);
        Assertions.assertEquals(1L,userResponseDTo.getId());
        Assertions.assertEquals("surname",userResponseDTo.getSurname());
        Assertions.assertEquals("name",userResponseDTo.getName());
        Assertions.assertEquals("email@demo.it",userResponseDTo.getEmail());
        Assertions.assertNotNull(userResponseDTo.getCreationDatetime());
        Assertions.assertNotNull(userResponseDTo.getLastUpdateDatetime());

        User u = new User();
        u.setId(1L);
        u.setSurname("surname");
        u.setName("name");
        u.setEmail("demo@mail.it");
        Role roleU = new Role();
        roleU.setId(2L);
        roleU.setName("nameRole");

        u.setRoles(new ArrayList<>(Arrays.asList(roleU)));
        u.setCreationDatetime(LocalDateTime.now());
        u.setLastUpdateDatetime(LocalDateTime.now());

        userResponseDTo = new UserResponseDTO(u);
        Assertions.assertNotNull(userResponseDTo);
        Assertions.assertEquals(1L,userResponseDTo.getId());
        Assertions.assertEquals("surname",userResponseDTo.getSurname());
        Assertions.assertEquals("name",userResponseDTo.getName());
        Assertions.assertEquals("demo@mail.it",userResponseDTo.getEmail());
        Assertions.assertNotNull(userResponseDTo.getCreationDatetime());
        Assertions.assertNotNull(userResponseDTo.getLastUpdateDatetime());


        userResponseDTo = new UserResponseDTO(null);
        Assertions.assertNotNull(userResponseDTo);
        Assertions.assertNull(userResponseDTo.getId());
        Assertions.assertNull(userResponseDTo.getSurname());
        Assertions.assertNull(userResponseDTo.getName());
        Assertions.assertNull(userResponseDTo.getEmail());
        Assertions.assertNull(userResponseDTo.getCreationDatetime());
        Assertions.assertNull(userResponseDTo.getLastUpdateDatetime());
    }
}
