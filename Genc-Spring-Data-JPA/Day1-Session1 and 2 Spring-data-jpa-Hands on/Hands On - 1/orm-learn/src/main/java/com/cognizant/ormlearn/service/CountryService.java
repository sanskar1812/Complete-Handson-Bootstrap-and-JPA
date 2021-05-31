package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;



@Service
public class CountryService {
	
	@Autowired
	private CountryRepository repository;
	
	@Transactional
	public List<Country> getAllCountries() {
		return repository.findAll();
	}

}
