package cl.test.bci.prueba.services;

import cl.test.bci.prueba.domain.Response;
import cl.test.bci.prueba.entity.Users;
import cl.test.bci.prueba.exception.BciAppTestException;
import cl.test.bci.prueba.repository.BciAppTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.test.bci.prueba.domain.Login;

@Service
public class LoginImpl implements LoginService {

	@Autowired
	BciAppTestRepository repo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public Object access(Login login) throws BciAppTestException {

		Users resp = repo.findUser(login.getUsername());

		if (resp == null || !encoder.matches(login.getPassword(), resp.getPassword())) {
			throw new BciAppTestException(HttpStatus.UNAUTHORIZED, "Usuario o Contrasena Invalido");
		}

		Users modified = repo.save(resp);
		
		Response data = new Response();
		data.setId(modified.getId());
		data.setCreated(modified.getCreated());
		data.setModified(modified.getModified());
		data.setLastLogin(modified.getLastLogin());
		data.setToken(modified.getToken());
		data.setIsactive("activo");
		return data;
	}

}
