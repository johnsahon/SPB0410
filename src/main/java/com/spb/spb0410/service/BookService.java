package com.spb.spb0410.service;

import java.util.Collection;

import com.spb.spb0410.VO.MybookVO;


public interface BookService {

    Collection<MybookVO> getBooks();
    MybookVO addBook(MybookVO book);
    
}