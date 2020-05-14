package com.cognizant.ormLearn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cognizant.ormLearn.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
