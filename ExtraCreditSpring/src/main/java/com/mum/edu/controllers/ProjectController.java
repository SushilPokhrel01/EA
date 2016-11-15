package com.mum.edu.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.edu.domain.*;
import com.mum.edu.service.*;


@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value={"/"})
	public String main(Model model){
		model.addAttribute("projectList", projectService.getProjects());
		return "index";
	}
	
	@RequestMapping(value="/forwardToAddProject", method = RequestMethod.POST)
	public String open(Model model){
		Project project = new Project();
		project.setStatus(Status.COMPLETED);
		model.addAttribute("project", project);
		return "addProject";
	}
	
	@RequestMapping(value="/addProject", method=RequestMethod.POST)
	public String add(Project project, Model model){
		projectService.save(project);
		model.addAttribute("projectList", projectService.getProjects());
		return "index";
	}
	
	@RequestMapping(value="/forwardToTasks", method = RequestMethod.POST)
	public String forwardToResource(Model model, @RequestParam("projectId") int projectId){
		model.addAttribute("taskList",projectService.getTasks(projectId) );
		return "tasks";
	}
}