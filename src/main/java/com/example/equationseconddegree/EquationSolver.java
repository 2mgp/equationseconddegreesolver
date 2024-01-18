package com.example;

public class EquationSolver implements IEquationSolver {
    @Override
    public  double[] solve(double a, double b, double c) {
        final double tolerance = 1e-5;
        if (Math.abs(a) < tolerance) {
        
            throw new IllegalArgumentException("l'equation n'a pas de solution reel ne peux etre 0,equation non conforme.");
        }

        // Calculation of the discriminant
        final double discriminant = b * b - 4 * a * c;
        double[] solutions;

        if (discriminant > 0) {
            // Two distinct real solutions
            final double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            final double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            solutions = new double[]{x1, x2};
        } else if (discriminant == 0) {
            // Single real solution
            final double x = -b / (2 * a);
            solutions = new double[]{x, x};
        } else {
            // No real solutions
            throw new IllegalArgumentException("l'equation n'a pas de solution reel");
        }

        return solutions;

    }



  
}
    

