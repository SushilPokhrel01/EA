package com.mum.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.edu.domain.Resource;
import com.mum.edu.service.ProjectService;
import com.mum.edu.service.ResourceService;


@Controller
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ProjectService projectService;
	
	
	@RequestMapping(value="/addresource", method=RequestMethod.POST)
	public String saveResource(Model model, Resource resource, @RequestParam("taskId") int taskId){	
		resourceService.save(resource, taskId);
		model.addAttribute("resourceList", resourceService.getResource(taskId));
		model.addAttribute("resource", new Resource());
		return "resources";
	}
	
	@RequestMapping(value="/backToIndex", method=RequestMethod.POST)
	public String open( Model model){
		model.addAttribute("projectList", projectService.getProjects());
		return "index";
	}
}
