package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

@Test
    public void instantiateClass(){
    Hero hero = new Hero("Nyarango", 60, "Superman", "Stubborn");
    assertTrue(true);
}
@Test
    public void checkSquad(){
    Squad squad = new Squad(5, "", "");
    Hero hero = new Hero();
}

}