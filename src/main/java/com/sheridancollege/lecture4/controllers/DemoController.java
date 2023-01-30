package com.sheridancollege.lecture4.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class DemoController {

    @GetMapping("/")
    public String goHome(){
        return"index";
    }

    @GetMapping("/process_register")
    public String registerUser(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam(defaultValue = "off") String rememberMe,
                               HttpServletResponse response ) throws IOException {
        PrintWriter out = response.getWriter();

        printHeader(out);
         out.print("<h2> Welcome " +firstName +""+ lastName +"");
         if(rememberMe.equals("on")){
             out.print("<h3> you will remembered ! <h3>");
         }

         printFooter(out);
         return null;

    }

    private void printHeader(PrintWriter out) {
        out.print("<!DOCTYPE html>\n"
                +"<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Registration Status</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Registration Successful!</h1>\n");

    }
    private void printFooter(PrintWriter out) {
        out.print("\n"
                +"</body>\n"
                +"</html>");
    }

    @GetMapping("/register_page")
    public String goRegister(){
        return "register";
    }

}
