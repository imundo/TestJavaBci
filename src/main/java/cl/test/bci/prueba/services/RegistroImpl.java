package cl.test.bci.prueba.services;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;

import cl.test.bci.prueba.domain.Registro;
import cl.test.bci.prueba.domain.Response;
import cl.test.bci.prueba.entity.Users;
import cl.test.bci.prueba.exception.BciAppTestException;
import cl.test.bci.prueba.repository.BciAppTestRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import cl.test.bci.prueba.utils.JWTGenerator;
import cl.test.bci.prueba.utils.Util;

@Service
public class RegistroImpl implements RegistroService {

	@Autowired
	BciAppTestRepository repo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public Object crear(Registro registro) throws BciAppTestException {
		Response data = new Response();
		Users userValid = repo.findUser(registro.getEmail());

		if (userValid == null) {
			try {
				String uuid = Util.getUIID();
				Users user = new Users();
				user.setId(uuid);
				user.setUsername(registro.getEmail());
				user.setPassword(encoder.encode(registro.getPassword()));
				user.setToken(JWTGenerator.createJWT(registro.getEmail(), registro.getPassword()));

				byte[] json = Util.toJson(registro.getPhones());

				Blob datos = BlobProxy.generateProxy(json);
				user.setDatos(datos);
				Users response = repo.save(user);

				data.setId(response.getId());
				data.setCreated(response.getCreated());
				data.setModified(response.getModified());
				data.setLastLogin(response.getLastLogin());
				data.setToken(response.getToken());
				data.setIsactive("activo");
				return data;
			} catch (JsonProcessingException | UnsupportedEncodingException e) {
				throw new BciAppTestException(HttpStatus.BAD_REQUEST, "El correo ya registrado");
			}
		}
		throw new BciAppTestException(HttpStatus.CONFLICT, "El correo ya registrado");
	}

}
