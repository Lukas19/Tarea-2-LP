package Game;


import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;

public class PowerUps extends Piece implements Context{

    private String tipo;

    public PowerUps(int x, int y, Color color, String tipo){
        super(x,y,color);
        this.tipo = tipo;

    }



    @Override
    public void update(MouseHandler mouseHandler) {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
