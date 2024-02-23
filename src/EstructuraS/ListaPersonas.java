/*
 */
package EstructuraS;

import ObjetosU.*;

public class ListaPersonas implements FuncEstr {

    //lista estatica de 20 elementos
    static int VACIA = -1;
    static int LLENA = 20;
    private Persona[] elementos;
    private int ult;
    private int cursor;

    public ListaPersonas() {
        elementos = new Persona[LLENA];
        ult = VACIA;
        cursor = VACIA;
    }

    public ListaPersonas(ListaPersonas l) {
        elementos = new Persona[LLENA];
        ult = VACIA;
        cursor = VACIA;
        l.reset();
        reset();
        while (!l.oos()) {
            insert(l.copy());
            forward();
            l.forward();
        }
    }

    public void reset() {
        if (!isempty()) 
            cursor = 0;
            else
                cursor = VACIA;
    }

    public void forward() {
        if (cursor == ult) {
            cursor = VACIA;
        }   else{
                cursor++;
            }
    }

    public void insert(Persona x) {
        if (cursor == -1) {
            ult = ult + 1;
            cursor = ult;
        } else {
            shiftD();
        }
        elementos[cursor] = x;
    }

    public void supress() {
        elementos[cursor] = null;
        if (ult == 0) {
            cursor = VACIA;
            ult = VACIA;
        } else {
            shiftI();
        }
    }

    public Persona copy() {
        Persona aux = new Persona();
        
        if (elementos[cursor] instanceof Docente) {
            aux = new Docente((Docente) elementos[cursor]);
            
        } else {
            if (elementos[cursor] instanceof AlumnoPostGrado) {
                String auxiliar = new String(((AlumnoPostGrado)elementos[cursor]).getcarPos()); //Tuve que usar este string para pasarlo como argumento
                                                                                                //en el constructor de APG. Probé pasando directamente el elemento
                                                                                                //en un constructor de copia como en los otros casos,
                                                                                                //pero el campo CarreraDePostGrado de aux quedaba en null... esto
                                                                                                //en los otros casos (Alumno y Docente) no pasa. No encontré otra forma de hacerlo funcionar.
                                                                                                
                                                                                                //En el elemento se carga bien la carrera de post grado, por alguna razón el constructor de copia 
                                                                                                //no lo copia completo.
                aux = new AlumnoPostGrado   (((Alumno)elementos[cursor]).getNbre(),
                                            ((Alumno)elementos[cursor]).getDoc(),
                                            ((Alumno)elementos[cursor]).getDir(),
                                            ((Alumno)elementos[cursor]).getfNac(),
                                            ((Alumno)elementos[cursor]).getFac(),
                                            ((Alumno)elementos[cursor]).getCar(),
                                            ((Alumno)elementos[cursor]).getfIng(),
                                            ((Alumno)elementos[cursor]).getReg(),auxiliar); 
                
            } else {
                if (elementos[cursor] instanceof Alumno) {
                    aux = new Alumno((Alumno) elementos[cursor]);
                }
            }
            return aux;
        }
        return aux;
    }

    public Boolean isempty() {
        return ult == VACIA;
    }

    public Boolean isfull() {
        return ult == (LLENA - 1);
    }

    public Boolean oos() {
        return cursor == VACIA;
    }

    private void shiftI() {
        for (int i = cursor + 1; i <= ult; i++) {
            elementos[i - 1] = elementos[i];
        }
        ult--;
    }

    private void shiftD() {
        for (int i = ult; i >= cursor; i--) {
            elementos[i + 1] = elementos[i];
        }
        ult++;
    }

    @Override
    public int cardinalidad() {
        if (isempty()) {
            return 0;
        } else {
            return (ult + 1);
        }
    }

    @Override
    public Boolean inStruc(Persona p) {
        reset();
        while (!oos()) {
            if ((p.getDoc()).equals((this.elementos[cursor].getDoc()))) {
                return true;
            } else {
                forward();
            }
        }
        return false;
    }

    @Override
    public void muestroEstruc() {
        System.out.print("Lista de personas registradas: \n");
        reset();
        while (!oos()) {
            System.out.println("----------------------------");
            System.out.println((elementos[cursor]).toString());
            System.out.println();
            forward();
        }
        System.out.println("----------------------------");
        System.out.println("Fin de la lista.");
    }
}
