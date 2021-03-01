package com.huynhbaoloc.demo.converter;

import org.springframework.stereotype.Component;

import com.huynhbaoloc.demo.dto.NewDTO;
import com.huynhbaoloc.demo.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setContext(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO newDTO = new NewDTO();
		if(newDTO.getId() == null) {
			newDTO.setId(entity.getId());
		}
		newDTO.setTitle(entity.getTitle());
		newDTO.setContent(entity.getContent());
		newDTO.setShortDescription(entity.getShortDescription());
		newDTO.setThumbnail(entity.getThumbnail());
		newDTO.setCategoryCode(entity.getCategory().getCode());
		return newDTO;
	}
	
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setContext(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}

//	public NewEntity toEntity(NewDTO newDTO, Optional<NewEntity> entity) {
//		entity.get().setTitle(newDTO.getTitle());
//		entity.get().setContext(newDTO.getContent());
//		entity.get().setShortDescription(newDTO.getShortDescription());
//		entity.get().setThumbnail(newDTO.getThumbnail());
//		return entity.get();
//	}
}	
