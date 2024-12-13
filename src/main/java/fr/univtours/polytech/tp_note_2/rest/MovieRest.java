package fr.univtours.polytech.tp_note_2.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("v1")
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
                if (filtre.equals(String.valueOf(movie.getNote()))) {
                    results.add(movie);
                }
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
/* 

 // Méthode appelée lorsqu'on ajoute toutes les informations dans le corps de la
    // requête.
    @POST
    @Path("locations")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response createLocation(LocationBean locationBean) {
        this.locationBusiness.addLocation(locationBean);
        return Response.status(Status.ACCEPTED).build();
    }

    @PUT
    @Path("locations/{id}")
    public Response fullUpdateLocation(@PathParam("id") Integer idLocation, LocationBean locationBean) {
        LocationBean odlLocationBean = this.locationBusiness.getLocation(idLocation);
        if (null == odlLocationBean) {
            return Response.status(Status.NOT_FOUND).build();
        }

        // On met à jour tous les champs :
        odlLocationBean.setAddress(locationBean.getAddress());
        odlLocationBean.setCity(locationBean.getCity());
        odlLocationBean.setNightPrice(locationBean.getNightPrice());
        odlLocationBean.setPicture(locationBean.getPicture());
        odlLocationBean.setZipCode(locationBean.getZipCode());

        this.locationBusiness.updateLocation(odlLocationBean);
        return Response.status(Status.ACCEPTED).build();
    }

    @PATCH
    @Path("locations/{id}")
    public Response partialUpdateLocation(@PathParam("id") Integer idLocation, LocationBean locationBean) {
        LocationBean odlLocationBean = this.locationBusiness.getLocation(idLocation);
        if (null == odlLocationBean) {
            return Response.status(Status.NOT_FOUND).build();
        }

        // Seul les champs renseignés dans le bean envoyé sont mis à jour en base de données.
        if (null != locationBean.getAddress() && !"".equals(locationBean.getAddress())) {
            odlLocationBean.setAddress(locationBean.getAddress());
        }
        if (null != locationBean.getCity() && !"".equals(locationBean.getCity())) {
            odlLocationBean.setCity(locationBean.getCity());
        }
        if (null != locationBean.getNightPrice() && !"".equals(locationBean.getNightPrice())) {
            odlLocationBean.setNightPrice(locationBean.getNightPrice());
        }
        if (null != locationBean.getPicture()) {
            odlLocationBean.setPicture(locationBean.getPicture());
        }
        if (null != locationBean.getZipCode() && !"".equals(locationBean.getZipCode())) {
            odlLocationBean.setZipCode(locationBean.getZipCode());
        }

        this.locationBusiness.updateLocation(odlLocationBean);
        return Response.status(Status.ACCEPTED).build();
    }*/
}
