import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        Random generator = new Random();
        Scanner readKeyboard = new Scanner(System.in);
        int choicePlayExit;

        do {
            String options = """ 
                Escolha uma das opções abaixo:
                    1 - Jogar
                    0 - Sair
                """;

            System.out.print(options);
            System.out.print("\nSua Escolha: ");
            choicePlayExit = readKeyboard.nextInt();

            int randomNumber = generator.nextInt(1, 100);
            int limitChoices = 1;

            switch (choicePlayExit) {
                case 1:
                    while (true) {
                        System.out.print("Qual é o número sorteado? Resposta: ");
                        int choiceNumber = readKeyboard.nextInt();

                        if (choiceNumber == randomNumber) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("\nPARABÉNS!!!, Você acertou o número " + choiceNumber + " com " + limitChoices + " Tentativa(s) :)");
                            break;
                        } else if (limitChoices == 8) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("\nInfelizmente você esgotou suas " + limitChoices + " Tentativas :(\nTente Novamente\n");
                            break;
                        }

                        if (randomNumber > choiceNumber)
                            System.out.println("O número sorteado é maior que " + choiceNumber + "\n");
                        else {
                            System.out.println("O número sorteado é menor que " + choiceNumber + "\n");
                        }
                        limitChoices++;
                    }
                    break;

                case 0:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Saiu do jogo");
                    readKeyboard.nextLine();
                    readKeyboard.close();
                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    continue;
            }
        } while (choicePlayExit != 0);
    }
}