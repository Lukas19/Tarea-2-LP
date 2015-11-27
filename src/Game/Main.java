package Game;

import lp.motor.Application;
import lp.motor.Context;
import lp.motor.MouseHandler;
import java.awt.*;

public class Main implements Context {
    Board board;

    public Main() {
        // aquí puede inicializar valores y crear los objetos de juego.
        board = new Board();
    }

    @Override
    public void update(MouseHandler mouseHandler) {
        // aquí actualice sus objetos para que puedan interactuar con input de usuario o entre los mismos
        // objetos.

        // por ejemplo imprimir algo si el mouse está cerca de la esquina superior izquierda:
        Point point = mouseHandler.getMousePosition();
        if (point.x < 200 && point.y < 200)
            System.out.println(point);
    }

    @Override
    public void render(Graphics graphics) {
        // aquí, y solo aquí, puede dibujar cosas en la pantalla.
        // por ejemplo dibujar un círculo verde:
        board.draw(graphics);
    }

    public static void main(String[] args) {
        // el método main solo se encargará de iniciar el sistema.
        Application.start(600, 600, "Elepé!", 60, new Main());
    }
}