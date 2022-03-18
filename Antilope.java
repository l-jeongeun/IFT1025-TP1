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
    public static final int AGEMAX = 15;

    Antilope(double facteurCroissanceAntilopes ){
        super(facteurCroissanceAntilopes);
    }

    
    // animal becomes alive
    public void naitre(){
        this.ageMax = Antilope.AGEMAX;
        this.ageMature = 2;
        this.setProie(true);
        this.setPredateur(false);
    }    
    
    public Animal accoucher(){
        return new Antilope(this.facteurCroissance); 
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
