public class Psicologo extends Profissional {

    public Psicologo(String nome, String cpf) {
        super(nome, cpf, "psicologia");
    }

    public Psicologo(String nome, String cpf,
                      String registro, double valor) {
        super(nome, cpf, "psicologia", registro, valor);
    }

    public Psicologo(String nome, String cpf,
                      String registro, double valor,
                      String[] dias, int totalDias) {
        super(nome, cpf, "psicologia", registro, valor, dias, totalDias);
    }
}