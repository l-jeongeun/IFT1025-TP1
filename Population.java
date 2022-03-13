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
    private ArrayList<Animal> individus = new ArrayList<>(); // concatener proies et predateurs dans individus

    ArrayList<Animal> proies;
    ArrayList<Animal> predateurs;
    int nombreAntilopesMatures = 0;
    int nombreLionsMatures = 0 ;
    Antilope antilopes;
    Herbe herbe;
   

    public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {
	// A completer
	this.proies = proies;
    this.predateurs = predateurs;
    this.herbe = herbe;
	
    }

    // number of current preys
    public int getNombreProies(){
        return this.proies.size();
    }
    // number of current predators
    public int getNombrePredateurs(){
        return this.predateurs.size();

    }
    // number of current mature preys
    public int getNombreProiesMatures(){
        for( Animal a : this.proies ) {
            if( a.estMature() ) nombreAntilopesMatures++;               
        }
        return nombreAntilopesMatures;
    }
    // number of current mature predators
    public int getNombrePredateursMatures(){
        for( Animal a : this.proies ) {
            if( a.estMature() ) nombreLionsMatures++;               
        }
        return nombreLionsMatures;

    }
    // number of current chaseable preys
    public int getNombreProiesChassables(){
            

    }
    // current total mass of preys
    public double masseProies(){
        double masseTotale = 0;
        //get the mass of every prey
        for (int i = 0; i<this.proies.size(); i++){
           double masse = this.proies.get(i).getMasse();
            masseTotale += masse;
        }
        return masseTotale;

    }
    // current toral mass of predators
    public double massePredateurs(){
        double masseTotale = 0;
        //get the mass of every predator
        for (int i = 0; i<this.proies.size(); i++){
           double masse = this.proies.get(i).getMasse();
            masseTotale += masse;
        }
        return masseTotale;
    }
    // getting older
    public void vieillir(){
        herbe.vieillir();


    }
    // chasing
    public void chasser(){

        
    }
    // reproducing
    public void reproduire(){

    }
    // mix the list of animals
    public void melanger(){
        Collections.shuffle(this.animaux, new Random(4));
    }
        
    
}
