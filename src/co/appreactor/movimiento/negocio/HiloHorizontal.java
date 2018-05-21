/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.movimiento.negocio;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lord_Nightmare
 */
public class HiloHorizontal extends Thread {

    private JLabel imgJava;
    private JFrame principal;
    private boolean sentido;

    public HiloHorizontal(JLabel imgJava, JFrame principal) {
        this.imgJava = imgJava;
        this.principal = principal;
        this.sentido = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (sentido) {
                    avanzar();
                } else {
                    retroceder();
                }
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void avanzar() {
        imgJava.setLocation(imgJava.getX() + 1, imgJava.getY());
        if (imgJava.getLocation().x == (principal.getWidth() - imgJava.getWidth())) {
            this.sentido = false;
        }
    }

    private void retroceder() {
        imgJava.setLocation(imgJava.getX() - 1, imgJava.getY());
        if (imgJava.getLocation().x == 0) {
            this.sentido = true;
        }
    }
}
