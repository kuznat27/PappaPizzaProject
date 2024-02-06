package model;

public class PizzaChoice {
    private String pizzaType ="";
    private int pizzaQuantity = 0;
    private String ingredients = "";
    private int ingredientQuantity = 0;
    private int totalPrice = 0;

    public String getPizzaType() {
        return pizzaType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType += pizzaType;
    }

    public int getPizzaQuantity() {
        return pizzaQuantity;
    }

    public int getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredients(String ingredients) {
        this.ingredients += ingredients;
    }

    public void setPizzaQuantity(int pizzaQuantity) {
        this.pizzaQuantity = pizzaQuantity;
    }

    public void setIngredientQuantity(int ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice += totalPrice;
    }

    @Override
    public String toString() {
        return "PizzaChoice{" +
                "pizzaType='" + pizzaType + '\'' +
                ", pizzaQuantity=" + pizzaQuantity +
                ", ingredients='" + ingredients + '\'' +
                ", ingredientQuantity=" + ingredientQuantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
