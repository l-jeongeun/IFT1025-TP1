import java.util.ArrayList;

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
    private ArrayList<Animal> nourriture = new ArrayList<>(); 
    Population pop ;
    Lion(double facteurCroissanceLions ){
        super();
        this.setFacteur(facteurCroissanceLions);
        setProie(false);
        setPredateur(true);
        setAge(0);

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
    
    
}
