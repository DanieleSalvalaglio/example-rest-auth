package it.vidiemme.boilerplate.exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.vertx.core.http.HttpServerRequest;
import it.vidiemme.boilerplate.dto.error.ErrorMessageDTO;
import it.vidiemme.boilerplate.dto.error.ErrorResponseDTO;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The Class ExceptionMappers.
 */
class ExceptionMappers {
	
	private static final Logger LOG = Logger.getLogger(ExceptionMappers.class);

	/**
	 * Handle NotAllowedException.
	 *
	 * @param ex the Exception
	 * @param req the HttpServerRequest
	 * @return the Response
	 */
	@ServerExceptionMapper
	public Response handleNotSupportedException(NotAllowedException ex, HttpServerRequest req) {
		return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(handleMessageError(ex)).build();
	}

	/**
	 * Handle NotSupportedException.
	 *
	 * @param ex the Exception
	 * @param req the HttpServerRequest
	 * @return the Response
	 */
	@ServerExceptionMapper
	public Response handleNotSupportedException(NotSupportedException ex, HttpServerRequest req) {
		return Response.status(Response.Status.BAD_REQUEST).entity(handleMessageError(ex)).build();
	}
	
	/**
	 * Handle InvalidFormatException.
	 *
	 * @param ex the Exception
	 * @param req the HttpServerRequest
	 * @return the Response
	 */
	@ServerExceptionMapper
	public Response handleInvalidFormatException(InvalidFormatException ex, HttpServerRequest req) {
		return Response.status(Response.Status.BAD_REQUEST).entity(handleMessageError(ex)).build();
	}
	
	
	/**
	 * Handle ConstraintViolationException.
	 *
	 * @param ex the Exception
	 * @param req the HttpServerRequest
	 * @return the Response
	 */
	@ServerExceptionMapper
	public Response handleInternalServerError(ConstraintViolationException ex, HttpServerRequest req) {
		String errorId = UUID.randomUUID().toString();
		LOG.errorv("errorId[{0}] - {1}", errorId, ex.getMessage());
		String defaultErrorMessage = ex.getMessage();
	    List<ErrorMessageDTO> errorMessageDTOS = ex.getConstraintViolations().stream()
	            .map(constraintViolation -> new ErrorMessageDTO(null, constraintViolation.getPropertyPath().toString(),
	                constraintViolation.getMessage()))
	            .collect(Collectors.toList());
	        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponseDTO(errorId,defaultErrorMessage, errorMessageDTOS)).build();
	}
	
	/**
	 * Handle internal server error.
	 *
	 * @param ex the Exception
	 * @param req the HttpServerRequest
	 * @return the Response
	 */
	@ServerExceptionMapper
	public Response handleInternalServerError(Exception ex, HttpServerRequest req) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(handleMessageError(ex)).build();
	}
	
	/**
	 * Handle NotFoundException
	 *
	 * @param ex the NotFoundException
	 * @param req the HttpServerRequest
	 * @return the Response
	 */
	@ServerExceptionMapper
	public Response handleProcessingException(javax.ws.rs.NotFoundException ex, HttpServerRequest req) {
		return Response.status(Response.Status.NOT_FOUND).entity(handleMessageError(ex)).build();
	}
	
	/**
	 * Handle ProcessingException
	 *
	 * @param ex the ProcessingException
	 * @param req the HttpServerRequest
	 * @return the Response
	 */
	@ServerExceptionMapper
	public Response handleProcessingException(javax.ws.rs.ProcessingException ex, HttpServerRequest req) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(handleMessageError(ex)).build();
	}
	
	
	/**
	 * Handle message error.
	 *
	 * @param ex the ex
	 * @return the error response
	 */
	private ErrorResponseDTO handleMessageError(Exception ex) {
		String errorId = UUID.randomUUID().toString();
		LOG.errorv("errorId[{0}] - {1}", errorId, ex.getMessage() + " "+ (ex.getCause() != null ? "--> "+ex.getCause().getMessage() : ""));
		String defaultErrorMessage = Optional.ofNullable(ex.getMessage()).orElse(ex.getClass().getSimpleName());
		ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(defaultErrorMessage);
		return new ErrorResponseDTO(errorId, errorMessageDTO);
	}
    

}