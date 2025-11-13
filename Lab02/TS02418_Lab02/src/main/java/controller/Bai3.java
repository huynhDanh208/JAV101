package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/Bai03", "/form/update", "/form/create" })
public class Bai3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fullname", "Huỳnh Lê Đức Anh");
		map.put("gender", true);
		map.put("country", "vn");
		req.setAttribute("user", map);
		req.getRequestDispatcher("/form/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		
		if (uri.endsWith("/form/update")) {
			
			String fullname = req.getParameter("fullname");
			String gender = req.getParameter("gender");
			String country = req.getParameter("country");
			
			Map<String, Object> map = new HashMap<>();
			map.put("fullname", fullname);
			map.put("gender", gender);
			map.put("country", country);
			
			req.setAttribute("user", map);
			req.setAttribute("capnhat", "update thành công");
			
			req.getRequestDispatcher("/form/form.jsp").forward(req, resp);
			
		} else if (uri.endsWith("/form/create")) {
			
			String fullname = req.getParameter("fullname");
			String gender = req.getParameter("gender");
			String country = req.getParameter("country");
			
			Map<String, Object> map = new HashMap<>();
			map.put("fullname", fullname);
			map.put("gender", gender);
			map.put("country", country);
			
			req.setAttribute("user", map);
			req.getRequestDispatcher("/form/form_create.jsp").forward(req, resp);
		}

	}
}
