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
    public static final int AGEMAX = 50;
    Lion(double facteurCroissanceLions ){
        super();
        this.setFacteur(facteurCroissanceLions);
        setProie(false);
        setPredateur(true);

    }
    


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
        return new Lion(getFacteur());

    }
    /*
    public void manger() {// Un Lion mange des antilopes equivalent a deux fois sa masse
       // calcul du double de la masse du lion 
        double doubleMassePredateur = lion.getMasse() *2;
        //masse totale antilope - le double de la masse du lion = nouvelle masse des antilopes
        double nouvelleMasseAntilopes = population.masseProies() - doubleMassePredateur ;
        antilope.setMasse(nouvelleMasseAntilopes);
    }*/
    
}

