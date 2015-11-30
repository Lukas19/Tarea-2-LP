package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
public class Piece implements Context{

    int x;
    int y;
    int width = 50;
    int height = 50;
    boolean isSelected = false;
    Color color;

    public Piece(int x,int y,Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Point getCuadro(Point punto){

        for (Point pto : Board.getCuadros()){
            for (int i = pto.x; i < (pto.x+50); i++){
                for (int j = pto.y; j < (pto.y+50); j++){
                    if (punto.x == i && punto.y == j){
                        //System.out.println("---> PUNTO  RECIBIDO: (" + punto.x + "," + punto.y + ")");
                        //System.out.println("---> CUADRO ASOCIADO: (" + pto.x + "," + pto.y + ")");
                        return pto;
                    }
                }
            }
        }
        return null; //arreglar esto pq tira error cuando cliqueas fuera del tablero.
    }

    public void movePieza(Point punto){

        if (isSelected) {

            Point pto;
            pto = getCuadro(punto);

            this.x = pto.x;
            this.y = pto.y;
        }

    }

    @Override
    public void update(MouseHandler mouseHandler) { //
        Point pto,point = mouseHandler.getMousePosition();
        pto = getCuadro(point);

        if (mouseHandler.isButtonJustPressed()) {
            if (pto.x == this.x && pto.y == this.y){
                this.isSelected = true;
            }
            movePieza(point);
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x,y,width, height);

    }
}
