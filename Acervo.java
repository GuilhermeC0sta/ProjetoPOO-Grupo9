import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Acervo{ //ADICIONAR ou REMOVER livros do acervo;
    ArrayList<livro> estante = new ArrayList<>();

    public void addLivro (livro lll){
        estante.add(lll);
    }

    public void remlivro(livro lll){
        estante.remove(lll);
    }

    public void checklivro(livro lll){
        int index = estante.indexOf(lll);
        livro livroverificando;
        livroverificando = estante.get(index);
        if(livroverificando.qnt_disp > 0){
            System.out.println("Há" +livroverificando.qnt_disp +"cópias disponíveis deste livro no acervo.");
        }
        else{
            System.out.println("Não há cópias disponíveis deste livro no acervo.");
        }
    }
}