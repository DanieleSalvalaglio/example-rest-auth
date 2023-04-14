package it.vidiemme.boilerplate.dto.error;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class ErrorResponseDTOTest {
    @Test
    //Test generated new ErrorResponseDTO
    void errorResponseDTOTest() {

        List<ErrorMessageDTO> errors = new ArrayList<ErrorMessageDTO>();
        for (int i=1 ; i<=3; i++){
            ErrorMessageDTO error = new ErrorMessageDTO();
            error.setMessage("message error "+i);
            error.setField("field "+i);
            error.setConstraints("Details error");
            errors.add(error);
        }

        ErrorResponseDTO res = new ErrorResponseDTO("Code12345", "Message error", errors);

        Assertions.assertNotNull(res);
        Assertions.assertEquals("Code12345",res.getErrorId());
        Assertions.assertEquals(3,res.getErrorMessages().size());
        Assertions.assertEquals("field 1",res.getErrorMessages().get(0).getField());
        Assertions.assertEquals("field 2",res.getErrorMessages().get(1).getField());
        Assertions.assertEquals("field 3",res.getErrorMessages().get(2).getField());

        res = new ErrorResponseDTO();
        res.setErrorId("Code12345");
        res.setErrorMessages(errors);
        res.setDefaultErrorMessage(errors.get(0));


        Assertions.assertNotNull(res);
        Assertions.assertEquals("Code12345",res.getErrorId());
        Assertions.assertEquals(3,res.getErrorMessages().size());
        Assertions.assertEquals("field 1",res.getErrorMessages().get(0).getField());
        Assertions.assertEquals("field 2",res.getErrorMessages().get(1).getField());
        Assertions.assertEquals("field 3",res.getErrorMessages().get(2).getField());

        ErrorMessageDTO error = new ErrorMessageDTO();
        error.setMessage("message error");
        error.setField("field");
        error.setConstraints("Details error");
        res = new ErrorResponseDTO("Code123456", error);

        Assertions.assertNotNull(res);
        Assertions.assertEquals("Code123456",res.getErrorId());
        Assertions.assertEquals(error, res.getDefaultErrorMessage());


    }
}
