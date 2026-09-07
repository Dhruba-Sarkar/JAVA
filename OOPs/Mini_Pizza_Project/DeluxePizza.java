package Mini_Pizza_Project;

class DeluxePizza extends Pizza {
    public DeluxePizza(boolean isVeg) {
        super(isVeg);
        super.addExtraCheese();
        super.addExtraToppings();
    }
}