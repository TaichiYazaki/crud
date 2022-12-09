package com.example.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HogeService {

    @Autowired
    HogeRepository repository;

    // データの登録
    public void save(HogeForm form){
        Hoge hoge = new Hoge();
        hoge.setName(form.getName());
        hoge.setAge(form.getAge());
        repository.save(hoge);
    }

    // idの検索
    public List<Hoge> findById(Integer id) {
        return repository.findById(id);
    }
}
