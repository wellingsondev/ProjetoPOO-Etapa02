public class Prontuario {

    private int indiceConsulta;
    private String observacoes;
    private String diagnostico;
    private String[] procedimentos;


    public Prontuario(int indiceConsulta, String observacoes,
                      String diagnostico, String[] procedimentos) {

        this.indiceConsulta = indiceConsulta;
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.procedimentos = procedimentos;
    }


    public String exibirResumo() {

        return "Consulta: " + indiceConsulta +
               "\nObservacoes: " + observacoes +
               "\nDiagnostico: " + diagnostico;
    }

}