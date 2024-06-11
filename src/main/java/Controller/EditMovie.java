package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Movie_DAO;
import dto.Movie;

@WebServlet("/edit-movie")
@MultipartConfig
public class EditMovie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Movie_DAO dao = new Movie_DAO();
		Movie movie = dao.findMovie(id);
		req.setAttribute("movie", movie);
		req.getRequestDispatcher("edit_movie.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String language = req.getParameter("language");
		// to receive the picture from the frontend

		Part picture = req.getPart("picture");

		String genre = req.getParameter("genre");
		Movie_DAO dao = new Movie_DAO();

		try {
			double rating = Double.parseDouble(req.getParameter("rating"));

			Movie movie = dao.findMovie(id);
			movie.setLanguage(language);
			movie.setGenre(genre);
			movie.setName(name);
			movie.setRating(rating);

			byte[] image = new byte[picture.getInputStream().available()];
			picture.getInputStream().read(image);
			
			if(image.length>0)
			movie.setPicture(image);

			dao.updateMovie(movie);

			resp.getWriter().print("<h1 align='center' style='color:red'>Movie Updated Successfully</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);

		}

		catch (NumberFormatException e) {
			resp.getWriter().print("<h1 align='center'>Enter Proper Id</h1>");
			req.getRequestDispatcher("edit-movie").include(req, resp);
		}
	}

}
