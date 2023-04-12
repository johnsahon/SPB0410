package com.spb.spb0410.service.serviceimplements;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spb.spb0410.Dao.BookRelatedDAO;
import com.spb.spb0410.VO.MybookVO;
import com.spb.spb0410.controller.DuplicateBookException;
import com.spb.spb0410.service.BookService;

@Service
public class BookServiceImpl  implements BookService  {
    
    // get values from  your properties
    // @Value("${someString}")
	// String someString = ";

    private final BookRelatedDAO bookRelatedDAO;

    
    // constructors
    public BookServiceImpl(BookRelatedDAO bookRelatedDAO){
        this.bookRelatedDAO = bookRelatedDAO;

    }
    // other override methods 

    @Override
    public MybookVO addBook(MybookVO book) {
        final List<MybookVO> existingBook = bookRelatedDAO.findById(book.getIsbn());
        if (existingBook.size()>0) {
            throw new DuplicateBookException(book);
        }
        //沒查到的 新增
        int addBookResult= bookRelatedDAO.addBook(book);
        if (1==addBookResult){
            System.out.println("save book success");
        }
        return book;
    }

    @Override
    public Collection<MybookVO> getBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooks'");
    }

}
