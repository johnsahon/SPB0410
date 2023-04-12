package com.spb.spb0410.controller;

import com.spb.spb0410.VO.MybookVO;


public class DuplicateBookException extends RuntimeException {
    private final MybookVO book;

    public DuplicateBookException(MybookVO book) {
        this.book = book;
    }

    // getter methods
    public MybookVO getBook() {
        return book;
    }

}