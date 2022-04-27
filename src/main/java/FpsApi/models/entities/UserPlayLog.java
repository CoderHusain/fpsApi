package FpsApi.models.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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


    @Transient
    String userGuid;

}
