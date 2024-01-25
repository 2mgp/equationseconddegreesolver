package com.example.equationseconddegree.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.equationseconddegree.EquationInput;
import com.example.equationseconddegree.EquationSolver;

@RestController
@RequestMapping("/api/equation")
public class EquationController {

    @PostMapping("/solve")
    public ResponseEntity<?> solveEquation(@RequestBody EquationInput input) {
        try {
            EquationSolver solver = new EquationSolver();
            double[] result = solver.solve(input.getA(), input.getB(), input.getC());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            ApiError apiError = new ApiError(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        }
    }
}
