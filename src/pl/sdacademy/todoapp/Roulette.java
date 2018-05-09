package pl.sdacademy.todoapp;

import java.util.Random;

public class Roulette {

    int rouletteNumber;

    enum RouletteNumberColour {
        RED,
        BLACK,
        ZERO
    }

    RouletteNumberColour numberColour;

    enum Parity {
        EVEN,
        ODD,
        ZERO
    }

    Parity numberParity;

    enum Thirds {
        FIRSTTHIRD,
        SECONDTHIRD,
        THIRDTHIRD,
        ZERO
    }

    Thirds numberThird;

    Roulette() {
        ruletteNumber();
        setNumberParity();
        setNumberColour();
        setNumberThird();
    }

    private void setNumberParity() {
        if (this.rouletteNumber != 0) {
            if (this.rouletteNumber % 2 == 0) {
                this.numberParity = Parity.EVEN;
            } else this.numberParity = Parity.ODD;
        } else this.numberParity = Parity.ZERO;
    }

    private void setNumberColour() {
        switch (rouletteNumber) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 12:
            case 14:
            case 16:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 27:
            case 30:
            case 32:
            case 34:
            case 36:
                this.numberColour = RouletteNumberColour.RED;
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 20:
            case 22:
            case 24:
            case 26:
            case 28:
            case 29:
            case 31:
            case 33:
            case 35:
                this.numberColour = RouletteNumberColour.BLACK;
                break;
            default:
                this.numberColour = RouletteNumberColour.ZERO;
                break;
        }
    }

    private void setNumberThird() {
        if (this.rouletteNumber == 0) {
            this.numberThird = Thirds.ZERO;
        } else {
            if (this.rouletteNumber > 0 && this.rouletteNumber <= 12) {
                this.numberThird = Thirds.FIRSTTHIRD;
            } else if (this.rouletteNumber > 12 && this.rouletteNumber <= 24) {
                this.numberThird = Thirds.SECONDTHIRD;
            } else this.numberThird = Thirds.THIRDTHIRD;
        }
    }

    private void ruletteNumber() {
        Random number = new Random();
        this.rouletteNumber = number.nextInt(36);
    }

    public String toString() {
        return ("Ruletka pokazaała : Numer = " + this.rouletteNumber + "   Colour : " + this.numberColour + "   Parity : " + this.numberParity + "   Thirds : " + this.numberThird);
    }


    private static boolean gameOver(int capital) {
        if (capital <= 100) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        HumanGambler gambler = new HumanGambler(1000);
        System.out.println(gambler.toString());
        Roulette casino = new Roulette();
        System.out.println(casino.toString());
        gambler.loseOrWin(casino);
        while (!gameOver(gambler.moneyAmount)) {
            gambler = new HumanGambler(gambler.moneyAmount);
            System.out.println(gambler.toString());
            casino = new Roulette();
            System.out.println(casino.toString());
            gambler.loseOrWin(casino);
        }
        System.out.println("Przegrałeś i pozostało Ci " + gambler.moneyAmount + " złotych w kieszeni. Przyjdż jak zarobisz.");
    }
}
