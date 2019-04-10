package test.mvc.servlet;

import entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is get request...");
        Person per = new Person();
        per.setPassword("123456");
        req.setAttribute("person",per);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet service method calling...");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet is destroyed...");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("MyServlet was init...");
    }
}
