/**
 * 
 */
package com.fleetmgt.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/*
 * @author Shivanand Amalyal
 *
 */
@ControllerAdvice
public class RestExceptionHandler {
	/*private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles
			.lookup().lookupClass());*/
	private static final Logger LOGGER=Logger.getLogger(RestExceptionHandler.class);

	/* @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, })
	    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
	        String bodyOfResponse = "This should be application specific";
	        logException(ex);
	        return handleExceptionInternal(ex, bodyOfResponse, 
	          new HttpHeaders(), HttpStatus.CONFLICT, request);
	    }*/

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public void handleNotFoundException(final Exception exception) {

		logException(exception);

	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	//@ExceptionHandler(CustomForbiddenException.class)
	public void handleForbiddenException(final Exception exception) {

		logException(exception);

	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//@ExceptionHandler({ CustomException.class, Exception.class })
	public void handleGeneralException(final Exception exception) {

		logException(exception);

	}

	/*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public void handleGeneralException(final Exception exception) {

		logException(exception);

	}*/

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	/*@ExceptionHandler({ CustomBadRequestException.class,
			IllegalArgumentException.class })*/
	@ResponseBody
	public String handleBadRequestException(final Exception exception) {

		logException(exception);

		return exception.getMessage();

	}

	// Add more exception handling as needed…

	// …

	private void logException(final Exception exception) {
 
		 LOGGER.info("Exception ::" +exception);
		

	}

}
