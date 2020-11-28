package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
private int size;
private String name;
private String cause;
private int plusSize;
    private static List<Object> members = new ArrayList<>();
    private List<Hero> hero = new ArrayList<>();

    public Squad(int size, String name, String cause) {
        this.size = size;
        this.name = name;
        this.cause = cause;
        members.add(this);
        plusSize = members.size();
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public int getPlusSize() {
        return plusSize;
    }

    public static List<Object> getMembers() {
        return members;
    }
    public static void add(Hero hero){
        members.add(hero);
    }

    public static boolean whoIsTheHeroInSquad(Hero hero){
        return members.contains(hero);
    }

}
