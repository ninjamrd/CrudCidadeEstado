/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudcidadeestado;

import com.mycompany.crudcidadeestado.view.EstadoView;
import com.mycompany.crudcidadeestado.view.MainView;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.flywaydb.core.Flyway;


/**
 *
 * @author Mateus
 */
public class CrudCidadeEstado {

    public static void main(String[] args) {
        
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:~/cidadeestado", "sa", "")
                .load();
        flyway.migrate();
        
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView(null, true);
            mainView.setLocationRelativeTo(null); 
            mainView.setVisible(true);
        });

    }
}
