package com.cognizant.ormLearn.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormLearn.Model.Stock;

@Repository

public interface StockRepository extends JpaRepository<Stock, String> {
	
	
	
	List<Stock> findByCodeAndDateBetween(String code,Date startDate,Date endDate);
	
	List<Stock> findByCodeAndCloseGreaterThan(String code,Double price);

	List<Stock> findTop3ByOrderByVolumeDesc();

	List<Stock> findFirst3ByCodeOrderByCloseAsc(String string);
	
	


}
