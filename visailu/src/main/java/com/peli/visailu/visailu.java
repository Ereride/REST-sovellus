package com.peli.visailu;

public class visailu {

    private int id;
    private String kysymys;
    private String vastaus;
    
    public visailu(int id, String kysymys, String vastaus) {
        this.id = id;
        this.kysymys = kysymys;
        this.vastaus = vastaus;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKysymys() {
        return this.kysymys;
    }

    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    public String getVastaus() {
        return this.vastaus;
    }

    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }

}
