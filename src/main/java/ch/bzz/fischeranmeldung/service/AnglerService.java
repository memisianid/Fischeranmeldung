package ch.bzz.fischeranmeldung.service;


import ch.bzz.fischeranmeldung.data.DataHandler;
import ch.bzz.fischeranmeldung.model.Angler;
import ch.bzz.fischeranmeldung.model.Fische;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Serviceclass with two service which are listing angler and reading fisher
 *
 * M133: Fischeranmeldung
 *
 * @date 08.03.2021
 * @author Anid Memisi
 * @version 1.0
 */

@Path("angler")
public class AnglerService {

    /**
     *
     * gets the list of Angler
     * @return Response
     */
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAngler () {
        Map<String, Angler> anglerMap = DataHandler.getAnglerMap();
        Response response = Response
                .status(200)
                .entity(anglerMap)
                .build();
        return response;
    }

    /**
     *
     * reads all fischer
     * @param fischerLizenz
     * @return Response
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response ReadDecks(@QueryParam("fischerLizenz") Integer fischerLizenz){
        Angler angler = null;
        int httpStatus;

        try {
            angler = DataHandler.readAngler(angler.getLizenz());

            if(angler.getLizenz() == null){
                httpStatus = 404;
            } else {
                httpStatus = 200;
            }
        } catch(IllegalArgumentException e){
            httpStatus = 400;
        }

        Response response = Response
                .status(httpStatus)
                .entity(angler)
                .build();
        return  response;
    }
}
