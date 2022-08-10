package io.logicojp.example;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

@Client("https://ip.seeip.org/geoip")
public interface WhatsMyIpClient {
    @Get(consumes = MediaType.APPLICATION_JSON)
    @SingleResult
    Publisher<GeoIp> getMyIpText();
}
