package com.example.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class HogeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HogeService service;

    // テスト1 トップページが表示できること
    @Test
    public void test01() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hoge"));
    }

    // テスト2 DBにイベントが登録できること
    @Test
    @Sql(statements = {
        "DELETE FROM hoge"
    })
    public void test02() throws Exception {
        String name = "テスト用イベント";
        String age = "20";
        Hoge hoge = new Hoge();
        hoge.setName(name);
        hoge.setAge(age);

        mockMvc.perform(post("/save")
        //キー/データ
        .flashAttr("hoge",hoge))
        .andExpect(status().is3xxRedirection());

        List<Hoge> hogeList = service.findById(1);
        Hoge getHoge = hogeList.get(0);
        assertThat(getHoge.getId(), is(1));
        assertThat(getHoge.getName(), is(name));        
        assertThat(getHoge.getAge(), is(age));
        }
}
