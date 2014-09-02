package be.pieterprovoost.bike.server;

import be.pieterprovoost.bike.engine.BikePoint;
import be.pieterprovoost.bike.engine.Engine;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.jaxrs.json.annotation.JacksonFeatures;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api")
public class BikeService {

    private Engine engine;

    public BikeService() {
        engine = new Engine();
    }

    @GET
    @Path("/path")
    @JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPath(@QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("callback") String callback) {
        String begin;
        String end;
        try {
            if (from.matches("[0-9]+\\.[0-9]+,[0-9]+\\.[0-9]+")) {
                String[] parts = from.split(",");
                Double latitude = Double.parseDouble(parts[0]);
                Double longitude = Double.parseDouble(parts[1]);
                begin = engine.getClosest(latitude, longitude);
            } else {
                begin = engine.getClosest(from);
            }
            if (to.matches("[0-9]+\\.[0-9]+,[0-9]+\\.[0-9]+")) {
                String[] parts = to.split(",");
                Double latitude = Double.parseDouble(parts[0]);
                Double longitude = Double.parseDouble(parts[1]);
                end = engine.getClosest(latitude, longitude);
            } else {
                end = engine.getClosest(to);
            }
        } catch (Exception e) {
            return Response.status(422).build();
        }
        List<BikePoint> path = engine.getPath(begin, end);
        if (callback != null) {
            JSONPObject jpo = new JSONPObject(callback, path);
            return Response.status(200).entity(jpo).build();
        }
        return Response.status(200).entity(path).build();
    }

}
