package Sp_car;

import java.util.Scanner;

public class SpCar {

	/*
     * Programa desenvolvido para SPCAR para auxiliar na locação de carros
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String modeloCarro ;
        double valorDiaria ;
        int diasLocacao ;
        double kmPercorrido ;

        final double taxaPorKm = 0.2;

        System.out.println("Por favor, entre com o modelo de carro alugado:");
        modeloCarro = scan.nextLine();

        System.out.println("Agora, entre com o valor da diária do carro:");
        valorDiaria = scan.nextDouble();

        // Validação da diária
        while (valorDiaria <= 0) {
            System.out.println("Erro: O valor da diária deve ser maior que zero.");
            System.out.println("Agora, entre com o valor da diária do carro:");
            valorDiaria = scan.nextDouble();
        }

        System.out.println("Agora os dias de locação:");
        diasLocacao = scan.nextInt();
        scan.nextLine(); // Consumir o \n restante do buffer

        // Validação dos dias de locação
        while (diasLocacao <= 0) {
            System.out.println("Erro: O número de dias de locação deve ser maior que zero.");
            System.out.println("Agora, entre com o número de dias de locação:");
            diasLocacao = scan.nextInt();
            scan.nextLine(); // Consumir o \n restante do buffer
        }

        System.out.println("Agora quantos KM foram rodados com o carro alugado?:");
        kmPercorrido = scan.nextDouble();

        // Validação dos km percorridos
        while (kmPercorrido < 0) {
            System.out.println("Erro: A quilometragem percorrida deve ser um valor não negativo.");
            System.out.println("Agora, entre com a quilometragem percorrida:");
            kmPercorrido = scan.nextDouble();
        }

        System.out.println("\n");
        double valorAPagar = calcularValorAPagar(valorDiaria, diasLocacao, kmPercorrido, taxaPorKm); 
        
    	System.out.println("═════════════════════════════════════════════");

        System.out.println("Total a ser pago pelo " + modeloCarro + " é de R$" + String.format("%.2f", valorAPagar));

        // Fecha o Scanner
        scan.close(); 
        
    	System.out.println("\n");
    	System.out.println("═════════════════════════════════════════════");
        
        exibirSobre();
    }

    // Função para calcular o valor a ser pago
    public static double calcularValorAPagar(double valorDiaria, int diasLocacao, double kmPercorrido, double taxaPorKm) {
        return (kmPercorrido * taxaPorKm) + (valorDiaria * diasLocacao);
    }
    
    static void exibirSobre() {
        System.out.println("""
                ╔══════════════════════════════════════════════════╗
                ║            >>>>>>>>>>>SPCAR<<<<<<<<<<<<             ║
                ║ ................................................................................................................................... ║
                ║                      Codigo de  2024       versão: 1.0.0                     ║
                ╠══════════════════════════════════════════════════╣
                ║                               >>>> SOBRE <<<<                                 ║
                ║                                                                                                    ║
                ║        A aplicação foi desenvolvida para a Atividade da         ║
                ║       agenda 4 de desenvolvimento de sistemas da Etec       ║
                ╚══════════════════════════════════════════════════╝
              """);
    }
}
