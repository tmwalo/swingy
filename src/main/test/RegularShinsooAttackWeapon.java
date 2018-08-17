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
public class RegularShinsooAttackWeapon {

    Regular     player;
    Shinheuh    enemy;
    int         expectedHpChange;

    public RegularShinsooAttackWeapon(Regular player, Shinheuh enemy, int expectedHpChange) {
        this.player = player;
        this.enemy = enemy;
        this.expectedHpChange = expectedHpChange;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {new Scout("Killer Arts"), new NetDolphin(), -3},
                {new Scout("Killer Arts"), new StripedGroundPig(), -2},
                {new Scout("Killer Arts"), new WhiteSteelEel(), 0},
                {new Scout("Killer Arts"), new Barracuda(), 0},
                {new LightBearer("Khun"), new NetDolphin(), -3},
                {new LightBearer("Khun"), new StripedGroundPig(), -2},
                {new LightBearer("Khun"), new WhiteSteelEel(), 0},
                {new LightBearer("Khun"), new Barracuda(), 0},
                {new Fisherman("Androssi"), new NetDolphin(), -1},
                {new Fisherman("Androssi"), new StripedGroundPig(), 0},
                {new Fisherman("Androssi"), new WhiteSteelEel(), 0},
                {new Fisherman("Androssi"), new Barracuda(), 0},
                {new SpearBearer("Rak"), new NetDolphin(), -2},
                {new SpearBearer("Rak"), new StripedGroundPig(), -1},
                {new SpearBearer("Rak"), new WhiteSteelEel(), 0},
                {new SpearBearer("Rak"), new Barracuda(), 0},
                {new WaveController("Baam"), new NetDolphin(), -10},
                {new WaveController("Baam"), new StripedGroundPig(), -9},
                {new WaveController("Baam"), new WhiteSteelEel(), -6},
                {new WaveController("Baam"), new Barracuda(), -7}
        });
    }

    @Test
    public void shinsooAttackWeapon() {
        int             originalEnemyHp;
        int             actualHpChange;
        Weapon          needle;
        RegularManager  regularManager;

        regularManager = new RegularManager(player);
        originalEnemyHp = enemy.getHitPts();
        needle = new Weapon("staff", 0, 2);
        player.setWeapon(needle);
        regularManager.shinsooAttack(enemy);
        actualHpChange = enemy.getHitPts() - originalEnemyHp;
        assertEquals(expectedHpChange, actualHpChange);
    }

}
