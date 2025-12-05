public class Aluno {
// Atributos privados pra garantir o encapsulamento
    private String nome;
    private String email;
    private int matricula;
 // Construtor padrão pra já criar o aluno com o básico necessário     
    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
 // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getMatricula() { return matricula; }
 // A matrícula vai ser setada pelo sistema depois, não no construtor
    public void setMatricula(int matricula) { this.matricula = matricula; }

// Sobrescrita do toString pra facilitar a visualização no console depois.
    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nome: " + nome + " | Email: " + email;
    }
}
