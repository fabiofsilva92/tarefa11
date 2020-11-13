import javax.swing.*;
import java.util.Random;
import java.io.*;


public class ClasseIndicador {
    
    //Quantidade de eleitores por seção (votos = eleitores)
    public int [] qtdSecao(Votacao [] votosInd)
    {
        int [] contador = new int [11];
        
        for(int i = 0 ; i<11 ; i++)
        {
            for(int j = 0; j<100; j++)
            {
                if(votosInd[j].numeroSec == i) //Se o numero da seção for igual ao i, o contador será incrementado para contar quantos eleitores tiveram naquela seção.
                {
                    contador[i]++;
                }
            }
        }
        
        for(int i = 0 ; i<11; i++)
        {
            System.out.println("A Seção " +i+" teve " +contador[i] + " votos");
        }
        return contador;
    }

    
    //Classifica a quantidade de eleitores por seção, colocando em um vetor classificado do menor para o maior
    public void ClassificaQtdSecao(int [] contadorVotos)
    {
        int aux = 0; //auxiliar da quantidade de votos para o bubble sort
        int [] vetorAuxSec = new int[11]; //Esse vetor será auxiliar para demarcar as posições das seções juntamente com sua quantidade de votos
        int auxSec = 0; //auxiliar da seção para o bubble sort
        
        for(int i = 0; i<11; i++) //atribuindo o valor de 0 a 10 para a quantidade de seções
        {
            vetorAuxSec[i] = i;
        }
        
        //Bubble Sort
        for(int i = 0; i<10; i++)
        {
            for (int j = i+1; j<11; j++)
            {
                if(contadorVotos[i]>contadorVotos[j])
                {
                    aux = contadorVotos[i];
                    contadorVotos[i] = contadorVotos[j];
                    contadorVotos[j] = aux;
                    
                    auxSec = vetorAuxSec[i];
                    vetorAuxSec[i] = vetorAuxSec[j];
                    vetorAuxSec[j] = auxSec;
                }
            }
        }
        //Após a classificação a menor quantidade esta na primeira posição e a maior na ultima posição.
        System.out.println("A Seções foram classificadas: \nA Seção com menor quantidade de eleitores foi a seção " +vetorAuxSec[0]+ " que teve " +contadorVotos[0]+ " votos");
        boolean verificador = true; //delimitador para a verificação
        for(int i = 0; verificador ; i++) //verificando se as posições seguintes tem a mesma quantidade de votos para referenciar juntamente como a menor ou a maior quantidade de votos.
        {
            if(contadorVotos[i] == contadorVotos[(i+1)])
            {
                System.out.println("Juntamente com a seção " +vetorAuxSec[i+1] + " que teve a mesma quantidade de votos = " + contadorVotos[i+1]);
            }      
            else
            {
                verificador = false;
            }
        }
        
        verificador = true;
        
        System.out.println("A Seção com maior quantidade de leitores foi a seção " + vetorAuxSec[10] + " que teve " + contadorVotos[10] + " votos");
        for (int i = 10; verificador; i--)
        {
            if(contadorVotos[i] == contadorVotos[(i-1)])
            {
                System.out.println("Juntamente com a seção " +vetorAuxSec[i-1] + " que teve a mesma quantidade de votos = " + contadorVotos[i-1]);
            }
            else
            {
                verificador = false;
            }
        }
    }
    
    //Quantidade de votos por candidato
    public int [] [] QtdVotosCandidato(Votacao[] votosInd)
    {
        int [] classificaCandidato = new int [100];
        int aux = 0;
        
        for (int i = 0; i<100; i++)
        {
            classificaCandidato[i] = votosInd[i].numeroCand;
        }
        
        //Classificando em ordem crescente o vetor auxiliar para nao bagunçar o votos.numeroCand em relação as respectivas seções.
        for (int i = 0; i<99; i++)
        {
            for(int j = i+1; j<100; j++)
            {
                if(classificaCandidato[i] > classificaCandidato[j])
                {
                    aux = classificaCandidato[i];
                    classificaCandidato[i] = classificaCandidato[j];
                    classificaCandidato[j] = aux;
                }
            }
        }
        
        System.out.println("Ordenado:" );
        
        for(int i = 0; i<100; i++)
        {
            System.out.println (classificaCandidato[i]);
        }
        
        
        //Contagem de votos por candidato.
        int cont = 0;
        int[][] candidatoVoto = new int [30][2];
        
        int num = 0;  
        //Como o vetor já está em ordem crescente, a contagem será feita em sequencia, e interrompida caso seja necessário
        for (int i = 0 ; i<100; i++)
        {
            for (int j = i ; j<100; j++) // Compara a posição i com todo o restando do array
            {   
                if (classificaCandidato[i]==classificaCandidato[j])
                {
                    if(i>0 && classificaCandidato[i] == classificaCandidato[(i-1)]) //Se a posição i for igual a anterior, acrescento 99 ao j para nao fazer processamento desnecessário por todo o array
                    {
                        j=99;
                    }
                    else // caso contrário faz a contagem.
                    {
                        cont++;
                    }
                }
                else // Se i for diferente de j já para a contagem.
                {
                    j=99;
                }
            }
            if(i>0 && classificaCandidato[i] == classificaCandidato[(i-1)])
            {
                cont = 0;
            }
            else
            {
                System.out.println("O candidato " +classificaCandidato[i]+ " teve " + cont + " votos");
                candidatoVoto[num][0] = classificaCandidato[i]; //atribuindo a matriz o numero do candidto
                candidatoVoto[num][1] = cont; // atribuindo a matriz a quantidade de votos
                //System.out.println("Candidato " +candidatoVoto[num][0] + " Votos " +candidatoVoto[num][1]);
                num++; //incrementando a posição da matriz
                cont=0;
            }
        }
        return candidatoVoto;   
    }
    
    public void ColocacaoCand(int [] [] candidatoVoto)
    {
        int auxQtd = 0;
        int auxCand = 0;
        
        for(int i = 0; i<30; i++)
        {
            System.out.println("Candidato " +candidatoVoto[i][0] + " Votos " +candidatoVoto[i][1]);
        }
        
        for(int i = 0; i<29; i++)
        {
            for(int j = i+1; j<30; j++)
            {
                if(candidatoVoto[i][1] > candidatoVoto[j][1])
                {
                 auxQtd = candidatoVoto[i][1];
                 candidatoVoto[i][1] = candidatoVoto[j][1];
                 candidatoVoto[j][1] = auxQtd;
                 
                 auxCand = candidatoVoto[i][0];
                 candidatoVoto[i][0] = candidatoVoto[j][0];
                 candidatoVoto[j][0] = auxCand;
                }
            }
        }
        System.out.println("ordenado: ");
        
        for(int i = 0; i<30; i++)
        {
            System.out.println("Candidato " +candidatoVoto[i][0] + " Votos " +candidatoVoto[i][1]);
        }
        
        int contador = 1;
        for(int i = 29; i>19; i--)
        {
            System.out.println("O Candidato em " +contador+ "º lugar foi o candidato " + candidatoVoto[i][0]+ " com " +candidatoVoto[i][1]+ " votos.");
            contador++;
        }
        
    }
}
