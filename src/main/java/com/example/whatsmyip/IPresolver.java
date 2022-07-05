package com.example.whatsmyip;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/caller")
public class IPresolver {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject hello() {
        JsonObject jsonObject = null;
        Response response = ClientBuilder.newBuilder()
            .build()
            .target("https://api.myip.com")
            .path("/")
            .request(MediaType.TEXT_HTML)
            .accept(MediaType.TEXT_HTML)
            .get(Response.class);
        if(response.getStatus() == Response.Status.OK.getStatusCode()) {
            try (JsonReader reader = Json.createReader(new StringReader(response.readEntity(String.class)))) {
                jsonObject = reader.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.close();
        return jsonObject;
    }
}
