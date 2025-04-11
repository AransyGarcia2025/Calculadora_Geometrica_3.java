package Calculadora_Geometrica_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora_Geometrica_3 {
    static double[] resultados = new double[100];
    static int contadorResultados = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> calcularFigura();
                case 2 -> calcularPotencia();
                case 3 -> mostrarResultados();
                case 4 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 4);
    }

    static void mostrarMenuPrincipal() {
        System.out.println("\n=== Calculadora Geométrica ===");
        System.out.println("1. Calcular Área o Perímetro de Figuras");
        System.out.println("2. Calcular Potencia");
        System.out.println("3. Mostrar Resultados Anteriores");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static void calcularFigura() {
        System.out.println("\nSeleccione la figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        int figura = leerEntero();

        System.out.println("Seleccione la operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        int operacion = leerEntero();

        double resultado = 0;
        switch (figura) {
            case 1 -> resultado = (operacion == 1) ? areaCirculo() : perimetroCirculo();
            case 2 -> resultado = (operacion == 1) ? areaCuadrado() : perimetroCuadrado();
            case 3 -> resultado = (operacion == 1) ? areaTriangulo() : perimetroTriangulo();
            case 4 -> resultado = (operacion == 1) ? areaRectangulo() : perimetroRectangulo();
            case 5 -> resultado = (operacion == 1) ? areaPentagono() : perimetroPentagono();
            default -> System.out.println("Figura no válida.");
        }

        System.out.println("El resultado es: " + resultado);
        guardarResultado(resultado);
    }

    static void calcularPotencia() {
        System.out.print("Ingrese la base: ");
        double base = leerDouble();
        System.out.print("Ingrese el exponente: ");
        int exponente = leerEntero();

        double resultado = potencia(base, exponente);
        System.out.println("El resultado de " + base + "^" + exponente + " es: " + resultado);
        guardarResultado(resultado);
    }

    static double potencia(double base, int exponente) {
        if (exponente == 0) return 1;
        if (exponente < 0) return 1 / potencia(base, -exponente);
        return base * potencia(base, exponente - 1);
    }

    static void mostrarResultados() {
        System.out.println("\n=== Resultados Anteriores ===");
        if (contadorResultados == 0) {
            System.out.println("No hay resultados almacenados.");
        } else {
            for (int i = 0; i < contadorResultados; i++) {
                System.out.println((i + 1) + ". " + resultados[i]);
            }
        }
    }

    // Métodos para cada figura geométrica
    static double areaCirculo() {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = leerDouble();
        return Math.PI * Math.pow(radio, 2);
    }

    static double perimetroCirculo() {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = leerDouble();
        return 2 * Math.PI * radio;
    }

    static double areaCuadrado() {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = leerDouble();
        return lado * lado;
    }

    static double perimetroCuadrado() {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = leerDouble();
        return 4 * lado;
    }

    static double areaTriangulo() {
        System.out.print("Ingrese la base del triángulo: ");
        double base = leerDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = leerDouble();
        return (base * altura) / 2;
    }

    static double perimetroTriangulo() {
        System.out.print("Ingrese el lado 1 del triángulo: ");
        double lado1 = leerDouble();
        System.out.print("Ingrese el lado 2 del triángulo: ");
        double lado2 = leerDouble();
        System.out.print("Ingrese el lado 3 del triángulo: ");
        double lado3 = leerDouble();
        return lado1 + lado2 + lado3;
    }

    static double areaRectangulo() {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = leerDouble();
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = leerDouble();
        return base * altura;
    }

    static double perimetroRectangulo() {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = leerDouble();
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = leerDouble();
        return 2 * (base + altura);
    }

    static double areaPentagono() {
        System.out.print("Ingrese el perímetro del pentágono: ");
        double perimetro = leerDouble();
        System.out.print("Ingrese el apotema del pentágono: ");
        double apotema = leerDouble();
        return (perimetro * apotema) / 2;
    }

    static double perimetroPentagono() {
        System.out.print("Ingrese la longitud de un lado del pentágono: ");
        double lado = leerDouble();
        return 5 * lado;
    }

    static int leerEntero() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Se esperaba un número entero.");
            scanner.next();
            return leerEntero();
        }
    }

    static double leerDouble() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Se esperaba un número.");
            scanner.next();
            return leerDouble();
        }
    }

    static void guardarResultado(double resultado) {
        if (contadorResultados < resultados.length) {
            resultados[contadorResultados++] = resultado;
        } else {
            System.out.println("No se pueden almacenar más resultados.");
        }
    }
}

