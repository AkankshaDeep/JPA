package com.cognizant.ormLearn.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormLearn.Model.Stock;
import com.cognizant.ormLearn.Repository.StockRepository;

@Service
public class StockService {
	@Autowired
	StockRepository stockRepository;

	// Get all countries
	@Transactional
	public List<Stock> getAllStock() {

		return stockRepository.findAll();
	}
	
	@Transactional
	public List<Stock> getFbSept19() throws ParseException{
		//List<Stock> l =stockRepository.findByCodeSept("FB");
		List<Stock> l=stockRepository.findByCodeAndDateBetween("FB",new SimpleDateFormat("yyyy-MM-dd").parse("2019-9-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-01"));
		return l;
	}
	
	@Transactional
	public List<Stock> getGoggleGreaterPrice(){
		List<Stock> l=stockRepository.findByCodeAndCloseGreaterThan("GOOGL",1250.00);
		return l;
	}
	
	@Transactional
	public List<Stock> getTopThreeByVolume(){
		List<Stock> l=stockRepository.findTop3ByOrderByVolumeDesc();
		return l;
	}

	@Transactional
	public List<Stock> getLowestNetflixStockDate(){
		List<Stock> l=stockRepository.findFirst3ByCodeOrderByCloseAsc("NFLX");
		return l;
	}
}

