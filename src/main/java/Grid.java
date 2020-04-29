import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<GridComponent> firstLayer;
    private List<GridElement> secondLayer;
    private Ally ally;
    private int sizeX;
    private int sizeY;

    public Grid(int sizeX, int sizeY) {
        this.firstLayer = new ArrayList<>();
        this.secondLayer = new ArrayList<>();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    public Grid(int sizeX, int sizeY, List<GridComponent> firstLayer, List<GridElement> secondLayer) {
        this.firstLayer = firstLayer;
        this.secondLayer = secondLayer;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void addFirstLayerElement(GridComponent component) {
        if (!component.insideGrid(this.sizeX, this.sizeY)) {
            // exception ?
        }
        this.firstLayer.add(component);
    }

    public void addSecondLayerElement(GridElement element) {
        if (!element.insideGrid(this.sizeX, this.sizeY)) {
            // exception ?
        }
        this.secondLayer.add(element);
    }

    public void draw() {
        for (GridComponent gridComponent : this.firstLayer) {
            gridComponent.draw();
        }
        for (GridElement gridElement : this.secondLayer) {
            gridElement.draw();
        }
        this.ally.draw();
    }

    public void inflictDamage(Position pos, int damage) {
        if (pos.insideRectangle(new Position(0, 0), new Position(this.sizeX, this.sizeY))) {
            for (GridElement element : this.secondLayer) {
                if (element.getPos().same(pos)) {
                    element.takeDamage(damage);
                }
            }
        }
    }

    public void cleanDeadBodies() {
        for (GridElement element : this.secondLayer) {
            if (element.isDead()) {
                this.secondLayer.remove(element);
            }
        }
    }
}
