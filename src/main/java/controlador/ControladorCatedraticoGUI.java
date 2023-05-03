package controlador;

import dao.DAOAlumno;
import dao.DAOCatedratico;
import modelo.ModeloCatedratico;
import vista.VistaCatedratico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCatedraticoGUI implements ActionListener{
    private final ModeloCatedratico modelo;
    private final VistaCatedratico vista;
    public ControladorCatedraticoGUI(ModeloCatedratico modelo, VistaCatedratico vista) {
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
            modelo.setRFC(vista.txfFRC.getText());
            modelo.setNombre(vista.txfNombre.getText());
            DAOCatedratico dao = new DAOCatedratico();
            if(dao.agregar(modelo)){
                JOptionPane.showMessageDialog(
                        null,
                        "Registro Guardado",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else{
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar agregar especialidad. \n"+
                                "intente nuevamente.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            clear();
        } else if (vista.salirButton == evento.getSource()) {
            Salir();
        }
        if(this.vista.eliminarButton == evento.getSource()){
            modelo.setRFC(vista.txfFRC.getText());
            DAOCatedratico dao = new DAOCatedratico();
            if(dao.eliminarRFC(modelo.getRFC()) ==true){
                JOptionPane.showMessageDialog(
                        null,
                        "Registro eliminado",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else{
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar eliminar catedratico. \n"+
                                "intente nuevamente.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    public void clear (){
        this.vista.txfFRC.setText("");
        this.vista.txfNombre.setText("");
    }
    public void Salir(){
        System.exit(0);

    }
}