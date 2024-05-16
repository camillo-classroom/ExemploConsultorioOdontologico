import Models.Dentista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome1 = sc.nextLine();
        String nome2 = sc.nextLine();

        boolean ehIgual = nome1.equals(nome2);
        boolean ehDiferente = !nome1.equals(nome2);

        System.out.println("ehIgual:");
        System.out.println(ehIgual);
        System.out.println("ehDiferente:");
        System.out.println(ehDiferente);
    }
}