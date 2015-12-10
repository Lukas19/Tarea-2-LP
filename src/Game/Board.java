package Game;

import lp.motor.Context;
import lp.motor.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class Board implements Context {

    Point esquina = new Point(50,50);
    private Color colorEquipo1;
    private Color colorEquipo2;
    private ArrayList<Point> cuadros = new ArrayList<>();
    private ArrayList<Piece> equipo1 = new ArrayList<>();
    private ArrayList<Piece> equipo2 = new ArrayList<>();

    private Piece piezaSeleccionada = null;
    private int turno = 1;


    public Board(Color color1,Color color2) {

        colorEquipo1 = color1;
        colorEquipo2 = color2;

    }

    public void agregarPieza(Piece pieza) {

        if (pieza.getColor() == colorEquipo1) {
            equipo1.add(pieza);
        } else {
            equipo2.add(pieza);
        }
    }

    public void agregarCuadros() {

        for (int i = 50; i <= (500); i += 50) {
            for (int j = 50; j <= (500); j += 50) {
                Point esquina = new Point(i,j);
                cuadros.add(esquina);
            }
        }

    }

    public void verificarJugada(Point point) {

        Point pto = piezaSeleccionada.obtenerCuadro(this,point);

        for (Piece pieza : equipo1) {
            if (pieza.getX() == pto.x && pieza.getY() == pto.y) {
                return;
            }
        }

        for (Piece pieza : equipo2) {
            if (pieza.getX() == pto.x && pieza.getY() == pto.y) {
                return;
            }
        }

        if (turno == 1) { //Turno del primer jugador

            if (piezaSeleccionada.esDama()) {

                if ((pto.x == piezaSeleccionada.getX() - 50 && pto.y == piezaSeleccionada.getY() + 50)
                    || (pto.x == piezaSeleccionada.getX() + 50 && pto.y == piezaSeleccionada.getY() + 50)
                    || (pto.x == piezaSeleccionada.getX() - 50 && pto.y == piezaSeleccionada.getY() - 50)
                    || (pto.x == piezaSeleccionada.getX() + 50 && pto.y == piezaSeleccionada.getY() - 50)) {

                    piezaSeleccionada.mover(this, point);
                    turno = 2;

                } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                    for (Piece pieza : equipo2) {
                        if (pieza.getX() == piezaSeleccionada.getX() - 50 && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo2.remove(pieza);
                            turno = 2;
                            break;

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo2) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50 && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo2.remove(pieza);
                            turno = 2;

                            if (piezaSeleccionada.getY() == 500 ) {
                                piezaSeleccionada.hacerDama();
                            }

                            break;

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo2) {
                        if (pieza.getX() == piezaSeleccionada.getX() - 50 && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo2.remove(pieza);
                            turno = 2;

                            if (piezaSeleccionada.getY() == 500 ) {
                                piezaSeleccionada.hacerDama();
                            }

                            break;

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                    for (Piece pieza : equipo2) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50 && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo2.remove(pieza);
                            turno = 2;
                            break;

                        }
                    }
                }
            } else if ((pto.x == piezaSeleccionada.getX() - 50 && pto.y == piezaSeleccionada.getY() + 50)
                    || (pto.x == piezaSeleccionada.getX() + 50 && pto.y == piezaSeleccionada.getY() + 50)) {
                    //Jugada diagonal simple. sin comer.

                piezaSeleccionada.mover(this, point);
                turno = 2;

                if (piezaSeleccionada.getY() == 500 ) {
                    piezaSeleccionada.hacerDama();
                }

            } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                for (Piece pieza : equipo2) {
                    if (pieza.getX() == piezaSeleccionada.getX() - 50 && pieza.getY() == piezaSeleccionada.getY() + 50) {

                        piezaSeleccionada.mover(this, point);
                        equipo2.remove(pieza);
                        turno = 2;

                        if (piezaSeleccionada.getY() == 500 ) {
                            piezaSeleccionada.hacerDama();
                        }

                        break;

                    }
                }

            } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                for (Piece pieza : equipo2) {
                    if (pieza.getX() == piezaSeleccionada.getX() + 50 && pieza.getY() == piezaSeleccionada.getY() + 50) {

                        piezaSeleccionada.mover(this, point);
                        equipo2.remove(pieza);
                        turno = 2;

                        if (piezaSeleccionada.getY() == 500 ) {
                            piezaSeleccionada.hacerDama();
                        }

                        break;

                    }
                }

            }

        } else {    //Turno del segundo jugador

            if (piezaSeleccionada.esDama()) {
                if ((pto.x == piezaSeleccionada.getX() - 50 && pto.y == piezaSeleccionada.getY() + 50)
                        || (pto.x == piezaSeleccionada.getX() + 50 && pto.y == piezaSeleccionada.getY() + 50)
                        || (pto.x == piezaSeleccionada.getX() -50 && pto.y == piezaSeleccionada.getY() -50)
                        || (pto.x == piezaSeleccionada.getX() +50 && pto.y == piezaSeleccionada.getY() -50)) {

                    piezaSeleccionada.mover(this, point);
                    turno = 1;

                } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                    for (Piece pieza : equipo1) {
                        if (pieza.getX() == piezaSeleccionada.getX() - 50 && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo1.remove(pieza);
                            turno = 1;

                            if (piezaSeleccionada.getY() == 50) {
                                piezaSeleccionada.hacerDama();
                            }

                            break;

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo1) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50 && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo1.remove(pieza);
                            turno = 1;
                            break;

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo1) {
                        if (pieza.getX() == piezaSeleccionada.getX() - 50 && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo1.remove(pieza);
                            turno = 1;
                            break;

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                    for (Piece pieza : equipo1) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50 && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            piezaSeleccionada.mover(this, point);
                            equipo1.remove(pieza);
                            turno = 1;

                            if (piezaSeleccionada.getY() == 50) {
                                piezaSeleccionada.hacerDama();
                            }

                            break;

                        }
                    }
                }
            } else if ((pto.x == piezaSeleccionada.getX() - 50 && pto.y == piezaSeleccionada.getY() - 50)
                    || (pto.x == piezaSeleccionada.getX() + 50 && pto.y == piezaSeleccionada.getY() - 50)) {

                piezaSeleccionada.mover(this, point);
                turno = 1;

                if (piezaSeleccionada.getY() == 50) {
                    piezaSeleccionada.hacerDama();
                }

            } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                for (Piece pieza : equipo1) {
                    if (pieza.getX() == piezaSeleccionada.getX() + 50 && pieza.getY() == piezaSeleccionada.getY() - 50) {

                        piezaSeleccionada.mover(this, point);
                        equipo1.remove(pieza);
                        turno = 1;

                        if (piezaSeleccionada.getY() == 50) {
                            piezaSeleccionada.hacerDama();
                        }

                        break;

                    }
                }
            } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                for (Piece pieza : equipo1) {
                    if (pieza.getX() == piezaSeleccionada.getX() - 50 && pieza.getY() == piezaSeleccionada.getY() - 50) {

                        piezaSeleccionada.mover(this, point);
                        equipo1.remove(pieza);
                        turno = 1;

                        if (piezaSeleccionada.getY() == 50) {
                            piezaSeleccionada.hacerDama();
                        }

                        break;

                    }
                }
            }

        }

    }

    public ArrayList<Point> getCuadros() {

        return cuadros;

    }

    public void draw(Graphics graphics) {

        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.WHITE);
                graphics.fillRect(50 + i, 50 + j, 50, 50);
            }
        }

        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(100 + i, 50 + j, 50, 50);
            }
        }

        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.WHITE);
                graphics.fillRect(100 + i, 100 + j, 50, 50);
            }
        }

        for (int i = 0; i < 500; i += 100) {
            for (int j = 0; j < 500; j += 100) {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(50 + i, 100 + j, 50, 50);
            }
        }

    }

    @Override
    public void update(MouseHandler mouseHandler) {

        Point pto;
        Point point = mouseHandler.getMousePosition();

        if (mouseHandler.isButtonJustPressed()) {
            if (piezaSeleccionada == null) {
                if (turno == 1) {
                    for (Piece pieza : equipo1) {
                        if (pieza.obtenerCuadro(this,point).x == pieza.getX() && pieza.obtenerCuadro(this,point).y == pieza.getY()) {
                            piezaSeleccionada = pieza;
                        }
                    }
                } else {
                    for (Piece pieza : equipo2) {
                        if (pieza.obtenerCuadro(this,point).x == pieza.getX() && pieza.obtenerCuadro(this,point).y == pieza.getY()) {
                            piezaSeleccionada = pieza;
                        }
                    }
                }
            } else {
                pto = piezaSeleccionada.obtenerCuadro(this,point);
                verificarJugada(pto);
                piezaSeleccionada = null;
            }
        }
    }

    @Override
    public void render(Graphics graphics) {

        for (Piece pieza : equipo1) {
            if (pieza.esDama()) {
                graphics.setColor(pieza.getColor());
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
                graphics.setColor(Color.white);
                graphics.fillOval(pieza.getX()+12, pieza.getY()+12, 25, 25);
            }

            else {
                graphics.setColor(pieza.getColor());
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());

            }
        }

        for (Piece pieza : equipo2) {
            if (pieza.esDama()) {
                graphics.setColor(pieza.getColor());
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
                graphics.setColor(Color.white);
                graphics.fillOval(pieza.getX()+12, pieza.getY()+12, 25, 25);
            }

            else {
                graphics.setColor(pieza.getColor());
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
            }
        }
    }
}
