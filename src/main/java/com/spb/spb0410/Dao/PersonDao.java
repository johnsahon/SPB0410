package com.spb.spb0410.Dao;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import com.spb.spb0410.VO.PersonVO;

@Repository
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    ////https://blog.csdn.net/zbdxcyg/article/details/71440729  list 引用錯檔案 換import就好
    public List<PersonVO> getAllPersons() {
        return jdbcTemplate.query(
                "SELECT * FROM person",
                (rs, rowNum) -> new PersonVO(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                )
        );
    }

    public void addPerson(PersonVO person) {
        jdbcTemplate.update(
                "INSERT INTO person(name, age) VALUES(?, ?)",
                person.getName(), person.getAge()
        );
    }

}