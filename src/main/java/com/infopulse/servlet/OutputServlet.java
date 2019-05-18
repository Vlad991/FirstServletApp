package com.infopulse.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class OutputServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String formValue = (String) request.getAttribute("param1");
        String filterParam = (String) request.getAttribute("param2");
        String eventParam = (String) request.getAttribute("newatr");
        response.setContentType("text/html");

        request.setAttribute("name", formValue);
//        pw.println("<html>");
//        pw.println("<body>");
//        pw.println("Hello, " + formValue);
//        pw.println("Filter param " + filterParam);
//        pw.println("Event param " + eventParam);
//        pw.println("</body>");
//        pw.println("</html>");
        List<String> text = Arrays.asList("aaa", "bbb", "ccc");
        request.setAttribute("list", text);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/answer.jsp");
        rd.forward(request, response);
    }
}
