package br.com.llapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.llapi.dto.ClientProductKey;
import br.com.llapi.entity.Client;
import br.com.llapi.entity.Product;
import br.com.llapi.entity.WishList;
import br.com.llapi.repository.ClientRepository;
import br.com.llapi.repository.ProductRepository;
import br.com.llapi.repository.WishListRepository;
import br.com.llapi.repository.WishListRepositoryCustom;
import br.com.llapi.resource.ProductResource;

@RestController
@RequestMapping("/api")
public class WishListController {

	@Autowired
	private WishListRepository _whishListRepository;

	@Autowired
	private ClientRepository _clientRepository;

	@Autowired
	private ProductRepository _productRepository;

	@Autowired
	ProductResource _productResource;

	@RequestMapping(value = "/client/{clientId}/whishlist", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> putInWhishList(@PathVariable(value = "clientId") long clientId) {

		List<Product> wishList = WishListRepositoryCustom.getWishList(clientId);
		
		return new ResponseEntity<List<Product>>(wishList, HttpStatus.OK);

	}

	@RequestMapping(value = "/client/{clientId}/whishlist/{prodId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> putInWhishList(@PathVariable(value = "clientId") long clientId,
			@PathVariable(value = "prodId") String prodId) {

		Optional<WishList> wishList = _whishListRepository.findById(new ClientProductKey(clientId, prodId));

		if (wishList.isPresent()) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {

			Optional<Client> client = _clientRepository.findById(clientId);

			if (client.isPresent()) {

				Optional<Product> product = _productRepository.findById(prodId);

				if (!product.isPresent()) {

					Product newProduct = _productResource.getById(prodId);

					if (newProduct != null) {

						_productRepository.save(newProduct);
					} else {

						return new ResponseEntity<>("Invalid Product.", HttpStatus.FAILED_DEPENDENCY);
					}

				}

				WishList newWishList = new WishList();
				newWishList.setId(clientId, prodId);
				_whishListRepository.save(newWishList);

				return new ResponseEntity<>(HttpStatus.OK);

			} else {

				return new ResponseEntity<>("Client not found.", HttpStatus.NOT_FOUND);
			}
		}
	}

	@RequestMapping(value = "/client/{clientId}/whishlist/{prodId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFromWhishList(@PathVariable(value = "clientId") long clientId,
			@PathVariable(value = "prodId") String prodId) {

		Optional<WishList> wishList = _whishListRepository.findById(new ClientProductKey(clientId, prodId));

		if (wishList.isPresent()) {
			_whishListRepository.delete(wishList.get());
			return new ResponseEntity<>(HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Client not found.", HttpStatus.NOT_FOUND);
		}
	}
}