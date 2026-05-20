/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import javax.swing.*;

public class EditData extends JFrame {

    Controller controller;
    JLabel labelInputNama = new JLabel("Nama");
    JTextField InputNama = new JTextField();
    JLabel labelInputPosisi = new JLabel("Posisi");
    JComboBox ComboPosisi
            = new JComboBox(new String[]{
        "Android Developer",
        "Web Developer"
    });
    JLabel labelInputWriting = new JLabel("Writing");
    JTextField InputWriting = new JTextField();
    JLabel labelInputCoding = new JLabel("Coding");
    JTextField InputCoding = new JTextField();
    JLabel labelInputInterview = new JLabel("Interview");
    JTextField InputInterview = new JTextField();
    JButton button = new JButton("Tambah");

    public EditData() {
        setTitle("Input Data");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        add(labelInputNama);
        labelInputNama.setBounds(20, 20, 100, 20);
        add(InputNama);
        InputNama.setBounds(140, 20, 200, 20);
        add(labelInputPosisi);
        labelInputPosisi.setBounds(20, 60, 100, 20);
        add(ComboPosisi);
        ComboPosisi.setBounds(140, 60, 200, 20);
        add(labelInputWriting);
        labelInputWriting.setBounds(20, 100, 100, 20);
        add(InputWriting);
        InputWriting.setBounds(140, 100, 200, 20);
        add(labelInputCoding);
        labelInputCoding.setBounds(20, 140, 100, 20);
        add(InputCoding);
        InputCoding.setBounds(140, 140, 200, 20);
        add(labelInputInterview);
        labelInputInterview.setBounds(20, 180, 100, 20);
        add(InputInterview);
        InputInterview.setBounds(140, 180, 200, 20);
        add(button);
        button.setBounds(120, 240, 120, 30);
        button.addActionListener(e -> {
            try {
                controller.insert(
                        InputNama.getText(),
                        ComboPosisi.getSelectedItem().toString(),
                        Integer.parseInt(InputWriting.getText()),
                        Integer.parseInt(InputCoding.getText()),
                        Integer.parseInt(InputInterview.getText())
                );
                JOptionPane.showMessageDialog(null,
                        "Data Berhasil Ditambah");
                dispose();
                new ViewData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Input Salah"
                        + ex.getLocalizedMessage());
            }
        });
        setVisible(true);
    }
};
