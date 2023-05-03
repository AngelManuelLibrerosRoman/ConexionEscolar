package controlador;

import dao.DAOAlumno;
import dao.DAOEspecialidad;
import dao.DAOMateria;
import modelo.ModeloMateria;
import vista.VistaMateria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMateriaGUI implements ActionListener{
    private final ModeloMateria modelo;
    private final VistaMateria vista;
    public ControladorMateriaGUI(ModeloMateria modelo, VistaMateria vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.guardarButton.addActionListener(this);
        this.vista.nuevoButton.addActionListener(this);
        this.vista.salirButton.addActionListener(this);
        this.vista.actualizarButton.addActionListener(this);
        this.vista.eliminarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(this.vista.nuevoButton == evento.getSource()){
            clear();
        } else if (vista.guardarButton == evento.getSource()) {
            modelo.setId_materia(Integer.parseInt(vista.txfid.getText()));
            modelo.setNombre(vista.txfMateria.getText());
            DAOMateria dao = new DAOMateria();
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
            modelo.setId_materia(Integer.parseInt(vista.txfid.getText()));
            DAOMateria dao = new DAOMateria();
            if(dao.eliminar(modelo.getId_materia()) ==true){
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
        this.vista.txfid.setText("");
        this.vista.txfMateria.setText("");
    }
    public void Salir(){
        System.exit(0);

    }
}