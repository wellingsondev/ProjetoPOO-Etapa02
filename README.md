Sistema de Gerenciamento de Clínica
Descritivo do Projeto
1. Descrição do Sistema

O Sistema de Gerenciamento de Clínica foi desenvolvido como atividade da disciplina de Programação Orientada a Objetos com o objetivo de simular as principais operações realizadas em uma clínica médica.

O sistema permite gerenciar pacientes, profissionais da saúde, consultas, atendimentos, pagamentos e relatórios, aplicando os conceitos de Programação Orientada a Objetos, como herança, polimorfismo, abstração, encapsulamento, interfaces, composição, associação e tratamento de exceções.

2. Funcionalidades Desenvolvidas
Cadastro de pacientes utilizando diferentes construtores.
Complementação dos dados do paciente.
Consulta de pacientes por CPF.
Listagem de pacientes cadastrados.
Desativação de pacientes.
Validação de CPF duplicado.
Cadastro de profissionais das especialidades:
Clínico Geral;
Psicólogo;
Nutricionista;
Fisioterapeuta.
Atualização dos dados dos profissionais.
Listagem dos profissionais cadastrados.
Agendamento de consultas.
Agendamento por especialidade.
Verificação de disponibilidade do profissional.
Verificação de conflito de horários.
Sugestão de novo horário disponível quando necessário.
Cancelamento de consultas.
Remarcação de consultas.
Registro de atendimentos.
Registro de observações, diagnóstico e procedimentos por meio do prontuário.
Processamento de pagamentos em dinheiro, cartão e convênio.
Aplicação de descontos e multas conforme as regras do sistema.
Emissão de relatórios financeiros.
Emissão de relatórios por profissional.
Emissão de relatórios por período.
Exportação de informações utilizando a interface Exportavel.
Tratamento de exceções personalizadas para operações inválidas.
3. Orientações para Compilação e Execução
Instale o Java JDK 17 ou versão superior.

Abra o projeto em uma IDE compatível com Java, como:

IntelliJ IDEA;
Eclipse;
NetBeans.

Ou utilize o terminal.

Compile todos os arquivos do projeto.

Caso utilize o terminal:

javac *.java

ou

javac src/*.java
Após a compilação, execute a classe principal:
java Main

Caso utilize uma IDE, basta abrir o projeto e executar a classe Main.java.

4. Descrição de Como Realizar as Operações do Sistema
4.1 Cadastro de Pacientes
Selecione a opção de cadastro no menu principal.
Informe os dados solicitados.
Escolha o tipo de cadastro.
Caso possua convênio, informe seus dados.
Confirme o cadastro.
4.2 Cadastro de Profissionais
Selecione a opção de cadastro de profissional.
Escolha a especialidade.
Informe os dados solicitados.
Defina o valor da consulta.
Informe os dias disponíveis para atendimento.
Confirme o cadastro.
4.3 Agendamento de Consultas
Selecione a opção de agendamento.
Informe o CPF do paciente.
Escolha o profissional ou a especialidade.
Informe a data e o horário desejados.
Caso exista conflito, o sistema informará e poderá sugerir outro horário.
Confirme o agendamento.
4.4 Cancelamento de Consultas
Selecione a opção de cancelamento.
Informe os dados da consulta.
Confirme a operação.
O sistema registrará o cancelamento e aplicará multa quando necessário.
4.5 Remarcação de Consultas
Selecione a opção de remarcação.
Informe os dados da consulta.
Informe a nova data e horário.
Confirme a operação.
4.6 Registro de Atendimento
Selecione a consulta realizada.
Informe as observações do atendimento.
Informe o diagnóstico, quando necessário.
Registre os procedimentos realizados.
O sistema armazenará as informações no prontuário do atendimento.
4.7 Registro de Pagamentos
Selecione a consulta.
Escolha a forma de pagamento.
Informe os dados necessários para a modalidade escolhida.
Confirme o pagamento.
4.8 Emissão de Relatórios
Selecione a opção de relatórios.
Escolha o tipo de relatório desejado.
O sistema exibirá as informações correspondentes.
