
package EstructuraS;
import ObjetosU.*;
//import java.util.ArrayList; (Tarea 5)

public interface FuncEstr {
    public int cardinalidad (); //retorna la cantidad de elementos de la estructura
    public Boolean inStruc(Persona p); //retorna true si arg. esta en la estruc., sino false
    public void muestroEstruc(); // muestra contenido ded la estruc. por pantalla.
    
    
    //Tarea 5
    
    //public ArrayList filter(Object p); // Busca elementos de la estructura que
                                       // contengan un campo especifico de p y retorna esos elementos 
                                       // en un arraylist. Ej: Buscar en una estructura alumnos de computación...
                                       // y devolver el arraylist con los nombres de todos esos alumnos.
    
    //public void map(Object p); // Aplica un método a todos los elementos de una estructura.
                               // Ej: Setear la misma facultad a todas las personas de una lista.
}
