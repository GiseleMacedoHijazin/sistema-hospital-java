import java.util.ArrayList;
import java.util.Scanner;

class Paciente {

    private String nome;
    private String cpf;
    private int idade;
    private String telefone;

    public Paciente(String nome,
                     String cpf,
                     int idade,
                     String telefone) {

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    // SETTER
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // MOSTRAR DADOS
    public void mostrarDados() {

        System.out.println("\n===== PACIENTE =====");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + telefone);
    }
}

class Consulta {

    private Paciente paciente;
    private String data;
    private String horario;
    private String especialidade;
    private String medico;

    public Consulta(Paciente paciente,
                     String data,
                     String horario,
                     String especialidade,
                     String medico) {

        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
        this.especialidade = especialidade;
        this.medico = medico;
    }

    public String getCpfPaciente() {
        return paciente.getCpf();
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    // MOSTRAR CONSULTA
    public void mostrarConsulta() {

        System.out.println("\n===== CONSULTA =====");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Médico: " + medico);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
    }
}

class SistemaHospital {

    private ArrayList<Paciente> listaPacientes =
        new ArrayList<>();

    private ArrayList<Consulta> listaConsultas =
        new ArrayList<>();

    // VALIDAR CPF
    public boolean cpfValido(String cpf) {

        if (cpf.length() != 11) {
            return false;
        }

        for (int i = 0; i < cpf.length(); i++) {

            if (!Character.isDigit(cpf.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // VERIFICA SE TEM NÚMERO
    public boolean contemNumero(String texto) {

        for (int i = 0; i < texto.length(); i++) {

            if (Character.isDigit(texto.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    // VERIFICA SE TEM LETRA
    public boolean contemLetra(String texto) {

        for (int i = 0; i < texto.length(); i++) {

            if (Character.isLetter(texto.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    // CADASTRAR PACIENTE
    public void cadastrarPaciente(String nome,
                                  String cpf,
                                  int idade,
                                  String telefone) {

        // VALIDAR NOME
        if (contemNumero(nome)) {

            System.out.println(
                "O nome não pode conter números."
            );

            return;
        }

        // VALIDAR TELEFONE
        if (contemLetra(telefone)) {

            System.out.println(
                "O telefone não pode conter letras."
            );

            return;
        }

        // VALIDAR CPF
        if (!cpfValido(cpf)) {

            System.out.println(
                "CPF inválido. Digite exatamente 11 números."
            );

            return;
        }

        boolean cpfExiste = false;

        for (Paciente p : listaPacientes) {

            if (p.getCpf().equals(cpf)) {
                cpfExiste = true;
            }
        }

        if (cpfExiste) {

            System.out.println(
                "Já existe um paciente com este CPF."
            );

        } else {

            Paciente novoPaciente =
                new Paciente(
                    nome,
                    cpf,
                    idade,
                    telefone
                );

            listaPacientes.add(novoPaciente);

            System.out.println(
                "Paciente cadastrado com sucesso!"
            );
        }
    }

    // AGENDAR CONSULTA
    public void marcarConsulta(String cpf,
                               String data,
                               String horario,
                               String especialidade,
                               String medico) {

        boolean pacienteEncontrado = false;

        for (Paciente p : listaPacientes) {

            if (p.getCpf().equals(cpf)) {

                // VALIDAÇÃO
                if (contemNumero(especialidade)
                    || contemNumero(medico)) {

                    System.out.println(
                        "Especialidade e médico não podem conter números."
                    );

                } else {

                    Consulta novaConsulta =
                        new Consulta(
                            p,
                            data,
                            horario,
                            especialidade,
                            medico
                        );

                    listaConsultas.add(novaConsulta);

                    pacienteEncontrado = true;

                    System.out.println(
                        "Consulta marcada com sucesso!"
                    );
                }
            }
        }

        if (!pacienteEncontrado) {

            System.out.println(
                "Paciente não encontrado."
            );
        }
    }

    // LISTAR CONSULTAS
    public void listarConsultas(String cpf) {

        boolean encontrou = false;

        for (Consulta c : listaConsultas) {

            if (c.getCpfPaciente().equals(cpf)) {

                c.mostrarConsulta();
                encontrou = true;
            }
        }

        if (!encontrou) {

            System.out.println(
                "Nenhuma consulta encontrada."
            );
        }
    }

    // REMOVER PACIENTE
    public void removerPaciente(String cpf) {

        boolean removeu = false;

        for (int i = 0;
             i < listaPacientes.size();
             i++) {

            if (listaPacientes.get(i)
                .getCpf()
                .equals(cpf)) {

                listaPacientes.remove(i);

                removeu = true;
            }
        }

        // REMOVE CONSULTAS DO PACIENTE
        for (int i = 0;
             i < listaConsultas.size();
             i++) {

            if (listaConsultas.get(i)
                .getCpfPaciente()
                .equals(cpf)) {

                listaConsultas.remove(i);

                i--;
            }
        }

        if (removeu) {

            System.out.println(
                "Paciente removido com sucesso!"
            );

        } else {

            System.out.println(
                "Paciente não encontrado."
            );
        }
    }

    // CANCELAR CONSULTA
    public void cancelarConsulta(String cpf,
                                 String data,
                                 String horario) {

        boolean removeu = false;

        for (int i = 0;
             i < listaConsultas.size();
             i++) {

            Consulta c = listaConsultas.get(i);

            if (c.getCpfPaciente().equals(cpf)
                && c.getData().equals(data)
                && c.getHorario().equals(horario)) {

                listaConsultas.remove(i);

                removeu = true;
            }
        }

        if (removeu) {

            System.out.println(
                "Consulta cancelada com sucesso!"
            );

        } else {

            System.out.println(
                "Consulta não encontrada."
            );
        }
    }

    // ATUALIZAR TELEFONE
    public void atualizarTelefone(String cpf,
                                  String novoTelefone) {

        // VALIDAR TELEFONE
        if (contemLetra(novoTelefone)) {

            System.out.println(
                "O telefone não pode conter letras."
            );

            return;
        }

        boolean encontrou = false;

        for (Paciente p : listaPacientes) {

            if (p.getCpf().equals(cpf)) {

                p.setTelefone(novoTelefone);

                encontrou = true;

                System.out.println(
                    "Telefone atualizado com sucesso!"
                );
            }
        }

        if (!encontrou) {

            System.out.println(
                "Paciente não encontrado."
            );
        }
    }

    // LISTAR PACIENTES
    public void listarPacientes() {

        if (listaPacientes.isEmpty()) {

            System.out.println(
                "Nenhum paciente cadastrado."
            );

        } else {

            for (Paciente p : listaPacientes) {
                p.mostrarDados();
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
            new Scanner(System.in);

        SistemaHospital sistema =
            new SistemaHospital();

        // CADASTROS AUTOMÁTICOS

        sistema.cadastrarPaciente(
            "Lucas Martins",
            "11111111111",
            29,
            "99999-1111"
        );

        sistema.cadastrarPaciente(
            "Juliana Costa",
            "22222222222",
            34,
            "98888-2222"
        );

        sistema.marcarConsulta(
            "11111111111",
            "15/06/2026",
            "14:00",
            "Cardiologia",
            "Dr Roberto"
        );

        // MENU

        while (true) {

            System.out.println(
                "\n======= MENU ======="
            );

            System.out.println(
                "1 - Cadastrar paciente"
            );

            System.out.println(
                "2 - Agendar consulta"
            );

            System.out.println(
                "3 - Listar consultas"
            );

            System.out.println(
                "4 - Remover paciente"
            );

            System.out.println(
                "5 - Cancelar consulta"
            );

            System.out.println(
                "6 - Atualizar telefone"
            );

            System.out.println(
                "7 - Listar pacientes"
            );

            System.out.println(
                "8 - Sair"
            );

            System.out.print(
                "Escolha uma opção: "
            );

            int opcao =
                scanner.nextInt();

            scanner.nextLine();

            // CADASTRAR PACIENTE
            if (opcao == 1) {

                System.out.print("Nome: ");
                String nome =
                    scanner.nextLine();

                System.out.print("CPF: ");
                String cpf =
                    scanner.nextLine();

                System.out.print("Idade: ");
                int idade =
                    scanner.nextInt();

                scanner.nextLine();

                System.out.print("Telefone: ");
                String telefone =
                    scanner.nextLine();

                sistema.cadastrarPaciente(
                    nome,
                    cpf,
                    idade,
                    telefone
                );
            }

            // AGENDAR CONSULTA
            else if (opcao == 2) {

                System.out.print(
                    "CPF do paciente: "
                );

                String cpf =
                    scanner.nextLine();

                System.out.print("Data: ");
                String data =
                    scanner.nextLine();

                System.out.print("Horário: ");
                String horario =
                    scanner.nextLine();

                System.out.print(
                    "Especialidade: "
                );

                String especialidade =
                    scanner.nextLine();

                System.out.print("Médico: ");
                String medico =
                    scanner.nextLine();

                sistema.marcarConsulta(
                    cpf,
                    data,
                    horario,
                    especialidade,
                    medico
                );
            }

            // LISTAR CONSULTAS
            else if (opcao == 3) {

                System.out.print(
                    "CPF do paciente: "
                );

                String cpf =
                    scanner.nextLine();

                sistema.listarConsultas(cpf);
            }

            // REMOVER PACIENTE
            else if (opcao == 4) {

                System.out.print(
                    "CPF do paciente: "
                );

                String cpf =
                    scanner.nextLine();

                sistema.removerPaciente(cpf);
            }

            // CANCELAR CONSULTA
            else if (opcao == 5) {

                System.out.print(
                    "CPF do paciente: "
                );

                String cpf =
                    scanner.nextLine();

                System.out.print(
                    "Data da consulta: "
                );

                String data =
                    scanner.nextLine();

                System.out.print(
                    "Horário da consulta: "
                );

                String horario =
                    scanner.nextLine();

                sistema.cancelarConsulta(
                    cpf,
                    data,
                    horario
                );
            }

            // ATUALIZAR TELEFONE
            else if (opcao == 6) {

                System.out.print(
                    "CPF do paciente: "
                );

                String cpf =
                    scanner.nextLine();

                System.out.print(
                    "Novo telefone: "
                );

                String telefone =
                    scanner.nextLine();

                sistema.atualizarTelefone(
                    cpf,
                    telefone
                );
            }

            // LISTAR PACIENTES
            else if (opcao == 7) {

                sistema.listarPacientes();
            }

            // SAIR
            else if (opcao == 8) {

                System.out.println(
                    "Sistema encerrado."
                );

                break;
            }

            // OPÇÃO INVÁLIDA
            else {

                System.out.println(
                    "Opção inválida."
                );
            }
        }

        scanner.close();
    }
}