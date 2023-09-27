package lk.ijse.gdse.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Response {
    private int statusCode;
    private String message;
    private Object data;
}