package javademos.rentACar.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javademos.rentACar.business.abstracts.BrandService;
import javademos.rentACar.business.requests.brand.CreateBrandRequest;
import javademos.rentACar.business.requests.brand.DeleteBrandRequest;
import javademos.rentACar.business.requests.brand.UpdateBrandRequest;
import javademos.rentACar.business.responses.brand.CreateBrandResponse;
import javademos.rentACar.business.responses.brand.DeleteBrandResponse;
import javademos.rentACar.business.responses.brand.GetBrandListItemResponse;
import javademos.rentACar.business.responses.brand.GetBrandResponse;
import javademos.rentACar.business.responses.brand.UpdateBrandResponse;
import javademos.rentACar.dataAccess.abstracts.BrandRepository;
import javademos.rentACar.entities.Brand;

@Service
public class BrandManager implements BrandService {

	private BrandRepository repository;
	private ModelMapper mapper;

	@Autowired
	public BrandManager(BrandRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<GetBrandListItemResponse> getList() {
		
		return this.repository.findAll().stream()
		.map(b -> this.mapper.map(b, GetBrandListItemResponse.class))
		.toList();
	}

	@Override
	public GetBrandResponse getById(int id) {

		Brand brand = this.repository.getReferenceById(id);
		return this.mapper.map(brand, GetBrandResponse.class);
	}

	@Override
	public CreateBrandResponse create(CreateBrandRequest request) {

		Brand brand = this.mapper.map(request, Brand.class);
		Brand created = this.repository.save(brand);
		return this.mapper.map(created, CreateBrandResponse.class);
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest request) {

		Brand brand = this.mapper.map(request, Brand.class);
		Brand updated = this.repository.save(brand);
		return this.mapper.map(updated, UpdateBrandResponse.class);
	}

	@Override
	public DeleteBrandResponse delete(DeleteBrandRequest request) {
		this.repository.deleteById(request.getId());
		return new DeleteBrandResponse(request.getId());
	}

}
