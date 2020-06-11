package conntroller.tuan_test;

import model.users.UserDAO;
import service.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/admin")
public class AdminController extends CustomerController {

    private UserDAO userDAO;
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
        String action = req.getParameter("command");
        doAction(action, req, resp);
    }

    private void doAction(String action, HttpServletRequest req, HttpServletResponse resp) {
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "list":
                    getListUser(req, resp);
                    break;
                case "getName":
                    String nameParam1 = req.getParameter("name");
                    getByName(nameParam1, req, resp);
                    break;
                case "delete":
                    String nameParam2 = req.getParameter("name");
                    deleteByUsername(nameParam2, req, resp);
                    break;
                default:
                    PrintWriter writer = resp.getWriter();
                    writer.print("insert command: list, save, getName, delete");
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteByUsername(String _username, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            userDAO.deleteByUsername(_username);
            getListUser(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("error delete username" + _username);
        }
    }

    private void getByName(String _username, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException  {
        req.setAttribute("users", userDAO.getByUsername(_username));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("List_user.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void getListUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("users", userDAO.getAllUsers());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("List_user.jsp");
        requestDispatcher.forward(req, resp);
    }
}




