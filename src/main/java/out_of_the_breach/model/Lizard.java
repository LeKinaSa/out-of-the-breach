package out_of_the_breach.model;

import java.util.ArrayList;
import java.util.List;

import static out_of_the_breach.model.AttackDirection.*;

/*
    It will target the closest units.
    If the target is inaccessible, it will try the next nearest entity.
    Prioritizes cities.
 */

public class Lizard extends Enemy {
    public Lizard(Position pos, int hp, int damage) {
        super(pos, hp, new AOEAttack(damage));
    }

    @Override
    public void moveAndPlanAttack(GameModel grid) {
        // Find the Targets -> (Prioritize the attacks on cities)
        List<Entity> targets = new ArrayList<>();

        for (City city : grid.getCities()) {
            targets.add(city);
        }

        for (Hero ally : grid.getAllies()) {
            targets.add(ally);
        }

        // Find the Position where we can Attack
        Position pos = super.getPosition();
        Position closerPosition = null;
        Position targetPosition;
        double smallerDistance = 64;
        double distance;

        // Check what's the closest position to the current position of the lizard
        for (int index = 0; (index < targets.size()) && (smallerDistance != 0); index ++) {
            targetPosition = targets.get(index).getPosition();

            Position north = targetPosition.adjacentPos(NORTH);
            Position south = targetPosition.adjacentPos(SOUTH);
            Position east  = targetPosition.adjacentPos( EAST);
            Position west  = targetPosition.adjacentPos( WEST);

            if (canMove(grid, north)) {
                distance = pos.distanceTo(north);
                if (distance < smallerDistance) {
                    closerPosition = north;
                    smallerDistance = distance;
                }
            }
            if (canMove(grid, south)) {
                distance = pos.distanceTo(south);
                if (distance < smallerDistance) {
                    closerPosition = south;
                    smallerDistance = distance;
                }
            }
            if (canMove(grid, east)) {
                distance = pos.distanceTo(east);
                if (distance < smallerDistance) {
                    closerPosition = east;
                    smallerDistance = distance;
                }
            }
            if (canMove(grid, west)) {
                distance = pos.distanceTo(west);
                if (distance < smallerDistance) {
                    closerPosition = west;
                    smallerDistance = distance;
                }
            }
        }

        if (closerPosition != null) {
            this.setPosition(closerPosition);
        }
    }
}
