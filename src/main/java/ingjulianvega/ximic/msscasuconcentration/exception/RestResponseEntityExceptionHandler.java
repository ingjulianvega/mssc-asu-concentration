package ingjulianvega.ximic.msscasuconcentration.exception;


import ingjulianvega.ximic.msscasuconcentration.web.model.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final ErrorMessageResolver resolver;

    @ExceptionHandler(value = {ConcentrationException.class})
    protected ResponseEntity<Object> handleConflict(ConcentrationException ex, WebRequest request) {

        return handleExceptionInternal(ex, ApiError.builder().code(ex.getCode()).description(ex.getMessage()).build(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return handleExceptionInternal(ex, resolver.resolveException(ex.getBindingResult().getFieldError().getDefaultMessage()),
                headers, HttpStatus.BAD_REQUEST, request);
    }

}

