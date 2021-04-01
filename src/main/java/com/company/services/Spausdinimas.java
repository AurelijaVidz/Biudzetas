package com.company.services;

import com.company.enums.IslaiduKategorija;
import com.company.enums.PajamuKategorija;
import com.company.model.Biudzetas;

public class Spausdinimas {
    private static Biudzetas biudzetas = null;

    public static void setBiudzetas(Biudzetas biudzetas) {
        Spausdinimas.biudzetas = biudzetas;
    }

    public static void pagrindinioMeniuSpausdinimas() {
        System.out.println("Pasirinkite:\n" +
                "[1] - Ivesti informacija \n" +
                "[2] - Gauti Informacija \n" +
                "[3] - Baigti darba \n");
    }

    public static void ivedimoMeniuSpausdinimas() {
        System.out.println("Pasirinkite: \n" +
                "[1] - Ivesti pajamas \n" +
                "[2] - Ivesti islaidas \n" +
                "[3] - Grizti i pagrindini meniu \n");
    }

    public static void informacijosGavimoMeniuSpausdinimas() {
        System.out.println("Pasirinkite, kokia informacija norite gauti:\n" +
                "[1] - Pajamu irasai \n" +
                "[2] - Islaidu irasai \n" +
                "[3] - Grizti i pagrindini meniu \n");
    }

    public static void pajamuIrasuSpausdinimas() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("                              PAJAMU IRASAI");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Data         Suma, Eur    Kategorija      Ar banke           Papildoma inf.");
        System.out.println("---------------------------------------------------------------------------");
        if (biudzetas.gautiPajamuIrasuSk() == 0) {
            System.out.printf("%47s", "Pajamu irasu nerasta\n");
        } else {
            for (int i = 0; i < biudzetas.gautiPajamuIrasuSk(); i++) {
                System.out.println(biudzetas.gautiPajamuIrasa(i).toString() + "\n");
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void islaiduIrasuSpausdinimas() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("                                          ISLAIDU IRASAI");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Data, laikas         Suma, Eur    Kategorija      Budas                              Papildoma inf.");
        System.out.println("---------------------------------------------------------------------------------------------------");
        if (biudzetas.gautiIslaiduIrasuSk() == 0) {
            System.out.printf("%55s", "Islaidu irasu nerasta\n");
        } else {
            for (int i = 0; i < biudzetas.gautiIslaiduIrasuSk(); i++) {
                System.out.println(biudzetas.gautiIslaiduIrasa(i).toString() + "\n");
            }
        }
            System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public static void arIBankaMeniuSpausdinimas() {
        System.out.println("Ar pajamos pervestos i banka? : \n" +
                "[1] - Ne \n" +
                "[2] - Taip \n");
    }

    public static void atsiskaitymoBudoMeniuSpausdinimas() {
        System.out.println("Pasirinkite islaidu atsiskaitymo buda: \n" +
                "[1] - Grynais \n" +
                "[2] - Bankiniu pavedimu \n");
    }

    public static void islaiduKategorijosMeniuSpausdinimas() {
        System.out.println("Pasirinkite kategorija:");
        for (int i = 0; i < IslaiduKategorija.values().length; i++) {
            System.out.printf("[%d] - %s \n", i + 1, IslaiduKategorija.values()[i].toString());
        }
    }

    public static void pajamuKategorijosMeniuSpausdinimas() {
        System.out.println("Pasirinkite kategorija:");
        for (int i = 0; i < PajamuKategorija.values().length; i++) {
            System.out.printf("[%d] - %s \n", i + 1, PajamuKategorija.values()[i].toString());
        }
    }
}
