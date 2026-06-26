public class PagamentoCartao extends Pagamento {

    public PagamentoCartao(int indiceConsulta,
                           double valorFinal,
                           String tipoPagamento,
                           int parcelas){

        super(indiceConsulta, valorFinal, tipoPagamento, parcelas);
    }


    @Override
    public double calcularValorFinal() {
        return this.valorFinal * 0.90;
    }


    public double calcularParcela(){

        return calcularValorFinal() / parcelas;

    }

}
