import java.util.*;


public class teste_conta{
    
    public static void main(String[] args){
        
        ArrayList<conta> inf = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        String nome, email, senha;
        int op = 0, id = 0;

        while(op != -1){
        
        System.out.println("Digite 1 para criar uma conta\nDigite 2 para editar perfil\nDigite 3 para adicionar um livro\nDigite 4 para verificar livros disponíveis\nDigite -1 para sair\n");
        op = sc.nextInt();
        
        if(op == 1){

            System.out.println("Digite seu nome:");
            sc.nextLine();
            nome = sc.nextLine();

            System.out.println("Digite o email:");

            email = sc.nextLine();

            System.out.println("Digite a senha:");

            senha = sc.nextLine();

            inf.add(new conta(email, senha, nome, id));
            id += 1;
            
            for(int i = 0; i < inf.size(); i++){
                System.out.println("Nome: " + inf.get(i).nome + " - " + "Email: " + inf.get(i).email);
            }
        }

        else if(op == 2){
            
        }

        else if(op == 3){

        }

        else if(op == 4){

        }

    }

    }
}
