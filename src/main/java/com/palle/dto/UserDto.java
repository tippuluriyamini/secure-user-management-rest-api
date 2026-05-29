package com.palle.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName ="build")
public class UserDto {
	
	@NotNull(message="Name cannot be null")
	private String name;
	@Email(message ="mail can not be without @ symbol")
	private String email;
	@Pattern(regexp="^\\d{10}$")
	private String mobile_no;
	@Min(18)
	@Max(60)
	private int age;
	@NotEmpty(message = "Nationality cannot be empty")
	private String national;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getMobile_no() {
//		return mobile_no;
//	}
//	public void setMobile_no(String mobile_no) {
//		this.mobile_no = mobile_no;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getNational() {
//		return national;
//	}
//	public void setNational(String national) {
//		this.national = national;
//	}
//	
	

}
