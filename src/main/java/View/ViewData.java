/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author micha
 */
import Controller.Controller;
import javax.swing.*;
import java.awt.event.*;

public class ViewData extends JFrame {
    
    Controller controller
            = new Controller();
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JLabel labelInputNama = new JLabel("Nama");
    JTextField InputNama = new JTextField();
    JLabel labelInputPosisi = new JLabel("Path");
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
    JButton btnAdd = new JButton("Add");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    int selectedId = -1;
    
    public ViewData() {
        setTitle("Data Recruitment");
        setSize(900, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        table.setModel(controller.showData());
        scrollPane.setBounds(20, 20, 580, 400);
        add(scrollPane);
        add(labelInputNama);
        labelInputNama.setBounds(650, 20, 100, 20);
        add(InputNama);
        InputNama.setBounds(650, 45, 180, 25);
        add(labelInputPosisi);
        labelInputPosisi.setBounds(650, 80, 100, 20);
        add(ComboPosisi);
        ComboPosisi.setBounds(650, 105, 180, 25);
        add(labelInputWriting);
        labelInputWriting.setBounds(650, 140, 100, 20);
        add(InputWriting);
        InputWriting.setBounds(650, 165, 180, 25);
        add(labelInputCoding);
        labelInputCoding.setBounds(650, 200, 100, 20);
        add(InputCoding);
        InputCoding.setBounds(650, 225, 180, 25);
        add(labelInputInterview);
        labelInputInterview.setBounds(650, 260, 100, 20);
        add(InputInterview);
        InputInterview.setBounds(650, 285, 180, 25);
        add(btnAdd);
        btnAdd.setBounds(650, 330, 180, 30);
        add(btnUpdate);
        btnUpdate.setBounds(650, 365, 180, 30);
        add(btnDelete);
        btnDelete.setBounds(650, 400, 180, 30);
        add(btnClear);
        btnClear.setBounds(650, 435, 180, 30);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = table.getSelectedRow();
                selectedId = Integer.parseInt(
                        table.getValueAt(baris, 0).toString()
                );
                InputNama.setText(table.getValueAt(baris, 1).toString());
                ComboPosisi.setSelectedItem(
                        table.getValueAt(baris, 2).toString());
                InputWriting.setText(
                        table.getValueAt(baris, 3).toString());
                InputCoding.setText(table.getValueAt(baris, 4).toString());
                InputInterview.setText(table.getValueAt(baris, 5).toString());
            }
        });
        btnAdd.addActionListener(e -> {
            try {
                controller.insert(InputNama.getText(),
                        ComboPosisi.getSelectedItem().toString(),
                        Integer.parseInt(InputWriting.getText()),
                        Integer.parseInt(InputCoding.getText()),
                        Integer.parseInt(InputInterview.getText())
                );
                JOptionPane.showMessageDialog(null, "Successfully added data");
                refreshTable();
                clearForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Input salah");
            }
        });
        btnUpdate.addActionListener(e -> {
            if (selectedId == -1) {
                JOptionPane.showMessageDialog(null, "Choose data from table");
                return;
            }
            try {
                String nama = InputNama.getText();
                String path = ComboPosisi.getSelectedItem().toString();
                int writing = Integer.parseInt(InputWriting.getText());
                int coding = Integer.parseInt(InputCoding.getText());
                int interview = Integer.parseInt(InputInterview.getText());
                controller.update(selectedId, nama, path, writing, coding, interview);
                
                JOptionPane.showMessageDialog(null, "Update Succesfully");
                refreshTable();
                clearForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Wrong Input" + ex.getMessage());
            }
        });
        btnDelete.addActionListener(e -> {
            if (selectedId == -1) {
                JOptionPane.showMessageDialog(null, "Choose data from table");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Yakin hapus data?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.delete(selectedId);
                JOptionPane.showMessageDialog(null,
                        "Data berhasil dihapus");
                refreshTable();
                clearForm();
            }
        });
        btnClear.addActionListener(e -> {
            clearForm();
        });
        setVisible(true);
    }
    
    void refreshTable() {
        table.setModel(controller.showData());
    }
    
    void clearForm() {
        selectedId = -1;
        InputNama.setText("");
        ComboPosisi.setSelectedIndex(0);
        InputWriting.setText("");
        InputCoding.setText("");
        InputInterview.setText("");
    }
}
