import javax.swing.*;
import java.util.Random;
import java.io.*;


public class ClasseMetodos {
 
    //Cadastro de votos randomicos
    public Votacao [] FCADRASTRAVOTACAO (Votacao [] votos)
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
    public Votacao [] FCLASSIFICASECAO(Votacao [] votos)
    {
        int auxCand = 0; //Auxiliar para o Bubble Sort.
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
               
        //Classificando em ordem crescente o numero dos candidados, por cada seção
        for (int i = 0; i<99; i++)
        {
            for (int j = i+1; j<100; j++)
            {
                if(votos[i].numeroSec == votos[j].numeroSec && votos[i].numeroCand >= votos[j].numeroCand) // Caso a seção seja igual, classifica os numeros dos candidatos em ordem crescente.
                {
                    auxCand = votos[i].numeroCand;
                    votos[i].numeroCand = votos[j].numeroCand;
                    votos[j].numeroCand = auxCand;
                }
            }
        }  
        return votos;
    }
    
    //Gravação de arquivos
    public void FGRAVAVOTACAO(Votacao [] votos) throws IOException
    {
        String fileName = "Votacao2020.txt"; //nome do arquivo
        
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        
        for (int i = 0; i<100; i++)
        {
            gravar.write(Integer.toString(votos[i].numeroSec)); gravar.newLine();
            gravar.write(Integer.toString(votos[i].numeroCand)); gravar.newLine();
        }
        gravar.close();
    }
    
    //Novo menu de indicadores
    public void indicadores () throws IOException
    {
        ClasseIndicador ind = new ClasseIndicador(); //Instanciando a classe de indicadores
        int [] contador = new int [11]; //Variavel contadora para organizar a quantidade de votos.
        
        Votacao [] votosInd = new Votacao [100]; //Criando a variavel para os votos nos indicadores
        
        for(int i = 0; i<100; i++) //Criando os tipos de dados na classe abstrata
        {
            votosInd[i] = new Votacao();
        }
        
        String filename = "Votacao2020.txt";
        
        BufferedReader ler = new BufferedReader(new FileReader(filename));
        
        for(int i = 0; i<100; i++) //lendo a gravação feita nos metodos anteriores.
        {
            votosInd[i].numeroSec = Integer.parseInt(ler.readLine());
            votosInd[i].numeroCand = Integer.parseInt(ler.readLine());
        }
        
        int[][] candidatoVoto = new int [30][2];
        
        int opc = 0;
        
        while(opc!=9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Estatísticas de votação 2020 \n 1 – Quantidade Eleitores por Seção \n 2 –Seção com Maior e Menor número de Eleitores  \n 3 – Quantidade de votos por candidato \n 4 – 10 primeiros colocadas (nro  cand. e qtd votos ) \n 9 - Finaliza"));
            
            switch(opc)
            {
                case 1 : contador = ind.qtdSecao(votosInd) ;
                break;
                case 2 : ind.ClassificaQtdSecao(contador);
                break;
                case 3 : candidatoVoto = ind.QtdVotosCandidato(votosInd);
                break;
                case 4 : ind.ColocacaoCand(candidatoVoto);
                break;
                case 9 : JOptionPane.showMessageDialog(null, "Obrigado por utilizar a aplicação");
                break;
                
                default: JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}
