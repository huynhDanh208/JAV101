package controller;

import java.io.IOException;
import java.security.MessageDigest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/TrangChu", "/sanpham", "/LienHe" })
public class Bai01 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if (uri.endsWith("/TrangChu")) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else if (uri.endsWith("/sanpham")) {
			req.getRequestDispatcher("/sanpham.jsp").forward(req, resp);
		} else if (uri.endsWith("/LienHe")) {
			req.getRequestDispatcher("/lienHe.jsp").forward(req, resp);
		} else {
			req.setAttribute("message", "Không tìm thấy trang. Lỗi!!");
		}
	}
}
