package jwl.mis.jewelry_ms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RemoteCustomersNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RemoteCustomersNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(RemoteCustomersNotFoundException exception){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("ErrorMessage",exception.getMessage());

        return errorMap;
    }
}
