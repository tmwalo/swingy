import com.gmail.vuyotm.swingy.controller.ShinheuhManager;
import com.gmail.vuyotm.swingy.model.artifacts.Helm;
import com.gmail.vuyotm.swingy.model.characters.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShinheuhShinsooAttackHelm {

    Regular     enemy;
    Shinheuh    shinheuh;
    int         expectedHpChange;

    public ShinheuhShinsooAttackHelm(Regular enemy, Shinheuh shinheuh, int expectedHpChange) {
        this.enemy = enemy;
        this.shinheuh = shinheuh;
        this.expectedHpChange = expectedHpChange;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {new Scout("Killer Arts"), new NetDolphin(), 0},
                {new LightBearer("Khun"), new NetDolphin(), 0},
                {new Fisherman("Androssi"), new NetDolphin(), 0},
                {new SpearBearer("Rak"), new NetDolphin(), 0},
                {new WaveController("Baam"), new NetDolphin(), 0},
                {new Scout("Killer Arts"), new StripedGroundPig(), 0},
                {new LightBearer("Khun"), new StripedGroundPig(), 0},
                {new Fisherman("Androssi"), new StripedGroundPig(), 0},
                {new SpearBearer("Rak"), new StripedGroundPig(), 0},
                {new WaveController("Baam"), new StripedGroundPig(), 0},
                {new Scout("Killer Arts"), new WhiteSteelEel(), 0},
                {new LightBearer("Khun"), new WhiteSteelEel(), 0},
                {new Fisherman("Androssi"), new WhiteSteelEel(), 0},
                {new SpearBearer("Rak"), new WhiteSteelEel(), 0},
                {new WaveController("Baam"), new WhiteSteelEel(), 0},
                {new Scout("Killer Arts"), new Barracuda(), 0},
                {new LightBearer("Khun"), new Barracuda(), 0},
                {new Fisherman("Androssi"), new Barracuda(), 0},
                {new SpearBearer("Rak"), new Barracuda(), 0},
                {new WaveController("Baam"), new Barracuda(), 0}
        });
    }

    @Test
    public void shinsooAttackHelm() {
        int     originalEnemyHp;
        int     actualHpChange;
        Helm    helm;
        ShinheuhManager shinheuhManager;

        shinheuhManager = new ShinheuhManager(shinheuh);
        helm = new Helm("basic", 2);
        enemy.setHelm(helm);
        originalEnemyHp = enemy.getHitPts();
        shinheuhManager.shinsooAttack(enemy);
        actualHpChange = enemy.getHitPts() - originalEnemyHp;
        assertEquals(expectedHpChange, actualHpChange);
    }

}
