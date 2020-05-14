package com.cognizant.ormLearn.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormLearn.Model.Country;



@Repository

public interface CountryRepository extends JpaRepository<Country, String> {

	List<Country> findByName(String string);

	List<Country> findByNameContaining(String string);

	@Query("from Country where name LIKE %:code% order by name")
	List<Country> findByNameSorted(@Param("code")String coCode);

	List<Country> findByNameStartsWith(String cLetter);
	
	@Query("from Country where name LIKE :letter% order by name")
	List<Country> findByNameStartsWithSorted(@Param("letter")String cLetter);

	

}