package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Bai02")
public class Bai2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fullname", "Huỳnh Lê Đức Anh");
		map.put("gender", "Nam");
		map.put("country", "Việt Nam");
		req.setAttribute("user", map);
		req.getRequestDispatcher("bai02.jsp").forward(req, resp);
	}
}
