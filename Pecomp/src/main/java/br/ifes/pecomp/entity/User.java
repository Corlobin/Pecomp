package br.ifes.pecomp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TB_USUARIO")
public class User extends AbstractEntity implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="TB_USU_FIRSTNAME")
	private String firstname;
     
	@Column(name="TB_USU_LASTNAME")
    private String lastname; 

	@Column(name="TB_USU_IDADE")
	private Integer age;
	
	@Column(name="TB_USU_RUA")
	private String street;
	
	@Column(name="TB_USU_CIDADE")
	private String city;
	
	@Column(name="TB_USU_COD_POSTAL")
	private String postalCode;
	
	@Column(name="TB_USU_INFO")
	private String info;
	
	@Column(name="TB_USU_EMAIL")
	private String email;
	
	@Column(name="TB_USU_TELEFONE")
	private String phone;
	
	
	
	public User(String firstname, String lastname, Integer age, String street, String city, String postalCode,
			String info, String email, String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.info = info;
		this.email = email;
		this.phone = phone;
	}

	
	public String getFirstname() {
	   return firstname;
	}
	
	public void setFirstname(String firstname) {
	   this.firstname = firstname;
	}
	
	public String getLastname() {
	   return lastname;
	}
	
	public void setLastname(String lastname) {
	   this.lastname = lastname;
	}
	
	public Integer getAge() {
	   return age;
	}
	
	public void setAge(Integer age) {
	   this.age = age;
	}
	
	public String getStreet() {
	   return street;
	}
	
	public void setStreet(String street) {
	   this.street = street;
	}
	
	public String getCity() {
	   return city;
	}
	
	public void setCity(String city) {
	   this.city = city;
	}
	
	public String getPostalCode() {
	   return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
	   this.postalCode = postalCode;
	}
	
	public String getInfo() {
	   return info;
	}
	
	public void setInfo(String info) {
	   this.info = info;
	}
	
	public String getEmail() {
	   return email;
	}
	
	public void setEmail(String email) {
	   this.email = email;
	}
	
	public String getPhone() {
	   return phone;
	}
	
	public void setPhone(String phone) {
	   this.phone = phone;
	}
}
