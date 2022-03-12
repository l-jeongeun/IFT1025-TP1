// Fichier :     Lion.java
// Création:     
// Auteurs :
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Lion
    extends Animal

**/

public class Lion extends Animal {
    double facteurCroissanceLions;
    Lion(double facteurCroissanceLions ){
        super();
        this.facteurCroissanceLions = facteurCroissanceLions;
        setProie(false);
    }
    EcoSysteme ecosystem;
    Antilope antilopes;

    @Override
    public int getAgeMax() {
        return 50;
    }
    @Override
    public int getAgeMature() {
        return 5;
    }
    @Override
    public Animal accoucher() {
        return new Lion(facteurCroissanceLions);
    }
    public void manger() {// Un Lion mange des antilopes equivalent a deux fois sa masse
       // calcul la masse de chaque predateur et multiplie par deux pour doubler
        double doubleMasseParPredateur = (ecosystem.massePredateurs()/ ecosystem.getNombrePredateurs()) *2;
        double nouvelleMasseDesAntilopes = ecosystem.masseProies() - doubleMasseParPredateur ;
        antilopes.setMasse(nouvelleMasseDesAntilopes);
    }
}

