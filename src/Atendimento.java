public class Atendimento implements Exportavel {

    private int indiceConsulta;
    private Prontuario prontuario;

    // registro basico - so observacoes
    public Atendimento(int indiceConsulta, String observacoes) {

        this.indiceConsulta = indiceConsulta;

        this.prontuario = new Prontuario();
        this.prontuario.setObservacoes(observacoes);
    }

    // registro com diagnostico
    public Atendimento(int indiceConsulta,
                       String observacoes,
                       String diagnostico) {

        this.indiceConsulta = indiceConsulta;

        this.prontuario = new Prontuario();
        this.prontuario.setObservacoes(observacoes);
        this.prontuario.setDiagnostico(diagnostico);
    }


    public Atendimento(int indiceConsulta,
                       String observacoes,
                       String diagnostico,
                       String[] procedimentos,
                       int totalProcedimentos) {

        this.indiceConsulta = indiceConsulta;

        this.prontuario = new Prontuario();

        this.prontuario.setObservacoes(observacoes);
        this.prontuario.setDiagnostico(diagnostico);

        for (int i = 0; i < totalProcedimentos; i++) {
            this.prontuario.adicionarProcedimento(procedimentos[i]);
        }
    }

    public void adicionarProcedimento(String procedimento) {

        prontuario.adicionarProcedimento(procedimento);

    }

    public void adicionarProcedimento(String[] procs,
                                      int quantidade) {

        prontuario.adicionarProcedimento(procs, quantidade);

    }

    public String exibirResumo() {

        return prontuario.exibirResumo();

    }

    public int getIndiceConsulta() {
        return indiceConsulta;
    }

    public String getDiagnostico() {
        return prontuario.getDiagnostico();
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    @Override
    public void exportarDados() {

        String resumo =
                exibirResumo().replace("\n", " | ");

        System.out.println(
                "Atendimento da consulta "
                        + indiceConsulta
                        + " - "
                        + resumo
        );
    }
}