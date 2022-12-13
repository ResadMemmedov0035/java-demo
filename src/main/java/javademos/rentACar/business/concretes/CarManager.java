package javademos.rentACar.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javademos.rentACar.business.abstracts.CarService;
import javademos.rentACar.business.requests.car.CreateCarRequest;
import javademos.rentACar.business.responses.car.CreateCarResponse;
import javademos.rentACar.business.responses.car.GetCarListItemResponse;
import javademos.rentACar.business.responses.car.GetCarResponse;
import javademos.rentACar.dataAccess.abstracts.CarRepository;
import javademos.rentACar.entities.Car;

@Service
public class CarManager implements CarService {

	private CarRepository repository;
	private ModelMapper mapper;
	
	@Autowired
	public CarManager(CarRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<GetCarListItemResponse> getList() {
		
		return this.repository.findAll().stream()
		.map(c -> this.mapper.map(c, GetCarListItemResponse.class))
		.toList();
	}

	@Override
	public GetCarResponse getById(int id) {
		
		Car car = this.repository.getReferenceById(id);
		return this.mapper.map(car, GetCarResponse.class);
	}

	@Override
	public CreateCarResponse create(CreateCarRequest request) {
		
		Car car = this.mapper.map(request, Car.class);
		Car created = this.repository.save(car);
		return this.mapper.map(created, CreateCarResponse.class);
	}

}
