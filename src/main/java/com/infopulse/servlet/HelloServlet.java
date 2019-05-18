package com.infopulse.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          String formValue = null;
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie: cookies) {
//                if ("user".equals(cookie.getName())) {
//                    formValue = cookie.getValue();
//                }
//            }
//        }
//        if(formValue == null) {
//            formValue = request.getParameter("username");
//            Cookie cookie = new Cookie("user", formValue);
//            cookie.setMaxAge(1000);
//            response.addCookie(cookie);
//        }
        HttpSession hs = request.getSession(true);
        formValue = (String) hs.getAttribute("user");
        if (formValue == null) {
            formValue = request.getParameter("username");
            //hs.setMaxInactiveInterval(100000);
            hs.setAttribute("user", formValue);
        }

        String filterParam = (String) request.getAttribute("filter");

//        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        pw.println("<html>");
//        pw.println("<body>");
//        pw.println("Hello, " + formValue);
//        pw.println("Filter param " + filterParam);
//        pw.println("</body>");
//        pw.println("</html>");
//        pw.close();

        request.setAttribute("param1", formValue);
        request.setAttribute("param2", filterParam);
        RequestDispatcher rd = request.getRequestDispatcher("/output");
        rd.forward(request, response);
    }
}
