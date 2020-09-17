package segundoPeriodo.Exame;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class AppExame {

    static List <Exame> listaExames = new ArrayList<Exame>();
    static Scanner sc = new Scanner(System.in);
    static byte opcao;
    static int codExame;
    static  boolean infValida = false;
    static int newCodExame;

    public static void main(String[] args) {

        do {
            System.out.println("\nOpção: \n*** 1 - Cadastrar Exame\n*** 2 - Listar Exame" +
                    "\n*** 3 - Consultar Exame\n*** 4 - Excluir Exame " +
                    "\n*** 5 - Sair  ");
            System.out.print("Entre com a opção: ");
            opcao = sc.nextByte();

            switch (opcao){
                case 1:
                    cadastrarExame();
                    break;
                case 2:
                    listarExames();
                    break;
                case 3:
                    consultarExame();
                    break;
                case 4:
                    excluirExame();
                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
    }

    public static void cadastrarExame(){

        do {
            try {
                System.out.print("Informe o Código: ");
                codExame = sc.nextInt();
                if (codExame > 0) {
                    infValida = true;
                } else {
                    System.out.println("Digite um valor maior que [0] ZERO!");
                    continue;
                }
            } catch (Exception e){
                System.out.println("Digite apenas Números");
                sc.next();
                continue;
            }
        } while (!infValida);
        if (listaExames.size() == codExame){
            System.out.println("Cod. já cadastrado!");
            return;
        }
        sc.nextLine();
        System.out.print("Tipo de Exame: ");
        String tipoExame = sc.nextLine();
        System.out.print("Nível de Glicose: ");
        int nivelGlicosa = sc.nextInt();
        Exame exame = new Exame(codExame, tipoExame, nivelGlicosa);
        listaExames.add(exame);
    }

    public static void listarExames(){
        if (listaExames.size() == 0){
            System.out.println("Sem Exames Cadastrados!");
            return;
        }
        for (Exame exame: listaExames) {
            System.out.printf("\n %d - %s - %d - %s",exame.getIdExame(), exame.getTipoExame(), exame.getNivelGlicose(),exame.obterDiagnostico());
        }
    }

    public static void consultarExame(){
        if (listaExames.size() == 0){
            System.out.println("Sem Exames Cadastrados");
            return;
        }

        System.out.print("Informe Código: ");
        int codExame = sc.nextInt();
        for (Exame exame: listaExames) {
            if (exame.getIdExame() == codExame){
                System.out.printf("\n %d - %s - %d - %s",exame.getIdExame(), exame.getTipoExame(), exame.getNivelGlicose(),exame.obterDiagnostico());
                infValida = true;
                break;
            }
        }
        if (infValida ==  false){
            System.out.println("Código Não Encontrado!");
        }
    }

    public static void excluirExame(){
        if (listaExames.size() == 0){
            System.out.println("Sem Exames Cadastrados");
            return;
        }
        System.out.print("Informe Código: ");
        int codExame = sc.nextInt();
        for (Exame exame: listaExames) {
            if (exame.getIdExame() == codExame){
                listaExames.remove(codExame);
                System.out.printf("\nRemovido da Lista: %d - %s - %d - %s",exame.getIdExame(), exame.getTipoExame(), exame.getNivelGlicose(),exame.obterDiagnostico());
                infValida = true;
                break;
            }
        }
        if (infValida ==  false){
            System.out.println("Código Não Encontrado!");
        }
    }

}
