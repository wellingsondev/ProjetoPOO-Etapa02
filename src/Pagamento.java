// eu fiz comit dessa classe no repositorio errado...
public abstract class Pagamento {
    private int indiceConsulta;
    private double valorFinal;
    private String tipoPagamento;
    private int parcelas;

    //getters por conta do encapsulamento
    public int getIndiceConsulta(){
        return indiceConsulta;
    }
    public double getValorFinal(){
        return valorFinal;
    }
    public String getTipoPagamento(){
        return tipoPagamento;
    }
    public int getParcelas(){
        return parcelas;
    }

    //Pagamento comum, dinheiro ou pix sem parcela
    public Pagamento(int indiceConsulta, double valorFinal, String tipoPagamento) {
        this.indiceConsulta = indiceConsulta;
        this.valorFinal = valorFinal;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = 1;
    }
    //possivel parcelar / cartao
    public Pagamento(int indiceConsulta, double valorFinal, String tipoPagamento, int parcelas) {
        this.indiceConsulta = indiceConsulta;
        this.valorFinal = valorFinal;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = parcelas;
    }

    public abstract double calcularValorFinal();

    public String exibirResumo() {
        double valor = calcularValorFinal();
        String resumo = "Consulta #" + indiceConsulta + " | Valor: R$" + valor + " | Tipo: " + tipoPagamento + " | Parcelas: " + parcelas;
        if (parcelas > 1) {
            double valorParcela =
                    Math.round((valor / parcelas) * 100.0) / 100.0;
            resumo += " (R$" + valorParcela + " cada)";
        }
        return resumo;
    }
}

