package vista;

import controlador.*;
import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalGUI extends JFrame{
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    public JButton salirButton;
    public JButton mostrarButton;
    private JPanel panelSur;
    private JMenuBar barraMenu;
    private JMenu menuPrincipal;
    private JMenuItem itemGrupo;
    private JMenuItem itemAlumno;
    private JMenuItem itemEspecialidad;
    private JMenuItem itemCatedratico;
    private JMenuItem itemMateria;

    //cosas que se agregaron

    private JMenu nuevo;
    private JMenuItem itemDardealta;
    private JMenu grupo;

    //experimento


   public MenuPrincipalGUI() {
        super("BD: Proyecto Escolar");

        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 260);
        setLocation(500, 250);
        setResizable(false);

        barraMenu = new JMenuBar();
        menuPrincipal = new JMenu("-Opciones de registro-");

       barraMenu.setBackground(Color.GRAY);
       menuPrincipal.setFont(new Font("Tw Cent MT", 1,13));
       menuPrincipal.setForeground(Color.WHITE);
        //173,215,239


        itemGrupo = new JMenuItem("Grupo alta");
        nuevo = new JMenu("Grupo");

        nuevo.add(itemGrupo);
        itemGrupo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n----------- Grupos ---------");
                ModeloGrupo grupo = new ModeloGrupo();
                VistaGrupo vistag = new VistaGrupo();
                ControladorGrupoGUI controladorg = new ControladorGrupoGUI(grupo,vistag);
            }
        });

        itemAlumno = new JMenuItem("Alumno");
        itemAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n----------- Alumnos  ---------");
                ModeloAlumno alumno = new ModeloAlumno();
                VistaAlumno vista = new VistaAlumno();
                ControladorAlumnoGUI controlador = new ControladorAlumnoGUI(alumno,vista);
            }
        });


        itemEspecialidad = new JMenuItem("Especialidad");
        itemEspecialidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n----------- Especialidades ---------");
                ModeloEspecialidad especialidad = new ModeloEspecialidad();
                VistaEspecialidad vista = new VistaEspecialidad();
                ControladorEspecialidadGUI controlador = new ControladorEspecialidadGUI(especialidad,vista);
            }
        });

        itemCatedratico = new JMenuItem("Catedrático");
        itemCatedratico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n----------- Catedráticos ---------");
                ModeloCatedratico alumno = new ModeloCatedratico();
                VistaCatedratico vista = new VistaCatedratico();
                ControladorCatedraticoGUI controladorc = new ControladorCatedraticoGUI(alumno,vista);
            }
        });

        itemMateria = new JMenuItem("Materia");
        itemMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n----------- Materias ---------");
                ModeloMateria materia = new ModeloMateria();
                VistaMateria vista = new VistaMateria();
                ControladorMateriaGUI controlador = new ControladorMateriaGUI(materia,vista);
            }
        });

        menuPrincipal.add(itemAlumno);
        menuPrincipal.add(itemCatedratico);
        menuPrincipal.add(itemEspecialidad);
        menuPrincipal.add(itemMateria);
        menuPrincipal.add(nuevo);

        barraMenu.add(menuPrincipal);
        this.setJMenuBar(barraMenu);

        setVisible(true);

    }

}
