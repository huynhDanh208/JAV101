package controller;

import model.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductDetailServlet")
public class Chitietitem extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("id");
		selectById(name, req);
		req.getRequestDispatcher("/detailtu.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("id");
		selectById(name, req);
		req.getRequestDispatcher("/detailtu.jsp").forward(req, resp);

	}

	public void selectById(String name, HttpServletRequest request) throws ServletException, IOException {
		{
			List<Item> items = new ArrayList<>();
			items.add(new Item("Barcalona Home", "Barcalona_Home.jpg", 500, 0.1));
			items.add(new Item("Barcalona Away", "Barcalona_Away.jpg", 800, 0.1));
			items.add(new Item("Manchester City Away", "Manchester_City_Away.jpg", 560, 0.4));
			items.add(new Item("Manchester City Home", "Manchester_City_Home.jpg", 760, 0.7));
			items.add(new Item("Manchester United Away", "Manchester_United_Away.jpg", 980, 0.2));
			items.add(new Item("Manchester United Home", "Manchester_United_Home.jpg", 240, 0.1));

			ArrayList<Item> selectedItems = new ArrayList<>();
			for (Item item : items) {
				if (item.getName().equalsIgnoreCase(name)) {
					selectedItems.add(item); // 1 sản phẩm

				}
			}

			// Lưu danh sách sản phẩm đã chọn vào request để chuyển tiếp tới trang JSP
			request.setAttribute("selectedItems", selectedItems);
		}

	}

}
