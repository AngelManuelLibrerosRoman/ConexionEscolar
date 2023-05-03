package vista;

import javax.swing.*;

public class VistaGrupo extends JFrame{
    private JPanel panelPrincipal;
    public JTextField txfClave;
    private JPanel panelNorte;
    private JLabel lblClave;
    public JTextField txfHora;
    private JLabel lblHora;
    private JLabel lblSalon;
    public JTextField txfSalon;
    public JButton nuevoButton;
    public JButton guardarButton;
    public JButton salirButton;
    private JPanel panelSur;
    private JPanel panelCentral;
    public JTextField txfidMateria;
    private JLabel lblMateria;
    public JTextField txfrfc;
    public JButton eliminarButton;
    public JButton actualizarButton;

    public VistaGrupo(){
        setTitle("Grupo");
        setContentPane(panelPrincipal);
        setSize(500,170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
