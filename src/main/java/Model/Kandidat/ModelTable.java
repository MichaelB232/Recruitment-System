/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Kandidat;

/**
 *
 * @author micha
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;

import Model.Kandidat.*;

public class ModelTable extends AbstractTableModel {

    List<ModelKandidat> DaftarCandidate;
    String kolom[] = {"ID", "Nama", "Path", "Writing", "Coding",
        "Interview", "Score", "Status"};

    // Constructor
    public ModelTable(List<ModelKandidat> DaftarCandidate) {
        this.DaftarCandidate = DaftarCandidate;
    }

    @Override
    public int getRowCount() {
        return DaftarCandidate.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }
    // Untuk Merubah Data ArrayList Ke Dalam Bentuk Objek

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return DaftarCandidate.get(rowIndex).getId();
            case 1:
                return DaftarCandidate.get(rowIndex).getName();
            case 2:
                return DaftarCandidate.get(rowIndex).getPath();
            case 3:
                return DaftarCandidate.get(rowIndex).getWriting();
            case 4:
                return DaftarCandidate.get(rowIndex).getCoding();
            case 5:
                return DaftarCandidate.get(rowIndex).getInterview();
            case 6:
                return DaftarCandidate.get(rowIndex).getScore();
            case 7:
                return DaftarCandidate.get(rowIndex).getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        // Akan Mengembalikan Kolom 

        return kolom[columnIndex];
    }
}
