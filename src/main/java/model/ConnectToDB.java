package model;

import java.sql.*;
import java.util.ArrayList;

public class ConnectToDB {
    String getPizzaData = "select * from pizza_cafe.pizza_types";
    String getIngredientsData = "select * from pizza_cafe.ingredients";
    String addOrder = "insert into pizza_cafe.orders(pizza_name, ingredients, total_price, address, status) values (?, ?, ?, ?, ?)";
    Connection con;
    Statement statement;
    PreparedStatement pStmt;
    ResultSet result;

    public ArrayList<PizzaType> getPizzaFromDB(){
        ArrayList<PizzaType> pizzaArray = new ArrayList<>();

        try {
            con = DriverManager.getConnection(Credentials.url, Credentials.uName, Credentials.password);
            statement = con.createStatement();
            result = statement.executeQuery(getPizzaData);

            while (result.next()){
                PizzaType pizzaType = new PizzaType();

                pizzaType.setPosition(result.getInt("pizza_id"));
                pizzaType.setName(result.getString("pizza_type"));
                pizzaType.setPrice(result.getInt("price"));
                pizzaArray.add(pizzaType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzaArray;
    }

    public ArrayList<IngredientType> getIngredientsFromDB() {
        ArrayList<IngredientType> ingredientArray = new ArrayList<>();

        try {
            con = DriverManager.getConnection(Credentials.url, Credentials.uName, Credentials.password);
            statement = con.createStatement();
            result = statement.executeQuery(getIngredientsData);

            while (result.next()){
                IngredientType ingredientType = new IngredientType();

                ingredientType.setPosition(result.getInt("id"));
                ingredientType.setName(result.getString("name"));
                ingredientType.setPrice(result.getInt("price"));
                ingredientArray.add(ingredientType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientArray;
    }

    public void sendOrder(Order newOrder) {
        try {
            con = DriverManager.getConnection(Credentials.url, Credentials.uName, Credentials.password);
            pStmt = con.prepareStatement(addOrder);

            pStmt.setString(1, newOrder.getPizzaType());
            pStmt.setString(2, newOrder.getIngredients());
            pStmt.setInt(3, newOrder.getTotalPrice());
            pStmt.setString(4, newOrder.getAddress());
            pStmt.setString(5, newOrder.getStatus());

            pStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
