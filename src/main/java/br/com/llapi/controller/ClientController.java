package br.com.llapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.llapi.entity.Client;
import br.com.llapi.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController extends BaseRestController {

	@Autowired
	private ClientRepository _clientRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Client> Get() {

		return _clientRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> GetById(@PathVariable(value = "id") long id) {

		Optional<Client> client = _clientRepository.findById(id);

		if (client.isPresent()) {

			return new ResponseEntity<Client>(client.get(), HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Client Post(@Valid @RequestBody Client pessoa) {

		return _clientRepository.save(pessoa);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Client newClient) {

		Optional<Client> oldClient = _clientRepository.findById(id);

		if (oldClient.isPresent()) {

			Client client = oldClient.get();
			client.setName(newClient.getName());
			_clientRepository.save(client);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<Client> client = _clientRepository.findById(id);
		if (client.isPresent()) {

			_clientRepository.delete(client.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}