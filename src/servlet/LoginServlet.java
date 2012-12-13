package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBObject;
import model.DriverLicenseInspector;
import model.DutyInspector;
import model.Inspector;
import model.PatrolInspector;
import model.VehicleInspector;

/**
 * Сервлет входа в систему
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Перенаправляет на страничку входа в систему
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * Производит вход в систему
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		HttpSession session = request.getSession();

		Inspector inspector = new DriverLicenseInspector();
		inspector.select(login, password);

		boolean correctLogin = false;

		if (inspector.getId() != DBObject.UNDEFINED_ID) {
			correctLogin = true;
		} else {
			inspector = new DutyInspector();
			inspector.select(login, password);
			if (inspector.getId() != DBObject.UNDEFINED_ID) {
				correctLogin = true;
			} else {
				inspector = new PatrolInspector();
				inspector.select(login, password);

				if (inspector.getId() != DBObject.UNDEFINED_ID) {
					correctLogin = true;
				} else {
					inspector = new VehicleInspector();
					inspector.select(login, password);
					if (inspector.getId() != DBObject.UNDEFINED_ID) {
						correctLogin = true;
					}
				}
			}
		}

		if (correctLogin) {
			session.setAttribute("login-error", null);
			session.setAttribute("inspector", inspector);

			response.sendRedirect("workspace.jsp");
		} else {
			session.setAttribute("login-error",
					"неверное имя пользователя или пароль");

			response.sendRedirect("login.jsp");
		}
	}
}
