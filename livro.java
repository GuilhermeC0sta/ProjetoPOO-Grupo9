import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//Função que registra um livro novo/retira um livro da biblioteca
public class livro {
    private String titulo;
    private String autor;
    private int isbn;
    private int qnt_disp;

    Scanner entrada = new Scanner(System.in);

    public livro(){
        System.out.println("Insira o código isbn do livro: ");
        this.isbn = entrada.nextInt();
        System.out.println("Insira o título do livro: ");
        this.titulo = entrada.nextLine();
        System.out.println("Insira o autor do livro: ");
        this.autor = entrada.nextLine();
        System.out.println("Insira a quantidade disponível de cópias do livro no acervo: ");
        this.qnt_disp = entrada.nextInt();
    }

}
