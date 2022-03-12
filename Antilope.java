// Fichier :     Antilope.java
// Création:     
// Auteurs :     
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Antilope
    extends Animal

**/

public class Antilope extends Animal {
    double facteurCroissanceAntilopes;
    Herbe herbe;
    EcoSysteme ecosystem;
    Savane savane;
    Antilope(double facteurCroissanceAntilopes ){
        super();
        this.facteurCroissanceAntilopes = facteurCroissanceAntilopes;
        setProie(true);

    }
    
    @Override
    public int getAgeMax() {
        return 15;
    }
    @Override
    public int getAgeMature() {
        return 2;
    }
    
    @Override
    public Animal accoucher() {
        return new Antilope(facteurCroissanceAntilopes);
    }
    @Override
    public void manger() {
        double nouvelleMasseHerbe = herbe.getMasse() - (2 * ecosystem.masseProies()) ;
        herbe.setMasse(nouvelleMasseHerbe);

    }


}
