package com.mum.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.edu.domain.Task;
import com.mum.edu.service.ProjectService;
import com.mum.edu.service.TaskService;



@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/tasks", method=RequestMethod.POST)
	public String saveTask(Model model, Task task, @RequestParam("projectId") int projectId){
		task.setProject(projectService.getProject(projectId));;
		taskService.save(task);
		model.addAttribute("taskList", taskService.getTasks(projectId));
		model.addAttribute("task", new Task());
		return "tasks";
	}
	
	@RequestMapping(value="/backToHome", method = RequestMethod.POST)
	public String returnToIndexPage(Model model){
		model.addAttribute("projectList", projectService.getProjects());
		return "index";
	}
	
	@RequestMapping(value="/forwardToResource", method = RequestMethod.POST)
	public String forwardToResource(Model model, @RequestParam("taskId") int taskId){
		model.addAttribute("resourceList",taskService.getResources(taskId) );
		return "resources";
	}
}