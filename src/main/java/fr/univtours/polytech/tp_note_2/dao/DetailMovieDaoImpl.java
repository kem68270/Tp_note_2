package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.detailMovie.Description;
import fr.univtours.polytech.tp_note_2.model.detailMovie.WsDetailMovieResult;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class DetailMovieDaoImpl implements DetailMovieDao {

    private static String URL = "https://imdb.iamidiotareyoutoo.com/search";

    
    @Override
    public List<Description> getMoviesDescriptions(String title) {
         Client client = ClientBuilder.newClient();


    WebTarget target = client.target(URL);

    target = target.queryParam("q", title);

    System.out.println(target.getUri());
    WsDetailMovieResult wsResult = target.request(MediaType.APPLICATION_JSON).get(WsDetailMovieResult.class);
    client.close();
    return wsResult.getDescription();
    }

}
