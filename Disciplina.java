import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String titulo;
    private int capacidadeMaxima;
    private List<Aluno> inscritos; // Lista de alunos 
    
    public Disciplina(String codigo, String titulo, int capacidadeMaxima) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.inscritos = new ArrayList<>(); // Inicializar a lista aqui
    }

    // Método auxiliar pra saber se cabe mais alunos
    public boolean isLotada() {
        return inscritos.size() >= capacidadeMaxima;
    }
    
    public List<Aluno> getAlunos() {
        return new ArrayList<>(inscritos); // Cópia defensiva
    }
    
    // Getters e Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public void setCapacidadeMaxima(int capacidadeMaxima) { 
        this.capacidadeMaxima = capacidadeMaxima; 
    }
    
    // Método para adicionar aluno (Matriculador)
    boolean adicionarAluno(Aluno aluno) {
        // Verifica se já está inscrito (por matrícula)
        for (Aluno a : inscritos) {
            if (a.getMatricula() == aluno.getMatricula()) {
                return false;
            }
        }

        //verifica se tem vagas
        if (!isLotada()) {
            inscritos.add(aluno);
            return true;
        }
        return false;
    }
}
