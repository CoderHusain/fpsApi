package FpsApi.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<UserPlayLog> userPlayLogs = new HashSet<>();

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
