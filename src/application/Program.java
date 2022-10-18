package application;

import entities.Pacient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pacient> listOfPacients = new ArrayList<>();

        System.out.print("Enter the number of pacients to be added in the list of pacients: ");
        int N = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            try {
                System.out.print("Enter the pacient name: ");
                String name = sc.nextLine();

                System.out.print("Enter the body mass of the pacient: ");
                double bodyMass = sc.nextDouble();

                System.out.print("Enter the height of the pacient: ");
                double height = sc.nextDouble();

                Pacient pacient = new Pacient(name, bodyMass, height);
                listOfPacients.add(pacient);

                System.out.println("BMI: " + String.format("%.2f", pacient.BMI()));
                System.out.println(pacient.bmiClassification());
                sc.nextLine();
            }
            catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        System.out.println();
        System.out.println(listOfPacients);
        System.out.println("Number of pacients attended today: " + listOfPacients.size());

        sc.close();
    }
}
