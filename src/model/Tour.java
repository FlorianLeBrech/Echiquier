/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.AbstractPiece;
import model.Coord;
import model.Couleur;

/**
 *
 * @author hugo.talbot
 */
public class Tour extends AbstractPiece {
   
    public Tour(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }
            
    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if(Coord.coordonnees_valides(xFinal, yFinal)) {
            //System.out.println(this.getX()!=xFinal);
            if((this.getX()==xFinal && this.getY()!=yFinal) || (this.getX()!=xFinal && this.getY()==yFinal)) {
                
                    return true;
                
            }
        }
        
        return false;
    }

    @Override
    public String toString() {
        return this.getCouleur()+"_To";
    }

    @Override
    public String getName() {
        return "To";
    }
    
 
}
