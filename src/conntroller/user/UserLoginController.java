package conntroller.user;

import model.users.UserDAO;
import service.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserLoginController extends HttpServlet {

    DBConnection dbConnection;
    {
        try {
            dbConnection = DBConnection.getInstance("root", "111333");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(dbConnection);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("users", userDAO.getAllUsers());
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("testUser.jsp");
//        requestDispatcher.forward(req, resp);

        req.setAttribute("users", userDAO.getByUsername("tuan1"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("testUser.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}




