package com.huynhbaoloc.demo.service;

import java.util.List;

import com.huynhbaoloc.demo.dto.NewDTO;

public interface INewService {
	List<NewDTO> getListNew();
	NewDTO save(NewDTO newDTO);
//	NewDTO update(NewDTO newDTO);
}
