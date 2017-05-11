package ui;


import model.*;

import javax.swing.*;

public class Ui {
    private Tekening tekening;
    //story 2
    /*public static void main() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
        Punt p = new Punt(x,y);
        JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + p.toString());
    }*/

    //story 3
    /*public static void main() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
        Punt p = new Punt(x,y);
        int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
        Cirkel c = new Cirkel(p,radius);
        JOptionPane.showMessageDialog(null,"U heeft een correcte cirkel aangemaakt: " + c.toString());
    }*/

    //story 4
    public void main(){
        String naam = JOptionPane.showInputDialog(null,"Geef de naam van je tekening:");
        tekening = new Tekening(naam);
        String[] options = {"Vorm maken","Tekening tonen", "Stoppen"};
        int response = JOptionPane.showOptionDialog(null, "Wat wil je doen?", "UI-hoofdmenu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        try {
            switch (response) {
                case 0:
                    tekenVorm();
                    break;
                case 1:
                    toonTekening();
                    break;
                case 2:
                    Runtime.getRuntime().exit(0);
                    break;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getClass() + e.getMessage() + e.getStackTrace());
        }

        }

    private void toonTekening() {
        throw new UiException("unimplemented");
    }

    private void tekenVorm() {
        String[] vormen = {"Cirkel","Rechthoek","Lijnstuk","Driehoek"};
        int response = JOptionPane.showOptionDialog(null, "Welke vorm wil je tekenen", "Teken vorm", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, vormen, vormen[0]);
            switch (response) {
                case 0:
                    tekenCirkel();
                    break;
                case 1:
                    tekenRechthoek();
                    break;
                case 2:
                    tekenLijnStuk();
                    break;
                case 3:
                    tekenDriehoek();
                    break;
            }
        main();
    }

    private void tekenDriehoek() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eerste punt:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het eerste punt:"));
        Punt p1 = new Punt(x,y);

        x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het tweede punt:"));
        y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het tweede punt:"));
        Punt p2 = new Punt(x,y);

        x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het derde punt:"));
        y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het derde punt:"));
        Punt p3 = new Punt(x,y);

        Driehoek dh = new Driehoek(p1,p2,p3);
        JOptionPane.showMessageDialog(null,"U heeft een correcte driehoek aangemaakt: " + dh.toString());
        tekening.voegToe(dh);
    }

    private void tekenRechthoek() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van de linkerbovenhoek:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van de linkerbovenhoek:"));
        Punt p = new Punt(x,y);

        int b = Integer.parseInt(JOptionPane.showInputDialog("Breedte van de rechthoek:"));
        int h = Integer.parseInt(JOptionPane.showInputDialog("Hoogte van de rechthoek:"));
        Rechthoek rh = new Rechthoek(p,b,h);
        JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + rh.toString());
        tekening.voegToe(rh);
    }

    public void tekenCirkel(){
        int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het middelpunt:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het middelpunt:"));
        Punt p = new Punt(x,y);
        int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
        Cirkel c = new Cirkel(p,radius);
        JOptionPane.showMessageDialog(null,"U heeft een correcte cirkel aangemaakt: " + c.toString());
        tekening.voegToe(c);
    }

    public void tekenLijnStuk(){
        int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het startpunt:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het startpunt:"));
        Punt p1 = new Punt(x,y);

        x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eindpunt:"));
        y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het eindpunt:"));
        Punt p2 = new Punt(x,y);

        LijnStuk ls = new LijnStuk(p1,p2);
        JOptionPane.showMessageDialog(null,"U heeft een correct lijnstuk aangemaakt: " + ls.toString());
        tekening.voegToe(ls);
    }
}
