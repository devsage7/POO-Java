/*
* Laboratorio Java - 2021
* Programacion II */
/**
* @author Axel Marconi
*/

package EstructuraS;

public class Lista 
{
    //lista estatica de 10 elementos
    static int VACIA = -1;
    static int LLENA = 10;
    private String[] elementos;
    private int ult=VACIA;
    private int cursor=VACIA;
    
    public Lista() {
        elementos = new String[LLENA];
        ult=VACIA; cursor=VACIA;
    }

    public Lista( Lista l) {
        elementos = new String [LLENA];
        ult=VACIA; cursor=VACIA;
        l.reset();
        reset();
        while(!l.oos()){
            insert(l.copy());
            forward(); l.forward();
        }
    }
    
    public void reset() {
        if (oos()) cursor=VACIA;
        else cursor=0;
    }

    public void forward() {
        if (oos()) System.out.println("Operacion Invalida-No puede avanzar(oos)");
        else
        if (cursor==ult) cursor=VACIA;
        else cursor++;
    }
 
    public void insert(String x) {
        if (cursor==-1){ ult=ult+1; cursor=ult;}
            else shiftD();
        elementos[cursor]=x;
    }
       
    public void supress() {
        if (ult==0) {cursor=VACIA; ult=VACIA;}
        else shiftI();
    }
    
    public String copy() {
        if (oos()) {System.out.println("Operacion Invalida");return "-99";}
        else return elementos[cursor];
    }
    
    public Boolean isempty() {return ult==VACIA;
    }
    
    public Boolean isfull() {return ult==(LLENA -1);
    }
    
    public Boolean oos() {return cursor==VACIA;
    }
    
    private void shiftI(){
        for (int i=cursor+1; i<=ult; i++)
            elementos[i-1]=elementos[i];
            ult--; 
    }
 
    private void shiftD(){
        for (int i=ult; i>=cursor; i--)
        elementos[i+1]=elementos[i];
        ult++; 
    }
 
    public void muestroL(){
        int aux=cursor;
        System.out.println("El contenido de la lista es:");
        reset();
        while (!oos()){
        System.out.print(copy() + " - ");
        forward();}
        System.out.println();
        cursor=aux; 
    }
    
}