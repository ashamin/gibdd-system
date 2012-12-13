package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Inspector;

/**
 * Главный сервлет
 * 
 * @author Вотяков Роман
 * @author Кудинов Александр
 * @author Шамин Антон
 */
@WebServlet({ "/index.jsp" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *  Производит перенаправление
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Inspector inspector = (Inspector) session.getAttribute("inspector");

		if (inspector == null)
			response.sendRedirect("login.jsp");
		else
			response.sendRedirect("workspace.jsp");
	}
}
