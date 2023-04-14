package it.vidiemme.boilerplate.entity;

import it.vidiemme.boilerplate.entity.abstractEntity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET is_deleted = true, last_update_datetime = now(), delete_datetime = now() WHERE id=?")
@Where(clause = "is_deleted=false")
@Getter
@Setter
public class User extends BaseEntity {

    @NotEmpty
    @Length(max = 250)
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Length(max = 250)
    @Column(name = "surname")
    private String surname;

    @NotEmpty
    @Length(max = 250)
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "creation_datetime")
    private LocalDateTime creationDatetime;

    @Column(name = "last_update_datetime")
    private LocalDateTime lastUpdateDatetime;

    @Column(name = "delete_datetime")
    private LocalDateTime deleteDatetime;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
        name = "users_roles",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<Role>();

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
