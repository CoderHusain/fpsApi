package FpsApi.models.entities;

import FpsApi.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "UserPlayLog")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserPlayLog {

    public UserPlayLog(){}
    public UserPlayLog(String gameMode, long totalPlayers){
        this.gameMode = gameMode;
        this.totalPlayers = totalPlayers;
    }
    @Transient
    long totalPlayers;

    @Column
    String guid;

    @PrePersist
    public void persistGuid() {
        guid = UUID.randomUUID().toString().toUpperCase();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "user")
    User user;

    @Column
    String gameMode;

    @Column
    private LocalDateTime startDateTime;

    @Column
    private LocalDateTime endDateTime;


    @Column
    LocalDateTime lastModifiedTime;

    @Column
    Constants.PlayingStatus playingStatus;

}
