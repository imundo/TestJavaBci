package cl.test.bci.prueba.exception;

import cl.test.bci.prueba.domain.BciAppTestError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BciAppTestControllerException {

	@ExceptionHandler(BciAppTestException.class)
	public BciAppTestError handleMyException(BciAppTestException mex) {
		return new BciAppTestError(mex.getStatus(), mex.getMessage());
	}
}
