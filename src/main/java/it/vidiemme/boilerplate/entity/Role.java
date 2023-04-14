package it.vidiemme.boilerplate.entity;

import it.vidiemme.boilerplate.entity.abstractEntity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity {
    @NotEmpty
    @Length(max = 250)
    private String name;

    public Role() {
        super();
    }

    public Role(Long id) {
        super();
        this.id = id;
    }

    public Role(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
