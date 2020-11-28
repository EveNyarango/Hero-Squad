package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
private String name;
private int age;
private String power;
private String weaknesses;
    private static List<Hero> hInstances = new ArrayList<>();
private int size;

    public Hero(String name, int age, String power, String weaknesses) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weaknesses = weaknesses;
        hInstances.add(this);
        size = hInstances.size();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPower() {
        return power;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public static List<Hero> getAll() {
        return hInstances;
    }

    public static List<Hero> addHero() {
        Hero aqua = new Hero("Aquaman", 40, "Ability to communicate with creatures", "kryptonite");
        Hero iron = new Hero("Ironman", 44, "Supersonic flight Energy", "Ego-Centric");
        Hero king = new Hero("Wakanda",36,"Vibranium", "Nerdy");
        hInstances.add(aqua);
        hInstances.add(iron);
        hInstances.add(king);
        return hInstances;
    }
}
