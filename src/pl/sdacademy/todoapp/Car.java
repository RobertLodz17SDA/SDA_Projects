package pl.sdacademy.todoapp;

import java.util.*;
import java.util.stream.Collectors;

public class Car {

    private String markaIModel;
    private String kolor;
    private int predkosc;

    Car(String markaIModel, String kolor, int predkosc){
        this.markaIModel = markaIModel;
        this.kolor = kolor;
        this.predkosc = predkosc;
    }

    private String getMarkaIModel() {
        return markaIModel;
    }

    public String getKolor() {
        return kolor;
    }

    public int getPredkosc() {
        return predkosc;
    }

    public String toString(){
        String string = "|"+ kolor+ " "+markaIModel+"|";
        return string;
    }

    public static void main(String[] args) {
        List<Car> bazaSamochodow = new ArrayList<>();
        bazaSamochodow.add(new Car("Ford Mondeo", "Czarny", 180));
        bazaSamochodow.add(new Car("Toyota Prius", "Czarny", 200));
        bazaSamochodow.add(new Car("Toyota Prius", "Czerwony", 200));
        bazaSamochodow.add(new Car("BMW 5", "Biały", 220));
        bazaSamochodow.add(new Car("BMW 5", "Czarny", 220));
        bazaSamochodow.add(new Car("Ford Mondeo", "Czarny", 180));
        bazaSamochodow.add(new Car("BMW 3", "Czarny", 190));
        bazaSamochodow.add(new Car("BMW 3", "Zielony", 190));
        bazaSamochodow.add(new Car("Ford Mondeo", "Czarny", 240));

        bazaSamochodow.stream() // odfiltrowanie czarnych
                .filter(element->element
                .kolor=="Czarny")
                .forEach(e->System.out.println("Czarny jest : "+e.markaIModel));

        System.out.println();

        bazaSamochodow.stream() // posortowanie po kolorach
                .sorted(Comparator.comparing(e->e.kolor))
                .forEach(e->System.out.println("Samochody w kolorach "+e.kolor+e.markaIModel));

        System.out.println();

        bazaSamochodow.stream() // odfiltrować w nazwie "M"
        .filter(e->e.markaIModel.contains("M")).forEach(e->System.out.println("Odfiltrowana marka : "+e.markaIModel));

        Map<Car,String> map=bazaSamochodow.stream() // odfiltrować w nazwie "M"
                .filter(e->e.markaIModel.contains("M"))
                .collect(Collectors.toMap(k->k, v->v.getMarkaIModel()));
        System.out.println(map.values());
    }
}