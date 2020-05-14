package com.example.truyumm.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.truyumm.model.Cart;

public interface ProductRepository extends CrudRepository<Cart,Integer>{

}
