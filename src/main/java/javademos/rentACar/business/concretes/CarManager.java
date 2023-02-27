package javademos.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javademos.rentACar.business.abstracts.CarService;
import javademos.rentACar.business.requests.car.CreateCarRequest;
import javademos.rentACar.business.requests.car.UpdateCarRequest;
import javademos.rentACar.business.responses.car.CreateCarResponse;
import javademos.rentACar.business.responses.car.GetCarListItemResponse;
import javademos.rentACar.business.responses.car.GetCarResponse;
import javademos.rentACar.business.responses.car.UpdateCarResponse;
import javademos.rentACar.core.utilities.mappers.ModelMapperService;
import javademos.rentACar.dataAccess.abstracts.CarRepository;
import javademos.rentACar.entities.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	private CarRepository repository;
	private ModelMapperService mapper;

	@Override
	public GetCarResponse getById(int id) {
		
		Car car = this.repository.findById(id).orElseThrow();
		return this.mapper.forResponse().map(car, GetCarResponse.class);
	}
	
	@Override
	public List<GetCarListItemResponse> getList() {
		
		return this.repository.findAll().stream()
		.map(c -> this.mapper.forResponse().map(c, GetCarListItemResponse.class))
		.toList();
	}

	@Override
	public CreateCarResponse create(CreateCarRequest request) {
		
		Car car = this.mapper.forRequest().map(request, Car.class);
		Car created = this.repository.save(car);
		return this.mapper.forResponse().map(created, CreateCarResponse.class);
	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest request) {

		Car car = this.mapper.forRequest().map(request, Car.class);
		Car updated = this.repository.save(car);
		return this.mapper.forResponse().map(updated, UpdateCarResponse.class);
	}

	@Override
	public void deleteById(int id) {

		this.repository.deleteById(id);		
	}
}
