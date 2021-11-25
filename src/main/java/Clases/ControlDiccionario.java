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
import java.util.Scanner;
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
    String rutaDiccionario, rutaArchivo,nombreArchivo;
    Ordenamiento ordenamientos;
    boolean metodo;
    HashSet<String> palabrasIgnoradas;
    int numArchivo;

    public ControlDiccionario(JFrame frame) {
        ventanaEmergente = new VentanaOpciones(frame, true);
        ordenamientos = new Ordenamiento();
        palabrasIgnoradas = new HashSet<>();
        diccionario = new ArrayList<>();
        rutaDiccionario = "src\\main\\java\\Archivos\\diccionario.txt";
        numArchivo = 0;
    }

    public void lecturaDiccionario() {
        try {
//parsing a CSV file into BufferedReader class constructor  

            BufferedReader br = new BufferedReader(new FileReader(rutaDiccionario));
            String a = br.readLine();
            int i = 0;
            do//returns a Boolean value  
            {
                if (i % 10000.0 == 0) {
                    System.out.println("Leyendo archivo:" + i);
                }
                diccionario.add(transformarConAcentos(a));
                i++;
            } while ((a = br.readLine()) != null);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }/*
        palabrasDiccionario = new String[diccionario.size()];
        for (int i = 0; i < palabrasDiccionario.length; i++) {
            palabrasDiccionario[i] = transformarConAcentos(diccionario.get(i)).toLowerCase();
        }
        
        Arrays.sort(palabrasDiccionario);
        Arrays.sort(palabrasDiccionario);
        Arrays.sort(palabrasDiccionario);
        
            for(int i = 0;i<palabrasDiccionario.length;i++) System.out.println(i + ":" + palabrasDiccionario[i]);*/
        diccionario.sort(String::compareToIgnoreCase);
        return;
    }
    public void setMetodo(boolean metodo){
        this.metodo = metodo;
    }

    public boolean leerArchivos(String ubicacion,String nombreArchivo) {
        lecturaDiccionario();
        this.nombreArchivo = nombreArchivo;
        numArchivo++;
        rutaArchivo = ubicacion;
        crearNuevoArchivo(rutaArchivo,nombreArchivo);
        ///aqui va el metodo para crear el nuevo archivo
        File f = new File(rutaArchivo);
        String[] palabrasDiccionario = new String[diccionario.size()];
        Scanner s;
        boolean diccRecreado = false;
        ArrayList<String> palabrasNuevas = new ArrayList<>();
        String[] provisional;
        int i = 0;
        for (i = 0; i < diccionario.size(); i++) {
            palabrasDiccionario[i] = diccionario.get(i);
        }
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                //Texto sin modificaciones
                String cadenaNormal = transformarConAcentos(s.nextLine());//limpieza de caracteres no alfa numericos
                String cadena = cadenaNormal.replaceAll("\\p{P}", "");//limpieza de caracteres
                provisional = cadena.split(" ");//division de la cadena limpia en un vector de strinfs
                
                System.out.println("/*////////////////Impresion arreglo");
                for(i= 0; i<provisional.length;i++) {
                    provisional[i] = provisional[i].replaceAll("\\s","");
                    System.out.println("["+i+"]"+provisional[i]);
                }
                for (int j = 0; j < provisional.length; j++) {
                    if (!provisional[j].isEmpty() && !palabrasIgnoradas.contains(provisional[j].toLowerCase()) && !palabrasNuevas.contains(provisional[j].toLowerCase())) {
                        if (eleccionMetodo(palabrasDiccionario,provisional[j])) {
                            System.out.println("Encontrada");
                        } else {
                            System.out.println("Palabra no encontrada:" + provisional[j].toLowerCase());
                            desplegarMenu(cadenaNormal, provisional[j]);
                            switch (ventanaEmergente.getEleccion()) {
                                case 0://ignorar
                                    break;
                                case 1:
                                    palabrasIgnoradas.add(provisional[j].toLowerCase());//para que no se vuelva a marcar como error
                                    break;
                                case 2://a;adir al diccionario
                                    palabrasNuevas.add(provisional[j].toLowerCase());
                                    agregarDiccionario(provisional[j]);
                                    break;
                                case 3:// reemplazar
                                    if (ventanaEmergente.getSiCambio()) {
                                        Sustituir(provisional[j], ventanaEmergente.getNuevaPalabra());
                                        System.out.println("Si jala");
                                        cadenaNormal=cadenaNormal.replaceAll(provisional[j], ventanaEmergente.getNuevaPalabra());
                                        palabrasNuevas.add(ventanaEmergente.getNuevaPalabra().toLowerCase());
                                        agregarDiccionario(ventanaEmergente.getNuevaPalabra());
                                        System.out.println("nueva palabra:"+ventanaEmergente.getNuevaPalabra().toLowerCase());
                                    }
                                    break;
                                case 4:
                                    diccRecreado = true;
                                    System.out.println("Ingreso temirnar");
                                    recrearDiccionario();
                                    System.out.println("Si se recrea");
                                    return false;
                            }
                        }
                    }
                }
                i++;
            } if(!diccRecreado) recrearDiccionario();
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void desplegarMenu(String cadenaCompleta, String palabra) {
        ventanaEmergente.enviarTexto(cadenaCompleta, palabra);
        ventanaEmergente.getEleccion();
    }

    public String transformarConAcentos(String palabra) {
        String palabraTransformada = "";
        byte[] bytes = palabra.getBytes();
        try {
            palabraTransformada = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return palabraTransformada;
    }

    public void ordenar(ArrayList array) {
        ArrayList sortedTertiaryCollator = new ArrayList(array);
        Collator tertiaryCollator = Collator.getInstance(new Locale("es"));
        tertiaryCollator.setStrength(Collator.TERTIARY);
        sortedTertiaryCollator.sort(tertiaryCollator);
        array = sortedTertiaryCollator;
    }

    public void agregarDiccionario(String palabraNueva) {
        if(!diccionario.contains(palabraNueva))diccionario.add(palabraNueva);
        else System.out.println("Palabra ya existente en el diccionario");
    }

    public void recrearDiccionario() {
        try {
            System.out.println("Ruta directorio:"+rutaDiccionario);
            BufferedWriter bufferWritter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaDiccionario), "UTF-8"));
            BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\Archivos\\diccionario.txt"));
            ordenar();
            for (int i = 0; i < diccionario.size(); i++) {
                //System.out.println("["+i+"]"+diccionario.get(i));
                bufferWritter.write(diccionario.get(i)+"\n");
            }
            diccionario.sort(String::compareToIgnoreCase);

            bufferWritter.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ordenar(){
    ArrayList sortedTertiaryCollator = new ArrayList(diccionario);
    Collator tertiaryCollator = Collator.getInstance(new Locale("es"));
    tertiaryCollator.setStrength(Collator.TERTIARY);
    sortedTertiaryCollator.sort(tertiaryCollator);
    diccionario=sortedTertiaryCollator;
  }
    
   private void crearNuevoArchivo(String nombre,String nombreArchivo){
       String cadena = "";
       int i = 0;
       System.out.println("Nombre archivo");
       String[] nameExt = nombreArchivo.split("\\.");
       System.out.println(nameExt[0]);
       nombre = nombre.replaceAll(nombreArchivo, "");
       System.out.println("Nombre:"+nombre);
       System.out.println("Nombre archivo:"+nombreArchivo);
       File nuevoArchivo= new File(nombre+nameExt[0]+"_revisado ("+i+")"+"."+nameExt[1]);
       while(nuevoArchivo.exists()){
           i++;
           cadena =nombre+nameExt[0]+"_revisado ("+i+")"+"."+nameExt[1];
           nuevoArchivo = new File(cadena);
       }
       
       File original = new File(rutaArchivo);
       try{
           FileUtils.copyFile(original, nuevoArchivo);
       } catch (IOException ex) {
           
        }
       System.out.println("Ruta nuevo"+nuevoArchivo.getAbsolutePath());
       System.out.println("RutaOriginal:"+original.getAbsolutePath());
       rutaArchivo = nuevoArchivo.getAbsolutePath();
       System.out.println("Variable Ruta Archivo:"+rutaArchivo);
       System.out.println("Pokimon");
       
   }
   
   private boolean eleccionMetodo(String[] palabrasDiccionario,String provisional ){
       if(metodo){
           if(ordenamientos.binaria(palabrasDiccionario, provisional.toLowerCase()) != -1){
               System.out.println("Se uso binario");
               return true;
           }else return false;
       }else{
           System.out.println("Se uso hash");
           ordenamientos.Hash(palabrasDiccionario);
           return ordenamientos.funcionHash(provisional.toLowerCase());
       }
   }

    public void Sustituir(String palabraVieja, String palabraNueva) {
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
