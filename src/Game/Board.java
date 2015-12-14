package Game;

import lp.motor.Context;
import lp.motor.Element;
import lp.motor.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class Board implements Context {

    Point esquina = new Point(50,50);
    private ArrayList<Point> cuadros = new ArrayList<>();
    private ArrayList<Piece> equipo1 = new ArrayList<>();
    private ArrayList<Piece> equipo2 = new ArrayList<>();
    private ArrayList<PowerUps> powerUps = new ArrayList<>();

    private Piece piezaSeleccionada = null;
    private PowerUps powerUpSeleccionado = null;
    private int turno = 1;

    public void agregarPieza(Piece pieza, int equipo) {

        if (equipo == 1) {
            equipo1.add(pieza);
        } else if (equipo == 2) {
            equipo2.add(pieza);
        }


    }

    public void agregarPower(PowerUps power){
        powerUps.add(power);
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
                        if (pieza.getX() == piezaSeleccionada.getX() - 50
                                && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                    && pieza.getElement() != Element.Type.WATER)
                                    || (piezaSeleccionada.getElement() == Element.Type.WATER
                                    && pieza.getElement() != Element.Type.LEAF)
                                    || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                    && pieza.getElement() != Element.Type.FIRE)) {

                                piezaSeleccionada.mover(this, point);
                                equipo2.remove(pieza);
                                turno = 2;
                                break;
                            }
                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo2) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50
                            && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                && pieza.getElement() != Element.Type.WATER)
                                || (piezaSeleccionada.getElement() == Element.Type.WATER
                                && pieza.getElement() != Element.Type.LEAF)
                                || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                && pieza.getElement() != Element.Type.FIRE)) {

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
                } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo2) {
                        if (pieza.getX() == piezaSeleccionada.getX() - 50
                            && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                && pieza.getElement() != Element.Type.WATER)
                                || (piezaSeleccionada.getElement() == Element.Type.WATER
                                && pieza.getElement() != Element.Type.LEAF)
                                || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                && pieza.getElement() != Element.Type.FIRE)) {

                                piezaSeleccionada.mover(this, point);
                                equipo2.remove(pieza);
                                turno = 2;

                                if (piezaSeleccionada.getY() == 500) {
                                    piezaSeleccionada.hacerDama();
                                }

                                break;
                            }

                        }
                    }

                } else if ((pto.x == piezaSeleccionada.getX() + 100
                    && pto.y == piezaSeleccionada.getY() - 100)) {

                    for (Piece pieza : equipo2) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50
                            && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                && pieza.getElement() != Element.Type.WATER)
                                || (piezaSeleccionada.getElement() == Element.Type.WATER
                                && pieza.getElement() != Element.Type.LEAF)
                                || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                && pieza.getElement() != Element.Type.FIRE)) {

                                piezaSeleccionada.mover(this, point);
                                equipo2.remove(pieza);
                                turno = 2;
                                break;
                            }

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


            }
            if (piezaSeleccionada.isSuperAvance()) {
                if ((pto.x == piezaSeleccionada.getX() -150 && pto.y ==piezaSeleccionada.getY() +150) ||
                    (pto.x == piezaSeleccionada.getX() +150 && pto.y == piezaSeleccionada.getY() +150)) {

                    piezaSeleccionada.mover(this, point);
                    piezaSeleccionada.setSuperAvance(false);
                    turno = 2;
                    if (piezaSeleccionada.getY() == 500) {
                        piezaSeleccionada.hacerDama();
                    }
                }
            } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                for (Piece pieza : equipo2) {
                    if (pieza.getX() == piezaSeleccionada.getX() - 50
                        && pieza.getY() == piezaSeleccionada.getY() + 50) {

                        if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                            && pieza.getElement() != Element.Type.WATER)
                            || (piezaSeleccionada.getElement() == Element.Type.WATER
                            && pieza.getElement() != Element.Type.LEAF)
                            || (piezaSeleccionada.getElement() == Element.Type.LEAF
                            && pieza.getElement() != Element.Type.FIRE)) {

                            piezaSeleccionada.mover(this, point);
                            equipo2.remove(pieza);
                            turno = 2;

                            if (piezaSeleccionada.getY() == 500) {
                                piezaSeleccionada.hacerDama();
                            }

                            break;
                        }

                    }
                }

                for (PowerUps power : powerUps) {
                    if (power.getX() == piezaSeleccionada.getX() - 50
                            && power.getY() == piezaSeleccionada.getY() + 50) {

                        if (power.getTipo() == "Reina") {
                            powerUpSeleccionado = power;
                            piezaSeleccionada.hacerDama();
                            System.out.println("Soy una dama ");

                        } else if (power.getTipo() == "Obliga") { //PowerUps Obliga
                            System.out.println("Elige la pieza que deseas que tu oponente mueva: ");
                            System.out.println("Jugador 2 mueve: ");
                            powerUpSeleccionado = power;
                        } else if (power.getTipo() == "Transforma" ) {
                            System.out.println("Selecciona la pieza que deseas transformar: ");
                            powerUpSeleccionado = power;
                            //turno = 2;
                        } else if (power.getTipo() == "Avanza") {
                            System.out.println("Esta pieza se moverá de tres espacios");
                            powerUpSeleccionado = power;
                            piezaSeleccionada.setSuperAvance(true);
                        }

                        piezaSeleccionada.mover(this, point);
                        powerUps.remove(power);
                        turno = 2;
                        break;

                    }
                }

            } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                for (Piece pieza : equipo2) {
                    if (pieza.getX() == piezaSeleccionada.getX() + 50
                        && pieza.getY() == piezaSeleccionada.getY() + 50) {

                        if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                            && pieza.getElement() != Element.Type.WATER)
                            || (piezaSeleccionada.getElement() == Element.Type.WATER
                            && pieza.getElement() != Element.Type.LEAF)
                            || (piezaSeleccionada.getElement() == Element.Type.LEAF
                            && pieza.getElement() != Element.Type.FIRE)) {

                            piezaSeleccionada.mover(this, point);
                            equipo2.remove(pieza);
                            turno = 2;

                            if (piezaSeleccionada.getY() == 500) {
                                piezaSeleccionada.hacerDama();
                            }

                            break;
                        }

                    }
                }

                for (PowerUps power : powerUps) {
                    if (power.getX() == piezaSeleccionada.getX() + 50
                            && power.getY() == piezaSeleccionada.getY() + 50) {

                        if (power.getTipo() == "Reina") {
                            powerUpSeleccionado = power;
                            piezaSeleccionada.hacerDama();
                            System.out.println("Soy una dama ");

                        } else if (power.getTipo() == "Obliga") { //PowerUps Obliga
                            System.out.println("Elige la pieza que deseas que tu oponente mueva: ");
                            System.out.println("Jugador 2 mueve: ");
                            powerUpSeleccionado = power;
                        } else if (power.getTipo() == "Transforma" ) {
                            System.out.println("Selecciona la pieza que deseas transformar: ");
                            powerUpSeleccionado = power;
                            turno = 2;
                        } else if (power.getTipo() == "Avanza") {
                            System.out.println("Esta pieza se moverá de tres espacios");
                            powerUpSeleccionado = power;
                            piezaSeleccionada.setSuperAvance(true);
                        }

                        piezaSeleccionada.mover(this, point);
                        powerUps.remove(power);
                        turno = 2;
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
                        if (pieza.getX() == piezaSeleccionada.getX() - 50
                            && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                && pieza.getElement() != Element.Type.WATER)
                                || (piezaSeleccionada.getElement() == Element.Type.WATER
                                && pieza.getElement() != Element.Type.LEAF)
                                || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                && pieza.getElement() != Element.Type.FIRE)) {

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
                } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo1) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50
                            && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                && pieza.getElement() != Element.Type.WATER)
                                || (piezaSeleccionada.getElement() == Element.Type.WATER
                                && pieza.getElement() != Element.Type.LEAF)
                                || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                && pieza.getElement() != Element.Type.FIRE)) {

                                piezaSeleccionada.mover(this, point);
                                equipo1.remove(pieza);
                                turno = 1;
                                break;
                            }

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() + 100)) {

                    for (Piece pieza : equipo1) {
                        if (pieza.getX() == piezaSeleccionada.getX() - 50
                            && pieza.getY() == piezaSeleccionada.getY() + 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                && pieza.getElement() != Element.Type.WATER)
                                || (piezaSeleccionada.getElement() == Element.Type.WATER
                                && pieza.getElement() != Element.Type.LEAF)
                                || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                && pieza.getElement() != Element.Type.FIRE)) {

                                piezaSeleccionada.mover(this, point);
                                equipo1.remove(pieza);
                                turno = 1;
                                break;
                            }

                        }
                    }
                } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                    for (Piece pieza : equipo1) {
                        if (pieza.getX() == piezaSeleccionada.getX() + 50
                            && pieza.getY() == piezaSeleccionada.getY() - 50) {

                            if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                                && pieza.getElement() != Element.Type.WATER)
                                || (piezaSeleccionada.getElement() == Element.Type.WATER
                                && pieza.getElement() != Element.Type.LEAF)
                                || (piezaSeleccionada.getElement() == Element.Type.LEAF
                                && pieza.getElement() != Element.Type.FIRE)) {

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
            } else if ((pto.x == piezaSeleccionada.getX() - 50 && pto.y == piezaSeleccionada.getY() - 50)
                    || (pto.x == piezaSeleccionada.getX() + 50 && pto.y == piezaSeleccionada.getY() - 50)) {

                piezaSeleccionada.mover(this, point);
                turno = 1;

                if (piezaSeleccionada.getY() == 50) {
                    piezaSeleccionada.hacerDama();
                }

            }
            if(piezaSeleccionada.isSuperAvance()) {
                if ((pto.x == piezaSeleccionada.getX() - 150 && pto.y == piezaSeleccionada.getY() - 150) ||
                        (pto.x == piezaSeleccionada.getX() + 150 && pto.y == piezaSeleccionada.getY() - 150)) {
                    piezaSeleccionada.mover(this, point);
                    piezaSeleccionada.setSuperAvance(false);
                    turno = 1;
                    if (piezaSeleccionada.getY() == 50) {
                        piezaSeleccionada.hacerDama();
                    }
                }
            } else if ((pto.x == piezaSeleccionada.getX() + 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                for (Piece pieza : equipo1) {
                    if (pieza.getX() == piezaSeleccionada.getX() + 50
                        && pieza.getY() == piezaSeleccionada.getY() - 50) {

                        if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                            && pieza.getElement() != Element.Type.WATER)
                            || (piezaSeleccionada.getElement() == Element.Type.WATER
                            && pieza.getElement() != Element.Type.LEAF)
                            || (piezaSeleccionada.getElement() == Element.Type.LEAF
                            && pieza.getElement() != Element.Type.FIRE)) {

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
                for (PowerUps power : powerUps) {
                    if (power.getX() == piezaSeleccionada.getX() + 50
                            && power.getY() == piezaSeleccionada.getY() - 50) {

                        if (power.getTipo() == "Reina") {
                            powerUpSeleccionado = power;
                            piezaSeleccionada.hacerDama();
                            System.out.println("Soy una dama ");

                            //Comparar posicion para saber que PowerUps es en este caso TRANSFORMA EN REINA

                        } else if (power.getTipo() == "Obliga") { //PowerUps Obliga
                            System.out.println("Elige la pieza que deseas que tu oponente mueva: ");
                            System.out.println("Jugador 2 mueve: ");
                            powerUpSeleccionado = power;
                        } else if (power.getTipo() == "Transforma" ) {
                            System.out.println("Selecciona la pieza que deseas transformar: ");
                            powerUpSeleccionado = power;
                            piezaSeleccionada.setTeam1(true);
                            turno = 1;
                        } else if (power.getTipo() == "Avanza") {
                            System.out.println("Esta pieza se moverá de tres espacios");
                            powerUpSeleccionado = power;
                            piezaSeleccionada.setSuperAvance(true);
                        }

                        piezaSeleccionada.mover(this, point);
                        powerUps.remove(power);
                        turno = 1;
                        break;
                    }
                }
            } else if ((pto.x == piezaSeleccionada.getX() - 100 && pto.y == piezaSeleccionada.getY() - 100)) {

                for (Piece pieza : equipo1) {
                    if (pieza.getX() == piezaSeleccionada.getX() - 50
                        && pieza.getY() == piezaSeleccionada.getY() - 50) {

                        if ((piezaSeleccionada.getElement() == Element.Type.FIRE
                            && pieza.getElement() != Element.Type.WATER)
                            || (piezaSeleccionada.getElement() == Element.Type.WATER
                            && pieza.getElement() != Element.Type.LEAF)
                            || (piezaSeleccionada.getElement() == Element.Type.LEAF
                            && pieza.getElement() != Element.Type.FIRE)) {

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
                for (PowerUps power : powerUps) {
                    if (power.getX() == piezaSeleccionada.getX() - 50
                            && power.getY() == piezaSeleccionada.getY() - 50) {

                        if (power.getTipo() == "Reina"){
                            powerUpSeleccionado = power;
                            piezaSeleccionada.hacerDama();
                            System.out.println("Soy una dama ");

                        } else if (power.getTipo() == "Obliga") { //PowerUps Obliga
                            System.out.println("Elige la pieza que deseas que tu oponente mueva: ");
                            System.out.println("Jugador 2 mueve: ");
                            powerUpSeleccionado = power;
                        } else if (power.getTipo() == "Transforma" ) {
                            System.out.println("Selecciona la pieza que deseas transformar: ");
                            powerUpSeleccionado = power;
                            turno = 1;
                        } else if (power.getTipo() == "Avanza") {
                            System.out.println("Esta pieza se moverá de tres espacios");
                            powerUpSeleccionado = power;
                            piezaSeleccionada.setSuperAvance(true);
                        }

                        piezaSeleccionada.mover(this, point);
                        powerUps.remove(power);
                        turno = 1;
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
    public void update(MouseHandler mouseHandler ) {

        Point pto;
        Point actual = null;
        Point point = mouseHandler.getMousePosition();
        boolean loco = true;


        if (mouseHandler.isButtonJustPressed() &&  powerUpSeleccionado == null) {
            if (piezaSeleccionada == null) {
                if (turno == 1) {
                    for (Piece pieza : equipo1) {
                        if (pieza.obtenerCuadro(this,point).x == pieza.getX()
                                && pieza.obtenerCuadro(this,point).y == pieza.getY()) {

                            piezaSeleccionada = pieza;
                        }
                    }
                } else {
                    for (Piece pieza : equipo2) {
                        if (pieza.obtenerCuadro(this,point).x == pieza.getX()
                                && pieza.obtenerCuadro(this,point).y == pieza.getY()) {

                            piezaSeleccionada = pieza;
                        }
                    }
                }
            } else {
                pto = piezaSeleccionada.obtenerCuadro(this,point);
                verificarJugada(pto);
                //if(piezaSeleccionada.isPowerDama()){
                //  piezaSeleccionada.yaNoEsDama();
                //  piezaSeleccionada.setPowerDama(false);
                //}
                piezaSeleccionada = null;

            }
        } else if (powerUpSeleccionado != null ) {
            if (piezaSeleccionada == null) {
                if (powerUpSeleccionado.getTipo() == "Transformar" || powerUpSeleccionado.getTipo() == "Obligar") {
                    for (Piece pieza : equipo1) {
                        if (pieza.obtenerCuadro(this, point).x == pieza.getX()
                                && pieza.obtenerCuadro(this, point).y == pieza.getY()) {

                            piezaSeleccionada = pieza;
                        }
                    }
                }   for (Piece pieza : equipo2) {
                    if (pieza.obtenerCuadro(this, point).x == pieza.getX()
                            && pieza.obtenerCuadro(this, point).y == pieza.getY()) {

                        piezaSeleccionada = pieza;
                    }
                }

            } else {
                if(powerUpSeleccionado.getTipo() == "Transforma") {
                    if(piezaSeleccionada.isTeam1()) {
                        //System.out.println(piezaSeleccionada.getColor());
                        //piezaSeleccionada.setColor(Color.GREEN);
                        piezaSeleccionada.setTeam1(false);
                        equipo2.add(piezaSeleccionada);
                        equipo1.remove(piezaSeleccionada);
                        pto = piezaSeleccionada.obtenerCuadro(this, point);
                        verificarJugada(pto);
                    } else if(equipo2.contains(piezaSeleccionada)) {
                        //piezaSeleccionada.setColor(Color.BLACK);
                        equipo1.add(piezaSeleccionada);
                        equipo2.remove(piezaSeleccionada);
                        pto = piezaSeleccionada.obtenerCuadro(this, point);
                        verificarJugada(pto);
                    }
                } else if(powerUpSeleccionado.getTipo() == "Obliga") {
                    //piezaSeleccionada.setColor(Color.ORANGE);
                    pto = piezaSeleccionada.obtenerCuadro(this,point);
                    while(loco) {
                        if (pto.x != piezaSeleccionada.getX()) {
                            loco = false;
                            pto = piezaSeleccionada.obtenerCuadro(this, point);
                            verificarJugada(pto);
                        }
                    }
                } else if(powerUpSeleccionado.getTipo() == "Reina") {
                    if(piezaSeleccionada.esDama()) {
                        System.out.println("ESTOY AQUI");
                        pto = piezaSeleccionada.obtenerCuadro(this, point);
                        verificarJugada(pto);
                    }
                }
                piezaSeleccionada = null;
                powerUpSeleccionado = null;
            }
        }
        //System.out.println("Dejame entrar!");
    }

    @Override
    public void render(Graphics graphics) {

        for (Piece pieza : equipo1) {

            if (pieza.getElement() == Element.Type.FIRE) {
                graphics.setColor(Color.RED);
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
            } else if (pieza.getElement() == Element.Type.WATER) {
                graphics.setColor(Color.CYAN);
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
            } else {
                graphics.setColor(Color.GREEN);
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
            }

            if (pieza.esDama()) {
                graphics.setColor(Color.white);
                graphics.fillOval(pieza.getX()+12, pieza.getY()+12, 25, 25);
            }
        }

        for (Piece pieza : equipo2) {

            if (pieza.getElement() == Element.Type.FIRE) {
                graphics.setColor(Color.red);
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
            } else if (pieza.getElement() == Element.Type.WATER) {
                graphics.setColor(Color.cyan);
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
            } else {
                graphics.setColor(Color.green);
                graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
            }

            if (pieza.esDama()) {
                graphics.setColor(Color.black);
                graphics.fillOval(pieza.getX()+12, pieza.getY()+12, 25, 25);
            }
        }

        for (PowerUps pieza : powerUps){
            graphics.setColor(Color.YELLOW);
            graphics.fillOval(pieza.getX(), pieza.getY(), pieza.getWidth(), pieza.getHeight());
        }
    }
}
