public class PagamentoDinheiro extends Pagamento{
    //paulo-victor1 esteve aqui (transferencia de branch)
    
    public PagamentoDinheiro(int indiceConsulta, double valorFinal, String tipoPagamento){
        super(indiceConsulta, valorFinal, tipoPagamento);
    }

    @Override
    public double calcularValorFinal(){
        return this.valorFinal;
    }

}
