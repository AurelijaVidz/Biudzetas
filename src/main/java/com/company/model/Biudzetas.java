package com.company.model;

public class Biudzetas {
    private PajamuIrasas pajamos[] = new PajamuIrasas[100];
    private IslaiduIrasas islaidos[] = new IslaiduIrasas[100];
    private short pajamuIrasuSk = 0;
    private short islaiduIrasuSk = 0;

    public void pridetiPajamuIrasa(PajamuIrasas naujosPajamos) {
        pajamos[pajamuIrasuSk] = naujosPajamos;
        pajamuIrasuSk++;
    }

    public void pridetiIslaiduIrasa(IslaiduIrasas naujosIslaidos) {
        islaidos[islaiduIrasuSk] = naujosIslaidos;
        islaiduIrasuSk++;
    }

    public PajamuIrasas gautiPajamuIrasa(int i) {
        return pajamos[i];
    }

    public IslaiduIrasas gautiIslaiduIrasa(int i) {
        return islaidos[i];
    }

    public short gautiPajamuIrasuSk() {
        return pajamuIrasuSk;
    }

    public short gautiIslaiduIrasuSk() {
        return islaiduIrasuSk;
    }
}
