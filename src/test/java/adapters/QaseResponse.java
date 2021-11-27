package adapters;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Builder
@Data
@ToString
public class QaseResponse<T> {
    private boolean status;
    private T result;
    private List<ErrorFields> errorFields;
    private String errorMessage;
}
