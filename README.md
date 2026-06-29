Sistema de Gerenciamento de Clínica
1. Descrição do Sistema
O Sistema de Gerenciamento de Clínica foi desenvolvido como atividade da disciplina de Programação Orientada a Objetos com o objetivo de simular as principais operações realizadas em uma clínica médica.

O sistema permite gerenciar pacientes, profissionais da saúde, consultas, atendimentos, pagamentos e relatórios, aplicando conceitos de Programação Orientada a Objetos, como herança, polimorfismo, abstração, encapsulamento, interfaces, composição, associação e tratamento de exceções.
2. Funcionalidades Desenvolvidas
    • Cadastro de pacientes utilizando diferentes construtores.
    • Complementação dos dados do paciente.
    • Consulta de pacientes por CPF.
    • Listagem de pacientes cadastrados.
    • Desativação de pacientes.
    • Validação de CPF duplicado.
    • Cadastro de profissionais das especialidades: Clínico Geral, Psicólogo, Nutricionista e Fisioterapeuta.
    • Atualização dos dados dos profissionais.
    • Listagem dos profissionais cadastrados.
    • Agendamento de consultas.
    • Agendamento por especialidade.
    • Verificação de disponibilidade do profissional.
    • Verificação de conflito de horários.
    • Sugestão de novo horário disponível quando necessário.
    • Cancelamento de consultas.
    • Remarcação de consultas.
    • Registro de atendimentos.
    • Registro de observações, diagnóstico e procedimentos por meio do prontuário.
    • Processamento de pagamentos em dinheiro, cartão e convênio.
    • Aplicação de descontos e multas conforme as regras do sistema.
    • Emissão de relatórios financeiros.
    • Emissão de relatórios por profissional.
    • Emissão de relatórios por período.
    • Exportação de informações utilizando a interface Exportavel.
    • Tratamento de exceções personalizadas para operações inválidas.
    
3. Orientações para Compilação e Execução

1. Instale o Java JDK 17 ou superior.
2. Abra o projeto em uma IDE compatível (IntelliJ IDEA, Eclipse ou NetBeans) ou utilize o terminal.
3. Compile todos os arquivos do projeto.

Comandos:

javac *(nomeDoArquivo).java
ou
javac src/*(nomeDoArquivo).java

4. Execute a classe principal:

java Main

Em uma IDE, basta executar a classe Main.java.
4. Descrição de Como Realizar as Operações do Sistema
4.1 Cadastro de Pacientes
    1. Selecione a opção de cadastro no menu principal.
    2. Informe os dados solicitados.
    3. Escolha o tipo de cadastro.
    4. Caso possua convênio, informe seus dados.
    5. Confirme o cadastro.
4.2 Cadastro de Profissionais
    6. Selecione a opção de cadastro de profissional.
    7. Escolha a especialidade.
    8. Informe os dados solicitados.
    9. Defina o valor da consulta.
    10. Informe os dias disponíveis para atendimento.
    11. Confirme o cadastro.
4.3 Agendamento de Consultas
    12. Selecione a opção de agendamento.
    13. Informe o CPF do paciente.
    14. Escolha o profissional ou a especialidade.
    15. Informe a data e o horário desejados.
    16. Caso exista conflito, o sistema informará e poderá sugerir outro horário.
    17. Confirme o agendamento.
4.4 Cancelamento de Consultas
    18. Selecione a opção de cancelamento.
    19. Informe os dados da consulta.
    20. Confirme a operação.
    21. O sistema registrará o cancelamento e aplicará multa quando necessário.
4.5 Remarcação de Consultas
    22. Selecione a opção de remarcação.
    23. Informe os dados da consulta.
    24. Informe a nova data e horário.
    25. Confirme a operação.
4.6 Registro de Atendimento
    26. Selecione a consulta realizada.
    27. Informe as observações do atendimento.
    28. Informe o diagnóstico, quando necessário.
    29. Registre os procedimentos realizados.
    30. O sistema armazenará as informações no prontuário do atendimento.
4.7 Registro de Pagamentos
    31. Selecione a consulta.
    32. Escolha a forma de pagamento.
    33. Informe os dados necessários para a modalidade escolhida.
    34. Confirme o pagamento.
4.8 Emissão de Relatórios
    35. Selecione a opção de relatórios.
    36. Escolha o tipo de relatório desejado.
    37. O sistema exibirá as informações correspondentes.
