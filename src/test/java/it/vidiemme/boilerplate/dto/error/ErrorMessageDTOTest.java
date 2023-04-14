package it.vidiemme.boilerplate.dto.error;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ErrorMessageDTOTest {
    @Test
    //Test generated new ErrorMessageDTO
    void errorMessageDTOtest() {
        ErrorMessageDTO error = new ErrorMessageDTO();
        error.setMessage("message");
        error.setField("field");
        error.setConstraints("Not found");

        Assertions.assertNotNull(error);
        Assertions.assertEquals("message",error.getMessage());
        Assertions.assertEquals("field",error.getField());
        Assertions.assertEquals("Not found",error.getConstraints());
        Assertions.assertEquals(error.getField() + ": " + error.getConstraints(),error.toString());

        error = new ErrorMessageDTO("message 2", "field 2", "Missing field");
        Assertions.assertNotNull(error);
        Assertions.assertEquals("message 2",error.getMessage());
        Assertions.assertEquals("field 2",error.getField());
        Assertions.assertEquals("Missing field",error.getConstraints());
        Assertions.assertEquals(error.getField() + ": " + error.getConstraints(),error.toString());
    }
}
