package escalonamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Escalonamento Round Robin com prioridade
 *
 * Este programa recebe um arquivo de entrada com as informações dos processos que desejam ser executados, realiza o escalonamento
 * da execucao desses processos utilizando o algoritmo Round Robin com prioridade. Ao final, mostra ao usuário um grafo ilustrando como 
 * foram executados esses processos, bem como os tempos do algoritmo, sendo eles o tempo médio de espera e resposta.
 * 
 * Autores: 
 * Renata Sirotsky Soria
 * Wagner Oliveira dos Santos
 *
 * Disciplina: Sistemas Operacionais - PUCRS
 * Data: 
 */


public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("****Algoritmo Round Robin****\n");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Insira o nome do arquivo: ");
		String file_name = scan.nextLine();
		scan.close();
		
		// Classe que controla lista de processos
		GerProcessos processos = GerProcessos.readFile(file_name);

		// Instancia processador com lista de processos do arquivo
		Processador processador = new Processador(processos);

		// Executa round robin
		processador.executaEscalonador();

		// Imprime resultados
		processador.printResultados();
		
		System.out.println("***FIM***");
	}
}
