package io.logicojp.example;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record GeoIp(String ip,
                    String continent_code,
                    String country,
                    String country_code,
                    String country_code3,
                    String region,
                    String region_code,
                    String city,
                    String postal_code,
                    String latitude,
                    String longitude,
                    String timezone,
                    int offset,
                    int asn,
                    String organization) { }
