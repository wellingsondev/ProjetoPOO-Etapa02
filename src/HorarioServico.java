public class HorarioServico {

    // pega os dias do profissional antigo e soma aos dias que o novo ja tem
    // os dias nao se perdem quando o profissional antigo "sai", so passam pra frente
    public void transferirDias(Profissional antigo, Profissional novo) {
        String[] diasAntigo = antigo.getDiasDisponiveis();
        int totalAntigo = antigo.getTotalDias();

        String[] diasNovo = novo.getDiasDisponiveis();
        int totalNovo = novo.getTotalDias();

        String[] diasFinais = new String[7];
        int totalFinal = 0;

        for (int i = 0; i < totalNovo; i++) {
            diasFinais[totalFinal] = diasNovo[i];
            totalFinal++;
        }

        for (int i = 0; i < totalAntigo; i++) {
            if (novo.atendeNoDia(diasAntigo[i])) {
                throw new HorarioIndisponivelException("o profissional " + novo.getNome()
                        + " ja atende no dia " + diasAntigo[i]);
            }
            if (totalFinal >= 7) {
                throw new HorarioIndisponivelException("nao ha mais espaco de dias pra transferir pro profissional "
                        + novo.getNome());
            }
            diasFinais[totalFinal] = diasAntigo[i];
            totalFinal++;
        }

        novo.atualizar(novo.getRegistroProfissional(), novo.getValorConsulta(), diasFinais, totalFinal);
    }

    public boolean temDiaLivre(Profissional profissional, String dia) {
        return !profissional.atendeNoDia(dia);
    }
}
