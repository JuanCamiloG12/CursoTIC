
package web;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inicio {
     public static void main(String[] args) {
        MarcoAccion accion = new MarcoAccion();

    }
}

class MarcoAccion extends JFrame {

    public MarcoAccion() {
        setBounds(300, 150, 500, 500);
        setVisible(true);
        setTitle("Accion multiples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelAccion panelaccion = new PanelAccion();
        add(panelaccion);

    }

}

class PanelAccion extends JPanel {

    public PanelAccion() {
        AccionColor accionAmarillo = new AccionColor("amarillo", new ImageIcon("src/web/BETH.png"), Color.YELLOW);
        AccionColor accionAzul = new AccionColor("azul", new ImageIcon("src/web/DuaLipa.jpg"), Color.BLUE);
        AccionColor accionCyan = new AccionColor("Cyan", new ImageIcon("src/web/Trunks.jpg"), Color.CYAN);

        /* JButton botonAmarillo= new JButton(accionAmarillo);
         add(botonAmarillo);
         */
        add(new JButton(accionAmarillo));
        add(new JButton(accionAzul));
        add(new JButton(accionCyan));

        /*
    JButton amarillo = new JButton("amarillo");
    JButton azul = new JButton("azul");
    JButton cyan = new JButton("cyan");
    add(amarillo);
    add(azul);
    add(cyan);
         */
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        KeyStroke teclaAmarilla = KeyStroke.getKeyStroke("ctrl A");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondoAmarillo");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondoAzul");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondoCyan");
        
        ActionMap mapaAccion = getActionMap();
        
        mapaAccion.put("fondoAmarillo", accionAmarillo);
        mapaAccion.put("fondoAzul", accionAzul);
        mapaAccion.put("fondoCyan", accionCyan);
    }

    private class AccionColor extends AbstractAction {

        public AccionColor(String nombre, Icon icono, Color color_buton) {
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "poner la lamina de color " + nombre);
            putValue("Color_de_fondo", color_buton);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color_de_fondo");
            setBackground(c);
        }

    }
    
}
