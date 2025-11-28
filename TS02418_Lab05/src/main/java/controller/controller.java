package controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.User;

import util.Cookies;

@WebServlet({ "/Bai01", "/Bai02", "/Bai03" })
@MultipartConfig
public class controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		switch (servletPath) {
		case "/Bai01": {
			String usernameCookie = Cookies.get("username1", req);
			// nếu có cookie thì prefill và đánh dấu checked
			if (usernameCookie != null && !usernameCookie.isEmpty()) {
				req.setAttribute("username", usernameCookie);
				req.setAttribute("rememberChecked", "checked");
			} else {
				req.setAttribute("username", "");
				req.setAttribute("rememberChecked", "");
			}
			req.setAttribute("message", req.getAttribute("message")); // giữ message nếu có
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
			break;
		case "/Bai02": {
			req.getRequestDispatcher("sign_up.jsp").forward(req, resp);
		}
			break;
		case "/Bai03": {
			req.getRequestDispatcher("send_mail.jsp").forward(req, resp);
		}
			break;
		default: {
			req.setAttribute("messageLog", "Lỗi đường dẫn");
		}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		switch (servletPath) {
		case "/Bai01": {
			// credentials demo
			String usernameCorrect = "ducanh";
			String passwordCorrect = "123";

			String usernameip = req.getParameter("username");
			String passwordip = req.getParameter("password");
			// tên param trùng với JSP: rememberMe
			String remember = req.getParameter("rememberMe");
			int countFalseLogin = 0;

			// lấy số lần sai hiện tại từ session
			Object countObj = req.getSession().getAttribute("countFalseLogin");
			if (countObj != null) {
				try {
					countFalseLogin = (int) countObj;
				} catch (Exception e) {
					countFalseLogin = 0;
				}
			}

			if (usernameCorrect.equalsIgnoreCase(usernameip) && passwordCorrect.equals(passwordip)) {
				// đăng nhập thành công
				req.getSession().setAttribute("user", usernameCorrect);
				// reset counter
				req.getSession().setAttribute("countFalseLogin", 0);

				if (remember != null) {
					// lưu username trong cookie 30 ngày (không lưu password)
					int days30 = 24 * 30;
					Cookies.add("username1", usernameCorrect, days30, resp);
				} else {
					// xóa cookie nếu có
					Cookies.add("username1", "", 0, resp);
				}

				// redirect đến trang chính để tránh resubmit
				req.setAttribute("mesage", "Đăng nhập thành công");
				return;
			} else {
				// sai đăng nhập
				countFalseLogin++;
				req.getSession().setAttribute("countFalseLogin", countFalseLogin);
				req.setAttribute("message", "Sai username hoặc password! (Lần sai: " + countFalseLogin + "/5)");
				if (countFalseLogin >= 5) {
					req.getRequestDispatcher("false_login.jsp").forward(req, resp);
					return;
				}
				// Prefill username user đã nhập để tiện thử lại
				req.setAttribute("username", usernameip == null ? "" : usernameip);
				req.setAttribute("rememberChecked", (Cookies.get("username1", req) != null ? "checked" : ""));
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;
			}
		}
		case "/Bai02": {
			try {
				req.setCharacterEncoding("utf-8");

				DateConverter dc = new DateConverter();
				dc.setPattern("yyyy-MM-dd");
				ConvertUtils.register(dc, Date.class);

				User user = new User();

				BeanUtils.populate(user, req.getParameterMap()); //

				File dir = new File(req.getServletContext().getRealPath("/files"));
				if (!dir.exists()) {
					dir.mkdir();
					// System.out.print(request.getServletContext() + "anhtu");
				}

				Part photo = req.getPart("avatar");
				File photoFile = new File(dir, photo.getSubmittedFileName());
				photo.write(photoFile.getAbsolutePath());
				user.setAvatar(photoFile.getName());

				req.setAttribute("bean", user);
				// lấy sở thích cách 2

				String lay = Arrays.toString(user.getHobbies());
				String catchuoi = lay.substring(1, lay.lastIndexOf("]")) + ".";

				req.setAttribute("st", catchuoi);
				//

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			req.getRequestDispatcher("result_sign_up.jsp").forward(req, resp);
			return;
		}
		case "/Bai03": {
			try {
	            // Cấu hình SMTP
	            Properties p = new Properties();
	            p.put("mail.smtp.auth", "true");
	            p.put("mail.smtp.starttls.enable", "true");
	            p.put("mail.smtp.ssl.protocols", "TLSv1.2");
	            p.put("mail.smtp.host", "smtp.gmail.com");
	            p.put("mail.smtp.port", "587");
	            p.put("mail.debug", "true");

	            // Session mail
	            Session s = Session.getInstance(p, new jakarta.mail.Authenticator() {
	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(
	                        "huynhdem2609@gmail.com",
	                        "vtqj opuj yvyv iyju"
	                    );
	                }
	            });

	            // Message
	            Message msg = new MimeMessage(s);
	            msg.setFrom(new InternetAddress("huynhdem2609@gmail.com", "Huỳnh Lê Đức Anh"));

	            msg.setRecipients(Message.RecipientType.TO, 
	                InternetAddress.parse(req.getParameter("to")));

	            msg.setSubject(req.getParameter("subject"));

	            String content = req.getParameter("body");

	            // Nội dung text
	            MimeBodyPart contentPart = new MimeBodyPart();
	            contentPart.setContent(content, "text/html; charset=utf-8");

	            MimeMultipart multipart = new MimeMultipart();
	            multipart.addBodyPart(contentPart);

	            // Kiểm tra file đính kèm có hay không
	            Part filePart = req.getPart("file");

	            if (filePart != null && filePart.getSize() > 0 && 
	                    filePart.getSubmittedFileName() != null && 
	                    !filePart.getSubmittedFileName().isEmpty()) {

	                // Tạo folder /files
	                File dir = new File(req.getServletContext().getRealPath("/files"));
	                if (!dir.exists()) {
	                    dir.mkdir();
	                }

	                // Lưu file
	                File savedFile = new File(dir, filePart.getSubmittedFileName());
	                filePart.write(savedFile.getAbsolutePath());

	                // File đính kèm
	                MimeBodyPart fileBodyPart = new MimeBodyPart();
	                FileDataSource fds = new FileDataSource(savedFile);
	                fileBodyPart.setDataHandler(new DataHandler(fds));
	                fileBodyPart.setFileName(savedFile.getName());

	                // Gắn vào email
	                multipart.addBodyPart(fileBodyPart);
	            }

	            msg.setContent(multipart);

	            // Gửi mail
	            Transport.send(msg);

	            req.setAttribute("message", "Send email success!");

	        } catch (Exception e) {
	            e.printStackTrace();
	            req.setAttribute("message", "Send email fail!");
	        }
			
			req.getRequestDispatcher("send_mail.jsp").forward(req, resp);
			return;
		}
		default: {
			req.setAttribute("messageLog", "Lỗi đường dẫn");
		}
		}
	}
}
