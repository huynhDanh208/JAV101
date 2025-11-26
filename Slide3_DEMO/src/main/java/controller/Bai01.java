package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;

@WebServlet({ "/Bai01", "/Bai02" })
public class Bai01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("ntrang", "3333333");
		req.setAttribute("Teo", "110");
		req.setAttribute("Ty", "90");

		ArrayList<String> tenteo = new ArrayList<String>();
		tenteo.add("Lê");
		tenteo.add("Văn");
		tenteo.add("Tèo");
		req.setAttribute("tenteo", tenteo);


		ArrayList<Item> item = new ArrayList<Item>();
		item.add(new Item("Áo Manchester City Home", "100000", "Manchester_City_Home.jpg"));
		item.add(new Item("Áo Manchester City Away", "130000", "Manchester_City_Away.jpg"));
		item.add(new Item("Áo Barcalona Home", "200000", "Barcalona_Home.jpg"));
		item.add(new Item("Áo Barcalona Away", "230000", "Barcalona_Away.jpg"));
		req.setAttribute("dsao", item);
		req.getRequestDispatcher("jstl_coban.jsp").forward(req, resp);
	}
}
