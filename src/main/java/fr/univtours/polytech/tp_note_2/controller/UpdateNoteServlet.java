package fr.univtours.polytech.tp_note_2.controller;

import java.io.IOException;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import fr.univtours.polytech.tp_note_2.dao.MovieDao;
import fr.univtours.polytech.tp_note_2.model.MovieBean;

@WebServlet("/updateNote")
public class UpdateNoteServlet extends HttpServlet {

    @Inject
    private MovieDao movieDao; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmIdStr = request.getParameter("id");
        String action = request.getParameter("action");

        try {
            int filmId = Integer.parseInt(filmIdStr);
            MovieBean movie = movieDao.getMovieById(filmId);

            if (movie != null) {
                boolean updated = updateMovieNote(movie, action);
                if (updated) {
                    movieDao.updateMovie(movie);  
                }
                response.sendRedirect("movieList"); 
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Film not found");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid film ID");
        }
    }

    /**
     * Met à jour la note du film si elle respecte les règles RG1 et RG3.
     * 
     * @param movie  Le film à mettre à jour
     * @param action L'action ("increase" ou "decrease")
     * @return true si la note a été mise à jour, false sinon
     */
    private boolean updateMovieNote(MovieBean movie, String action) {
        Integer currentNote = movie.getNote();

        /*Si y a pas de note */
        if (currentNote == null) {
            if ("increase".equals(action)) {
                movie.setNote(1); // RG1
            } else if ("decrease".equals(action)) {
                movie.setNote(5); // RG3
            }
            return true;
        }

        
        if ("increase".equals(action) && currentNote < 5) {
            movie.setNote(currentNote + 1); // Incrémente la note
            return true;
        } else if ("decrease".equals(action) && currentNote > 1) {
            movie.setNote(currentNote - 1); // Décrémente la note
            return true;
        }
        return false; // La note n'est pas modifiée
    }
}
