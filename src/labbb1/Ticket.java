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

    public boolean isPalindrome() {
        return espalindromo;
    }

    public String print() {
        if (espalindromo) {
            return "Nombre: " + nombre + "\n"
                 + "Monto original: " + montooriginal + "\n"
                 + "Monto pagado: " + monto + "\n"
                 + "Se aplicó descuento:    SÍ";
        } else {
            return "Nombre: " + nombre + "\n"
                 + "Monto original: " + montooriginal + "\n"
                 + "Monto pagado: " + monto + "\n"
                 + "Se aplicó descuento:    NO";
        }
    }
}
