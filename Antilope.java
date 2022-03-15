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

    Savane savane;
    Antilope antilope = new Antilope(facteurCroissanceAntilopes);
    Antilope(double facteurCroissanceAntilopes ){
        super();
        this.facteurCroissanceAntilopes = facteurCroissanceAntilopes;
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
        antilope.naitre();
        return antilope;
    }

    @Override
    public void vieillir() {
       int age = antilope.getAge();
        age++;
        antilope.setAge(age);
        double masse = antilope.getMasse() * this.facteurCroissanceAntilopes;
        antilope.setMasse(masse);
    }
    

}
