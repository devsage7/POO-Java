package Ejecuciones;

import EstructuraS.*;
import ObjetosU.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main1 
{
    public static void main(String[] args) 
    {
    
        Lista l1=new Lista();
        Scanner reader = new Scanner(System.in);

        int op=1; String elem;

        while (op!= 0)
        {
            System.out.println("Lista de Enteros - Menu de Opciones");
            System.out.println("1-Pararse en 1er elemento");
            System.out.println("2-Avanzar al prox. elemento");
            System.out.println("3-preguntar si esta vacia");
            System.out.println("4-preguntar si esta llena");
            System.out.println("5-Preguntar si esta afuera de la estructura");
            System.out.println("6-Insertar elemento");
            System.out.println("7-Suprimir elemento");
            System.out.println("8-Muestra toda la lista");
            System.out.println("0-Salir");
            System.out.print("Ingrese Opcion:");
            op= reader.nextInt();
            System.out.println();
            switch (op)
            {
                case 0: continue;

                case 1: l1.reset();break;

                case 2: l1.forward();break;

                case 3: if (l1.isempty())System.out.println("Lista Vacia");
                        else 
                            System.out.println("Lista NO Vacia");break;

                case 4: if (l1.isfull()) System.out.println("Lista Llena");
                        else 
                            System.out.println("Lista NO Llena");break;

                case 5: if (l1.oos()) System.out.println("Fuera de la estructura");
                        else 
                            System.out.println(" NO esta fuera de la estructura");break;

                case 6: if (l1.isfull()) System.out.println(" Operacion invalida-Lista LLENA ");
                        else 
                        { 
                            System.out.print(" Ingrese elemento a insertar (int):");
                            elem=reader.next();
                            System.out.println();
                            l1.insert(elem);
                        }break;

                case 7: if (l1.isempty()) System.out.println(" Operacion invalida-Lista VACIA ");
                        else 
                            l1.supress();break;

                case 8: if (l1.isempty()) System.out.println(" Operacion invalida-Lista VACIA ");
                        else 
                            l1.muestroL();break;

                default: System.out.println(" Opcion equivocada");
            } // fin switch
            reader.nextLine(); // limpio \n ultimo int
            System.out.print(" toque <enter> para continuar");
            reader.nextLine(); // limpio tecla
            System.out.println();
        }// fin while

        System.out.println(" Fin Ejecucion");

    }//fin Main1
    
}//fin clase


/*
- para el objeto de tipo Lista:

1. Cuáles son sus atributos? Qué relación hay entre los atributos y el estado de un
objeto?
-Los atributos almacenan valores que representan el estado de un objeto.
-Atributos: VACIA, LLENA, elementos, ult, cursor

2. Cuáles son los servicios que brinda? Servicios y métodos significan lo mismo?
-Servicios: Constructores, reset, forward, insert, supress, copy,
           isempty, isfull, oos, muestroL.
-Servicios son los métodos de acceso público, los métodos privados son auxiliares.

3. Cuántos CONSTRUCTORES tiene?
-Tiene 2 constructores.

4. Para qué sirven los métodos constructores?
-Sirven para pedir memoria e inicializar con valores deseados los atributos de un objeto.

5. Qué significa que existan varios constructores?
-Significa que se puede invocar con diferentes argumentos.

6. Qué pasa si no hay ninguno?
-Se crea uno por defecto (sin argumentos).

7. Analice el tipo usado para el campo elementos y como es manipulado en los
constructores.
-elementos es un array de Strings (Despues de Tarea 5).
-El primer constructor le asigna memoria para 10 elementos.
-El segundo tambien le asigna memoria, pero además le mete los elementos de otra lista 
pasada como argumento.


- para el proyecto desarrollado:

1. Qué método es el que responde el mensaje de ejecutar el proyecto (dicho de otra
forma, cuál es el programa principal del proyecto)?
-El programa principal es el método "main" de la clase Main1.

2. Cuántas variables de instancias de tipo Lista se definen? Porqué puede hacerlo?
-Se define una sola.
-Se puede hacer porque existe la clase Lista.

3. Qué sucede si no existe un programa principal en el proyecto?
-No se puede ejecutar el proyecto.

*/