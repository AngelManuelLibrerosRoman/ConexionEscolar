package controlador;

import dao.DAOEspecialidad;
import modelo.ModeloEspecialidad;
import vista.VistaEspecialidad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEspecialidadGUI implements ActionListener{
    private final ModeloEspecialidad modelo;
    private final VistaEspecialidad vista;
     public ControladorEspecialidadGUI (ModeloEspecialidad modelo, VistaEspecialidad vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.guardarButton.addActionListener(this);
        this.vista.nuevoButton.addActionListener(this);
        this.vista.salirButton.addActionListener(this);
         this.vista.eliminarButton.addActionListener(this);
         this.vista.actualizarButton.addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent evento) {
         if(this.vista.nuevoButton == evento.getSource()){
             clear();
         } else if (vista.guardarButton == evento.getSource()) {
             modelo.setId(Integer.parseInt(vista.txfId.getText()));
             modelo.setNombre(vista.jtfEspecialidad.getText());
             DAOEspecialidad dao = new DAOEspecialidad();
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
            modelo.setId(Integer.parseInt(vista.txfId.getText()));
            DAOEspecialidad dao = new DAOEspecialidad();
            if(dao.eliminar(modelo.getId()) == true){
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
         this.vista.txfId.setText("");
         this.vista.jtfEspecialidad.setText("");
    }
    public void Salir(){
         System.exit(0);

    }
}
