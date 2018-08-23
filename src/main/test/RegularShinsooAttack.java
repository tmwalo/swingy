import com.gmail.vuyotm.swingy.controller.RegularManager;
import com.gmail.vuyotm.swingy.model.characters.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegularShinsooAttack {

    Regular     player;
    Shinheuh    enemy;
    int         expectedHpChange;

    public RegularShinsooAttack(Regular player, Shinheuh enemy, int expectedHpChange) {
        this.player = player;
        this.enemy = enemy;
        this.expectedHpChange = expectedHpChange;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {new Scout("Killer Arts"), new NetDolphin(), -1},
                {new Scout("Killer Arts"), new StripedGroundPig(), 0},
                {new Scout("Killer Arts"), new WhiteSteelEel(), 0},
                {new Scout("Killer Arts"), new Barracuda(), 0},
                {new LightBearer("Khun"), new NetDolphin(), -1},
                {new LightBearer("Khun"), new StripedGroundPig(), 0},
                {new LightBearer("Khun"), new WhiteSteelEel(), 0},
                {new LightBearer("Khun"), new Barracuda(), 0},
                {new Fisherman("Androssi"), new NetDolphin(), 0},
                {new Fisherman("Androssi"), new StripedGroundPig(), 0},
                {new Fisherman("Androssi"), new WhiteSteelEel(), 0},
                {new Fisherman("Androssi"), new Barracuda(), 0},
                {new SpearBearer("Rak"), new NetDolphin(), 0},
                {new SpearBearer("Rak"), new StripedGroundPig(), 0},
                {new SpearBearer("Rak"), new WhiteSteelEel(), 0},
                {new SpearBearer("Rak"), new Barracuda(), 0},
                {new WaveController("Baam"), new NetDolphin(), -8},
                {new WaveController("Baam"), new StripedGroundPig(), -7},
                {new WaveController("Baam"), new WhiteSteelEel(), -4},
                {new WaveController("Baam"), new Barracuda(), -5}
        });
    }

    @Test
    public void shinsooAttack() {
        int             originalEnemyHp;
        int             actualHpChange;
        RegularManager  regularManager;

        regularManager = new RegularManager(player);
        originalEnemyHp = enemy.getHitPts();
        regularManager.shinsooAttack(enemy);
        actualHpChange = enemy.getHitPts() - originalEnemyHp;
        assertEquals(expectedHpChange, actualHpChange);
    }

}
