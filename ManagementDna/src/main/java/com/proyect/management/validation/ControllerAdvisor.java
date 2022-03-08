package com.proyect.management.validation;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.proyect.management.dto.ErrorDTO;


/**
 * @author hburiticao Realiza la Gesti�n de errores.
 *
 */
@ControllerAdvice
@ResponseBody

public class ControllerAdvisor   extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, 
        HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Realiza la gesti�n de errores graves.
     * @param ex informaci�n de la excepcion.
     * @param request WebRequest.
     * @return ResponseEntity
     */
    @ExceptionHandler({ Exception.class, NullPointerException.class, ArrayIndexOutOfBoundsException.class, IOException.class })
    public final ResponseEntity<ErrorDTO> handleAllExceptions(Exception ex, WebRequest request) {
      List<String> details = new ArrayList<>();
      if (StringUtils.isNotBlank(ex.getMessage())) {
        logger.error(ex.getMessage(), ex);
      }

      ErrorDTO error = new ErrorDTO(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), details.toString(),null);
      return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * Se ejecuta cuando hay errores en las validaciones.
     * @param ex excepcion que se levanto;
     * @param request .;
     * @return ResponseEntity
     */
    @ExceptionHandler({ javax.validation.ValidationException.class })
    public final ResponseEntity<ErrorDTO> handleAllExceptions(javax.validation.ValidationException ex, WebRequest request) {
      List<String> details = new ArrayList<>();
      details.add(ex.getLocalizedMessage());
      ErrorDTO error = new ErrorDTO(String.valueOf(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value()), details.toString(),null);
      return new ResponseEntity<>(error, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }
}