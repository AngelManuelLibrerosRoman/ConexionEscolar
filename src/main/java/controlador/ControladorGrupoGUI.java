package controlador;

import dao.DAOGrupo;
import modelo.ModeloGrupo;
import vista.VistaGrupo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGrupoGUI implements ActionListener{
    private final ModeloGrupo modelo;
    private final VistaGrupo vista;
    public ControladorGrupoGUI(ModeloGrupo modelo, VistaGrupo vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.nuevoButton.addActionListener(this);
        this.vista.guardarButton.addActionListener(this);
        this.vista.salirButton.addActionListener(this);
        this.vista.eliminarButton.addActionListener(this);
        this.vista.actualizarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(this.vista.nuevoButton == evento.getSource()){
            clear();
        } else if (vista.guardarButton == evento.getSource()) {
            modelo.setClave(vista.txfClave.getText());
            modelo.setMateria(Integer.parseInt(vista.txfidMateria.getText()));
            modelo.setCatedratico((vista.txfrfc.getText()));
            modelo.setHora(Integer.parseInt(vista.txfHora.getText()));
            modelo.setSalon(Integer.parseInt(vista.txfSalon.getText()));
            DAOGrupo dao = new DAOGrupo();
            if(dao.agregar(modelo)){
                JOptionPane.showMessageDialog(
                        null,
                        "Registro Guardado",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else{
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar agregar grupo. \n"+
                                "intente nuevamente.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            clear();
        } else if (vista.salirButton == evento.getSource()) {
            Salir();
        }
        if(this.vista.eliminarButton == evento.getSource()){
            modelo.setClave(vista.txfClave.getText());
            DAOGrupo dao = new DAOGrupo();
            if(dao.eliminarClave(modelo.getClave()) ==true){
                JOptionPane.showMessageDialog(
                        null,
                        "Registro eliminado",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else{
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar eliminar alumno. \n"+
                                "intente nuevamente.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    public void clear (){
        this.vista.txfClave.setText("");
        this.vista.txfidMateria.setText("");
        this.vista.txfrfc.setText("");
        this.vista.txfHora.setText("");
        this.vista.txfSalon.setText("");
    }
    public void Salir(){
        System.exit(0);

    }
}
