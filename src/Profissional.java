
public abstract class Profissional extends Pessoa {

    private String especialidade;
    private String registroProfissional;
    private double valorConsulta;
    private String[] diasDisponiveis;
    private int totalDias;

    // so nome e especialidade
    public Profissional(String nome, String cpf, String especialidade) {
        super(nome, cpf);

        this.especialidade = especialidade;
        this.registroProfissional = "";
        this.valorConsulta = 0;
        this.diasDisponiveis = new String[7];
        this.totalDias = 0;
    }

    public Profissional(String nome, String cpf, String especialidade, String registroProfissional, double valorConsulta) {
        super(nome, cpf);

        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.diasDisponiveis = new String[7];
        this.totalDias = 0;
    }

    // construtor completo com dias
    public Profissional(String nome, String cpf, String especialidade, String registroProfissional, double valorConsulta, String[] dias, int totalDias) {
        super(nome, cpf);

        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.diasDisponiveis = new String[7];
        this.totalDias = totalDias;
        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis[i] = dias[i];
        }
    }

    public void atualizar(String registro, double valor) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
    }

    public void atualizar(String registro, double valor, String[] dias, int totalDias) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
        this.totalDias = totalDias;
        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis[i] = dias[i];
        }
    }

    // verifica se o profissional atende naquele dia
    public boolean atendeNoDia(String dia) {
        for (int i = 0; i < totalDias; i++) {
            if (diasDisponiveis[i].equals(dia)) {
                return true;
            }
        }
        return false;
    }

    // valida as especialidades aceitas pela clinica
    public static boolean especialidadeValida(String esp) {
        if (esp.equals("clinica geral")) return true;
        if (esp.equals("fisioterapia")) return true;
        if (esp.equals("psicologia")) return true;
        if (esp.equals("nutricao")) return true;
        return false;
    }

    public String exibirResumo() {
        String dias = "";
        for (int i = 0; i < totalDias; i++) {
            if (i > 0) dias = dias + ", ";
            dias = dias + diasDisponiveis[i];
        }
        return "Nome: " + getNome() + " | Espec: " + especialidade + " | Reg: " + registroProfissional
                + " | Valor: R$" + valorConsulta + " | Dias: " + dias;
    }
    //getters
    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public String[] getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public int getTotalDias() {
        return totalDias;
    }

    //setters
    public void setEspecialidade(String especialidade) {
        if (!especialidade.equals("")) {
            this.especialidade = especialidade;
        }
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public void setValorConsulta(double valorConsulta) {
        if (valorConsulta >= 0) {
            this.valorConsulta = valorConsulta;
        }
    }
}
