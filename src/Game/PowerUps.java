package Game;


import lp.motor.Context;
import lp.motor.Element;
import lp.motor.MouseHandler;

import java.awt.*;

public class PowerUps extends Piece implements Context {

    private String tipo;
    private Color color;

    public PowerUps(int x, int y, String tipo, Color color) {

        super(x,y, Element.Type.FIRE);
        this.tipo = tipo;
        this.color = color;
    }

      public String getTipo() {
        return tipo;
    }

    @Override
    public void update(MouseHandler mouseHandler) {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
