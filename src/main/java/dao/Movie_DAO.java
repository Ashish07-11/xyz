package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Movie;


public class Movie_DAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mahesh");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveMovie(Movie movie)
	{
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	}
	
	public List<Movie> fetchMovies(){
		//return manager.createNativeQuery("select * from Movie, Movie.class").getResultList();    --------SQL Query
		return manager.createQuery("select x from Movie x").getResultList();
	}
	
	public List<Movie> fetchMoviesById(int id){
		return manager.createQuery("select x from Movie x where id=?1").setParameter(1, id).getResultList();
	}
	
	
	public List<Movie> fetchMoviesByRating(double rating){
		return manager.createQuery("select x from Movie x where rating >= ?1").setParameter(1, rating).getResultList();
	}
	
	public List<Movie> fetchMoviesByName(String name){
		return manager.createQuery("select x from Movie x where name = ?1").setParameter(1, name).getResultList();
	}
	
	public List<Movie> fetchMoviesByLanguage(String language){
		return manager.createQuery("select x from Movie x where language = ?1").setParameter(1, language).getResultList();
	}
	
	public List<Movie> fetchMoviesByGenre(String genre){
		return manager.createQuery("select x from Movie x where genre = ?1").setParameter(1, genre).getResultList();
	}
	
	public void deleteMovie(int id) {
		transaction.begin();
		manager.remove(manager.find(Movie.class, id));
		transaction.commit();
	}
	
	public Movie findMovie(int id) {
		return manager.find(Movie.class, id);
	}

	public void updateMovie(Movie movie) {
		
		
	}
}
