package FpsApi.models.entities;

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
@NoArgsConstructor
public class UserPlayLog {

    UserPlayLog(String gameMode, BigDecimal totalPlayers){
        this.gameMode = gameMode;
        this.totalPlayers = totalPlayers;
    }

    @Transient
    BigDecimal totalPlayers;


    @Id
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


}
