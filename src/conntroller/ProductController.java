package conntroller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if(action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//
//                break;
//            case "edit":
//
//                break;
//            case "delete":
//
//                break;
//            default:
//                break;
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//        if(action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//
//                break;
//            case "edit":
//
//                break;
//            case "delete":
//
//                break;
//            default:
//                break;
//        }
    }
}
