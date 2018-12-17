package Partie2;

public class StrategyConfort implements Strategy {
    private Integer d;
    public StrategyConfort(Integer d) {
    this.d=d;
    }

    @Override
    public void stratGarerVehicule(Vehicule v, Parking park) {
        Place pTemp = park.getPlaces().get(0);
        for (Place p : park.getPlaces()) {
            if (p.getCoutJour() < pTemp.getCoutJour() && p.getCapacite() > d){
                pTemp=p;
            }
        }
        pTemp.affecterVehicule(v);
    }
}
