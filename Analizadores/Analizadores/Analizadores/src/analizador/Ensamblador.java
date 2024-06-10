package analizador;

import java.util.ArrayList;

public class Ensamblador {

    public String convertirACodigoEnsamblador(String code, boolean isOptimized) {
        StringBuilder assemblyCode = new StringBuilder();

        String[] lines = code.split("\n");
        for (String line : lines) {
            assemblyCode.append(convertirLineaACodigoEnsamblador(line)).append("\n");
        }

        return assemblyCode.toString();
    }

    private String convertirLineaACodigoEnsamblador(String line) {
        StringBuilder assemblyLine = new StringBuilder();
        ArrayList<String> datalist = new ArrayList<>();

        // Convertir la línea en una lista de tokens
        String[] parts = line.split(" ");
        for (String part : parts) {
            datalist.add(part);
        }

        String variable = datalist.get(0); // Guardar la variable de destino
        boolean processedHighPriority = false;

        // Procesar multiplicaciones, divisiones y módulo
        processedHighPriority = processMultiplicationDivisionModulo(assemblyLine, datalist);

        // Procesar sumas y restas
        processAdditionSubtraction(assemblyLine, datalist, variable, processedHighPriority);

        // Si no hay operadores, es una asignación simple
        if (!line.matches(".*[+\\-*/%].*")) {
            String operando0 = datalist.get(2);
            assemblyLine.append("MOV AX, ").append(operando0).append("\n");
        }

        // Guardar el resultado en la variable de destino
        assemblyLine.append("MOV ").append(variable).append(", AX\n");

        // Agregar la línea original al final
        assemblyLine.append(line).append("\n");

        return assemblyLine.toString();
    }

    private boolean processMultiplicationDivisionModulo(StringBuilder assemblyLine, ArrayList<String> datalist) {
        boolean processed = false;
        for (int i = 1; i < datalist.size() - 1; i++) {
            String token = datalist.get(i);
            if (token.matches("[*/%]")) {
                processed = true;
                String operando1 = datalist.get(i - 1);
                String operando2 = datalist.get(i + 1);
                switch (token) {
                    case "*":
                        assemblyLine.append("MOV AL, ").append(operando1).append("\n");
                        assemblyLine.append("MOV BL, ").append(operando2).append("\n");
                        assemblyLine.append("MUL BL\n");
                        break;
                    case "/":
                        assemblyLine.append("MOV AX, ").append(operando1).append("\n");
                        assemblyLine.append("MOV BL, ").append(operando2).append("\n");
                        assemblyLine.append("DIV BL\n");
                        assemblyLine.append("MOV AX, AL\n");
                        break;
                    case "%":
                        assemblyLine.append("MOV AX, ").append(operando1).append("\n");
                        assemblyLine.append("MOV BL, ").append(operando2).append("\n");
                        assemblyLine.append("DIV BL\n");
                        assemblyLine.append("MOV AX, AH\n"); // Mover el resultado del módulo a AX
                        break;
                }
                // Reemplazar la operación por la variable temporal
                datalist.set(i - 1, "AX");
                datalist.remove(i); // Remover operador
                datalist.remove(i); // Remover segundo operando
                i--; // Retroceder el índice para continuar con el siguiente operador
            }
        }
        return processed;
    }

    private void processAdditionSubtraction(StringBuilder assemblyLine, ArrayList<String> datalist, String variable,
            boolean processedHighPriority) {
        for (int i = 1; i < datalist.size() - 1; i++) {
            String token = datalist.get(i);
            if (token.matches("[+-]")) {
                String operando1 = datalist.get(i - 1);
                String operando2 = datalist.get(i + 1);
                switch (token) {
                    case "+":
                        if (processedHighPriority) {
                            assemblyLine.append("MOV BX, ").append(operando1).append("\n");
                            assemblyLine.append("ADD AX, ").append("BX").append("\n");
                        } else {
                            assemblyLine.append("MOV AX, ").append(operando1).append("\n");
                            assemblyLine.append("ADD AX, ").append(operando2).append("\n");
                        }
                        break;
                    case "-":
                        if (processedHighPriority) {
                            assemblyLine.append("MOV BX, ").append(operando1).append("\n");
                            assemblyLine.append("SUB AX, ").append("BX").append("\n");
                        } else {
                            assemblyLine.append("MOV AX, ").append(operando1).append("\n");
                            assemblyLine.append("SUB AX, ").append(operando2).append("\n");
                        }
                        break;
                }
                // Reemplazar la operación por la variable temporal
                datalist.set(i - 1, "AX");
                datalist.remove(i); // Remover operador
                datalist.remove(i); // Remover segundo operando
                i--; // Retroceder el índice para continuar con el siguiente operador
            }
        }
    }
}
