public class PagamentoConvenio extends Pagamento{
    //isso ja tava no meu commit do dia 22/06 as 21h40
    public PagamentoConvenio(int indiceConsulta, double valorFinal, String tipoPagamento){
        super(indiceConsulta, valorFinal, tipoPagamento);
    }
    @Override
    public double calcularValorFinal(){
        return getValorFinal();
    }

}
