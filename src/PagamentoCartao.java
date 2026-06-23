public class PagamentoCartao extends Pagamento {


    public PagamentoCartao(int indiceConsulta,
                           double valor,
                           int parcelas){

        super(indiceConsulta,
              valor,
              "Cartao",
              parcelas);
    }


    public double calcularParcela(){

        return valorFinal / parcelas;

    }

}