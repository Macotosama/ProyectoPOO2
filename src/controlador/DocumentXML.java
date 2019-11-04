/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author peperony
 */
public class DocumentXML {
    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;
    private Document doc;
    private Element raiz;
    
    
    public DocumentXML() {
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            // elemento raiz
            doc = docBuilder.parse("Data.xml");
        } catch (Exception ex) {
            crearXml();
        }
    }
    
    /**
     * Metodo para crear el archivo XML que contendrá los datos del juego
     */
    private void crearXml() {
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            // elemento raiz
            doc = docBuilder.newDocument();
            raiz = doc.createElement("WarForJustice");
            doc.appendChild(raiz);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Data.xml");
            transformer.transform(source, result);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para registrar una persona cercana
     * @param pNombre
     * @param pNombreCiudad 
     */
    public void registrarPersona(String pNombre, String pNombreCiudad) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
            for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pNombreCiudad)) ciudad=temp;
                
            } 
            NodeList nList = ciudad.getElementsByTagName("PersonasCercanas");
            Element personajeRaiz=doc.createElement("PersonasCercanas");
            int cont=0;
            while(cont!=nList.getLength()) {
                Node nNode = nList.item(cont);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (nNode.getNodeName().equals("PersonasCercanas")) {
                        personajeRaiz=(Element) nNode;
                        cont=nList.getLength();
                    }
                    else cont++;
                }
            }
            Element personaje=doc.createElement("PersonaCercana");
            Element nombre = doc.createElement("Nombre");
            nombre.appendChild(doc.createTextNode(pNombre));
            Element estado=doc.createElement("Estado");
            estado.appendChild(doc.createTextNode("."));
           

            personaje.appendChild(nombre);
            personaje.appendChild(estado);
           
 
            personajeRaiz.appendChild(personaje);
        
        if (nList.getLength()==0) ciudad.appendChild(personajeRaiz);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Data.xml");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    /**
     * Metodo para editar el estado de la persona cercana 
     * @param pNombrePersona
     * @param pNombreCiudad
     * @param pEstado 
     */
    public void editarEstado(String pNombrePersona,String pNombreCiudad,String pEstado) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");
                
                if (nombre.item(0).getTextContent().equals(pNombreCiudad)) {
                    ciudad=temp;
                }  
            }
           NodeList personas=ciudad.getElementsByTagName("PersonaCercana");
           for (int i=0;i!=personas.getLength();i++) {
               Element temp2=(Element) personas.item(i);
               NodeList nombre = temp2.getElementsByTagName("Nombre");
               if (nombre.item(0).getTextContent().equals(pNombrePersona)) {
                   NodeList estado=temp2.getElementsByTagName("Estado");
                   estado.item(0).setTextContent(pEstado);
               }
                  
           }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult("Data.xml");
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para registrar un personaje heroe en el XML
     * @param pNombre
     * @param pEdad
     * @param pSexo
     * @param pAltura
     * @param pCiudadOrigen
     * @param pNombreCiudad
     * @param pOcupacion
     * @param pOrientacionSexual
     * @param pPersonaCercana
     * @param pImg
     * @param pID
     * @param pNombreHeroe
     * @param pArchiEnemigo 
     */
    public void registrarHeroe(String pNombre, int pEdad, String pSexo, float pAltura, String pCiudadOrigen, String pNombreCiudad,
            String pOcupacion, String pOrientacionSexual,Personaje pPersonaCercana, String pImg, int pID, String pNombreHeroe, String pArchiEnemigo) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
            
            for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pNombreCiudad)) {
                    ciudad=temp;
                    System.out.println("yes");
                }
                
            } 
            //registrarPersonaje(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen,pOcupacion,pOrientacionSexual,pPersonaCercana,pImg,pID,0,0,ciudad,doc,false);
            NodeList nList = ciudad.getElementsByTagName("Heroes");
            Element personajeRaiz=doc.createElement("Heroes");
            int cont=0;
            while(cont!=nList.getLength()) {
                Node nNode = nList.item(cont);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (nNode.getNodeName().equals("Heroes")) {
                        personajeRaiz=(Element) nNode;
                        cont=nList.getLength();
                    }
                    else cont++;
                }
            }
            Element heroe=doc.createElement("Heroe");
            Element nombre=doc.createElement("NombreHeroe");
            nombre.appendChild(doc.createTextNode(pNombreHeroe));
            Element archiEnemigo=doc.createElement("ArchiEnemigo");
            archiEnemigo.appendChild(doc.createTextNode(pArchiEnemigo));
            registrarPersonaje(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen,pOcupacion,pOrientacionSexual,pPersonaCercana,pImg,pID,0,0,heroe,doc);
            
            heroe.appendChild(nombre);
            heroe.appendChild(archiEnemigo);
            personajeRaiz.appendChild(heroe);
            if (nList.getLength()==0) ciudad.appendChild(personajeRaiz);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Data.xml");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    /**
     * Metodo para registrar un AntiHeroe en el XML
     * @param pNombre
     * @param pEdad
     * @param pSexo
     * @param pAltura
     * @param pCiudadOrigen
     * @param pNombreCiudad
     * @param pOcupacion
     * @param pOrientacionSexual
     * @param pPersonaCercana
     * @param pImg
     * @param pID
     * @param pNombreAntiHeroe
     * @param pArchiEnemigo 
     */
    public void registrarAntiHeroe(String pNombre, int pEdad, String pSexo, float pAltura, String pCiudadOrigen, String pNombreCiudad,
            String pOcupacion, String pOrientacionSexual,Personaje pPersonaCercana, String pImg, int pID, String pNombreAntiHeroe, String pArchiEnemigo) {
        try {
            
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
            for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pNombreCiudad)) {
                    ciudad=temp;
                    System.out.println("yes");
                }
                
            }
            NodeList nList = ciudad.getElementsByTagName("AntiHeroes");
            Element personajeRaiz=doc.createElement("AntiHeroes");
            int cont=0;
            while(cont!=nList.getLength()) {
                Node nNode = nList.item(cont);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (nNode.getNodeName().equals("AntiHeroes")) {
                        personajeRaiz=(Element) nNode;
                        cont=nList.getLength();
                    }
                    else cont++;
                }
            }
            Element antiheroe=doc.createElement("AntiHeroe");
            Element nombre=doc.createElement("NombreAntiHeroe");
            nombre.appendChild(doc.createTextNode(pNombreAntiHeroe));
            Element archiEnemigo=doc.createElement("ArchiEnemigo");
            archiEnemigo.appendChild(doc.createTextNode(pArchiEnemigo));
            registrarPersonaje(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen,pOcupacion,pOrientacionSexual,pPersonaCercana,pImg,pID,0,0,antiheroe,doc);
            antiheroe.appendChild(nombre);
            antiheroe.appendChild(archiEnemigo);
            personajeRaiz.appendChild(antiheroe);
            if (nList.getLength()==0) ciudad.appendChild(personajeRaiz);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Data.xml");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para registrar un villano en el XML
     * @param pNombre
     * @param pEdad
     * @param pSexo
     * @param pAltura
     * @param pCiudadOrigen
     * @param pNombreCiudad
     * @param pOcupacion
     * @param pOrientacionSexual
     * @param pPersonaCercana
     * @param pImg
     * @param pID
     * @param pNombreVillano
     * @param pArchiEnemigo 
     * @param pTipo
     */
    public void registrarVillano(String pNombre, int pEdad, String pSexo, float pAltura, String pCiudadOrigen, String pNombreCiudad,
            String pOcupacion, String pOrientacionSexual,Personaje pPersonaCercana, String pImg, int pID, String pNombreVillano, String pArchiEnemigo,String pTipo) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pNombreCiudad)) {
                    ciudad=temp;
                }
                
            }
            NodeList nList = ciudad.getElementsByTagName("Villanos");
            Element personajeRaiz=doc.createElement("Villanos");
            int cont=0;
            while(cont!=nList.getLength()) {
                Node nNode = nList.item(cont);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (nNode.getNodeName().equals("Villanos")) {
                        personajeRaiz=(Element) nNode;
                        cont=nList.getLength();
                    }
                    else cont++;
                }
            }
            Element villano=doc.createElement("Villano");
            Element nombre=doc.createElement("NombreVillano");
            nombre.appendChild(doc.createTextNode(pNombreVillano));
            Element archiEnemigo=doc.createElement("ArchiEnemigo");
            archiEnemigo.appendChild(doc.createTextNode(pArchiEnemigo));
            registrarPersonaje(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen,pOcupacion,pOrientacionSexual,pPersonaCercana,pImg,pID,0,0,villano,doc);
            Element tipo=doc.createElement("Tipo");
            tipo.appendChild(doc.createTextNode(pTipo));
            villano.appendChild(nombre);
            villano.appendChild(archiEnemigo);
            villano.appendChild(tipo);
            personajeRaiz.appendChild(villano);
            if (nList.getLength()==0) ciudad.appendChild(personajeRaiz);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Data.xml");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para registrar la informacion de persona normal de cualquiera de los 3 posibles personajes(heroe,antiheroe y villanos)
     * @param pNombre
     * @param pEdad
     * @param pSexo
     * @param pAltura
     * @param pCiudadOrigen
     * @param pOcupacion
     * @param pOrientacionSexual
     * @param pPersonaCercana
     * @param pImg
     * @param pID
     * @param pGanes
     * @param pPerdidos
     * @param pNombreCiudad
     * @param doc 
     */
    public void registrarPersonaje(String pNombre, int pEdad, String pSexo, float pAltura, String pCiudadOrigen,
            String pOcupacion, String pOrientacionSexual,Personaje pPersonaCercana, String pImg, int pID,int pGanes, int pPerdidos,Element pNombreCiudad, Document doc) {
        Element personaje=pNombreCiudad;
      
   
        Element nombre = doc.createElement("Nombre");
        nombre.appendChild(doc.createTextNode(pNombre));
        Element edad = doc.createElement("Edad");
        edad.appendChild(doc.createTextNode(String.valueOf(pEdad)));
        Element sexo = doc.createElement("Sexo");
        sexo.appendChild(doc.createTextNode(pSexo));
        Element altura = doc.createElement("Altura");
        altura.appendChild(doc.createTextNode(String.valueOf(pAltura)));
        Element ciudad = doc.createElement("CiudadOrigen");
        ciudad.appendChild(doc.createTextNode(pCiudadOrigen));
        Element ocupacion = doc.createElement("Ocupacion");
        ocupacion.appendChild(doc.createTextNode(pOcupacion));
        Element orientacion = doc.createElement("OrientacionSexual");
        orientacion.appendChild(doc.createTextNode(pOrientacionSexual));
        Element personaCercana = doc.createElement("PersonaCercana");
        personaCercana.appendChild(doc.createTextNode(pPersonaCercana.getNombre()));
        Element img = doc.createElement("IMG");
        img.appendChild(doc.createTextNode(pImg));
        Element id = doc.createElement("ID");
        id.appendChild(doc.createTextNode(String.valueOf(pID)));
        Element ganes = doc.createElement("CantidadEventosGanados");
        ganes.appendChild(doc.createTextNode(String.valueOf(pGanes)));
        Element perdidas = doc.createElement("CantidadEventosPerdidos");
        perdidas.appendChild(doc.createTextNode(String.valueOf(pPerdidos)));
        
        personaje.appendChild(nombre);
        personaje.appendChild(edad);
        personaje.appendChild(sexo);
        personaje.appendChild(altura);
        personaje.appendChild(ciudad);
        personaje.appendChild(ocupacion);
        personaje.appendChild(orientacion);
        personaje.appendChild(personaCercana);
        personaje.appendChild(img);
        personaje.appendChild(id);
        personaje.appendChild(ganes);
        personaje.appendChild(perdidas);
        
        
    }
    
    /**
     * Metodo para registrar ciudades en el XML
     * @param pIndiceCriminalidad
     * @param pNombreCiudad
     * @param pImg 
     */
    public void registrarCiudad(double pIndiceCriminalidad, String pNombreCiudad, String pImg) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            Element root=doc.getDocumentElement();
            NodeList nList = doc.getElementsByTagName("Ciudades");
            Element ciudadRaiz=doc.createElement("Ciudades");
            int cont=0;
            while(cont!=nList.getLength()) {
                Node nNode = nList.item(cont);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (nNode.getNodeName().equals("Ciudades")) {
                        ciudadRaiz=(Element) nNode;
                        cont=nList.getLength();
                    }
                    else cont++;
                }
            }
            Element ciudad = doc.createElement("Ciudad");
            Element nombreCiudad = doc.createElement("Nombre");
            nombreCiudad.appendChild(doc.createTextNode(pNombreCiudad));
            Element indiceCriminalidad = doc.createElement("IndiceCriminalidad");
            indiceCriminalidad.appendChild(doc.createTextNode(String.valueOf(pIndiceCriminalidad)));
            Element ubicacionImg = doc.createElement("IMG");
            ubicacionImg.appendChild(doc.createTextNode(pImg));
            ciudad.appendChild(nombreCiudad);
            ciudad.appendChild(indiceCriminalidad);
            ciudad.appendChild(ubicacionImg);
           
            ciudadRaiz.appendChild(ciudad);
            if (nList.getLength()==0) root.appendChild(ciudadRaiz);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Data.xml");
            transformer.transform(source, result);
            
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    /**
     * Metodo para verificar la existencia de un heroe XML
     * @param pNombre
     * @param pCiudad
     * @return Un valor boolean
     */
    public boolean buscarHeroe(String pNombre, String pCiudad) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList heroes=ciudad.getElementsByTagName("Heroe");
           if (heroes.getLength()==0) return false;
           else {
               for (int i=0;i!=heroes.getLength();i++) {
                   Element temp=(Element) heroes.item(i);
                   NodeList nombre = temp.getElementsByTagName("Nombre");
                   
                   if (nombre.item(0).getTextContent().equals(pNombre)) return true;
               }
           }
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Metodo para verificar la existencia de un Antiheroe XML
     * @param pNombre
     * @param pCiudad
     * @return Un valor boolean
     */
    public boolean buscarAntiHeroe(String pNombre, String pCiudad) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList heroes=ciudad.getElementsByTagName("AntiHeroe");
           if (heroes.getLength()==0) return false;
           else {
               for (int i=0;i!=heroes.getLength();i++) {
                   Element temp=(Element) heroes.item(i);
                   NodeList nombre = temp.getElementsByTagName("Nombre");
                   
                   if (nombre.item(0).getTextContent().equals(pNombre)) return true;
               }
           }
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Metodo para verificar la existencia de un villano en el XML
     * @param pNombre
     * @param pCiudad
     * @return Un valor boolean
     */
    public boolean buscarVillano(String pNombre, String pCiudad) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList heroes=ciudad.getElementsByTagName("Villano");
           if (heroes.getLength()==0) return false;
           else {
               for (int i=0;i!=heroes.getLength();i++) {
                   Element temp=(Element) heroes.item(i);
                   NodeList nombre = temp.getElementsByTagName("Nombre");
                   
                   if (nombre.item(0).getTextContent().equals(pNombre)) return true;
               }
           }
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Metodo que genera un lista de las ciudades existentes
     * @return Un Arreglo de ciudades
     */
    public ArrayList<Ciudad> listaCiudades() {
        ArrayList<Ciudad> lista=new ArrayList<>();
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            for (int i=0;i!=rootCiudad.getLength();i++) {
                Ciudad ciudad= new Ciudad();
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");
                ciudad.setNombre(nombre.item(0).getTextContent());
                NodeList indice = temp.getElementsByTagName("IndiceCriminalidad");
                ciudad.setIndiceCriminalidad(Double.parseDouble(indice.item(0).getTextContent()));
                ciudad.setHeroes(listaHeroes(nombre.item(0).getTextContent()));
                ciudad.setAntiheroes(listaAntiHeroes(nombre.item(0).getTextContent()));
                ciudad.setVillanos(listaVillanos(nombre.item(0).getTextContent()));
                lista.add(ciudad);
            }
            return lista;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Metodo que genera una lista de los heroes existentes
     * @param pCiudad
     * @return Un arreglo de heroes
     */
    public ArrayList<Heroe> listaHeroes(String pCiudad) {
        ArrayList<Heroe> lista=new ArrayList<>();
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) ciudad=temp;
            }
           NodeList heroes=ciudad.getElementsByTagName("Heroe");
           for (int i=0;i!=heroes.getLength();i++) {
               Heroe personaje=new Heroe();
                Element temp =(Element) heroes.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");
                personaje.setNombre(nombre.item(0).getTextContent());
                NodeList edad = temp.getElementsByTagName("Edad");
                personaje.setEdad(Integer.parseInt(edad.item(0).getTextContent()));
                NodeList sexo = temp.getElementsByTagName("Sexo");
                personaje.setSexo(sexo.item(0).getTextContent());
                NodeList altura = temp.getElementsByTagName("Altura");
                personaje.setAltura(Float.parseFloat(altura.item(0).getTextContent()));
                NodeList ciudadOrigen = temp.getElementsByTagName("CiudadOrigen");
                personaje.setCiudadOrigen(ciudadOrigen.item(0).getTextContent());
                NodeList orientacion = temp.getElementsByTagName("OrientacionSexual");
                personaje.setOrientacionSexual(orientacion.item(0).getTextContent());
                NodeList ocupacion = temp.getElementsByTagName("Ocupacion");
                personaje.setOCupacion(ocupacion.item(0).getTextContent());
                NodeList id = temp.getElementsByTagName("ID");
                personaje.setID(Integer.parseInt(id.item(0).getTextContent()));
                Personaje persona=new Personaje();
                NodeList personaCercana=temp.getElementsByTagName("PersonaCercana");
                persona.setNombre(personaCercana.item(0).getTextContent());
                personaje.aPersonasercana(persona);
                
                NodeList ganados = temp.getElementsByTagName("CantidadEventosGanados");
                personaje.setCantidadEventosGanados(Integer.parseInt(ganados.item(0).getTextContent()));
                NodeList perdidos = temp.getElementsByTagName("CantidadEventosPerdidos");
                personaje.setCantidadEventosPerdidos(Integer.parseInt(perdidos.item(0).getTextContent()));
                NodeList nombreHeroe = temp.getElementsByTagName("NombreHeroe");
                personaje.setNombreHeroe(nombreHeroe.item(0).getTextContent());
                NodeList archiEnemigo = temp.getElementsByTagName("ArchiEnemigo");
                personaje.setArchiEnemigo(archiEnemigo.item(0).getTextContent());
                lista.add(personaje);
            }
            return lista;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Metodo que genera una lista de los antiheroes existentes
     * @param pCiudad
     * @return Un arreglo de antiheroes
     */
    public ArrayList<AntiHeroe> listaAntiHeroes(String pCiudad) {
        ArrayList<AntiHeroe> lista=new ArrayList<>();
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList antiHeroes=ciudad.getElementsByTagName("AntiHeroe");
           for (int i=0;i!=antiHeroes.getLength();i++) {
                Element temp =(Element) antiHeroes.item(i);
                AntiHeroe personaje=new AntiHeroe();
                NodeList nombre = temp.getElementsByTagName("Nombre");
                personaje.setNombre(nombre.item(0).getTextContent());
                NodeList edad = temp.getElementsByTagName("Edad");
                personaje.setEdad(Integer.parseInt(edad.item(0).getTextContent()));
                NodeList sexo = temp.getElementsByTagName("Sexo");
                personaje.setSexo(sexo.item(0).getTextContent());
                NodeList altura = temp.getElementsByTagName("Altura");
                personaje.setAltura(Float.parseFloat(altura.item(0).getTextContent()));
                NodeList ciudadOrigen = temp.getElementsByTagName("CiudadOrigen");
                personaje.setCiudadOrigen(ciudadOrigen.item(0).getTextContent());
                NodeList orientacion = temp.getElementsByTagName("OrientacionSexual");
                personaje.setOrientacionSexual(orientacion.item(0).getTextContent());
                NodeList ocupacion = temp.getElementsByTagName("Ocupacion");
                personaje.setOCupacion(ocupacion.item(0).getTextContent());
                NodeList id = temp.getElementsByTagName("ID");
                personaje.setID(Integer.parseInt(id.item(0).getTextContent()));
                Personaje persona=new Personaje();
                NodeList personaCercana=temp.getElementsByTagName("PersonaCercana");
                persona.setNombre(personaCercana.item(0).getTextContent());
                personaje.aPersonasercana(persona);
                
                NodeList ganados = temp.getElementsByTagName("CantidadEventosGanados");
                personaje.setCantidadEventosGanados(Integer.parseInt(ganados.item(0).getTextContent()));
                NodeList perdidos = temp.getElementsByTagName("CantidadEventosPerdidos");
                personaje.setCantidadEventosPerdidos(Integer.parseInt(perdidos.item(0).getTextContent()));
                NodeList nombreAntiHeroe = temp.getElementsByTagName("NombreAntiHeroe");
                personaje.setNombreAntiHeroe(nombreAntiHeroe.item(0).getTextContent());
                NodeList archiEnemigo = temp.getElementsByTagName("ArchiEnemigo");
                personaje.setArchiEnemigo(archiEnemigo.item(0).getTextContent());
                lista.add(personaje);
            }
            return lista;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Metodo que genera una lista de villanos existentes
     * @param pCiudad
     * @return Un arreglo de villano
     */
    public ArrayList<Villano> listaVillanos(String pCiudad) {
        ArrayList<Villano> lista=new ArrayList<>();
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList villanos=ciudad.getElementsByTagName("Villano");
           for (int i=0;i!=villanos.getLength();i++) {
                Element temp =(Element) villanos.item(i);
                Villano personaje=new Villano();
                NodeList nombre = temp.getElementsByTagName("Nombre");
                personaje.setNombre(nombre.item(0).getTextContent());
                NodeList edad = temp.getElementsByTagName("Edad");
                personaje.setEdad(Integer.parseInt(edad.item(0).getTextContent()));
                NodeList sexo = temp.getElementsByTagName("Sexo");
                personaje.setSexo(sexo.item(0).getTextContent());
                NodeList altura = temp.getElementsByTagName("Altura");
                personaje.setAltura(Float.parseFloat(altura.item(0).getTextContent()));
                NodeList ciudadOrigen = temp.getElementsByTagName("CiudadOrigen");
                personaje.setCiudadOrigen(ciudadOrigen.item(0).getTextContent());
                NodeList orientacion = temp.getElementsByTagName("OrientacionSexual");
                personaje.setOrientacionSexual(orientacion.item(0).getTextContent());
                NodeList ocupacion = temp.getElementsByTagName("Ocupacion");
                personaje.setOCupacion(ocupacion.item(0).getTextContent());
                NodeList id = temp.getElementsByTagName("ID");
                personaje.setID(Integer.parseInt(id.item(0).getTextContent()));
                Personaje persona=new Personaje();
                NodeList personaCercana=temp.getElementsByTagName("PersonaCercana");
                persona.setNombre(personaCercana.item(0).getTextContent());
                personaje.aPersonasercana(persona);
                
                NodeList ganados = temp.getElementsByTagName("CantidadEventosGanados");
                personaje.setCantidadEventosGanados(Integer.parseInt(ganados.item(0).getTextContent()));
                NodeList perdidos = temp.getElementsByTagName("CantidadEventosPerdidos");
                personaje.setCantidadEventosPerdidos(Integer.parseInt(perdidos.item(0).getTextContent()));
                NodeList villano = temp.getElementsByTagName("NombreVillano");
                personaje.setNombreVillano(villano.item(0).getTextContent());
                NodeList archiEnemigo = temp.getElementsByTagName("ArchiEnemigo");
                personaje.setArchiEnemigo(archiEnemigo.item(0).getTextContent());
                lista.add(personaje);
            }
            return lista;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Metodo que genera una lista de las personas cercanas existentes
     * @param pCiudad
     * @return Un arreglo de las personajes
     */
    public ArrayList<Personaje> listaPersona(String pCiudad) {
        ArrayList<Personaje> lista=new ArrayList<>();
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList personajes=ciudad.getElementsByTagName("PersonaCercana");
           for (int i=0;i!=personajes.getLength();i++) {
               Personaje personaje=new Personaje();
                Element temp =(Element) personajes.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");
                personaje.setNombre(nombre.item(0).getTextContent());
                NodeList estado = temp.getElementsByTagName("Estado");
                personaje.setEstadoPersonacerna(estado.item(0).getTextContent());
                
                lista.add(personaje);
                
            }
            return lista;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
 
    /**
     * Metodo para editar el nombre de una ciudad 
     * @param pCiudad
     * @param pNombre 
     */
    public void editarCiudad(String pCiudad,String pNombre) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList nombre=ciudad.getElementsByTagName("Nombre");
           nombre.item(0).setTextContent(pNombre);
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult("Data.xml");
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para editar el indice de criminalidad de una ciudad
     * @param pCiudad
     * @param pIndice 
     */
    public void editarCiudad(String pCiudad,double pIndice) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList indice=ciudad.getElementsByTagName("IndiceCriminalidad");
           indice.item(0).setTextContent(String.valueOf(pIndice));
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult("Data.xml");
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para actualizar la cuenta de los eventos ganados y perdidos de un personaje
     * @param pNombreCiudad
     * @param pNombre
     * @param bandera 
     */
    public void actualizarGane(String pNombreCiudad,String pNombre,int bandera) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pNombreCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList personajes=null;
           switch (bandera) {
               case 1:
                   personajes=ciudad.getElementsByTagName("Heroe");
                   break;
               case 2:
                   personajes=ciudad.getElementsByTagName("ArchiEnemigo");
                   break;
               case 3:
                   personajes=ciudad.getElementsByTagName("Villano");
                   break;
               default:
                   break;
           }
           for (int i=0;i!=personajes.getLength();i++) {
               Element personaje=(Element) personajes.item(0);
               if (personaje.getElementsByTagName("Nombre").item(0).getTextContent().equals(pNombre)) {
                   personaje.getElementsByTagName("CantidadEventosGanados").item(0).setTextContent(String.valueOf(Integer.parseInt(personaje.getElementsByTagName("CantidadEventosGanados").item(0).getTextContent())+1));
               }
           }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult("Data.xml");
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para actualizar la cuenta de los eventos perdidos de un personaje 
     * @param pNombreCiudad
     * @param pNombre
     * @param bandera 
     */
    public void actualizarPerdido(String pNombreCiudad,String pNombre,int bandera) {
        try {
            File fXmlFile = new File("Data.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Ciudad");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");       
                
                if (nombre.item(0).getTextContent().equals(pNombreCiudad)) {
                    ciudad=temp;
                }   
            }
           NodeList personajes=null;
           switch (bandera) {
               case 1:
                   personajes=ciudad.getElementsByTagName("Heroe");
                   break;
               case 2:
                   personajes=ciudad.getElementsByTagName("ArchiEnemigo");
                   break;
               case 3:
                   personajes=ciudad.getElementsByTagName("Villano");
                   break;
               default:
                   break;
           }
           for (int i=0;i!=personajes.getLength();i++) {
               Element personaje=(Element) personajes.item(0);
               if (personaje.getElementsByTagName("Nombre").item(0).getTextContent().equals(pNombre)) {
                   personaje.getElementsByTagName("CantidadEventosPerdidos").item(0).setTextContent(String.valueOf(Integer.parseInt(personaje.getElementsByTagName("CantidadEventosPerdidos").item(0).getTextContent())+1));
               }
           }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult("Data.xml");
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
