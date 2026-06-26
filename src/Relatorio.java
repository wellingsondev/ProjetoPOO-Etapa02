
import java.util.List;

public class Relatorio {
    //17:33 mudancas em coisas q n  envolvem a logica, mas sim o uso de arraylists para se adaptar a estrutura do codigo inteiro

    // mostra todas as consultas
    public static void gerarRelatorio(List<Consulta> consultas,
                                  List<Atendimento> atendimentos) {

        System.out.println("\n=== RELATORIO GERAL ===");
       for (int i = 0; i < consultas.size(); i++) {
            System.out.println(consultas.get(i).exibirResumo());
            // verifica se tem diagnostico
            String diag = buscarDiagnostico(i, atendimentos);
            if (!diag.equals("")) {
                System.out.println("  Diagnostico: " + diag);
            }
            System.out.println("---");
        }
    }

    //necessario pra pagamentoAutomatico(), feito nesse commit por paulo-victor1
    public static int buscarIndiceProfissional(String nome, List<Profissional> profissionais) {
    for (int i = 0; i < profissionais.size(); i++) {
        if (profissionais.get(i).getNome().equals(nome)) {
            return i;
        }
    }
    return -1;
    }
    //necessario pra pagamentoAutomatico(), feito nesse commit por paulo-victor1
    public static int buscarIndicePaciente(String cpf, List<Paciente> pacientes) {
    for (int i = 0; i < pacientes.size(); i++) {
        if (pacientes.get(i).getCpf().equals(cpf)) {
            return i;
        }
    }
    return -1;
}

    // filtra por profissional
    public static void gerarRelatorio(List<Consulta> consultas, List<Atendimento> atendimentos, String nomeProfissional) {

        System.out.println("\n==== RELATORIO - " + nomeProfissional + " ====");
        boolean achou = false;
       for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getNomeProfissional().equals(nomeProfissional)) {
                System.out.println(consultas.get(i).exibirResumo());
                String diag = buscarDiagnostico(i, atendimentos);
                if (!diag.equals("")) {
                    System.out.println("  Diagnostico: " + diag);
                }
                System.out.println("---");
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhuma consulta encontrada para esse profissional.");
        }
    }

    // filtra por periodo (data inicio e fim)
    public static void gerarRelatorio(List<Consulta> consultas, List<Atendimento> atendimentos, String dataInicio, String dataFim) {

        System.out.println("\n=== RELATORIO - " + dataInicio + " a " + dataFim + " ===");
        for (int i = 0; i < consultas.size(); i++) {
            if (estaNoIntervalo(consultas.get(i).getData(), dataInicio, dataFim)) {
                System.out.println(consultas.get(i).exibirResumo());
                String diag = buscarDiagnostico(i, atendimentos);
                if (!diag.equals("")) {
                    System.out.println("  Diagnostico: " + diag);
                }
                System.out.println("---");
            }
        }
    }

    // resumo financeiro do dia foi mudado pra adaptarse ao arraylist
    public static void gerarResumoFinanceiro( List<Consulta> consultas, List<Pagamento> pagamentos, double[] multas, int totalMultas) {

        int realizadas = 0;
        int canceladas = 0;
        double totalFaturado = 0;
        double totalEmMultas = 0;

    for (int i = 0; i < consultas.size(); i++) {

        if (consultas.get(i).getStatus().equals("realizada")) {
            realizadas++;
        }

        if (consultas.get(i).getStatus().equals("cancelada")) {
            canceladas++;
        }
    }

    for (int i = 0; i < pagamentos.size(); i++) {
        totalFaturado += pagamentos.get(i).calcularValorFinal();
    }

    for (int i = 0; i < totalMultas; i++) {
        totalEmMultas += multas[i];
    }

    System.out.println("\n=== RESUMO FINANCEIRO ===");
    System.out.println("Atendimentos realizados: " + realizadas);
    System.out.println("Total faturado: R$" + Math.round(totalFaturado * 100.0) / 100.0);
    System.out.println("Cancelamentos: " + canceladas);
    System.out.println("Total em multas: R$" + Math.round(totalEmMultas * 100.0) / 100.0);
}
    // busca diagnostico de um atendimento pelo indice da consulta att para se adaptar a arraylist
    public static String buscarDiagnostico(int indiceConsulta, List<Atendimento> atendimentos) {

    for (int i = 0; i < atendimentos.size(); i++) {
        if (atendimentos.get(i).getIndiceConsulta() == indiceConsulta) {
            return atendimentos.get(i).getDiagnostico();
        }
    }
    return "";
}

    // compara datas convertendo pra numero inteiro (AAAAMMDD)
    public static boolean estaNoIntervalo(String data, String inicio, String fim) {
        int valorData = converterDataParaNumero(data);
        int valorInicio = converterDataParaNumero(inicio);
        int valorFim = converterDataParaNumero(fim);
        return valorData >= valorInicio && valorData <= valorFim;
    }

    // converte DD/MM/AAAA pra um numero tipo 20260519 pra poder comparar
    private static int converterDataParaNumero(String data) {
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));
        return ano * 10000 + mes * 100 + dia;
    }
}
