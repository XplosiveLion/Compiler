package analizador;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Triplos {

    private static int NLinea = 0;
    private static String TextoBase;

    private static ArrayList<BaseTriplo> ArrTriplo = new ArrayList<>();

    private static ArrayList<BaseTriplo> ArrTriploEns = new ArrayList<>();

    public static void GenerarTriplosNOPT(String textoEn, boolean optimizar) {
        // Optimizar el código si la bandera optimizar es verdadera
        if (optimizar) {
            textoEn = Optimizar.optimizarCodigo(textoEn);
        }

        NLinea = 0;
        ArrTriplo.clear();
        ArrTriploEns.clear();
        // TextoBase = textoEn;
        // String[] LiPoLi = TextoBase.split("\\r?\\n|\\r"); //Linea por Linea

        TextoBase = textoEn; // contiene un documento de texto, que se dividira en lineas individuales y se
                             // creara una matriz de cadenas
        String[] LiPoLi = TextoBase.split("\\r?\\n|\\r"); // separa linea por linea

        for (int i = 0; i < LiPoLi.length; i++) { // analiza linea de lexemas
            String[] ArrLex = LiPoLi[i].split("[ ]+"); // Separa lexemas y divide en lexemas individuales y utilizando
                                                       // espacios como delimitador
            // Para cada línea, la divide en lexemas individuales (palabras o tokens)
            // utilizando espacios como delimitador y los almacena en la ArrLex

            if (ArrLex.length == 4 && ArrLex[1].equals("=")) { // identifica instruccion de asignacion
                String[] lexemaAux = LiPoLi[i].split("[ ]+");// separa lexemas
                // posición 0 está a donde se asigna y en posición 2 está qué se debe asignar
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, lexemaAux[0], lexemaAux[2], "", "="));
            }

            if (ArrLex.length > 4) { // verifica si es mayor a 4
                if (ArrLex[1].equals("=") && (ArrLex[3].equals("+") || ArrLex[3].equals("-")) || ArrLex[3].equals("/")
                        || ArrLex[3].equals("*") || ArrLex[3].equals("%")) {// identifica instruccion aritmetica
                    // comprueba si el cuarto elemento de ArrLexes uno de los operadores aritméticos
                    // "+", "-", "/", "*" o "%". Esto sugiere una operación aritmética.
                    NuevoTriplo(LiPoLi[i]);
                } else {
                    if (ArrLex[1].equals("=") && ArrLex[2].equals("(") || ArrLex[4].equals("(")
                            || (ArrLex[2].equals("(") && ArrLex[8].equals("("))) {
                        NuevoTriplo(LiPoLi[i]);
                    }
                }
            }

        }

        mostrarCuadruplosEnVentana();
        // llama a una función`mostrarCuadruplosEnVentana`
    }

    private static void NuevoTriplo(String linea) {
        String[] ArrLex = linea.split("[ ]+");
        String[] lexes = new String[ArrLex.length - 3];

        if (lexes.length == 3) {
            // w = y + 24
            System.arraycopy(ArrLex, 2, lexes, 0, 3);
            NLinea++; // lexes[0]=Operando1
                      // lexes[2]=Operando 2
                      // lexes[1]=Operador que haya y en este caso es una operacion que involucra 2
                      // operandos y 1 operador
            ArrTriplo.add(new BaseTriplo(NLinea, "T1", lexes[0], lexes[2], lexes[1]));
            NLinea++;
            ArrTriplo.add(new BaseTriplo(NLinea, ArrLex[0], "T1", "", "="));
            ///////////////////////////////////////////////// ArrLex[0] representa el dato a
            ///////////////////////////////////////////////// la izquieda de la igualdad
        }

        if (lexes.length == 5) {
            System.arraycopy(ArrLex, 2, lexes, 0, 5);
            if ((lexes[1].equals("+") || lexes[1].equals("-"))
                    && (lexes[3].equals("+") || lexes[3].equals("-"))) {
                // lexes[1] puede ser '+' o '-'
                // lexes[3] puede ser '+' o '-'
                // esto es en el caso de que tengamos 2 operaciones
                // w = y + 24 - 5
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T1", lexes[0], lexes[2], lexes[1]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T1", "T1", lexes[4], lexes[1]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, ArrLex[0], "T1", "", "="));
            } else if ((lexes[1].equals("+") || lexes[1].equals("-"))
                    && (lexes[3].equals("*") || lexes[3].equals("/") || lexes[3].equals("%"))) {
                // w = y + 24 * 5
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T1", lexes[2], lexes[4], lexes[3]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T2", lexes[0], "T1", lexes[1]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, ArrLex[0], "T2", "", "="));
            } else if ((lexes[1].equals("*") || lexes[1].equals("/") || lexes[1].equals("%"))
                    && (lexes[3].equals("+") || lexes[3].equals("-"))) {
                // w = y * 24 + 5
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T1", lexes[0], lexes[2], lexes[1]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T1", "T1", lexes[4], lexes[3]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, ArrLex[0], "T1", "", "="));
            } else if ((lexes[1].equals("*") || lexes[1].equals("/") || lexes[1].equals("%"))
                    && (lexes[3].equals("*") || lexes[3].equals("/") || lexes[3].equals("%"))) {
                // w = y * 24 * 5
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T1", lexes[0], lexes[2], lexes[1]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, "T1", "T1", lexes[4], lexes[3]));
                NLinea++;
                ArrTriplo.add(new BaseTriplo(NLinea, ArrLex[0], "T1", "", "="));
            }

        }

    }

    private static int indice = -1; // Variable para controlar el índice del cuádruplo actual
    private static JFrame frame; // Variable para la ventana
    private static DefaultTableModel model; // Modelo de tabla para los cuádruplos
    private static JTable table;

    private static void mostrarCuadruplosEnVentana() {
        // Si la ventana no está creada, la creamos
        if (frame == null) {
            // Creamos una ventana emergente
            frame = new JFrame("Cuádruplos");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

            // Creamos un modelo de tabla para los cuádruplos
            model = new DefaultTableModel();
            model.addColumn("Linea");
            model.addColumn("Dato Objeto");
            model.addColumn("Dato Fuente 1");
            model.addColumn("Dato Fuente 2");
            model.addColumn("Operador");

            // Creamos una tabla con el modelo de tabla
            table = new JTable(model);
            table.setPreferredScrollableViewportSize(new Dimension(500, 300));
            JScrollPane scrollPane = new JScrollPane(table);

            // Agregamos la tabla al contenido de la ventana
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

            // Añadimos un KeyListener a la tabla para esperar la entrada del teclado
            table.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    // Al presionar la tecla F2, mostramos el siguiente cuádruplo
                    if (e.getKeyCode() == KeyEvent.VK_F2) {
                        mostrarSiguienteCuadruplo();
                    }
                }
            });

            // Hacemos que la tabla pueda recibir eventos de teclado
            table.setFocusable(true);
            table.requestFocus();

            // Mostramos la ventana
            frame.setVisible(true);
        }

        // Mostramos el primer cuádruplo
        mostrarSiguienteCuadruplo();
    }

    private static void mostrarSiguienteCuadruplo() {
        // Incrementamos el índice para mostrar el próximo cuádruplo
        indice++;

        // Verificamos si hay más cuádruplos por mostrar
        if (indice < ArrTriplo.size()) {
            // Obtenemos el cuádruplo actual
            BaseTriplo t = ArrTriplo.get(indice);

            // Agregamos el cuádruplo al modelo de tabla
            model.addRow(new Object[] { t.getLinea(), t.getDatoObjeto(), t.getDatoFuente(),
                    t.getDatoFuente2(), t.getOperador() });

            // Hacemos que la última fila sea visible
            table.scrollRectToVisible(table.getCellRect(table.getRowCount() - 1, 0, true));
        } else {
            // Si no hay más cuádruplos, mostramos un mensaje y cerramos la ventana
            JOptionPane.showMessageDialog(frame, "No hay más cuádruplos por mostrar.", "Fin de los Cuádruplos",
                    JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        }
    }

}
