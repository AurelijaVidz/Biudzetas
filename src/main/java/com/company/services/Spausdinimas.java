package com.company.services;

import com.company.enums.IslaiduKategorija;
import com.company.enums.PajamuKategorija;
import com.company.model.Biudzetas;
import com.company.model.IslaiduIrasas;
import com.company.model.PajamuIrasas;

import java.util.List;

public class Spausdinimas {
    private static Biudzetas biudzetas = null;

    public static void setBiudzetas(Biudzetas biudzetas) {
        Spausdinimas.biudzetas = biudzetas;
    }

    public static void pagrindinioMeniuSpausdinimas() {
        System.out.println("Pasirinkite:\n" +
                "[1] - Ivesti informacija \n" +
                "[2] - Gauti Informacija \n" +
                "[3] - Trinti irasa \n" +
                "[4] - Baigti darba \n");
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
                "[3] - Balansas \n" +
                "[4] - Grizti i pagrindini meniu \n");
    }

    public static void pajamuIrasuSpausdinimas() {
        System.out.printf("-".repeat(80) + "\n%50s\n" + "-".repeat(80) + "\nNr.%6s%18s%14s%14s%25s\n" + "-".repeat(80) + "\n", "PAJAMU IRASAI", "Data", "Suma, Eur", "Kategorija", "Ar banke", "Papildoma inf.");

        List<PajamuIrasas> pajamuSar = biudzetas.getPajamuSar();

        if (pajamuSar.size() == 0) {
            System.out.printf("%47s", "Pajamu irasu nerasta\n");
        } else {
            for (int i = 0; i < pajamuSar.size(); i++) {
                System.out.printf("%-5d%75s", i + 1, pajamuSar.get(i).toString() + "\n");
            }
        }
        System.out.println("-".repeat(80));
    }

    public static void islaiduIrasuSpausdinimas() {
        System.out.printf("-".repeat(104) + "\n%57s" + "-".repeat(104)
                        + "\nNr.%14s%18s%14s%11s%44s\n" + "-".repeat(104) + "\n",
                "ISLAIDU IRASAI\n", "Data, laikas", "Suma, Eur", "Kategorija", "Budas", "Papildoma inf.");

        List<IslaiduIrasas> islaiduSar = biudzetas.getIslaiduSar();

        if (islaiduSar.size() == 0) {
            System.out.printf("%60s", "Islaidu irasu nerasta\n");
        } else {
            for (int i = 0; i < islaiduSar.size(); i++) {
                System.out.printf("%-5d%99s", i + 1, islaiduSar.get(i).toString() + "\n\n");
            }
        }
        System.out.println("-".repeat(104));
    }

    public static void balansoSpausdinimas() {
        System.out.printf("BIUDZETO BALANSAS: %10.2f Eur\n\n", biudzetas.balansas());
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

    public static void trynimoMeniuSpausdinimas() {
        System.out.println("Pasirinkite:\n" +
                "[1] - Pajamu iraso trynimas \n" +
                "[2] - Islaidu iraso trynimas \n");
    }

}