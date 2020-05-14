package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		// LOGGER.info("Inside main");

	}

	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}

	private static void getAllCountriesTest() {

		try {
			LOGGER.info("Start");

			Country country;
			country = countryService.findCountryByCode("IZ");
			LOGGER.debug("Country:{}", country);

			LOGGER.info("End");

		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	private static void testAddCountry() {

		try {
			LOGGER.info("Start");

			Country country=new Country();;
			country.setCo_code("IN");
			country.setCo_name("India");
			countryService.addCountry(country);
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);

			LOGGER.info("End");

		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private static void testUpdateCountry() {

		try {
			LOGGER.info("Start");
			Country country;
			countryService.updateCountry("IN","India");
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);

			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	private static void testDeleteCountry() {

		try {
			LOGGER.info("Start");
			Country country;
			countryService.deleteCountry("IN");
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
