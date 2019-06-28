public class Vetor{
	private String disciplina;
	private int notas[] = new int[8];

	//public Vetor(String disciplina, int notas[]){
	//	this.notas = new int[8];
	//	setDisciplina(disciplina);
	//	setNotas(notas);
	//}

	public void setDisciplina(String disciplina){
		this.disciplina = disciplina;
	}

	public String getDisciplina(){
		return this.disciplina;
	}

	public void setNotas(int notas[]){
		this.notas = notas;
	}

	public int[] getNotas(){
		return notas;
	}

}