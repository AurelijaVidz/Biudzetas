package com.company;

import com.company.enums.AtsiskaitymoBudas;
import com.company.enums.IslaiduKategorija;
import com.company.enums.PajamuKategorija;
import com.company.model.Biudzetas;
import com.company.model.IslaiduIrasas;
import com.company.model.PajamuIrasas;
import com.company.services.Spausdinimas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Programa BIUDZETAS
 */
public class Programa {
    private static Scanner sc = new Scanner(System.in);
    private static int meniuPasirinkimas;

    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();
        boolean arTestiDarba = true, arTestiDarbaIvedimo = true, arTestiDarbaIsvedimo = true;

        meniu:
        while (arTestiDarba) {
            Spausdinimas.setBiudzetas(biudzetas);
            Spausdinimas.pagrindinioMeniuSpausdinimas();

            switch (nuskaitytiMeniuPasirinkima(1, 3)) {

                // Klaidingai ivestas meniu pasirinkimas - pakartotinai spausdinamas meniu
                case 0:
                    continue meniu;

                    // Pasirinkta '[1] - Ivesti informacija' - spausdinamas f-jos submeniu ir nuskaitomas naujas pasirinkimas
                case 1:
                    infIvedimoMeniu:
                    while (arTestiDarbaIvedimo) {
                        Spausdinimas.ivedimoMeniuSpausdinimas();
                        switch (nuskaitytiMeniuPasirinkima(1, 3)) {

                            // Klaidingai ivestas meniu pasirinkimas
                            case 0:
                                continue infIvedimoMeniu;

                                // Pajamu iraso ivedimas
                            case 1:
                                biudzetas.pridetiPajamuIrasa(pajamuIrasoIvedimas());
                                System.out.println("Pajamu irasas sekmingai pridetas.\n");
                                continue meniu;

                                // Islaidu iraso ivedimas
                            case 2:
                                biudzetas.pridetiIslaiduIrasa(islaiduIrasoIvedimas());
                                System.out.println("Islaidu irasas sekmingai pridetas. \n");
                                continue meniu;

                                // Grizti i pagrindini meniu
                            case 3:
                                continue meniu;
                        }
                    }

                    // Pasirinkta '[2] - Gauti informacija' - spausdinamas submeniu ir isspausdinama pasirinktas pajamu/islaidu sarasas
                case 2:
                    infGavimoMeniu:
                    while (arTestiDarbaIsvedimo) {
                        Spausdinimas.informacijosGavimoMeniuSpausdinimas();
                        switch (nuskaitytiMeniuPasirinkima(1, 3)) {

                            // Klaidingai ivestas meniu pasirinkimas
                            case 0:
                                continue infGavimoMeniu;
                            case 1:

                                // Spausdinamas pajamu irasu sarasas ir griztama i pagrindini meniu
                                Spausdinimas.pajamuIrasuSpausdinimas();
                                continue meniu;

                                // Spausdinamas islaidu irasu sarasas ir griztama i pagrindini meniu
                            case 2:
                                Spausdinimas.islaiduIrasuSpausdinimas();
                                continue meniu;

                                // Grizimas i pagrindini meniu
                            case 3:
                                continue meniu;
                        }
                    }

                    // Pasirinkta '[3] - Baigti darba'
                case 3:
                    sc.close();
                    exit(0);
            }
        }

    }

    // Nuskaito meniu pasirinkimo nr. is intervalo [riba1, riba2] ir grazina pasirinkima; klaidos atveju grazina 0
    private static int nuskaitytiMeniuPasirinkima(int riba1, int riba2) {
        try {
            meniuPasirinkimas = Integer.parseInt(sc.nextLine().trim());
            if (meniuPasirinkimas < riba1 || meniuPasirinkimas > riba2)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("KLaidingai pasirinkta meniu funkcija.");
            return 0;
        }
        return meniuPasirinkimas;
    }

    private static PajamuIrasas pajamuIrasoIvedimas() {
        boolean arTestiIvedima = true;

        double suma = 0;
        LocalDate data = null;
        int kategorija = -1;
        boolean pozymisArIBanka = false;
        String papildomaInfo = "";

        // Sumos ivedimas
        while (arTestiIvedima) {
            try {
                System.out.println("Iveskite gautas pajamas eurais:");
                suma = Double.parseDouble(sc.nextLine().trim());
                arTestiIvedima = false;

            } catch (NumberFormatException e) {
                System.out.println("Klaidingai ivesta suma.");
                continue;
            }
        }

        // Sumos ivedimo data
        data = LocalDate.now();

        // Kategorijos ivedimas
        arTestiIvedima = true;

        while (arTestiIvedima) {
            Spausdinimas.pajamuKategorijosMeniuSpausdinimas();
            kategorija = nuskaitytiMeniuPasirinkima(1, PajamuKategorija.values().length);

            if (kategorija == 0)
                continue;
            arTestiIvedima = false;
        }

        // Pasirinkimas, ar pajamos pervestos i banka
        arTestiIvedima = true;

        while (arTestiIvedima) {
            Spausdinimas.arIBankaMeniuSpausdinimas();
            switch (nuskaitytiMeniuPasirinkima(1, 2)) {
                case 0:
                    continue;
                case 1:
                    pozymisArIBanka = false;
                    break;
                case 2:
                    pozymisArIBanka = true;
            }
            arTestiIvedima = false;

        }

        // Papildomos informacijos ivedimas
        System.out.println("Papildoma informacija:");
        papildomaInfo = sc.nextLine();

        return new PajamuIrasas(suma, data, kategorija, pozymisArIBanka, papildomaInfo);
    }

    private static IslaiduIrasas islaiduIrasoIvedimas() {
        boolean arTestiIvedima = true;
        double suma = 0;
        LocalDateTime dataSuLaiku = null;
        int kategorija = -1;
        AtsiskaitymoBudas atsiskaitymoBudas = null;
        String papildomaInfo = "";

        // Sumos ivedimas
        while (arTestiIvedima) {
            try {
                System.out.println("Iveskite islaidas eurais:");
                suma = Double.parseDouble(sc.nextLine().trim());
                arTestiIvedima = false;

            } catch (NumberFormatException e) {
                System.out.println("Klaidingai ivesta suma.");
                continue;
            }
        }

        // Data ir laikas
        dataSuLaiku = LocalDateTime.now();

        // Islaidu kategorijos pasirinkimas
        arTestiIvedima = true;

        while (arTestiIvedima) {
            Spausdinimas.islaiduKategorijosMeniuSpausdinimas();
            switch (nuskaitytiMeniuPasirinkima(1, IslaiduKategorija.values().length)) {
                case 0:
                    continue;
                case 1:
                    kategorija = 1;
                    break;
                case 2:
                    kategorija = 2;
                    break;
                case 3:
                    kategorija = 3;
                    break;
                case 4:
                    kategorija = 4;
            }
            arTestiIvedima = false;
        }

        // Atsiskaitymo budo pasirinkimas
        arTestiIvedima = true;

        while (arTestiIvedima) {
            Spausdinimas.atsiskaitymoBudoMeniuSpausdinimas();
            switch (nuskaitytiMeniuPasirinkima(1, 2)) {
                case 0:
                    continue;
                case 1:
                    atsiskaitymoBudas = AtsiskaitymoBudas.values()[0];
                    break;
                case 2:
                    atsiskaitymoBudas = AtsiskaitymoBudas.values()[1];
            }
            arTestiIvedima = false;
        }

        // Papildomos informacijos ivedimas
        System.out.println("Papildoma informacija:");
        papildomaInfo = sc.nextLine();

        return new IslaiduIrasas(suma, dataSuLaiku, kategorija, atsiskaitymoBudas, papildomaInfo);
    }
}