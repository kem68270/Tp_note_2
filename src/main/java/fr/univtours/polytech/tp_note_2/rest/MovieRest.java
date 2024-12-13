package fr.univtours.polytech.tp_note_2.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("V1")
public class MovieRest {

    @EJB
    MovieBusiness movieBusiness;

    
    @Path("movies")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<MovieBean> getMovies(@QueryParam("tri") String tri, @QueryParam("filtre") String filtre) {
        List<MovieBean> movies = this.movieBusiness.getMovies();
        List<MovieBean> results = new ArrayList<MovieBean>();
        if (null != filtre && !"".equals(filtre)) {
            filtre.toLowerCase();
            for (MovieBean movie : movies) {
                if (filtre.contains(movie.getTitle().toLowerCase())) {
                    results.add(movie); 
                }
                if (filtre.equals(String.valueOf(movie.getNote())));
            }
        } else {
            results = movies;
        }

        if ("asc".equals(tri)) {
            Collections.sort(results, (a, b) -> a.getNote() < b.getNote() ? -1 : 1);
        }
        if ("desc".equals(tri)) {
            Collections.sort(results, (a, b) -> a.getNote() < b.getNote() ? 1 : -1);
        }

        return results;
    }

    @GET
    @Path("movies/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public MovieBean getLocation(@PathParam("id") Integer idMovie) {
        MovieBean movieBean = this.movieBusiness.getMovieById(idMovie);
        return movieBean;
    }

    @DELETE
    @Path("movies/{id}")
    public Response deleteLocation(@PathParam("id") Integer idMovie,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        if (!"42".equals(auth)) {
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            MovieBean locationBean = this.movieBusiness.getMovieById(idMovie);
            if (null == locationBean) {
                return Response.status(Status.NOT_FOUND).build();
            } else {
                this.movieBusiness.deleteMovie(idMovie);
                return Response.status(Status.NO_CONTENT).build();
            }
        }
    }

  //Méthode appelée lorsqu'on ajoute toutes les informations dans le corps de la requête.
    @POST
    @Path("movies")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response createMovie(MovieBean movieBean) {
        if (movieBean.getTitle() == null || movieBean.getTitle().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Title is required.")
                        .build();
        }

        if (movieBean.getNote() != null && (movieBean.getNote() < 1 || movieBean.getNote() > 5)) {
            return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Note must be between 1 and 5.")
                        .build();
        }
        this.movieBusiness.createMovie(movieBean);

        return Response.status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("movies/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response fullUpdateMovie(@PathParam("id") Integer idMovie, MovieBean movieBean) {
        MovieBean oldMovieBean = this.movieBusiness.getMovieById(idMovie);
        if (null == oldMovieBean) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        oldMovieBean.setTitle(movieBean.getTitle());
        oldMovieBean.setAnnee(movieBean.getAnnee());
        oldMovieBean.setActeur(movieBean.getActeur());
        oldMovieBean.setPoster(movieBean.getPoster());

        if (movieBean.getNote() != null && movieBean.getNote() >= 1 && movieBean.getNote() <= 5) {
            oldMovieBean.setNote(movieBean.getNote());
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Note must be between 1 and 5.")
                        .build();
        }


        this.movieBusiness.updateMovie(oldMovieBean);

        return Response.status(Response.Status.ACCEPTED).build();
    }


    @PATCH
    @Path("movies/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response partialUpdateMovie(@PathParam("id") Integer idMovie, MovieBean movieBean) {
        MovieBean oldMovieBean = this.movieBusiness.getMovieById(idMovie);
        if (null == oldMovieBean) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (null != movieBean.getTitle() && !movieBean.getTitle().isEmpty()) {
            oldMovieBean.setTitle(movieBean.getTitle());
        }
        if (null != movieBean.getAnnee()) {
            oldMovieBean.setAnnee(movieBean.getAnnee());
        }
        if (null != movieBean.getActeur() && !movieBean.getActeur().isEmpty()) {
            oldMovieBean.setActeur(movieBean.getActeur());
        }
        if (null != movieBean.getPoster() && !movieBean.getPoster().isEmpty()) {
            oldMovieBean.setPoster(movieBean.getPoster());
        }
        if (null != movieBean.getNote()) {
            int note = movieBean.getNote();
            if (note >= 1 && note <= 5) {
                oldMovieBean.setNote(note);
            }
        }

        this.movieBusiness.updateMovie(oldMovieBean);

        return Response.status(Response.Status.ACCEPTED).build();
}

}
