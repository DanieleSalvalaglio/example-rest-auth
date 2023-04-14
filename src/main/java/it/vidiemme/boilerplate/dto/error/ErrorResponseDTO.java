package it.vidiemme.boilerplate.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@RegisterForReflection
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ErrorResponseDTO {

	public String errorId;
	public ErrorMessageDTO defaultErrorMessage;
	public List<ErrorMessageDTO> errorMessages;

	/**
	 * Constructor
	 */
	public ErrorResponseDTO() {
	}

	/**
	 * Constructor
	 *
	 * @param errorId
	 * @param errorMessageDTO
	 */
	public ErrorResponseDTO(String errorId, ErrorMessageDTO errorMessageDTO) {
		this.errorId = errorId;
		this.defaultErrorMessage = errorMessageDTO;
	}

	/**
	 * Constructor
	 *
	 * @param errorId
	 * @param message
	 * @param errorMessageDTOS
	 */
	public ErrorResponseDTO(String errorId, String message, List<ErrorMessageDTO> errorMessageDTOS) {
		this.errorId = errorId;
		this.errorMessages = errorMessageDTOS;
		this.defaultErrorMessage = new ErrorMessageDTO(message);
	}

}
