/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FileDialog;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
/**
 *
 * @author peperony
 */
public class VistaControl implements ActionListener{
    private Fondo fondo;
    private Sonido sonido;
    
    public VistaControl(){
        fondo = new Fondo();
        sonido = new Sonido();
    }
    
    private void IniciarElementos(){
        this.fondo.principal.jButtonSalir.addActionListener(this);
        this.fondo.principal.jButtonJugar.addActionListener(this);
        this.fondo.menu.jButtonSalir.addActionListener(this);
        this.fondo.menu.jButtonAgregarCioudad.addActionListener(this);
        this.fondo.agregarCiudad.jButtonSalir.addActionListener(this);
        this.fondo.agregarCiudad.jButtonBuscarRutaCiudad.addActionListener(this);
        this.fondo.agregarCiudad.jButtonGuardarCiudad.addActionListener(this);
        this.fondo.agregarCiudad.jButtonAtrasAgregarCiudad.addActionListener(this);
        this.fondo.menu.jButtonEditarCiudad.addActionListener(this);
        this.fondo.menu.jButtonCargarCiudad.addActionListener(this);
        this.fondo.cargarCiudad.jButtonSalir.addActionListener(this);
        this.fondo.cargarCiudad.jButtonAtrasCargarCiudad.addActionListener(this);
        this.fondo.editarCiudad.jButtonSalir.addActionListener(this);
        this.fondo.editarCiudad.jButtonAtrasEditarCiudad.addActionListener(this);
        this.fondo.menu.jButtonAgregarAntiheroe.addActionListener(this);
        this.fondo.agregarAntiheroe.jButtonSalir.addActionListener(this);
        this.fondo.agregarAntiheroe.jButtonAtrasCargarAntiheroe.addActionListener(this);
        this.fondo.menu.jButtonAgregarVillano.addActionListener(this);
        this.fondo.agregarVillano.jButtonAtrasAgregarVillano.addActionListener(this);
        this.fondo.agregarVillano.jButtonSalir.addActionListener(this);
        this.fondo.agregarHeroe.jButtonSalir.addActionListener(this);
        this.fondo.agregarHeroe.jButtonAtrasAgregarHeroe.addActionListener(this);
        this.fondo.menu.jButtonAgregarHeroe.addActionListener(this);
    }
    
    public void Inicio () {
        IniciarElementos();
        fondo.setVisible(true);
        fondo.principal.setVisible(true);
        fondo.menu.setVisible(false);
        fondo.agregarCiudad.setVisible(false);
        fondo.cargarCiudad.setVisible(false);
        fondo.editarCiudad.setVisible(false);
        fondo.agregarAntiheroe.setVisible(false);
        fondo.agregarVillano.setVisible(false);
        fondo.agregarHeroe.setVisible(false);
        fondo.add(fondo.principal,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.menu,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarCiudad,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.editarCiudad,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.cargarCiudad,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarAntiheroe,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarVillano,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarHeroe,new AbsoluteConstraints(0,0,-1,-1));
    }
    
    public void sonidoBotones () {
        sonido.sonidoBotones(fondo.clip);
    }
    
    public void buscarRuta() {
        FileDialog fd = new FileDialog(fondo, "Busqueda", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        fd.setFile("*.png");
        fd.setVisible(true);
        String filename =fd.getDirectory() + fd.getFile();
        System.out.println(filename);
    }
    
    public void moverImagen(){
        Archivos archivo = new Archivos();
        archivo.moverImagen("", "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje = e.getActionCommand();
        switch (mensaje) {
            case "Salir":
                System.exit(0);
            case "Jugar":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.principal.setVisible(false);
                sonido.run();
                break;
            case "Agregar ciudad":
                sonidoBotones();
                fondo.agregarCiudad.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "BuscarRuta":
                sonidoBotones();
                buscarRuta();
                break;
            case "GuardarCiudad":
                sonidoBotones();
                moverImagen();
                break;
            case "AtrasAgregarCiudad":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.agregarCiudad.setVisible(false);
                fondo.agregarCiudad.jTextFieldNombreCiudad.setText("");
                fondo.agregarCiudad.jTextFieldRutaCiudad.setText("");
                break;
            case "Cargar ciudad":
                sonidoBotones();
                fondo.cargarCiudad.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "Editar ciudad":
                sonidoBotones();
                fondo.editarCiudad.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "AtrasCargarCiudad":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.cargarCiudad.setVisible(false);
                break;
            case "AtrasEditarCiudad":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.editarCiudad.setVisible(false);
                break;
            case "Agregar antiheroe":
                sonidoBotones();
                fondo.agregarAntiheroe.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "AtrasCargarAntiheroe":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.agregarAntiheroe.setVisible(false);
                break;
            case "Agregar villano":
                sonidoBotones();
                fondo.agregarVillano.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "AtrasAgregarVillano":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.agregarVillano.setVisible(false);
                break;
            case "Agregar heroe":
                sonidoBotones();
                fondo.agregarHeroe.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "AtrasAgregarHeroe":
                sonidoBotones();
                fondo.agregarHeroe.setVisible(false);
                fondo.menu.setVisible(true);
                break;
        }
    }
}
