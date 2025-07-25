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

   


}
