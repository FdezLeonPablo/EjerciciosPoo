package com.campusdual.ejercicio4;

/*
* Escribe una clase dieta, que teniendo en cuenta una serie de alimentos, vaya sumando cantidades en gramos y calcule cuentas calorías, carbohidratos, proteinas y grasas genera la ingesta
La clase dieta tiene que tener las siguientes funcionalidades:
	-Diet(): crea una dieta sin límite de calorías
	-Diet(Integer maxCalories): crea una dieta con un máximo de calorías, en cuanto se supera ese máximo cuando se adjunta un alimento se despliega un error
	-Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein): crea una dieta con un máximo de estos tres valores, si se supera alguno de ellos cuando se adjunta un alimento se indicara cual y desplegará un error
	-Diet(Boolean women, Integer age, Integer height, Integer weight): Calcula el metabolismo basal de la persona y lo asigna como máximo de calorías en la dieta
		--CALCULAR METABOLISMO BASAL
			E = edad
			A = altura en centímetros
			P = peso en kilos

			Fórmula Hombres: TMB = 10P + 6,25A – 5E + 5
			Fórmula Mujeres: TMB = 10P + 6,25A – 5E – 161
	-addFood(Food,Integer): agrega un alimento y una cantidad en gramos
	-getTotalCalories(): devuelve el total de calorías
	-getTotalCarbs(): devuelve el total de carbohidratos
	-getTotalFats(): devuelve el total de grasas
	-getTotalProtein(): devuelve el total de proteinas
*
* */
public class Diet {
    private int maxCalories;
    private int maxFats;
    private int maxCarbs;
    private int maxProteins;

    private int totalCalories = 0;
    private int totalFats = 0;
    private int totalCarbs = 0;
    private int totalProteins = 0;

    public Diet() {
        this(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public Diet(int maxCalories) {
        this(maxCalories, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public Diet(int maxFats, int maxCarbs, int maxProteins) {
        this(Integer.MAX_VALUE, maxFats, maxCarbs, maxProteins);
    }

    public Diet(boolean isFemale, int age, int height, int weight) {
        this(calculateTMB(isFemale, age, height, weight), Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private static int calculateTMB(boolean isFemale, int age, int height, int weight) {
        return isFemale
                ? (10 * weight + 6 * height - 5 * age - 161)
                : (10 * weight + 6 * height - 5 * age + 5);
    }

    private Diet(int maxCalories, int maxFats, int maxCarbs, int maxProteins) {
        this.maxCalories = maxCalories;
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProteins = maxProteins;
    }

    public void resetDiet() {
        this.totalCalories = 0;
        this.totalFats = 0;
        this.totalCarbs = 0;
        this.totalProteins = 0;
    }

    public boolean addFood(Food food, int quantityInGrams) {
        int calories = food.getCalories(quantityInGrams);
        int fats = food.getFatContent() * quantityInGrams / 100;
        int carbs = food.getCarbContent() * quantityInGrams / 100;
        int proteins = food.getProteinContent() * quantityInGrams / 100;

        if (totalCalories + calories > maxCalories) {
            System.out.println("Error: Límite de calorías excedido");
            return false;
        }
        if (totalFats + fats > maxFats) {
            System.out.println("Error: Límite de grasas excedido");
            return false;
        }
        if (totalCarbs + carbs > maxCarbs) {
            System.out.println("Error: Límite de carbohidratos excedido");
            return false;
        }
        if (totalProteins + proteins > maxProteins) {
            System.out.println("Error: Límite de proteínas excedido");
            return false;
        }

        totalCalories += calories;
        totalFats += fats;
        totalCarbs += carbs;
        totalProteins += proteins;

        return true;
    }


    public int getTotalCalories() {
        return totalCalories;
    }

    public int getTotalFats() {
        return totalFats;
    }

    public int getTotalCarbs() {
        return totalCarbs;
    }

    public int getTotalProteins() {
        return totalProteins;
    }
}
