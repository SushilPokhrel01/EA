package com.mum.edu.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mum.edu.domain.Resource;
import com.mum.edu.domain.Task;


public interface ITaskDAO extends JpaRepository<Task, Integer>{
	public Task saveAndFlush(Task arg0);
	public List<Task> findAll();
	public List<Resource> findOneById(int id);
}