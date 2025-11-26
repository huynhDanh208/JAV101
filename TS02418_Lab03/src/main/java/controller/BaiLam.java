package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem1;
import model.Country;
import model.Item;


@WebServlet({ "/Bai01", "/Bai02", "/Bai03", "/Bai04", "/Bonus" })
public class BaiLam extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();

		if (uri.endsWith("/Bai01")) {
			List<Country> list = List.of(new Country("VN", "Viet Nam"), new Country("US", "Hoa Ky"),
					new Country("SP", "Tay Ban Nha"));
			req.setAttribute("countries", list);

			req.getRequestDispatcher("bai1.jsp").forward(req, resp);
		} else if (uri.endsWith("/Bai02")) {
			List<Country> list = List.of(new Country("VN", "Viet Nam"), new Country("US", "Hoa Ky"),
					new Country("SP", "Tay Ban Nha"));
			req.setAttribute("countries", list);

			req.getRequestDispatcher("bai2.jsp").forward(req, resp);
		} else if (uri.endsWith("/Bai03")) {
			Map<String, Object> map = new HashMap<>();
			map.put("name", "iPhone 2024");
			map.put("price", 12345.678);
			map.put("date", new Date());
			req.setAttribute("item", map);

			req.getRequestDispatcher("bai3.jsp").forward(req, resp);
		} else if (uri.endsWith("/Bai04")) {
			Map<String, Object> map = new HashMap<>();
			map.put("title", "Tiêu đề bản tin");
			map.put("content", "Nội dung bản tin thường rất dài");
			req.setAttribute("item", map);

			req.getRequestDispatcher("bai4.jsp").forward(req, resp);
		} else if (uri.endsWith("/Bonus")) {
			 HttpSession session = req.getSession(); // Lấy session
				List<CartItem1> cartItems = (List<CartItem1>) session.getAttribute("cartItems"); // Lấy giỏ hàng từ session

		        // Nếu giỏ hàng chưa có, khởi tạo mới
		        if (cartItems == null) {
		            cartItems = new ArrayList<>();
		        }

		        // Tạo danh sách sản phẩm
		        List<Item> items = new ArrayList<>();
		        items.add(new Item("Barcalona Home", "Barcalona_Home.jpg", 500, 0.1));
		        items.add(new Item("Barcalona Away", "Barcalona_Away.jpg", 800, 0.1));
		        items.add(new Item("Manchester City Away", "Manchester_City_Away.jpg",560, 0.4));
		        items.add(new Item("Manchester City Home", "Manchester_City_Home.jpg", 760, 0.7));
		        items.add(new Item("Manchester United Away", "Manchester_United_Away.jpg", 980, 0.2));
		        items.add(new Item("Manchester United Home", "Manchester_United_Home.jpg", 240, 0.1));

		        req.setAttribute("items", items);
		        req.setAttribute("cartItems", cartItems);

			req.getRequestDispatcher("cart.jsp").forward(req, resp);
		} else {
			req.setAttribute("message", "Bị lỗi đường dẫn!");
		}

	}
}
