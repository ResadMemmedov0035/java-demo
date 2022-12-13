package javademos.rentACar.business.abstracts;

import java.util.List;

import javademos.rentACar.business.requests.car.CreateCarRequest;
import javademos.rentACar.business.responses.car.CreateCarResponse;
import javademos.rentACar.business.responses.car.GetCarListItemResponse;
import javademos.rentACar.business.responses.car.GetCarResponse;

public interface CarService {
	
	List<GetCarListItemResponse> getList();
	GetCarResponse getById(int id);
	CreateCarResponse create(CreateCarRequest request);
}