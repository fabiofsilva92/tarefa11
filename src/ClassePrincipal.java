import java.io.IOException;
import javax.swing.*;
import java.io.*;

public class ClassePrincipal  { //Classe principal
    
    public static void main (String args[]) throws IOException
    {
        
        Votacao [] votos = new Votacao [100]; //Criação classe abstrata
        ClasseMetodos m = new ClasseMetodos(); //instanciamento da classe de métodos
        
        int opc = 0; //parâmetro de escolha
        
        for (int i = 0; i<100; i++) //Criando os tipos de dados para a classe abstrata
        {
            votos[i] = new Votacao();
        }
        
        while(opc!=9) // Enquanto a opção não for 9, o programa continuará sendo executado
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Carregar Seção/Número Eleitor  \n 2 – Classificar por Seção \n 3 – Gravar Registros \n 4 – Mostrar Indicadores \n 9 - Finalizar"));
            
            switch(opc)
            {
                case 1 : m.FCADRASTRAVOTACAO(votos) ; //Chama a função de cadastrar os votos.
                break;
                case 2 : m.FCLASSIFICASECAO(votos); //Classifica as seções e seus candidatos
                break;
                case 3 : m.FGRAVAVOTACAO(votos); //Gera arquivo com os votos e suas respectivas seções
                break;
                case 4 : m.indicadores(); //Novo menu para os indicadores
                break;
                case 9: JOptionPane.showMessageDialog(null, "Obrigado por utilizar a aplicação.");
                break;
                
                default: JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }   
    }  
}
