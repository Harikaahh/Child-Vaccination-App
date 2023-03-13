package com.capg.ChildVaccination.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ChildVaccination.Dto.ParentDto;
import com.capg.ChildVaccination.Entity.Parent;
import com.capg.ChildVaccination.Service.ParentService;


/* 
 * Author : Kanithi Pooja Harika
 * Creation Date : 20-02-2023
 * Module : Parent
 * Description : This controller methods handles HTTP requests from client(UI)
 * and sends response by returning data from the database back to the UI.
 */ 


@RestController
@RequestMapping("/parent")
@CrossOrigin("http://localhost:3000")
public class ParentController {
	
	@Autowired
	ParentService parentService;
	private static Logger logger=LogManager.getLogger();
	
	@PostMapping("/addParent")
	/* @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.*/
	
	public ResponseEntity<Parent> addParent(@RequestBody ParentDto parent) {
		logger.info("posting parent details");
		Parent p1 = parentService.addParent(parent);
		logger.info("Parent posted");
		return new ResponseEntity<>(p1,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateParent/{id}")
	/*@PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
	** @RequestBody: It is used to bind HTTP request body with a domain object in
	* method parameter or return type*/
	
	public ResponseEntity<Parent> updateParent(@PathVariable("id")int id , @RequestBody ParentDto parent){
		logger.info("posting parent details");
		Parent p1 = parentService.updateParent(id,parent);
		logger.info("Parent posted");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteParent/{id}")
	/*@DeleteMapping : It is used to delete the resource and for mapping HTTP DELETE requests onto
	* specific handler methods.
	*/
	public ResponseEntity<Parent> deleteParent(@PathVariable("id")int id){
		logger.info("deleting parent details");
		Parent p1 = parentService.delParent(id);
		logger.info("Parent deleted");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@GetMapping("/viewParent/{id}")
	/* @GetMapping: It is used to handle the HTTP GET requests matched with the given 
	 * URI expression.*/
	
	public ResponseEntity<Parent> viewParent(@PathVariable("id")int id){
		logger.info("view parent details");
		Parent p1 = parentService.viewParent(id);
		logger.info("Parent details recieved");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	@GetMapping("/viewAllParent")
	/* @GetMapping: It is used to handle the HTTP GET requests matched with the given 
	 * URI expression.*/
	public ResponseEntity<List<Parent>> viewAllParent(){
		logger.info("getting all parent details");
		List<Parent> p1 = parentService.viewAllParent();
		logger.info("Parent details recieved");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	
	@GetMapping("/getParentByEmail")
	/* @GetMapping: It is used to handle the HTTP GET requests matched with the given 
	 * URI expression.*/
	public ResponseEntity<Parent> getParentByEmail(String email){
		Parent p1 = parentService.getParentByEmail(email);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@PutMapping("/updateParentByEmail/{email}")
	/*@PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
	** @RequestBody: It is used to bind HTTP request body with a domain object in
	* method parameter or return type*/
	public ResponseEntity<Parent> updateParentByEmail(@PathVariable("email")String email,@RequestBody ParentDto parent){
		Parent p1 = parentService.updateParentByEmail(email,parent);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@GetMapping("/getParentByEmail/{email}")
	/* @GetMapping: It is used to handle the HTTP GET requests matched with the given 
	 * URI expression.*/
	public ResponseEntity<Parent> viewParentByEmail(@PathVariable String email){
		Parent p1 = parentService.viewParentByEmail(email);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@GetMapping("/pagingAndSortingParent/{pageNumber}/{pageSize}/{sortProperty}")
	/* @GetMapping: It is used to handle the HTTP GET requests matched with the given 
	 * URI expression.*/
    public Page<Parent> parentPagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return parentService.getParentPagination(pageNumber, pageSize, sortProperty);
    }
	
	@PutMapping("/updatePassword/{email}")
	public ResponseEntity<Parent> updatePassword(@PathVariable("email")String email,@RequestParam("password")String password){
		Parent p1 = parentService.updatePasswordByEmail(email,password);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}


}
