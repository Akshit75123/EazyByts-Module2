package trading.stock.service;

import java.util.Optional;
import trading.stock.dao.AdvisorDao;
import trading.stock.dto.Advisor;
import trading.stock.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AdvisorService {
	@Autowired
	private AdvisorDao aDao;

	
	//POST
	public ResponseEntity<ResponseStructure<Advisor>> saveAdvisor(Advisor a){
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		structure.setData(aDao.saveAdvisor(a));
		structure.setMessage("Advisor Account Created Succesfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.CREATED);
	}
	
	//PUT 
	public ResponseEntity<ResponseStructure<Advisor>> updateAdvisor(Advisor a){
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		structure.setData(aDao.saveAdvisor(a));
		structure.setMessage("Advisor Details Updated Succesfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.ACCEPTED);
	}
	
	//GET
	public ResponseEntity<ResponseStructure<Advisor>> findById(int advisorID){
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		Optional<Advisor> recAdvisor = aDao.findAdvisorById(advisorID);
		
		if(recAdvisor.isPresent()) {
			structure.setMessage("Advisor Found Successfully");
			structure.setData(recAdvisor.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.OK);
		}
		else {
			structure.setData(null);
			structure.setMessage("Advisor Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	//DELETE - /delete/{advisor_id}
	public ResponseEntity<ResponseStructure<String>> deleteAdvisor(int advisorID){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Advisor> recAdvisor = aDao.findAdvisorById(advisorID);
		if(recAdvisor.isPresent()) {
			aDao.deleteAdvisor(advisorID);
			structure.setMessage("Task Executed");
			structure.setData("Advisor Deleted Succesfully");		
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		else {
			structure.setData(null);
			structure.setMessage("Advisor Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
	} 
	
	//POST -  verify/Email
	public ResponseEntity<ResponseStructure<Advisor>> verifyAdvisor(String email, String password){
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		Optional<Advisor> recAdvisor = aDao.verifyAdvisor(email, password);
		if(recAdvisor.isPresent()) {
			structure.setData(recAdvisor.get());
			structure.setMessage("Advisor verified successfully with Email and Password");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.OK);
		}
		else {
			structure.setData(null);
			structure.setMessage("Entered Credentials are wrong, please check your Email or Password once again");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	//POST -  verify/Phone
	public ResponseEntity<ResponseStructure<Advisor>> verifyAdvisor(long phone, String password){
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		Optional<Advisor> recAdvisor = aDao.verifyAdvisor(phone, password);
		if(recAdvisor.isPresent()) {
			structure.setData(recAdvisor.get());
			structure.setMessage("Advisor verified successfully with Phone and Password");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.OK);
		}
		else {
			structure.setData(null);
			structure.setMessage("Entered Credentials are wrong, Kindly check your Phone or Password once again");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.NOT_FOUND);
		}
	}
}
