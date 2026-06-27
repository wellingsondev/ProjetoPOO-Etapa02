import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class ClinicaServico {
    
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Profissional> profissionais = new ArrayList<>();

    private static List<Consulta> consultas = new ArrayList<>();
    private static List<Atendimento> atendimentos = new ArrayList<>();
    private static List<Pagamento> pagamentos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public static void cadastrarPaciente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        int tipo = 0;
        boolean tipoInvalido = false;

        // verifica se ja existe
        if (buscarIndicePaciente(cpf) != null) {
            System.out.println("CPF ja cadastrado!");
            return;
        }

        //Refatorei aqui e usei exceção para tentar evitar erro do usuário e o sistema não parar (ass: lucas primo)
        while (!tipoInvalido){
            try{
                System.out.println("Tipo (1-Mínimo / 2-Com idade e tel / 3-Completo):");
                tipo = Integer.parseInt(sc.nextLine());
                if (tipo >= 1 && tipo <= 3){
                    tipoInvalido = true;
                }else {
                    System.out.println("Opção inválida. Digite 1, 2 ou 3.");
                }
            }
            catch (NumberFormatException e){
                System.out.println("ERRO: Você digitou texto. Digite apenas números (1, 2 ou 3).");
            }
        }

        if (tipo == 1) {

            pacientes.add(new Paciente(nome, cpf));
            System.out.println("Paciente cadastrado com sucesso!");

            } else if (tipo == 2) {

                //===== LER A IDADE DO PACIENTE =====
                int lerIdade = 0;
                boolean idadeValida = false;

                //Aqui fiz para validar a idade e nem deixar negativa ou adicionar outro caractere inválido
                while (!idadeValida) {
                    try {
                        System.out.println("Digite a idade do paciente: ");
                        lerIdade = Integer.parseInt(sc.nextLine());
                        if (lerIdade < 0) {
                            System.out.println("Idade não pode ser negativa. Tente novamente.");
                        } else {
                            idadeValida = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Você digitou um valor inválido. Digite apenas números para a idade.");
                    }
                }
                String lerTelefone = "";
                boolean telValido = false;
                while (!telValido) {
                    System.out.print("Digite o telefone do paciente: ");
                    lerTelefone = sc.nextLine();
                    //Esse regex "\\d+" aceita uma ou mais ocorrências de dígitos (0 a 9).
                    if (lerTelefone.matches("\\d+")) {
                        telValido = true;
                    } else {
                        System.out.println("Telefone deve conter apenas números. Tente novamente.");
                    }
                }

                pacientes.add(new Paciente(nome, cpf, lerIdade, lerTelefone));
                System.out.println("Paciente cadastrado com sucesso!");

            } else if (tipo == 3) {

                //===== LER A IDADE DO PACIENTE =====
                int lerIdade = 0;
                boolean idadeValida = false;

                //Aqui fiz para validar a idade e nem deixar negativa ou adicionar outro caractere inválido
                while (!idadeValida) {
                    try {
                        System.out.println("Digite a idade do paciente: ");
                        lerIdade = Integer.parseInt(sc.nextLine());
                        if (lerIdade < 0) {
                            System.out.println("Idade não pode ser negativa. Tente novamente.");
                        } else {
                            idadeValida = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Você digitou um valor inválido. Digite apenas números para a idade.");
                    }
                }

                //===== LER NUMERO DE TELEFONE DO PACIENTE =====
                String lerTelefone = "";
                boolean telValido = false;
                while (!telValido) {
                    System.out.print("Digite o telefone do paciente: ");
                    lerTelefone = sc.nextLine();

                    //Esse regex "\\d+" aceita uma ou mais ocorrências de dígitos (0 a 9).
                    if (lerTelefone.matches("\\d+")) {
                        telValido = true;
                    } else {
                        System.out.println("Telefone deve conter apenas números. Tente novamente.");
                    }
                }
                System.out.println("Digite o covênio do paciente: ");
                String lerConvenio = sc.nextLine();

                pacientes.add(new Paciente(nome, cpf, lerIdade, lerTelefone, lerConvenio));
                System.out.println("Paciente cadastrado com sucesso!");
        }
    }

    public static void complementarPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        Paciente paciente = buscarIndicePaciente(cpf);
        
        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
            return;
        }

        System.out.print("Vai informar convenio? (1-Nao / 2-Sim): ");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        System.out.print("Telefone: ");
        String tel = sc.nextLine();

        if (tipo == 1) {
            paciente.complementar(idade, tel);
        } else if (tipo == 2) {
            System.out.print("Convenio: ");
            String conv = sc.nextLine();
            paciente.complementar(idade, tel, conv);
        }else{
            System.out.println("Tipo invalido!");
            return;
        }
        System.out.println("Cadastro atualizado!");
    }

    public static void buscarPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        Paciente paciente = buscarIndicePaciente(cpf);

        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
        } else {
            System.out.println(paciente.exibirResumo());
        }
    }

    public static void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.exibirResumo());
        }
    }

    public static void desativarPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        Paciente paciente = buscarIndicePaciente(cpf);
        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
        } else {
            paciente.desativar();
            System.out.println("Paciente desativado.");
        }
    }

    public static Paciente buscarIndicePaciente(String cpf) {
            for (Paciente paciente : pacientes) {
                if (paciente.getCpf().equals(cpf)) return paciente;
            }
            return null;
        }

    public static void cadastrarProfissional() {
    System.out.print("Nome: ");
    String nome = sc.nextLine();
    System.out.print("CPF: ");
    String cpf = sc.nextLine();
    System.out.print("Especialidade (clinica geral/fisioterapia/psicologia/nutricao): ");
    String esp = sc.nextLine();

    if (!Profissional.especialidadeValida(esp)) {
        System.out.println("Especialidade invalida!");
        return;
    }

    System.out.print("Tipo (1-Minimo / 2-Com registro e valor / 3-Completo): ");
    int tipo = Integer.parseInt(sc.nextLine());

    if (tipo == 1) {

    if (esp.equals("psicologia")) {
        profissionais.add(new Psicologo(nome, cpf));
    }
    else if (esp.equals("nutricao")) {
        profissionais.add(new Nutricionista(nome, cpf));
    }
    else if (esp.equals("fisioterapia")) {
        profissionais.add(new Fisioterapeuta(nome, cpf));
    }
    else {
        profissionais.add(new ClinicoGeral(nome, cpf));
    }
    }

    else if (tipo == 2) {

    System.out.print("Registro: ");
    String reg = sc.nextLine();
    System.out.print("Valor consulta: ");
    double valor = Double.parseDouble(sc.nextLine());

    if (esp.equals("psicologia")) {
        profissionais.add(new Psicologo(nome, cpf, reg, valor));
    }
    else if (esp.equals("nutricao")) {
        profissionais.add(new Nutricionista(nome, cpf, reg, valor));
    }
    else if (esp.equals("fisioterapia")) {
        profissionais.add(new Fisioterapeuta(nome, cpf, reg, valor));
    }
    else {
        profissionais.add(new ClinicoGeral(nome, cpf, reg, valor));
    }
    }

    else {
    System.out.print("Registro: ");
    String reg = sc.nextLine();
    System.out.print("Valor consulta: ");
    double valor = Double.parseDouble(sc.nextLine());
    System.out.print("Quantos dias atende? ");
    int qtd = Integer.parseInt(sc.nextLine());

    String[] dias = new String[7];

    for (int i = 0; i < qtd; i++) {
        System.out.print("Dia " + (i + 1) + ": ");
        dias[i] = sc.nextLine();
    }

    if (esp.equals("psicologia")) {
        profissionais.add(
            new Psicologo(nome, cpf, reg, valor, dias, qtd)
        );
    }
    else if (esp.equals("nutricao")) {
        profissionais.add(
            new Nutricionista(nome, cpf, reg, valor, dias, qtd)
        );
    }
    else if (esp.equals("fisioterapia")) {
        profissionais.add(
            new Fisioterapeuta(nome, cpf, reg, valor, dias, qtd)
        );
    }
    else {
        profissionais.add(
            new ClinicoGeral(nome, cpf, reg, valor, dias, qtd)
        );
    }
    }
    Profissional profissional = profissionais.get(profissionais.size() - 1);  
    
    if (profissional instanceof Fisioterapeuta) {
        System.out.print("Quantidade de sessões por paciente: ");
        int sessoes = Integer.parseInt(sc.nextLine());
        ((Fisioterapeuta) profissional).setQuantidadeSessoes(sessoes);
        System.out.println(profissional.exibirResumo());
    }
    if (profissional instanceof Psicologo) {
    System.out.print("Abordagem terapêutica: ");
    String abordagem = sc.nextLine();
    ((Psicologo) profissional).setAbordagemTerapeutica(abordagem);
    System.out.println(profissional.exibirResumo());
}
    System.out.println("Profissional cadastrado!");
}

    public static void atualizarProfissional() {
        System.out.print("Nome do profissional: ");
        String nome = sc.nextLine();
        Profissional profissional = buscarIndiceProfissional(nome);
        if (profissional == null) {
            System.out.println("Profissional nao encontrado.");
            return;
        }

        System.out.print("Vai informar dias? (1-Nao / 2-Sim): ");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Registro: ");
        String reg = sc.nextLine();
        System.out.print("Valor consulta: ");
        double valor = Double.parseDouble(sc.nextLine());

        if (tipo == 1) {
           profissional.atualizar(reg, valor);
        } else {
            System.out.print("Quantos dias? ");
            int qtd = Integer.parseInt(sc.nextLine());
            String[] dias = new String[7];
            for (int i = 0; i < qtd; i++) {
                System.out.print("Dia " + (i+1) + ": ");
                dias[i] = sc.nextLine();
            }
            profissional.atualizar(reg, valor, dias, qtd);
        }
        System.out.println("Profissional atualizado!");
    }

    public static void listarProfissionais() {
        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional cadastrado.");
            return;
        }
        for (int i = 0; i < profissionais.size(); i++) {
            System.out.println(profissionais.get(i).exibirResumo());
        }
    }

    public static void filtrarProfissionais() {
        System.out.print("Especialidade: ");
        String esp = sc.nextLine();
        boolean achou = false;
            for (int i = 0; i < profissionais.size(); i++) {
            if (profissionais.get(i).getEspecialidade().equals(esp)) {
                System.out.println(profissionais.get(i).exibirResumo());
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum profissional com essa especialidade.");
    }

    public static Profissional buscarIndiceProfissional(String nome) {

        for (Profissional profissional : profissionais) {
            if (profissional.getNome().equals(nome)) return profissional;
        }
        return null;
    }

    public static void agendarComProfissional() {
            
            System.out.print("CPF do paciente: ");
            String cpf = sc.nextLine();
            Paciente paciente = buscarIndicePaciente(cpf);

            if (paciente == null) {
                System.out.println("Paciente nao encontrado.");
                return;
            }
            if (!paciente.isAtivo()) {
                System.out.println("Paciente inativo. Agendamento não permitido.");
                return;
            }
            Profissional prof = null;

            System.out.print("Nome do profissional: ");
            String nomeProf = sc.nextLine();
            prof = buscarIndiceProfissional(nomeProf);
            if (prof == null) {
                System.out.println("Profissional nao encontrado.");
                return;
            }
            if (prof.getValorConsulta() == 0) {
                System.out.println("Profissional sem valor definido. Nao pode agendar.");
                return;
            }

            System.out.print("Data (DD/MM/AAAA): ");
            String data = sc.nextLine();
            System.out.print("Horario (HH:MM): ");
            String horario = sc.nextLine();

            // verifica dia da semana
            String diaSemana = descobrirDiaSemana(data);
            if (!prof.atendeNoDia(diaSemana)) {
                System.out.println("Profissional nao atende nesse dia.");
                return;
            }

            // verifica conflito
          try {
        if (temConflito(nomeProf, data, horario)) {
        throw new HorarioIndisponivelException("Horario ocupado!");
        }
        } catch (HorarioIndisponivelException e) {
            System.out.println(e.getMessage());
            String sugestao = sugerirHorario(nomeProf, data);
        if (sugestao.equals("")) {
            System.out.println("Nenhum horario disponivel nesse dia.");
        return;
        }

        System.out.println("Sugestao: " + sugestao);
        System.out.print("Aceita? (1-Sim / 2-Nao): ");
        int aceita = Integer.parseInt(sc.nextLine());

        if (aceita == 1) {
        horario = sugestao;
        } else {
        return;
        }
        }
            int infoTipo;
            

            do{
            System.out.print("Informar tipo? (1-Nao / 2-Sim): ");
            infoTipo= Integer.parseInt(sc.nextLine());

            if (infoTipo == 1) {

                
                consultas.add(new Consulta(cpf, nomeProf, data, horario));
            } else if(infoTipo == 2) {
                System.out.print("Tipo (inicial/retorno/avaliacao): ");
                String tipo = sc.nextLine();

                consultas.add(new Consulta(cpf, nomeProf, data, horario, tipo));

            }else{
                System.out.println("Opção invalida, TENTE NOVAMENTE!");
            }
        }while(infoTipo !=1 && infoTipo != 2);

            System.out.println("Consulta agendada com sucesso!");
            
            

        }

    public static void agendarPorEspecialidade() {
        
        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();
        Paciente paciente = buscarIndicePaciente(cpf);
        Profissional prof = null;
        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
            return;
        }
        if (!paciente.isAtivo()) {
            System.out.println("Paciente inativo. Agendamento não permitido.");
            return;
        }

        System.out.print("Especialidade: ");
        String esp = sc.nextLine();
        System.out.print("Data (DD/MM/AAAA): ");
        String data = sc.nextLine();
        System.out.print("Horario (HH:MM): ");
        String horario = sc.nextLine();

        String diaSemana = descobrirDiaSemana(data);

        // procura profissional disponivel
        for (Profissional profissional : profissionais) {
            if (profissional.getEspecialidade().equals(esp)
                    && profissional.getValorConsulta() > 0
                    && profissional.atendeNoDia(diaSemana)
                    && !temConflito(profissional.getNome(), data, horario)) {
                prof = profissional;
                break;
            }
        }

        if (prof == null) {
            System.out.println("Nenhum profissional disponivel.");
            return;
        }
        
        consultas.add(new Consulta(cpf, prof.getNome(), data, horario));
        System.out.println("Consulta agendada com " + prof.getNome() + "!");
    }

    public static void cancelarConsulta() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data (DD/MM/AAAA): ");
        String data = sc.nextLine();
        System.out.print("Horario (HH:MM): ");
        String horario = sc.nextLine();
        Consulta cons = null;
        // localiza a consulta
    
        for (Consulta consuta : consultas) {
            if (consuta.getCpfPaciente().equals(cpf) && consuta.getData().equals(data)
                    && consuta.getHorario().equals(horario)) {
                cons = consuta;
                break;
            }
        }
        
        if (cons == null) {
            System.out.println("Consulta agendada nao encontrada.");
            return;
        }
        if (cons.getStatus().equals("realizada")) {
            System.out.println("Consulta ja realizada. Nao pode cancelar.");
            return;
        }
        
        if (cons.getStatus().equals("cancelada")) {
            System.out.println("Consulta ja cancelada.");
            return;
        }

        // calculo da multa
        System.out.print("Horario atual (HH:MM): ");
        String horaAtual = sc.nextLine();

        int hConsulta = Integer.parseInt(horario.substring(0, 2));
        int hAgora = Integer.parseInt(horaAtual.substring(0, 2));
        int diff = hConsulta - hAgora;

        if (diff < 2) {
            System.out.println("Multa de R$50.00 aplicada!");
            cons.setMultas(50.0);
        
        }

        System.out.print("Informar motivo? (1-Nao / 2-Sim): ");
        int temMotivo = Integer.parseInt(sc.nextLine());

        if (temMotivo == 1) {
            cons.cancelar();
        } else {
            System.out.print("Motivo: ");
            String motivo = sc.nextLine();
            String msg = cons.cancelar(motivo);
            System.out.println(msg);
        }

        System.out.println("Consulta cancelada.");
    }

    public static void remarcarConsulta() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data original (DD/MM/AAAA): ");
        String dataOrig = sc.nextLine();
        System.out.print("Horario original (HH:MM): ");
        String horarioOrig = sc.nextLine();

        Consulta cons = null;

        for (Consulta consulta : consultas) {
            if (consulta.getCpfPaciente().equals(cpf) && consulta.getData().equals(dataOrig)
                    && consulta.getHorario().equals(horarioOrig)
                    && consulta.getStatus().equals("agendada")) {
                cons = consulta;
                break;
            }
        }
        
        if (cons == null) {
            System.out.println("Consulta agendada nao encontrada.");
            return;
        }
        
        String novaData;
        String novoHorario;
        String dia = null;
        int tipo;
        String nomeProf = cons.getNomeProfissional();
        Profissional profissional = buscarIndiceProfissional(nomeProf);
        
        do{
            System.out.print("Apenas trocar horario no mesmo dia? (1-Sim / 2-Nao): ");
            tipo = Integer.parseInt(sc.nextLine());

            if (tipo == 1) {
                novaData = dataOrig;
                System.out.print("Novo horario: ");
                novoHorario = sc.nextLine();

            } else if(tipo == 2) {
                System.out.print("Nova data (DD/MM/AAAA): ");
                novaData = sc.nextLine();
                System.out.print("Novo horario (HH:MM): ");
                novoHorario = sc.nextLine();

                dia = descobrirDiaSemana(novaData);
            }else{
                System.out.println("Tipo invalido! Remarcacao cancelada.");
                return;
            }

        }while (tipo!=1 && tipo!=2);

        if (!profissional.atendeNoDia(dia)) {
                System.out.println("Profissional nao atende nesse dia.");
                return;
            }
        
        if (temConflito(nomeProf, novaData, novoHorario)) {
            System.out.println("Horario ocupado. Nao foi possivel remarcar.");
            return;
        }

        cons.remarcar(cpf, nomeProf, novaData, novoHorario);
    
        System.out.println("Consulta remarcada com sucesso!");
    }

    public static void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta.");
            return;
        }
        for (Consulta consulta : consultas) {
            System.out.println(consulta.exibirResumo());
        }
        
    }

    public static void buscarConsultasPorPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        boolean achou = false;

        for (Consulta consulta : consultas) {
            if (consulta.getCpfPaciente().equals(cpf)) {
                System.out.println(consulta.exibirResumo());
                achou = true;
            }
        }

      
        if (!achou) System.out.println("Nenhuma consulta encontrada.");
    }

    // verifica se ja tem consulta nesse horario com esse profissional
    public static boolean temConflito(String nomeProf, String data, String horario) {
        
        for (Consulta consulta : consultas) {
            if (consulta.getNomeProfissional().equals(nomeProf)
                    && consulta.getData().equals(data)
                    && consulta.getHorario().equals(horario)
                    && consulta.getStatus().equals("agendada")) {
                return true;
            }
        }
        return false;
    }

    // sugere proximo horario livre (de hora em hora, 08h ate 18h)
    public static String sugerirHorario(String nomeProf, String data) {
        for (int h = 8; h <= 18; h++) {
            String teste;
            if (h < 10) {
                teste = "0" + h + ":00";
            } else {
                teste = h + ":00";
            }
            if (!temConflito(nomeProf, data, teste)) {
                return teste;
            }
        }
        return "";
    }

    // descobre dia da semana a partir da data
    // operação opcional
    public static String descobrirDiaSemana(String data) {
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));

        // ajuste pra formula funcionar com janeiro e fevereiro
        if (mes < 3) {
            mes = mes + 12;
            ano = ano - 1;
        }

        int k = ano % 100;
        int j = ano / 100;

        // formula de zeller
        int resultado = (dia + (13 * (mes + 1)) / 5 + k + k/4 + j/4 - 2*j) % 7;
        if (resultado < 0) resultado = resultado + 7;

        // 0=sabado, 1=domingo, 2=segunda...
        String[] nomes = {"sabado", "domingo", "segunda", "terca", "quarta", "quinta", "sexta"};
        //System.out.println("DEBUG dia semana: " + nomes[resultado]); // pra testar
        return nomes[resultado];
    }

    public static void registrarAtendimento() {

            System.out.print("Indice da consulta: ");
            int idxConsulta = Integer.parseInt(sc.nextLine());

            if (idxConsulta < 0 || idxConsulta >= consultas.size()) {
                System.out.println("Indice invalido.");
                return;
            }
            if (!consultas.get(idxConsulta).getStatus().equals("agendada")) {
                System.out.println("So pode registrar atendimento em consulta agendada.");
                return;
            }

            System.out.print("Observacoes: ");
            String obs = sc.nextLine();

            System.out.print("Tipo de registro (1-So obs / 2-Com diagnostico / 3-Completo): ");
            int tipo = Integer.parseInt(sc.nextLine());

            if (tipo == 1) {
                atendimentos.add(new Atendimento(idxConsulta, obs));

            } else if (tipo == 2) {
                System.out.print("Diagnostico: ");
                String diag = sc.nextLine();
                atendimentos.add(new Atendimento(idxConsulta, obs, diag));

            } else {
                System.out.print("Diagnostico: ");
                String diag = sc.nextLine();

                System.out.print("Como informar procedimentos? (1-Um por vez / 2-Todos de uma vez): ");
                int forma = Integer.parseInt(sc.nextLine());

                String[] procs = new String[10];
                int qtdProcs = 0;

                if (forma == 1) {
                    String proc = "";
                    while (!proc.equals("fim") && qtdProcs < 10) {
                        System.out.print("Procedimento (ou 'fim'): ");
                        proc = sc.nextLine();
                        if (!proc.equals("fim")) {
                            procs[qtdProcs] = proc;
                            qtdProcs++;
                        }
                    }
                } else {
                    System.out.print("Quantos? ");
                    qtdProcs = Integer.parseInt(sc.nextLine());
                    if (qtdProcs > 10) qtdProcs = 10;
                    for (int i = 0; i < qtdProcs; i++) {
                        System.out.print("Proc " + (i+1) + ": ");
                        procs[i] = sc.nextLine();
                    }
                }
                atendimentos.add(new Atendimento(idxConsulta, obs, diag, procs, qtdProcs));
            }

            consultas.get(idxConsulta).realizar();
            System.out.println("\n--- RESUMO ---");
            System.out.println(atendimentos.get(atendimentos.size() -1).exibirResumo());
            System.out.println("Consulta marcada como realizada.");
        }
    // paulo-victor1 - mudei aqui e na minha branch, n foi ajustada da forma q deveria
    public static void pagamentoDireto() {
        System.out.print("Indice da consulta: ");
        int idxConsulta = Integer.parseInt(sc.nextLine());

        // Validação simples para evitar indice invalido (eu mudei o if pq n tava compativel com ArrL)
        if (idxConsulta < 0 || idxConsulta >= consultas.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        // Lê o valor do pagamento
        System.out.print("Valor: ");
        double valor = Double.parseDouble(sc.nextLine());

        // Define o tipo de pagamento
        System.out.print("Tipo (dinheiro/cartao/convenio): ");
        String tipoPag = sc.nextLine();

        Pagamento pagamento = null;

        // se for cartao (add completo no commit)
        if (tipoPag.equals("cartao")) {

            System.out.print("Parcelas (1 a 3): ");
            int parc = Integer.parseInt(sc.nextLine());
            pagamento = new PagamentoCartao(idxConsulta, valor, tipoPag, parc);
            pagamentos.add(pagamento);

        } else if (tipoPag.equals("dinheiro")) {

            pagamento = new PagamentoDinheiro(idxConsulta, valor, tipoPag);
            pagamentos.add(pagamento);

        } else if (tipoPag.equals("convenio")) {

            System.out.print("Nome do convênio: ");
            String nomeConvenio = sc.nextLine();

            System.out.print("Percentual de desconto: ");
            double percentualDesconto = Double.parseDouble(sc.nextLine());

            pagamento = new PagamentoConvenio(idxConsulta, valor, tipoPag, nomeConvenio, percentualDesconto);

            pagamentos.add(pagamento);

        }
        System.out.println(pagamento.exibirResumo());
        System.out.println("Pagamento registrado!");

    }

   public static void pagamentoAutomatico() {

    System.out.print("Indice da consulta: ");
    int idxConsulta = Integer.parseInt(sc.nextLine());

    // validação ArrayList
    if (idxConsulta < 0 || idxConsulta >= consultas.size()) {
        System.out.println("Indice invalido.");
        return;
    }

    // pega consulta
    Consulta consulta = consultas.get(idxConsulta);

    String nomeProf = consulta.getNomeProfissional();
    int idxProf = buscarIndiceProfissional(nomeProf, profissionais);

    if (idxProf == -1) {
        System.out.println("Profissional não encontrado.");
        return;
    }

    double valorBase = profissionais.get(idxProf).getValorConsulta();

    // paciente
    String cpfPac = consulta.getCpfPaciente();
    int idxPac = buscarIndicePaciente(cpfPac, pacientes);

    if (idxPac == -1) {
        System.out.println("Paciente não encontrado.");
        return;
    }

    boolean temConvenio = !pacientes.get(idxPac).getConvenioNome().isEmpty();
    boolean ehRetorno = consulta.getTipo().equals("retorno");

    double desconto = 0;
    if (ehRetorno) desconto += 20;
    if (temConvenio) desconto += 40;

    double valorFinal = valorBase * (1 - desconto / 100.0);

    System.out.print("Tem multa pendente? (1-Nao / 2-Sim): ");
    int temMulta = Integer.parseInt(sc.nextLine());

    if (temMulta == 2) {
        System.out.print("Valor da multa: ");
        double multa = Double.parseDouble(sc.nextLine());
        valorFinal += multa;
    }

    System.out.print("Tipo (dinheiro/cartao/convenio): ");
    String tipoPag = sc.nextLine();

    if (tipoPag.equals("cartao")) {

        System.out.print("Parcelas (1 a 3): ");
        int parc = Integer.parseInt(sc.nextLine());

        pagamentos.add(new PagamentoCartao(idxConsulta, valorFinal, tipoPag, parc));

    } else if (tipoPag.equals("dinheiro")) {

        pagamentos.add(new PagamentoDinheiro(idxConsulta, valorFinal, tipoPag));

    } else if (tipoPag.equals("convenio")) {

        System.out.print("Nome do convênio: "); 
        String nomeConvenio = sc.nextLine();

        String especialidade = profissionais.get(idxProf).getEspecialidade();

    if (!convenioCobreEspecialidade(nomeConvenio, especialidade)) { // valida se o convênio cobre
        System.out.println("Convênio não cobre a especialidade " + especialidade + ".");
        System.out.println("Selecione outra forma de pagamento.");

        System.out.print("Nova forma (dinheiro/cartao): ");
        String novaForma = sc.nextLine();

    if (novaForma.equals("dinheiro")) {
        pagamentos.add(new PagamentoDinheiro(idxConsulta, valorFinal, novaForma));
    } else if (novaForma.equals("cartao")) {
        System.out.print("Parcelas (1 a 3): ");
        int parc = Integer.parseInt(sc.nextLine());
        pagamentos.add(new PagamentoCartao(idxConsulta, valorFinal, novaForma, parc));
    } else {
        System.out.println("Forma de pagamento invalida.");
        return;
    }
        } else {
        System.out.print("Percentual de desconto: ");
        double percentualDesconto = Double.parseDouble(sc.nextLine());

        pagamentos.add(new PagamentoConvenio(idxConsulta, valorFinal, tipoPag, nomeConvenio, percentualDesconto));
}

    }else{
        
        System.out.println("Tipo de pagamento invalido!");
        return;
    }

    System.out.println("Pagamento registrado com sucesso!");
}
    public static void listarPagamentos() {
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
            return;
        }
        for (int i = 0; i < pagamentos.size(); i++) {
            System.out.println(pagamentos.get(i).exibirResumo());
        }
    }
    //relatorio
    public static void gerarResumoFinanceiro() {
        Relatorio.gerarResumoFinanceiro(consultas, pagamentos);
    }
    public static void gerarRelatorioGeral() {
        Relatorio.gerarRelatorio(consultas, atendimentos);
    }

    public static void gerarRelatorioPorProfissional(String nome) {
        Relatorio.gerarRelatorio(consultas, atendimentos, nome);
    }   

    public static void gerarRelatorioPorPeriodo(String inicio, String fim) {
        Relatorio.gerarRelatorio(consultas, atendimentos, inicio, fim);
    }
    //movi do relatorio pra aqui.
    public static int buscarIndiceProfissional(String nome, List<Profissional> profissionais) {
    for (int i = 0; i < profissionais.size(); i++) {
        if (profissionais.get(i).getNome().equals(nome)) {
            return i;
        }
    }
    return -1;
    }
    //movi do relatoria pra acula
    public static int buscarIndicePaciente(String cpf, List<Paciente> pacientes) {
    for (int i = 0; i < pacientes.size(); i++) {
        if (pacientes.get(i).getCpf().equals(cpf)) {
            return i;
        }
    }
    return -1;
    }

    public static boolean convenioCobreEspecialidade(String nomeConvenio, String especialidade) {
    if (nomeConvenio.equals("Unimed")) {
        return especialidade.equals("clinica geral") || especialidade.equals("psicologia");
    }

    if (nomeConvenio.equals("Hapvida")) {
        return especialidade.equals("clinica geral") || especialidade.equals("fisioterapia");
    }

    if (nomeConvenio.equals("Bradesco")) {
        return especialidade.equals("clinica geral") || especialidade.equals("psicologia") || especialidade.equals("nutricao");
    }
    return false;
    }
}

