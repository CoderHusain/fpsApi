package FpsApi.repositories;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    Long id;

    @Column
    String name;

    @Column
    protected String guid;

    @PrePersist
    public void persistGuid() {
        guid = UUID.randomUUID().toString().toUpperCase();
    }


}
