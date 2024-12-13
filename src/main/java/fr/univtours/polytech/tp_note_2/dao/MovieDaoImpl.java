package fr.univtours.polytech.tp_note_2.dao;

import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext(unitName = "Movie")
    private EntityManager entityManager;

    @Override
    public List<MovieBean> getAllMovies() {
        TypedQuery<MovieBean> query = entityManager.createQuery("SELECT m FROM Movie m", MovieBean.class);
        return query.getResultList();
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
}

