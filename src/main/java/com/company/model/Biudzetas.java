package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Biudzetas {
    private List<PajamuIrasas> pajamuSar = new ArrayList<>();
    private List<IslaiduIrasas> islaiduSar = new ArrayList<>();

    public void pridetiPajamuIrasa(PajamuIrasas naujosPajamos) {
        pajamuSar.add(naujosPajamos);
    }

    public void pridetiIslaiduIrasa(IslaiduIrasas naujosIslaidos) {
        islaiduSar.add(naujosIslaidos);
    }

    public void trintiPajamuIrasa(int i) {
        pajamuSar.remove(i - 1);
    }

    public void trintiIslaiduIrasa(int i) {
        islaiduSar.remove(i - 1);
    }

    public List<PajamuIrasas> getPajamuSar() {
        return pajamuSar;
    }

    public List<IslaiduIrasas> getIslaiduSar() {
        return islaiduSar;
    }

    public double balansas() {
        double balansas = pajamuSar.stream()
                .map((irasas) -> irasas.getSuma())
                .reduce(0., (pajamos, pajIrasas) -> pajamos + pajIrasas)
                - islaiduSar.stream()
                .map((irasas) -> irasas.getSuma())
                .reduce(0., (islaidos, islIrasas) -> islaidos + islIrasas);
        return balansas;
    }
}