package cabBook;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Book {
	
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
	private String name,phone,pickup,dest,type;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String name,String phone,String pickup,String dest,String type) {
		this.name=name;
		this.phone=phone;
		this.pickup=pickup;
		this.dest=dest;
		this.type=type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

