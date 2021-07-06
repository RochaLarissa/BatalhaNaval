import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		
		//CRIANDO OS TABULEIROS DOS JOGADORES
		Tabuleiro tabuleiro1 = new Tabuleiro(8, 9, 8, 5);
		Tabuleiro tabuleiro2 = new Tabuleiro(8, 9, 8, 5);
		
		//COLOCANDO AGUA NOS TABULEIROS
		tabuleiro1.zeraTabuleiro();
		tabuleiro2.zeraTabuleiro();
		
		System.out.println("TABULEIRO DO JOGADOR 1");
		tabuleiro1.mostraTabuleiro();
		
		System.out.println("TABULEIRO DO JOGADOR 2");
		tabuleiro2.mostraTabuleiro();
		
		
		//INSERINDO NAVIOS ALEATORIAMENTE NOS 2 TABULEIROS
		tabuleiro1.inserirSubmarinos();
		tabuleiro1.inserirContratorpedeiros();
		tabuleiro1.inserirNaviosTanque();
		tabuleiro1.inserirPortaAvioes();
		System.out.println("TABULEIRO DO JOGADOR 1");
		tabuleiro1.mostraTabuleiro();
		
		tabuleiro2.inserirSubmarinos();
		tabuleiro2.inserirContratorpedeiros();
		tabuleiro2.inserirNaviosTanque();
		tabuleiro2.inserirPortaAvioes();
		System.out.println("TABULEIRO DO JOGADOR 2");
		tabuleiro2.mostraTabuleiro();
		
		
		
		//CRIANDO AS 100 JOGADAS POSSÍVEIS PARA O JOGADOR 1 
		ArrayList<Jogada> jogadas1 = new ArrayList<Jogada>();
		
			for (int l = 0; l < 10; l++) {
				for (int c = 0; c < 10; c++) { //evitando jogadas repetidas
					Jogada jog = new Jogada (l, c);			
					jogadas1.add(jog);
				}
			}
		
		//CRIANDO UM ARQUIVO COM O INPUT
		String filename1 = "ataques1.txt";
		
		try {
			FileWriter fw = new FileWriter(filename1);
			for (int i = 0 ; i < 100; i++) {
				fw.write(jogadas1.get(i).getLinha() + " " + jogadas1.get(i).getColuna() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Um erro do tipo IO ocorreu.");
		}
		
		
		
		//CRIANDO AS 100 JOGADAS POSSÍVEIS PARA O JOGADOR 2 
		ArrayList<Jogada> jogadas2 = new ArrayList<Jogada>();
		for (int i  = 0; i < 100; i++) {
			for (int l = 0; l < 10; l++) {
				for (int c = 0; c < 10; c++) { //evitando jogadas repetidas
					Jogada jog = new Jogada (l, c);			
					jogadas2.add(jog);
				}
			}
		}	
		//CRIANDO UM ARQUIVO COM O INPUT
		String filename2 = "ataques2.txt"; 
		
		try {
			FileWriter fw = new FileWriter(filename2);
			for (int i = 0 ; i < 100; i++) {
				fw.write(jogadas2.get(i).getLinha() + " " + jogadas2.get(i).getColuna() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Um erro do tipo IO ocorreu.");
		}
		
		
		
		//LENDO AS JOGADAS A PARTIR DO ARQUIVO E ARMAZENANDO EM UM NOVO ARRAYLIST PARA CADA JOGADOR
		File f1 = new File(filename1); 
		ArrayList<Jogada> listaJogadas1 = new ArrayList<Jogada>(); 
		try {
			Scanner s1 = new Scanner(f1); //LENDO O ARQUIVO F1
			while (s1.hasNext()) { //enquanto houver uma próxima entrada no scanner, retorna true
				int linha = s1.nextInt();
				int coluna = s1.nextInt();
				Jogada j1 = new Jogada(linha, coluna);
				listaJogadas1.add(j1);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro: Arquivo não existe.");
		}
			
		File f2 = new File(filename2); 
		ArrayList<Jogada> listaJogadas2 = new ArrayList<Jogada>(); 
			try {
			Scanner s2 = new Scanner(f2); //LENDO O ARQUIVO F2
			while (s2.hasNext()) { //enquanto houver uma próxima entrada no scanner, retorna true
				int linha = s2.nextInt();
				int coluna = s2.nextInt();
				Jogada j2 = new Jogada(linha, coluna);
				listaJogadas2.add(j2);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro: Arquivo não existe.");
		}
		
		
		
		//JOGANDO
		boolean turnoJogador1 = true;
		int contJog1 = 0;
		int contJog2 = 0;
		
		
		//RANDOMIZANDO A ORDEM DAS JOGADAS DO JOGADOR 1 ATRAVÉS DE UM ÍNDICE
		ArrayList<Integer> ataques1 = new ArrayList<Integer>(); //contém números de 0 a 100 em ordem 
		for (int i = 0; i < 100; i++) {
			ataques1.add(i);
		}
		Collections.shuffle(ataques1); //embaralho os números
		System.out.println(ataques1);
		
		
		//RANDOMIZANDO A ORDEM DAS JOGADAS DO JOGADOR 2 ATRAVÉS DE UM ÍNDICE
		ArrayList<Integer> ataques2 = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			ataques2.add(i);
		}
		Collections.shuffle(ataques2);
		System.out.println(ataques2);
		
		
		//ENTRANDO NO LAÇO DO JOGO		
		while (tabuleiro1.verificaGanhador() == false && tabuleiro2.verificaGanhador() == false) {
			
			if (turnoJogador1) {
				System.out.println("VEZ DO JOGADOR 1");
				int jogadaLinha = listaJogadas1.get(ataques1.get(contJog1)).getLinha();
				int jogadaColuna = listaJogadas1.get(ataques1.get(contJog1)).getColuna();
				tabuleiro2.verificaJogada(jogadaLinha, jogadaColuna);
				contJog1++;
				tabuleiro2.mostraTabuleiro();
				
			} else {
				System.out.println("VEZ DO JOGADOR 2");
				int jogadaLinha = listaJogadas2.get(contJog2).getLinha();
				int jogadaColuna = listaJogadas2.get(contJog2).getColuna();
				tabuleiro1.verificaJogada(jogadaLinha, jogadaColuna);
				contJog2++;
				tabuleiro1.mostraTabuleiro();
				
			}
			
			turnoJogador1 = !turnoJogador1; //muda o turno do jogador
		}
		
		if (tabuleiro1.verificaGanhador()) {
			System.out.println("O jogador número 2 venceu com " + contJog2 + " ataques!");
		} else if (tabuleiro2.verificaGanhador()) {
			System.out.println("O jogador número 1 venceu com " + contJog1 + " ataques!");
		} else {
			System.out.println("O jogo terminou empatado.");
		}
		
		//ESCREVENDO QUAL O JOGADOR VENCEU O JOGO E NÚMERO DE ATAQUES
				String filename3 = "saida.txt";
				
				if (tabuleiro1.verificaGanhador()) {
					try {
						FileWriter fw = new FileWriter(filename3);
						fw.write("O jogador número 2 venceu com " + contJog2 + " ataques!");
						fw.close();
					} catch (IOException e) {
						System.out.println("Um erro do tipo IO ocorreu.");
					}
				} else if (tabuleiro2.verificaGanhador()) {
					try {
						FileWriter fw = new FileWriter(filename3);
						fw.write("O jogador número 1 venceu com " + contJog1 + " ataques!");
						fw.close();
					} catch (IOException e) {
						System.out.println("Um erro do tipo IO ocorreu.");
					}
				} else {				
					try {
						FileWriter fw = new FileWriter(filename3);
						fw.write("O jogo terminou empatado.");
						fw.close();
					} catch (IOException e) {
						System.out.println("Um erro do tipo IO ocorreu.");
					}
				}
		
				
		 	
		
		
		
		
	}

}
