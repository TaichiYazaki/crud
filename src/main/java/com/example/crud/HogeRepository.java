package com.example.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HogeRepository extends JpaRepository<Hoge,String>{
    public List<Hoge> findById(Integer id);
}
