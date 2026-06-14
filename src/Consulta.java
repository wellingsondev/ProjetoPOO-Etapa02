import java.util.Date;

public class Consulta implements Agendavel {
    private String cpfPaciente;
    private String nomeProfissional;
    private Date data;
    private String horario;
    private String tipo;
    private String status;


    // sem tipo - assume inicial
    public Consulta(String cpfPaciente, String nomeProfissional, Date data, String horario) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = "inicial";
        this.status = "agendada";
    }

    public Consulta(String cpfPaciente, String nomeProfissional, Date data, String horario, String tipo) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
        this.status = "agendada";
    }
    // esse aqui a gente usa na remarcacao pra poder setar o status direto
     public Consulta(String cpfPaciente, String nomeProfissional, Date data,
                    String horario, String tipo, String status) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }
    public String getNomeProfissional() {
        return nomeProfissional;
    }
    public Date getData() {
        return data;
    }
    public String getHorario() {
        return horario;
    }
    public String getTipo() {
        return tipo;
    }
    public String getStatus() {
        return status;
    }

    @Override
     public void cancelar() {
        this.status = "cancelada";
    }

    // cancelar com motivo - retorna a msg formatada
    @Override
    public String cancelar(String motivo) {
        this.status = "cancelada";
        return "Consulta cancelada. Motivo: " + motivo;
    }

    public void remarcar() {
        this.status = "remarcada";
    }

    public void realizar() {
        this.status = "realizada";
    }

    public String exibirResumo() {
        return "Paciente(CPF): " + cpfPaciente + " | Prof: " + nomeProfissional
                + " | Data: " + data + " | Hora: " + horario
                + " | Tipo: " + tipo + " | Status: " + status;
    }

    @Override
    public void agendar() {
            this.status = "agendada";
    }
}
