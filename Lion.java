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
        setPredateur(true);
    }
    Population population;
    Antilope antilope;
    Lion lion = new Lion(facteurCroissanceLions);

    @Override
    public int getAgeMax() {
        return 50;
    }
    public int AGEMAX = getAgeMax();
    

    @Override
    public int getAgeMature() {
        return 5;
    }
    @Override
    public Animal accoucher() {
        lion.naitre();
        return lion;

    }
    public void manger() {// Un Lion mange des antilopes equivalent a deux fois sa masse
       // calcul du double de la masse du lion 
        double doubleMassePredateur = lion.getMasse() *2;
        //masse totale antilope - le double de la masse du lion = nouvelle masse des antilopes
        double nouvelleMasseAntilopes = population.masseProies() - doubleMassePredateur ;
        antilope.setMasse(nouvelleMasseAntilopes);
    }
    @Override
    public void vieillir() {
       int age = lion.getAge();
        age++;
        lion.setAge(age);
        double masse = lion.getMasse() * this.facteurCroissanceLions;
        lion.setMasse(masse);
    }
}
