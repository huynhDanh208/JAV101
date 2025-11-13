package poly.com.controller;

import java.io.IOException;

import org.eclipse.jdt.internal.compiler.ast.RequiresStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/Bai04", "/crud/them", "/crud/xoa", "/crud/sua" })
public class bai04 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.getRequestDispatcher("bai4.jsp").forward(req, resp);
		// TODO Auto-generated method stub
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		String uri = req.getRequestURI();

		if (uri.endsWith("/Bai04")) {
			resp.getWriter().print("<h1>Đây là bài 4</h1>");
		} else if (uri.endsWith("/crud/them")) {
			resp.getWriter().print("<h1>Đang thêm...</h1>");
		} else if (uri.endsWith("/crud/xoa")) {
			resp.getWriter().print("<h1>Đang xóa...</h1>");
		} else if (uri.endsWith("/crud/sua")) {
			resp.getWriter().print("<h1>Đang sửa...</h1>");
		} else if (uri.endsWith("/crud/edit/2024")) {
			resp.getWriter().print("<h1>Đang chỉnh sửa 2024...</h1>");
		} else {
			resp.getWriter().print("<h1>Lỗi!</h1>");
		}

	}
}
