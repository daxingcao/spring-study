package test.mvc.controller;

import entity.Person;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        Object name = getServletContext().getAttribute("name");
        System.out.println(name.toString());
        if(requestAttributes != null){
            HttpServletRequest request = requestAttributes.getRequest();
            RequestContextUtils.findWebApplicationContext(request);
        }
        Person person = new Person();
        person.setPassword("123456");
        return new ModelAndView("index","person",person);
    }

}
