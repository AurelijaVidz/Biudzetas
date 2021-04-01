package com.company.model;

import com.company.enums.IslaiduKategorija;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PajamuIrasas {
    private double suma;
    private LocalDate data;
    private int kategorija;
    private boolean pozymisArIBanka;
    private String papildomaInfo;

    public PajamuIrasas(double suma, LocalDate data, int kategorija, boolean pozymisArIBanka, String papildomaInfo) {
        this.suma = suma;
        this.data = data;
        this.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
    }

    public double getSuma() {
        return suma;
    }

    public LocalDate getData() {
        return data;
    }

    public int getKategorija() {
        return kategorija;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    @Override
    public String toString() {
        DateTimeFormatter datosFormatas = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String kategorijaZodine = IslaiduKategorija.values()[kategorija - 1].toString();
        String pozymisArIBankaSimbolis;
        StringBuilder papildomaInfoSkaidyta;

        // Pozymio ar i banka keitima i simbolius
        if (pozymisArIBanka)
            pozymisArIBankaSimbolis = "✓";
        else
            pozymisArIBankaSimbolis = "✗";

        // Visu kintamuju, isskyrus papildomos inf. suliejimas i tekstine eilute
        String str = String.format("%-12s %-12s %-15s %-8s", data.format(datosFormatas).toString(), Double.toString(suma), kategorijaZodine, pozymisArIBankaSimbolis);

        // Papildomos informacijos skaidymas
        if (papildomaInfo.length() > 25) {
            papildomaInfoSkaidyta = new StringBuilder(papildomaInfo);
            int i, j;
            for (i = 0, j = 0; i + 25 < papildomaInfoSkaidyta.length() && (i = papildomaInfoSkaidyta.lastIndexOf(" ", i + 25)) != -1; ) {
                papildomaInfoSkaidyta.replace(i, i + 1, "\n");

                if (j == 0) {
                    str += String.format("%25s\n", papildomaInfoSkaidyta.substring(j, i));
                } else {
                    str += String.format("%75s\n", papildomaInfoSkaidyta.substring(j + 1, i));
                }
                j = i;
            }
            str += String.format("%75s", papildomaInfoSkaidyta.substring(i + 1, papildomaInfoSkaidyta.length()));
        } else {
            str += String.format("%25s", papildomaInfo);
        }

        return str;
    }
}