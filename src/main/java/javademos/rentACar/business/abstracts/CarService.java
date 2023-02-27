package javademos.rentACar.business.abstracts;

import java.util.List;

import javademos.rentACar.business.requests.car.CreateCarRequest;
import javademos.rentACar.business.requests.car.UpdateCarRequest;
import javademos.rentACar.business.responses.car.CreateCarResponse;
import javademos.rentACar.business.responses.car.GetCarListItemResponse;
import javademos.rentACar.business.responses.car.GetCarResponse;
import javademos.rentACar.business.responses.car.UpdateCarResponse;

public interface CarService {
	
	GetCarResponse getById(int id);
	List<GetCarListItemResponse> getList();
	CreateCarResponse create(CreateCarRequest request);
	UpdateCarResponse update(UpdateCarRequest request);
	void deleteById(int id);
}