package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries(){
		return countryRepository.findAll();
	}
	
	@Transactional
	 public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result=countryRepository.findById(countryCode);
		if(!result.isPresent()) {
			throw new CountryNotFoundException();
		}
		return result.get();
	}
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional
	public void updateCountry(String co_code, String co_name) {
		
		Optional<Country> optionalCountry=countryRepository.findById(co_code);
		Country country=optionalCountry.get();
		country.setName(co_name);
		countryRepository.save(country);
	}
	
	@Transactional
	public void deleteCountry(String co_code) {
		countryRepository.deleteById(co_code);
	}
	
	@Transactional 
	public List<Country> findByNameContaining(String str){
		List<Country> list=countryRepository.findByNameContaining(str);
		return list;
	}
	
	@Transactional 
	public List<Country> findByNameContainingOrderByAsc(String str){
		List<Country> list=countryRepository.findByNameContainingOrderByNameAsc(str);
		return list;
	}
	
	@Transactional
	public List<Country> findByNameStartingWith(String str){
		return countryRepository.findByNameStartingWith(str);
	}
}
