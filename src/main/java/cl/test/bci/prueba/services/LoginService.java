package cl.test.bci.prueba.services;

import cl.test.bci.prueba.domain.Login;
import cl.test.bci.prueba.exception.BciAppTestException;

/**
 * 
 * @author s2526158
 *
 */
public interface LoginService {

	public Object access(Login login) throws BciAppTestException;

}
