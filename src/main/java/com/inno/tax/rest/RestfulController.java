package com.inno.tax.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.inno.tax.Client_Data;
import com.inno.tax.service.Client_DataService;

@RestController
public class RestfulController {
	
	@Autowired
	Client_DataService client_DataServiceImpl;
	
	@RequestMapping(value = "/clientdata/{id}",method = RequestMethod.GET)
	public Client_Data findbyid(@PathVariable("id")int id) {	
		Client_Data cd2 = client_DataServiceImpl.findById(id);
		return cd2;

	}
	
	@RequestMapping(value = "/clientdata",method = RequestMethod.GET)
	public List<Client_Data> findall() {	
		List<Client_Data> list = client_DataServiceImpl.findAll();
		return list;

	}
	
	
	
	
	
	
//	@RequestMapping(value="/view2/{id}", method=RequestMethod.GET)
//	public @ResponseBody Person searchPerson2(@PathVariable("id")int id, Map<String,Object> model){
//		
//		log.debug("In viewPerson2, id={}", id);
//		
////		Person person = personService.getPersonById(id);
//		
//		Person person=new Person(id,"aaaa","bbbb");
//		
//		model.put("person", person);
//		
//		return person;
//	}
	
}
