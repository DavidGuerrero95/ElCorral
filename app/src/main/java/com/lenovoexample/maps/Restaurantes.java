package com.lenovoexample.maps;

public class Restaurantes {

    private String restaurante;
    private String info;
    private int foto;

    public Restaurantes(){

    }

    public Restaurantes(String restaurante, String info, int foto) {
        this.restaurante = restaurante;
        this.info = info;
        this.foto = foto;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
