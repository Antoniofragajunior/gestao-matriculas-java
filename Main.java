public class Main {
    public static void main(String[] args) {
        Matriculador matriculador = new Matriculador();
        
        System.out.println("=== SISTEMA ACADÊMICO - CADASTRO ===");
        
        // Criando disciplinas
        Disciplina poo = new Disciplina("ADS001", "Programação Orientada a Objetos", 2);
        Disciplina eda = new Disciplina("ADS002", "Estrutura de Dados", 1);
        Disciplina bd = new Disciplina("ADS003", "Banco de Dados", 3);
        
        // Criando alunos
        Aluno aluno1 = new Aluno("João Silva", "joao.silva@email.com");
        Aluno aluno2 = new Aluno("Maria Santos", "maria.santos@email.com");
        Aluno aluno3 = new Aluno("Pedro Costa", "pedro.costa@email.com");
        Aluno aluno4 = new Aluno("Ana Oliveira", "ana.oliveira@email.com");
        
        // Cadastrando componentes
        System.out.println("\n=== CADASTRANDO DISCIPLINAS ===");
        matriculador.cadastrarDisciplina(poo);
        matriculador.cadastrarDisciplina(eda);
        matriculador.cadastrarDisciplina(bd);
        
        System.out.println("\n=== CADASTRANDO ALUNOS ===");
        matriculador.cadastrarAluno(aluno1);
        matriculador.cadastrarAluno(aluno2);
        matriculador.cadastrarAluno(aluno3);
        matriculador.cadastrarAluno(aluno4);
        
        // Realizando matrículas
        System.out.println("\n=== REALIZANDO MATRÍCULAS ===");
        matriculador.matricular(1000, "ADS001"); // João em POO
        matriculador.matricular(1001, "ADS001"); // Maria em POO
        matriculador.matricular(1002, "ADS001"); // Pedro em POO (deve falhar - lotada)
        matriculador.matricular(1002, "ADS002"); // Pedro em EDA
        matriculador.matricular(1003, "ADS002"); // Ana em EDA (deve falhar - lotada)
        matriculador.matricular(1003, "ADS003"); // Ana em BD
        matriculador.matricular(1000, "ADS003"); // João em BD (matrícula dupla permitida)
        
        // Tentativa de matrícula duplicada
        System.out.println("\n=== TENTATIVA DE MATRÍCULA DUPLICADA ===");
        matriculador.matricular(1000, "ADS001"); // João tentando se matricular novamente em POO
        
        // Gerando relatórios
        System.out.println("\n=== RELATÓRIO: ALUNOS INSCRITOS EM POO ===");
        for (Aluno aluno : matriculador.listarInscritos("ADS001")) {
            System.out.println(aluno.toString());
        }
        
        System.out.println("\n=== RELATÓRIO: ALUNOS INSCRITOS EM EDA ===");
        for (Aluno aluno : matriculador.listarInscritos("ADS002")) {
            System.out.println(aluno.toString());
        }
        
        System.out.println("\n=== RELATÓRIO: ALUNOS INSCRITOS EM BANCO DE DADOS ===");
        for (Aluno aluno : matriculador.listarInscritos("ADS003")) {
            System.out.println(aluno.toString());
        }
        
        // Testando busca de aluno
        System.out.println("\n=== BUSCA DE ALUNO ===");
        Aluno alunoBuscado = matriculador.buscarAluno(1000);
        if (alunoBuscado != null) {
            System.out.println("Aluno encontrado: " + alunoBuscado.toString());
        }
    }
}