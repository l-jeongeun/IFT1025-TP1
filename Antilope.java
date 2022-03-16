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
    Herbe herbe;
    Savane savane;
    public static final int AGEMAX = 15;
    Antilope(double facteurCroissanceAntilopes ){
        super();
        this.setFacteur(facteurCroissanceAntilopes);
        setProie(true);
        setPredateur(false);       
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
        
        return new Antilope(getFacteur());
    }
    /*
    @Override
    public void manger() {
        double nouvelleMasseHerbe = herbe.getMasse() - (2 * antilope.getMasse()) ;
        herbe.setMasse(nouvelleMasseHerbe);

    }*/
    /*
    @Override
    public void vieillir() {
       int age = this.getAge();
        age++;
        this.setAge(age);
        double masse = this.getMasse() * this.facteurCroissanceAntilopes;
        this.setMasse(masse);
    }
    */

}
