/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import arbol.Arbol;
import arbol.Persona;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pablonoguera
 */
public class Archivo {
    public static Arbol cargarDatos(){
        Arbol arbol =new Arbol();
        FileInputStream inputStream =null;
        Scanner sc = null;
        try{
            inputStream = new FileInputStream("Datos.txt");
            sc =new Scanner(inputStream, "UTF-8");
            while(sc.hasNextLine()){
                String[] datos = sc.nextLine().split(",");
                Persona nuevaPersona=new Persona(datos[0]);
                arbol.insertarNodo(nuevaPersona);
                
                
                
           
            if (arbol.retornaraiz()!= null) {// revisar el de getHojas porque me da 0
                arbol.getPostOrden(arbol.retornaraiz());
            }
            
            
                
                
            }
            if(sc.ioException() != null){
                throw sc.ioException();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(inputStream != null){
                try{
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(sc != null){
                sc.close();
            }
        }
        return arbol;
        
    }
    
}
