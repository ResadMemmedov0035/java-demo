package javademos.rentACar.business.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {
	private int id;
	private String model;
	private int modelYear;
	private int speed;
	private String brandName;
}
