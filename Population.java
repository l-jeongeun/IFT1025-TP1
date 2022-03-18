// Fichier :     Population.java
// Création:     
// Auteurs :     
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Population
    implements EcoSysteme, Iterable<Animal>

**/

import java.util.Iterator;
import java.lang.Iterable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

// Defines a population of herb and animals (preys and predators), iterable
public class Population implements EcoSysteme, Iterable<Animal> {
    private ArrayList<Animal> individus = new ArrayList<>(); // concatener proies et predateurs
   
    int nombreAntilopesMatures;
    int nombreLionsMatures  ;
    Herbe herbe;
    //ArrayList<Animal> maturesProies = new ArrayList<>();
   // ArrayList<Animal> maturesPredateurs = new ArrayList<>(); 

    public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {
	
    this.herbe = herbe;

    for(int i = 0; i<(proies.size()); i++){
        this.individus.add(proies.get(i));
    }
    for(int i = 0; i<(predateurs.size()); i++){
        this.individus.add(predateurs.get(i));
    }
    
    }
    
    public Iterator<Animal> iterator(){
        return this.individus.iterator();
    }
    
    // number of current preys
    public int getNombreProies(){
        int nombreDeProies = 0;
        for( Animal a : this.individus ) {
            if(a.estProie() & a.estVivant()){
                nombreDeProies++;
            }
        }

        return nombreDeProies;
    }

    // number of current predators
    public int getNombrePredateurs(){
        int nombreDePredateurs = 0;
        for( Animal a : this.individus ) {
            if(a.estPredateur() & a.estVivant()){
                nombreDePredateurs++;
            }
        }

        return nombreDePredateurs;
    }

    // number of current mature preys
    public int getNombreProiesMatures(){
        nombreAntilopesMatures = 0;
        for( Animal a : this.individus ) {
            if( a.estMature() & a.estVivant() & a.estProie()) {
                nombreAntilopesMatures++; 
                //on ajoute les proies a l'arraylist maturesProies
                
            }              
        }
        //System.out.println(this.nombreAntilopesMatures+"Antilope mature");
        return nombreAntilopesMatures;
    }

    // number of current mature predators
    public int getNombrePredateursMatures(){
        nombreLionsMatures = 0;
        for( Animal a : this.individus) {
            if( a.estMature()  & a.estVivant() & a.estPredateur()) {
                nombreLionsMatures++;
                
                //this.maturesPredateurs.add(a);
            }               
        }
        return nombreLionsMatures;
    }

    // number of current chaseable preys
    public int getNombreProiesChassables(){
        //seulement 20% des antilopes vivantes sont chassables  
        int nombreProiesChassable = (getNombreProies()*20)/100;//********************************
           return nombreProiesChassable;
    }
    
    // current total mass of preys
    public double masseProies(){
        double masseTotale = 0;
        //get the mass of every prey
        for( Animal a : individus ) {
            if(a.estProie()){   
           double masse = a.getMasse();
            masseTotale += masse;
        }
        }
        return masseTotale;
    }

    // current toral mass of predators
    public double massePredateurs(){
        double masseTotale = 0;
        //get the mass of every predator
        for( Animal a : individus ) {
            if(a.estPredateur()){   
           double masse = a.getMasse();
            masseTotale += masse;
            }
        }
        return masseTotale;
    }

    // getting older
    public void vieillir(){
        //l'herbe viellit
        herbe.vieillir();
        //les animaux vieillissent en ajoutant un an a leur age et s'ils ont atteint l'age max, ils meurt
        for( Animal a : this.individus ) {
            a.vieillir();
            //si l'animal atteint l'age max il meurt
            if (a.getAge() > a.getAgeMax()){
                a.mourir();
            }               
        }
    }

    // chasing
    public void chasser(){
        melanger();
        int nombreDeProiesChassees = 0;
        for( Animal a : this.individus ) {
            //si c'est un predateur on fait manger le predateur
            if( a.estPredateur() &a.estVivant()){
                //iterer a travers la list
                double totalMasseAntilopeMangee = 0;
                double doubleMassePredateur = a.getMasse() *2;
                int i = 0 ;
                
                while((totalMasseAntilopeMangee<doubleMassePredateur) & (i <this.individus.size()) & (nombreDeProiesChassees < getNombreProiesChassables())){
                    //iterer a travers la list tant q on a pas atteint la masse de nourriture necessaire
                    if (individus.get(i).estProie()){
                        totalMasseAntilopeMangee += individus.get(i).getMasse();
                        nombreDeProiesChassees++;
                        //individus.remove(i);
                        individus.get(i).mourir();
                        i++;
                    }
                    i++;
                }
                //si le lion n'a pas mangE la masse suffisante elle meurt
                if (totalMasseAntilopeMangee<doubleMassePredateur){
                    a.mourir();
                }
                
              
            }
            // sinon on fait manger l'antilope
            else if (a.estProie()& a.estVivant()){
      
                //une antilope doit manger 2 fois sa masse d’herbe s'il ya pas assez d'herbe l'antilope meurt
                if(this.herbe.getMasse() > 0){
                    this.herbe.setMasse(herbe.getMasse() - (2 * a.getMasse()));
                }
                else{
                   a.mourir();
                }

                }                          
        }             

    }
    
    // reproducing
    public void reproduire(){
        // la moitie du nombre d'animaux matures sont femmelles et peuvent reproduire
        int femmelleProies = getNombreProiesMatures()/2;
        int femmellePredateurs = getNombrePredateursMatures()/2;

        for(int i = 0; i<this.individus.size(); i++){
            if(this.individus.get(i).estProie() & this.individus.get(i).estVivant()& femmelleProies>0 &this.individus.get(i).estMature()){
                this.individus.add(this.individus.get(i).accoucher());
                femmelleProies--;
            }
            else if( this.individus.get(i).estPredateur() & this.individus.get(i).estVivant()& femmellePredateurs>0 &this.individus.get(i).estMature()){
                this.individus.add(this.individus.get(i).accoucher());
                femmellePredateurs--;
            }
        }    

        //System.out.println(getNombrePredateurs()+"predateurs");
        

        
    }

    // mix the list of animals
    public void melanger(){
        Collections.shuffle(this.individus, new Random(4));
    }   
    public ArrayList<Animal> getIndividus(){
        
        return this.individus;
    }
}
