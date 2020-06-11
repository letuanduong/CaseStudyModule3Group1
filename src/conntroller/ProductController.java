package conntroller;

import model.ProductStone.Product;
import model.ProductStone.ProductDAO;

import javax.annotation.PreDestroy;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {

    public ProductDAO productDAO;

    public ProductController(){
        try {
            productDAO = new ProductDAO();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                break;
            case "delete":

                break;
            default:
                listProduct(req,resp);
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(req,resp);
                break;
            case "edit":

                break;
            case "delete":

                break;
            default:
                break;
        }
        resp.setContentType("text/html;charset=UTF-8");
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("product_name");
        String brand = req.getParameter("product_brand");
        int price = Integer.parseInt(req.getParameter("product_price"));
        int amount = Integer.parseInt(req.getParameter("product_amount"));
        String description = req.getParameter("product_description");
        Product product = new Product(0, name, brand, price,amount, description);
        productDAO.insertProduct(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/TestProduct/alertSuccess.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> ListProduct = new ArrayList<>();
        ListProduct= productDAO.selectAllProduct();
        req.setAttribute("ListProduct",ListProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("TestProduct/test.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("TestProduct/createP.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
