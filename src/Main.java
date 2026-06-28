    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {
        
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            int opcao = -1;
            while (opcao != 0) {
                System.out.println("\n=== CLINICA VIDAPLENA ===");
                System.out.println("1 - Pacientes");
                System.out.println("2 - Profissionais");
                System.out.println("3 - Consultas");
                System.out.println("4 - Atendimentos");
                System.out.println("5 - Pagamentos");
                System.out.println("6 - Relatorios");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1: menuPacientes(); break;
                    case 2: menuProfissionais(); break;
                    case 3: menuConsultas(); break;
                    case 4: menuAtendimentos(); break;
                    case 5: menuPagamentos(); break;
                    case 6: menuRelatorios(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
            }
            System.out.println("Sistema encerrado.");
        }

        // ---- PACIENTES ----

        public static void menuPacientes() {
            int op = -1;
            while (op != 0) {
                System.out.println("\n--- PACIENTES ---");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Complementar cadastro");
                System.out.println("3 - Buscar por CPF");
                System.out.println("4 - Listar todos");
                System.out.println("5 - Desativar");
                System.out.println("6 - Busca rapida por CPF (hashmap)");
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: ClinicaServico.cadastrarPaciente(); break;
                    case 2: ClinicaServico.complementarPaciente(); break;
                    case 3: ClinicaServico.buscarPaciente(); break;
                    case 4: ClinicaServico.listarPacientes(); break;
                    case 5: ClinicaServico.desativarPaciente(); break;
                    case 6: buscaRapidaPaciente(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
            }
        }

        public static void buscaRapidaPaciente() {
            PacienteServico pacienteServico = new PacienteServico();
            for (Paciente p : ClinicaServico.getPacientes()) {
                try {
                    pacienteServico.cadastrar(p);
                } catch (CpfDuplicadoException e) {
                    System.out.println("aviso ao indexar: " + e.getMessage());
                }
            }
            System.out.print("CPF: ");
            String cpf = sc.nextLine();
            try {
                Paciente paciente = pacienteServico.buscarPorCpf(cpf);
                System.out.println(paciente.exibirResumo());
            } catch (PacienteNaoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        }

        

        // ---- PROFISSIONAIS ----

        public static void menuProfissionais() {
            int op = -1;
            while (op != 0) {
                System.out.println("\n--- PROFISSIONAIS ---");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Atualizar cadastro");
                System.out.println("3 - Listar todos");
                System.out.println("4 - Filtrar por especialidade");
                System.out.println("5 - Transferir dias disponiveis entre profissionais");
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: ClinicaServico.cadastrarProfissional(); break;
                    case 2: ClinicaServico.atualizarProfissional(); break;
                    case 3: ClinicaServico.listarProfissionais(); break;
                    case 4: ClinicaServico.filtrarProfissionais(); break;
                    case 5: transferirDiasProfissionais(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
            }
        }

        public static void transferirDiasProfissionais() {
            System.out.print("Nome do profissional que vai sair: ");
            String nomeAntigo = sc.nextLine();
            Profissional antigo = ClinicaServico.buscarIndiceProfissional(nomeAntigo);

            System.out.print("Nome do profissional que vai receber os dias: ");
            String nomeNovo = sc.nextLine();
            Profissional novo = ClinicaServico.buscarIndiceProfissional(nomeNovo);

            if (antigo == null || novo == null) {
                System.out.println("Um dos profissionais nao foi encontrado.");
                return;
            }

            HorarioServico horarioServico = new HorarioServico();
            try {
                horarioServico.transferirDias(antigo, novo);
                System.out.println(novo.exibirResumo());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        
        // ---- CONSULTAS ----

        public static void menuConsultas() {
            int op = -1;
            while (op != 0) {
                System.out.println("\n--- CONSULTAS ---");
                System.out.println("1 - Agendar (escolher profissional)");
                System.out.println("2 - Agendar (busca por especialidade)");
                System.out.println("3 - Cancelar");
                System.out.println("4 - Remarcar");
                System.out.println("5 - Listar todas");
                System.out.println("6 - Buscar por CPF");
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: ClinicaServico.agendarComProfissional(); break;
                    case 2: ClinicaServico.agendarPorEspecialidade(); break;
                    case 3: ClinicaServico.cancelarConsulta(); break;
                    case 4: ClinicaServico.remarcarConsulta(); break;
                    case 5: ClinicaServico.listarConsultas(); break;
                    case 6: ClinicaServico.buscarConsultasPorPaciente(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
            }
        }

       

        // ---- PAGAMENTOS ----

        public static void menuPagamentos() {
            int op = -1;
            while (op != 0) {
                System.out.println("\n--- PAGAMENTOS ---");
                System.out.println("1 - Pagamento direto");
                System.out.println("2 - Pagamento automatico");
                System.out.println("3 - Listar pagamentos");
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: ClinicaServico.pagamentoDireto(); break;
                    case 2: ClinicaServico.pagamentoAutomatico(); break;
                    case 3: ClinicaServico.listarPagamentos(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
            }
        }

           // ---- ATENDIMENTOS ----

        public static void menuAtendimentos() {
            int op = -1;
            while (op != 0) {
                System.out.println("\n--- ATENDIMENTOS ---");
                System.out.println("1 - Registrar atendimento");
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                if (op == 1) ClinicaServico.registrarAtendimento();
            }
    }

        // ---- RELATORIOS ----

        public static void menuRelatorios() {
            int op = -1;
            while (op != 0) {
                System.out.println("\n--- RELATORIOS ---");
                System.out.println("1 - Geral");
                System.out.println("2 - Por profissional");
                System.out.println("3 - Por periodo");
                System.out.println("4 - Resumo financeiro");
                System.out.println("5 - Exportar dados (atendimentos e pagamentos)");
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1:
                        ClinicaServico.gerarRelatorioUnificado();
                        break;
                    case 2:
                        System.out.print("Nome do profissional: ");
                        String nome = sc.nextLine();
                        ClinicaServico.gerarRelatorioPorProfissional(nome);
                        break;
                    case 3:
                        System.out.print("Data inicio (DD/MM/AAAA): ");
                        String ini = sc.nextLine();
                        System.out.print("Data fim (DD/MM/AAAA): ");
                        String fim = sc.nextLine();
                        ClinicaServico.gerarRelatorioPorPeriodo(ini, fim);
                        break;
                    case 4:
                        ClinicaServico.gerarResumoFinanceiro();
                        break;
                    case 5:
                        exportarDadosConsolidados();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                        break;
                }
            }
        }

        public static void exportarDadosConsolidados() {
            ExportacaoServico exportacaoServico = new ExportacaoServico();
            List<Exportavel> itens = new ArrayList<>();
            itens.addAll(ClinicaServico.getAtendimentos());
            itens.addAll(ClinicaServico.getPagamentos());
            exportacaoServico.exportarTudo(itens);
        }
    }
