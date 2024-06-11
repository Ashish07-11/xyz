package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Movie_DAO;

@WebServlet("/delete-movie")
public class DeleteMovie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	Movie_DAO dao = new Movie_DAO();
	dao.deleteMovie(id);
	resp.getWriter().print("<h1 align='center' style='color:orange'>Movie Removed Succefully</h1>");
	req.getRequestDispatcher("home.html").include(req, resp);
	}

}
