package com.example.superherov5.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;
import java.util.logging.Logger;

@Controller
public class SuperheroErrorController implements ErrorController {
/*    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SuperheroErrorController.class);

    @Override
    public String getErrorPath(){
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model){
        String errorPage = "error";
        String pageTitle = "Error";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null){
            int statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()){
                pageTitle = "Page not found";
                errorPage = "error/404";

            }
        }
    }*/
}
