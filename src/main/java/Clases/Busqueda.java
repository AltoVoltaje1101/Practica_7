/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author felix_5bh1a4y
 */
public class Busqueda {

    HashMap<Integer, String> elementos;

    public Busqueda() {
        elementos = new HashMap();
    }

    public static int binaria(String[] a, String x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid].toLowerCase().compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].toLowerCase().compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public void Hash(String[] diccionario) {
        int indice = 0;
        for (int i = 0; i < diccionario.length; i++) {
            String elemento = diccionario[i];
            indice = indice + elemento.hashCode();
            elementos.put(indice, elemento.toLowerCase());
        }
    }

    public boolean funcionHash(String x) {
        if (elementos.containsValue(x)) {
            return true;
        } else {
            return false;
        }

    }
}
