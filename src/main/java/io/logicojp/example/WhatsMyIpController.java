package io.logicojp.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.reactivestreams.Publisher;

@Controller("/caller")
public class WhatsMyIpController {

    private final WhatsMyIpClient whatsMyIpClient;

    public WhatsMyIpController(WhatsMyIpClient whatsMyIpClient) {
        this.whatsMyIpClient = whatsMyIpClient;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    Publisher<GeoIp> sayHello() {
        return whatsMyIpClient.getMyIpText();
    }
}
