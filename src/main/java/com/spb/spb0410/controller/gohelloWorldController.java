package com.spb.spb0410.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class gohelloWorldController {

    // ref
    // https://stackoverflow.com/questions/55016359/gradle-for-this-spring-boot-project-jsp
    // https://www.itread01.com/article/1507595041.html
    // 記得自己建 src/main/webapp/WEB-INF/jsp目錄 gradle dependency 加 jsp &tomcat
    @GetMapping("/hello")
    public String getHelloMessage() {
        return "index";
    }

    @RequestMapping("/test")
    public String myJsp(HttpServletRequest request, ModelMap model) {
        System.out.println("myjsp");
        model.put("test", "test");
        request.setAttribute("test2", "test2");
        return "test";
    }

}
