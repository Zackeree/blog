package com.example.blog.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun blog(model: Model): String {
        // org.springframework.ui.set allows us to declare model in this fashion
        // as opposed to model.addAttribute("title", "Blog")
        model["title"] = "Blog"
        return "blog"
    }
}