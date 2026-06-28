import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PacienteServico {

    private Map<String, Paciente> pacientesPorCpf;
    private Set<String> cpfsCadastrados;

    public PacienteServico() {
        this.pacientesPorCpf = new HashMap<>();
        this.cpfsCadastrados = new HashSet<>();
    }

    public void cadastrar(Paciente paciente) throws CpfDuplicadoException {
        boolean novoCpf = cpfsCadastrados.add(paciente.getCpf());

        if (!novoCpf) {
            throw new CpfDuplicadoException("o cpf " + paciente.getCpf() + " ja esta cadastrado");
        }

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
