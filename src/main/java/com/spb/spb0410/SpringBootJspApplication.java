package com.spb.spb0410;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//spring boot 起始的controller 將擴充成 web container 
@SpringBootApplication
public class SpringBootJspApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootJspApplication.class);
	}

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJspApplication.class);
    }
}

//Field personDao d a bean of type 'com.spb.spb0410.Dao.PersonDao' that could not be found.
//https://blog.csdn.net/Julycaka/article/details/80622754
//啟動類要放在controller外 ，才會整個一起掃&build bean


//每次預設的 起始，單獨的啟動method
//https://www.baeldung.com/spring-boot-jsp
// @SpringBootApplication(scanBasePackages = "com.baeldung.boot.jsp")
// public class SpringBootJspApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(SpringBootJspApplication.class);
//     }
// }
