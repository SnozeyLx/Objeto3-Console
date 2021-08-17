import java.util.concurrent.Semaphore;

public class Grilo extends Thread {
		 
	
		private int pulos, distAtual, id, time;
						
		private Semaphore s;
		
		
		
		
		public Grilo (int id, int time, Semaphore s) {
			this.id = id;
			this.time = time;
			this.s = s;
			
		}
		
		
		
		public void run() {
			
				
			
				while(distAtual < Main.disMax) {
				int distpulo = (int) (Math.random()* 100.0);
				distAtual = distAtual + distpulo;
				System.out.println("O Grilo " + id + " pulou " + distpulo + " e ja percorreu " + distAtual);
				pulos ++;
				distpulo = 0;
				
				
				//Colocamos um if antes do try/catch de descanso da thread para evitar um "pulo adicional" antes de dizer que chegou
				if(distAtual >= Main.disMax) {
					
					
					// try/catch para pedir permissão para acessar o semaforo
					try {
				        s.acquire();
				        
				        // verifica se é o primeiro a chegar e define o time dele como o ganhador
				    	if(Main.posicao == 1) Main.timeW = this.time;
				    	
						   System.out.println("O Grilo "+id+ " do time " +time+ " chegou em "+Main.posicao+"º lugar e alcançou a linha de chegada com " + pulos + " pulos.");
						   
						   // acrescenta a posição para ir dando as colocações dos grilos
						   Main.posicao++;   
						   
						   // adicionar os valores do grilo ao seu time
						   Main.totalpulos[time] += pulos;
						   Main.totaldist[time] += distAtual;
						   
						   // se a posição do grilo for igual a quantidade total de grilos, significa que o ultimo grilo chegou e ele pode fazer o print final
						   if (Main.posicao == Main.gg) {
								
							   //for para printar a informação de cada time baseado na quantidade de times criados
							   for (int i = 1; i <= Main.z; i++) {
								  
								   System.out.println("\n" + "\n" + "Time "+i+": Total de pulos: " + Main.totalpulos[i] + " - Distancia percorrida: " + Main.totaldist[i]);
							   }
							
							   //print final dizendo o vencedor
								System.out.println("\n" + "\n" + "Time "+Main.timeW+" foi o vencedor!");
							
							}
				        
				        } 
					catch (InterruptedException e) {
				        e.printStackTrace();
				        } 
					
					finally {
				        s.release();
				    }
													  
										   
					   
				   }
				
			
				
			   try {
					sleep(100 + (int)(Math.random() * 100.0));
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				 
			   	
							
				
				}
				
		}
		
	}
		
