
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
    protected double facteurCroissance ;
    private int age;
    protected int ageMax;
    // current mass
    private double masse;
    //age auquel un animal devient mature
    protected int ageMature;
    private boolean proie;
    private boolean predateur;
    private boolean vivant = true;

    public Animal(double facteurCroissance){
        this.facteurCroissance = facteurCroissance;
        this.setMasse(10);
        this.setAge(0);
        this.naitre();
    }
    
    //Animal animale = new Animal();

    public void setFacteur(double facteur){
        this.facteurCroissance = facteur;
    }

    public double getFacteur(){
        return this.facteurCroissance;
    }

    // animal becomes alive
    public void naitre(){

    } 
    

    // animal eats
    public void manger(){
          // A completer          
    
        
    }

     // animal delivers
    public Animal accoucher(){
        return new Animal(this.facteurCroissance); 
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
        return this.estVivant() && this.getAge() >= this.getAgeMature();
    }

     // set animal mode to prey
    public void setProie( boolean proie ){
        this.proie = proie;
    }

    // animal is a prey
    public boolean estProie(){
        // si l'animal a ete set une proie on retourne true
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
        return this.ageMax;
    }

    // get animal's mature age
    public int getAgeMature(){
        return this.ageMature;
    }

    // animal is getting one year older
    public void vieillir() {
         this.age++;
         this.setMasse(this.getMasse() * getFacteur());
         
         if (this.getAge() > this.getAgeMax()){
             this.mourir();
         } 
     }
}
