package com.mum.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mum.edu.domain.Resource;
import com.mum.edu.domain.Task;



public interface IResourceDAO extends JpaRepository<Resource, Integer>{
	public Resource saveAndFlush(Resource arg0);
	List<Resource> findAll();
	public List<Task> findByTask_Id(int id);
}