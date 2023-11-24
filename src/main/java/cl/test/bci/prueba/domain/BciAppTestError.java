package cl.test.bci.prueba.domain;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BciAppTestError {

	private HttpStatus errorCode;
	private String message;

	public BciAppTestError(HttpStatus errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

}
