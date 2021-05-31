package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	public static CountryService countryService;
	public static void main(String[] args) {
		 
		 ApplicationContext context = SpringApplication.run(Application.class, args);
		 countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		LOGGER.info("Inside main");
	}

	 private static void testGetAllCountries() {

		 LOGGER.info("Start");

		 List<Country> countries = countryService.getAllCountries();
		 

		 LOGGER.debug("countries={}", countries);

		 LOGGER.info("End");

		 }
	 
	 private static void getAllCountriesTest() {

		 LOGGER.info("Start");

			Country country;
			try {
				country = countryService.findCountryByCode("IN");
				LOGGER.debug("Country:{}", country);
			} catch (CountryNotFoundException e) {
				e.printStackTrace();
			}

			LOGGER.info("End");

		 }
	 
	 private static void testAddCountry() {
		 Country country = new Country();
		 country.setCode("KM");
		 country.setName("MEGH");
		 countryService.addCountry(country);
		 getAllCountriesTest();
	 }
	 
	 private static void testUpdateCountry() {
			countryService.updateCountry("KM","Megh");
		}
	 
	 private static void testDeleteCountry() {
			countryService.deleteCountry("KM");
		}
	 
	 
}
