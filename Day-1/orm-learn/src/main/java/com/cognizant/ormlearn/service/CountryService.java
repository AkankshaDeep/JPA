package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	// Get all countries
	@Transactional
	public List<Country> getAllCountries() {

		return countryRepository.findAll();
	}

	// Get countries by code
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Country country = null;
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent())
			throw new CountryNotFoundException("No country with code-" + countryCode);
		else
			country = result.get();
		return country;

	}

	// Add country
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	// Update country
	@Transactional
	public void updateCountry(String countryCode, String newName) throws CountryNotFoundException {
		Country country;

		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent())
			throw new CountryNotFoundException("Cannot update country with code-" + countryCode);
		else {
			country = result.get();
			country.setCo_name(newName);
			countryRepository.save(country);
		}
	}

	@Transactional
	public void deleteCountry(String countryCode) throws CountryNotFoundException {
		Country country;

		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent())
			throw new CountryNotFoundException("Cannot update country with code-" + countryCode);
		else {
			country = result.get();
			
			countryRepository.deleteById(countryCode);
		}
	}
}
