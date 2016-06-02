/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import java.util.*;

/**
 *
 * @author hugo.talbot
 */
public class Echiquier implements BoardGames {

    protected Jeu jeublanc;
    protected Jeu jeunoir;
    protected Jeu jeucourant;
    private String message;

    public Echiquier() {
        this.jeublanc=new Jeu(Couleur.BLANC);
        this.jeunoir=new Jeu(Couleur.NOIR);
        this.jeucourant=jeublanc;
    }
    
    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    

           


           
    public List <PieceIHMs> getPiecesIHM() {
        
        //créer une liste de piècesHIM et le remplir avec les listes de pièces de jeublanc et jeunoir
        List<PieceIHMs> listeIHM = new LinkedList<PieceIHMs>();
        listeIHM.addAll(jeublanc.getPiecesIHM());
        listeIHM.addAll(jeunoir.getPiecesIHM());
                
        return listeIHM;
    }
           

           
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        /*
        s'il n'existe pas de piece du jeu courant aux coordonnées initiales --> false,
        si les coordonnées finales ne sont pas valides ou égales aux initiales --> false,
        si position finale ne correspond pas à algo de déplacement piece --> false,
        s'il existe une piéce intermédiaire sur la trajectoire --> false (sauf cavalier),
        s'il existe une piéce positionnées aux coordonnées finales :
            si elle est de la méme couleur --> false ou tentative roque du roi,
            sinon : prendre la piéce intermédiaire (vigilance pour le cas du pion) et déplacer la piéce -->true,
        sinon déplacer la piéce -->true
        */
                
        return jeucourant.isMoveOk(xInit, yInit, xFinal, yFinal, true, jeucourant.castlingPossible);
          
    }

    public static void	main(java.lang.String[] args) {
        Echiquier echiquier = new Echiquier();
        System.out.println(echiquier);
    }
           

    public void switchJoueur() {
        if(this.jeucourant.getCouleur()==Couleur.BLANC) {
            this.jeucourant=jeunoir;
        }
        else {
            this.jeucourant=jeublanc;
        }
    }
          
    public String toString() {
        return jeublanc+"\n"+jeunoir;
    }
    
    

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if(this.isMoveOk(xInit, yInit, xFinal, yFinal)) {
            jeucourant.move(xInit, yInit, xFinal, yFinal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isEnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        return jeucourant.getCouleur();
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        if(this.jeublanc.isPieceHere(x, y)) {
            return Couleur.BLANC;
        }
        if(this.jeunoir.isPieceHere(x, y)) {
            return Couleur.NOIR;
        }
        return  null;
       
    }
    
    
    
}
