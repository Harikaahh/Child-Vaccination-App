package com.capg.ChildVaccination;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.ChildVaccination.Entity.Parent;
import com.capg.ChildVaccination.Repository.ParentRepository;
import com.capg.ChildVaccination.ServiceImpl.ParentServiceImpl;

@ExtendWith(SpringExtension.class)
public class ParentServiceMockitoTest {

	
	@InjectMocks
	ParentServiceImpl parentService;
	
	@MockBean
	ParentRepository ParentRepo;
	
	@BeforeEach
	void init(){
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testgetParentById() {
		
		Parent parent=new Parent();
		
		parent.setParentid(7);
	parent.setUserName("vijaya");
		
		Mockito.when(ParentRepo.findById(7)).thenReturn(Optional.of(parent));
		
		Parent parent1= parentService.viewParent(7);
		assertEquals(7,parent.getParentid());
		assertEquals("vijaya",parent1.getUserName());
	
	}

@Test
public void testDelParent() throws Exception {
	// Step 2 
	Parent parent = new Parent();
	parent.setUserId(1); parent.setUserName("John");
	// Step 3
	when(ParentRepo.findById(1)).thenReturn(Optional.of(parent)); 
	// Step 4
	Parent deletedParent = parentService.delParent(1); 
	// Step 5
	verify(ParentRepo, times(1)).findById(1); verify(ParentRepo, times(1)).deleteById(1); 
	// Step 6
	assertEquals(deletedParent, parent); }

@Test
public void testViewAllParent() {
  // Arrange
  Parent parent1 = new Parent();
  Parent parent2 = new Parent();
  List<Parent> parents = Arrays.asList(parent1, parent2);
  Mockito.when(ParentRepo.findAll()).thenReturn(parents);

}
}






