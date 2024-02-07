package model;

public class Order {
    private int id;
    private String pizzaType ="";
    private String ingredients = "";
    private int totalPrice = 0;
    private String address = "";

    public void setId(int id) {
        this.id = id;
    }

    private String status = "";

    public int getId() {
        return id;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType += pizzaType + " ";
    }

    public void setNewPizzaStr(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setNewIngredientStr(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients += ingredients + " ";
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice += totalPrice;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", pizzaType='" + pizzaType + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", totalPrice=" + totalPrice +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
