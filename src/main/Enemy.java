package main;

public class Enemy extends Character {

    int playerXp;
    public Enemy(String name, int playerXp) {
        super(name, (int)(Math.random()*playerXp+playerXp/3+4),(int)(Math.random()*(playerXp/2+4)));

        this.playerXp=playerXp;
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(playerXp/4+2)+xp/4+3);
    }

    @Override
    public int defend() {

        return (int) (Math.random()*(playerXp/5+2)+xp/4+3);
    }

}
