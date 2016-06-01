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

    private Couleur couleur;
    private List<Pieces> pieces;
    boolean castlingPossible;
        
    public Jeu(Couleur couleur) {
        this.pieces = ChessPiecesFactory.newPieces(couleur);
        this.castlingPossible=false;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu(Couleur.BLANC);
        System.out.println(jeu);
    }

    @Override
    public String toString() {
        return "Jeu{" + "pieces=" + pieces + '}';
    }

    private Pieces findPiece(int x, int y) {
        for (int i=0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public boolean setCastlingPossible() 
    {
        return castlingPossible;
        
    }
    
        public boolean getCastlingPossible() 
    {
        return castlingPossible;        
    }

    @Override
    public boolean isPieceHere(int x, int y) {
        for (int i=0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public List<Pieces> getPieces() {
        return pieces;
    }

    

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if (findPiece(xInit, yInit) != null) {
            return findPiece(xInit, yInit).isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible);
        }
        return false;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        findPiece(xInit, yInit).move(xFinal, yFinal);
        return false;
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
