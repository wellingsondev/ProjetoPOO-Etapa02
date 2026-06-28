public class OperacaoServico {

    private PacienteServico pacienteServico;

    public OperacaoServico(PacienteServico pacienteServico) {
        this.pacienteServico = pacienteServico;
    }

    public void executarCadastroSeguro(Paciente paciente) {
        try {
            pacienteServico.cadastrar(paciente);
            System.out.println("paciente cadastrado: " + paciente.getNome());
        } catch (CpfDuplicadoException e) {
            System.out.println("erro no cadastro: " + e.getMessage());
        } finally {
            System.out.println("--- fim do cadastro ---");
        }
    }

    public Paciente executarBuscaSegura(String cpf) {
        Paciente paciente = null;
        try {
            paciente = pacienteServico.buscarPorCpf(cpf);
        } catch (PacienteNaoEncontradoException e) {
            System.out.println("erro na busca: " + e.getMessage());
        }
        return paciente;
    }

    public int lerIdadeComValidacao(String entrada) {
        int idade;
        try {
            idade = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("valor invalido pra idade, digite numero");
            return -1;
        } finally {
            System.out.println("leitura de idade encerrada");
        }

        if (idade < 0) {
            System.out.println("idade negativa nao existe, vou considerar 0");
            idade = 0;
        }
        return idade;
    }
}
