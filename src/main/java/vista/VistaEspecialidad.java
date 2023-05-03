package vista;

import javax.swing.*;

public class VistaEspecialidad extends JFrame{
    private JPanel panelPrincipal;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JPanel panelCentro;
    public JButton nuevoButton;
    public JButton guardarButton;
    public JButton salirButton;
    public JTextField txfId;
    private JLabel lblaidi;
    public JTextField jtfEspecialidad;
    private JLabel lblEspecialidad;
    public JButton eliminarButton;
    public JButton actualizarButton;

    public VistaEspecialidad(){
        setTitle("Especialidades");
        setContentPane(panelPrincipal);
        setSize(600,160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
