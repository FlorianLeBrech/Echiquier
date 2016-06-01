/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

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
                
        if(jeucourant.findPiece(xInit, yInit)==null) {
            return false;
        }
        if(Coord.coordonnees_valides(xFinal, yFinal)==false || (xInit==xFinal && yInit==yFinal)) {
            return false;
        }
        if(jeucourant.findPiece(xInit, yInit).isMoveOK(xFinal, yFinal)==false) {
            return false;
        }
        //manque le if pour pièce sur la trajectoire
        if(jeucourant.findPiece(xInit, yInit).isPieceHere(xFinal, yFinal)) {
            if(jeucourant.findPiece(xInit, yInit).getCouleur()==jeucourant.couleur) {
                return false; //manque tentative de roque du roi
            }
            else {
                
            }
        }
        
    }

    public static void	main(java.lang.String[] args) {
        Echiquier echiquier = new Echiquier();
        System.out.println(echiquier);
    }
           

    public void switchJoueur() {
        if(this.jeucourant==Couleur.BLANC) {
            this.jeucourant=Couleur.NOIR;
        }
        else {
            this.jeucourant=Couleur.BLANC;
        }
    }
          
    public String toString() {
        return jeublanc+"\n"+jeunoir;
    }
    
    

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
