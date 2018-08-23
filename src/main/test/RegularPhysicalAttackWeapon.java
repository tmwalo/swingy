import com.gmail.vuyotm.swingy.controller.RegularManager;
import com.gmail.vuyotm.swingy.model.artifacts.Weapon;
import com.gmail.vuyotm.swingy.model.characters.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegularPhysicalAttackWeapon {

    Regular     player;
    Shinheuh    enemy;
    int         expectedHpChange;

    public RegularPhysicalAttackWeapon(Regular player, Shinheuh enemy, int expectedHpChange) {
        this.player = player;
        this.enemy = enemy;
        this.expectedHpChange = expectedHpChange;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {new Scout("Killer Arts"), new NetDolphin(), -3},
                {new Scout("Killer Arts"), new StripedGroundPig(), -2},
                {new Scout("Killer Arts"), new WhiteSteelEel(), -1},
                {new Scout("Killer Arts"), new Barracuda(), 0},
                {new LightBearer("Khun"), new NetDolphin(), -2},
                {new LightBearer("Khun"), new StripedGroundPig(), -1},
                {new LightBearer("Khun"), new WhiteSteelEel(), 0},
                {new LightBearer("Khun"), new Barracuda(), 0},
                {new Fisherman("Androssi"), new NetDolphin(), -10},
                {new Fisherman("Androssi"), new StripedGroundPig(), -9},
                {new Fisherman("Androssi"), new WhiteSteelEel(), -8},
                {new Fisherman("Androssi"), new Barracuda(), -7},
                {new SpearBearer("Rak"), new NetDolphin(), -8},
                {new SpearBearer("Rak"), new StripedGroundPig(), -7},
                {new SpearBearer("Rak"), new WhiteSteelEel(), -6},
                {new SpearBearer("Rak"), new Barracuda(), -5},
                {new WaveController("Baam"), new NetDolphin(), -2},
                {new WaveController("Baam"), new StripedGroundPig(), -1},
                {new WaveController("Baam"), new WhiteSteelEel(), 0},
                {new WaveController("Baam"), new Barracuda(), 0}
        });
    }

    @Test
    public void physicalAttackWeapon() {
        int             originalEnemyHp;
        int             actualHpChange;
        RegularManager  regularManager;
        Weapon          needle;

        regularManager = new RegularManager(player);
        originalEnemyHp = enemy.getHitPts();
        needle = new Weapon("needle", 2, 0);
        player.setWeapon(needle);
        regularManager.physicalAttack(enemy);
        actualHpChange = enemy.getHitPts() - originalEnemyHp;
        assertEquals(expectedHpChange, actualHpChange);
    }

}
