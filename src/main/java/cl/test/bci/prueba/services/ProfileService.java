package cl.test.bci.prueba.services;

import cl.test.bci.prueba.exception.BciAppTestException;

/**
 * 
 * @author s2526158
 *
 */
public interface ProfileService {

	public Object getProfile(String id) throws BciAppTestException;
}
