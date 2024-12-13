package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;
import fr.univtours.polytech.tp_note_2.model.MovieBean;

public interface MovieDao {
    List<MovieBean> getAllMovies();
    void updateMovie(MovieBean movie);
    void createMovie(MovieBean movie);
}
