package gerenciadortarefas;

    import java.util.ArrayList;
    import java.util.Scanner;

/**
 * @author Bruno Ullmann do Nascimento
 */
public class Principal {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<String> tarefa =new ArrayList<String> ();
    static ArrayList<String> tarefaConcluidas =new ArrayList<String> ();
        static boolean menu = true;
    public static void main(String[] args){
        
        
        
        while(menu){
            System.out.println("Selecione a opcao desejada: ");
            System.out.println("1- Adicionar tarefa");
            System.out.println("2- Concluir tarefa");
            System.out.println("3- Remover tarefa");
            System.out.println("4- Listar tarefas");
            System.out.println("5- Tarefas concluidas");
            System.out.println("6- sair");
            int opcao = teclado.nextInt();
            teclado.nextLine();
            
            switch(opcao){
                case 1:
                    try{
                        adicionarTarefa();
                    }catch(Exception e){
                        System.out.println("Erro " + e);
                    }finally{
                        break;
                    }
                    //fim caso 1
                case 2:
                    try{
                        listarTarefas();
                        System.out.print("Digite a tarefa a ser concluida: ");
                        int tarefaConcluir = teclado.nextInt();
                        if(tarefaConcluir < 0  || tarefaConcluir > tarefa.size() ){
                            System.out.println("Tarefa invalida");
                            break;
                        }else{
                            System.out.println("Voce deseja concluir a tarefa " + tarefa.get(tarefaConcluir) +  " 0/nao  1/sim");
                            int concluir = teclado.nextInt();
                            if(concluir == 1){
                                tarefaConcluidas.add(tarefa.get(tarefaConcluir));
                                tarefa.remove(tarefaConcluir);
                                break;
                            }else{
                                break;
                            }
                    }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    //fim caso 2
                case 3:
                    listarTarefas();
                    System.out.println("Digite a tarefa a ser concluida:");
                    int remove = teclado.nextInt();
                    
                    try{
                        tarefa.remove(tarefa.get(remove));
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    
                    System.out.println("Deseja voltar ao menu? 0/voltar ao menu  1/sair");
                    
                    try{
                        int voltar = teclado.nextInt();
                        if(voltar == 1){
                            menu = false; 
                        }else if(voltar != 0 && voltar != 1){
                            throw new Exception();
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                    //fim caso 3
                    
                case 4:
                    try{
                    listarTarefas();
                    System.out.println("Deseja voltar ao menu? 0/voltar ao menu  1/sair");
                    int volta = teclado.nextInt();
                    if(volta == 1){
                        menu = false; 
                    }else if(volta != 1 && volta != 0){
                        throw new Exception();
                    }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                    //fim caso 4
                    
                case 5:
                    tarefasConcluidas();
                    break;
                    //fim caso 5
                    
                case 6:
                    menu = false;
                    break;
                    //fim caso 6
                default:
                    System.out.println("Opcao invalida");
            }//fim switch
        }//fim while
        
    }
    
    //Método para adicionar uma nova tarefa
    public static void adicionarTarefa(){
        try{
            System.out.print("Digite a tarefa a ser adicionada: ");
                tarefa.add(teclado.nextLine());
                System.out.println("Tarefa adicionada com sucesso!");
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            System.out.println("Deseja outra tarefa ? 0/nao  1/sim");
                int maisTarefa = teclado.nextInt();
                teclado.nextLine();
                if(maisTarefa == 0){
                    System.out.println("Deseja voltar ao menu? 0/voltar ao menu  1/sair");
                    int voltar = teclado.nextInt();
                    if(voltar == 1){
                        menu = false; 
                    }
                }else if(maisTarefa == 1){
                    adicionarTarefa();
                }else{
                    throw new Exception();
                }
        }catch(Exception e){
            System.out.println("Opcao invalida!");
        }
                
                
        }
    
    
    //Método para listar as tarefas
    public static void listarTarefas(){
        System.out.println("Tarefas");
                    
        for(int indice = 0; indice < tarefa.size(); indice++){
            System.out.println((indice + 1) + "- " + tarefa.get(indice));
        }
    }
    
    public static void tarefasConcluidas(){
        System.out.println("Tarefas concluidas");
        for(int indice = 0; indice < tarefaConcluidas.size(); indice++){
            System.out.println((indice + 1) + "- " + tarefaConcluidas.get(indice));
        }
    }
    
    
    
    
}