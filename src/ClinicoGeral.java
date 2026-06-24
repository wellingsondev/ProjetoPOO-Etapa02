public class ClinicoGeral extends Profissional {

    public ClinicoGeral(String nome, String cpf) {
        super(nome, cpf, "clinica geral");
    }

    
    public ClinicoGeral(String nome, String cpf,
                      String registro, double valor) {
        super(nome, cpf, "clinica geral", registro, valor);
    }

    public ClinicoGeral(String nome, String cpf,
                      String registro, double valor,
                         String[] dias, int totalDias) {
        super(nome, cpf, "clinica geral", registro, valor, dias, totalDias);
    }
}