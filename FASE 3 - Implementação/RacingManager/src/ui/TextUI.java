package ui;
import business.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextUI {
    // O model tem a 'lógica de negócio'.
    private ISimularFacade model;

    // Menus da aplicação
    private Menu menu;

    // Scanner para leitura
    private Scanner scin;

    /**
     * Construtor.
     *
     * Cria os menus e a camada de negócio.
     */
    public TextUI() {
        // Criar o menu
        //METER AQUI O QUE SE DEVIA FAZER
        /*
        this.menu = new Menu(new String[]{
                "Adicionar Aluno",
                "Consultar Aluno",
                "Listar Alunos",
                "Adicionar Turma",
                "Mudar Sala à Turma",
                "Listar Turmas",
                "Adicionar Aluno a Turma",
                "Remover Aluno da Turma",
                "Listar Alunos de Turma",
                "Adicionar Sala",
                "Consultar Sala",
                "Listar Salas"
        });
        this.menu.setHandler(1, this::trataAdicionarAluno);
        this.menu.setHandler(2, this::trataConsultarAluno);
        this.menu.setHandler(3, this::trataListarAlunos);
        this.menu.setHandler(4, this::trataAdicionarTurma);
        this.menu.setHandler(5, this::trataMudarSalaTurma);
        this.menu.setHandler(6, this::trataListarTurmas);
        this.menu.setHandler(7, this::trataAdicionarAlunoATurma);
        this.menu.setHandler(8, this::trataRemoverAlunoDaTurma);
        this.menu.setHandler(9, this::trataListarAlunosTurma);
        this.menu.setHandler(10, this::trataAdicionarSala);
        this.menu.setHandler(11, this::trataConsultarSala);
        this.menu.setHandler(12, this::trataListarSalas);

        this.model = new TurmasFacade();
        scin = new Scanner(System.in);

         */
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    public void run() {
        this.menu.run();
        System.out.println("Até breve!...");
    }

    // Métodos auxiliares
    private void trataAdicionarAluno() {
        /*
        try {
            System.out.println("Número da novo aluno: ");
            String num = scin.nextLine();
            if (!this.model.existeAluno(num)) {
                System.out.println("Nome da novo aluno: ");
                String nome = scin.nextLine();
                System.out.println("Email da novo aluno: ");
                String email = scin.nextLine();
                this.model.adicionaAluno(new Aluno(num, nome, email));
                System.out.println("Aluno adicionado");
            } else {
                System.out.println("Esse número de aluno já existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataConsultarAluno() {
        try {
            System.out.println("Número a consultar: ");
            String num = scin.nextLine();
            if (this.model.existeAluno(num)) {
                System.out.println(this.model.procuraAluno(num).toString());
            } else {
                System.out.println("Esse número de aluno não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataListarAlunos() {
        //Scanner scin = new Scanner(System.in);
        try {
            System.out.println(this.model.getAlunos().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataAdicionarTurma() {
        //Scanner scin = new Scanner(System.in);
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            if (!this.model.existeTurma(tid)) {
                System.out.println("Sala: ");
                String sala = scin.nextLine();
                System.out.println("Edifício: ");
                String edif = scin.nextLine();
                System.out.println("Capacidade: ");
                int cap = scin.nextInt();
                scin.nextLine();    // Limpar o buffer depois de ler o inteiro
                this.model.adicionaTurma(new Turma(tid, new Sala(sala, edif, cap)));
                System.out.println("Turma adicionada");
            } else {
                System.out.println("Esse número de turma já existe!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataMudarSalaTurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            if (this.model.existeTurma(tid)) {
                System.out.println("Sala: ");
                String sala = scin.nextLine();
                System.out.println("Edifício: ");
                String edif = scin.nextLine();
                System.out.println("Capacidade: ");
                int cap = scin.nextInt();
                scin.nextLine();    // Limpar o buffer depois de ler o inteiro
                this.model.alteraSalaDeTurma(tid, new Sala(sala, edif, cap));
                System.out.println("Sala da turma alterada");
            } else {
                System.out.println("Esse número de turma não existe!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataListarTurmas() {
        try {
            System.out.println(this.model.getTurmas().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataAdicionarAlunoATurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            if (this.model.existeTurma(tid)) {
                System.out.println("Número do aluno: ");
                String num = scin.nextLine();
                if (this.model.existeAluno(num)) {
                    this.model.adicionaAlunoTurma(tid, num);
                    System.out.println("Aluno adicionado à turma");
                } else {
                    System.out.println("Esse número de aluno não existe!");
                }
            } else {
                System.out.println("Esse número de turma não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataRemoverAlunoDaTurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            if (this.model.existeTurma(tid)) {
                System.out.println("Número do aluno: ");
                String num = scin.nextLine();
                if (this.model.existeAlunoEmTurma(tid,num)) {
                    this.model.removeAlunoTurma(tid, num);
                    System.out.println("Aluno removido da turma");
                } else {
                    System.out.println("Esse número de aluno não existe na turma!");
                }
            } else {
                System.out.println("Esse número de turma não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataListarAlunosTurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            List<Aluno> als = this.model.getAlunos(tid).stream()
                    .map((na)->this.model.procuraAluno(na))
                    .collect(Collectors.toList());
            System.out.println(als);
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    private void trataAdicionarSala(){
        try {
            System.out.println("Número da nova sala: ");
            String num = scin.nextLine();
            if (!this.model.existeSala(num)) {
                System.out.println("Nome do Edificio: ");
                String edificio = scin.nextLine();
                System.out.println("Capacidade da Sala: ");
                int capacidade = scin.nextInt();
                this.model.adicionaSala(new Sala(num, edificio, capacidade));
                System.out.println("Sala adicionada");
            } else {
                System.out.println("Esse número de sala já existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    private void trataConsultarSala(){
        try {
            System.out.println("Número a consultar: ");
            String num = scin.nextLine();
            if (this.model.existeSala(num)) {
                System.out.println(this.model.procuraSala(num).toString());
            } else {
                System.out.println("Esse número de sala não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    private void trataListarSalas(){
        try {
            System.out.println(this.model.getSalas().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        */
    }

}