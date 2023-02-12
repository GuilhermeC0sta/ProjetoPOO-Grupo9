import java.util.*;

public class teste_conta { // 5, 6, 8, 9, 10
    public static void main(String[] args) {

        ArrayList<conta> inf = new ArrayList<>();
        ArrayList<livro> estante = new ArrayList<>();

        ArrayList<Integer> id_user = new ArrayList<>();
        ArrayList<Integer> isbn_locado = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String nome, email, senha, titulo, autor, controle;

        String nome_b = "biblioteca";
        String email_b = "biblioteca123@gmail.com";
        String senha_b = "admin";

        inf.add(new conta(email_b, senha_b, nome_b, 0));

        int isbn, qnt_disp, isbnlocar, k, isbndevolver;
        int op = 0, id = 1, j;
        int index_user = 0, tam;

        String log = "w";

        while (log == "w") {

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
                            System.out.println("Seja bem vindo " + inf.get(k).nome + "!");
                            log = "a";
                            index_user = k;
                            break;
                        } else {
                            while (!inf.get(k).senha.equals(senha)) {
                                System.out.println("Digite novamente sua senha");
                                senha = sc.nextLine();
                                if (inf.get(k).senha.equals(senha)) { // aqui está logado
                                    System.out.println("Logado!\n");
                                    System.out.println("Seja bem vindo " + inf.get(k).nome + "!");
                                    log = "a";
                                    index_user = k;
                                    break;
                                }
                            }
                        }
                    }

                    if (k == inf.size() - 1) {
                        System.out.println("Email não cadastrado");
                    }

                }
            }

            else {
                System.out.println("Digite seu nome:");
                nome = sc.nextLine();

                System.out.println("Digite o email:");
                email = sc.nextLine();

                System.out.println("Digite a senha:");
                senha = sc.nextLine();

                inf.add(new conta(email, senha, nome, id));
                id += 1;
            }
        }

        while (op != -1) {
            System.out.println(
                    "Digite 1 para editar perfil\nDigite 2 para adicionar um livro\nDigite 3 para verificar livros disponíveis\nDigite 4 para exibir todas as contas\nDigite 5 para locar um livro do acervo\nDigite 6 para remover um livro do acervo\nDigite 7 para devolver um livro\nDigite -1 para sair\n");
            op = sc.nextInt();

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
                    break;

                case 3:
                    for (int i = 0; i < estante.size(); i++) {
                        System.out.println("Titulo: " + estante.get(i).titulo + " - " + "Autor: " + estante.get(i).autor
                                + " Código ISBN: " + estante.get(i).isbn + " Quantidade disponível: "
                                + estante.get(i).qnt_disp);
                    }
                    break;

                case 4:
                    for (int i = 0; i < inf.size(); i++) {
                        System.out.println("Nome: " + inf.get(i).nome + " - " + "Email: " + inf.get(i).email);
                    }
                    break;

                case 5:
                    System.out.println("Digite o código ISBN do livro que deseja locar: ");
                    isbnlocar = sc.nextInt();
                    tam = estante.size();
                    for (k = 0; k < tam; k++) {
                        if (isbnlocar == estante.get(k).isbn) {
                            if (estante.get(k).qnt_disp == 0) {
                                System.out.println("Livro indisponível, Tente novamente em outro momento.");
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
                    System.out.println("Digite o código ISBN do livro que deseja remover do acervo: ");
                    isbnlocar = sc.nextInt();
                    tam = estante.size();
                    for (k = 0; k < tam; k++) {
                        if (isbnlocar == estante.get(k).isbn) {
                            estante.remove(k);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Livros locados: ");
                    for (k = 0; k < id_user.size(); k++) {
                        if (id_user.get(k) == index_user) {
                            System.out.println(isbn_locado.get(k));
                            System.out.println("Escolha o livro que deseja devolver de acordo com o ISBN: ");
                            isbndevolver = sc.nextInt();
                            isbn_locado.remove(k);
                            id_user.remove(k);

                            for (j = 0; j < estante.size(); j++) {
                                if (isbndevolver == estante.get(j).isbn) {
                                    if (estante.get(j).qnt_disp == 0) {
                                        System.out.println("Livro indisponível, Tente novamente em outro momento.");
                                        break;
                                    } else {
                                        estante.set(j,
                                                new livro(estante.get(j).titulo, estante.get(j).autor, isbndevolver,
                                                        estante.get(j).qnt_disp + 1));

                                        System.out
                                                .println(
                                                        "\nVocê conseguiu locar um livro! Devolva dentro de 10 dias.\n");

                                        id_user.add(index_user);
                                        isbn_locado.add(isbndevolver);
                                        break;
                                    }
                                }
                            }

                        }
                    }

            }
        }
    }
}
