package main;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    public static boolean isRunning;
    

    public static int act=1;
    static Player player;
    static Scanner scanner= new Scanner(System.in);
    static Random random = new Random();
    
    public static String[] encounters={"Batalha" ,"Batalha","Batalha","Batalha","Descanso","Descanso"};

    public static String[] enemies={"Zumbi", "Zumbi Apodrecido","Zumbi sem braço", "Zumbi Gordo", "Zumbi Hippie", "Zumbi Grande"};

    public static String[] battleEvents={
        "Os personagens chegam a uma pequena cidade onde encontram uma festa de zumbis em uma casa de fazenda. Os zumbis parecem estar \"dançando\" e \"celebrando\" algo. É uma situação estranha e potencialmente perigosa, com muitos zumbis em um estado inusitado.Vocês terão que enfrenta-los para enfim ficar em segurança",

        "O grupo explora um estádio de futebol abandonado, onde zumbis parecem estar organizados como se estivessem assistindo a um jogo. A cena é desconcertante, e os jogadores devem enfrentar os zumbis que podem ter se agrupado ali por causa do ambiente.",

        "Na costa, os jogadores encontram uma vila de pescadores que foi invadida por zumbis marítimos, com alguns dos mortos-vivos vindo do mar. A vila está parcialmente submersa e é cheia de perigos tanto aquáticos quanto terrestres." ,

        "Você ouve um gemido baixo vindo de um beco escuro. O ar fica pesado e frio.",

        "De dentro de uma casa em ruínas, você ouve uma porta batendo. Um zumbi encharcado de sangue aparece.",

        "Uma forte chuva começa a cair, dificultando sua visão. Um zumbi surge do nada.",

        "Você encontra um carro abandonado, mas antes de poder investigá-lo, zumbis começam a surgir de todos os lados.",

        "Enquanto atravessa um parque abandonado, você ouve o som suave de uma melodia de caixa de música. Seguindo o som, encontra uma velha carrossel ainda funcionando, cercada por crianças zumbis que parecem presas em um ciclo interminável de horror. Um deles se vira lentamente em sua direção, com olhos vazios e sorriso macabro.",

        "Ao entrar em uma igreja aparentemente abandonada, você é imediatamente envolto em uma sensação de paz... até que ouve um som rítmico vindo do porão. Curioso, desce as escadas para investigar. O que você encontra são dezenas de zumbis, todos ajoelhados, aparentemente rezando, com um enorme zumbi líder à frente, comandando-os para atacar você.",

        "O silêncio da noite é quebrado por um estrondo ensurdecedor. Um helicóptero militar cai em chamas a poucos metros de você, despedaçando-se ao colidir com o solo. Os zumbis, atraídos pelo barulho, começam a se aglomerar em volta da aeronave em chamas, e você está exatamente no meio do caminho entre eles e a única rota de fuga.",

        "Enquanto revira os destroços de uma loja em busca de suprimentos, você encontra uma criança. Ela está suja, assustada, e sussurra sobre seu 'amigo' que foi buscar ajuda. Antes que você possa reagir, ouve um rosnado gutural. O 'amigo' da criança, agora um zumbi, aparece na entrada, com os olhos vidrados e fome mortal.",

    };

    
    //metodo para pegar o input do usurario no terminal
    public static int readInt(String prompt,int UserChoices){
        int input;

        do { 
            System.out.println(prompt);
            try {
                input=Integer.parseInt(scanner.next());
            } catch(Exception e){
                input=-1;
                System.out.println("Por favor digite um número válido:");
            }
        } while (input<1 || input>UserChoices);

        return input;
    }
    //metodo para limpar o console
    public static void clearConsole() {
        for(int i=0;i<100;i++){
            System.out.println();

        }
    }

    //metodo para criar um separador com lenght n
    public static void printSeparator(int n) {
        for(int i=0;i<n;i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingContinue(){
        printSeparator(20);
        System.out.println("Digite algo para continuar...");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet=false;
        String name;

        clearConsole();
        printSeparator(50);
        printSeparator(30);
        System.out.println("DEAD CITY");
        System.out.println("By Levi Arcanjo");
        printSeparator(30);
        printSeparator(50);
        anythingContinue();
        do { 
            clearConsole();
            printHeading("Olá Viajante, Como é seu nome? ");
            name=scanner.next();
            printHeading("Seu nome é : "+name+"\nEstá certo?");
            System.out.println("(1) Sim");
            System.out.println("(2) Não, quero trocar.");
            int input=readInt("-->", 2);
            if (input==1) {
                nameSet=true;
            }
        } while (!nameSet);
        player=new Player(name);

        isRunning=true;
        Story.printIntro();
        Story.printFirstActIntro();

        gameLoop();
    }
    public static void checkAct() {
        if(player.xp>=20 && act==1){
            act=2;
            Story.printFirstActEnd();
            player.chooseTrait();
            Story.printSecondActIntro();
            enemies[0]="Zumbi Baiano";
            enemies[5]="Estuprador";

            encounters[0]="Batalha";
            encounters[5]="Caso de Estupro";

        }else if(player.xp>=50 && act==2){
            act=3;
            Story.printSecondActEnd();
            player.chooseTrait();
            Story.printThirdActIntro();

            enemies[0]="Zumbi Mineiro";

        }else if (player.xp>=100 && act==3) {
            act=4;
            Story.printThirdActEnd();
            player.chooseTrait();
            randomEncounter();
            randomEncounter();
            Story.printEndAct(player);
        }
        }

    public static void continueJourney() {
        checkAct();
        if(act!=4){
            randomEncounter();
        }
    }

    public static void randomEncounter(){
        int encounter=(int)(Math.random()*encounters.length);
        if (encounters[encounter].equals("Batalha")) {
            randomBattle();
        }else if (encounters[encounter].equals("Descanso")) {
            randomRest();
        }
    }
    public static void randomRest(){
        clearConsole();
        int hpRestored=(int) (Math.random()*(player.hp/8+10));
        String[] restEvents={
            "Você encontra uma pequena cabana escondida entre as árvores. Ao entrar, o cheiro de lenha queimada ainda persiste no ar. Após trancar a porta, você se deita em uma cama improvisada. A noite é tranquila, e você acorda sentindo-se revigorado. (Recuperou "+hpRestored+"HP)",
    
            "Depois de muito procurar, você encontra um pequeno abrigo subterrâneo. A pesada porta de metal é o suficiente para manter os zumbis do lado de fora. Você acende uma vela e se prepara para descansar. A sensação de segurança permite que você durma sem preocupações. (Recuperou "+hpRestored+"HP)",
    
            "Você encontra uma farmácia saqueada, mas ao explorar os fundos, descobre uma sala que ainda está intacta. Lá, encontra alguns analgésicos e bandagens. Após se tratar, você adormece em uma cadeira confortável. (Recuperou"+hpRestored+"HP)",
    
            "Em uma pequena igreja abandonada, você encontra um lugar tranquilo para descansar. Ao rezar por um momento de paz, sente um estranho conforto. A tranquilidade do local permite um descanso profundo. (Recuperou "+hpRestored+"HP)"        
        };
        
        player.hp+=hpRestored;
        if (player.hp>player.max_hp) {
            player.hp=player.max_hp;
        }
        printHeading(restEvents[random.nextInt(restEvents.length)]);
        anythingContinue();
    }
    
    public static void randomBattle(){
        clearConsole();
        printHeading(battleEvents[random.nextInt(battleEvents.length)]);
        anythingContinue();

        battle(new Enemy(enemies[(int) (Math.random()*enemies.length)], player.xp));
        
    }
    
    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeading( enemy.name + " \nHP" + enemy.hp+ "/" + enemy.max_hp);
            printHeading(player.name + " \nHP" + player.hp+ "/" + player.max_hp);
            System.out.println("(1)Lutar\n(2)Tentar se curar\n(3)Fugir");
            int input= readInt("-->", 3);
            if(input==1){
                int dmg=player.attack()-enemy.defend();
                int dmgTook=enemy.attack()-player.defend();

                if(dmgTook<0){
                    dmg -= dmgTook/2;
                    dmgTook=0;
                }
                if (dmg<0) {
                    dmg=0;
                }

                player.hp-=dmgTook;
                enemy.hp-=dmg;
                printHeading("BATTLE");
                System.out.println("Você deu "+dmg+" de dano no "+enemy.name + ".");
                printSeparator(20);
                System.out.println(enemy.name+ " lhe deu "+ dmgTook+ " de dano, cuidado.");
                anythingContinue();
                if (player.hp<=0) {
                    playerDied();
                    break;
                }else if (enemy.hp<=0) {
                    System.out.println("Você derrotou o "+enemy.name+" !!");
                    player.xp+=enemy.xp;
                    System.out.println("Você ganhou "+enemy.xp+ " xp!!");
                    anythingContinue();
                    break;
                }
            }else if (input==2) {
                //curar();
            }else{
                clearConsole();
                if (Math.random()*10>=3.5) {
                    printHeading("VOCÊ FUGIU DO "+enemy.name+" !!");
                    anythingContinue();
                    break;
                }else{
                    printHeading("Você não conseguiu fugir!");
                    int dmgTook=enemy.attack();
                    System.out.println("Na sua corrida você tomou "+dmgTook+" de dano.");
                    anythingContinue();

                    if (player.hp<=0) {
                        playerDied();
                        break;
                    }
                }
            }
        }

    }

    public static void playerDied(){
        printHeading("VOCÊ MORREU...");
        printHeading("Na sua jornada você ganhou "+player.xp+" de xp!!");
        printHeading("Espero que tenha gostado do meu jogo.Tente novamente outra vez!");

        isRunning=false;
    }

    public static void characterInfo(){
        clearConsole();
        printHeading("STATUS");
        System.out.println(player.name+"\tHP: " +player.hp+"/"+player.max_hp);
        printSeparator(30);
        System.out.println("XP: "+player.xp);

        if ( player.numAtkUpgrades>0) {
            System.out.println("Traços de Ataque: "+player.atkupgrades[player.numAtkUpgrades-1]);
            printSeparator(30);
        }
        if (player.numDefUpgrades>0) {
            System.out.println("Traços de Defesa: "+player.defupgrades[player.numDefUpgrades-1]);
            printSeparator(30);
        }
        anythingContinue();
    }

    public static void printMenu(){
        clearConsole();
        printHeading("MENU");
        System.out.println("Escolha uma Opção: ");
        printSeparator(30);
        System.out.println("(1) Continue sua jornada ");
        System.out.println("(2) Status");
        System.out.println("(3) Sair");
    }
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-->",3);
            if (input==1) {
                continueJourney();
            }else if (input==2) {
                characterInfo();
            
            }else if (input==3){
                isRunning=false;
            }
        }
    }
}
