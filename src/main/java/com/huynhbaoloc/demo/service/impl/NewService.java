package com.huynhbaoloc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynhbaoloc.demo.converter.NewConverter;
import com.huynhbaoloc.demo.dto.NewDTO;
import com.huynhbaoloc.demo.entity.CategoryEntity;
import com.huynhbaoloc.demo.entity.NewEntity;
import com.huynhbaoloc.demo.repository.CategoryRepository;
import com.huynhbaoloc.demo.repository.NewRepository;
import com.huynhbaoloc.demo.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public List<NewDTO> getListNew() {
		List<NewDTO> list = new ArrayList<NewDTO>();
		List<NewEntity> listEntity = newRepository.findAll();
		for(NewEntity item : listEntity) {
			NewDTO newDTO = new NewDTO();
			newDTO.setId(item.getId());
			newDTO.setTitle(item.getTitle());
			newDTO.setContent(item.getContent());
			newDTO.setThumbnail(item.getThumbnail());
			newDTO.setShortDescription(item.getShortDescription());	
			newDTO.setCategoryCode(item.getCategory().getCode());
			list.add(newDTO);
		}
		return  list;
	}

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			Optional<NewEntity> oldNewEntity = newRepository.findById(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO,  oldNewEntity);
			
		}else if(newDTO.getId() == null) {
			newEntity = newConverter.toEntity(newDTO);
			
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	

	/*@Override
	public NewDTO update(NewDTO newDTO) {
		NewEntity oldNewEntity = newRepository.getOne(newDTO.getId());
		NewEntity newEntity = newConverter.toEntity(newDTO,  oldNewEntity);
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}*/

}
