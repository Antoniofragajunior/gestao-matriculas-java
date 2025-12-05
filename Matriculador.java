import java.util.ArrayList;
import java.util.List;

public class Matriculador {
    private List<Disciplina> ofertas;
    private List<Aluno> alunos;
    private int proximaMatricula;
    
    public Matriculador() {
        this.ofertas = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.proximaMatricula = 1000; // Começando do numero 1000 mais realista
    }
    
    public void cadastrarDisciplina(Disciplina d) {
        if (d == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }
        
        for (Disciplina disciplina : ofertas) {
            if (disciplina.getCodigo().equals(d.getCodigo())) {
                throw new IllegalArgumentException("Código de disciplina já existe: " + d.getCodigo());
            }
        }
        ofertas.add(d);
        System.out.println("Disciplina cadastrada: " + d.getCodigo() + " - " + d.getTitulo());
    }
    
    public void cadastrarAluno(Aluno a) {
        if (a == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo");
        }
        
        a.setMatricula(proximaMatricula++); //Gerando matricula
        alunos.add(a);
        System.out.println("Aluno cadastrado: " + a.getMatricula() + " - " + a.getNome() + " - " + a.getEmail());
    }

    //Aluno + Disciplina
    public boolean matricular(int matricula, String codigoDisciplina) {
        Aluno aluno = buscarAluno(matricula);
        Disciplina disciplina = buscarDisciplina(codigoDisciplina);
        
        if (aluno == null) {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado!");
            return false;
        }
        
        if (disciplina == null) {
            System.out.println("Disciplina com código " + codigoDisciplina + " não encontrada!");
            return false;
        }
        
        boolean sucesso = disciplina.adicionarAluno(aluno);
        if (sucesso) {
            System.out.println("Matrícula realizada: " + aluno.getNome() + " em " + disciplina.getTitulo());
        } else {
            if (disciplina.isLotada()) {
                System.out.println("Falha na matrícula: " + disciplina.getTitulo() + " está lotada!");
            } else {
                System.out.println("Falha na matrícula: " + aluno.getNome() + " já está inscrito em " + disciplina.getTitulo());
            }
        }
        return sucesso;
    }
    
    public List<Aluno> listarInscritos(String codigoDisciplina) {
        Disciplina disciplina = buscarDisciplina(codigoDisciplina);
        return (disciplina != null) ? disciplina.getAlunos() : new ArrayList<>();
    }
    
    public Aluno buscarAluno(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null; //não achado
    }
    
    private Disciplina buscarDisciplina(String codigo) {
        for (Disciplina disciplina : ofertas) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }
}
