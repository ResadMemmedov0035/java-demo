package javademos.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javademos.rentACar.business.abstracts.BrandService;
import javademos.rentACar.business.requests.brand.CreateBrandRequest;
import javademos.rentACar.business.requests.brand.UpdateBrandRequest;
import javademos.rentACar.business.responses.brand.CreateBrandResponse;
import javademos.rentACar.business.responses.brand.GetBrandListItemResponse;
import javademos.rentACar.business.responses.brand.GetBrandResponse;
import javademos.rentACar.business.responses.brand.UpdateBrandResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

	private BrandService brandService;
	
	@GetMapping("/{id}")
	public GetBrandResponse getById(@PathVariable int id) {
		return this.brandService.getById(id);
	}
	
	@GetMapping
	public List<GetBrandListItemResponse> getList() {
		return this.brandService.getList();
	}	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CreateBrandResponse create(@RequestBody CreateBrandRequest request) {
		return this.brandService.create(request);
	}
	
	@PutMapping("/{id}")
	public UpdateBrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequest request) {
		request.setId(id);
		return this.brandService.update(request);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.deleteById(id);
	}
}



