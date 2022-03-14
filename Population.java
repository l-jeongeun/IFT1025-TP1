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
    private ArrayList<Animal> individus = new ArrayList<>(); // contatener proies et predateurs
    Iterator<Animal> iterator = individus.iterator();
    ArrayList<Animal> proies;
    ArrayList<Animal> predateurs;
    int nombreAntilopesMatures = 0;
    int nombreLionsMatures = 0 ;
    Antilope antilope;
    Lion lion;
    Herbe herbe;
   

    public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {
	// A completer
	this.proies = proies;
    this.predateurs = predateurs;
    this.herbe = herbe;
	
    }
    
    public Iterator<Animal> iterator(){
        return this.individus.iterator();
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
        //seulement 20% des antilopes vivantes sont chassable
           int  nombreProiesVivante = 0;
           for( Animal a : this.proies ) {
            if( a.estVivant() ) nombreProiesVivante++;               
        }
        int nombreProiesChassable = (nombreProiesVivante*20)%100;
           return nombreProiesChassable;
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
        //l'herbe viellit
        herbe.vieillir();
        //les animaux vieillissent en ajoutant un an a leur age et s'ils ont atteint l'age max, ils meurt
        for( Animal a : this.individus ) {
            a.vieillir();
            if (a.getAge() > a.getAgeMax()){
                a.mourir();
            }               
        }
    }

    // chasing
    public void chasser(){

      
        

    }

    // reproducing
    public void reproduire(){
        // la moitie du nombre d'animaux matures sont femmelles et peuvent reproduire
        int nombreDeFemmellesAntilope = getNombreProiesMatures()/2;
        int nombreDeFemmellesLionne = getNombrePredateursMatures()/2;
        for (int i =0; i<nombreDeFemmellesAntilope; i++){
            this.proies.add(antilope.accoucher());
            antilope.naitre();
        }
        for (int i =0; i<nombreDeFemmellesLionne; i++){
            
            this.predateurs.add(lion.accoucher());
            lion.naitre();

        }
    }
    // mix the list of animals
    public void melanger(){
        Collections.shuffle(this.animaux, new Random(4));
    }
        
    
}
