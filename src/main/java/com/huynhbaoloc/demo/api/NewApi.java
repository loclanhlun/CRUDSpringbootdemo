package com.huynhbaoloc.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.huynhbaoloc.demo.dto.NewDTO;
import com.huynhbaoloc.demo.entity.NewEntity;
import com.huynhbaoloc.demo.service.INewService;

@RestController
@CrossOrigin
public class NewApi {
	
	@Autowired
	private INewService newService;
	
//	@GetMapping(value = "/new")
//	List<NewDTO> listNews(){
//		return newService.getListNew();
//	}
	
	@GetMapping(value = "/new/search")
	public ResponseEntity<List<NewDTO>> searchNews(@RequestParam(name = "keyword", required = false) String keyword ){
		List<NewDTO> list = newService.getListNew(keyword);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/new/{id}")
	public ResponseEntity<NewDTO> getById(@PathVariable("id") Long id) {
		NewDTO newdto = newService.getById(id);
		return ResponseEntity.ok(newdto);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<NewDTO> createNew(@RequestBody NewDTO model) {
		NewDTO newDTO = newService.save(model);
		return ResponseEntity.ok(newDTO);
	}
	
	@PutMapping(value = "/new")
	public ResponseEntity<NewDTO> updateNew(@RequestBody NewDTO model) {
		NewDTO newDTO = newService.save(model);
		return ResponseEntity.ok(newDTO);
	}
	
	@DeleteMapping(value = "/new/{id}")
	public void deleteNew(@PathVariable("id") Long id) {
		newService.delete(id);
	}
	
}
