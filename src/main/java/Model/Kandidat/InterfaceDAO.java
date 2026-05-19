/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Kandidat;

/**
 *
 * @author micha
 */
import java.util.List;

public interface InterfaceDAO {

    public boolean create(ModelKandidat kandidat);

    public boolean update(ModelKandidat kandidat);

    public boolean delete(int id);

    public List<ModelKandidat> findAll();
}
