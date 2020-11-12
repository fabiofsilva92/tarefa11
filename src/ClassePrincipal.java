import java.io.IOException;
import javax.swing.*;
import java.io.*;


public class ClassePrincipal  {
    
    public static void main (String args[]) throws IOException
    {
        
        Votação [] votos = new Votação [100];
        ClasseMetodos m = new ClasseMetodos();
        
        int opc = 0;
        
        for (int i = 0; i<100; i++)
        {
            votos[i] = new Votação();
        }
        
        while(opc!=9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Carregar Seção/Número Eleitor  \n 2 – Classificar por Seção \n 3 – Gravar Registros \n 4 – Mostrar Indicadores \n 9 - Finalizar"));
            
            switch(opc)
            {
                case 1 : m.FCADRASTRAVOTAÇÃO(votos) ;
                break;
                case 2 : m.FCLASSIFICASEÇÃO(votos);
                break;
                case 3 : m.FGRAVAVOTAÇÃO(votos);
                break;
                case 4 : indicadores();
                break;
                case 9: JOptionPane.showMessageDialog(null, "Obrigado por utilizar a aplicação.");
                break;
                
                default: JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }   
    }
    
    public static void indicadores () throws IOException
    {
        ClasseIndicador ind = new ClasseIndicador();
        int [] contador = new int [11];
        int novo = 0;
        int teste= 0;
        
        
        Votação [] votosInd = new Votação [100]; //Criando a variavel para os votos nos indicadores
        
        for(int i = 0; i<100; i++)
        {
            votosInd[i] = new Votação();
        }
        
        String filename = "Votação2020.txt";
        
        BufferedReader ler = new BufferedReader(new FileReader(filename));
        
        for(int i = 0; i<100; i++) //lendo a gravação feita nos metodos anteriores.
        {
            votosInd[i].numeroSec = Integer.parseInt(ler.readLine());
            votosInd[i].numeroCand = Integer.parseInt(ler.readLine());
        }
        
        int opc = 0;
        
        while(opc!=9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Estatísticas de votação 2020 \n 1 – Quantidade Eleitores por Seção \n 2 –Seção com Maior e Menor número de Eleitores  \n 3 – Quantidade de votos por candidato \n 4 – 10 primeiros colocadas (nro  cand. e qtd votos ) \n 9 - Finaliza"));
            
            switch(opc)
            {
                case 1 : contador = ind.qtdSeção(votosInd) ;
                break;
                case 2 : ind.ClassificaQtdSeção(contador);
                break;
                case 3 : ind.QtdVotosCandidato(votosInd);
                break;
                case 4 : ;
                break;
                case 9 : JOptionPane.showMessageDialog(null, "Obrigado por utilizar a aplicação");
                break;
                
                default:
            }
        }
    }
    
}
