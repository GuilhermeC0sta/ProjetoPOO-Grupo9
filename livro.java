import java.util.*;

//Função que registra um livro novo/retira um livro da biblioteca
public class livro {

    static ArrayList<livro> estante = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static String titulo;
    public static String autor;
    public static int isbn;
    public static int qnt_disp;

    public livro(String titulo, String autor, int isbn, int qnt_disp) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.qnt_disp = qnt_disp;

    }

    static void add_livro() {
        System.out.println("Digite o titulo:");
        titulo = sc.nextLine();

        System.out.println("Digite o autor:");

        autor = sc.nextLine();

        System.out.println("Digite o codigo ISBN:");
        isbn = sc.nextInt();

        System.out.println("Digite a quantidade disponíveis:");
        qnt_disp = sc.nextInt();

        estante.add(new livro(titulo, autor, isbn, qnt_disp));
    }

}
