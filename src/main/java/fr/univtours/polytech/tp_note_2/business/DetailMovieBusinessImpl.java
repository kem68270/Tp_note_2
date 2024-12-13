package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.dao.DetailMovieDao;
import fr.univtours.polytech.tp_note_2.model.detailMovie.Description;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DetailMovieBusinessImpl implements DetailMovieBusiness {

    @Inject
    DetailMovieDao detailMovieDao;

    @Override
    public List<Description> getMoviesDescriptions(String title) {
        return detailMovieDao.getMoviesDescriptions(title);
    }

}
