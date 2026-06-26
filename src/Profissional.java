    public class Profissional {
        private String nome;
        private String especialidade;
        private String registroProfissional;
        private double valorConsulta;
        private String[] diasDisponiveis;
        private int totalDias;
        private String abordagemTerapeutica; // abordagem utilizada pelo psicólogo
        private int quantidadeSessoesPadrao; // quantidade padrão de sessões para fisioterapia

        // so nome e especialidade
        public Profissional(String nome, String especialidade) {
            this.nome = nome;
            this.especialidade = especialidade;
            this.registroProfissional = "";
            this.valorConsulta = 0;
            this.diasDisponiveis = new String[7];
            this.totalDias = 0;
            this.abordagemTerapeutica = "";
            this.quantidadeSessoesPadrao = 0; // inicializa a quantidade de sessões padrão
        }

        public Profissional(String nome, String especialidade, String registroProfissional, double valorConsulta) {
            this.nome = nome;
            this.especialidade = especialidade;
            this.registroProfissional = registroProfissional;
            this.valorConsulta = valorConsulta;
            this.diasDisponiveis = new String[7];
            this.totalDias = 0;
            this.abordagemTerapeutica = "";
            this.quantidadeSessoesPadrao = 0;
        }

        // construtor completo com dias
        public Profissional(String nome, String especialidade, String registroProfissional,
                            double valorConsulta, String[] dias, int totalDias) {
            this.nome = nome;
            this.especialidade = especialidade;
            this.registroProfissional = registroProfissional;
            this.valorConsulta = valorConsulta;
            this.diasDisponiveis = new String[7];
            this.abordagemTerapeutica = "";
            this.quantidadeSessoesPadrao = 0;
            this.totalDias = totalDias;
            for (int i = 0; i < totalDias; i++) {
                this.diasDisponiveis[i] = dias[i];
            }
        }

        public void atualizar(String registro, double valor) {
            this.registroProfissional = registro;
            this.valorConsulta = valor;
        }

        public void atualizar(String registro, double valor, String[] dias, int totalDias) {
            this.registroProfissional = registro;
            this.valorConsulta = valor;
            this.totalDias = totalDias;
            for (int i = 0; i < totalDias; i++) {
                this.diasDisponiveis[i] = dias[i];
            }
        }

        // verifica se o profissional atende naquele dia
        public boolean atendeNoDia(String dia) {
            for (int i = 0; i < totalDias; i++) {
                if (diasDisponiveis[i].equals(dia)) {
                    return true;
                }
            }
            return false;
        }

        // valida as especialidades aceitas pela clinica
        public static boolean especialidadeValida(String esp) {
            if (esp.equals("clinica geral")) return true;
            if (esp.equals("fisioterapia")) return true;
            if (esp.equals("psicologia")) return true;
            if (esp.equals("nutricao")) return true;
            return false;
        }

        public String exibirResumo() {
            String dias = "";
            for (int i = 0; i < totalDias; i++) {
                if (i > 0) dias = dias + ", ";
                dias = dias + diasDisponiveis[i];
            }
            // Exibe a abordagem terapêutica quando a especialidade for psicologia
            if (especialidade.equals("psicologia")) {
            return "Nome: " + nome + " | Espec: " + especialidade + " | Reg: " + registroProfissional
                + " | Valor: R$" + valorConsulta + " | Dias: " + dias + " | Abordagem: " + abordagemTerapeutica;
}
        // Exibe sessões padrão quando a especialidade for fisioterapia
            if (especialidade.equals("fisioterapia")) {
            return "Nome: " + nome + " | Espec: " + especialidade  + " | Reg: " + registroProfissional
                 + " | Valor: R$" + valorConsulta + " | Dias: " + dias   + " | Sessoes: " + quantidadeSessoesPadrao;
}
            return "Nome: " + nome + " | Espec: " + especialidade + " | Reg: " + registroProfissional
                    + " | Valor: R$" + valorConsulta + " | Dias: " + dias;
        }

        public String getNome() {
            return nome;
        }
        public String getEspecialidade() {
            return especialidade;
        }
        public String getRegistroProfissional() {
            return registroProfissional;
        }
        public double getValorConsulta() {
            return valorConsulta;
        }
        public String[] getDiasDisponiveis() {
            return diasDisponiveis;
        }
        public int getTotalDias() {
            return totalDias;
        }
        // Retorna a quantidade de sessões padrão para fisioterapia
        public int getQuantidadeSessoesPadrao() {
        return quantidadeSessoesPadrao;
        }
        // Define a quantidade de sessões padrão para fisioterapia
        public void setQuantidadeSessoesPadrao(int quantidadeSessoesPadrao) {
        this.quantidadeSessoesPadrao = quantidadeSessoesPadrao;
        }
        // retorna a abordagem terapêutica
        public String getAbordagemTerapeutica() {
        return abordagemTerapeutica;
        }
        // define a abordagem terapêutica
        public void setAbordagemTerapeutica(String abordagemTerapeutica) {
         this.abordagemTerapeutica = abordagemTerapeutica;
}
}
