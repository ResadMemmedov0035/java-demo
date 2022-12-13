package javademos.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javademos.rentACar.business.abstracts.BrandService;
import javademos.rentACar.business.requests.brand.CreateBrandRequest;
import javademos.rentACar.business.requests.brand.DeleteBrandRequest;
import javademos.rentACar.business.requests.brand.UpdateBrandRequest;
import javademos.rentACar.business.responses.brand.CreateBrandResponse;
import javademos.rentACar.business.responses.brand.DeleteBrandResponse;
import javademos.rentACar.business.responses.brand.GetBrandListItemResponse;
import javademos.rentACar.business.responses.brand.GetBrandResponse;
import javademos.rentACar.business.responses.brand.UpdateBrandResponse;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping
	@ResponseBody
	public List<GetBrandListItemResponse> getList() {
		return this.brandService.getList();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public GetBrandResponse getById(@PathVariable int id) {
		return this.brandService.getById(id);
	}
	
	@PostMapping
	@ResponseBody
	public CreateBrandResponse create(@RequestBody CreateBrandRequest request) {
		return this.brandService.create(request);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public UpdateBrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequest request) {
		request.setId(id);
		return this.brandService.update(request);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public DeleteBrandResponse delete(@PathVariable int id) {
		return this.brandService.delete(new DeleteBrandRequest(id));
	}
}



