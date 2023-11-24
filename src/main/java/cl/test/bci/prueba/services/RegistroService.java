package cl.test.bci.prueba.services;

import cl.test.bci.prueba.domain.Registro;
import cl.test.bci.prueba.exception.BciAppTestException;

/**
 * 
 * @author s2526158
 *
 */
public interface RegistroService {

	public Object crear(Registro registro) throws BciAppTestException;

}
