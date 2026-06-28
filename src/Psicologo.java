public class Psicologo extends Profissional {

    private String abordagemTerapeutica; 

    public Psicologo(String nome, String cpf) {
        super(nome, cpf, "psicologia");
        this.abordagemTerapeutica = "";
    }

    public Psicologo(String nome, String cpf,
                      String registro, double valor) {
        super(nome, cpf, "psicologia", registro, valor);
        this.abordagemTerapeutica = "";
    }

    public Psicologo(String nome, String cpf,
                      String registro, double valor,
                      String[] dias, int totalDias) {
        super(nome, cpf, "psicologia", registro, valor, dias, totalDias);
        this.abordagemTerapeutica = "";
    }
    public String getAbordagemTerapeutica() {
    return abordagemTerapeutica;
    }
    public void setAbordagemTerapeutica(String abordagemTerapeutica) {
        if (!abordagemTerapeutica.equals("")) {
            this.abordagemTerapeutica = abordagemTerapeutica;
        }
    }
    @Override // Dados do Psicologo 
    public String exibirResumo() {
        return super.exibirResumo()
                + " | Abordagem: " + abordagemTerapeutica;
    }

    @Override
    public void registrarEspecifico(Atendimento atendimento) {
        String abordagem = abordagemTerapeutica.equals("") ? "abordagem nao definida" : abordagemTerapeutica;
        atendimento.adicionarProcedimento("sessao de psicologia - abordagem " + abordagem);
    }
}