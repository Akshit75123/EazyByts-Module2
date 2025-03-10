package trading.stock.controller;

import trading.stock.dto.Advisor;
import trading.stock.dto.ResponseStructure;
import trading.stock.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdvisorController {
	
	@Autowired
	private AdvisorService service;

	@PostMapping("/advisor")
	public ResponseEntity<ResponseStructure<Advisor>> saveAdvisor(@RequestBody Advisor a){
		return service.saveAdvisor(a);
	}
	
	@PutMapping("/advisor")
	public ResponseEntity<ResponseStructure<Advisor>> updateAdvisor(@RequestBody Advisor a){
		return service.updateAdvisor(a);
	}
	
	@GetMapping("/advisor/{advisorID}")
	public ResponseEntity<ResponseStructure<Advisor>> findByID(@PathVariable int advisorID){
		return service.findById(advisorID);
	}

	@DeleteMapping("/advisor/{advisorID}")
	public ResponseEntity<ResponseStructure<String>> deleteAdvisor(@PathVariable int advisorID){
		return service.deleteAdvisor(advisorID);
	}
	
	@PostMapping("/advisor/login-via-email")
	public ResponseEntity<ResponseStructure<Advisor>> verifyByEmail(@RequestParam String email, @RequestParam String password){
		return service.verifyAdvisor(email, password);
	}
	
	@PostMapping("/advisor/login-via-phone")
	public ResponseEntity<ResponseStructure<Advisor>> verifyByPhone(@RequestParam long phone, @RequestParam String password){
		return service.verifyAdvisor(phone, password);
	}
	
	
}
