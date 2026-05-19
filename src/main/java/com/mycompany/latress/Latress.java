/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.latress;

/**
 *
 * @author micha
 */
import View.MainView;

public class Latress {

    public static void main(String[] args) {
        // Identitas
        //    Nama  : Michael Bintang
        //    NIM   : 123240145
        //    Kelas : Praktikum PBO IF-F
        java.awt.EventQueue.invokeLater(() -> {

            new MainView().setVisible(true);

        });
    }
}
