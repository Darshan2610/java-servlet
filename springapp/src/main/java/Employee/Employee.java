package Employee;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity


public class Employee {
	

	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
	private String name,email,phone,pass;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name,String email,String phone,String pass) {
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.pass = pass;
	}
	
//	<--                                                          ------- id method ---------------        ->
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	<--                                                          ------- name method ---------------        ->
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
//																		<-----------method of Email------------->
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//																				<-----------method of phone------------->
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
//	<--                                                          ------- password method ---------------        ->
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
