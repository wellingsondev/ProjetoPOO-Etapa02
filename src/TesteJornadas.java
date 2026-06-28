import java.util.ArrayList;
import java.util.List;

public class TesteJornadas {

    public static void main(String[] args) {
        PacienteServico pacienteServico = new PacienteServico();
        OperacaoServico operacaoServico = new OperacaoServico(pacienteServico);
        ExportacaoServico exportacaoServico = new ExportacaoServico();
        AtendimentoServico atendimentoServico = new AtendimentoServico();
        HorarioServico horarioServico = new HorarioServico();

        Paciente p1 = new Paciente("Carlos Eduardo", "52199384021");
        Paciente p2 = new Paciente("Fernanda Lima", "70812456390");

        operacaoServico.executarCadastroSeguro(p1);
        operacaoServico.executarCadastroSeguro(p2);
        // testando cpf repetido de proposito
        operacaoServico.executarCadastroSeguro(new Paciente("Carlos Falso", "52199384021"));

        Paciente busca = operacaoServico.executarBuscaSegura("70812456390");
        if (busca != null) {
            System.out.println(busca.exibirResumo());
        }
        operacaoServico.executarBuscaSegura("00000000000");

        String[] diasPsicologa = {"segunda", "quarta"};
        Psicologo psicologa = new Psicologo("Ana Beatriz", "33344455566", "registro123", 150.0, diasPsicologa, 2);
        psicologa.setAbordagemTerapeutica("TCC");

        List<Profissional> profissionais = new ArrayList<>();
        profissionais.add(psicologa);

        Consulta consulta = new Consulta(p1.getCpf(), psicologa.getNome(), "30/06/2026", "14:00");
        Atendimento atendimento = new Atendimento(0, "paciente relatou melhora no quadro", "ansiedade leve");

        try {
            atendimentoServico.registrarComEspecialidade(atendimento, consulta, profissionais);
            System.out.println(atendimento.exibirResumo());
        } catch (OperacaoInvalidaException e) {
            System.out.println("erro ao registrar atendimento: " + e.getMessage());
        }

        Fisioterapeuta fisio = new Fisioterapeuta("Rafael Souza", "88877766655", "registro456", 130.0, new String[]{"terca"}, 1);
        try {
            horarioServico.transferirDias(psicologa, fisio);
            System.out.println(fisio.exibirResumo());
        } catch (RuntimeException e) {
            System.out.println("nao foi possivel transferir os dias: " + e.getMessage());
        }

        PagamentoConvenio pagamento = new PagamentoConvenio(0, 180.0, "convenio", "SaudePlus", 30.0);

        List<Exportavel> exportaveis = new ArrayList<>();
        exportaveis.add(atendimento);
        exportaveis.add(pagamento);
        exportacaoServico.exportarTudo(exportaveis);

        int idade = operacaoServico.lerIdadeComValidacao("trinta");
        System.out.println("idade lida: " + idade);
    }
}
