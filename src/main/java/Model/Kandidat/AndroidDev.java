/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Kandidat;

/**
 *
 * @author micha
 */
public class AndroidDev extends ModelKandidat {

    public AndroidDev() {
        this.path = "Android Dev";
    }

    @Override
    public float calculate_final_score() {
        float last_score;
        last_score = (float) (super.getWriting() + super.getCoding() + super.getScore()) / 3;
        return last_score;
    }

    @Override
    public String check_status() {
        return calculate_final_score() >= 85 ? "Diterima" : "Ditolak";
    }

}
