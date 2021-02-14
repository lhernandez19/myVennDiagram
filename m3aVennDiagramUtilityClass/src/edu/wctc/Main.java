package edu.wctc;

public class Main {

    public static void main(String[] args) {
        String even = "even";
        String prime = "prime";
        String fibonacci = "fibonacci";

        VennDiagram<Integer> myVennDiagram = new VennDiagram<>(even, prime, fibonacci);

        myVennDiagram.add(1, fibonacci);
        myVennDiagram.add(2, even, prime, fibonacci);
        myVennDiagram.add(3, prime, fibonacci);
        myVennDiagram.add(4, even);
        myVennDiagram.add(5, prime, fibonacci);
        myVennDiagram.add(6, even);
        myVennDiagram.add(7, prime);
        myVennDiagram.add(8, even, fibonacci);
        myVennDiagram.add(9);
        myVennDiagram.add(10, even);

        // Numbers that are either prime or even
        System.out.println("Numbers that are either prime or even: " + myVennDiagram.unionOf(prime, even));

        // Numbers that are both prime and Fibonacci
        System.out.println("Numbers that are both prime and Fibonacci: " + myVennDiagram.intersectionOf(prime, fibonacci));

        // Odd Fibonacci numbers
        System.out.println("Odd Fibonacci numbers: " + myVennDiagram.complementOf(fibonacci, even));

        // Numbers that are even and prime and Fibonacci
        System.out.println("Numbers that are even and prime and Fibonacci: " + myVennDiagram.diagramCenter());
    }


}
