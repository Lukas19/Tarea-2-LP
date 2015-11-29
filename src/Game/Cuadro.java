package Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by wil on 28-11-15.
 */
public class Cuadro {

    private ArrayList<Point> points;
    private int x;
    private int y;
    private Piece pieza;

    public void Cuadro(int x, int y){

        this.x = x;
        this.y = y;

        /*for (int i = x; i < x + LARGO; i++){
            for (int j = y; j < y + ALTURA; j++){
                Point punto = new Point(i,j);
            }
        }*/

        /* Agregar puntos:

            xBottom = x + largo/2
            xTop = x - largo/2
            for min <= i <= max
                for min <= j <= max
                    new point
                    point = i,j

        */

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isInCuadro(Point point){

        for (Point pto : points){
            if (pto.x == point.x && pto.y == point.y){
                return true;
            }
        }
        return false;
    }
}
