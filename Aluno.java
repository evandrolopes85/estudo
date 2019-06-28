public class Aluno {
	private static final int IDADE_MINIMA  = 17;
	private static final int IDADE_MAXIMA  = 50;

	private String nome;
	private int idade;
	private int ra;
	private NotasEDisciplina notasEDisciplina;


	public Aluno(){
		this(null, 17, 120, null);
	}

	public Aluno(String nome, int idade, int ra, NotasEDisciplina nd){
		setNome(nome);
		setIdade(idade);
		setRA(ra);
		setNotasEDisciplina(nd);
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setIdade(int idade){
		if(idade < IDADE_MINIMA || idade > IDADE_MAXIMA){
			throw new RuntimeException("Idade Invalida, por favor, digite idade maior que 16 anos!");
		}
		this.idade = idade;
	}

	public int getIdade(){
		return this.idade;
	}

	public void setRA(int ra){
		this.ra = ra;
	}

	public int getRA(){
		return this.ra;
	}

	public void setNotasEDisciplina(NotasEDisciplina nd){
		this.notasEDisciplina = nd;
	}

	public NotasEDisciplina getNotasEDisciplina(){
		return this.notasEDisciplina;
	}

	@Override
	public String toString(){
		return String.format("Nome: %s%nIdade: %d%nRA: %d%n", getNome(), getIdade(), getRA());
	}
}