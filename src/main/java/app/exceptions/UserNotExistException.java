package app.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserNotExistException  extends RuntimeException{

    public  UserNotExistException(String message){
        super(message);
    }
}
