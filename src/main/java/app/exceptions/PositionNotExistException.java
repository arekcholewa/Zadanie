package app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PositionNotExistException extends RuntimeException {

    public  PositionNotExistException(String message){
        super(message);
    }
}
