import java.util.*;

public class libraric { // 5, 6, 8, 9, 10
    static void tab() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<conta> inf = new ArrayList<>();
        ArrayList<livro> estante = new ArrayList<>();

        ArrayList<Integer> id_user = new ArrayList<>();
        ArrayList<Integer> isbn_locado = new ArrayList<>();

        ArrayList<Integer> id_devolvido = new ArrayList<>();
        ArrayList<Integer> isbn_devolvido = new ArrayList<>();
        ArrayList<Integer> id_multa = new ArrayList<>();
        ArrayList<Integer> id_multapaga = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String nome, email, senha, titulo, autor, controle, dev;

        String nome_b = "biblioteca";
        String email_b = "biblioteca123@gmail.com";
        String senha_b = "admin";

        inf.add(new conta(email_b, senha_b, nome_b, 0));

        int isbn, qnt_disp, isbnlocar, k, isbndevolver;
        int op = 0, id = 1, j = 0;
        int index_user = 0, tam;

        String log = "n";
        while (op != -1) {
            while (log == "n") {

                System.out.println("Você possui uma conta ? S - para sim ou N para não");
                controle = sc.nextLine();

                if (controle.equalsIgnoreCase("S")) {
                    System.out.println("Informe o email");
                    email = sc.nextLine();
                    System.out.println("Informe a senha");
                    senha = sc.nextLine();

                    for (k = 0; k < inf.size(); k++) {
                        if (inf.get(k).email.equals(email)) { // ACHOU O EMAIL
                            if (inf.get(k).senha.equals(senha)) { // aqui está logado
                                System.out.println("Logado!\n");
                                System.out.println("Seja bem vindo " + inf.get(k).nome + "! Digite: ");
                                log = "s";
                                index_user = k;
                                break;
                            } else {
                                while (!inf.get(k).senha.equals(senha)) {
                                    System.out.println("Digite novamente sua senha");
                                    senha = sc.nextLine();
                                    if (inf.get(k).senha.equals(senha)) { // aqui está logado
                                        System.out.println("Logado!\n");
                                        System.out.println("Seja bem vindo " + inf.get(k).nome + "! Digite: ");
                                        log = "s";
                                        index_user = k;
                                        break;
                                    } else {
                                        System.out.println(
                                                "Se esqueceu sua senha, e deseja parar o processo de login, digite SAIR, caso contrário digite CONTINUAR!");
                                        senha = sc.nextLine();
                                        if (senha.equalsIgnoreCase("SAIR")) { // aqui está logado
                                            System.out.println("Você saiu da tentativa de login!\n");
                                            break;
                                        } else if (senha.equalsIgnoreCase("CONTINUAR")) { // aqui está logado
                                        } else {
                                            System.out.println("Opção inválida, encerrando processo de login...\n");
                                            System.out.println("Processo de Login encerrado!\n");
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        else if (k == inf.size() - 1) {
                            System.out.println("Email errado ou não cadastrado ou senha incorreta!\n");
                        }
                    }

                }

                else if (controle.equalsIgnoreCase("N")) {
                    System.out.println("Digite seu nome:");
                    nome = sc.nextLine();

                    System.out.println("Digite o email:");
                    email = sc.nextLine();

                    System.out.println("Digite a senha:");
                    senha = sc.nextLine();

                    inf.add(new conta(email, senha, nome, id));
                    id += 1;
                } else {
                    System.out.println("Opcao incorreta! Digite apenas S/s ou N/n");
                    System.out.println();
                }
            }

            while (log == "s") {
                System.out.println();
                System.out.println(
                        "[1] para editar perfil\n[2] (ADMIN) para adicionar um livro\n[3] para verificar livros disponíveis\n[4] (ADMIN) para exibir todas as contas\n[5] para locar um livro do acervo\n[6] (ADMIN) para remover um livro do acervo\n[7] para devolver um livro\n[8] para ver quais livros vc tem locados\n[9] para deslogar\n[10] para sair\n[11] (ADMIN) para ver quais livros foram devolvidos e por quem\n[12] para verificar multas\n[13] (ADMIN) para verificar multas pagas pelos usuários\n");
                op = sc.nextInt();
                tab();
                switch (op) {
                    case 1:
                        System.out.println("Digite o novo nome:");
                        sc.nextLine();
                        nome = sc.nextLine();
                        System.out.println("Digite o novo email:");
                        email = sc.nextLine();
                        inf.set(index_user, new conta(email, inf.get(index_user).senha, nome, id));
                        System.out.println("Nome e email alterados com sucesso!");
                        break;

                    case 2:

                        if (index_user == 0) {
                            System.out.println("Digite o titulo:");
                            sc.nextLine();
                            titulo = sc.nextLine();

                            System.out.println("Digite o autor:");

                            autor = sc.nextLine();

                            System.out.println("Digite o codigo ISBN:");
                            isbn = sc.nextInt();

                            System.out.println("Digite a quantidade disponíveis:");
                            qnt_disp = sc.nextInt();

                            estante.add(new livro(titulo, autor, isbn, qnt_disp));
                        } else {
                            System.out.println("Somente adminstradores podem usar esta função");
                        }
                        break;

                    case 3:
                        for (int i = 0; i < estante.size(); i++) {
                            System.out.println(
                                    "Titulo: " + estante.get(i).titulo + " - " + "Autor: " + estante.get(i).autor
                                            + " - "
                                            + " Código ISBN: " + estante.get(i).isbn + " - "
                                            + " Quantidade disponível: "
                                            + estante.get(i).qnt_disp);
                        }
                        break;

                    case 4:
                        if (index_user == 0) {
                            for (int i = 0; i < inf.size(); i++) {
                                System.out.println("Nome: " + inf.get(i).nome + " - " + "Email: " + inf.get(i).email);
                            }
                        } else {
                            System.out.println("Somente adminstradores podem usar esta função");
                        }
                        break;

                    case 5:
                        System.out.println("Digite o código ISBN do livro que deseja locar: ");
                        isbnlocar = sc.nextInt();
                        tam = estante.size();
                        for (k = 0; k < tam; k++) {
                            if (isbnlocar == estante.get(k).isbn) {
                                if (estante.get(k).qnt_disp == 0) {
                                    System.out.println("Livro indisponível, tente novamente em outro momento.");
                                    break;
                                } else {
                                    estante.set(k, new livro(estante.get(k).titulo, estante.get(k).autor, isbnlocar,
                                            estante.get(k).qnt_disp - 1));

                                    System.out
                                            .println("\nVocê conseguiu locar um livro! Devolva dentro de 10 dias.\n");

                                    id_user.add(index_user);
                                    isbn_locado.add(isbnlocar);
                                    break;
                                }
                            }
                        }
                        break; // 12/02/2023 b = 12; 20/02/2023 c = 20;

                    case 6:
                        if (index_user == 0) {
                            System.out.println("Digite o código ISBN do livro que deseja remover do acervo: ");
                            isbnlocar = sc.nextInt();
                            tam = estante.size();
                            for (k = 0; k < tam; k++) {
                                if (isbnlocar == estante.get(k).isbn) {
                                    estante.remove(k);
                                }
                            }
                        } else {
                            System.out.println("Somente adminstradores podem usar esta função");
                        }

                        break;

                    case 7:
                        if (id_user.size() == 0) {
                            System.out.println("*NÃO HÁ LIVRO LOCADOS*");
                            break;
                        } else {
                            System.out.println("Livros locados: ");
                        }
                        for (k = 0; k < id_user.size(); k++) {
                            if (id_user.get(k) == index_user) {
                                System.out.println(isbn_locado.get(k));
                            }
                        }
                        System.out.println("Escolha o livro que deseja devolver de acordo com o ISBN: ");
                        isbndevolver = sc.nextInt();
                        for (j = 0; j < id_user.size(); j++) {
                            if (id_user.get(j) == index_user) {
                                if (isbn_locado.get(j) == isbndevolver) {
                                    id_devolvido.add(j, index_user);
                                    isbn_devolvido.add(j, isbndevolver);
                                    id_user.remove(j);
                                    isbn_locado.remove(j);
                                    System.out.println("Livro " + isbndevolver + " devolvido! A Libraric agradece!\n");
                                    for (k = 0; k < estante.size(); k++) {
                                        if (isbndevolver == estante.get(k).isbn) {
                                            estante.set(k,
                                                    new livro(estante.get(k).titulo, estante.get(k).autor, isbndevolver,
                                                            estante.get(k).qnt_disp + 1));
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (j == id_user.size() - 1) {
                                System.out.println("Este livro não foi locado por você.");
                            }
                        }
                        break;

                    case 8:
                        if (id_user.size() == 0) {
                            System.out.println("*NÃO HÁ LIVRO LOCADOS*");
                            break;
                        } else {
                            System.out.println("Livros locados: ");
                        }
                        for (k = 0; k < id_user.size(); k++) {
                            if (id_user.get(k) == index_user) {
                                System.out.println(isbn_locado.get(k));
                            }
                        }
                        break;

                    case 9:
                        log = "n";
                        controle = "n";
                        System.out.println("Usuario deslogado!");
                        sc.nextLine();
                        break;

                    case 10:
                        op = -1;
                        log = "a";
                        break;

                    case 11:
                        if (index_user == 0) {
                            for (j = 0; j < id_devolvido.size(); j++) {
                                System.out.println("O usuario de id " + id_devolvido.get(j) + " devolveu o livro "
                                        + isbn_devolvido.get(j));
                                System.out.println("Se este livro foi devolvido digite S, caso contrario, digite N");
                                sc.nextLine();
                                dev = sc.nextLine();
                                if (dev.equalsIgnoreCase("S")) {
                                    id_devolvido.remove(j);
                                    isbn_devolvido.remove(j);
                                } else if (dev.equalsIgnoreCase("N")) {
                                    System.out.println(
                                            "Aplicar multa? digite S para aplicar multa caso tenha passado o prazo, digite N, caso nao tenha passado o prazo");
                                    String multinha = sc.nextLine();
                                    if (multinha.equalsIgnoreCase("S")) {
                                        System.out.println("MULTA APLICADA!");
                                        id_multa.add(id_devolvido.get(j));
                                    } else if (multinha.equalsIgnoreCase("N")) {
                                        System.out.println("MULTA NÃO APLICADA!");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Somente adminstradores podem usar esta função");
                        }
                        break;

                    case 12:
                        for (j = 0; j < id_multa.size(); j++) {
                            if (id_multa.get(j) == index_user) {
                                System.out.println(
                                        "Você possui uma multa não paga! Realize o pagamento dentro do prazo ou então será aplicado juros à multa!");
                                System.out.println(
                                        "Deseja pagá-la agora? se SIM digite S, caso contrário, digite outra N");
                                sc.nextLine();
                                String resp = sc.nextLine();
                                if (resp.equalsIgnoreCase("S")) {
                                    System.out.println("Dirija-se para o caixa para realizar o pagamento!");
                                    id_multapaga.add(index_user);
                                } else if (resp.equalsIgnoreCase("N")) {
                                    System.out.println(
                                            "Realize o pagamento dentro do prazo ou então será aplicado juros à multa!");
                                    break;
                                }
                            }
                        }
                        break;

                    case 13:
                        if (index_user == 0) {
                            for (j = 0; j < id_multapaga.size(); j++) {
                                System.out.println(
                                        "O usuário de id " + id_multapaga.get(j) + " pagou a multa, confirma?");
                                sc.nextLine();
                                String resposta = sc.nextLine();
                                if (resposta.equalsIgnoreCase("S")) {
                                    System.out.println("Confirmado que o usuário de id " + id_multapaga.get(j)
                                            + " pagou a multa!");
                                    id_multapaga.remove(j);
                                    id_devolvido.remove(j);
                                    id_multa.remove(j);
                                }
                            }
                        } else {
                            System.out.println("Somente adminstradores podem usar esta função");
                        }
                        break;

                    default:
                        System.out.println("Opcao incorreta!");

                }
            }
        }
    }
}
