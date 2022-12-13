package javademos.rentACar.business.abstracts;

import java.util.List;

import javademos.rentACar.business.requests.brand.CreateBrandRequest;
import javademos.rentACar.business.requests.brand.DeleteBrandRequest;
import javademos.rentACar.business.requests.brand.UpdateBrandRequest;
import javademos.rentACar.business.responses.brand.CreateBrandResponse;
import javademos.rentACar.business.responses.brand.DeleteBrandResponse;
import javademos.rentACar.business.responses.brand.GetBrandListItemResponse;
import javademos.rentACar.business.responses.brand.GetBrandResponse;
import javademos.rentACar.business.responses.brand.UpdateBrandResponse;

public interface BrandService {
	
	List<GetBrandListItemResponse> getList();
	GetBrandResponse getById(int id);
	CreateBrandResponse create(CreateBrandRequest request);
	UpdateBrandResponse update(UpdateBrandRequest request);
	DeleteBrandResponse delete(DeleteBrandRequest request);
}
