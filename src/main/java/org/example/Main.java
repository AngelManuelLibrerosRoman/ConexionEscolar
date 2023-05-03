package org.example;
import controlador.*;
import modelo.*;
import vista.*;

public class Main {
    public static void main(String[] args) {
        MenuPrincipalGUI p = new MenuPrincipalGUI();
        ControladorMenuGUI gui = new ControladorMenuGUI(p);

    }
}