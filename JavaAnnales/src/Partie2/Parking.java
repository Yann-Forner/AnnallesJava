package Partie2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Parking implements Iterable<Vehicule>{


    private ArrayList<Place> places;
    public Parking() {
        places = new ArrayList<Place>();
    }
    public void ajouter(Place place) {
        places.add(place);
    }
    public ArrayList<Place> getPlaces() {
        return places;
    }
    public void garerVehicule(Strategy strat, Vehicule v){
        strat.stratGarerVehicule(v,this);
    }

    @Override
    public Iterator<Vehicule> iterator() {
        return new Iterator<Vehicule>() {
            private Place p=placeSuivante(LocalDate.MIN);

            @Override
            public boolean hasNext() {
                return (p != null);
            }

            @Override
            public Vehicule next() {
                if(p==null)return null;
                Vehicule res = p.getVehiculeGaree();
                p = placeSuivante(res.getDateArrivee());
                return res;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Place placeSuivante(LocalDate date) {
                Place actuelle = null;
                LocalDate actuelleDate = LocalDate.MAX;
                for (Place p : places) {
                    if (p.estLibre()) {
                        continue;
                    }
                    Vehicule v = p.getVehiculeGaree();
                    if(v.getDateArrivee().isAfter(date)&& v.getDateArrivee().isBefore(actuelleDate)){
                        actuelle=p;
                        actuelleDate=v.getDateArrivee();
                    }
                }
                return actuelle;
            }
        };
    }
}
