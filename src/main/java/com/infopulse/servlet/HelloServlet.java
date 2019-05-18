package com.infopulse.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String formValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if ("user".equals(cookie.getName())) {
                    formValue = cookie.getValue();
                }
            }
        }
        if(formValue == null) {
            formValue = request.getParameter("username");
            Cookie cookie = new Cookie("user", formValue);
            cookie.setMaxAge(1000);
            response.addCookie(cookie);
        }


        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        pw.println("Hello, " + formValue);
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
