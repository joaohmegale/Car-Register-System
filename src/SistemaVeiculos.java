import java.util.*;
public class SistemaVeiculos {
    String[] modelos;
    String[] placas;
    int count;


    public SistemaVeiculos() {
        modelos = new String[100];
        placas = new String[100];
        count = 0;
    }


    public void cadastrarVeiculo(String modelo, String placa) {
        if (count < 100) {
            modelos[count] = modelo;
            placas[count] = placa;
            count++;
            System.out.println("Veículo cadastrado.");
        } else {
            System.out.println("Limite de cadastro atingido.");
        }
    }


    public void consultarVeiculo(String placa) {
        int index = buscarVeiculoRecursivo(placa, 0);
        if (index != -1) {
            System.out.println("Modelo: " + modelos[index]);
            System.out.println("Placa: " + placas[index]);
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }


    public int buscarVeiculoRecursivo(String placa, int i) {
        if (i >= count) {
            return -1;
        }
        if (placas[i].equals(placa)) {
            return i;
        }
        return buscarVeiculoRecursivo(placa, i + 1);
    }


    public void listarVeiculos() {
        for (int i = 0; i < count; i++) {
            System.out.println("Modelo: " + modelos[i]);
            System.out.println("Placa: " + placas[i]);
        }
    }


    public void exibirMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar veículo:");
            System.out.println("2- Consultar veículo:");
            System.out.println("3- Listar veículos:");
            System.out.println("4- Ordenar por: A. Modelo ou B. Placa.");
            System.out.println("0. Sair do programa.");


            System.out.print("Digite o comando desejado: ");
            int comando = in.nextInt();
            in.nextLine();


            switch (comando) {
                case 1:
                    System.out.print("Digite o modelo do veículo: ");
                    String modelo = in.nextLine();
                    System.out.print("Digite a placa do veículo: ");
                    String placa = in.nextLine();
                    cadastrarVeiculo(modelo, placa);
                    break;
                case 2:
                    System.out.print("Digite a placa do veículo que deseja consultar: ");
                    placa = in.nextLine();
                    consultarVeiculo(placa);
                    break;
                case 3:
                    listarVeiculos();
                    break;
                case 4:
                    String opcao = in.nextLine();
                    if (opcao.equalsIgnoreCase("A")) {
                        Ordenacao.ordenarPorModelo(modelos, placas, count);
                        System.out.println("Veiculos ordenados por modelo.");
                    } else if (opcao.equalsIgnoreCase("B")){
                        Ordenacao.ordenarPorPlaca(placas, modelos, count);
                        System.out.println("Veiculos ordenados por placa.");
                    }else{
                        System.out.println("Opcao invalida, Seleciona A ou B.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Comando inválido. Digite outro comando.");
                    break;
            }
        }
    }
}
