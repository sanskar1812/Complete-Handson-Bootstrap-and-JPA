package com.cognizant.ormlearn.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.Application;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Transactional
	public Skill get(int id) {

		  LOGGER.info("Start");
		  return skillRepository.findById(id).get();
	  }
	  
	  @Transactional
	  public void save(Skill skill) {
		  LOGGER.info("Start");
		  skillRepository.save(skill);
		  LOGGER.info("End");

	  }
}
