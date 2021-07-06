
public class Tabuleiro {
	
	private String [][] tabuleiro = new String[10][10];
	private int sub;
	private int contra;
	private int tanq;
	private int porta;
	
	public Tabuleiro (int sub, int contra, int tanq, int porta) {
		this.sub = sub;
		this.contra = contra;
		this.tanq = tanq;
		this.porta = porta;
	}
	
	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	public int getContra() {
		return contra;
	}

	public void setContra(int contra) {
		this.contra = contra;
	}

	public int getTanq() {
		return tanq;
	}

	public void setTanq(int tanq) {
		this.tanq = tanq;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}



	public void zeraTabuleiro() {
		for(int l = 0; l < 10; l++){
            for(int c = 0; c < 10; c++){
            	tabuleiro[l][c] = "---";      
            }
		}
	}
	
	
	public void mostraTabuleiro () {
		System.out.println("    0      1      2      3      4      5      6      7      8      9");
	       System.out.println("  ----------------------------------------- ");
	        for(int l = 0; l < 10; l++){
	            System.out.print(l + " ");
	            for(int c = 0; c < 10; c++){
	               
	                System.out.print("| "+ tabuleiro[l][c]+" ");
	                
	            }
	            System.out.println("|");
	       System.out.println("  ----------------------------------------- ");
	        }
	}
	
	
	public int inserirSubmarinos () { //4 submarinos de tamanho 2
		int qtd = 1;
		while (qtd < 5) { 
			double sorteio = Math.random();
			System.out.println(sorteio);
			if (sorteio < 0.5) { //inserir na vertical
				int l = (int)Math.round(Math.random() * 9);
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l+1][c] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "SUB";
					tabuleiro[l+1][c] = "SUB";
					qtd++;
				}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o submarino. Uma nova tentativa será feita.");
					}
				
				
			} else { //inserir na horizontal
				int l = (int)Math.round(Math.random() * 9);
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l][c+1] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "SUB";
					tabuleiro[l][c+1] = "SUB";
					qtd++;
				}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o submarino. Uma nova tentativa será feita.");
					}
								
			}
		}
		
		return qtd;
	}
	
	
	public int inserirContratorpedeiros() { //inserindo 3 Contra Torpedeiros de tamanho 3
		int qtd = 1;
		while (qtd < 4) { 
			double sorteio = Math.random();
			System.out.println(sorteio);
			if (sorteio < 0.5) { //inserir na vertical
				int l = (int)Math.round(Math.random() * 9); 
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l+1][c] == "---" && tabuleiro[l+2][c] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "CTP";
					tabuleiro[l+1][c] = "CTP";
					tabuleiro[l+2][c] = "CTP";
					qtd++;
				}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o contra torpedeiro. Uma nova tentativa será feita.");
					}
				
			} else { //inserir na horizontal
				int l = (int)Math.round(Math.random() * 9);
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l][c+1] == "---" && tabuleiro[l][c+2] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "CTP";
					tabuleiro[l][c+1] = "CTP";
					tabuleiro[l][c+2] = "CTP";
					qtd++;
					}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o contra torpedeiro. Uma nova tentativa será feita.");
					}
			}
		}
		return qtd;
	}
	
	
	public int inserirNaviosTanque() { //inserindo 2 Navios Tanque de tamanho 4
		int qtd = 1;
		while (qtd < 3) { 
			double sorteio = Math.random();
			System.out.println(sorteio);
			if (sorteio < 0.5) { //inserir na vertical
				int l = (int)Math.round(Math.random() * 9); 
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l+1][c] == "---" && tabuleiro[l+2][c] == "---" && tabuleiro[l+3][c] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "TNQ";
					tabuleiro[l+1][c] = "TNQ";
					tabuleiro[l+2][c] = "TNQ";
					tabuleiro[l+3][c] = "TNQ";
					qtd++;
				}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o navio tanque. Uma nova tentativa será feita.");
					}
				
			} else { //inserir na horizontal
				int l = (int)Math.round(Math.random() * 9);
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l][c+1] == "---" && tabuleiro[l][c+2] == "---" && tabuleiro[l][c+3] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "TNQ";
					tabuleiro[l][c+1] = "TNQ";
					tabuleiro[l][c+2] = "TNQ";
					tabuleiro[l][c+3] = "TNQ";
					qtd++;
				}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o navio tanque. Uma nova tentativa será feita.");
					}
				
			}
		}
		return qtd;
	}
	
	
	public int inserirPortaAvioes() { //inserindo 1 Porta Avioes de tamanho 5
		int qtd = 1;
		while (qtd < 2) { 
			double sorteio = Math.random();
			System.out.println(sorteio);
			if (sorteio < 0.5) { //inserir na vertical
				int l = (int)Math.round(Math.random() * 9); 
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l+1][c] == "---" && tabuleiro[l+2][c] == "---" && tabuleiro[l+3][c] == "---" && tabuleiro[l+4][c] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "PTA";
					tabuleiro[l+1][c] = "PTA";
					tabuleiro[l+2][c] = "PTA";
					tabuleiro[l+3][c] = "PTA";
					tabuleiro[l+4][c] = "PTA";
					qtd++;
				}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o porta avioes. Uma nova tentativa será feita.");
					}
				
			} else { //inserir na horizontal
				int l = (int)Math.round(Math.random() * 9);
				System.out.println("linha " + l);
				
				int c = (int)Math.round(Math.random() * 9);
				System.out.println("coluna " + c);
				
				try {
				if (tabuleiro[l][c] == "---" && tabuleiro[l][c+1] == "---" && tabuleiro[l][c+2] == "---" && tabuleiro[l][c+3] == "---" && tabuleiro[l][c+4] == "---") { //garantindo que não haja sobreposição
					tabuleiro[l][c] = "PTA";
					tabuleiro[l][c+1] = "PTA";
					tabuleiro[l][c+2] = "PTA";
					tabuleiro[l][c+3] = "PTA";
					tabuleiro[l][c+4] = "PTA";
					qtd++;
				}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Não foi possível inserir o porta avioes. Uma nova tentativa será feita.");
					}
				
			}
		}
		return qtd;
	}
	
	
	public void verificaJogada (int l, int c) {
		if (tabuleiro[l][c] == "SUB" ) {
			System.out.println("Você acertou um Submarino!");
			sub = sub - 1;
			tabuleiro[l][c] = "---"; //o campo do navio acertado vira agua de volta
		} else if (tabuleiro[l][c] == "CTP") {
			System.out.println("Você acertou um Contratorpedeiro!");
			contra = contra - 1;
			tabuleiro[l][c] = "---";
		} else if (tabuleiro[l][c] == "TNQ") {
			System.out.println("Você acertou um Navio Tanque!");
			tanq = tanq - 1;
			tabuleiro[l][c] = "---";
		} else if (tabuleiro[l][c] == "PTA") {
			System.out.println("Você acertou o Porta-Aviões!");
			porta = porta - 1;
			tabuleiro[l][c] = "---";
		} else {
			System.out.println("Você mirou na água.");
		}
	}
	
	public boolean verificaGanhador() {
		boolean retorno = true;
		if (sub == 0 && contra == 0 && tanq == 0 && porta == 0) {
			retorno = true;    
			System.out.println(retorno);
		} else {
			retorno = false;    
			System.out.println(retorno);
		}
		return retorno;
	}
	 

}
