import java.util.Scanner;
import java.util.Random;

public class DistribuicaoDeNotas{
	public static void main(String args[]){
		Scanner teclado = new Scanner(System.in);

		Aluno alunos[] = new Aluno[1];

		for(int i = 0; i < alunos.length; i++){
			alunos[i] = new Aluno();
		}

		int notas[] = new int[8];

		Random random = new Random();
		for(int x = 0; x < alunos.length; x++) {
			for(int i = 0; i < notas.length; i++){
				notas[i] = 1 + random.nextInt(100);
			}
			System.out.printf("Digite o nome do %d aluno\n", x+1);
			alunos[x].setNome(teclado.nextLine());
			System.out.printf("Digite a idade do %d aluno\n", x+1);
			alunos[x].setIdade(Integer.parseInt(teclado.nextLine()));
			System.out.printf("Digite o RA do %d aluno\n", x+1);
			alunos[x].setRA(Integer.parseInt(teclado.nextLine()));
			alunos[x].setNotas(notas);	
		}

		apresentarNotasDeUmAluno(alunos, teclado);
	}

	// Apresentar as notas de um Aluno
	private static void apresentarNotasDeUmAluno(Aluno alunos[], Scanner teclado){
		//System.out.println("Digite o RA do aluno que quer consultar as notas:")
		//int ra = teclado.nextInt();

		int notas[] = alunos[0].getNotas();
		int n[] = new int[11];

		for(int i = 0; i < notas.length; i++){
			n[notas[i]/10]++;
		}

		/*for(int i = 0; i < n.length; i++){
			System.out.printf("%d %d\n", i, n[i]);
		}*/

		System.out.println("Distribuição de notas: ");

		for(int i = 0;  i < n.length; i++){
			if(i == 10){
				System.out.printf("%5d: ", i*10);
			}else{
				if(i == 0){
					System.out.printf("0%d-0%d: ", i, i+9);	
				}else{
					System.out.printf("%d-%d: ", (i*10), (i*10+9));	
				}	
			}
			
			
			for(int x = 0; x < n[i]; x++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}