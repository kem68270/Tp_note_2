package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MovieBusinessImpl implements MovieBusiness {

    @Inject
    //MovieDao movieDao;

    @Override
    public void createMovie(MovieBean movieBean) {
       
        
    }

    @Override
    public void deleteMovie(Integer id) {
        
        
    }

    @Override
    public MovieBean getMovie(Integer id) {
       
        return null;
    }

    @Override
    public List<MovieBean> getMovies() {
        
        return null;
    }

    @Override
    public void updateMovie(MovieBean movieBean) {
        
    }

}
