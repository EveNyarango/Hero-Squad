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
    public void checkHeroSquad(){
    Squad squad = new Squad(5, "", "");
    Hero hero = new Hero("Wonder Woman", 25, "Supernatural Strength", "She falls in love");
    squad.add(hero);
    assertEquals(2, Squad.getMembers().size());
}
@Test
    public void functionalityTest(){
    Hero king = new Hero("Nyarango", 60, "Superman", "Stubborn");
    assertTrue(Hero.getAll().contains(king));
}
@Test
    public void heroInTheSquad(){
    Hero squadHero = new Hero("Wakanda",36,"Vibranium", "Nerdy");
    Squad.add(squadHero);
    assertTrue(Squad.whoIsTheHeroInSquad(squadHero));
}
}