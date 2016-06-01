/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Florian
 */
abstract class AbstractPiece implements Pieces {

    private Coord coord;
    private Couleur couleur;

    public AbstractPiece(Couleur couleur, Coord coord) {
        this.couleur = this.couleur;
        this.coord = coord;
        capture = false;
    }

    public int getX() {
        return this.coord.x;
    }

    public int getY() {
        return this.coord.y;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public java.lang.String getName() {
        return this.getClass().toString();      // a changer peut etre 
    }

    public boolean move(int x, int y) {
        this.coord.x = x;
        this.coord.y = y;
        return true;
    }

    public boolean capture() {
        this.coord.x = -1;
        this.coord.y = -1;
        return true;

    }

    public abstract boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);

}
