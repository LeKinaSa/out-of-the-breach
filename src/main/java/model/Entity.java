package model;

public abstract class Entity {
    private Position pos;
    private int hp;

    public Entity(Position pos, int hp) {
        this.pos = pos;
        this.hp = hp;
    }

    public Position getPosition() {
        return this.pos;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
        }
    }

    public boolean isDead() {
        return this.hp == 0;
    }

    public abstract void draw();
}
