package main;

public abstract class Character {
    //Atributos que todos personagens tem
    public String name;
    public int max_hp, hp, xp;


    //Construção do personagem
    public Character(String name,int max_hp,int xp){
        this.name=name;
        this.max_hp=max_hp;
        this.hp=max_hp;
        this.xp=xp;
    }
    //metodos de todos os personagens
    public abstract int attack();
    public abstract int defend();
}
