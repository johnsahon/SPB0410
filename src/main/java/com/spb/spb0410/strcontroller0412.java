package com.spb.spb0410;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class strcontroller0412 {
    // angular 接起
    @GetMapping("/go")
    public String index() {
        return "forward:/index.html";
    }
}
