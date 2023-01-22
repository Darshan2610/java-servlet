package Employee;

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

public class EmployeeController {
	
	private EmployeeInterface repository;
	public EmployeeController(EmployeeInterface repository) {
		this.repository=repository;
	}

	@GetMapping("/employee")
	List<Employee> get(){ 
		return repository.findAll();	}

	@PostMapping("/employee")
	Employee save(@RequestBody  Employee newEmployee){
	 return repository.save(newEmployee) ; }
	
	@DeleteMapping("/employee/{id}")
	void delete(@PathVariable Integer id) {
		repository.deleteById(id); }
	
	@GetMapping("/employee/{id}")
	Optional<Employee> getid(@PathVariable Integer id) {
		return repository.findById(id); }
	
	@PutMapping("/employee/{id}")
	Optional<Employee> update(@PathVariable Integer id,@RequestBody Employee newEmployee) {
		return repository.findById(id).map(employee-> {
			employee.setPhone(newEmployee.getPhone());
			employee.setPass(newEmployee.getPass());
			Employee updatedemployee = repository.save(employee);
			return updatedemployee;
			});
		}
		
		
}
	

