package FpsApi.models.response;

import FpsApi.models.entities.UserPlayLog;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FetchLogResponse extends AbstractResponse{

    UserPlayLog object;

}
