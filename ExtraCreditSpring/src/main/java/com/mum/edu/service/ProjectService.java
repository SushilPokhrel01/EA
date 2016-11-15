package com.mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.dao.IProjectDAO;
import com.mum.edu.domain.Project;
import com.mum.edu.domain.Task;


@Service
/*@Transactional(propagation=Propagation.REQUIRED)*/
public class ProjectService {

	@Autowired
	private IProjectDAO projectDAO;
	
	public void save(Project project){
		projectDAO.saveAndFlush(project);
	}
	
	public List<Project> getProjects(){
		return projectDAO.findAll();
	}
	public Project getProject(int projectId){
		return projectDAO.findOneById(projectId);
	}
	
	public List<Task> getTasks(int projectId){
		return projectDAO.findOneById(projectId).getTasks();
	}
}
