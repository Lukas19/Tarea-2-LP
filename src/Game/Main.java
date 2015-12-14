package Game;

//import com.sun.prism.paint.*;
import lp.motor.Application;
import lp.motor.Context;
import lp.motor.Element;
import lp.motor.MouseHandler;
import java.awt.*;
import java.awt.Color;

public class Main implements Context {

    Piece pieza1;
    Piece pieza2;
    Piece pieza3;
    Piece pieza4;
    Piece pieza5;
    Piece pieza6;
    Piece pieza7;
    Piece pieza8;
    Piece pieza9;
    Piece pieza10;
    Piece pieza11;
    Piece pieza12;
    Piece pieza13;
    Piece pieza14;
    Piece pieza15;
    Piece pieza16;
    Piece pieza17;
    Piece pieza18;
    Piece pieza19;
    Piece pieza20;
    PowerUps powerUpsReina;
    PowerUps powerUpsObliga;
    PowerUps powerUpsTransforma;
    PowerUps powerUpsAvanza;
    Board board = new Board();

    public Main() {

        // aquí puede inicializar valores y crear los objetos de juego.

        pieza1 = new Piece(100,50, Element.Type.FIRE);
        pieza2 = new Piece(200,50, Element.Type.WATER);
        pieza3 = new Piece(300,50, Element.Type.LEAF);
        pieza4 = new Piece(400,50, Element.Type.WATER);
        pieza5 = new Piece(500,50, Element.Type.FIRE);
        pieza6 = new Piece(50,100, Element.Type.FIRE);
        pieza7 = new Piece(150,100, Element.Type.WATER);
        pieza8 = new Piece(250,100, Element.Type.LEAF);
        pieza9 = new Piece(350,100, Element.Type.WATER);
        pieza10 = new Piece(450,100, Element.Type.FIRE);
        pieza11 = new Piece(50,500, Element.Type.FIRE);
        pieza12 = new Piece(150,500, Element.Type.WATER);
        pieza13 = new Piece(250,500, Element.Type.LEAF);
        pieza14 = new Piece(350,500, Element.Type.WATER);
        pieza15 = new Piece(450,500, Element.Type.FIRE);
        pieza16 = new Piece(100,450, Element.Type.FIRE);
        pieza17 = new Piece(200,450, Element.Type.WATER);
        pieza18 = new Piece(300,450, Element.Type.LEAF);
        pieza19 = new Piece(400,450, Element.Type.WATER);
        pieza20 = new Piece(500,450, Element.Type.FIRE);
        powerUpsReina = new PowerUps(200,250,"Reina",Color.YELLOW);
        powerUpsObliga = new PowerUps(300,250,"Obliga",Color.YELLOW);
        powerUpsTransforma = new PowerUps(400,250,"Transforma",Color.YELLOW);
        powerUpsAvanza = new PowerUps(100,250,"Avanza",Color.YELLOW);
        board.agregarCuadros();
        board.agregarPieza(pieza1,1);
        board.agregarPieza(pieza2,1);
        board.agregarPieza(pieza3,1);
        board.agregarPieza(pieza4,1);
        board.agregarPieza(pieza5,1);
        board.agregarPieza(pieza6,1);
        board.agregarPieza(pieza7,1);
        board.agregarPieza(pieza8,1);
        board.agregarPieza(pieza9,1);
        board.agregarPieza(pieza10,1);
        board.agregarPieza(pieza11,2);
        board.agregarPieza(pieza12,2);
        board.agregarPieza(pieza13,2);
        board.agregarPieza(pieza14,2);
        board.agregarPieza(pieza15,2);
        board.agregarPieza(pieza16,2);
        board.agregarPieza(pieza17,2);
        board.agregarPieza(pieza18,2);
        board.agregarPieza(pieza19,2);
        board.agregarPieza(pieza20,2);
        board.agregarPower(powerUpsReina);
        board.agregarPower(powerUpsObliga);
        board.agregarPower(powerUpsTransforma);
        board.agregarPower(powerUpsAvanza);
    
        
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
