import java.util.*;


public class teste_conta{
    
    public static void main(String[] args){
        
        ArrayList<conta> inf = new ArrayList<>();
        ArrayList<livro> estante = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String nome, email, senha, titulo, autor;
        int isbn, qnt_disp;
        int op = 0, id = 0;

        String log = "w";
        

        while(op != -1){

        System.out.println("Digite 1 para criar uma conta\nDigite 2 para editar perfil\nDigite 3 para adicionar um livro\nDigite 4 para verificar livros disponíveis\nDigite 5 para exibir todas as contas\nDigite -1 para sair\n");
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
            
        }

        else if(op == 2){

            System.out.println("Digite o código do usuário que deseja mudar");
            for(int i = 0; i < inf.size(); i++){
                System.out.println("ID: " + inf.get(i).id + " - Nome: " + inf.get(i).nome + " - " + " - Email: " + inf.get(i).email);
            }
            
            id = sc.nextInt();
            
            for(int j = 0; j < inf.size(); j++){
                if(inf.get(j).id == id){
                    System.out.println("Digite o novo nome:");
                    sc.nextLine();
                    nome = sc.nextLine();
                    System.out.println("Digite o novo email:");

                    email = sc.nextLine();
                    inf.set(j,new conta(email, inf.get(j).senha ,nome, id));
                    System.out.println("Nome e email alterados com sucesso!");
                }
            }
            
        }

        else if(op == 3){

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

        }

        else if(op == 4){
            
            for(int i = 0; i < estante.size(); i++){
                System.out.println("Titulo: " + estante.get(i).titulo + " - " + "Autor: " + estante.get(i).autor);
            }
        }

        else if(op == 5){
            for(int i = 0; i < inf.size(); i++){
                System.out.println("Nome: " + inf.get(i).nome + " - " + "Email: " + inf.get(i).email);
            }
        }

    }

    }
}
