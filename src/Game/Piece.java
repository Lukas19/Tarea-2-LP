package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
public class Piece implements Context{
    String own;
    int x = 50;
    int y = 50;
    int speed = 50;
    int width = 50;
    int height = 50;
    boolean isPressed = false;

   /* public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x,y,width, height);




    }*/

    @Override
    public void update(MouseHandler mouseHandler) {
        Point point = mouseHandler.getMousePosition();
        if (point.x <= 2*x && point.y <= 2*y && mouseHandler.isButtonPressed() || point.x <= x && point.y <= y && mouseHandler.isButtonPressed())
            isPressed = true;
        else if (mouseHandler.isButtonJustPressed() && isPressed) {
            x = point.x;
            y = point.y;
            isPressed = false;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x,y,width, height);

    }
}
