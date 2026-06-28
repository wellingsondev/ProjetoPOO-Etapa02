import java.util.List;

public class AtendimentoServico {

    public void registrarComEspecialidade(Atendimento atendimento, Consulta consulta, List<Profissional> profissionais)
            throws OperacaoInvalidaException {

        Profissional profissional = buscarPorNome(consulta.getNomeProfissional(), profissionais);

        if (profissional == null) {
            throw new OperacaoInvalidaException("profissional da consulta nao foi encontrado");
        }

        // aqui cada tipo de profissional executa o proprio registrarEspecifico
        profissional.registrarEspecifico(atendimento);
    }

    private Profissional buscarPorNome(String nome, List<Profissional> profissionais) {
        for (Profissional p : profissionais) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }
}
