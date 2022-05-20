package com.dkrucze.MoviesManager.Controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalErrorController {

    @ExceptionHandler(value = Exception.class)
    public String defaultExceptionHandler(HttpServletRequest req, Exception e, Model model){
        if(e.getClass()== DataIntegrityViolationException.class){
            return "redirect:/register?failure";
        }
        return "redirect:/";
    }

}
