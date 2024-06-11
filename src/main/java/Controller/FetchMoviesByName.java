package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Movie_DAO;
import dto.Movie;

@WebServlet("/fetch-movies-name")
public class FetchMoviesByName extends HttpServlet {	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("by_name.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		Movie_DAO dao = new Movie_DAO();
		List<Movie> list = dao.fetchMoviesByName(name);
		if (list.isEmpty()) {
			resp.getWriter().print("<h1 align='center' style='color:blue'>No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
			req.setAttribute("list",list);
			req.getRequestDispatcher("fetch_all.jsp").forward(req, resp);
		}
	}
}