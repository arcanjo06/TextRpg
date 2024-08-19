package main;

public class Player extends Character {
    //Numero de Upgrades em cada Path
    public int numAtkUpgrades,numDefUpgrades;

    int grana,bandagens;

    //Upgrades
    public String[] atkupgrades={"Força", "Poder", "Raiva", "Força Divina"};
    public String[] defupgrades={"Ossos Pesados", "Pele de Pedra", "Esquiva Perfeita", "Aura Divina"};


    //Construtor das especificações do player
    public Player(String name) {
        super(name, 100,0);

        //Valor dos upgrades é 0
        this.numAtkUpgrades=0;
        this.numDefUpgrades=0;
        //Opção de criar o traço
        this.grana=5;
        this.bandagens=2;
        chooseTrait();
    }

    @Override
    //Metodos especificos do player
    public int attack() {
        
        return (int) (Math.random()*(xp/4+numAtkUpgrades*3+3)+xp/10+numAtkUpgrades*2+numDefUpgrades+1);
    }
    @Override
    public int defend() {

        return (int) (Math.random()*(xp/4+numDefUpgrades*3+3)+xp/10+numDefUpgrades*2+numAtkUpgrades+1);
    }

    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Escolha um Traço: ");
        System.out.println("(1) "+ atkupgrades[numAtkUpgrades]);
        System.out.println("(2) "+defupgrades[numDefUpgrades]);

        int input= GameLogic.readInt("-->", 2);

        if (input==1) {
            GameLogic.printHeading("Você escolheu "+atkupgrades[numAtkUpgrades]+ "!");
            numAtkUpgrades++;
            
        }else if (input==2) {
            GameLogic.printHeading("Você escolheu "+defupgrades[numDefUpgrades]+"!");
            numDefUpgrades++;
        }else{
            System.out.println("Insira um numero valido");
        }
        GameLogic.anythingContinue();
    }

}
