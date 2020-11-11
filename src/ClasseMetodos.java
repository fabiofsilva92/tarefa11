import javax.swing.*;
import java.util.Random;
import java.io.*;


public class ClasseMetodos {
 
    //Cadastro de votos randomicos
    public Votação [] FCADRASTRAVOTAÇÃO (Votação [] votos)
    {
        Random gerador = new Random();
        
        for (int i = 0; i<100; i++)
        {
            votos[i].numeroCand = gerador.nextInt(31);
            votos[i].numeroSec = gerador.nextInt(11);
        }
        
        return votos;
    }
    
    //Classificação de seção
    public Votação [] FCLASSIFICASEÇÃO(Votação [] votos)
    {
        int auxCand = 0;
        int auxSec = 0;
        
        for (int i = 0 ; i<99; i++)
        {
            for(int j = i+1; j<100; j++)
            {
                if(votos[i].numeroSec >= votos[j].numeroSec)
                {
                    auxSec = votos[i].numeroSec;
                    votos[i].numeroSec = votos[j].numeroSec;
                    votos[j].numeroSec = auxSec;
                    
                    auxCand = votos[i].numeroCand;
                    votos[i].numeroCand = votos[j].numeroCand;
                    votos[j].numeroCand = auxCand;
                }
            }
        }
        
        System.out.println("Seção classificada");
        
        /*
        for (int i = 0; i<99; i++)
        {
            System.out.println("Seção: " + votos[i].numeroSec + " Candidato: " + votos[i].numeroCand);
            if(votos[i].numeroSec != votos[i+1].numeroSec)
            {
                System.out.println(" ");
            }
        } */
        
        //Classificando em ordem crescente o numero dos candidados, por cada seção
        for (int i = 0; i<99; i++)
        {
            for (int j = i+1; j<100; j++)
            {
                if(votos[i].numeroSec == votos[j].numeroSec && votos[i].numeroCand >= votos[j].numeroCand)
                {
                    auxCand = votos[i].numeroCand;
                    votos[i].numeroCand = votos[j].numeroCand;
                    votos[j].numeroCand = auxCand;
                }
            }
        }
        
        System.out.println(" ");
        System.out.println("___________");  
        System.out.println(" ");
        
        /*
        for (int i = 0; i<99; i++)
        {
            System.out.println("Seção: " + votos[i].numeroSec + " Candidato: " + votos[i].numeroCand);
            if(votos[i].numeroSec != votos[i+1].numeroSec)
            {
                System.out.println(" ");
            }
        }
        */
        return votos;
    }
    
    //Gravação de arquivos
    public void FGRAVAVOTAÇÃO(Votação [] votos) throws IOException
    {
        String fileName = "Votação2020.txt";
        
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        
        for (int i = 0; i<100; i++)
        {
            gravar.write(Integer.toString(votos[i].numeroSec)); gravar.newLine();
            gravar.write(Integer.toString(votos[i].numeroCand)); gravar.newLine();
        }
        gravar.close();
    }
}
