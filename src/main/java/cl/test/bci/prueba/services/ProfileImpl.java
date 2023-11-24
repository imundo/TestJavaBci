package cl.test.bci.prueba.services;

import cl.test.bci.prueba.domain.Response;
import cl.test.bci.prueba.entity.Users;
import cl.test.bci.prueba.exception.BciAppTestException;
import cl.test.bci.prueba.repository.BciAppTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProfileImpl implements ProfileService {

	@Autowired
	BciAppTestRepository repo;

	@Override
	public Object getProfile(String id) throws BciAppTestException {
		Users users = repo.getById(id);
		if (users == null) {
			throw new BciAppTestException(HttpStatus.NO_CONTENT, "No existe usuario");
		}

		Response data = new Response();
		data.setId(users.getId());
		data.setCreated(users.getCreated());
		data.setModified(users.getModified());
		data.setLastLogin(users.getLastLogin());
		data.setToken(users.getToken());
		data.setIsactive("activo");
		return data;
	}

}
