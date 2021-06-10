package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HtmlController {


    @GetMapping("/")
    public String getIndex(){
        return "index";

    }
    @GetMapping("/opdater")
    public String getOpdater(){
        return "opdater";

    }
    @GetMapping("/kommune")
    public String getKommune(){
        return "kommune";
    }
}
