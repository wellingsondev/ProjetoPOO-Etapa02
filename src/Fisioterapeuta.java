public class Fisioterapeuta extends Profissional {

    private int quantidadeSessoes; // quantidadede sessões por paciente


    public Fisioterapeuta(String nome, String cpf) {
        super(nome, cpf, "fisioterapia");
        this.quantidadeSessoes = 0;
    }

    public Fisioterapeuta(String nome, String cpf,
                      String registro, double valor) {
        super(nome, cpf, "fisioterapia", registro, valor);
        this.quantidadeSessoes = 0;
    }

    public Fisioterapeuta(String nome, String cpf,
                      String registro, double valor,
                      String[] dias, int totalDias) {
        super(nome, cpf, "fisioterapia", registro, valor, dias, totalDias);
        this.quantidadeSessoes = 0;
    }
    public int getQuantidadeSessoes() { // retorno da quantidade de sessões
        return quantidadeSessoes;
    }
    public void setQuantidadeSessoes(int quantidadeSessoesPadrao) { // Padrões por sessão
        this.quantidadeSessoes = quantidadeSessoesPadrao; 
    }

    @Override // Dados do Fisio pro resumo
    public String exibirResumo() {
        return super.exibirResumo() + "\nQuantidade de sessões por paciente: " + quantidadeSessoes;
    }

    @Override
    public void registrarEspecifico(Atendimento atendimento) {
        atendimento.adicionarProcedimento("sessao de fisioterapia (" + quantidadeSessoes + " sessoes previstas)");
    }
}