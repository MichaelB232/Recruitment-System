/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Kandidat;

/**
 *
 * @author micha
 */
import Model.connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class KandidatDAO implements InterfaceDAO {

    private final Connection conn;

    public KandidatDAO() {
        this.conn = connector.connect();
    }

    public boolean create(ModelKandidat k) {
        String sql = "INSERT INTO recruit (nama, path, writing, coding, interview, score, status) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, k.getName());
            ps.setString(2, k.getPath());
            ps.setDouble(3, k.getWriting());
            ps.setDouble(4, k.getCoding());
            ps.setInt(5, k.getInterview());
            ps.setDouble(6, k.getScore());
            ps.setString(7, k.getStatus());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Failed to add data");
        }
        return false;
    }

    public List<ModelKandidat> findAll() {
        String sql = "SELECT * FROM recruit";

        List<ModelKandidat> kandidats = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ModelKandidat k;
                if ("Web Developer".equals(rs.getString("path"))) {
                    k = new WebDeveloper();
                } else {
                    k = new AndroidDev();
                }
                k.setCoding(rs.getInt("coding"));
                k.setWriting(rs.getInt("writing"));
                k.setInterview(rs.getInt("interview"));
                k.setName(rs.getString("nama"));
                k.setScore(rs.getInt("Score"));
                k.setId(rs.getInt("id"));
                k.setStatus(rs.getString("status"));
                kandidats.add(k);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch data : " + e.getMessage());
        }
        return kandidats;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM recruit WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Failed to delete data");
        }
        return false;
    }

    public boolean update(ModelKandidat k) {
        String sql = "UPDATE recruit SET nama = ?, path = ?, writing = ?, coding = ?, interview = ?, score = ?, status = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, k.getName());
            ps.setString(2, k.getPath());
            ps.setInt(3, k.getWriting());
            ps.setInt(4, k.getCoding());
            ps.setInt(5, k.getInterview());
            ps.setDouble(6, k.calculate_final_score());
            ps.setString(7, k.check_status());

            ps.setInt(8, k.getId());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Failed to update data");
        }
        return false;
    }

}
