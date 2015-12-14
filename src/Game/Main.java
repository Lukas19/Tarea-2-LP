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
    PowerUps powerUpsReina;
    PowerUps powerUpsObliga;
    PowerUps powerUpsTransforma;
    PowerUps powerUpsAvanza;
    Color colorEquipo1 = Color.BLACK;
    Color colorEquipo2 = Color.GREEN;
    Board board = new Board();

    public Main() {

        // aquí puede inicializar valores y crear los objetos de juego.

        pieza1 = new Piece(100,50, Element.Type.FIRE);
        pieza2 = new Piece(250,100, Element.Type.WATER);
        pieza3 = new Piece(50,500, Element.Type.FIRE);
        pieza4 = new Piece(150,500, Element.Type.LEAF);
        powerUpsReina = new PowerUps(200,250,"Reina");
        powerUpsObliga = new PowerUps(300,250,"Obliga");
        powerUpsTransforma = new PowerUps(400,250,"Transforma");
        board.agregarCuadros();
        board.agregarPieza(pieza1,1);
        board.agregarPieza(pieza2,1);
        board.agregarPieza(pieza3,2);
        board.agregarPieza(pieza4,2);
        board.agregarPieza(powerUpsReina,3);
        board.agregarPieza(powerUpsObliga,3);
        board.agregarPieza(powerUpsTransforma,3);
        board.agregarPieza(powerUpsAvanza,3);
    
        
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
