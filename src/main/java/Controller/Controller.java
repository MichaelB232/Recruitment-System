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
import View.MainView;

public class Controller {
    
    private MainView view;
    private KandidatDAO dao;
    
    public Controller(MainView view) {
        
        this.view = view;
        dao = new KandidatDAO();
    }
    
    public void insert() {
        
        ModelKandidat k = createObject();
        
        dao.create(k);
        
        loadTable();
        
        view.clearForm();
        
    }
    
    public void update() {
        
        ModelKandidat k = createObject();
        
        k.setId(view.getSelectedId());
        
        dao.update(k);
        
        loadTable();
        
        view.clearForm();
    }
    
    public void delete() {
        
        dao.delete(view.getSelectedId());
        
        loadTable();
        
        view.clearForm();
    }
    
    public void clear() {
        
        view.clearForm();
    }
    
    private ModelKandidat createObject() {
        
        String nama = view.getNama();
        String path = view.getPath();
        
        int writing = Integer.parseInt(view.getWriting());
        int coding = Integer.parseInt(view.getCoding());
        int interview = Integer.parseInt(view.getInterview());
        
        ModelKandidat k;
        
        if (path.equals("Android Developer")) {
            k = new AndroidDev();
            
        } else {
            k = new WebDeveloper();
        }
        k.setName(nama);
        k.setPath(path);
        k.setWriting(writing);
        k.setCoding(coding);
        k.setWriting(writing);
        
        return k;
    }
    
    public void loadTable() {
        
        DefaultTableModel model
                = (DefaultTableModel) view.getTable().getModel();
        
        model.setRowCount(0);
        
        List<ModelKandidat> listKandidat = dao.findAll();
        
        for (ModelKandidat k : listKandidat) {
            
            Object[] row = {
                k.getId(),
                k.getName(),
                k.getPath(),
                k.getWriting(),
                k.getCoding(),
                k.getInterview(),
                k.calculate_final_score(),
                k.check_status()
            };
            
            model.addRow(row);
        }
    }
}
