package com.study.zqwstudy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Main  extends SpringBootServletInitializer {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @ResponseBody
    @RequestMapping(value = "/book",produces={MediaType.TEXT_PLAIN_VALUE})
    String index() {
        return "book name is:"+bookName+" and book author is2222:" + bookAuthor;
    }

    @RequestMapping(value = "/json")
    public String  json(Model model) {
        Person single = new Person("aa",11);
        model.addAttribute("single", single);
        return "jsonView";
    }

    @RequestMapping("/")
    public String index(Model model){
        Person single = new Person("aa",11);

        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("yy",22);
        Person p3 = new Person("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);

        return "index";
    }
    @RequestMapping("/spa/{.*}")
    public String spa(){
        return "spa";
    }

    @RequestMapping("/spa")
    public String spa2(){
        return "spa";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Main.class);
    }
}
