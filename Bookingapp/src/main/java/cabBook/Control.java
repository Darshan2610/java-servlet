package cabBook;

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

public class Control {
	
	private Inter repository;
	public Control(Inter repository) {
		this.repository=repository; 
	}

	@GetMapping("/bookin")
	List<Book> get(){ 
		return repository.findAll();	
		}

	@PostMapping("/bookin")
	Book save(@RequestBody  Book nBook){
	 return repository.save(nBook) ; }
	
	@DeleteMapping("/bookin/{id}")
	void delete(@PathVariable Integer id) {
		repository.deleteById(id); }
	
	@GetMapping("/bookin/{id}")
	Optional<Book> getid(@PathVariable Integer id) {
		return repository.findById(id); }
	
	@PutMapping("/bookin/{id}")
	Optional<Book> update(@PathVariable Integer id,@RequestBody Book nBook) {
		return repository.findById(id).map(obj-> {
			obj.setPickup(nBook.getPickup());
			obj.setDest(nBook.getDest());
			obj.setType(nBook.getType());
			Book updatedObj = repository.save(obj);
			return updatedObj;
			});
		}
		
		
}
	


