package vista;

import javax.swing.*;

public class VistaMateria extends JFrame {
    private JPanel panelPrincipal;
    public JTextField txfid;
    public JTextField txfMateria;
    private JPanel panelCentral;
    private JPanel panelNorte;
    private JPanel panelSur;
    public JButton nuevoButton;
    public JButton guardarButton;
    public JButton salirButton;
    private JLabel lblMateria;
    private JLabel lblaidi;
    public JButton actualizarButton;
    public JButton eliminarButton;

    public VistaMateria(){
        setTitle("Materias");
        setContentPane(panelPrincipal);
        setSize(600,160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
