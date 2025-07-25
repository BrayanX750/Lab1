/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labbb1;

public class Ticket {

    private String nombre;
    private double monto;
    private double montooriginal;
    private boolean espalindromo;

    public Ticket(String nombre, double monto, double montooriginal, boolean espalindromo) {
        this.nombre = nombre;
        this.monto = monto;
        this.montooriginal = montooriginal;
        this.espalindromo = espalindromo;

    }

    public String getName() {
        return nombre;
    }

    public double getFinalAmount() {
        return monto;
    }

    public double getOriginalticket() {
        return montooriginal;
    }

    public boolean espalindrome(String nombre) {
        boolean palin = true;
        String vuelta = "";
        for (int i = 0; i < nombre.length() / 2; i++) {
            if (nombre.charAt(i) != nombre.charAt(nombre.length() - 1)) {
                palin = false;
            }
        }
        return palin;
    }

    public String print(boolean espalindrome) {
        if(espalindrome){
        return "Nombre: " + nombre + "\n"
                + "Monto original: " + montooriginal+"\n"
                + "Monto pagado: " + monto+"\n"
                + "Se aplico descuento:    SI";
        }else{
        return "Nombre: " + nombre + "\n"
                + "Monto original: " + montooriginal+"\n"
                + "Monto pagado: " + monto+"\n"
                + "Se aplico descuento:    NO";
        }   
    
    }

}
