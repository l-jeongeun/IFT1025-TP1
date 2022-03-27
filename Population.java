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
import java.lang.Math;

// Defines a population of herb and animals (preys and predators), iterable
public class Population implements EcoSysteme, Iterable<Animal> {
    private ArrayList<Animal> individus = new ArrayList<>(); // concatener proies et predateurs
    int nombreAntilopesMatures = 0;
    int nombreLionsMatures = 0 ;
    Herbe herbe;
    

    
   

    public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {
        // A completer
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
    public int getNombreProies()
    {
        int count = 0;
        for(Animal a : this.individus) {
            if(a.estProie() && a.estVivant())    count++;
        }
        return count;
    }

    // number of current predators
    public int getNombrePredateurs()    
    {
        int count = 0;
        for(Animal a : this.individus) {
            if(a.estPredateur() && a.estVivant())    count++;
        }
        return count;
    }

    // number of current mature preys
    public int getNombreProiesMatures(){
        for( Animal a : this.individus ) {
            if( a.estProie() && a.estVivant() && a.estMature() ) nombreAntilopesMatures++;               
        }
        return nombreAntilopesMatures;
    }

    // number of current mature predators
    public int getNombrePredateursMatures(){
        for( Animal a : this.individus ) {
            if( a.estPredateur() && a.estVivant() && a.estMature() ) nombreLionsMatures++;               
        }
        return nombreLionsMatures;
    }

    // number of current chaseable preys
    public int getNombreProiesChassables()
    {
        //seulement 20% des antilopes vivantes sont chassable
        int  nombreProiesVivante = 0;
        for( Animal a : this.individus ) {
            if( a.estProie() && a.estVivant() ) nombreProiesVivante++;               
        }

        int nombreProiesChassable = (int)Math.floor(nombreProiesVivante*0.2);
           
        return nombreProiesChassable;
    }

    // current total mass of preys
    public double masseProies(){
        double masseTotale = 0;
        //get the mass of every prey
        for( Animal a : this.individus ) {
            if(!a.estProie() || !a.estVivant()) continue;

            double masse = a.getMasse();
            masseTotale += masse;
        }

        return masseTotale;
    }

    // current toral mass of predators
    public double massePredateurs(){
        double masseTotale = 0;
        //get the mass of every predator
        for( Animal a : this.individus ) {
            if(!a.estPredateur() || !a.estVivant()) continue;

            double masse = a.getMasse();
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
        }
        retirerAnimauxMorts();
    }

    // chasing
    public void chasser()
    {
        melanger();
        int nombreDeProiesChassees = 0;
        int chassable = this.getNombreProiesChassables();
        for( Animal a : this.individus ) {
            if (!a.estVivant()) {
                continue;
            }

            //si c'est un predateur on fait manger le predateur
            if( a.estPredateur()){
                //iterer a travers la list
                double totalMasseAntilopeMangee = 0;
                double doubleMassePredateur = a.getMasse() *2;
                int i = 0 ;
                

                for(Animal b : this.individus) {
                    if((totalMasseAntilopeMangee >= doubleMassePredateur) ||
                        (i >= this.individus.size()) || 
                        (nombreDeProiesChassees >= chassable))   break;

                    if (b.estProie() && b.estVivant()){
                        totalMasseAntilopeMangee += b.getMasse();
                        nombreDeProiesChassees++;
                        //individus.remove(i);
                        b.mourir();
                    }
                }

                //si le lion n'a pas mangE la masse suffisante elle meurt
                if (totalMasseAntilopeMangee < doubleMassePredateur){
                    a.mourir();
                }
              
            } else{
                // sinon on fait manger l'antilope
                //une antilope doit manger 2 fois sa masse d’herbe 
                
                //ou manger
                //A completer
                // s'il ya pas assez d'herbe l'antilope meurt
                if(this.herbe.getMasseAnnuelle() >= a.getMasse() *2){
                    //this.masseAnnuelle = 0.6 * this.masse;
                    double nouvelleMasseHerbe = this.herbe.getMasseAnnuelle() - (2 * a.getMasse()) ;
                    this.herbe.setMasseAnnuelle(nouvelleMasseHerbe);
                } else{
                   a.mourir();
                }
            }                          
        }             
        retirerAnimauxMorts();
    }
    
    public ArrayList<Animal> getIndividus(){
        return this.individus;
    }

    // reproducing

    // public void reproduire(){
    //     // la moitie du nombre d'animaux matures sont femmelles et peuvent reproduire
    //     int nombreDeFemmellesAntilope = getNombreProiesMatures()/2;
    //     int nombreDeFemmellesLionne = getNombrePredateursMatures()/2;
    //     for (int i =0; i<nombreDeFemmellesAntilope; i++){
    //     this.individus.add(new Animal());// new antilope
        
   
    // }
    // for (int i =0; i<nombreDeFemmellesLionne; i++){
    
    //      this.individus.add(new Animal());//new Lion // accoucher
    // }
        
    // }

    public void reproduire()
    {
	    ArrayList<Animal> proies = new ArrayList<>();
	    ArrayList<Animal> predateurs = new ArrayList<>();

	    boolean femelleLionne = false;
	    boolean femelleaAntilope = false;
	    for(Animal animal : this.individus) {
            if(animal.estVivant() && animal.estMature()) {
                if(animal.estPredateur()) {
                    if(femelleLionne) {
                        Lion lion = (Lion)animal.accoucher();
                         predateurs.add(lion);
                     }
                     femelleLionne = !femelleLionne;
                } else if(animal.estProie()) {
                    if(femelleaAntilope) {
                        Antilope antilope = (Antilope)animal.accoucher();
                        proies.add(antilope);
                    }
                    femelleaAntilope = !femelleaAntilope;
                }
            }
        }

        for(Animal animal : proies) this.individus.add(animal);
        for(Animal animal : predateurs) this.individus.add(animal);
        retirerAnimauxMorts();
    }




    // mix the list of animals
    public void melanger(){
        Collections.shuffle(this.individus, new Random(4));
    }   

    public void retirerAnimauxMorts(){
        for(int i = this.individus.size() - 1; i >= 0; --i) {
            if((!this.individus.get(i).estVivant())){
                this.individus.remove(i);
            }
        }
    }
}


