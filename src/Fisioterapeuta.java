public class Fisioterapeuta extends Profissional {

    public Fisioterapeuta(String nome, String cpf) {
        super(nome, cpf, "fisioterapia");
    }

    public Fisioterapeuta(String nome, String cpf,
                      String registro, double valor) {
        super(nome, cpf, "fisioterapia", registro, valor);
    }

    public Fisioterapeuta(String nome, String cpf,
                      String registro, double valor,
                      String[] dias, int totalDias) {
        super(nome, cpf, "fisioterapia", registro, valor, dias, totalDias);
    }
}