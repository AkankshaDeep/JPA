package com.example.truyumm.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.truyumm.model.Menu;

public interface UserRepository extends CrudRepository<Menu,Long>  {

}
