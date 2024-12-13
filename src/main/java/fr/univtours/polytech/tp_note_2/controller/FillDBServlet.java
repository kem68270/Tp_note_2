package fr.univtours.polytech.tp_note_2.controller;

import java.io.IOException;

import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fillDB")
public class FillDBServlet extends HttpServlet {

    @Inject
    private MovieBusiness movieBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        MovieBean movie1 = new MovieBean();
        movie1.setTitle("Le seigneur des anneaux");
        movie1.setNote(4);
        movieBusiness.createMovie(movie1);

        MovieBean movie2 = new MovieBean();
        movie2.setTitle("Avengers");
        movieBusiness.createMovie(movie1);

        MovieBean movie3 = new MovieBean();
        movie3.setTitle("Fast and Furious");
        movie3.setNote(1);
        movieBusiness.createMovie(movie1);

    }


}
