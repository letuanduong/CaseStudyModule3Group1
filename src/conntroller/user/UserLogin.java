package conntroller.user;

import model.users.User;
import model.users.UserDAO;
import service.DBConnection;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class UserLogin extends HttpServlet {

    UserDAO userDAO;
    DBConnection dbConnection;
    {
        try {
            dbConnection = DBConnection.getInstance("mystery1309", "13091997");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/LoginTest.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String _username = req.getParameter("username");
        String _password = req.getParameter("password");
        User user = userDAO.getByUsername(_username);

        if (user.getPassword().equals(_password)) {
            HttpSession session = req.getSession();
            session.setAttribute("ROLE", user.getRole());

//            resp.sendRedirect("/product");
            if (user.getRole()==1){
                resp.sendRedirect("/product");
            }else if (user.getRole()==0){
                resp.sendRedirect("/order");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/LoginTest.jsp");
                dispatcher.forward(req, resp);
            }

            req.setAttribute("message", "login Success");
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
            dispatcher.forward(req, resp);

        } else {
            req.setAttribute("message", "login un success");
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
            dispatcher.forward(req, resp);
        }
    }
}

