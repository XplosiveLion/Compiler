package analizador;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Optimizar {

    // Método para optimizar el código reemplazando expresiones dependientes con
    // variables previas
    public static String optimizarCodigo(String codigo) {
        // Dividir el código en líneas
        String[] lineas = codigo.split("\n");
        List<String> lineasOptimizadas = new ArrayList<>();
        Map<String, String> asignaciones = new LinkedHashMap<>();

        // Recorrer cada línea del código
        for (String linea : lineas) {
            linea = linea.trim();
            if (linea.isEmpty())
                continue;

            // Extraer la parte izquierda y derecha de la asignación
            String[] partes = linea.split("=", 2);
            if (partes.length < 2) {
                lineasOptimizadas.add(linea);
                continue;
            }

            String izquierda = partes[0].trim();
            String derecha = partes[1].trim();

            // Verificar si la parte derecha puede ser reemplazada
            for (Map.Entry<String, String> entry : asignaciones.entrySet()) {
                String variable = entry.getKey();
                String expresion = entry.getValue();
                if (puedeSerSustituida(expresion, derecha, asignaciones)) {
                    derecha = derecha.replace(expresion, variable);
                }
            }

            // Verificar si se puede optimizar la expresión con dos operadores
            derecha = optimizarExpresionConDosOperadores(derecha, asignaciones);

            if (!derecha.endsWith(";")) {
                derecha += " ;";
            }
            // Guardar la asignación optimizada
            lineasOptimizadas.add(izquierda + " = " + derecha);
            asignaciones.put(izquierda, derecha);
        }

        // Reconstruir el código optimizado
        StringBuilder codigoOptimizado = new StringBuilder();
        for (String linea : lineasOptimizadas) {
            codigoOptimizado.append(linea).append("\n");
        }

        return codigoOptimizado.toString();
    }

    // Método para verificar si una expresión puede ser sustituida sin violar la
    // jerarquía de operaciones
    private static boolean puedeSerSustituida(String expresion, String derecha, Map<String, String> asignaciones) {
        // Si la expresión tiene un solo operador, se puede optimizar
        if (puedeSerOptimizada(expresion)) {
            return true;
        }

        // Si la expresión y la derecha tienen operadores de alto nivel o de bajo nivel
        // pero no del mismo nivel, intentar optimizar la expresión con dos operadores
        if ((tieneOperadorAltoNivel(expresion) && tieneOperadorBajoNivel(derecha))
                || (tieneOperadorBajoNivel(expresion) && tieneOperadorAltoNivel(derecha))) {
            return optimizarExpresionConDosOperadores(expresion, asignaciones) != null;
        }

        return false;
    }

    // Método para verificar si una expresión tiene operadores de alto nivel
    // (multiplicación, división, módulo)
    private static boolean tieneOperadorAltoNivel(String expresion) {
        return expresion.contains("*") || expresion.contains("/") || expresion.contains("%");
    }

    // Método para verificar si una expresión tiene operadores de bajo nivel (suma,
    // resta)
    private static boolean tieneOperadorBajoNivel(String expresion) {
        return expresion.contains("+") || expresion.contains("-");
    }

    // Método para verificar si una expresión puede ser optimizada (tiene un solo
    // operador)
    private static boolean puedeSerOptimizada(String expresion) {
        return tieneUnSoloOperador(expresion);
    }

    // Método para verificar si una expresión tiene un solo operador
    private static boolean tieneUnSoloOperador(String expresion) {
        int count = 0;
        for (char c : expresion.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                count++;
            }
        }
        return count == 1;
    }

    // Método para optimizar una expresión con dos operadores
    private static String optimizarExpresionConDosOperadores(String expresion, Map<String, String> asignaciones) {
        // Dividir la expresión en sus componentes
        String[] componentes = expresion.split("[+\\-*/%]");

        // Verificar si la expresión tiene dos componentes
        if (componentes.length == 2) {
            String operador = expresion.replaceAll("[^+\\-*/%]", "");
            String izquierda = componentes[0].trim();
            String derecha = componentes[1].trim();

            // Verificar si la combinación es de alto y alto, o bajo y bajo
            if ((tieneOperadorAltoNivel(izquierda) && tieneOperadorAltoNivel(derecha))
                    || (tieneOperadorBajoNivel(izquierda) && tieneOperadorBajoNivel(derecha))) {
                // Intentar encontrar una asignación previa que coincida exactamente con la
                // expresión
                for (Map.Entry<String, String> entry : asignaciones.entrySet()) {
                    if (entry.getValue().equals(expresion)) {
                        return entry.getKey();
                    }
                }
            } else {
                // Si la combinación no es de alto y alto, o bajo y bajo, intentar encontrar una
                // asignación previa que coincida con el primer operando
                for (Map.Entry<String, String> entry : asignaciones.entrySet()) {
                    String variable = entry.getKey();
                    String expresionAsignada = entry.getValue();
                    String[] componentesAsignados = expresionAsignada.split("[+\\-*/%]");
                    if (componentesAsignados.length == 2 && componentesAsignados[0].trim().equals(izquierda)) {
                        // Construir la expresión optimizada
                        return variable + " " + operador + " " + derecha;
                    }
                }
            }
        }

        // Si no se puede optimizar, devolver la expresión original
        return expresion;
    }
}
