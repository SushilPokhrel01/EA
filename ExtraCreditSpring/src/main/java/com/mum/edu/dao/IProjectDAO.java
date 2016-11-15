package com.mum.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mum.edu.domain.*;




public interface IProjectDAO extends JpaRepository<Project, Integer> {

	public Project saveAndFlush(Project arg0);

	public List<Project> findAll();
	
	public Project findOneById(int id);
}