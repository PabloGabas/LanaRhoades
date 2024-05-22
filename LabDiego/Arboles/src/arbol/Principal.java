package arbol;

import utilidades.Archivo;


public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Arbol arbol = Archivo.cargarDatos();// este es nuestro mega constructor de la clase, para usar alguna funcion de los arboles es arbol. y ahi salen todas
        arbol.obtenerProvincia(202260432);
        
        
        
        NodoArbol raiz = arbol.retornaraiz();
        if (raiz != null && raiz.persona != null) {
            System.out.println(raiz.persona.getCedula());
        } else {
            System.out.println("no sirve porque raiz y persona estan nulos en "
                    + "codigo.");
        }

        System.out.println("");
        arbol.getPreOrden(raiz);
        System.out.println("");
        

        
       
        
        
        
    }
}
