package com.cognizant.ormLearn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.ormLearn.Model.Country;
import com.cognizant.ormLearn.Repository.CountryRepository;

@Controller
public class ApplicationController {

	@Autowired
	CountryRepository countryRepository;
	@RequestMapping("/")
	public String getHomepage() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/getCountry")
	public ModelAndView getCountry(@RequestParam String coCode) {
		
		ModelAndView mv=new ModelAndView("show.jsp");
		List<Country> c=countryRepository.findByNameContaining(coCode);
		List<Country> cSorted=countryRepository.findByNameSorted(coCode);
		
		mv.addObject("country",c);
		mv.addObject("countryList",cSorted);
		return mv;
	}
	@RequestMapping("/displayCountry")
	public ModelAndView displayCountry(@RequestParam String cLetter) {
		ModelAndView mv=new ModelAndView("show.jsp");
		
		List<Country> c=countryRepository.findByNameStartsWith(cLetter);
		List<Country> cSorted=countryRepository.findByNameStartsWithSorted(cLetter);
		mv.addObject("countryByLetter",c);
		System.out.println(cSorted);
		mv.addObject("sortedCountryByLetter",cSorted);
		return mv;
	}
		

}
