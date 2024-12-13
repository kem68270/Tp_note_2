package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.detailMovie.Description;

public interface DetailMovieBusiness {
    public List<Description> getMoviesDescriptions(String title);
}
