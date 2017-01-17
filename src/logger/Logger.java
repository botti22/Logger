/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

/**
 *
 * @author Ale
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Logger {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException  {
        
        
        Scanner s = new Scanner(System.in);
        String percorso;
        System.out.println("Seleziona il percorso dove creare il datalog: ");
        percorso=s.nextLine();
        String frase;
        String elimina;

         try {
            File datalog = new File(percorso); 
            

            if (datalog.exists()) {
            System.out.println("Il datalog nel percorso "+percorso+" già esiste, vuoi eliminarlo? (S/N): ");
            elimina=s.nextLine();
            if ("S".equals(elimina)) {
                datalog.delete();
                System.out.println("File eliminato correttamente.");
                
            } else if ("N".equals(elimina)) {
                try (BufferedReader br = new BufferedReader(new FileReader(datalog))) {
                    
                    String Linea;
                    while ((Linea = br.readLine()) != null) {
		        System.out.println("All'interno del file c'è scritto: "+Linea);
		    }
                }
                
                FileWriter scrivi = new FileWriter(datalog, true);
                BufferedWriter bw = new BufferedWriter(scrivi);
                    System.out.print("Scrivi nel file:");
                    bw.write(frase=s.nextLine());
                    bw.flush();
                    bw.close();
            }else {
                System.out.println("Non hai premuto ne N ne S, il programma si chiuderà.");
                System.exit(0);
            }
            
            }
                else if (datalog.createNewFile()) {
                    System.out.println("Il datalog nel percorso "+percorso+" è stato creato.");
                    FileWriter scrivi = new FileWriter(datalog, true);
                    BufferedWriter bw = new BufferedWriter(scrivi);
                    System.out.print("Scrivi nel file:");
                    bw.write(frase=s.nextLine());
                    bw.flush();
                    bw.close();
                }
                
                else {
                System.out.println("Il file non può essere creato");
                } 
         }        
            catch (IOException e) {
                System.out.println("Impossibile creare il datalog: "+e);
                }
            }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


                    
                    
            
        
    
    

    

