package pl.sdacademy.todoapp;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private int numberOfGuesses = 0;

    GuessNumber() {
        int randomNumber = randomNumber();
        System.out.println("zgadujemy liczbę : " + randomNumber);
        int guessNumber = enteredNumber();
        numberOfGuesses = 1;
        while (randomNumber != guessNumber) {
            if (randomNumber > guessNumber) {
                System.out.println("Liczba mniejsza od zgadywanej.");
                System.out.println("Poprzednia liczna : " + guessNumber + " Podaj kolejną : ");
            } else {
                System.out.println("Liczba większa od zgadywanej.");
                System.out.println("Poprzednia liczna : " + guessNumber + "  Podaj kolejną : ");
            }
            guessNumber = enteredNumber();
            numberOfGuesses ++;
        }
        System.out.println("Brawo !! Zgadywana liczba to : " + randomNumber);
    }

    private int randomNumber() {
        Random generator = new Random();
        return generator.nextInt(100);
    }

    private int enteredNumber() {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Podaj liczbę : ");
        String scanner = scanInput.nextLine();
        return Integer.parseInt(scanner);
    }

    public static void main(String[] args) {
        GuessNumber guesses = new GuessNumber();
        System.out.println("Liczba prób zgadywania liczby = " + guesses.numberOfGuesses);
    }
}
