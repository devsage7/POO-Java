/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ObjetosU;
import java.util.ArrayList;       
import java.util.Scanner;

/**
 *
 * @author Axel Marconi 
 */

public class Docente extends PersUniv{
    
    private String Cargo;
    private ArrayList <String> Materias;
    
    public Docente(){
        super();
        Cargo = "Desconocido";
        Materias = new ArrayList<String>();
    }
    
    public Docente(String nom, String doc, String dir, int nac[], String fac, String carr, int ingre[], String carg, ArrayList<String> mate){
        super(nom,doc,dir,nac,fac,carr,ingre);
        Cargo = carg;
        Materias = new ArrayList<String>();
        Materias = mate;
    }
    
    public Docente(Docente d){
        super(d);
        Cargo = d.Cargo;
        Materias = d.Materias;
    }
    
    public String getCargo(){
        return Cargo;
    }
    
    public ArrayList<String> getMat(){
        return Materias;
    }
    
    public void setCargo(String carg){
        Cargo = carg;
    }
    
    public void addMat(String materia){
        Materias.add(materia);
    }
    
    public void delMat(String materia){
        int contador = 0;
        while (!Materias.isEmpty()){
            if (materia.equals(Materias.get(contador))){
                Materias.remove(contador);
                contador++;
            }
        }
    }
    
    public void showMats(){
        for(String m : Materias){
            System.out.println("-"+m+"\n");
        }
    }
    
    public void register(Docente persona){
        Persona docaux = new Docente();
        int opcion,mataux,i;
        String elem = new String();
        String mats = new String();
        Scanner reader = new Scanner(System.in);
        
        super.register(persona);
        System.out.print("Ingrese cargo: ");
        elem = reader.nextLine();
        persona.setCargo(elem);
                
        System.out.println("¿Desea cargar las materias que dicta?");
        System.out.print("1-Si\n2-No\n");
        opcion = reader.nextInt();
        if (opcion==1){
            System.out.println("¿Cuántas materias cargará?");
            mataux = reader.nextInt();
            System.out.println();
            i=0;
            reader.nextLine();
            do{
                System.out.print("Ingrese materia "+(i+1)+": ");
                mats = reader.nextLine();
                persona.addMat(mats);
                System.out.println("toque <enter> para confirmar");
                reader.nextLine();
                System.out.println("Materia cargada con éxito.\n"); 
                i++;
            }while (i<mataux);

        }
    }
    
    /**
     *
     * @return
     */
    
    @Override
    public String toString(){
        return ""+super.toString()+"\n-Cargo: "+Cargo+"\n-Materias que dicta: "+Materias.toString();
    }
    
    
}
    
    

