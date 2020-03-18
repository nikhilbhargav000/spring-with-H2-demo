package com.sapient.catalog.search.expection;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sapient.catalog.search.model.ResponseMessage;

@ControllerAdvice
public class SAppsExceptionHanlder {
	
	Logger logger = LoggerFactory.getLogger(SAppsExceptionHanlder.class);
	
	@ExceptionHandler(SAppsRuntimeException.class)
    public ResponseEntity<ResponseMessage> handle(SAppsRuntimeException e)
    {
        ResponseMessage responseMessage = new ResponseMessage();
        if (StringUtils.isBlank(e.getMessage())) {
        	responseMessage.setMessage("Error !!!");
        } else {
        	responseMessage.setMessage(e.getMessage());
        }
        
        logger.debug("EAMemRuntimeException : ", e);
        
        return ResponseEntity.status(e.code).body(responseMessage);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handle(Exception e) {
    	  ResponseMessage responseMessage = new ResponseMessage();
          responseMessage.setMessage("Failed");
          
          logger.error("Exception occurred", e);
          
          return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(responseMessage);
	}

}
