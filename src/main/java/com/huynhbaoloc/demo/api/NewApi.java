package com.huynhbaoloc.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huynhbaoloc.demo.dto.NewDTO;
import com.huynhbaoloc.demo.service.INewService;

@RestController
@CrossOrigin
public class NewApi {
	
	@Autowired
	private INewService newService;
	
	@GetMapping(value = "/new")
	List<NewDTO> listNews(){
		return newService.getListNew();
	}
	
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}
	
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") Long id) {
		return newService.save(model);
	}
	
}
