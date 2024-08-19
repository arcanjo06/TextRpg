package main;

public class Story {
    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printHeading("HISTÓRIA");
        System.out.println("12 de Setembro de 1987");
        GameLogic.printSeparator(30);
        System.out.println("Tudo andava aparentemente bem, quando de repende uma doença parecida com a peste negra");
        System.out.println("Começa a assolar todo o litoral sul-americano, se espalhando rapidamente pela volatilidade do virus");
        System.out.println("Em poucas semanas já tinha matado quase 400 mil pessoas, e só se espalhava cada vez mais, até que");
        System.out.println("Os Mortos começaram a se levantar, o que no inicio parecia milagre, se tornou uma maldição.");
        System.out.println("Segundo boatos, dizem que estão tentando desenvolver uma cura em Guaretinguetá, recomendaram que todas as pessoas fossem pra lá, e esse é seu objetivo.");
        GameLogic.anythingContinue();
    }
    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printHeading("CARUARU-PE");
        System.out.println("15 de Outubro de 1987-2500km restantes");
        GameLogic.printSeparator(30);
        System.out.println("Primeiro dia de percurso, será um caminho difícil pelos mortos ambulantes, mas você e seu grupo acreditam.");
        System.out.println("Firme na estrada, o objetivo do seu grupo é chegar inteiro na Bahia, até la tem muita coisa pra ocorrer...");
        GameLogic.anythingContinue();
    }

    public static void printFirstActEnd(){
        GameLogic.clearConsole();
        GameLogic.printHeading("JEREMOABO-BA");
        System.out.println("17 de Outubro de 1987-2130km restantes");
        GameLogic.printSeparator(30);
        System.out.println("Vocês adentraram a Bahia, os tipos de monstros parecem ser diferentes nesse local.");
        System.out.println("Apesar de todos os problemas na viagem, vocês estão bem de suprimentos");
        System.out.println("Ao passar pelas cidades você nota a destruição tomando conta de tudo.");
        System.out.println("Vocês resolvem acampar nesse local e esperar um certo tempo até ir para estrada de novo");
        GameLogic.anythingContinue();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printHeading("JEREMOABO-BA");
        System.out.println("18 de Outubro de 1987-2130km restantes");
        GameLogic.printSeparator(30);
        System.out.println("Vocês se recuperam e vão em busca da estrada de novo.");
        System.out.println("Dessa vez o objetivo de vocês é chegar até Vitoria da Conquista, vai ser outro grande percurso.");
        GameLogic.anythingContinue();
    }

    public static void printSecondActEnd(){
        GameLogic.clearConsole();
        GameLogic.printHeading("VITORIA DA CONQUISTA-BA");
        System.out.println("23 de Outubro de 1987-1429km restantes");
        GameLogic.printSeparator(30);
        System.out.println("Essa viagem foi totalmente desgastante e demorada, vocês não pretendem ir a estrada tão cedo");
        System.out.println("A gasolina está acabando e vocês decidem parar num posto, aparentemente seguro.");
        System.out.println("Nesse local que vocês provavelmente vão acampar.");
        GameLogic.anythingContinue();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printHeading("VITORIA DA CONQUISTA-BA");
        System.out.println("27 de Outubro de 1987-1427km restantes");
        GameLogic.printSeparator(30);
        System.out.println("Depois de quase uma semana, vocês decidem ir embusca de chegar em Caratinga-MG, vai ser uma viagem ainda mais longa.");
        System.out.println("Vocês juntam as coisas e partem para uma maçante viagem.");
        GameLogic.anythingContinue();
    }

    public static void printThirdActEnd(){
        GameLogic.clearConsole();
        GameLogic.printHeading("CARATINGA-MG");
        System.out.println("01 de Novembro de 1987-800km restantes");
        GameLogic.printSeparator(30);
        System.out.println("Vocês resolvem parar de vez, o carro já não aguenta mais.");
        System.out.println("Com algumas ferramentas encontradas em um posto vocês ficam e consertam o carro, mas felizmente chegaram.");
        System.out.println("Está perto do destino final, mas ainda falta muito chão para chegar no local marcado, então vocês descansam apenas 2 dias e partem quando o carro voltou a funcionar.");
        GameLogic.anythingContinue();
    }
    public static void printEndAct(Player player){
        GameLogic.clearConsole();
        GameLogic.printHeading("GUARATINGUETÁ-SP");
        System.out.println("06 de Novembro de 1987-VOCÊS CHEGARAM NO DESTINO!!");
        GameLogic.printSeparator(30);
        System.out.println("Chegando na cidade, vocês reparam que está tudo assustadoramente destruido.");
        System.out.println("Todos entram em choque, alguns até choram sem ter esperança");
        System.out.println("Mas,você "+player.name+" mesmo abalado, resolve dar um discurso de fé, dizendo que era possivel sobreviver nesse mundo, mesmo nessa situação, e que juntos irão criar um mundo novo...");
        GameLogic.anythingContinue();
    }
}
