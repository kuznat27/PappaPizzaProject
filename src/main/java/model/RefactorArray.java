package model;

import java.util.ArrayList;

public class RefactorArray {

    public static void refactorPizzaTypes(ArrayList<Order> orderArray, ArrayList<PizzaType> arrayOfPizzas) {
        StringBuilder newPizzaString = new StringBuilder();

        for (int i = 0; i < orderArray.size(); i++) {
            String pizzaOrder = orderArray.get(i).getPizzaType();
            String [] pizzaStr = pizzaOrder.split(" ");

            for (String str : pizzaStr) {
                int id = Integer.parseInt(str) - 1;
                String pizzaName = arrayOfPizzas.get(id).getName();

                if (str.equals(pizzaStr[pizzaStr.length - 1])){
                    newPizzaString.append(pizzaName);
                } else {
                    newPizzaString.append(pizzaName).append(", ");
                }

            }

            orderArray.get(i).setNewPizzaStr(newPizzaString.toString());
            newPizzaString.setLength(0);
        }
    }

    public static void refactorIngredientTypes(ArrayList<Order> orderArray, ArrayList<IngredientType> ingredientArray) {
        StringBuilder newIngredientString = new StringBuilder();

        for (int i = 0; i < orderArray.size(); i++) {
            String ingredientOrder = orderArray.get(i).getIngredients();
            String [] ingredientStr = ingredientOrder.split(" ");

            for (String str : ingredientStr) {
                int id = Integer.parseInt(str) - 1;
                String ingredientName = ingredientArray.get(id).getName();

                if (str.equals(ingredientStr[ingredientStr.length - 1])){
                    newIngredientString.append(ingredientName);
                } else {
                    newIngredientString.append(ingredientName).append(", ");
                }

            }

            orderArray.get(i).setNewIngredientStr(newIngredientString.toString());
            newIngredientString.setLength(0);
        }
    }
}
