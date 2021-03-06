package org.jboss.test.clusterbench.web.ejb;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.test.clusterbench.ejb.singleton.LocalSingletonSB;

@WebServlet(name = "LocalSingletonEjbServlet", urlPatterns = {"/singletonejbservlet"})
public class LocalSingletonEjbServlet extends HttpServlet {

    @EJB
    private LocalSingletonSB bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        int serial = bean.getSerialAndIncrement();
        resp.getWriter().print(serial);
    }

    @Override
    public String getServletInfo() {
        return "Servlet invoking Singleton Session Bean to store serial.";
    }
}
