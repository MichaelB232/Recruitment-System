/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author micha
 */
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Model.Kandidat.*;
import Model.Kandidat.ModelKandidat;
import Model.Kandidat.KandidatDAO;
//import View.MainView;
import Model.Kandidat.*;

public class Controller {

    InterfaceDAO dao;
    List<ModelKandidat> list;

    public Controller() {
        dao = new KandidatDAO();
    }

    public void insert(String nama,
            String path,
            int writing,
            int coding,
            int interview) {
        ModelKandidat model;

        if (path == "Android Developer") {
            model = new AndroidDev();
        } else {
            model = new WebDeveloper();
        }
        double score
                = (writing + coding + interview) / 3.0;
        String status;
        if (score >= 85) {
            status = "DITERIMA";
        } else {
            status = "TIDAK DITERIMA";
        }
        model.setName(nama);
        model.setPath(path);
        model.setWriting(writing);
        model.setCoding(coding);
        model.setInterview(interview);
        model.setScore(score);
        model.setStatus(status);
        dao.create(model);
    }

    public void update(int id,
            String nama,
            String path,
            int writing,
            int coding,
            int interview) {
        ModelKandidat model;
        if (path == "Android Developer") {
            model = new AndroidDev();
        } else {
            model = new WebDeveloper();
        }
        double score
                = (writing + coding + interview) / 3.0;
        String status;
        if (score >= 85) {
            status = "DITERIMA";
        } else {
            status = "TIDAK DITERIMA";
        }
        model.setId(id);
        model.setName(nama);
        model.setPath(path);
        model.setWriting(writing);
        model.setCoding(coding);
        model.setInterview(interview);
        model.setScore(score);
        model.setStatus(status);
        dao.update(model);
    }

    public ModelTable showData() {
        list = dao.findAll();
        ModelTable table = new ModelTable(list);
        return table;
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
