package controlador;

import dao.DAOAlumno;
import modelo.ModeloAlumno;
import modelo.ModeloEspecialidad;
import vista.VistaAlumno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAlumnoGUI implements ActionListener{
    private final ModeloAlumno modelo;
    private final VistaAlumno vista;
    public ControladorAlumnoGUI (ModeloAlumno modelo, VistaAlumno vista) {
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
            modelo.setNumControl(Integer.parseInt(vista.txfNumecontrol.getText()));
            modelo.setNombre(vista.txfNombre.getText());
            modelo.setEspecialidad(Integer.parseInt(vista.txfEspecialidad.getText()));
            DAOAlumno dao = new DAOAlumno();
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
            modelo.setNumControl(Integer.parseInt(vista.txfNumecontrol.getText()));
            DAOAlumno dao = new DAOAlumno();
            if(dao.eliminar(modelo.getNumControl()) ==true){
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

        if(this.vista.actualizarButton == evento.getSource()){
            DAOAlumno dao = new DAOAlumno();
            ModeloAlumno mec = new ModeloAlumno();
            mec.setNombre(vista.txfNombre.getText());
            mec.setEspecialidad(Integer.parseInt(vista.txfEspecialidad.getText()));
            mec.setNumControl(Integer.parseInt(vista.txfNumecontrol.getText()));
            if(dao.actualizar(modelo.getNumControl(),mec) ==true){
                JOptionPane.showMessageDialog(
                        null,
                        "Registro actualizado",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else{
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar actualizar la información alumno. \n"+
                                "intente nuevamente.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    public void clear (){
        this.vista.txfNumecontrol.setText("");
        this.vista.txfNombre.setText("");
        this.vista.txfEspecialidad.setText("");
    }
    public void Salir(){
        System.exit(0);

    }
}
