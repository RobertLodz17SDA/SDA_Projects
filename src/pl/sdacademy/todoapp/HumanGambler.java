package pl.sdacademy.todoapp;

import java.util.Scanner;

public class HumanGambler extends Roulette {
    int moneyAmount;
    private int bet[] = new int[4];

    HumanGambler(int money) {
        this.moneyAmount = money;
        for (int i = 0; i < this.bet.length; i++) {
            this.bet[i] = 0;
        }
        inputHumanBet();
    }

    public String toString() {
        return ("Obstawiłeś : Numer = " + this.rouletteNumber + "   Colour : " + this.numberColour + "   Parity : " + this.numberParity + "   Thirds : " + this.numberThird + "   Money : " + this.moneyAmount);
    }

    private void inputHumanBet() {
        betHumanNumber();
        betHumanColour();
        betHumanParity();
        betHumanThird();
        System.out.println("Na numer : " + this.rouletteNumber + " postawiłeś : " + this.bet[0] + " złotych");
        System.out.println("Na kolor : " + this.numberColour + " postawiłeś : " + this.bet[1] + " złotych");
        System.out.println("Na parzystość : " + this.numberParity + " postawiłeś : " + this.bet[2] + " złotych");
        System.out.println("Na tuzin : " + this.numberThird + " postawiłeś : " + this.bet[3] + " złotych");
        System.out.println();
    }

    private int betGamblerMoney() {
        int betAmount = 0;
        for (int e : this.bet) {
            betAmount += e;
        }
        System.out.println("Obstawiana kwota : ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int nowBet = scanner.nextInt();
            if ((betAmount + nowBet) > this.moneyAmount) {
                System.out.println("Kwota zakładu większa od posiadanych pieniędzy. Podaj obstawianą kwotę : ");
            } else return nowBet;
        }
    }

    private void betHumanThird() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Obstaw tercję (1 - PIERWSZA, 2 - DRUGA, 3 - TRZECIA) : ");
        while (true) {
            switch (scanner.nextInt()) {
                case 1:
                    this.numberThird = Thirds.FIRSTTHIRD;
                    this.bet[3] = betGamblerMoney();
                    return;
                case 2:
                    this.numberThird = Thirds.SECONDTHIRD;
                    this.bet[3] = betGamblerMoney();
                    return;
                case 3:
                    this.numberThird = Thirds.THIRDTHIRD;
                    this.bet[3] = betGamblerMoney();
                    return;
                default:
                    System.out.println("Nieprawidłowy numer. podaj jeszcze raz : ");
            }
        }

    }

    private void betHumanParity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Obstaw parzystość (1 - PARZYSTE, 2 - NIEPARZYSTA) : ");
        while (true) {
            switch (scanner.nextInt()) {
                case 1:
                    this.numberParity = Parity.EVEN;
                    this.bet[2] = betGamblerMoney();
                    return;
                case 2:
                    this.numberParity = Parity.ODD;
                    this.bet[2] = betGamblerMoney();
                    return;
                default:
                    System.out.println("Nieprawidłowy numer. podaj jeszcze raz : ");
            }
        }

    }

    private void betHumanColour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Obstaw kolor (1 - RED, 2 - BLACK) : ");
        while (true) {
            ;
            switch (scanner.nextInt()) {
                case 1:
                    this.numberColour = RouletteNumberColour.RED;
                    this.bet[1] = betGamblerMoney();
                    return;
                case 2:
                    this.numberColour = RouletteNumberColour.BLACK;
                    this.bet[1] = betGamblerMoney();
                    return;
                default:
                    System.out.println("Nieprawidłowy numer. podaj jeszcze raz : ");
            }
        }
    }

    private void betHumanNumber() {
        int scannerIn;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Obstaw numer : ");
            scannerIn = scanner.nextInt();
            if (scannerIn >= 0 && scannerIn <= 36) {
                this.rouletteNumber = scannerIn;
                this.bet[0] = betGamblerMoney();
                break;
            } else {
                System.out.print("Podano nieprawidłowy numer. proszę o podanie numeru od 0 do 36 :");
            }
        }
    }

    public void loseOrWin(Roulette casino) {
        int wonOrLostMoney = this.moneyAmount;
        System.out.println();
        System.out.println("Rozpoczynając obstawianie miałeś " + wonOrLostMoney + " złotych gotówki");
        System.out.print("W ruletkę ");
        if (this.rouletteNumber == casino.rouletteNumber) {
            wonOrLostMoney += 35 * this.bet[0];
        } else wonOrLostMoney -= this.bet[0];
        if (this.numberColour == casino.numberColour) {
            wonOrLostMoney += this.bet[1];
        } else wonOrLostMoney -= this.bet[1];
        if (this.numberParity == casino.numberParity) {
            wonOrLostMoney += this.bet[2];
        } else wonOrLostMoney -= this.bet[2];
        if (this.numberThird == casino.numberThird) {
            wonOrLostMoney += 2 * this.bet[3];
        } else wonOrLostMoney -= this.bet[3];
        if (wonOrLostMoney > this.moneyAmount) {
            System.out.println("wygrałeś" + (wonOrLostMoney - this.moneyAmount) + " złotych");
        } else System.out.println("przegrałeś " + (this.moneyAmount - wonOrLostMoney) + " złotych");
        this.moneyAmount = wonOrLostMoney;
        System.out.println("Pozostało ci " + this.moneyAmount + " złotych gotówki");
    }
}