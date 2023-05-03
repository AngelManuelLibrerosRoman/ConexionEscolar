package controlador;

import dao.DAOEspecialidad;
import vista.MenuPrincipalGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuGUI implements ActionListener {

    private final MenuPrincipalGUI menuGUI;

    public ControladorMenuGUI(MenuPrincipalGUI menuGUI) {
        this.menuGUI = menuGUI;
        this.menuGUI.mostrarButton.addActionListener(this);
        this.menuGUI.salirButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (this.menuGUI.mostrarButton == e.getSource()){
            System.out.println("\n----------- Base de datos ---------");
            DAOEspecialidad dao = new DAOEspecialidad();
            dao.consultar();
        }

        if (this.menuGUI.salirButton == e.getSource()){
            salir();
        }

    }

    public void salir(){
        System.exit(0);
    }
}
