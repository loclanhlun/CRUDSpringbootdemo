package com.huynhbaoloc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public List<NewDTO> getListNew(String keyword) {
		List<NewDTO> list = new ArrayList<NewDTO>();
		List<NewEntity> listEntity = newRepository.findAll();
		if (keyword == null) {
			for (NewEntity item : listEntity) {
				list.add(newConverter.toDTO(item));
			}
		} else {
			for (NewEntity entity : listEntity) {
				if (entity.getTitle().contains(keyword)) {
					list.add(newConverter.toDTO(entity));
				}
			}
		}
		return list;
	}

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findById(newDTO.getId()).orElse(null);
			if (oldNewEntity == null) {
				return null;
			}
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);

		} else if (newDTO.getId() == null) {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public NewDTO getById(Long id) {
		NewEntity entity = newRepository.findById(id).orElse(null);
		if (entity == null) {
			return null;
		}
		return newConverter.toDTO(entity);
	}

	@Override
	public void delete(Long id) {
		newRepository.deleteById(id);
	}

	/*
	 * @Override public NewDTO update(NewDTO newDTO) { NewEntity oldNewEntity =
	 * newRepository.getOne(newDTO.getId()); NewEntity newEntity =
	 * newConverter.toEntity(newDTO, oldNewEntity); CategoryEntity categoryEntity =
	 * categoryRepository.findOneByCode(newDTO.getCategoryCode());
	 * newEntity.setCategory(categoryEntity); newEntity =
	 * newRepository.save(newEntity); return newConverter.toDTO(newEntity); }
	 */

}
