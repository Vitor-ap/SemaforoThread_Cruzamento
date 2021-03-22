package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class MainCruzamento {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo  = new Semaphore(permissoes);
		int random = (int) (Math.random()*1000);
		
			for (int i = 1; i <= 4; i++) {
				Thread tCruza = new ThreadCruzamento(i, random,semaforo);
				tCruza.start();
			}

	}

}