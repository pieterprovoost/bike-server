package be.pieterprovoost.bike.server;


import be.pieterprovoost.bike.engine.BikePoint;
import be.pieterprovoost.bike.engine.Engine;
import com.cedarsoftware.util.io.JsonWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Produces("text/plain")
    public Response getPath(@QueryParam("from") String from, @QueryParam("to") String to) {
        String begin = engine.getClosest(from);
        String end = engine.getClosest(to);
        List<BikePoint> path = engine.getPath(begin, end);

        JSONObject o = new JSONObject();
        JSONArray a = new JSONArray();

        for (BikePoint point : path) {
            JSONObject p = new JSONObject();
            p.put("number", point.getNumber());
            p.put("distance", point.getDistance());
            a.put(p);
        }

        o.put("path", a);
        String output = o.toString();
        try {
            output = JsonWriter.formatJson(o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(output).build();
    }

}
