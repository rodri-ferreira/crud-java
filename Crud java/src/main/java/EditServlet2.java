import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String nome = request.getParameter("Nome");
		String senha = request.getParameter("Senha");
		String email = request.getParameter("E-mail");
		String país = request.getParameter("País");

		Emp e = new Emp();
		e.setId(id);
		e.setName(nome);
		e.setPassword(senha);
		e.setEmail(email);
		e.setCountry(país);

		int status = EmpDao.update(e);
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Desculpe! não foi possível atualizar o registro");
		}

		out.close();
	}

}
