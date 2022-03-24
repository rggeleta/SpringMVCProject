package dmacc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Student {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String phone;
	private String major;
	@Autowired
	private CampusAddress campusAddress;
	

	public Student() {
		super();
		this.major = "spouse";
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Student(String name) {

	}

	public Student(String name, String phone, String major) {		
	}

	public Student(long id, String name, String phone, String major) {

	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", major=" + major + ", campusAddress="
				+ campusAddress + "]";
	}




	public void setCampusAddress(CampusAddress ca) {
		// TODO Auto-generated method stub
		
	}

}
	