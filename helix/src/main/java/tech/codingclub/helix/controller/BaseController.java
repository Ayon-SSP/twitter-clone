package tech.codingclub.helix.controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mohit.
 */
public class BaseController {
    @ExceptionHandler
    public
    //@ResponseBody
    String defaultErrorHandler(HttpServletRequest req,  Exception e) throws Exception {
        System.out.println(e.getMessage());

        return "alien";
    }
}
