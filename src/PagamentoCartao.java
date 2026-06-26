public class PagamentoCartao extends Pagamento{
    //paulo-victor1 esteve aqui (transferencia de branch)
    
    public PagamentoCartao(int indiceConsulta, double valorFinal, String tipoPagamento, int parcelas){
        super(indiceConsulta, valorFinal, tipoPagamento, parcelas);
    }
    
     @Override
    public double calcularValorFinal() {
        return this.valorFinal * 0.90;
    }

}
