package Web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Control {
	
	@Autowired
	private Inter userRepo;
	
	@Autowired
	private interf rep;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user){
		userRepo.save(user);
		return "register_success";
	}  
	@GetMapping("/registers")
	public String RegistrationForm(Model model) {
		model.addAttribute("book", new Book() );
		return "Registration";
	}
	
	@PostMapping("/res")
	public String Booking(Book book){
		rep.save(book);
		return "register_success";
	}
	
	 

}
