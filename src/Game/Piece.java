package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
public class Piece implements Context {

    int x;
    int y;
    int width = 50;
    int height = 50;
    boolean isSelected = false;
    Color color;

    public Piece(int x,int y,Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Point obtenerCuadro(Point punto) {

        for (Point pto : Board.obtenerCuadros() ) {
            for (int i = pto.x; i < (pto.x+50); i++) {
                for (int j = pto.y; j < (pto.y+50); j++) {
                    if (punto.x == i && punto.y == j) {
                        return pto;
                    }
                }
            }
        }
        return null; //arreglar esto, tira error cuando cliqueas fuera del tablero.
    }

    public void mover(Point punto) {

        if (isSelected) {

            Point pto;
            System.out.println("El mouse esta en :" + punto);
            pto = obtenerCuadro(punto);
            System.out.println("Me moveré a :" + pto);

            if ((pto.x == this.x - 50 && pto.y == this.y + 50) || (pto.x == this.x + 50 && pto.y == this.y + 50) || (pto.x == this.x-50 && pto.y == this.y-50) || (pto.x == this.x+50 && pto.y == this.y-50) ) {

                this.x = pto.x;
                this.y = pto.y;

            }

        }
    }

    @Override
    public void update(MouseHandler mouseHandler) { //
        Point pto,point = mouseHandler.getMousePosition();
        pto = obtenerCuadro(point);

        if (mouseHandler.isButtonJustPressed()) {
            if (pto.x == this.x && pto.y == this.y) { //Validamos que el usuario clickee sobre la pieza
                this.isSelected = true;
            }
            mover(point);
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x,y,width, height);

    }
}
