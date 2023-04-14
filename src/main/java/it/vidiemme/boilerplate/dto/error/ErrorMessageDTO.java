package it.vidiemme.boilerplate.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

@RegisterForReflection
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ErrorMessageDTO {
    private String message;
    private String field;
    private String constraints;

    /**
     * Constructor base
     */
    public ErrorMessageDTO() {
    }

    /**
     * Constructor
     *
     * @param message
     */
    public ErrorMessageDTO(String message) {
        this.message = message;
    }

    /**
     * Constructor
     *
     * @param message
     * @param field
     * @param constraints
     */
    public ErrorMessageDTO(String message, String field, String constraints) {
        this.field = field;
        this.message = message;
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        return field + ": " + constraints;
    }


}
