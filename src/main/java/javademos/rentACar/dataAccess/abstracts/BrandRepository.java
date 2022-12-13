package javademos.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javademos.rentACar.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
