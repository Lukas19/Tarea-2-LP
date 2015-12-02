package Game;

import lp.motor.Application;
import lp.motor.Context;
import lp.motor.MouseHandler;
import java.awt.*;

public class Main implements Context {
    Board board;
    Piece pieza1,pieza2,pieza3,pieza4;

    public Main() {
        // aquí puede inicializar valores y crear los objetos de juego.
        board = new Board();
        pieza1 = new Piece(100,50,Color.BLACK,1);
        pieza2 = new Piece(150,100,Color.BLACK,1);
        pieza3 = new Piece(50,500,Color.GREEN,2);
        pieza4 = new Piece(150,500,Color.GREEN,2);
        Board.agregarCuadros();
        Board.agregarPieza(pieza1);
        Board.agregarPieza(pieza2);
        Board.agregarPieza(pieza3);
        Board.agregarPieza(pieza4);
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
        pieza1.update(mouseHandler);
        pieza2.update(mouseHandler);
        pieza3.update(mouseHandler);
        pieza4.update(mouseHandler);

    }

    @Override
    public void render(Graphics graphics) {
        // aquí, y solo aquí, puede dibujar cosas en la pantalla.
        // por ejemplo dibujar un círculo verde:
        board.draw(graphics);
        pieza1.render(graphics);
        pieza2.render(graphics);
        pieza3.render(graphics);
        pieza4.render(graphics);
    }

    public static void main(String[] args) {
        // el método main solo se encargará de iniciar el sistema.
        Application.start(600, 600, "Elepé!", 60, new Main());
    }
}