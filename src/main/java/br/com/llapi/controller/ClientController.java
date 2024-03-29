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

import br.com.llapi.dto.ClientIn;
import br.com.llapi.entity.Client;
import br.com.llapi.repository.ClientRepository;

@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientRepository _clientRepository;

	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public List<Client> get() {

		return _clientRepository.findAll();
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> getById(@PathVariable(value = "id") long id) {

		Optional<Client> client = _clientRepository.findById(id);

		if (client.isPresent()) {
			
			return new ResponseEntity<Client>(client.get(), HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public Client post(@Valid @RequestBody ClientIn dtoClient) {

		Client client = new Client();
		client.setEmail(dtoClient.getEmail());
		client.setName(dtoClient.getName());
		
		return _clientRepository.save(client);
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> put(@PathVariable(value = "id") long id, @Valid @RequestBody ClientIn newClient) {

		Optional<Client> oldClient = _clientRepository.findById(id);

		if (oldClient.isPresent()) {

			Client client = oldClient.get();
			client.setName(newClient.getName());
			client.setEmail(newClient.getEmail());
			_clientRepository.save(client);
			
			return new ResponseEntity<Client>(client, HttpStatus.OK);
			
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {

		Optional<Client> client = _clientRepository.findById(id);
		if (client.isPresent()) {

			_clientRepository.delete(client.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}