package com.mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mum.edu.dao.IResourceDAO;
import com.mum.edu.domain.Resource;

public class ResourceService {
	@Autowired
	private IResourceDAO resourceDAO;
	
	public void save(Resource resource){
		resourceDAO.saveAndFlush(resource);
	}
	
	public List<Resource> getResource(){
		return resourceDAO.findAll();
	}
}
