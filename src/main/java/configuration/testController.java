package configuration;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Controller: Indicates that this class is a Spring MVC controller. 
//It is used to handle HTTP requests and return the appropriate response.
public class testController {
	
	@GetMapping("/test")
	//@GetMapping("/test"): Maps HTTP GET requests to the /test URL to this method.
	//This means when a GET request is made to /test, this method will be invoked.
	
	public String m1(Model model) throws Exception {
//public String m1(Model model): Defines a method named m1 that returns a String and takes a Model object as a parameter.
		//The Model object is used to pass data to the view.
		
		JDBC_Connectivity c =new JDBC_Connectivity();
		//JDBC_Connectivity jdbc = new JDBC_Connectivity();: Creates an instance of the JDBC_Connectivity class. 
		//This class is assumed to handle database connectivity and operations.
		
		List<testDao> students =c.get_Connection();
		//List<testDao> students = jdbc.get_Connection();: Calls the get_Connection method 
		//of the JDBC_Connectivity instance to retrieve a list of testDao objects from the database.
		
		model.addAttribute("students",students);
		//model.addAttribute("students", students);: Adds the students list to the model with the name "students".
		//This attribute will be available in the view (e.g., a JSP page) to render the list of students.
		return "home";
	}

	@GetMapping("/test2")
	public String m2() {
		return "home2";
	}
	@GetMapping("/test3")
	@ResponseBody
	public String m3() {
		return "home";
	}


}
