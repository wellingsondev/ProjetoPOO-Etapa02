import java.util.Date;

abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private Date nascimento;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    public Date getNascimento() {
        return nascimento;      
    }
    public abstract void exibirResumo();
}