package com.example.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
//テスト中のデータの管理
@Transactional
public class HogeServiceTest {

    @Autowired
    HogeService service;

    @Test
    @Sql(statements = {
        "DELETE FROM hoge"
        ,"INSERT INTO hoge(id,name, age) VALUES(1,'taro', '20')"
    })
    public void IDの検索() {
        List<Hoge> findById = service.findById(1);
        assertEquals(1, findById.size());
    }

    @Test
    @Sql(statements = {
        "DELETE FROM hoge"
    })
    public void データの登録() {
        Integer id =1;
        String name="sanji";
        String age="20";

        HogeForm hoge = new HogeForm();
        hoge.setId(id);
        hoge.setName(name);
        hoge.setAge(age);

        //DBに登録
        service.save(hoge);

        List<Hoge> list = service.findById(id);
        Hoge hogeData = list.get(0);

        assertThat(hogeData.getId(), is(id));
    }
    
}
