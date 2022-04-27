package FpsApi.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class AbstractResponse {
    private Boolean success = false;
    private String message;
}
