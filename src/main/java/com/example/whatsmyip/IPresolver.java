package com.example.whatsmyip;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;


@Path("/caller")
public class IPresolver {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<MyIp> hello() {
        MyIp myIp=null;
        Response response = ClientBuilder.newClient()
            .target("https://api.myip.com")
            .path("/")
            .request(MediaType.TEXT_HTML)
            .accept(MediaType.TEXT_HTML)
            .get();
        if(response.getStatus() == Response.Status.OK.getStatusCode()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                myIp = mapper.readValue(new StringReader(response.readEntity(String.class)), MyIp.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.ofNullable(myIp);
    }
}