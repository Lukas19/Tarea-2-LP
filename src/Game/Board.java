package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    private static ArrayList<Point> cuadros = new ArrayList<Point>();
    private static ArrayList<Piece> equipo1 = new ArrayList<Piece>();
    private static ArrayList<Piece> equipo2 = new ArrayList<Piece>();


    public static void addPieza(Piece pieza){

        if (pieza.color == Color.BLACK){
            equipo1.add(pieza);
        }
        else{
            equipo2.add(pieza);
        }
    }

    public static void addCuadros(){

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
