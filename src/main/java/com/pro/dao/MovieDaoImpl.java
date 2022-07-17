package com.pro.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.entity.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	SessionFactory factory;

	@Override
	public boolean addMovie(Movie entity) {

		Session session = null;

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(entity);

			tx.commit();
			return true;

		} catch (Exception e) {

			System.out.println("Unable to store movie into database!!!");
			e.printStackTrace();
			return false;

		} finally {
			session.close();
		}
	}

	@Override
	public List<Movie> getMovies() {

		Session session = null;
		List<Movie> list = new ArrayList<>();
		String q = "from Movie";

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createQuery(q);
			list = query.list();

			tx.commit();
			return list;

		} catch (Exception e) {

			System.out.println("failed to retrive the movies from table!!!");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Movie getMovie(int Id) {

		Session session = null;
		Movie movie = new Movie();
		String q = "from Movie as movie where movie.Id = :Id";

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Query<Movie> query = session.createQuery(q);
			query.setParameter("Id", Id);
			movie = query.uniqueResult();

			tx.commit();
			return movie;

		} catch (Exception e) {

			System.out.println("failed get movie details of Id : " + Id);
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteMovie(int Id) {

		Session session = null;
		String q = "delete from Movie as m where m.Id =" + Id;

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Query<Movie> query = session.createQuery(q);
			query.executeUpdate();

			tx.commit();
			return true;

		} catch (Exception e) {

			System.out.println("failed to delete Movie from database");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateMovie(int Id, Movie entity) {

		Session session = null;
		String q = "UPDATE Movie SET releaseDate = :releaseDate, movie_name = :movie_name where Id = :Id";

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Query<Movie> query = session.createQuery(q);
			query.setParameter("releaseDate", entity.getReleaseDate());
			query.setParameter("movie_name", entity.getMovie_name());
			query.setParameter("Id", Id);

			query.executeUpdate();

			tx.commit();
			return true;

		} catch (Exception e) {

			System.out.println("failed to update Movie in database!!!");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
