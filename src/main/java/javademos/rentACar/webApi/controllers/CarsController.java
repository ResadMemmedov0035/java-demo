package javademos.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javademos.rentACar.business.abstracts.CarService;
import javademos.rentACar.business.requests.car.CreateCarRequest;
import javademos.rentACar.business.responses.car.GetCarResponse;
import javademos.rentACar.business.responses.car.CreateCarResponse;
import javademos.rentACar.business.responses.car.GetCarListItemResponse;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

	private CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping
	@ResponseBody
	public List<GetCarListItemResponse> getList() {
		return this.carService.getList(); 
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public GetCarResponse getById(@PathVariable int id) {
		return this.carService.getById(id);
	}
	
	@PostMapping
	@ResponseBody
	public CreateCarResponse create(@RequestBody CreateCarRequest request) {
		return this.carService.create(request);
	}
}
