package com.capg.ChildVaccination;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.ServiceImpl.VaccineServiceImpl;
@SpringBootTest
 class VaccineServiceTest {
	
	  
	@Autowired
	VaccineServiceImpl  VaccineService;
	@Test
	void contextLoads() {
		
	}
	
//	
//	@Test
//	void deleteVaccinebyidTest() {
//		Vaccine vaccine=VaccineService.deleteVaccinebyid(2);
//		assertEquals("bcg",vaccine.getVaccineName());
//	}
//	
	
	@Test
	void viewAllVaccinesTest() {
		List<Vaccine> vaccine1 = VaccineService.viewAllVaccines();
		assertEquals(7,vaccine1.size());
	}
	}
