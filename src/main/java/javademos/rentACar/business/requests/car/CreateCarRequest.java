package javademos.rentACar.business.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
	private String model;	
	private int modelYear;	
	private int speed;	
	private int brandId;
}
