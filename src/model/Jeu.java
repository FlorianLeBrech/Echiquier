/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tools.ChessPiecesFactory;

/**
 *
 * @author hugo.talbot
 */
public class Jeu implements Game {
    List<Pieces> pieces = new LinkedList<>();
    public Jeu() {
        this.pieces=ChessPiecesFactory.newPieces(Couleur.BLANC);
    }
    
    public static void main (String[] args){
        Jeu jeu = new Jeu();
        
        System.out.println(jeu);
    }
    
    @Override
    public String toString() {
        Iterator it = pieces.iterator();
        while(it.hasNext()) {
            System.out.println(it);
        }
        return "";
    }
    
    @Override
    public boolean isPieceHere(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}