public class PagamentoConvenio extends Pagamento {

    private double cobertura;


    public PagamentoConvenio(
            int indiceConsulta,
            double valor,
            double cobertura){

        super(indiceConsulta,
              valor,
              "Convenio");

        this.cobertura = cobertura;
    }


    public double calcularValorPaciente(){

        return valorFinal -
              (valorFinal * cobertura / 100);

    }

}