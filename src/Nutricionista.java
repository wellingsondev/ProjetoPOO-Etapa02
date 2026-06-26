public class Nutricionista extends Profissional {

    public Nutricionista(String nome, String cpf) {
        super(nome, cpf, "nutricao");
    }

    public Nutricionista(String nome, String cpf,
                      String registro, double valor) {
        super(nome, cpf, "nutricao", registro, valor);
    }

    public Nutricionista(String nome, String cpf,
                      String registro, double valor,
                      String[] dias, int totalDias) {
        super(nome, cpf, "nutricao", registro, valor, dias, totalDias);
    }
}
