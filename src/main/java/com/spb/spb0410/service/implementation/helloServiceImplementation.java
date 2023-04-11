package com.spb.spb0410.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class helloServiceImplementation {

    @Autowired
    private SaveDAO saveDAO;

    @Autowired
    private saveJPADAO saveForJPAVO;
}
