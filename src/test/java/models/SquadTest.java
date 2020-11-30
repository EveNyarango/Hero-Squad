package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void squadTest(){
        Squad squad = new Squad(8, "Rando", "Machine learning");
        Hero marvel = new Hero("Marvel", 40, "Super-Soldier serurm", "Lack of confidence");
        squad.add(marvel);
        assertTrue(Squad.getMembers().contains(squad));
    }

}