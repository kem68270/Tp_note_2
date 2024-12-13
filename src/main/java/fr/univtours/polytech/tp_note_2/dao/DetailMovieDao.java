package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.detailMovie.Description;

public interface DetailMovieDao {
    public List<Description> getMoviesDescriptions(String title);

}
