package out_of_the_breach.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttackTest {
    @Test
    public void directionTestNoneAndSet() {
        AttackStrategy strategy = new LineAttack(2, 1);
        assertEquals(AttackDirection.NONE, strategy.getDirection());

        strategy.setDirection(AttackDirection.NORTH);
        assertEquals(AttackDirection.NORTH, strategy.getDirection());

        strategy.setDirection(AttackDirection.SOUTH);
        assertEquals(AttackDirection.SOUTH, strategy.getDirection());

        strategy.setDirection(AttackDirection.EAST);
        assertEquals(AttackDirection.EAST, strategy.getDirection());

        strategy.setDirection(AttackDirection.WEST);
        assertEquals(AttackDirection.WEST, strategy.getDirection());

        strategy.setDirection(AttackDirection.NONE);
        assertEquals(AttackDirection.NONE, strategy.getDirection());
    }

    @Test
    public void directionTestConstructors() {
        AttackStrategy strategyNone  = new LineAttack(1, 1, AttackDirection.NONE );
        AttackStrategy strategyNorth = new LineAttack(1, 1, AttackDirection.NORTH);
        AttackStrategy strategySouth = new LineAttack(1, 1, AttackDirection.SOUTH);
        AttackStrategy strategyEast  = new LineAttack(1, 1, AttackDirection.EAST );
        AttackStrategy strategyWest  = new LineAttack(1, 1, AttackDirection.WEST );

        assertEquals(AttackDirection.NONE ,  strategyNone.getDirection());
        assertEquals(AttackDirection.NORTH, strategyNorth.getDirection());
        assertEquals(AttackDirection.SOUTH, strategySouth.getDirection());
        assertEquals(AttackDirection.EAST ,  strategyEast.getDirection());
        assertEquals(AttackDirection.WEST ,  strategyWest.getDirection());
    }
}
