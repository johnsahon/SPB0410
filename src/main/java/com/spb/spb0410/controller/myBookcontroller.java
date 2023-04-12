package com.spb.spb0410.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.spb.spb0410.VO.MybookVO;
import com.spb.spb0410.service.BookService;

@Controller
@RequestMapping("/mybook")
public class myBookcontroller {

    @Autowired
    private final BookService bookService;

    public myBookcontroller(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/viewBooks")
    public String viewBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "view-books";
    }


    @GetMapping("/addBook")
    public String addBookView(Model model) {
        model.addAttribute("book", new MybookVO());
        return "add-book";
    }

    //有參的時候  對/mybook/addBook 傳post表單
    @PostMapping("/addBook")
    public RedirectView addBook(@ModelAttribute("book") MybookVO book, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/mybook/addBook", true);
        MybookVO savedBook = bookService.addBook(book);
        redirectAttributes.addFlashAttribute("savedBook", savedBook);
        redirectAttributes.addFlashAttribute("addBookSuccess", true);
        return redirectView;
    } 

// http://localhost:8080/h2-console/

// http://localhost:8080/mybook/viewBooks

// http://localhost:8080/mybook/addBook


}
