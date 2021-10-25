package com.example.listazakupow3pmodyfikowalna;

public class Produkt {
    private String nazwa;
    private boolean zaznaczony;

    public Produkt(String nazwa) {
        this.nazwa = nazwa;
        zaznaczony = false;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public boolean isZaznaczony() {
        return zaznaczony;
    }

    public void setZaznaczony(boolean zaznaczony) {
        this.zaznaczony = zaznaczony;
    }
}
