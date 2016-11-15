package com.mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.dao.ITaskDAO;
import com.mum.edu.domain.Resource;
import com.mum.edu.domain.Task;


@Service
//@Transactional(propagation=Propagation.REQUIRED)
public class TaskService {
	@Autowired
	private ITaskDAO taskDAO;
	
	public void save(Task task){
		taskDAO.saveAndFlush(task);
	}
	
	public List<Task> getTask(){
		return taskDAO.findAll();
	}
	
	public List<Resource> getResources(int taskId){
		return taskDAO.findOneById(taskId);
	}

	public Object getTasks(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
