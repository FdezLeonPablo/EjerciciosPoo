package com.campusdual.ejercicio4;

public class Food {
    private String foodName;
    private Integer carbContent;
    private Integer fatContent;
    private Integer proteinContent;

    public Food(String foodName){
        this.carbContent = 0;
        this.fatContent = 0;
        this.proteinContent = 0;
        this.foodName = foodName;
    }

    public Food(String foodName, Integer carbContent, Integer fatContent, Integer proteinContent){
        this.foodName = foodName;
        this.carbContent = carbContent;
        this.fatContent = fatContent;
        this.proteinContent = proteinContent;
    }

    public Integer getCalories(Integer quantityInGrams){
        return ((carbContent * 4) + (fatContent * 9) + (proteinContent * 4)) * quantityInGrams / 100;
    }


    public Integer getCarbContent() {
        return carbContent;
    }

    public void setCarbContent(Integer carbContent) {
        this.carbContent = carbContent;
    }

    public Integer getFatContent() {
        return fatContent;
    }

    public void setFatContent(Integer fatContent) {
        this.fatContent = fatContent;
    }

    public Integer getProteinContent() {
        return proteinContent;
    }

    public void setProteinContent(Integer proteinContent) {
        this.proteinContent = proteinContent;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
