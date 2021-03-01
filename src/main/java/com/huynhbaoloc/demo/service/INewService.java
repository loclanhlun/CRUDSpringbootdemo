package com.huynhbaoloc.demo.service;

import java.util.List;

import com.huynhbaoloc.demo.dto.NewDTO;

public interface INewService {
	List<NewDTO> getListNew(String keyword);
	NewDTO save(NewDTO newDTO);
	NewDTO getById(Long id);
	void delete(Long id);
//	NewDTO update(NewDTO newDTO);
}
