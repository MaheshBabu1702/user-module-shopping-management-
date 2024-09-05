package in.ac.jssate.usermodule;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class usercontroller {
	
	@Autowired
	private userservice service;

//RetriveAll
@GetMapping("/user")
public List<user> list(){
	return service.listAll();
}
//RetriveById
	@GetMapping("/users/{id}")
	public ResponseEntity<user> get(@PathVariable Integer id){
		try {
			user user = service.get(id);
			return new ResponseEntity<user>(user,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<user>(HttpStatus.NOT_FOUND);
		}
	}
	//Create
	@PostMapping("/users")
	public void save(@RequestBody user user) {
		service.save(user);
	}
	
	//Update
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody user user){
		try {
			user existuser = service.get(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
		
