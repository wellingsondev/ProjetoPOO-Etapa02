import java.util.HashMap;
import java.util.Map;

public class PacienteServico {

    private Map<String, Paciente> pacientesPorCpf;

    public PacienteServico() {
        this.pacientesPorCpf = new HashMap<>();
    }

    public void cadastrar(Paciente paciente) {
        pacientesPorCpf.put(paciente.getCpf(), paciente);
    }

    public Paciente buscarPorCpf(String cpf) throws PacienteNaoEncontradoException {
        Paciente paciente = pacientesPorCpf.get(cpf);

        if (paciente == null) {
            throw new PacienteNaoEncontradoException("nenhum paciente encontrado com o cpf " + cpf);
        }

        return paciente;
    }
}
