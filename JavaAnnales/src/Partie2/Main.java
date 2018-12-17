package Partie2;

import java.time.LocalDate;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Parking monParking = new Parking();
// On cr´ee des places de parking avec des capacit´es
// et des prix al´eatoires
        for (int i = 0; i < 100; i++) {
            double capacite = new Random().nextDouble() * 10;
            double cout = new Random().nextDouble() * 25;
            monParking.ajouter(new Place(capacite, cout));
            monParking.ajouter(new Place(50,10000));
        }
        Vehicule v1,v2,v3,v4;
        v1 = new Vehicule(LocalDate.now(), "PP-989-KK");
        v2 = new Vehicule(LocalDate.of(2017, 3, 11),"BZ-201-CA");
        v3 = new Vehicule(LocalDate.of(2017, 3, 6), "AO-167-DP");
        v4 = new Vehicule(LocalDate.of(2017, 3, 1), "PP-989-KK");
        monParking.garerVehicule(new StrategyPrix(),v2);
        monParking.garerVehicule(new StrategyPrix(),v3);
        monParking.garerVehicule(new StrategyPrix(),v4);

        afficherEtatParking(monParking);

    }
    public static void afficherEtatParking(Parking p){
        /* Le code pour la question 3 */
        for (Vehicule v : p) {
            System.out.println(v);
        }

    }
}
