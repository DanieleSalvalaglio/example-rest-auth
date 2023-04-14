package it.vidiemme.boilerplate.dto;

import it.vidiemme.boilerplate.entity.Role;
import it.vidiemme.boilerplate.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserResponseDTO {
    public Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime creationDatetime;
    private LocalDateTime lastUpdateDatetime;
    private List<Role> roles;

    /**
     * Retrieve new UserResponseDTO object from current User
     * @param user User object
     */
    public UserResponseDTO(User user) {
        if(user == null){
            return;
        }
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.creationDatetime = user.getCreationDatetime();
        this.lastUpdateDatetime = user.getLastUpdateDatetime();
        this.roles = user.getRoles();
    }

    /**
     * Retrieve new User object from current UserResponseDTO
     */
    public UserResponseDTO() {
    }
}
