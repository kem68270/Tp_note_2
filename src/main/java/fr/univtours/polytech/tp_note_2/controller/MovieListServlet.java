package fr.univtours.polytech.tp_note_2.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tp_note_2.business.DetailMovieBusiness;
import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import fr.univtours.polytech.tp_note_2.model.detailMovie.Description;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/movieList")
public class MovieListServlet extends HttpServlet{

    @Inject
    MovieBusiness movieBusiness;

    @Inject
    DetailMovieBusiness detailMovieBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MovieBean> listMovie = movieBusiness.getMovies();
        String acteur;
        Integer annee;
        String poster;
        Description description;
        request.setAttribute("films", listMovie);

        for (MovieBean movie : listMovie ) {
            description = detailMovieBusiness.getMoviesDescriptions(movie.getTitle()).get(0);
            acteur = description.getActors();
            annee = description.getYear();
            poster = description.getImgPoster();

            movie.setActeur(acteur);
            movie.setAnnee(annee);
            movie.setPoster(poster);

        }
        request.getRequestDispatcher("movie.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    

}
