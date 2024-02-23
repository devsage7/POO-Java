
package Ejecuciones;

import EstructuraS.*;
import ObjetosU.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main3 {

    public static void main(String[] args) {

        ListaPersonas l = new ListaPersonas(); //lista

        //auxiliares
        Scanner reader = new Scanner(System.in);
        Persona aux = new Persona();
        int op = 1;
        int clase;

        //Menú
        while (op != 0) {
            System.out.println("Lista de Personas - Menu de Opciones");
            System.out.println("------------------------------------");
            System.out.println("1-Pararse en primer elemento");
            System.out.println("2-Avanzar al prox. elemento");
            System.out.println("3-Preguntar si esta vacia");
            System.out.println("4-Preguntar si esta llena");
            System.out.println("5-Preguntar si esta fuera de la estructura");
            System.out.println("6-Insertar elemento");
            System.out.println("7-Suprimir elemento");
            System.out.println("8-Mostrar toda la lista");
            System.out.println("9-Ver cardinalidad de la lista");
            System.out.println("10-Preguntar si una persona está en la lista");
            System.out.println("11-Mostrar datos del elemento actual"); //cursor
            System.out.println("0-Salir");
            System.out.print("Ingrese Opcion:");
            op = reader.nextInt();
            System.out.println();

            switch (op) {

                case 0:
                    continue;

                case 1:
                    l.reset();
                    System.out.println("Ahora está parado en el primer elemento.");
                    break;

                case 2:
                    l.forward();
                    System.out.println("Avanzó al siguiente elemento.");
                    break;

                case 3:
                    if (l.isempty()) {
                        System.out.println("Lista Vacia");
                    } else {
                        System.out.println("Lista NO Vacia");
                    }
                    break;

                case 4:
                    if (l.isfull()) {
                        System.out.println("Lista Llena");
                    } else {
                        System.out.println("Lista NO Llena");
                    }
                    break;

                case 5:
                    if (l.oos()) {
                        System.out.println("Está fuera de la estructura");
                    } else {
                        System.out.println(" NO está fuera de la estructura");
                    }
                    break;

                case 6:
                    if (l.isfull()) {
                        System.out.println("Operación inválida - Lista LLENA");
                    } else {
                        System.out.println("¿Qué quiere cargar?");
                        System.out.println("1-Alumno\n2-Alumno de Post Grado\n3-Docente\n0-Volver");
                        clase = reader.nextInt();
                        switch (clase) {
                            case 0:
                                continue;

                            case 1:
                                Alumno a = new Alumno();
                                a.register((Alumno) a);
                                l.insert((Alumno) a);
                                System.out.println();
                                System.out.println("Alumno cargado con éxito.");
                                break;

                            case 2:
                                AlumnoPostGrado apg = new AlumnoPostGrado();
                                apg.register((AlumnoPostGrado) apg);
                                l.insert(apg);
                                System.out.println();
                                System.out.println("Alumno de PostGrado cargado con éxito.");
                                break;

                            case 3:
                                Docente d = new Docente();
                                d.register((Docente) d);
                                l.insert((Docente) d);
                                System.out.println();
                                System.out.println("Docente cargado con éxito.");
                                break;

                            default:
                                System.out.println("Ingrese una opción válida.");
                        } //fin switch(clase)
                    }//fin-else(carga)
                    break;
                //fin case 6 

                case 7:
                    if (l.isempty()) {
                        System.out.println(" Operacion invalida-Lista VACIA ");
                    } else {
                        if (!l.oos()) {
                            System.out.println("¿Seguro que quiere eliminar éste elemento?");
                            System.out.println("1-Eliminar\n2-Cancelar");
                            switch (reader.nextInt()) {
                                case 1:
                                    l.supress();
                                    System.out.println("Elemento eliminado.");
                                    break;
                                case 2:
                                    System.out.println("Operación cancelada.");
                                    break;
                                default:
                                    System.out.println("Ingrese una opción válida.");
                            }
                        } else {
                            System.out.println(" Operacion invalida-Fuera de la estructura ");
                        }
                    }
                    break;

                case 8:
                    if (l.isempty()) {
                        System.out.println(" Operacion invalida-Lista VACIA ");
                    } else {
                        l.muestroEstruc();
                    }
                    break;

                case 9:
                    System.out.println("La cardinalidad de la lista es: " + l.cardinalidad());
                    break;

                case 10:
                    if (!l.isempty()) {
                        System.out.print("Ingrese el nro. de documento de la persona: ");
                        aux.setDoc(reader.next());
                        System.out.println();
                        if ((l.inStruc(aux))) {
                            System.out.println("Está en la lista");
                        } else {
                            System.out.println("NO está en la lista");
                        }
                        break;
                    } else {
                        System.out.println(" Operacion invalida-Lista VACIA ");
                    }
                    break;

                case 11:
                    if (l.isempty()) {
                        System.out.println(" Operacion invalida-Lista VACIA ");
                    } else {
                        if (!l.oos()) {
                            System.out.println("" + (l.copy()).toString());
                        } else {
                            System.out.println(" Operacion invalida-Fuera de la estructura");
                        }
                    }
                    break;

                default:
                    System.out.println("Ingrese una opción válida.");
            }//fin switch(opción)

            reader.nextLine();
            System.out.println();
            System.out.print(" toque <enter> para continuar");
            reader.nextLine(); // limpio tecla
            System.out.println();

        }//fin Menú 

        System.out.println(" Fin Ejecucion");

    }

}

