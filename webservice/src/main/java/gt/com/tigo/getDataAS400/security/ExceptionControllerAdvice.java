package gt.com.tigo.getDataAS400.security;

import gt.com.tigo.getDataAS400.dto.TigoResponseDto;
import gt.com.tigo.getDataAS400.util.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<TigoResponseDto> handleUnauthorizedException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new TigoResponseDto(HttpStatus.UNAUTHORIZED.value(), "Access denied"));
    }

}

