/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteBL;

import javax.swing.JOptionPane;

/**
 *
 * @author Yisus
 */
public class ValidarHora {

    String hora;
    boolean aux = false;

    public ValidarHora(String time) {
        String[] part = time.split(":");
        String hour = part[0];
        String minute = part[1];
        try {
            int hour1 = Integer.parseInt(hour);
            int minute1 = Integer.parseInt(minute);
            if (hour1 > 0 && hour1 <= 24) {
                if (minute1 >= 0 && minute1 <= 59) {

                } else {
                    JOptionPane.showConfirmDialog(null, "minutos incorrectos");
                }
            } else {
                JOptionPane.showConfirmDialog(null, "hora equivocada");
            }
        } catch (Exception e) {
            aux = true;
        }

        if (aux == true) {
            try {
                int aux = Integer.parseInt(minute);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Formato hora incorrecto");
                aux = false;
            }

        }
    }
}