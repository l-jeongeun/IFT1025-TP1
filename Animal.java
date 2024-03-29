import java.util.ArrayList;

// Fichier :     Animal.java
// Création:     
// Auteurs :      
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Animal
    implements the Prey/Predator relationship

**/
    
    

public class Animal implements ProiePredateur{
    private double facteurCroissance ;
    public Animal(){
        setMasse(10);

    }
    Herbe herbe;
    
    private int age;
    // current mass
    private double masse =10.0 ;
    //age auquel un animal devient mature
    private int ageMature;
    private boolean proie;
    private boolean predateur;
    private boolean vivant = true;

    //Animal animale = new Animal();

    public void setFacteur(double facteur){
        this.facteurCroissance = facteur;
    }

    public double getFacteur(){
        return this.facteurCroissance;
    }


    // animal eats
    public void manger(){
       
    }

    // antelope eats
    public void manger(Herbe herbe){
       herbe.setMasseAnnuelle(herbe.getMasseAnnuelle() - (2 * getMasse()));
    }

    // Lion eats
    public void manger(ArrayList<Animal> animal ){
       
    }

     // animal delivers
    public Animal accoucher(){        
        return new Animal(); 

    }
    // animal dies
    public void mourir(){
        this.vivant = false;

    }
    // animal is alive
    public boolean estVivant(){
        return this.vivant;
    }

    // animal is mature   
    public boolean estMature(){
        if (this.vivant && (this.age >= this.getAgeMature())){
            return true;
        }      
        return false;
        
    }

     // set animal mode to prey
    public void setProie( boolean proie ){
        this.proie = proie;   
    }

    // animal is a prey
    public boolean estProie(){
        return this.proie;
    }

    // set animal mode to predator
    public void setPredateur( boolean predateur ){
        this.predateur = predateur;

    }

    // animal is a predator
    public boolean estPredateur(){
        return this.predateur;
     
    }

     // get animal's mass
    public double getMasse(){
         return this.masse; 
        
    }
    // set animal's mass
    public void setMasse( double masse ){
        this.masse = masse;
    }
    // set animal's age
    public void setAge( int age ){
        this.age = age;

    }
    // get animal's age
    public int getAge(){
        return this.age;

    }
    // get animal's maximum age
    public int getAgeMax(){
        return 0;
        
    }
    // get animal's mature age
    public int getAgeMature(){
        return this.ageMature;
        
    }
    // animal is getting one year older
    public void vieillir() {
         this.age++;
         this.setMasse(this.getMasse() * getFacteur());
         if (this.age > this.getAgeMax()){
            this.vivant = false;
        } 
    }
     
}
