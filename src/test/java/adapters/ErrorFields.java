package adapters;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ErrorFields {
    private String error;
    private String field;
}
