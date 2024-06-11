package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import dao.Movie_DAO;
import dto.Movie;

@WebServlet("/insert-movie")
@MultipartConfig
public class InsertMovie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("insert.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String language = req.getParameter("language");
		// to receive the picture from the frontend..

		Part picture = req.getPart("picture");

		String genre = req.getParameter("genre");

		try {
			double rating = Double.parseDouble(req.getParameter("rating"));

			Movie mv = new Movie();
			mv.setLanguage(language);
			mv.setGenre(genre);
			mv.setName(name);
			mv.setRating(rating);

			mv.setDoj("2024-05-01");

			byte[] image = new byte[picture.getInputStream().available()];
			picture.getInputStream().read(image);
			mv.setPicture(image);

			Movie_DAO dao = new Movie_DAO();
			dao.saveMovie(mv);

			resp.getWriter().print("<h1 align='center' style='color:green'>Movie Added Successfully</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);

		}

		catch (NumberFormatException e) {
			resp.getWriter().print("<h1 align='center'>Enter Proper Rating</h1>");
			req.getRequestDispatcher("insert.html").include(req, resp);
		}

	}
}