package recipe.app;

import java.util.ArrayList;


import static org.junit.Assert.*;

public class recipeAppTest {

    @org.junit.Test
    public void Fridge() {
        Inventory s = new Inventory();
        Inventory i = new Inventory();
        ArrayList<String> ingredients = new ArrayList<>();
        assertTrue(s.getNumIngredients() == 0);
        String q = "hi";
        String n = "food";
        ingredients.add(q);
        ingredients.add(n);
        s.addToFridge(q, n);
        assertTrue(s.getNumIngredients() == 1);
        s.addToFridge(n, q);
        assertTrue(s.getNumIngredients() == 2);

        i.addToFridge(n, q);
        assertTrue(i.getNumIngredients() == 1);
        i.addToFridge(q, n);
        assertTrue(i.getNumIngredients() == 2);
        assertTrue(s.getFridge().get(0).getName() == "food");
        assertSame(s.getFridge().get(1).getName(),"hi");
        s.removeFromFridge(q, n);
        assertTrue(s.getNumIngredients() == 1);

    }

    @org.junit.Test
    public void findRecipe() {
        Inventory i = new Inventory();
        i.addToFridge("1 cup", "food");
        i.addToFridge("1 pound", "ice");
        i.addToFridge("2 tbs", "oof");
        i.addToFridge("5 cups", "wasd");
        i.addToFridge("5 pizz", "asd");
        i.addToFridge("4 wsad", "qwerty");
        assertTrue(i.findRecipe(i.getFridge()).getName() == i.getMyCookbook().getRecipe(0).getName());
    }
}
