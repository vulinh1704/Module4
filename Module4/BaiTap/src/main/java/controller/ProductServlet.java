package controller;

import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> products = productService.getProductsOver200();
            request.setAttribute("productsOver200", products);
            List<Product> productListless200 = productService.getProductsLess200();
            request.setAttribute("productsLess200", productListless200);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        if (name == null) {
            name = "";
        }
        List<Product> productsApproximateName = null;
        try {
            productsApproximateName = productService.getProductsApproximateName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("productsApproximateName", productsApproximateName);
//        response.sendRedirect("/products");


        String price1 = request.getParameter("price1");
        String price2 = request.getParameter("price2");
        int p1 = 0;
        int p2 = 0;
        if (price1 == null || price2 == null){
            price1 = "0";
            price2 = "0";
        } else {
            p1 = Integer.parseInt(price1);
            p2 = Integer.parseInt(price2);
        }
        List<Product> productsPriceRange = null;
        try {
            productsPriceRange = productService.getProductsPriceRange(p1 ,p2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("productsPriceRange", productsPriceRange);
        response.sendRedirect("/products");
    }
}
