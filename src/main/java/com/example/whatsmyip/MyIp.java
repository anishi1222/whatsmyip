package com.example.whatsmyip;

public class MyIp {
    String ip;
    String country;
    String cc;

    public MyIp(String ip, String country, String cc) {
        this.cc = cc;
        this.ip = ip;
        this.country=country;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
