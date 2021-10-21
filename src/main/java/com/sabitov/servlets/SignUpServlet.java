package com.sabitov.servlets;

import com.sabitov.dto.SignUpForm;
import com.sabitov.dto.SignUpService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private SignUpService signUpService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext=config.getServletContext();
        ApplicationContext applicationContext= (ApplicationContext) servletContext.getAttribute("springContext");
        this.signUpService=applicationContext.getBean(SignUpService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/signUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpForm signUpForm=SignUpForm.builder().
                name((String) req.getAttribute("name")).
                login((String) req.getAttribute("login")).
                password((String) req.getAttribute("password")).
                build();
        this.signUpService.signUp(signUpForm);
    }
}
