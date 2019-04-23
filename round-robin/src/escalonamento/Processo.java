package escalonamento;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Define cada processo da lista e seus atributos. 
 *
 */
public class Processo implements Comparable<Object> {

	// Propriedades 
	private int id;
	private int tempo_chegada;
	private int tempo_execucao;
	private int prioridade;

	// Execucao
	private int tempo_rodando = 0;
	private int total_rodando = 0;
	
	// entrada/saida
	List<Integer> in_out;
	private int tempo_inicio_in_out;

	//Tempos do algoritmo
	private int tempo_resposta = -1;
	private int tempo_espera = 0;
	
	public void setTempo_inicio_in_out(int tempo_inicio_in_out) {
		this.tempo_inicio_in_out = tempo_inicio_in_out;
	}
	public void setTempo_rodando(int tempo_rodando) {
		this.tempo_rodando = tempo_rodando;
	}

	public int getTempo_inicio_in_out() {
		return tempo_inicio_in_out;
	}

	public int getTempo_resposta() {
		return tempo_resposta;
	}

	public int getTempo_rodando() {
		return tempo_rodando;
	}

	public int getTotal_rodando() {
		return total_rodando;
	}

	public Processo(int tempo_chegada, int tempo_execucao, int prioridade, int id, List<Integer> in_out) {
		this.id = id;
		this.tempo_chegada = tempo_chegada;
		this.tempo_execucao = tempo_execucao;
		this.prioridade = prioridade;
		this.in_out = in_out;

		if (in_out != null)
			Collections.sort(in_out);
	}

	public int getId() {
		return id;
	}

	public int getTempo_chegada() {
		return tempo_chegada;
	}

	public int getTempo_execucao() {
		return tempo_execucao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	@Override
	public String toString() {
		return id + "";
	}
	// executa processo atual
	public void executa(int tempo_atual) {
		if (tempo_resposta < 0)
			tempo_resposta = tempo_atual - tempo_chegada;

		tempo_execucao--;
		tempo_rodando++;
		total_rodando++;
	}
	// verifica se processo terminou de executar
	public boolean terminou() {
		return tempo_execucao <= 0;
	}
	
	
	@Override
	public int compareTo(Object arg) {
		int prioridade = ((Processo) arg).prioridade;
		System.out.println(this.prioridade - prioridade);
		return this.prioridade - prioridade;
	}

	// Ordena processos em execucao por prioridade em ordem crescente
	public static void ordenaPrioridades(List<Processo> executando) {
		Collections.sort(executando, new Comparator<Processo>() {
			@Override
			public int compare(Processo p1, Processo p2) {
				return p1.prioridade - p2.prioridade;
			}
		});
	}
	
	public void aumentaTempoEspera() {
		tempo_espera++;
	}
	public int getTempoEspera() {
		return tempo_espera;
	}

	public int getTempoChegada() {
		return tempo_chegada;
	}
	
	public int getTempoResposta() {
		return tempo_resposta;
	}
	
	/* Verifica se ha operacoes de E/S a serem executadas */
	public boolean verificaInOut() {
		if (in_out == null)
			return false;

		int t = total_rodando + 1;

		for (int i = 0; i < in_out.size(); i++) {
			if (t == in_out.get(i)) {
				in_out.remove(i);
				return true;
			}
		}
		return false;
	}

}



