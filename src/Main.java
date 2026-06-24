    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {

        //Agora e uma arraylist, e n um array (commit antigo mas recolocado, pois dei commit em outro repositorio)
        static ArrayList<Pagamento> pagamentos = new ArrayList<>();
        
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
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: ClinicaServico.cadastrarPaciente(); break;
                    case 2: ClinicaServico.complementarPaciente(); break;
                    case 3: ClinicaServico.buscarPaciente(); break;
                    case 4: ClinicaServico.listarPacientes(); break;
                    case 5: ClinicaServico.desativarPaciente(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
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
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: ClinicaServico.cadastrarProfissional(); break;
                    case 2: ClinicaServico.atualizarProfissional(); break;
                    case 3: ClinicaServico.listarProfissionais(); break;
                    case 4: ClinicaServico.filtrarProfissionais(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
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
        //PRIMEIRA FUNCAO DO pagamentoDireto()
    public static void pagamentoDireto() {
        System.out.print("Indice da consulta: ");
        int idxConsulta = Integer.parseInt(sc.nextLine());

        // Validação simples para evitar indice invalido
        if (idxConsulta < 0 || idxConsulta >= totalConsultas) {
            System.out.println("Indice invalido.");
            return;
        }

        // Lê o valor do pagamento
        System.out.print("Valor: ");
        double valor = Double.parseDouble(sc.nextLine());

        // Define o tipo de pagamento
        System.out.print("Tipo (dinheiro/cartao/convenio): ");
        String tipoPag = sc.nextLine();

        Pagamento pagamento;

        //se for cartao
        // if (tipoPag.equals("cartao")) vou add no prox commit

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
                System.out.println("0 - Voltar");
                System.out.print("Opcao: ");
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1:
                        Relatorio.gerarRelatorio(consultas, totalConsultas, atendimentos, totalAtendimentos);
                        break;
                    case 2:
                        System.out.print("Nome do profissional: ");
                        String nome = sc.nextLine();
                        Relatorio.gerarRelatorio(consultas, totalConsultas, atendimentos, totalAtendimentos, nome);
                        break;
                    case 3:
                        System.out.print("Data inicio (DD/MM/AAAA): ");
                        String ini = sc.nextLine();
                        System.out.print("Data fim (DD/MM/AAAA): ");
                        String fim = sc.nextLine();
                        Relatorio.gerarRelatorio(consultas, totalConsultas, atendimentos, totalAtendimentos, ini, fim);
                        break;
                    case 4:
                        Relatorio.gerarResumoFinanceiro(consultas, totalConsultas, pagamentos, totalPagamentos, multas, totalMultas);
                        break;
                    case 0: break;
                    default: System.out.println("Opcao invalida!"); break;
                }
            }
        }
    }
