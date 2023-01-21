package registration;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class Controller {
	
	private BookingInterface repository;
	public Controller(BookingInterface repository) {
		this.repository=repository;
	}

	@GetMapping("/register")
	List<Register> get(){ 
		return repository.findAll();	
		}

	@PostMapping("/register")
	Register save(@RequestBody  Register newBook){
	 return repository.save(newBook) ; }
	
	@DeleteMapping("/register/{id}")
	void delete(@PathVariable Integer id) {
		repository.deleteById(id); }
	
	@GetMapping("/register/{id}")
	Optional<Register> getid(@PathVariable Integer id) {
		return repository.findById(id); }
	
	@PutMapping("/register/{id}")
	Optional<Register> update(@PathVariable Integer id,@RequestBody Register newBook) {
		return repository.findById(id).map(employee-> {
			employee.setPhone(newBook.getPhone());
			employee.setAddress(newBook.getAddress());
			Register updatedemployee = repository.save(employee);
			return updatedemployee;
			});
		}
		
		
}
	


