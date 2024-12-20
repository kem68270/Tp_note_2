package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext(unitName = "Movie")
    private EntityManager entityManager;

    @Override
    public List<MovieBean> getAllMovies() {
        Query requete = entityManager.createNativeQuery("select * from moviebean", MovieBean.class);
        return requete.getResultList();
    }

    @Override
    public void updateMovie(MovieBean movie) {
        MovieBean existingMovie = entityManager.find(MovieBean.class, movie.getId());
        if (existingMovie != null) {
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setNote(movie.getNote());
            entityManager.merge(existingMovie);
        }
    }

    @Override
    public void createMovie(MovieBean movie) {
        entityManager.persist(movie);
    }

    @Override
    public MovieBean getMovieById(int id) {
        return entityManager.find(MovieBean.class, id);
    }

    @Override
    public void deleteMovie(int id) {
        MovieBean movie = entityManager.find(MovieBean.class, id);
        if (movie != null) {
            entityManager.remove(movie);
        }
    }
}

