package Partie2;

public class StrategyPrix implements Strategy {
    public StrategyPrix() {
    }

    @Override
    public void stratGarerVehicule(Vehicule v,Parking park) {
        Place pTemp = park.getPlaces().get(0);
        for (Place p : park.getPlaces()) {
            if (p.getCoutJour() < pTemp.getCoutJour()){
                pTemp=p;
            }
        }
        pTemp.affecterVehicule(v);
    }
}
