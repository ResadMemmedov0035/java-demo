package javademos.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javademos.rentACar.business.abstracts.CarService;
import javademos.rentACar.business.requests.car.CreateCarRequest;
import javademos.rentACar.business.requests.car.UpdateCarRequest;
import javademos.rentACar.business.responses.car.CreateCarResponse;
import javademos.rentACar.business.responses.car.GetCarListItemResponse;
import javademos.rentACar.business.responses.car.GetCarResponse;
import javademos.rentACar.business.responses.car.UpdateCarResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {

	private CarService carService;

	@GetMapping("/{id}")
	public GetCarResponse getById(@PathVariable int id) {
		return this.carService.getById(id);
	}
	
	@GetMapping
	public List<GetCarListItemResponse> getList() {
		return this.carService.getList(); 
	}
	
	@PostMapping
	public CreateCarResponse create(@RequestBody CreateCarRequest request) {
		return this.carService.create(request);
	}
	
	@PutMapping("/{id}")
	public UpdateCarResponse update(@PathVariable int id, @RequestBody UpdateCarRequest request) {
		request.setId(id);
		return this.carService.update(request);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.carService.deleteById(id);
	}
}
