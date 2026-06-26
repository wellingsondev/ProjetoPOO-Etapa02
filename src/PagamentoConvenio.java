public class PagamentoConvenio extends Pagamento {
    private String nomeConvenio;
    private double percentualDesconto;

    public PagamentoConvenio(int indiceConsulta, double valorFinal, String tipoPagamento, String nomeConvenio, double percentualDesconto) {
        super(indiceConsulta, valorFinal, tipoPagamento);
        this.nomeConvenio = nomeConvenio;
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public double calcularValorFinal() {
        return this.valorFinal * (1 - percentualDesconto / 100);
    }
    public String getNomeConvenio() {
        return nomeConvenio;
    }
    public double getPercentualDesconto() {
        return percentualDesconto;  
    }

    
}