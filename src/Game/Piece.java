package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
public class Piece implements Context{
    String own;
    int x = 50;
    int y = 50;
    int width = 50;
    int height = 50;
    boolean isSelected = false;

    public Point getCuadro(Point punto){

        for (Point pto : Board.getCuadros()){
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

    @Override
    public void update(MouseHandler mouseHandler) { //
        Point point = mouseHandler.getMousePosition();

        if (mouseHandler.isButtonJustPressed()) {
            getCuadro(point);
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x,y,width, height);

    }
}
