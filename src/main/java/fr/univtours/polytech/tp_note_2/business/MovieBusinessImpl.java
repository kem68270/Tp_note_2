package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.dao.MovieDao;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MovieBusinessImpl implements MovieBusiness {

    @Inject
    MovieDao movieDao;

    @Override
    public void createMovie(MovieBean movieBean) {
       movieDao.createMovie(movieBean);
        
    }

    @Override
    public void deleteMovie(Integer id) {
         movieDao.deleteMovie(id);
        
    }

    @Override
    public MovieBean getMovie(Integer id) {
       return new MovieBean();
        
    }

    @Override
    public List<MovieBean> getMovies() {
        
        return movieDao.getAllMovies();
    }

    @Override
    public void updateMovie(MovieBean movieBean) {
        
    }

}
