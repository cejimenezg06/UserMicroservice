package com.unvest.userMS.userMicroservice.error;

import com.unvest.userMS.userMicroservice.error.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // HANDLING ID EXCEPTION NOT FOUND
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> localNotFoundException(UserNotFoundException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> errors = new HashMap<>();                        // Mapeo necesario de los errores para hacer el forEach
        ex.getBindingResult().getFieldErrors().forEach(error -> {           // A partir de la exception, tomar los resultados -> cada error en campo
            errors.put(error.getField(), error.getDefaultMessage());        // -> Para cada uno, mostrarlo y poner el mensaje personalizado
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);  // Enviar el HttpStatus y el contenido adjunto (previamente editado)
    }
}
