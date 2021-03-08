package ch.bzz.fischeranmeldung.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * service for testing
 *
 * Deckbuilder
 *
 * @date 08.03.2021
 * @author Anid Memisi
 * @version 1.0
 */
@Path("test")
public class TestService {
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        return Response
                .status(200)
                .entity("Erfolgreich")
                .build();
    }
}
