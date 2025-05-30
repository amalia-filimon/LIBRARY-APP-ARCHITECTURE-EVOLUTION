package com.server.Service;

public interface IAngajat {
    public void vizualizareListaCarti();
    public void filtrareDupaDomeniu();
    public void filtrareDupaDisponibilitate();
    public void filtrareDupaEditura();
    public void filtrareDupaAutor();
    public void filtrareDupaPret();
    public void cautareCarteDupaTitlu();
    public void vanzareCarte();
    public void adaugareCarte();
    public void stergereCarte();
    public void actualizareCarte();
    public void salvareTXT();
    public void salvareJSON();
    public void salvareCSV();
    public void salvareXML();
}
