package br.com.igorborba.userapi.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;
@Data
@AllArgsConstructor
public class StandardError {
    private Instant timestamp;
    private String error;
    private Integer status;
    private String path;
}
