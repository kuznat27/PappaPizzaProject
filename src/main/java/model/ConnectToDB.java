package model;

import java.sql.*;
import java.util.ArrayList;

public class ConnectToDB {
    String getPizzaData = "select * from pizza_cafe.pizza_types";
    public ArrayList<PizzaType> getPizzaFromDB(){
        ArrayList<PizzaType> pizzaArray = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(Credentials.url, Credentials.uName, Credentials.password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(getPizzaData);

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

}
