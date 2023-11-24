/**
 * 
 */
package cl.test.bci.prueba.domain;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author s2526158
 *
 */
public class BciAppTestJwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5467875302368377200L;
	private String token;

	public BciAppTestJwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

}
