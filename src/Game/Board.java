package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    private static ArrayList<Point> cuadros;
    private ArrayList<Piece> equipo1;
    private ArrayList<Piece> equipo2;

    public static void addCuadros(){

        cuadros = new ArrayList<Point>();

        for (int i = 50; i <= (500); i += 50){
            for (int j = 50; j <= (500); j += 50){
                Point esquina = new Point(i,j);
                cuadros.add(esquina);
            }
        }

    }

    public static ArrayList<Point> getCuadros() {
        return cuadros;
    }

    /*public Point getCuadro(Point punto){

        for (Point pto : cuadros){
            for (int i = pto.x; i < (pto.x+50); i++){
                for (int j = pto.y; j < (pto.y+50); j++){
                    if (punto.x == i && punto.y == j){
                        System.out.println("---> PUNTO  RECIBIDO: (" + punto.x + "," + punto.y + ")");
                        System.out.println("---> CUADRO ASOCIADO: (" + pto.x + "," + pto.y + ")");
                        return pto;
                    }
                }
            }
        }
        return null;
    }
    */

    public void addPieza(){

    }

    public void draw(Graphics graphics) {
        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.WHITE);
                graphics.fillRect(50 + i, 50 + j, 50, 50);
            }

        }
        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(100 + i, 50 + j, 50, 50);
            }
        }

        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.WHITE);
                graphics.fillRect(100 + i, 100 + j, 50, 50);
            }
        }

        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(50 + i, 100 + j, 50, 50);
            }
        }

    }
}
