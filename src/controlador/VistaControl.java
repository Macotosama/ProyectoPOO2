/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
/**
 *
 * @author peperony
 */
public class VistaControl implements ActionListener{
    private Fondo fondo;
    
    public VistaControl(){
        fondo = new Fondo();
    }
    
    private void IniciarElementos(){
        this.fondo.principal.jButtonSalir.addActionListener(this);
        this.fondo.principal.jButtonJugar.addActionListener(this);
        this.fondo.menu.jButtonSalir.addActionListener(this);
    }
    
    public void Inicio () {
        IniciarElementos();
        fondo.setVisible(true);
        fondo.principal.setVisible(true);
        fondo.menu.setVisible(false);
        fondo.add(fondo.principal,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.menu,new AbsoluteConstraints(0,0,-1,-1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje = e.getActionCommand();
        switch (mensaje) {
            case "Salir":
                System.exit(0);
            case "Jugar":
                fondo.menu.setVisible(true);
                fondo.principal.setVisible(false);
                break;
        }
    }
}
