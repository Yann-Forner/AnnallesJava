package Partie2;

public class StrategyC implements Strategy {

    public StrategyC() {
    }

    @Override
    public void stratGarerVehicule(Vehicule v, Parking park) {
        Place pTemp = park.getPlaces().get(0);
        for (Place p: park.getPlaces()) {
            if(p.getCapacite() > pTemp.getCapacite()){
                pTemp=p;
            }
        }
        pTemp.affecterVehicule(v);
    }
}
