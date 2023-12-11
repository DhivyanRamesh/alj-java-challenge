package jp.co.axa.apidemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties
public class EmployeeRequest {
	
	private Long id;
	private String name;
	private Integer salary;
	private String department;

}
