public class PagamentoCartao extends Pagamento{
    //paulo-victor1 esteve aqui (transferencia de branch)
    public PagamentoCartao(int indiceConsulta, double valorFinal, String tipoPagamento, int parcelas){
        super(indiceConsulta, valorFinal, tipoPagamento, parcelas);
    }
     @Override
    public double calcularValorFinal() {
        return getValorFinal() * 0.90;
    }

}
