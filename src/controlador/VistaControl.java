/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import GUI.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FileDialog;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
/**
 * La clase VistaControl se encarga de controloar y administar todas las clases
 * del paquete GUI para su uso de manera eficas.
 * La clase encasula todos los datos necesaria para realizar las acciones
 * correctas y validadas.
 * Esta clase implementa la interfas "ActionListener" para poder relizar un 
 * control de eventos de los botones de los paneles
 * @author Josué Torres N.
 * @version 1.0
 */
public class VistaControl implements ActionListener{
    private final Fondo fondo;
    private final Sonido sonido;
    private final Imagenes imagenes;
    private final Animacion animaciones1;
    private final Animacion animaciones2;
    private final Control control;
    /**
     * Costructor de la clase
     */
    public VistaControl(){
        fondo = new Fondo();
        sonido = new Sonido();
        imagenes = new Imagenes();
        animaciones1 = new Animacion();
        animaciones2 = new Animacion();
        control = new Control();
    }
    
    /**
     * Le agrega un "addActionListener" como parametro esta clase a todos
     * los botones de los paneles del paquete GUI
     */
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
        this.fondo.menu.jButtonComenzar.addActionListener(this);
        this.fondo.preJuego.jButtonSalir.addActionListener(this);
        this.fondo.preJuego.jButtonAtrasPreJuego.addActionListener(this);
        this.fondo.preJuego.jButtonPreviewCiudad.addActionListener(this);
        this.fondo.preJuego.jButtonPreviewPJ1.addActionListener(this);
        this.fondo.preJuego.jButtonPreviewPJ2.addActionListener(this);
        this.fondo.preJuego.jButtonJugar.addActionListener(this);
        this.fondo.juego.jButtonSalir.addActionListener(this);
        this.fondo.juego.jButtonAtrasJuego.addActionListener(this);
        this.fondo.juego.jButtonDuelo.addActionListener(this);
    }
    
    /**
     * Metodo principal que inicia el programa.
     * Agrega a la ventana principal todos los
     * componentes importantes para dar incio
     */
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
        fondo.preJuego.setVisible(false);
        fondo.juego.setVisible(false);
        fondo.add(fondo.principal,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.menu,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarCiudad,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.editarCiudad,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.cargarCiudad,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarAntiheroe,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarVillano,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.agregarHeroe,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.preJuego,new AbsoluteConstraints(0,0,-1,-1));
        fondo.add(fondo.juego,new AbsoluteConstraints(0,0,-1,-1));
        
    }
    
    /**
     * Llama el metodo sonidoBotones de la clase
     * sonido para reproducir el sonido de los 
     * botones
     */
    private void sonidoBotones () {
        sonido.sonidoBotones(fondo.clip);
    }
    
    /**
     * Crea un FileDialog para buscar la ruta de una imagen
     */
    private void buscarRuta(JTextField actual, String extencion) {
        FileDialog fd = new FileDialog(fondo, "Busqueda", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        fd.setFile(extencion);
        fd.setVisible(true);
        String filename =fd.getDirectory() + fd.getFile();
        if(!filename.equals("nullnull")){
            actual.setText(filename);
        }
    }
    
    /**
     * Mueve una imagen seleccionada a la capeta image del proecto
     */
    private void moverImagen(){
        try {
            if (!fondo.agregarCiudad.jTextFieldNombreCiudad.getText().equals("")){
                imagenes.moverArchivo(fondo.agregarCiudad.jTextFieldRutaCiudad.getText());
            } else {
                JOptionPane.showMessageDialog(fondo,"Escriba el nombre de la imagen.","Complete los campos",JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fondo,"Hubo un error en la imagen.","Error de imagen",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cambiarNombreCiudad() {
        String nArchivovViejo = cortarPaht(fondo.agregarCiudad.jTextFieldRutaCiudad.getText());
        nArchivovViejo = getClass().getResource("/image/"+ nArchivovViejo).getPath();
        String nNuevoArchvo = getClass().getResource("/image/").getPath()+fondo.agregarCiudad.jTextFieldNombreCiudad.getText()+".jpg";//+fondo.agregarCiudad.jTextFieldNombreCiudad.getText()+".jpg").getPath();
        imagenes.cambiarNombre(nArchivovViejo, nNuevoArchvo);
    }
    
    private String cortarPaht(String ruta) {
        Path url = Paths.get(ruta);
        return url.getFileName().toString();
    }
    
    /**
     * Coloca la imagen en el label de tamaño cambiante enviado.
     * @param x Un entero del alto de la imagen
     * @param y Un entero del ancho de la imagen
     * @param fichero Un string de la exteción de la imagen
     * @param actual El label al cual se le pondra la imagen
     * @param imagen Un String del nombre de la imagen
     */
    private void ponerImagePreview(int x, int y, String fichero, JLabel actual,String imagen){
        if (!(imagen == null)){
            actual.setIcon(imagenes.modificarTamanioImagen(imagen, x, y, fichero));
        } else {
            JOptionPane.showMessageDialog(fondo,"Debe escoger una opcion.","Escoca",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Pone las imagenes a los label de los pj y la ciudad en el panel Juego
     */
    private void ponerImagenJuego() {
        fondo.juego.jLabelCiudad.setIcon(imagenes.modificarTamanioImagen(fondo.preJuego.Ciudades.getSelectedValue(), 1200, 610, ".jpg"));
        fondo.juego.jLabelPJ1.setIcon(imagenes.modificarTamanioImagen("blop1", 210, 230, ".png"));
        fondo.juego.jLabelPJ2.setIcon(imagenes.voltearImagen("capitan1", 210, 230, ".png"));
    }
    
    private void prepararEditar() {
        ArrayList<String> ciudades = control.listaCiudades();
        DefaultListModel model = new DefaultListModel<>();
        for (int i = 0; i < ciudades.size(); i++) {
            model.addElement(ciudades.get(i));
        }
        fondo.editarCiudad.jListCiudades.setModel(model);
    }
    
    private void agregarHeroe() {
        if ((isNum(fondo.agregarHeroe.jTextFieldAltura.getText())) && !(fondo.agregarHeroe.jTextFieldDireccion.getText().equals(""))
                && (isNum(fondo.agregarHeroe.jTextFieldEdad.getText())) && !(fondo.agregarHeroe.jTextFieldNombre.getText().equals(""))
                && !(fondo.agregarHeroe.jTextFieldOcupacion.getText().equals("")) && !(fondo.agregarHeroe.jTextFieldOrientacionSexual.getText().equals(""))
                && !(fondo.agregarHeroe.jTextFieldOrigen.getText().equals("")) && !(fondo.agregarHeroe.jTextFieldPersonaSercana.getText().equals(""))
                && !(fondo.agregarHeroe.jTextFieldSexo.getText().equals("")) && (fondo.agregarHeroe.jListCiudades.getSelectedValue() != null)
                && (fondo.agregarHeroe.jListArchienemigo.getSelectedValue() != null) && !(fondo.agregarHeroe.jTextFieldNombreHeroe.getText().equals(""))) {
            float pAltura = Integer.parseInt(fondo.agregarHeroe.jTextFieldAltura.getText());
            String pNombre = fondo.agregarHeroe.jTextFieldNombre.getText();
            String pSexo = fondo.agregarHeroe.jTextFieldSexo.getText();
            String pCiudadOrigen = fondo.agregarHeroe.jTextFieldOrigen.getText();
            String pNombreCiudad = fondo.agregarHeroe.jListCiudades.getSelectedValue();
            String pOcupacion = fondo.agregarHeroe.jTextFieldOcupacion.getText();
            String pOrientacionSexual = fondo.agregarHeroe.jTextFieldOrientacionSexual.getText();
            String pPersonaCercana = fondo.agregarHeroe.jTextFieldPersonaSercana.getText();
            String pNombreHeroe = fondo.agregarHeroe.jTextFieldNombreHeroe.getText();
            String pImg = cortarPaht(fondo.agregarHeroe.jTextFieldDireccion.getText());
            String pArchiEnemigo = fondo.agregarHeroe.jListArchienemigo.getSelectedValue();
            int pEdad = Integer.parseInt(fondo.agregarHeroe.jTextFieldEdad.getText());
            int aId = (int) (Math.random() * 1000);
            control.registrarHeroe(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen, pNombreCiudad, pOcupacion, pOrientacionSexual, pPersonaCercana, pImg, aId, pNombreHeroe, pArchiEnemigo);
        } else {
            JOptionPane.showMessageDialog(fondo,"Llenar todos los espacios.","Escoca",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void agregarAntiheroe () {
        if (isNum(fondo.agregarAntiheroe.jTextFieldAltura.getText()) && isNum(fondo.agregarAntiheroe.jTextFieldAltura.getText())
            && !(fondo.agregarAntiheroe.jTextField1Sexo.getText().equals("")) && !(fondo.agregarAntiheroe.jTextFieldCercana.getText().equals(""))
            && !(fondo.agregarAntiheroe.jTextFieldDireccion.getText().equals("")) && !(fondo.agregarAntiheroe.jTextFieldNombre.getText().equals(""))
            && !(fondo.agregarAntiheroe.jTextFieldOcupacion.getText().equals("")) && !(fondo.agregarAntiheroe.jTextFieldOrigen.getText().equals(""))
            && !(fondo.agregarAntiheroe.jTextFieldSexualidad.getText().equals("")) && (fondo.agregarAntiheroe.jListCiudades.getSelectedValue() != null)
            && (fondo.agregarAntiheroe.jListArchienemigo.getSelectedValue() != null) && !(fondo.agregarAntiheroe.jTextFieldNombreAntriheroe.getText().equals(""))) {
            int pEdad = Integer.parseInt(fondo.agregarAntiheroe.jTextFieldEdad.getText());
            float pAltura = Float.parseFloat(fondo.agregarAntiheroe.jTextFieldAltura.getText());
            String pNombre = fondo.agregarAntiheroe.jTextFieldNombre.getText();
            String pSexo = fondo.agregarAntiheroe.jTextField1Sexo.getText();
            String pCiudadOrigen = fondo.agregarAntiheroe.jTextFieldOrigen.getText();
            String pNombreCiudad = fondo.agregarAntiheroe.jListCiudades.getSelectedValue();
            String pOcupacion = fondo.agregarAntiheroe.jTextFieldOcupacion.getText();
            String pOrientacionSexual = fondo.agregarAntiheroe.jTextFieldSexualidad.getText();
            String pPersonaCercana = fondo.agregarAntiheroe.jTextFieldCercana.getText();
            String pImg = cortarPaht(fondo.agregarAntiheroe.jTextFieldDireccion.getText());
            String pNombreAntiHeroe = fondo.agregarAntiheroe.jTextFieldNombreAntriheroe.getText();
            String pArchiEnemogo = fondo.agregarAntiheroe.jListArchienemigo.getSelectedValue();
            int pID = (int) (Math.random() * 1000);
            control.registrarAntiHeroe(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen, pNombreCiudad, pOcupacion, pOrientacionSexual, pPersonaCercana, pImg, pID, pNombreAntiHeroe, pArchiEnemogo);
        }
    }
    private boolean isNum (String num) {
        try {
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException excepcion) {
            return false;
        }
    }
    
    /**
     * Se encarga de recibir el mensaje del evento y relizar la accion
     * referente
     * @param e El ActionEvent del cual se extraera el mensaje
     */
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
                fondo.agregarCiudad.jTextFieldNombreCiudad.setText("");
                fondo.agregarCiudad.jTextFieldRutaCiudad.setText("");
                break;
            case "BuscarRuta":
                sonidoBotones();
                buscarRuta(fondo.agregarCiudad.jTextFieldRutaCiudad, ".jpg");
                break;
            case "GuardarCiudad":
                sonidoBotones();
                if ("".equals(fondo.agregarCiudad.jTextFieldRutaCiudad.getText()) && ("".equals(fondo.agregarCiudad.jTextFieldNombreCiudad.getText()))){
                    cortarPaht(fondo.agregarCiudad.jTextFieldRutaCiudad.getText());
                    moverImagen();
                    cambiarNombreCiudad();
                    control.registrarCiudad(0, fondo.agregarCiudad.jTextFieldNombreCiudad.getText(), fondo.agregarCiudad.jTextFieldNombreCiudad.getText());
                }
                break;
            case "AtrasAgregarCiudad":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.agregarCiudad.setVisible(false);
                fondo.agregarCiudad.jTextFieldNombreCiudad.setText("");
                fondo.agregarCiudad.jTextFieldRutaCiudad.setText("");
                break;
            case "Cargar ciudades":
                sonidoBotones();
                fondo.cargarCiudad.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "Editar ciudad":
                sonidoBotones();
                prepararEditar();
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
            case "Comenzar":
                sonidoBotones();
                fondo.preJuego.setVisible(true);
                fondo.menu.setVisible(false);
                break;
            case "AtrasPreJuego":
                sonidoBotones();
                fondo.menu.setVisible(true);
                fondo.preJuego.setVisible(false);
                break;
            case "PreviewMapaPreJuego":
                sonidoBotones();
                ponerImagePreview(460, 270, ".jpg", fondo.preJuego.jLabelPreviewMapa,fondo.preJuego.Ciudades.getSelectedValue());
                break;
            case "PreviewPJ1":
                sonidoBotones();
                ponerImagePreview(220,180,".png",fondo.preJuego.jLabelPreviewPJ1,"blop1");
                break;
            case "PreviewPJ2":
                sonidoBotones();
                ponerImagePreview(220,180,".png",fondo.preJuego.jLabelPreviewPJ2,"capitan1");
                break;
            case "Partida":
                sonidoBotones();
                fondo.juego.setVisible(true);
                fondo.preJuego.setVisible(false);
                ponerImagenJuego();
                break;
            case "AtrasJuego":
                sonidoBotones();
                fondo.preJuego.setVisible(true);
                fondo.juego.setVisible(false);
                break;
            case "Duelo":
                sonidoBotones();
                animaciones1.actualizarActual(fondo.juego.jLabelPJ1,"blop");
                animaciones1.correr1();
                animaciones2.actualizarActual(fondo.juego.jLabelPJ2,"capitan");
                animaciones2.correr2();
                break;
        }
    }

}
