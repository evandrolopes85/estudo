import java.util.Random;
import java.util.Scanner;

public class AlunoTeste {
	public static void main(String args[]){
		Scanner teclado = new Scanner(System.in);
		
		Random random = new Random(); // Classe que gera numeros aleatorios
		// Vetor onde será armazenado os Alunos
		final int QUANT_ALUNOS = 3;
		Aluno alunos[] = new Aluno[QUANT_ALUNOS];
		Aluno aluno = new Aluno();

		int notas[] = null; // Variável onde será armazenada as notas antes de passar para o vetor de notas
		NotasEDisciplina nd = null; // Variaval onde será armazenada a disciplina e suas respectivas notas

		for(int x = 0; x < alunos.length; x++) {
			System.out.printf("Digite o nome do %d aluno\n", x+1);
			aluno.setNome(teclado.nextLine()); // cadastra o nome do aluno na posicao x do vetor de Alunos
			
			System.out.printf("Digite a idade do %d aluno\n", x+1);
			aluno.setIdade(Integer.parseInt(teclado.nextLine()));// cadastra o idade do aluno na posicao x do vetor de Alunos

			if(x == 0){
				System.out.printf("Digite o RA do %d aluno\n", x+1);
				aluno.setRA(Integer.parseInt(teclado.nextLine()));
			}
			else{
				boolean ok;
				do{
					ok = false;
					System.out.printf("Digite o RA do %d aluno\n", x+1);
					aluno.setRA(Integer.parseInt(teclado.nextLine()));
					for(int i = 0; alunos[i] != null; i++){
						if(alunos[i].getRA() == aluno.getRA()){
							ok = true;
							System.out.println("RA ja cadastrado, tente novamente!");
							break;
						}
					}
				}while(ok);
			}

			notas = new int[8]; // cria um vetor de inteiro com 8 posições

			nd = new NotasEDisciplina(); // cria uma instancia da classe Vetor
			System.out.printf("\nDigite a disciplina\n");
			nd.setDisciplina(teclado.nextLine()); // cadastra a disciplina do aluno na instancia Vetor			System.out.printf("Disciplina cadastrada com sucesso\n");

			System.out.printf("\nCadastrando notas automaticamente!\n");
			for(int i = 0; i < notas.length; i++){
				notas[i] = 1 + random.nextInt(100); // gera numeros aleatorios entre 0 e 100 e atribui ao vetor notas
				System.out.printf("%c", '-'); // 
				
				// Método estatico sleep da classe Thread só para fazer um charme :)
				try{
					Thread.sleep(200);
				}catch(Exception e){
					e.printStackTrace();
				}
			} // fim do for que cadastra as notas

			// Cadastrando a disciplina e as ntas
			nd.setNotas(notas); // preenche as notas da instancia de Vetor com notas[]
			aluno.setNotasEDisciplina(nd);

			alunos[x] = new Aluno(aluno.getNome(), aluno.getIdade(), aluno.getRA(), aluno.getNotasEDisciplina());
			System.out.printf("\nNotas Cadastrada com sucesso\n\n");	
		}
		
		aluno = null;
					
		System.out.printf("\n\n\n");
		

		int opcao = 0;
		do{ // laço do while que repete o menu até ser escolhida a posicao 5
			// Menu de Opções
			System.out.println("Menu:");
			System.out.printf("\t1 - Modificar Aluno\n");
			System.out.printf("\t2 - Consultar Boletim\n");
			System.out.printf("\t3 - Apresentar distribuição de notas\n");
			System.out.printf("\t4 - Apresentar distribuição de idade\n");
			System.out.printf("\t5 - Sair\n");
			opcao = Integer.parseInt(teclado.nextLine());

			switch(opcao){
				case 1:  // Menu Moficar Aluno
						opcao = 0;
						do{
							System.out.println("Menu(Modificar Aluno)");
							System.out.printf("\t1 - Modificar Nome\n");
							System.out.printf("\t2 - Modificar Idade\n");
							System.out.printf("\t3 - Modificar Nota de Disciplina\n");
							System.out.printf("\t4 - Voltar\n");
							opcao = Integer.parseInt(teclado.nextLine());
							
							switch(opcao){
								case 1 : // Modificar nome do Aluno
										modificaNomeDoAluno(alunos,teclado);
									break;
								case 2 : // Modificar Idade do Aluno
										modificaIdadeDoAluno(alunos, teclado);
									break;
								case 3 : // Modificar Notas de Disciplina
										modificaNotas(alunos,teclado);
									break;
								case 4 : // Voltar;
							}
						}while(opcao != 4);
					break;
				case 2 : 
						opcao = 0;
						aluno = null;
						do{
							System.out.println("Menu(Apresentar de notas)");
							System.out.printf("\t1 - Um Aluno\n");
							System.out.printf("\t2 - Todos os alunos\n");
							System.out.printf("\t3 - Voltar\n");
							opcao = Integer.parseInt(teclado.nextLine());
							
							switch(opcao){
								case 1 : // Apresentar notas de um aluno
										System.out.println("Digite o RA do aluno a ser consultado");
										int ra = Integer.parseInt(teclado.nextLine());
										aluno = consultaAluno(alunos, ra);
										//System.out.println("Disciplina: " +  aluno.getVetor().getDisciplina());
										apresentarNotasDeUmAluno(aluno);
									break;
								case 2 : // Apresentar a nota de todos os alunos
										apresentarNotasDeTodosALunos(alunos);
									break;
								case 3 : // Voltar;
							}
						}while(opcao != 3);
					break;
				case 3 : // Apresentar Distribuição de Notas
						if(alunos != null){
							apresentarNotasDistribuidas(alunos);
							linha(); // metodo que exibe uma linha tracejada
						}else{
							System.out.println("Nenhum aluno cadastrado!");
						}
					break;
				case 4 : // Apresentar Distribuição de Idade

						// Dificuldade para implementar esta parte

					break;
				case 5 : ;
			}	
		}while(opcao != 5);
	}

	// Metodo que faz Modifica as notas disciplina
	private static void modificaNotas(Aluno alunos[], Scanner teclado){
		System.out.println("Digite o RA do aluno a ser consultado");
		int ra = Integer.parseInt(teclado.nextLine());
		Aluno aluno = consultaAluno(alunos, ra);

		if(aluno != null){ // verifica se o aluno existe
			linha();
			System.out.println("Notas atuais: ");
			int notas[] = aluno.getNotasEDisciplina().getNotas();
			// exibe as notas dos alunos antes das alterações
			for(int i = 0; i < notas.length; i++){
				System.out.printf("\t%d - Nota %d: \n", i+1, notas[i]);
			}
			
			linha(); // exibe uma linha tracejada

			// for que solicita as novas notas e atribui ao vetor notas[]
			for(int i = 0; i < notas.length; i++){
				System.out.printf("Digite a %d Nota: ", i+1);
				notas[i] = Integer.parseInt(teclado.nextLine());
				System.out.println("");
			} // fim do for que solicita as notas

			aluno.getNotasEDisciplina().setNotas(notas); // cadastra as novas notas do aluno
			System.out.println("Notas atualizadas com sucesso!");	
		} 
		else{ // aluno nao encontrado
			System.out.println("Aluno não encontrado");
		}// fim do if que verifica se existe aluno
	}

	// Metodo que faz a Modificação do nome
	private static void modificaNomeDoAluno(Aluno alunos[], Scanner teclado){
		System.out.println("Digite o RA do aluno a ser consultado");
		int ra = Integer.parseInt(teclado.nextLine());
		Aluno aluno = consultaAluno(alunos, ra);                      // Verifica se o aluno existe, caso sim devolve a referencia desse aluno, caso no setorna null

		if(aluno != null){ // verifica se o aluno existe
			System.out.println("Nome atual do Aluno: " + aluno.getNome()); // Exibe o antigo nome do aluno
			System.out.println("Digite o novo nome: ");
			aluno.setNome(teclado.nextLine());                             // cadastra o novo nome do aluno
			System.out.println("Nome atualizado com sucesso!");	
		} 
		else{ // aluno nao encontrado
			System.out.println("Aluno não encontrado");
		}// fim do if que verifica se existe aluno
	}

    // Metodo que faz a Modificação a idade do aluno
	private static void modificaIdadeDoAluno(Aluno alunos[], Scanner teclado){
		System.out.println("Digite o RA do aluno a ser consultado");
		int ra = Integer.parseInt(teclado.nextLine());
		Aluno aluno = consultaAluno(alunos, ra);                        // Verifica se o aluno existe, caso sim devolve a referencia desse aluno, caso no setorna null

		if(aluno != null){                                                   // verifica se o aluno existe
			System.out.println("Idade atual do Aluno: " + aluno.getIdade()); // Exibe a idade antiga do aluno
			System.out.println("Digite a nova Idade: ");
			aluno.setIdade(Integer.parseInt(teclado.nextLine()));            // cadastra a nova idade
			System.out.println("Idade atualizada com sucesso!");	
		} 
		else{ // aluno nao encontrado
			System.out.println("Aluno não encontrado");
		}// fim do if que verifica se existe aluno
	}	

	// Apresentar as notas de um Aluno
	private static void apresentarNotasDistribuidas(Aluno alunos[]){
		int n[] = new int[11];

		for(int x = 0; x < alunos.length; x++){
			int notas[] = alunos[x].getNotasEDisciplina().getNotas();
			for(int i = 0; i < notas.length; i++){
				n[notas[i]/10]++;
			}
		}	

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

	// Metodos que apresenta idade Distribuida
	public static void apresentaIdadeDistribuida(Aluno alunos[]){
	
	}

	// Metodo que imprime uma linha tracejada para separação
	private static void linha(){
		System.out.println("");
		for(int i = 0; i < 25; i++){
			System.out.print("-");
		}
		System.out.println("");
	}

	private static Aluno consultaAluno(Aluno alunos[], int ra){
		//int ra = 0;
		int index = -1;
		boolean isExist = false;

		//System.out.println("Digite o RA do aluno a ser consultado");
		//ra = Integer.parseInt(teclado.nextLine());

		for(int i = 0; i < alunos.length && isExist == false; i++){
			if(alunos[i].getRA() == ra){
				index = i;
				isExist = true;
			}
		}

		if(isExist){
			return alunos[index];
		}

		return null;
	}

	private static void apresentarNotasDeUmAluno(Aluno aluno){
		System.out.println("Disciplina: " + aluno.getNotasEDisciplina().getDisciplina());
		int i = 1;

		for(int nota : aluno.getNotasEDisciplina().getNotas()){
			System.out.printf("%d - nota = %d\n", i, nota);
			i++;
		}
	}

	private static void apresentarNotasDeTodosALunos(Aluno alunos[]){
		for(int x = 0; x < alunos.length; x++){
			linha();
			System.out.println("Aluno: " + alunos[x].getNome());
			linha();
			System.out.println("Disciplina: " + alunos[x].getNotasEDisciplina().getDisciplina());
			linha();
			int i = 1;

			for(int nota : alunos[x].getNotasEDisciplina().getNotas()){
				System.out.printf("\t%d nota: %d\n", i, nota);
				i++;
			}

			System.out.println("");
		}
	}
}