package javademos.rentACar.business.requests.car;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
	@JsonIgnore
	private int id;
	private String model;	
	private int modelYear;	
	private int speed;	
	private int brandId;
}
