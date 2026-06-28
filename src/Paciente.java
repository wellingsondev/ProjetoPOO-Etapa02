public class Paciente extends Pessoa { 
    private int idade;
    private Convenio convenio;
    private boolean ativo;

    public Paciente(String nome, String cpf) {
        super(nome, cpf);

        this.idade = 0;
        setTelefone("");
        this.convenio = null;
        this.ativo = true;
    }

    public Paciente(String nome, String cpf, int idade, String telefone) {
        super(nome, cpf);

        this.idade = idade;
        setTelefone(telefone);
        this.convenio = null;
        this.ativo = true;
    }
    // construtor com todos os dados
    public Paciente(String nome, String cpf, int idade, String telefone, Convenio convenio) {
        super(nome, cpf);

        this.idade = idade;
        setTelefone(telefone);
        this.convenio = convenio;
        this.ativo = true;
    }
    // atualiza so idade e telefone
    public void complementar(int idade, String telefone) {
        this.idade = idade;
        setTelefone(telefone);
    }

    // atualiza tudo incluindo convenio
    public void complementar(int idade, String telefone, Convenio convenio) {
        this.idade = idade;
        setTelefone(telefone);
        this.convenio = convenio;
    }

    public void desativar() {
        this.ativo = false;
    }
    
    @Override
    public String exibirResumo() {
        String status = "Sim";
        if (!ativo) {
            status = "Nao";
        }
        return "Nome: " + getNome() + " | CPF: " + getCpf() + " | Idade: " + idade
                + " | Tel: " + getTelefone() + " | Convenio: " + (convenio != null ? convenio.getNome() : "Nenhum")
                + " | Ativo: " + status;
    }

    public int getIdade() {
        return idade;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
}
