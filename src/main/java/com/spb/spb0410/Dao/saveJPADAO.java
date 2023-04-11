package com.spb.spb0410.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spb.spb0410.Model.saveForJPAVO;

//https://ithelp.ithome.com.tw/articles/10271260 jdbctamplate

@Repository
public interface saveJPADAO extends JpaRepository<saveForJPAVO, Long> {

    // TODO
    // // maybe JPA or jdbc templated
    // saveVO a = new saveVO();

    // // simple CRUD

}
