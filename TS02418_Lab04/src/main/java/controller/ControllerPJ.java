package controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;
//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
//import sun.security.util.FilePaths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet({ "/Bai01", "/Bai02", "/Bai03", "/calculator/*"
//	,"/calculator/pls","/calculator/sub","/calculator/mul","/calculator/div"
})
public class ControllerPJ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String pathinfo = req.getPathInfo();
		String servletPath = req.getServletPath();
		if (uri.endsWith("/Bai01")) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		} else if (uri.endsWith("/Bai02") || "/calculator".equals(servletPath)) {
			req.getRequestDispatcher("/calculator.jsp").forward(req, resp);
			return;
		} else if (uri.endsWith("/Bai03")) {
			req.getRequestDispatcher("sign_up.jsp").forward(req, resp);

		} else {
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
	}

	private static final String UPLOAD_DIRECTORY = "uploads";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String servletPath = req.getServletPath(); // "/calculator" when mapped
		String pathinfo = req.getPathInfo();
		if (uri.endsWith("/Bai01")) {

			String username = "ducanh";
			String password = "1234";
			String usernameip = req.getParameter("username");
			String passwordip = req.getParameter("password");
			int countFalseLogin = 0;

			// lấy số lần sai hiện tại từ session
			Object countObj = req.getSession().getAttribute("countFalseLogin");
			if (countObj != null) {
				countFalseLogin = (int) countObj;
			}

			if (usernameip.equals(username) && passwordip.equals(password)) {

				// reset số lần sai
				req.getSession().setAttribute("countFalseLogin", 0);
				req.setAttribute("message", "Đăng nhập thành công");

			} else {
				// tăng số lần sai
				countFalseLogin++;
				req.getSession().setAttribute("countFalseLogin", countFalseLogin);
				if (countFalseLogin >= 5) {
					req.getRequestDispatcher("false_login.jsp").forward(req, resp);
					return;
				}
				req.setAttribute("message", "Đăng nhập thất bại. Sai lần: " + countFalseLogin);
			}
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		} else if ("/calculator".equals(servletPath) || (pathinfo != null && servletPath.equals("/calculator"))) {
			double a = Double.parseDouble(req.getParameter("soA"));
			double b = Double.parseDouble(req.getParameter("soB"));
			double result = 0;

			switch (pathinfo) {
			case "/pls":
				result = a + b;
				break;
			case "/sub":
				result = a - b;
				break;
			case "/mul":
				result = a * b;
				break;
			case "/div":
				if (b == 0) {
					req.setAttribute("error", "Không thể chia cho 0");
					req.getRequestDispatcher("/calculator.jsp").forward(req, resp);
					return;
				}
				result = a / b;
				break;
			}
			req.setAttribute("result", "Đáp án: " + result);
			req.getRequestDispatcher("/calculator.jsp").forward(req, resp);
			return;

		} else if (uri.endsWith("/Bai03")) {
			// Lấy param (chú ý tên trùng với sign_up.jsp)
			String username = req.getParameter("usernameip");
			String password = req.getParameter("passwordip");
			String gender = req.getParameter("genderip"); // <- sửa tên cho khớp
			String married = req.getParameter("marriedip"); // checkbox
			String country = req.getParameter("countryip");
			String[] hobbies = req.getParameterValues("hobbiesip");
			String note = req.getParameter("noteip");

			// XỬ LÝ FILE UPLOAD
			Part filePart = req.getPart("avatarip"); // cần enctype multipart/form-data
			String fileName = null;
			String photoURL = null;

			if (filePart != null && filePart.getSubmittedFileName() != null
					&& !filePart.getSubmittedFileName().isEmpty()) {
				// lấy tên an toàn
				fileName = java.nio.file.Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

				// nơi lưu: webapp/uploads
				String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists())
					uploadDir.mkdirs();

				// lưu file
				String fullPath = uploadPath + File.separator + fileName;
				filePart.write(fullPath);

				// đường dẫn để hiển thị trên JSP (có context path)
				photoURL = req.getContextPath() + "/" + UPLOAD_DIRECTORY + "/" + fileName;
			} else {
				photoURL = req.getContextPath() + "/" + UPLOAD_DIRECTORY + "/default-avatar.png"; // hoặc null
			}

			// set attribute để hiển thị ở result_sign_up.jsp
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			req.setAttribute("gender", gender);
			req.setAttribute("married", married != null ? "Yes" : "No");
			req.setAttribute("country", country);
			req.setAttribute("hobbies", hobbies);
			req.setAttribute("note", note);
			req.setAttribute("photoURL", photoURL);

			// forward tới trang kết quả
			req.getRequestDispatcher("/result_sign_up.jsp").forward(req, resp);
			return;
		} else {

			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
	}

}
