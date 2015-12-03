package Game;

import lp.motor.Application;
import lp.motor.Context;
import lp.motor.MouseHandler;
import java.awt.*;

public class Main implements Context {

    Piece pieza1;
    Piece pieza2;
    Piece pieza3;
    Piece pieza4;
    Color colorEquipo1 = Color.BLACK;
    Color colorEquipo2 = Color.GREEN;
    Board board = new Board(colorEquipo1, colorEquipo2);

    public Main() {

        // aquí puede inicializar valores y crear los objetos de juego.

        pieza1 = new Piece(100,50,colorEquipo1);
        pieza2 = new Piece(150,100,colorEquipo1);
        pieza3 = new Piece(50,500,colorEquipo2);
        pieza4 = new Piece(150,500,colorEquipo2);
        board.agregarCuadros();
        board.agregarPieza(pieza1);
        board.agregarPieza(pieza2);
        board.agregarPieza(pieza3);
        board.agregarPieza(pieza4);

    }

    @Override
    public void update(MouseHandler mouseHandler) {

        // aquí actualice sus objetos para que puedan interactuar con input de usuario o entre los mismos
        // objetos.

        // por ejemplo imprimir algo si el mouse está cerca de la esquina superior izquierda:

        Point point = mouseHandler.getMousePosition();

        /*
        if (point.x < 200 && point.y < 200)
            System.out.println(point);
        */

        board.update(mouseHandler);

    }

    @Override
    public void render(Graphics graphics) {

        // aquí, y solo aquí, puede dibujar cosas en la pantalla.
        // por ejemplo dibujar un círculo verde:

        board.draw(graphics);
        board.render(graphics);

    }

    public static void main(String[] args) {

        // el método main solo se encargará de iniciar el sistema.

        Application.start(600, 600, "Elepé!", 60, new Main());

    }
}