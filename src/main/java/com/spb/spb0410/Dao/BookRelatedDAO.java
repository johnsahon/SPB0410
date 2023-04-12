package com.spb.spb0410.Dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.spb.spb0410.VO.MybookVO;

@Repository
public class BookRelatedDAO {
    private JdbcOperations jdbcOperations;


    public BookRelatedDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    ////https://blog.csdn.net/zbdxcyg/article/details/71440729  list 引用錯檔案 換import就好
    public List<MybookVO> findById(String Isbn) {
        String sql ="SELECT * FROM bookSave place where Isbn = ? ";
        ArrayList<Object> sqlParams = new ArrayList<>();
	    sqlParams.add(Isbn);

        return jdbcOperations.query(sql, sqlParams.toArray(), new BeanPropertyRowMapper<>(MybookVO.class));
    }

    public int addBook(MybookVO vo) {
        String sql ="INSERT INTO bookSave(isbn, name, author) VALUES(?, ?, ?)";
        ArrayList<Object> sqlParams = new ArrayList<>();	
		sqlParams.add(vo.getIsbn());
        sqlParams.add(vo.getName());
        sqlParams.add(vo.getAuthor());   
       return jdbcOperations.update(sql,sqlParams.toArray());
    }

}
