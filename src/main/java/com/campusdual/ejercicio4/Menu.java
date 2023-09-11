package com.campusdual.ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

/*
* --Escribe un programa que utilice la clase Dieta y despliegue un menú donde puedas añadir alimentos. El menú tendrá las siguientes opciones.
	-1. Crear/reiniciar dieta: crea o remplaza la dieta inicial
		-a. Sin limite
		-b. Por calorías
		-c. Por macronutrientes
		-d. Por datos personales
	-2. Mostrar información: muestra calorías y macronutrientes de la dieta
	-3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible
		-a. Nuevo alimento
		-b. Alimento existente
	-4. Salir
* */
public class Menu {

    private Diet currentDiet;
    private ArrayList<Food> foodList;

    public Menu() {
        foodList = new ArrayList<>();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- Menú ----");
            System.out.println("1. Crear/reiniciar dieta");
            System.out.println("2. Mostrar información");
            System.out.println("3. Agregar alimento");
            System.out.println("4. Salir");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createDiet();
                    break;
                case 2:
                    showDietInfo();
                    break;
                case 3:
                    addFood();
                    break;
                case 4:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una de las opciones existentes.");
            }
        }
        while (choice != 4);
        scanner.close();
    }
    private void createDiet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("a. Sin límite");
        System.out.println("b. Por calorías");
        System.out.println("c. Por macronutrientes");
        System.out.println("d. Por datos personales");
        String option = scanner.nextLine();

        switch (option) {
            case "a":
                currentDiet = new Diet();
                break;

            case "b":
                System.out.println("Introduce el máximo de calorías:");
                int maxCalories = scanner.nextInt();
                currentDiet = new Diet(maxCalories);
                break;


            case "c":
                System.out.println("Introduce el máximo de grasas:");
                int maxFats = scanner.nextInt();
                System.out.println("Introduce el máximo de carbohidratos:");
                int maxCarbs = scanner.nextInt();
                System.out.println("Introduce el máximo de proteínas:");
                int maxProteins = scanner.nextInt();
                currentDiet = new Diet(maxFats, maxCarbs, maxProteins);
                break;

            case "d":
                System.out.println("Eres mujer? (true/false):");
                boolean isFemale = scanner.nextBoolean();
                System.out.println("Introduce tu edad:");
                int age = scanner.nextInt();
                System.out.println("Introduce tu altura en cm:");
                int height = scanner.nextInt();
                System.out.println("Introduce tu peso en kg");
                int weight = scanner.nextInt();
                currentDiet = new Diet(isFemale, age, height, weight);
                break;

            default:
                System.out.println("Opción no válida. Por favor, selecciona una de las opciones existentes.");
                break;
        }

    }
    private void showDietInfo() {
        if (currentDiet != null) {
            System.out.println("Calorías totales: " + currentDiet.getTotalCalories());
        } else {
            System.out.println("Primero debes crear una dieta.");
        }
    }

    private void addFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a. Nuevo alimento");
        System.out.println("b. Alimento existente");
        String option = scanner.nextLine();

        if (currentDiet == null) {
            System.out.println("Debes crear una dieta antes de agregar alimentos.");
            return;
        }

        if ("a".equals(option)) {
            System.out.print("Nombre del alimento: ");
            String name = scanner.nextLine();
            System.out.print("Grasas (g/100g): ");
            int fats = scanner.nextInt();
            System.out.print("Carbohidratos (g/100g): ");
            int carbs = scanner.nextInt();
            System.out.print("Proteínas (g/100g): ");
            int proteins = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Cantidad en gramos: ");
            int grams = scanner.nextInt();

            Food newFood = new Food(name, carbs, fats, proteins);
            foodList.add(newFood);
            if(currentDiet.addFood(newFood, grams)) {
                System.out.println(name + " ha sido añadido a la dieta.");
            } else {
                System.out.println("No se pudo añadir " + name + " a la dieta debido a restricciones.");
            }

        } else if ("b".equals(option)) {
            System.out.println("Alimentos existentes:");
            for (int i = 0; i < foodList.size(); i++) {
                System.out.println((i + 1) + ". " + foodList.get(i).getFoodName());
            }

            System.out.print("Seleccione el número del alimento que desea agregar: ");
            int foodIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            if (foodIndex >= 0 && foodIndex < foodList.size()) {
                System.out.print("Cantidad en gramos: ");
                int grams = scanner.nextInt();
                if(currentDiet.addFood(foodList.get(foodIndex), grams)) {
                    System.out.println(foodList.get(foodIndex).getFoodName() + " ha sido añadido a la dieta.");
                } else {
                    System.out.println("No se pudo añadir " + foodList.get(foodIndex).getFoodName() + " a la dieta debido a restricciones.");
                }
            } else {
                System.out.println("Selección inválida.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();
    }
}