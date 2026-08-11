
package com.mycompany.geometry;
import.java.util.*;
public class Geometry {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double area = a*b;
        double perimeter = 2*(a+b);
        System.out.printf("Area: %.2f\n", area);
        System.out.printf("Perimeter:%.2\n",perimeter);
    }
}
