
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
    private double facteurCroissanceAnimal ;
    public Animal(){
    }
    
    private int age;
    private int nombreDanimaux = 0;//*************************
    // current mass
    private double masse ;
    ;
    //obtenir l'age max de l'animal
    private int ageMax ;
    //age auquel un animal devient mature
    private int ageMature;
    private boolean proie;
    private boolean predateur;
    Animal animale = new Animal();

    // animal becomes alive
    public void naitre(){
        
        animale.setAge(0);
        animale.estVivant(); 
        nombreDanimaux++;
       
             
    } 
    // animal is getting one year older
    public void vieillir(){
        this.age += 1;
        this.masse = getMasse() * facteurCroissanceAnimal;
        
    }

    // animal eats
    public void manger(){
          // A completer          
    
        
    }

     // animal delivers
    public Animal accoucher(){
        
        return new Animal(); 

    }
    // animal dies
    public void mourir(){
        nombreDanimaux--;
        //!animale.estVivant();

    }
    // animal is alive
    public boolean estVivant(){
        return true;
    }

    // animal is mature   
    public boolean estMature(){
        if (animale.getAge() == animale.getAgeMature()){
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
        // si l'animal a ete set une proie on retourne true
       if(this.proie){
           return true;
       }
        return false;
    }
    // set animal mode to predator
    public void setPredateur( boolean predateur ){
        this.predateur = predateur;

    }
    // animal is a predator
    public boolean estPredateur(){
        if(this.predateur){
            return true;
        }
        return false;
     
    }

     // get animal's mass
    public double getMasse(){
         return masse; 
        
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
}
