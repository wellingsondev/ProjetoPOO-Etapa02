import java.util.ArrayList;
import java.util.List;

public class Convenio {

    private String nome;
    private double percentualCobertura;
    private List<String> especialidadesCobertas;

    public Convenio(String nome, double percentualCobertura) {
        this.nome = nome;
        this.percentualCobertura = percentualCobertura;
        this.especialidadesCobertas = new ArrayList<>();
    }

    public void adicionarEspecialidade(String especialidade){
        especialidadesCobertas.add(especialidade);
    }

    public boolean cobre(String especialidade){
        return especialidadesCobertas.contains(especialidade);
    }

    public double getPercentualCobertura(){
        return percentualCobertura;
    }

    public String getNome(){
        return nome;
    }
    public boolean isEmpty() {
        return nome == null || nome.isEmpty();
    }
}
    

