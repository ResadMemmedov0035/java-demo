package javademos.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javademos.rentACar.business.abstracts.BrandService;
import javademos.rentACar.business.requests.brand.CreateBrandRequest;
import javademos.rentACar.business.requests.brand.UpdateBrandRequest;
import javademos.rentACar.business.responses.brand.CreateBrandResponse;
import javademos.rentACar.business.responses.brand.GetBrandListItemResponse;
import javademos.rentACar.business.responses.brand.GetBrandResponse;
import javademos.rentACar.business.responses.brand.UpdateBrandResponse;
import javademos.rentACar.core.utilities.mappers.ModelMapperService;
import javademos.rentACar.dataAccess.abstracts.BrandRepository;
import javademos.rentACar.entities.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository repository;
	private ModelMapperService mapper;

	@Override
	public GetBrandResponse getById(int id) {

		Brand brand = this.repository.findById(id).orElseThrow();
		return this.mapper.forResponse().map(brand, GetBrandResponse.class);
	}
	
	@Override
	public List<GetBrandListItemResponse> getList() {
		
		return this.repository.findAll().stream()
				.map(b -> this.mapper.forResponse().map(b, GetBrandListItemResponse.class))
				.toList();
	}

	@Override
	public CreateBrandResponse create(CreateBrandRequest request) {

		Brand brand = this.mapper.forRequest().map(request, Brand.class);
		Brand created = this.repository.save(brand);
		return this.mapper.forResponse().map(created, CreateBrandResponse.class);
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest request) {

		Brand brand = this.mapper.forRequest().map(request, Brand.class);
		Brand updated = this.repository.save(brand);
		return this.mapper.forResponse().map(updated, UpdateBrandResponse.class);
	}

	@Override
	public void deleteById(int id) {
		
		this.repository.deleteById(id);
	}

}
