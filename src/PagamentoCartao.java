public class PagamentoCartao extends Pagamento{
    //isso ja tava no meu commit do dia 22/06 as 21h40
    public PagamentoCartao(int indiceConsulta, double valorFinal, String tipoPagamento, int parcelas){
        super(indiceConsulta, valorFinal, tipoPagamento, parcelas);
    }
     @Override
    public double calcularValorFinal() {
        return getValorFinal() * 0.90;
    }

}
