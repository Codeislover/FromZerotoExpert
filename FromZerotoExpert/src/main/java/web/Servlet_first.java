package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/try")
public class Servlet_first extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        Cookie cookie1 = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("exist") && cookie.getValue().equals("first"))
                    cookie1 = cookie;
                break;
            }
        }
        if (cookie1 != null) {
            writer.println("嗨，欢迎您再次到 from zero to expert.");
        } else {
            Cookie cookie = new Cookie("exist", "first");
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            writer.println("嗨，欢迎您来到 from zero to expert.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
