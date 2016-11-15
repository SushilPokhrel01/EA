package com.mum.edu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String description;
	@Enumerated(EnumType.STRING)
	
	private Status status;
	@ManyToOne
	@JoinColumn(name = "project_id")
	
	private Project project;
	@OneToMany
	@JoinColumn(name = "resource_id")
	
	private List<Resource> resources;
	@OneToMany
	@JoinColumn(name = "user_id")
	
	private List<UserRole> volunteers;
	
	public Task(){
		
	}

	public Task(String name, String description, Status status) {
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
	public void addResource(Resource resource){
		resources.add(resource);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<UserRole> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(List<UserRole> volunteers) {
		this.volunteers = volunteers;
	}
	
	
}
