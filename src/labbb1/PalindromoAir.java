/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labbb1; 

public class PalindromoAir {
    private Ticket[] asientos = new Ticket[30];

    public int firstAvailable(int index) {
        if (index >= asientos.length) return -1;
        if (asientos[index] == null) return index;
        return firstAvailable(index + 1);
    }

    public int searchPassenger(String nombre, int index) {
        if (index >= asientos.length) return -1;
        if (asientos[index] != null && asientos[index].getName().equalsIgnoreCase(nombre)) return index;
        return searchPassenger(nombre, index + 1);
    }

    public boolean isPalindromo(String nombre) {
        nombre = nombre.toLowerCase().replaceAll("\\s+", "");
        return isPalindromo(nombre, 0, nombre.length() - 1);
    }

    private boolean isPalindromo(String nombre, int i, int j) {
        if (i >= j) return true;
        if (nombre.charAt(i) != nombre.charAt(j)) return false;
        return isPalindromo(nombre, i + 1, j - 1);
    }

    public String printPassengers(int index) {
        if (index >= asientos.length) return "";
        if (asientos[index] != null) {
            return asientos[index].print() + "\n" + printPassengers(index + 1);
        } else {
            return printPassengers(index + 1);
        }
    }

    public double income(int index) {
        if (index >= asientos.length) return 0;
        if (asientos[index] != null) {
            return asientos[index].getFinalAmount() + income(index + 1);
        } else {
            return income(index + 1);
        }
    }

    public void reset(int index) {
        if (index >= asientos.length) return;
        asientos[index] = null;
        reset(index + 1);
    }

    public Ticket[] getAsientos() {
        return asientos;
    }

    public String sellTicket(int asiento, String nombre) {
    if (asiento < 0 || asiento >= asientos.length) {
        return "Número de asiento inválido.";
    }
    if (asientos[asiento] != null) {
        return "Ese asiento ya está ocupado.";
    }

    boolean esPalin = isPalindromo(nombre);
    double original = 100.0;
    double total = esPalin ? original * 0.8 : original;

    Ticket t = new Ticket(nombre, total, original, esPalin);
    asientos[asiento] = t;

    return "Ticket vendido en asiento #" + (asiento + 1) + " a " + nombre + ". Pagó: $" + total;
}


    public boolean cancelTicket(String nombre) {
        int pos = searchPassenger(nombre, 0);
        if (pos == -1) {
            return false;
        }
        asientos[pos] = null;
        return true;
    }

    public String dispatch() {
        double total = income(0);
        reset(0);
        return "Ingreso total: $" + total + "\nTodos los asientos fueron liberados.";
    }
}
