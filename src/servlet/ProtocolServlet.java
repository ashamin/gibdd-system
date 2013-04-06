package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;
import model.PatrolInspector;
import model.Protocol;
import model.Vehicle;
import model.Violation;

/**
 * Servlet implementation class ProtocolServlet
 */
@WebServlet("/protocolFunc")
public class ProtocolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProtocolServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("deleteProtocol") != null) {

			Protocol p = new Protocol();
			p.select(Integer.parseInt(request.getParameter("protocol_id")));
			System.out.println(p);

			p.delete();

			// here we use p.delete(); for deleting from data base

			response.sendRedirect("workspace.jsp");
		} else if (request.getParameter("refreshProtocol") != null) {

			Human human = new Human(request.getParameter("name"),
					request.getParameter("passportNumber"),
					request.getParameter("address"));

			human.insert();

			Violation violation = new Violation(request.getParameter("title"),
					request.getParameter("description"),
					request.getParameter("punishment"));

			violation.insert();

			HashSet<String> brands = (HashSet<String>) Vehicle.selectBrands();

			Iterator<String> it = brands.iterator();
			String str = null;
			int i = 0;

			while (it.hasNext()) {
				str = it.next();

				if (Integer.toString(i).equals(request.getParameter("brand")))
					break;

				i++;
			}

			Vehicle vehicle = new Vehicle(request.getParameter("VIN"),
					request.getParameter("EIN"), request.getParameter("color"),
					str, Date.valueOf(request.getParameter("year")));

			vehicle.insert();

			PatrolInspector patrolInspector = new PatrolInspector();
			patrolInspector.select(Integer.parseInt(request
					.getParameter("inspector_id")));

			Protocol protocol = new Protocol();
			protocol.select(Integer.parseInt(request
					.getParameter("protocol_id")));
			
			protocol.setHuman(new Human(human));
			protocol.setViolation(new Violation(violation));
			protocol.setVehicle(new Vehicle(vehicle));
			protocol.setDate(Date.valueOf(request.getParameter("date")));

			try {
				protocol.update();
			} catch (Exception e) {
				throw e;
			}

			response.sendRedirect("workspace.jsp");

		} else if (request.getParameter("backProtocol") != null) {
			System.out.println("It's back button");
			response.sendRedirect("workspace.jsp");
		} else if (request.getParameter("saveProtocol") != null) {
			System.out.println("It's save button");

			if (checkFields(request)) {

				Human human = new Human(request.getParameter("name"),
						request.getParameter("passportNumber"),
						request.getParameter("address"));

				human.insert();

				Violation violation = new Violation(
						request.getParameter("title"),
						request.getParameter("description"),
						request.getParameter("punishment"));

				violation.insert();

				HashSet<String> brands = (HashSet<String>) Vehicle
						.selectBrands();

				Iterator<String> it = brands.iterator();
				String str = null;
				int i = 0;

				while (it.hasNext()) {
					str = it.next();

					if (Integer.toString(i).equals(
							request.getParameter("brand")))
						break;

					i++;
				}

				Vehicle vehicle = new Vehicle(request.getParameter("VIN"),
						request.getParameter("EIN"),
						request.getParameter("color"), str,
						Date.valueOf(request.getParameter("year")));

				vehicle.insert();

				PatrolInspector patrolInspector = new PatrolInspector();
				patrolInspector.select(Integer.parseInt(request
						.getParameter("inspector_id")));

				Protocol protocol = new Protocol(human, violation,
						Date.valueOf(request.getParameter("date")), vehicle,
						patrolInspector);

				try {
					protocol.insert();
				} catch (Exception e) {
					throw e;
				}

				response.sendRedirect("workspace.jsp");
			} else
				response.sendRedirect("protocol-form.jsp");

		} else
			System.out.println("I don't know!");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private boolean checkFields(HttpServletRequest request) {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("passportNumber"));
		System.out.println(request.getParameter("address"));
		System.out.println();

		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("punishment"));
		System.out.println();

		System.out.println(request.getParameter("VIN"));
		System.out.println(request.getParameter("EIN"));
		System.out.println(request.getParameter("color"));
		System.out.println(request.getParameter("brand")); // PRINT ACTIVE
															// OPTION VALUE
		System.out.println(request.getParameter("year"));
		System.out.println();
		System.out.println(request.getParameter("date"));

		return true;
	}

}
