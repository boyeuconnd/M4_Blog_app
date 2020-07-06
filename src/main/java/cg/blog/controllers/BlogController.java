package cg.blog.controllers;

import cg.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public ModelAndView getHomePage() {

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("blogs", blogService.findAll());
        return mv;
    }

    @GetMapping("blog/{id}")
    public ModelAndView getBlogDetail(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("blog");
        mv.addObject("blog", blogService.findOne(id));
        return mv;
    }

    @GetMapping("/this-is-my-error")
    public ModelAndView testHomePage() {

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("blogs", blogService.findAll());
        return mv;
    }

    @ExceptionHandler(RuntimeException.class)
    public String getErrorPage() {
        return "my-error";
    }

}
