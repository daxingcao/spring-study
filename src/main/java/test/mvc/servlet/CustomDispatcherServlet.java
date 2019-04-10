package test.mvc.servlet;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class CustomDispatcherServlet extends DispatcherServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        addRequiredProperty("hello");
        super.init(config);
    }
}
