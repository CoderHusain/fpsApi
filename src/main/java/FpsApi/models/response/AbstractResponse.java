package FpsApi.models.response;

import lombok.Data;

@Data
public class AbstractResponse {
    private Boolean success = false;
    private String message;
}
