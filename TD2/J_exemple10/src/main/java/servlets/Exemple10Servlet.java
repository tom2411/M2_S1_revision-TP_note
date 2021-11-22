package servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exemple10Servlet extends HttpServlet {
    @Autowired
    Facade facade;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todo=request.getParameter("TODO");
        if (todo==null) {
            if (request.getSession().getAttribute("courant")!=null) {
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            switch (todo) {
                case "Submit" :
                    checkLP(request,response);
                    break;
                case "Logout":
                    logout(request,response);
                    break;
                case "SimpleCheck":
                    simpleCheck(request,response);
            }
        }

    }



    private void checkLP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password=request.getParameter("password");
        if (facade.checkLP(login,password)) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            request.getSession().setAttribute("courant",login);
            request.setAttribute("username",login);
            request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request,response);
        } else {
            List<String> errors=new ArrayList<>();
            errors.add("Les informations saisies ne correspondent pas à un utilisateur connu.");
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
    }



    public void simpleCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String courant=(String) request.getSession().getAttribute("courant");
        System.out.println(courant);
        request.setAttribute("username",courant);
        request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request,response);
    }

    public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException  {
        request.getSession().invalidate();
        request.getSession().removeAttribute("courant");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }
}
