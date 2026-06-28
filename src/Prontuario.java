public class Prontuario {

    private String observacoes;
    private String diagnostico;

    private String[] procedimentos;
    private int totalProcedimentos;

    public Prontuario() {

        procedimentos = new String[10];
        totalProcedimentos = 0;

        observacoes = "";
        diagnostico = "";
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void adicionarProcedimento(String procedimento) {

        if (totalProcedimentos < 10) {

            procedimentos[totalProcedimentos] =
                    procedimento;

            totalProcedimentos++;
        }
    }

    public void adicionarProcedimento(String[] procs,
                                      int quantidade) {

        for (int i = 0;
             i < quantidade && totalProcedimentos < 10;
             i++) {

            procedimentos[totalProcedimentos] =
                    procs[i];

            totalProcedimentos++;
        }
    }

    public String exibirResumo() {

        String resumo =
                "Observacoes: " + observacoes;

        if (!diagnostico.equals("")) {

            resumo +=
                    "\nDiagnostico: "
                            + diagnostico;
        }

        if (totalProcedimentos > 0) {

            resumo += "\nProcedimentos: ";

            for (int i = 0;
                 i < totalProcedimentos;
                 i++) {

                resumo += procedimentos[i];

                if (i < totalProcedimentos - 1) {
                    resumo += ", ";
                }
            }
        }

        return resumo;
    }
}