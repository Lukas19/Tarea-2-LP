package Game;

import lp.motor.Context;
import lp.motor.Element;
import lp.motor.MouseHandler;

import java.awt.*;
public class Piece {

    private int x;
    private int y;
    private int width = 50;
    private int height = 50;
    private boolean esDama = false;
    private Element.Type elemento;
    private boolean superAvance = false;
    private boolean team1 = false;
    
    
    public Piece(int x,int y,Element.Type elemento) {

        this.x = x;
        this.y = y;
        this.elemento = elemento;
    }

    public Point obtenerCuadro(Board board,Point punto) {

        for (Point pto : board.getCuadros()) {
            for (int i = pto.x; i < (pto.x+50); i++) {
                for (int j = pto.y; j < (pto.y+50); j++) {
                    if (punto.x == i && punto.y == j) {
                        return pto;
                    }
                }
            }
        }
        return board.esquina; //click fuera del tablero = click en la esquina superior izquierda del tablero.
    }

    public void mover(Board board,Point punto) {

        Point pto = obtenerCuadro(board,punto);
        this.x = pto.x;
        this.y = pto.y;
    }

    public boolean esDama() {
        return esDama;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Element.Type getElement() {
        return elemento;
    }

    public int getWidth() {
        return width;

    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void hacerDama() {
        this.esDama = true;
    }

    public void yaNoEsDama() {
        this.esDama = false;
    }
    
    public boolean isSuperAvance() { 
          return superAvance; 
    }

    public void setSuperAvance(boolean superAvance) { 
        this.superAvance = superAvance; 
    }

    public boolean isTeam1() { return team1; }

    public void setTeam1(boolean team1) { this.team1 = team1; }
    
    
}
