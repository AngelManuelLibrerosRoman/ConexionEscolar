package vista;

import javax.swing.*;

public class VistaAlumno extends JFrame{
    private JPanel panelPrincipal;
    private JLabel lblNumcontrol;
    private JPanel panelCentral;
    public JTextField txfNumecontrol;
    private JLabel lblNombre;
    public JTextField txfNombre;
    public JButton nuevoButton;
    public JButton guardarButton;
    private JPanel panelSur;
    private JPanel panelNorte;
    public JButton salirButton;
    public JTextField txfEspecialidad;
    private JLabel lblEspecialidad;
    public JButton eliminarButton;
    public JButton actualizarButton;

    public VistaAlumno(){
        setTitle("Alumnos");
        setContentPane(panelPrincipal);
        setSize(600,160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }





}
