import java.util.ArrayList;
import java.util.List;

public class Consulta implements Agendavel {
    private String cpfPaciente;
    private String nomeProfissional;
    private String data;
    private String horario;
    private String tipo;
    private String status;
    private List<Double> multas = new ArrayList<>();


    // sem tipo - assume inicial
    public Consulta(String cpfPaciente, String nomeProfissional, String data, String horario) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = "inicial";
        this.agendar();
    }

    public Consulta(String cpfPaciente, String nomeProfissional, String data, String horario, String tipo) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
        this.agendar();
    }
    // esse aqui a gente usa na remarcacao pra poder setar o status direto
     public Consulta(String cpfPaciente, String nomeProfissional, String data,
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
    public void setData(String data) {
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
    public String getData() {
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
    @Override
    public void remarcar(String cpf, String nomeProf, String novaData, String novoHorario) {
        this.cpfPaciente = cpf;
        this.nomeProfissional = nomeProf;
        this.data = novaData;
        this.horario = novoHorario;
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

    public void setMultas(double multa){
        this.multas.add(multa);
    }

    public List<Double> getMultas(){

        return this.multas;
    }


}
