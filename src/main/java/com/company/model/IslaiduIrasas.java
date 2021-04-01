package com.company.model;

import com.company.enums.AtsiskaitymoBudas;
import com.company.enums.IslaiduKategorija;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IslaiduIrasas {
    private double suma;
    private LocalDateTime dataSuLaiku;
    private int kategorija;
    private AtsiskaitymoBudas atsiskaitymoBudas;
    private String papildomaInfo;

    public IslaiduIrasas(double suma, LocalDateTime dataSuLaiku, int kategorija, AtsiskaitymoBudas atsiskaitymoBudas, String papildomaInfo) {
        this.suma = suma;
        this.dataSuLaiku = dataSuLaiku;
        this.kategorija = kategorija;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {

        DateTimeFormatter datosLaikoFormatas = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm");
        String kategorijaZodine = IslaiduKategorija.values()[kategorija - 1].toString();
        String atsiskaitymoBudasTekstas = atsiskaitymoBudas.toString();
        StringBuilder papildomaInfoSkaidyta;

        // Visu kintamuju, isskyrus papildomos inf. suliejimas i tekstine eilute
        String str = String.format("%-20s %-12s %-15s %-8s", dataSuLaiku.format(datosLaikoFormatas).toString(), Double.toString(suma), kategorijaZodine, atsiskaitymoBudasTekstas);

        // Papildomos informacijos skaidymas
        if (papildomaInfo.length() > 25) {
            papildomaInfoSkaidyta = new StringBuilder(papildomaInfo);
            int i, j;
            for (i = 0, j = 0; i + 25 < papildomaInfoSkaidyta.length() && (i = papildomaInfoSkaidyta.lastIndexOf(" ", i + 25)) != -1; ) {
                papildomaInfoSkaidyta.replace(i, i + 1, "\n");

                if (j == 0) {
                    str += String.format("%" + (73 - str.length() + 25) + "s\n", papildomaInfoSkaidyta.substring(j, i));
                } else {
                    str += String.format("%103s\n", papildomaInfoSkaidyta.substring(j + 1, i));
                }
                j = i;
            }
            str += String.format("%103s", papildomaInfoSkaidyta.substring(i + 1, papildomaInfoSkaidyta.length()));
        } else {
            str += String.format("%" + (73 - str.length() + 25) + "s\n", papildomaInfo);
        }

        return str;
    }

    public double getSuma() {
        return suma;
    }
}