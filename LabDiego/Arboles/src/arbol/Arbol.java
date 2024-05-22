package arbol;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Arbol {

    private NodoArbol nodoar;

    public Arbol() {
        nodoar = null;

    }
    public ArrayList<String> obtenerProvincia(int cedula){
        ArrayList<String> lista =  new ArrayList();
        nodoar.busquedaProvincia(lista, cedula);
        return lista;
        
    }
    public NodoArbol retornaraiz() {
        return (nodoar);
    }

  
    public synchronized void insertarNodo(Persona nuevaPersona) {

        if (nodoar == null) {
            nodoar = new NodoArbol(nuevaPersona);
            System.out.println("\nInsertado en la Raiz...");
        } else {
            nodoar.insertar(nuevaPersona);
        }
    }

    public synchronized void getInOrden(NodoArbol raiz) { 
        if (raiz.li != null) {
            getInOrden(raiz.li);
        }

        System.out.print(" "+raiz.persona.getCedula());

        if (raiz.ld != null) {
            getInOrden(raiz.ld);
        }
    }

    public synchronized void getPreOrden(NodoArbol raiz) { 
        
       System.out.print(" "+raiz.persona.getCedula());

        if (raiz.li != null) {
            getPreOrden(raiz.li);
        }

        if (raiz.ld != null) {
            getPreOrden(raiz.ld);
        }
    }

    public synchronized void getPostOrden(NodoArbol raiz) { // Funcion muestra en Preorden //  3  - 1 -  7 - 9 - 8 - 5 

        if (raiz.li != null) {//1
            getPostOrden(raiz.li);//visita en Orden árbol izquierdo
        }

        if (raiz.ld != null) {//3
            getPostOrden(raiz.ld);//Visita EnOrden árbol derecho
        }
        System.out.print(" "+raiz.persona.getCedula());
    }

    public synchronized void getHojas(NodoArbol raiz) {

        if (raiz.li == null && raiz.ld == null) {//1
            System.out.println("hoja: " + raiz.dato);//visita en Orden árbol izquierdo
        }

        if (raiz.li != null) {
            getHojas(raiz.li);
        }
        if (raiz.ld != null) {
            getHojas(raiz.ld);
        }
    }

    public synchronized void getPadres(NodoArbol raiz) {

        if (raiz.li != null || raiz.ld != null) {//1
            System.out.println("Padre: " + raiz.dato);//visita en Orden árbol izquierdo
        }

        if (raiz.li != null) {
            getPadres(raiz.li);
        }
        if (raiz.ld != null) {
            getPadres(raiz.ld);
        }
    }

    public synchronized int getNivel(NodoArbol raiz, int nivel) {

        if (raiz.li == null && raiz.ld == null) {//1
            System.out.println("Nivel: " + nivel);//visita en Orden árbol izquierdo
            return nivel;
        }

        if (raiz.li != null) {
            return getNivel(raiz.li, nivel + 1);
        }
        if (raiz.ld != null) {
            return getNivel(raiz.ld, nivel + 1);
        }
        
       return 0;
    }
}// fin class Arbol

