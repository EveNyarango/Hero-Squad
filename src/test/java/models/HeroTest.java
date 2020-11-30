package models;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HeroTest {

@Test
    public void instantiateClass(){
    Hero hero = new Hero("Nyarango", 60, "Superman", "Stubborn");
    assertTrue(true);
}

@Test
    public void functionalityTest(){
    Hero king = new Hero("Nyarango", 60, "Superman", "Stubborn");
    assertTrue(Hero.getAll().contains(king));
}

//    @Test
//    public void addHeroTest(){
//        List heroList = Hero.addHero();
//        assertEquals(6, heroList.size());
//    }
}