/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JFrame;
import java.io.BufferedWriter;
import java.text.Collator;
import java.util.Locale;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author felix_5bh1a4y
 */
public class ControlDiccionario {

    ArrayList<String> diccionario;
    VentanaOpciones ventanaEmergente;
    String rutaDiccionario, rutaArchivo, nombreArchivo;
    Ordenamiento ordenamientos;
    boolean metodo;
    HashSet<String> palabrasIgnoradas;
    int palabrasTotales, palabrasIgnorar, palabrasCorregidas, palabrasAgregadas;

    public ControlDiccionario(JFrame frame) {
        ventanaEmergente = new VentanaOpciones(frame, true);
        ordenamientos = new Ordenamiento();
        palabrasIgnoradas = new HashSet<>();
        diccionario = new ArrayList<>();
        rutaDiccionario = "src\\main\\java\\Archivos\\diccionario.txt";
    }

       //lectura de diccionario, y deposito de las palabras en un arrayList
    public void lecturaDiccionario() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaDiccionario));
            String a = br.readLine();
            int i = 0;
            do {
                if (i % 10000.0 == 0) {
                    System.out.println("Leyendo archivo:" + i);
                }
                diccionario.add(transformarConAcentos(a));
                i++;
            } while ((a = br.readLine()) != null);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            diccionario.sort(String::compareToIgnoreCase);
            return;
        }
    }

    public void setMetodo(boolean metodo) {
        this.metodo = metodo;
    }

    public void leerArchivos(String ubicacion, String nombreArchivo) {

        palabrasTotales = palabrasIgnorar = palabrasCorregidas = palabrasAgregadas = 0;
        lecturaDiccionario();//creacion del diccionario
        this.nombreArchivo = nombreArchivo;
        rutaArchivo = ubicacion;
        crearNuevoArchivo(rutaArchivo, nombreArchivo);//creamos una copia del archivo elegido
        //y es sobre esta copia haremos las correcciones necesarias.
        File f = new File(rutaArchivo);
        String[] palabrasDiccionario = new String[diccionario.size()];
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            boolean diccRecreado = false;
            ArrayList<String> palabrasNuevas = new ArrayList<>();
            String[] provisional;
            int i = 0;
            for (i = 0; i < diccionario.size(); i++) {
                palabrasDiccionario[i] = diccionario.get(i);
            }
            try {
                String mientras;
                while ((mientras = br.readLine()) != null) {
                    String cadenaNormal = transformarConAcentos(mientras);//transformacion de cadena
                    //para forzar una cadena con acentos en caso de contenerlos y evitar simbolos extra;os
                    String cadena = cadenaNormal.replaceAll("\\p{P}", "");//limpieza de simbolos de puntuacion
                    provisional = cadena.split(" ");//division de la cadena limpia en un vector de strings
                    for (i = 0; i < provisional.length; i++) {
                        provisional[i] = provisional[i].replaceAll("\\s", "");//limpieza de tabuladores en caso de ser necesario
                    }
                    palabrasTotales += provisional.length;
                    if (ventanaEmergente.getEleccion() != -1) {//Que la ventana tenga un valor de -1, indica que el usuario hizo click en el boton terminar
                        //lo que quiere decir que correremos el programa unicamente para contar las palabras, por lo que no es necesario
                        //buscar en el diccionario las palabras restantes
                        for (int j = 0; j < provisional.length; j++) {//bucle que recorre el arreglo con el fin de buscar
                            //cada una de las palabras con el metodo seleccionado por el usuario
                            if (!provisional[j].isEmpty() && !palabrasIgnoradas.contains(provisional[j].toLowerCase()) && !palabrasNuevas.contains(provisional[j].toLowerCase()) && ventanaEmergente.getEleccion() != -1) {
                                if (eleccionMetodo(palabrasDiccionario, provisional[j]) && ventanaEmergente.getEleccion() != -1) {
                                } else {
                                    ventanaEmergente.enviarTexto(cadenaNormal, provisional[j]);//metodo que despliega el Jdialog
                                    //correspondiente, en donde se muestra la linea leida, y la palabra no encontrada
                                    switch (ventanaEmergente.getEleccion()) {
                                        case 0://ignorar
                                            palabrasIgnorar++;
                                            System.out.println("Palabras ignoradas1:" + palabrasIgnorar);
                                            break;
                                        case 1:
                                            palabrasIgnoradas.add(provisional[j].toLowerCase());//para que no se vuelva a marcar como error
                                            palabrasIgnorar++;
                                            System.out.println("Palabras ignoradas1:" + palabrasIgnorar);
                                            break;
                                        case 2://a;adir al diccionario
                                            palabrasNuevas.add(provisional[j].toLowerCase());
                                            agregarDiccionario(provisional[j]);
                                            System.out.println("Palabrasagregadas:" + palabrasAgregadas);
                                            break;
                                        case 3:// reemplazar
                                            if (ventanaEmergente.getSiCambio()) {
                                                sustituir(provisional[j], ventanaEmergente.getNuevaPalabra());
                                                cadenaNormal = cadenaNormal.replaceAll(provisional[j], ventanaEmergente.getNuevaPalabra());
                                                palabrasNuevas.add(ventanaEmergente.getNuevaPalabra().toLowerCase());//a;adimos la palabra
                                                //a un hashset para no volver a buscarla
                                                agregarDiccionario(ventanaEmergente.getNuevaPalabra());//la agregamos al diccionario
                                                //en caso de que no este en este
                                                palabrasCorregidas++;
                                            }
                                            break;
                                        case 4:
                                            diccRecreado = true;
                                            recrearDiccionario();//metodo utilziado para sobreescribir el diccionario con las palabras nuevas
                                            ventanaEmergente.setEleccion(-1);
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    i++;
                }
                if (!diccRecreado) {
                    recrearDiccionario();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                diccionario.sort(String::compareToIgnoreCase);
            }
            ventanaEmergente.modificarInterfaz(palabrasIgnorar, palabrasAgregadas, palabrasCorregidas, palabrasTotales);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String transformarConAcentos(String palabra) {
        String palabraTransformada = "";
        byte[] bytes = palabra.getBytes();
        try {
            palabraTransformada = new String(bytes, "UTF-8");//transformamos la palabra 
            //recibida a una codificacion que permita mostrar los acentos
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return palabraTransformada;
    }

    public void ordenar(ArrayList array) {//Metodo utilizado para ordenar el arrayList 
        //del diccionario de manera correcta
        ArrayList sortedTertiaryCollator = new ArrayList(array);
        Collator tertiaryCollator = Collator.getInstance(new Locale("es"));
        tertiaryCollator.setStrength(Collator.TERTIARY);
        sortedTertiaryCollator.sort(tertiaryCollator);
        array = sortedTertiaryCollator;
    }

    public void agregarDiccionario(String palabraNueva) {
        if (!diccionario.contains(palabraNueva)) {
            diccionario.add(palabraNueva);
            palabrasAgregadas++;
        } else {
            System.out.println("Palabra ya existente en el diccionario");
        }
    }

    public void recrearDiccionario() {
        try {
            System.out.println("Ruta directorio:" + rutaDiccionario);
            BufferedWriter bufferWritter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaDiccionario), "UTF-8"));
            ordenar();
            for (int i = 0; i < diccionario.size(); i++) {
                bufferWritter.write(diccionario.get(i) + "\n");
            }
            diccionario.sort(String::compareToIgnoreCase);
            bufferWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ordenar() {
        ArrayList sortedTertiaryCollator = new ArrayList(diccionario);
        Collator tertiaryCollator = Collator.getInstance(new Locale("es"));
        tertiaryCollator.setStrength(Collator.TERTIARY);
        sortedTertiaryCollator.sort(tertiaryCollator);
        diccionario = sortedTertiaryCollator;
    }

    private void crearNuevoArchivo(String nombre, String nombreArchivo) {
        int i = 0;
        String[] nameExt = nombreArchivo.split("\\.");
        nombre = nombre.replaceAll(nombreArchivo, "");
        File nuevoArchivo = new File(nombre + nameExt[0] + "_revisado (" + i + ")" + "." + nameExt[1]);
        while (nuevoArchivo.exists()) {
            i++;
            nuevoArchivo = new File( nombre + nameExt[0] + "_revisado (" + i + ")" + "." + nameExt[1]);
        }

        File original = new File(rutaArchivo);
        try {
            FileUtils.copyFile(original, nuevoArchivo);
        } catch (IOException ex) {

        }
        rutaArchivo = nuevoArchivo.getAbsolutePath();

    }

    private boolean eleccionMetodo(String[] palabrasDiccionario, String provisional) {
        if (metodo) {
            System.out.println("Se uso binaria");
            if (ordenamientos.binaria(palabrasDiccionario, provisional.toLowerCase()) != -1) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("se uso hash");
            ordenamientos.Hash(palabrasDiccionario);
            return ordenamientos.funcionHash(provisional.toLowerCase());
        }
    }

    public void sustituir(String palabraVieja, String palabraNueva) {
        File textFile = new File(rutaArchivo);
        try {
            String data = FileUtils.readFileToString(textFile);
            data = data.replace(palabraVieja, palabraNueva);
            FileUtils.writeStringToFile(textFile, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
