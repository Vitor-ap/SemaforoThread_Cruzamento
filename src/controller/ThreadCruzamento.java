package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread{
	
	private int idThread;
	private Semaphore semaforo;
	private String sentido;
	private int random;
	
	public ThreadCruzamento(int i, int random, Semaphore semaforo) {
		this.idThread = i;
		this.semaforo = semaforo;
		this.random = random;
	}

	
	@Override
	public void run() {
		defineSentido();
		agurdando();
		try {
			semaforo.acquire();
			cruzando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
	
		}
	}


	private void agurdando() {
		try {
			sleep(random);
			System.err.println("O carro #"+idThread+" está aguardando para passar no cruzamento");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	private void cruzando() {
		try {
			sleep(random);
			System.out.println("O carro #"+idThread+" passou pelo cruzamento no sentido: "+sentido+".");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}


	private void defineSentido() {
		switch(idThread){
			case 1:
				sentido = "Sul";
				break;
			case 2:
				sentido = "Norte";
				break;
			case 3: 
				sentido = "Leste";
				break;
			case 4: 
				sentido = "Oeste";
				break;
				
		}
		
		
		
	}
}
