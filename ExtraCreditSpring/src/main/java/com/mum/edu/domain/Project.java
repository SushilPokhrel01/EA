package com.mum.edu.domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String description;
	
	private String location;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@OneToMany(mappedBy = "project")
	@JoinColumn(name = "task_id")
	List<Task> tasks;
	
	@Enumerated(EnumType.STRING)
	
	private Status status;
	
	@OneToMany
	@JoinColumn(name = "project")
	List<Beneficiary> beneficiaries;
	
	@Lob
	private byte[] photo;
	
	private User user;

	public Project() {

	}

	public Project(String name, String description, String location, Date startDate, Date endDate, Status status,
			List<Beneficiary> beneficiaries, User user) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.beneficiaries = beneficiaries;
		this.user = user;
	}

	public void addTask(Task task) {
		tasks.add(task);
		task.setProject(this);
	}

	public void removeTask(Task task) {
		tasks.remove(task);
		task.setProject(null);
	}

	public void addBeneficiaries(Beneficiary beneficiary) {
		beneficiaries.add(beneficiary);
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
