package conntroller;

import model.ProductStone.Product;
import model.ProductStone.ProductBill;
import model.ProductStone.ProductDAO;
import model.order.Order;
import model.order.OrderDAO;
import model.users.User;
import model.users.UserDAO;
import service.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {
    public ProductDAO productDAO;
    public OrderDAO orderDAO;
    public OrderController(){
        try {
            productDAO = new ProductDAO();
            orderDAO=new OrderDAO();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "pay":
                break;
            case "buy":
                showBuyProduct(req,resp);
                break;
            default:
                listProduct(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                insertOrderDetail(req,resp);
            case "history":
                checkHistory(req,resp);

        }
    }



    private void listProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> ListProduct = new ArrayList<>();
        ListProduct= productDAO.selectAllProduct();
        req.setAttribute("ListProduct",ListProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewUser/viewUser.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkHistory(HttpServletRequest req, HttpServletResponse resp) {
        List<ProductBill> productBills = new ArrayList<>();
        String username = req.getParameter("user_name");
        productBills = orderDAO.getHistory(username);
        req.setAttribute("productBills",productBills);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewUser/viewHistory.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showBuyProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id =Integer.parseInt(req.getParameter("id"));
        Product product = productDAO.getProductById(id);
        req.setAttribute("product",product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewUser/viewBuy.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void insertOrderDetail(HttpServletRequest req, HttpServletResponse resp) {
        int id_product=Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        try {
            orderDAO.insertOrderDetail(id_product,quantity);
            RequestDispatcher dispatcher = req.getRequestDispatcher("viewUser/alertAddSuccessfully.jsp");
            dispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
