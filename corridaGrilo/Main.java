import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
	
	static int posicao, gg, timeW, disMax, z;
			
	public static int totalpulos[], totaldist[];
	
	
	
	public static void main(String[] args) {
		
		Semaphore s = new Semaphore(1);	// criação do semaforo e quantos podem acessar por vez
		
		
	
		try (Scanner scanner = new Scanner(System.in)) {
			
			System.out.print("Quantos grilos deseja? ");
			int Qgrilos = scanner.nextInt();
			
			
			while(Qgrilos > 30) {
				System.out.print("30 e o limite! Digite novamente...");
				Qgrilos = scanner.nextInt();
			}
			
			gg = Qgrilos + 1;      // aqui ele pega o valor digitado e adiciona mais um para considerar a anulação do valor 0 do array
			
			posicao +=1;         // começa por 1 pois é aqui que é definido a posição dos grilos que vão chegando
			
			System.out.print("Qual Distancia da linha de chegada? ");
			disMax = scanner.nextInt();
			
			while(disMax > 1000) {
				System.out.print("Distancia maxima de 1000 unidades! Digite novamente...");
				disMax = scanner.nextInt();
			}
			
		}
		
		
		Grilo []g = new Grilo[gg];
	    
	     for(int i = 1; i<gg; i++) {    //For para passar os parametos para os grilos
		    	
		    	if (z*3 < i) z++;      // um int multiplo por 3 pra definir um time a cada 3 grilos
		 	  
		 	     g[i] = new Grilo (i, z, s);
		 		 g[i].start();                 //inicia os grilos
		 		 
		 		}
		
	     // um array para salvar os valores totais dos times baseado em quatos times foram criados
	     totalpulos = new int [z + 1];   
	     totaldist = new int [z + 1]; 
	 
	
	
	
	
	}
   
}