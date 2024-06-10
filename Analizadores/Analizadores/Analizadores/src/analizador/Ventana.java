package analizador;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Ventana extends javax.swing.JFrame {

    int ErrorTO = 0;
    int FlagOP = 0;
    int ContErrSem;
    int ContErriden;
    int ContErriAsig;
    int ErrIni;
    int ContErrSem2;
    int ContSep;
    int ContOPA;
    int ContOPREL;
    int ContOPAS;
    int ContLOG;
    int ContID;
    int ContENT;
    int ContFLOAT;
    int ContCADS;
    int ContEQ;

    public String[] TabLexemas = { "Lexema", "Tipo de dato ", "#Linea", "Token" };
    public String[] TabPost = { "Numero", "Dato Objeto", "Dato Fuente", "Operador" };
    public String[] TabError = { "Token Error", "Lexema", "#Linea Error", "Descripcion del error" };
    public String[] Visual = { "Checa", "ChecaMas", "Checa2", "Cheacar3" };
    public DefaultTableModel TablaLexema = new DefaultTableModel(null, TabLexemas);
    public DefaultTableModel TablaError = new DefaultTableModel(null, TabError);
    public DefaultTableModel TablaVisual = new DefaultTableModel(null, Visual);
    public DefaultTableModel TablaPost = new DefaultTableModel(null, TabPost);
    public String Etiqueta = "";
    public String NewTexto = "";
    public String AuxError = "";
    ArrayList<Analizador> PalabraList = new ArrayList<>();
    ArrayList<Analizador> Error = new ArrayList<>();
    ArrayList<Analizador> Etiquetailiar = new ArrayList<>();
    ArrayList<Analizador> Postorden = new ArrayList<>();
    ArrayList<Analizador> Asignacion = new ArrayList<>();
    ArrayList<Analizador> AritmeticaEnt = new ArrayList<>();
    ArrayList<Analizador> AritmeticaReal = new ArrayList<>();
    ArrayList<Analizador> AritmeticaCad = new ArrayList<>();

    public Ventana() {
        initComponents();
        // Asignacion
        Asignacion.add(new Analizador("pikachu=pikachu"));// Entero = Entero
        Asignacion.add(new Analizador("pichu=pichu"));// Real = Real
        Asignacion.add(new Analizador("pichu=pikachu"));// Real = Entero
        Asignacion.add(new Analizador("raichu=raichu"));// Cadena = Cadena

        // Entero = Entero OPA Entero
        AritmeticaEnt.add(new Analizador("pikachu+pikachu"));// Entero = Entero
        AritmeticaEnt.add(new Analizador("pikachu-pikachu"));// Entero = Entero
        AritmeticaEnt.add(new Analizador("pikachu*pikachu"));// Entero = Entero

        // Cad OPA

        AritmeticaCad.add(new Analizador("raichu+raichu"));// cadena = cadena
        AritmeticaCad.add(new Analizador("raichu-raichu"));// cadena = cadena

        // Tabla de OPS Real = Real OPA Real
        AritmeticaReal.add(new Analizador("pichu+pichu"));// Real = Real
        AritmeticaReal.add(new Analizador("pichu*pichu"));// Real = Real
        AritmeticaReal.add(new Analizador("pichu/pichu"));// Real = Real
        AritmeticaReal.add(new Analizador("pichu-pichu"));// Real = Real
        // Real = Entero OPA Entero
        AritmeticaReal.add(new Analizador("pikachu+pikachu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pikachu-pikachu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pikachu*pikachu"));// Entero = Entero
        // Real = Real OPA Entero
        AritmeticaReal.add(new Analizador("pichu+pikachu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pichu-pikachu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pichu*pikachu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pichu/pikachu"));// Entero = Entero
        // Real = Entero OPA Real
        AritmeticaReal.add(new Analizador("pikachu+pichu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pikachu-pichu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pikachu*pichu"));// Entero = Entero
        AritmeticaReal.add(new Analizador("pikachu/pichu"));// Entero = Entero

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        Compilar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        DHL = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Visual2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tdlDatos1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        JButton ensambladorButton = new javax.swing.JButton(); // Botón Ensamblador

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Compilar.setText("Compilar");
        Compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompilarActionPerformed(evt);
            }
        });

        DHL.setColumns(20);
        DHL.setRows(5);
        jScrollPane2.setViewportView(DHL);

        Visual2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane4.setViewportView(Visual2);

        jButton1.setText("Texto de Prueba");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tdlDatos1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane3.setViewportView(tdlDatos1);

        jButton2.setText("Codigo Intermedio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Codigo Optimizado");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        ensambladorButton.setText("Ensamblador"); // Configuración del nuevo botón
        ensambladorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensambladorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane3,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 528,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(Compilar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 131,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 170,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton4,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ensambladorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
                                        javax.swing.GroupLayout.PREFERRED_SIZE) // Añadir el nuevo botón al layout
                                .addGap(79, 79, 79)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jScrollPane2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Compilar)
                                        .addComponent(jButton2)
                                        .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ensambladorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)) // Añadir el nuevo botón al
                                                                                         // layout
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)));

        pack();
    }// </editor-fold>//GEN-END:initComponents
     // ---- erorres

    public void EliminarRepetidas() {
        for (int i = 0; i < PalabraList.size(); i++) {

            if (PalabraList.get(i).getToken().equals("Eliminar")) {
                PalabraList.remove(i);
                i--;
            }
            for (int j = i + 1; j < PalabraList.size(); j++) {
                if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                    PalabraList.remove(j);
                    j--;
                }
            }
        }
    }

    public void AgregandoErrolesLexicos() {
        for (int i = 0; i < PalabraList.size(); i++) {

            if (PalabraList.get(i).getToken().equals("Eliminar")) {
                if (PalabraList.get(i).getLexema() == "") {

                } else {
                    Error.add(new Analizador("ErrSemantico" + ContErrSem2, PalabraList.get(i).getLexema(),
                            PalabraList.get(i).getLinea(), "La palabra que ingreso no cumple con el lenguaje regular",
                            "", "", ""));
                    ContErrSem2++;
                }

            }
        }
    }

    public void ErrorInicializacion(int i) {
        if (PalabraList.get(i - 1).getTokenEs().equals("NOID")) {
            Error.add(new Analizador("ErrIn" + ErrIni, PalabraList.get(i - 1).getLexema(),
                    PalabraList.get(i).getLinea(), "Intenta igualar un valor constante", "", "", ""));
            ErrIni++;
        } else {
            if (PalabraList.get(i - 1).getTokenEs().equals("NOIN")) {
                Error.add(new Analizador("ErrIn" + ErrIni, PalabraList.get(i - 1).getLexema(),
                        PalabraList.get(i).getLinea(), "Variable no inicializada", "", "", ""));
                ErrIni++;
            } else {
            }
        }
    }

    public void Asiganciones(int i, String xd) {
        int FlagGood = 0;
        xd = PalabraList.get(i - 1).getTipo() + "=" + PalabraList.get(i + 1).getTipo();
        if (PalabraList.get(i + 1).getTokenEs().equals("ID") | PalabraList.get(i + 1).getTokenEs().equals("NOID")) {
            for (int k = 0; k < Asignacion.size(); k++) {
                if (xd.equals(Asignacion.get(k).getAsig())) {
                    FlagGood = 1;
                }
            }
            if (FlagGood == 0) {
                Error.add(new Analizador("EAsig" + ContErriAsig, PalabraList.get(i + 1).getLexema(),
                        PalabraList.get(i).getLinea(), "Asigancion no permitida: " + " " + xd, "", "", ""));
                ContErriAsig++;
            }
        } else {
            if (PalabraList.get(i + 1).getTokenEs() == "" || PalabraList.get(i + 1).getTokenes() == "") {
                Error.add(new Analizador("ErrIn" + ContErriAsig, PalabraList.get(i + 1).getLexema(),
                        PalabraList.get(i).getLinea(), " Variable no inicializada ", "", "", ""));
                ErrIni++;
            }
        }

    }

    public void AnalisisEnt(int i, int ContadoOP, String AuxError0, String AuxError1, String AuxError2,
            String AuxError3) {
        for (int h = i; h < ContadoOP; h++) {
            int FlagG2 = 0;
            if (PalabraList.get(h + 1).getTokenEs().equals("ID") | PalabraList.get(h + 1).getTokenEs().equals("NOID")
                    && PalabraList.get(h + 3).getTokenEs().equals("ID")
                            | PalabraList.get(h + 3).getTokenEs().equals("NOID")) {

                AuxError2 = PalabraList.get(h + 1).getTipo() + PalabraList.get(h + 2).getLexema()
                        + PalabraList.get(h + 3).getTipo();
                AuxError1 = PalabraList.get(h + 3).getLexema();
                AuxError3 = PalabraList.get(h + 1).getLexema();
                AuxError0 = PalabraList.get(h + 1).getLexema() + " " + PalabraList.get(h + 2).getLexema() + " "
                        + PalabraList.get(h + 3).getLexema();

                for (int j = 0; j < AritmeticaEnt.size(); j++) {
                    if (AuxError2.equals(AritmeticaEnt.get(j).getAsig())) {
                        FlagG2 = 1;
                    }
                }
                if (FlagG2 == 0) {
                    if (PalabraList.get(h + 1).getTipo().equals("pichu")
                            | PalabraList.get(h + 1).getTipo().equals("raichu")
                            && PalabraList.get(h + 3).getTipo().equals("pichu")
                                    | PalabraList.get(h + 3).getTipo().equals("raichu")) {
                        Error.add(new Analizador("ErrOpENT" + ContErrSem, AuxError3 + " , " + AuxError1,
                                PalabraList.get(i).getLinea(), "Incompatibilidad de tipos: " + "pikachu", "", "", ""));
                        ContErrSem++;
                    } else {
                        if (PalabraList.get(h + 1).getTipo().equals("pichu")
                                | PalabraList.get(h + 1).getTipo().equals("raichu")) {
                            Error.add(new Analizador("ErrOpENT" + ContErrSem, AuxError3, PalabraList.get(i).getLinea(),
                                    "Incompatibilidad de tipos:" + " " + "pikachu", "", "", ""));
                            ContErrSem++;
                        } else {
                            if (PalabraList.get(h + 3).getTipo().equals("pichu")
                                    | PalabraList.get(h + 3).getTipo().equals("raichu")) {
                                Error.add(new Analizador("ErrOpENT" + ContErrSem, AuxError1,
                                        PalabraList.get(i).getLinea(), "Incompatibilidad de tipos:" + " " + "pikachu",
                                        "", "", ""));
                                ContErrSem++;
                            } else {
                                Error.add(new Analizador("ErrOpENT" + ContErrSem, AuxError0,
                                        PalabraList.get(i).getLinea(), "Tipo de operacion no soportada por pikachu", "",
                                        "", ""));
                                ContErrSem++;
                            }
                        }
                    }
                }
            } else {
                if (PalabraList.get(h + 1).getTokenEs() == "" || PalabraList.get(h + 1).getTokenEs() == "NOIN") {
                    Error.add(new Analizador("ErrInVar" + ContErriden, PalabraList.get(h + 1).getLexema(),
                            PalabraList.get(i).getLinea(), "Variable indefinida", "", "", ""));
                    ContErriden++;
                }
                if (PalabraList.get(h + 3).getTokenEs() == "" || PalabraList.get(h + 3).getTokenEs() == "NOIN") {
                    Error.add(new Analizador("ErrInVar" + ContErriden, PalabraList.get(h + 3).getLexema(),
                            PalabraList.get(i).getLinea(), "Variable indefinida", "", "", ""));
                    ContErriden++;
                }
            }
            if (PalabraList.get(h + 3).getLexema().equals(";")) {
                h = ContadoOP;
            }

        }
    }

    public void AnalisisCad(int i, int ContadoOP, String AuxError0, String AuxError1, String AuxError2,
            String AuxError3) {

        for (int h = i; h < ContadoOP; h++) {
            int FlagG2 = 0;
            if (PalabraList.get(h + 1).getTokenEs().equals("ID") | PalabraList.get(h + 1).getTokenEs().equals("NOID")
                    && PalabraList.get(h + 3).getTokenEs().equals("ID")
                            | PalabraList.get(h + 3).getTokenEs().equals("NOID")) {

                AuxError2 = PalabraList.get(h + 1).getTipo() + PalabraList.get(h + 2).getLexema()
                        + PalabraList.get(h + 3).getTipo();
                AuxError1 = PalabraList.get(h + 3).getLexema();
                AuxError3 = PalabraList.get(h + 1).getLexema();
                AuxError0 = PalabraList.get(h + 1).getLexema() + " " + PalabraList.get(h + 2).getLexema() + " "
                        + PalabraList.get(h + 3).getLexema();

                for (int j = 0; j < AritmeticaCad.size(); j++) {
                    if (AuxError2.equals(AritmeticaCad.get(j).getAsig())) {
                        FlagG2 = 1;
                    }
                }
                if (FlagG2 == 0) {
                    if (PalabraList.get(h + 1).getTipo().equals("pichu")
                            | PalabraList.get(h + 1).getTipo().equals("pikachu")
                            && PalabraList.get(h + 3).getTipo().equals("pichu")
                                    | PalabraList.get(h + 3).getTipo().equals("pikachu")) {
                        Error.add(new Analizador("ErrOpCAD" + ContErrSem, AuxError3 + " , " + AuxError1,
                                PalabraList.get(i).getLinea(), "Incompatibilidad de tipos: " + "raichu", "", "", ""));
                        ContErrSem++;
                    } else {
                        if (PalabraList.get(h + 1).getTipo().equals("pichu")
                                | PalabraList.get(h + 1).getTipo().equals("pikachu")) {
                            Error.add(new Analizador("ErrOpCAD" + ContErrSem, AuxError3, PalabraList.get(i).getLinea(),
                                    "Incompatibilidad de tipos:" + " " + "raichu", "", "", ""));
                            ContErrSem++;
                        } else {
                            if (PalabraList.get(h + 3).getTipo().equals("pichu")
                                    | PalabraList.get(h + 3).getTipo().equals("pikachu")) {
                                Error.add(new Analizador("ErrOpCAD" + ContErrSem, AuxError1,
                                        PalabraList.get(i).getLinea(), "Incompatibilidad de tipos:" + " " + "raichu",
                                        "", "", ""));
                                ContErrSem++;
                            } else {
                                Error.add(new Analizador("ErrOpCAD" + ContErrSem, AuxError0,
                                        PalabraList.get(i).getLinea(),
                                        "Tipo de operacion no soportada por datos tipo raichu", "", "", ""));
                                ContErrSem++;
                            }
                        }
                    }
                }
            } else {
                if (PalabraList.get(h + 1).getTokenEs() == "" || PalabraList.get(h + 1).getTokenEs() == "NOIN") {
                    Error.add(new Analizador("ErrInVar" + ContErriden, PalabraList.get(h + 1).getLexema(),
                            PalabraList.get(i).getLinea(), "Variable indefinida", "", "", ""));
                    ContErriden++;
                }
                if (PalabraList.get(h + 3).getTokenEs() == "" || PalabraList.get(h + 3).getTokenEs() == "NOIN") {
                    Error.add(new Analizador("ErrInVar" + ContErriden, PalabraList.get(h + 3).getLexema(),
                            PalabraList.get(i).getLinea(), "Variable indefinida", "", "", ""));
                    ContErriden++;
                }
            }
            if (PalabraList.get(h + 3).getLexema().equals(";")) {
                h = ContadoOP;
            }

        }

    }

    public void AnalisisCar(int i, int ContadoOP, String AuxError0, String AuxError1, String AuxError2,
            String AuxError3) {

        for (int h = i; h < ContadoOP; h++) {
            int FlagG2 = 0;
            if (PalabraList.get(h + 1).getTokenEs().equals("ID") | PalabraList.get(h + 1).getTokenEs().equals("NOID")
                    && PalabraList.get(h + 3).getTokenEs().equals("ID")
                            | PalabraList.get(h + 3).getTokenEs().equals("NOID")) {

                AuxError2 = PalabraList.get(h + 1).getTipo() + PalabraList.get(h + 2).getLexema()
                        + PalabraList.get(h + 3).getTipo();
                AuxError1 = PalabraList.get(h + 3).getLexema();
                AuxError3 = PalabraList.get(h + 1).getLexema();
                AuxError0 = PalabraList.get(h + 1).getLexema() + " " + PalabraList.get(h + 2).getLexema() + " "
                        + PalabraList.get(h + 3).getLexema();

                for (int j = 0; j < AritmeticaReal.size(); j++) {
                    if (AuxError2.equals(AritmeticaReal.get(j).getAsig())) {
                        FlagG2 = 1;
                    }
                }
                if (FlagG2 == 0) {
                    if (PalabraList.get(h + 1).getTipo().equals("raichu")
                            && PalabraList.get(h + 3).getTipo().equals("raichu")) {
                        Error.add(new Analizador("ErrOpCAR" + ContErrSem, AuxError3 + " , " + AuxError1,
                                PalabraList.get(i).getLinea(), "Incompatibilidad de tipos: " + "pichu", "", "", ""));
                        ContErrSem++;
                    } else {
                        if (PalabraList.get(h + 1).getTipo().equals("raichu")) {
                            Error.add(new Analizador("ErrOpCAR" + ContErrSem, AuxError3, PalabraList.get(i).getLinea(),
                                    "Incompatibilidad de tipos:" + " " + "pichu", "", "", ""));
                            ContErrSem++;
                        } else {
                            if (PalabraList.get(h + 3).getTipo().equals("raichu")) {
                                Error.add(new Analizador("ErrOpCAR" + ContErrSem, AuxError1,
                                        PalabraList.get(i).getLinea(), "Incompatibilidad de tipos:" + " " + "pichu", "",
                                        "", ""));
                                ContErrSem++;
                            } else {
                                Error.add(new Analizador("ErrOpCAR" + ContErrSem, AuxError0,
                                        PalabraList.get(i).getLinea(), "Tipo de operacion no soportada por tipos pichu",
                                        "", "", ""));
                                ContErrSem++;
                            }
                        }
                    }
                }
            } else {
                if (PalabraList.get(h + 1).getTokenEs() == "" || PalabraList.get(h + 1).getTokenEs() == "NOIN") {
                    Error.add(new Analizador("ErrInVar" + ContErriden, PalabraList.get(h + 1).getLexema(),
                            PalabraList.get(i).getLinea(), "Variable indefinida", "", "", ""));
                    ContErriden++;
                }
                if (PalabraList.get(h + 3).getTokenEs() == "" || PalabraList.get(h + 3).getTokenEs() == "NOIN") {
                    Error.add(new Analizador("ErrInVar" + ContErriden, PalabraList.get(h + 3).getLexema(),
                            PalabraList.get(i).getLinea(), "Variable indefinida", "", "", ""));
                    ContErriden++;
                }
            }
            if (PalabraList.get(h + 3).getLexema().equals(";")) {
                h = ContadoOP;
            }

        }

    }

    // ---- erorres

    public void AsignandoTokens() {
        // Asignando numeros a los tokens
        String auxtokens = "";
        String auxtokens2 = "";
        int tope = 0;
        for (int i = 0; i < PalabraList.size(); i++) {
            if (PalabraList.get(i).getTokenes().equals("SEP")) { // agregando lexema separador
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContSep++;
                    auxtokens2 = String.valueOf(ContSep);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
            if (PalabraList.get(i).getTokenes().equals("OPA")) { // agregando lexema operador aritmetico
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContOPA++;
                    auxtokens2 = String.valueOf(ContOPA);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
            if (PalabraList.get(i).getTokenes().equals("OPR")) { // agregando lexema operador RELACIONAL
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContOPREL++;
                    auxtokens2 = String.valueOf(ContOPREL);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
            if (PalabraList.get(i).getTokenes().equals("OPL")) { // agregando lexema operador logico
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContLOG++;
                    auxtokens2 = String.valueOf(ContLOG);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
            if (PalabraList.get(i).getTokenes().equals("IDE")) { // agregando lexema operador logico
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContID++;
                    auxtokens2 = String.valueOf(ContID);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
            if (PalabraList.get(i).getTokenes().equals("NENT")) { // agregando lexema operador logico
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContENT++;
                    auxtokens2 = String.valueOf(ContENT);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
            if (PalabraList.get(i).getTokenes().equals("NFLO")) { // agregando lexema operador logico
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContFLOAT++;
                    auxtokens2 = String.valueOf(ContFLOAT);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
            if (PalabraList.get(i).getTokenes().equals("NCAD")) { // agregando lexema operador logico
                tope = 0;
                for (int j = 0; j < i; j++) {
                    if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                        tope++;
                    }
                }
                if (tope == 0) {
                    ContCADS++;
                    auxtokens2 = String.valueOf(ContCADS);
                    auxtokens = PalabraList.get(i).getTokenes() + auxtokens2;
                    PalabraList.get(i).setTokenes(auxtokens);
                    tope++;
                }
            }
        }
    }

    private void CompilarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CompilarActionPerformed

        NewTexto = DHL.getText();
        ContSep = 0;
        ContOPA = 0;
        ContOPREL = 0;
        ContOPAS = 0;
        ContLOG = 0;
        ContID = 0;
        ContENT = 0;
        ContFLOAT = 0;
        ContCADS = 0;
        ContEQ = 0;

        // limpiando el piso

        TablaLexema.setRowCount(0);
        PalabraList.removeAll(PalabraList);

        Visual2.setModel(TablaError);
        TablaError.setRowCount(0);
        Error.removeAll(Error);

        // Visual1.setModel(TablaVisual);
        TablaVisual.setRowCount(0);
        Etiquetailiar.removeAll(Etiquetailiar);

        ContErrSem = 0;
        ContErriden = 0;
        ContErriAsig = 0;
        ErrIni = 0;
        ContErrSem2 = 0;

        // NewTexto = DHL.getText();
        NewTexto = NewTexto.replaceAll("\\s +", " ");
        char[] tch = NewTexto.toCharArray();
        int NumLinea = 1;
        int CadenaInicio = 0;
        int ContadorEntero = 0;
        int ContadorCad = 0;
        int ContadorCar = 0;

        for (int i = 0; i < tch.length; i++) {
            if (tch[i] != '\n') {
                Etiqueta += tch[i];
            }

            if (tch[i] == '"') {
                CadenaInicio++;
            }

            if (tch[i] == 32) {
                if (CadenaInicio == 0) {
                    Etiqueta = Etiqueta.replaceAll(" ", "");
                    PalabraList.add(new Analizador(Etiqueta, "", String.valueOf(NumLinea), "", "", "", ""));
                    Etiqueta = "";
                } else {
                    if (CadenaInicio == 2) {
                        PalabraList.add(new Analizador(Etiqueta, "", String.valueOf(NumLinea), "", "", "", ""));
                        Etiqueta = "";
                        CadenaInicio = 0;
                    }
                }
            } else if (tch[i] == 10) {
                if (CadenaInicio == 0) {
                    Etiqueta = Etiqueta.replaceAll(" ", "");
                    PalabraList.add(new Analizador(Etiqueta, "", String.valueOf(NumLinea), "", "", "", ""));
                    NumLinea++;
                    Etiqueta = "";
                } else {
                    if (CadenaInicio == 2) {
                        PalabraList.add(new Analizador(Etiqueta, "", String.valueOf(NumLinea), "", "", "", ""));
                        NumLinea++;
                        Etiqueta = "";
                        CadenaInicio = 0;
                    }
                }
            } else if (i == tch.length - 1) {
                if (CadenaInicio == 0) {
                    Etiqueta = Etiqueta.replaceAll(" ", "");
                    PalabraList.add(new Analizador(Etiqueta, "", String.valueOf(NumLinea), "", "", "", ""));
                    Etiqueta = "";
                } else {
                    if (CadenaInicio == 2) {
                        PalabraList.add(new Analizador(Etiqueta, "", String.valueOf(NumLinea), "", "", "", ""));
                        Etiqueta = "";
                        CadenaInicio = 0;
                    }
                }
            }
        }

        // Agregando atributos. separando palabras del no lenjuage
        for (int i = 0; i < PalabraList.size(); i++) {
            Analizador Etiquetai = PalabraList.get(i);
            ErrorTO = 0;

            Pattern ExpReg = Pattern.compile("[(|)|}|{|,|;]");
            Matcher Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                if (PalabraList.get(i).getLexema().compareTo(";") == 0) {
                    ContadorEntero = 0;
                    ContadorCad = 0;
                    ContadorCar = 0;
                    Etiquetai.setTokenEs("ESP");
                    PalabraList.set(i, Etiquetai);
                }
                Etiquetai.setTokenes("SEP"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
            }

            ExpReg = Pattern.compile("[\"\"]"); // para agregar comillas
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
            }

            ExpReg = Pattern.compile("[+|/|*|-|%]"); // expersiom para operador aritmetico
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                Etiquetai.setTokenEs("OP");
                PalabraList.set(i, Etiquetai);
                Etiquetai.setTokenes("OPA"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
            }

            ExpReg = Pattern.compile("([<]|[>]|[<][=]|[>][=]|[=][=]|[!][=]|[?]|[¿])"); // operadores relacioneales
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                Etiquetai.setTokenes("OPR"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
            }

            ExpReg = Pattern.compile("[=]"); // operacion de asginacion
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                Etiquetai.setTokenEs("ASIN");
                PalabraList.set(i, Etiquetai);
                Etiquetai.setTokenes("OPAS"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
            }

            ExpReg = Pattern.compile("[ ]");
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                if (PalabraList.get(i).getLexema().compareTo(" ") == 0
                        | PalabraList.get(i).getLexema().compareTo("If") == 0) {
                    PalabraList.get(i).setToken("Eliminar");
                }
            }

            ExpReg = Pattern.compile("(\\&\\&|\\|\\|)"); // operadores logicos
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                Etiquetai.setTokenes("OPL");
                PalabraList.set(i, Etiquetai);
            }

            ExpReg = Pattern.compile("E4[a-z]4"); // identificadores
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                int yes = 0;
                if (ContadorEntero == 1) {
                    Etiquetai.setTipo("pikachu");
                    PalabraList.set(i, Etiquetai);
                    Etiquetai.setTokenEs("ID");
                    PalabraList.set(i, Etiquetai);
                    Etiquetai.setTokenes("IDE"); // agregando los tokens uwu
                    PalabraList.set(i, Etiquetai);
                    yes++;
                }
                if (ContadorCad == 1) {
                    Etiquetai.setTipo("raichu");
                    PalabraList.set(i, Etiquetai);
                    Etiquetai.setTokenEs("ID");
                    PalabraList.set(i, Etiquetai);
                    Etiquetai.setTokenes("IDE"); // agregando los tokens uwu
                    PalabraList.set(i, Etiquetai);
                    yes++;
                }
                if (ContadorCar == 1) {
                    Etiquetai.setTipo("pichu");
                    PalabraList.set(i, Etiquetai);
                    Etiquetai.setTokenEs("ID");
                    PalabraList.set(i, Etiquetai);
                    Etiquetai.setTokenes("IDE"); // agregando los tokens uwu
                    PalabraList.set(i, Etiquetai);
                    yes++;
                }
                if (yes == 0) {
                    Etiquetai.setTokenEs("NOIN");
                    PalabraList.set(i, Etiquetai);
                    Etiquetai.setTokenes("IDE"); // agregando los tokens uwu
                    PalabraList.set(i, Etiquetai);
                }
            }

            ExpReg = Pattern.compile("^4\\d+4$"); // enteros
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                Etiquetai.setTipo("pikachu");
                PalabraList.set(i, Etiquetai);
                ErrorTO = 1;
                Etiquetai.setTokenEs("NOID");
                PalabraList.set(i, Etiquetai);
                Etiquetai.setTokenes("NENT"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
            }

            ExpReg = Pattern.compile("\\d+\\.4\\d+4"); // flotantes
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                ErrorTO = 1;
                ErrorTO = 1;
                Etiquetai.setTipo("pichu");
                PalabraList.set(i, Etiquetai);
                ErrorTO = 1;
                Etiquetai.setTokenEs("NOID");
                PalabraList.set(i, Etiquetai);
                Etiquetai.setTokenes("NFLO"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
            }

            ExpReg = Pattern.compile("(pikachu|pichu|raichu)");// tipos de dato
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.matches()) {
                Etiquetai.setTokenes("NCAD"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
                ErrorTO = 1;
                if (PalabraList.get(i).getLexema().compareTo("pikachu") == 0) {
                    ContadorEntero = 1;
                }
                if (PalabraList.get(i).getLexema().compareTo("raichu") == 0) {
                    ContadorCad = 1;
                }
                if (PalabraList.get(i).getLexema().compareTo("pichu") == 0) {
                    ContadorCar = 1;
                }
            }

            ExpReg = Pattern.compile("\"[^\"]*\""); // datos tipo cadena
            Match = ExpReg.matcher(PalabraList.get(i).getLexema());
            if (Match.find()) {
                ErrorTO = 1;
                Etiquetai.setTipo("raichu");
                PalabraList.set(i, Etiquetai);
                ErrorTO = 1;
                Etiquetai.setTokenEs("NOID");
                PalabraList.set(i, Etiquetai);
                Etiquetai.setTokenes("NCAD"); // agregando los tokens uwu
                PalabraList.set(i, Etiquetai);
            }

        }

        AsignandoTokens();

        // Reasignando valores existente.
        for (int i = 0; i < PalabraList.size(); i++) {
            for (int j = i + 1; j < PalabraList.size(); j++) {
                if (PalabraList.get(i).getLexema().equals(PalabraList.get(j).getLexema())) {
                    PalabraList.get(j).setTipo(PalabraList.get(i).getTipo());
                    PalabraList.get(j).setTokenEs(PalabraList.get(i).getTokenEs());
                    PalabraList.get(j).setTokenes(PalabraList.get(i).getTokenes());
                }
            }
        }

        // GENERANDO CODIGO POST ORDEN

        // artmetia postorden

        int ContadoOP;
        String AuxError2 = "";
        String AuxError1 = "";
        String AuxError3 = "";
        String AuxError0 = "";

        for (int i = 0; i < PalabraList.size(); i++) {
            if (PalabraList.get(i).getLexema().equals("=")) {
                if (PalabraList.get(i - 1).getTokenEs().equals("ID")) {
                    FlagOP = 0;
                    ContadoOP = 0;

                    for (int j = i + 1; j < PalabraList.size(); j++) {
                        if (PalabraList.get(j).getTokenEs().equals("OP")) {
                            FlagOP = 1;
                        }
                        ContadoOP++;
                        if (PalabraList.get(j).getLexema().equals(";")) {
                            j = PalabraList.size() - 1;
                        }
                    }

                    ContadoOP = ContadoOP + i;

                    if (FlagOP == 1) {
                        // PARA BUSCAR ERRORES DE TIPO CAR.
                        if (PalabraList.get(i - 1).getTipo().equals("pikachu")) {
                            AnalisisEnt(i, ContadoOP, AuxError0, AuxError1, AuxError2, AuxError3);
                        } else {
                            if (PalabraList.get(i - 1).getTipo().equals("raichu")) {
                                AnalisisCad(i, ContadoOP, AuxError0, AuxError1, AuxError2, AuxError3);
                            } else {
                                AnalisisCar(i, ContadoOP, AuxError0, AuxError1, AuxError2, AuxError3);
                            }
                        }

                    } else { // Else para buscar por asignacion.
                        Asiganciones(i, AuxError2);
                    }
                } else {
                    ErrorInicializacion(i);
                }
            }

        }

        // AgregandoErrolesLexicos();
        EliminarRepetidas();

        for (int i = 0; i < PalabraList.size(); i++) {
            TablaLexema.addRow(new Object[] { PalabraList.get(i).getLexema(), PalabraList.get(i).getTipo(),
                    PalabraList.get(i).getLinea(), PalabraList.get(i).getTokenes() });
        }
        tdlDatos1.setModel(TablaLexema);

        for (int i = 0; i < Error.size(); i++) {
            TablaError.addRow(new Object[] { Error.get(i).getLexema(), Error.get(i).getTipo(), Error.get(i).getLinea(),
                    Error.get(i).getToken() });
        }
        Visual2.setModel(TablaError);
    }// GEN-LAST:event_CompilarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        DHL.setText(
                """
                        pikachu E4a4 , E4b4 , E4c4 ;
                        pichu E4d4 , E4e4 , E4f4 ;
                        raichu E4g4 , E4h4 , E4i4 ;

                        E4b4 = 454 ;
                        E4a4 = 4554 + 424 ;
                        E4b4 = 4554 + 424 ;
                        E4h4 = "hola" + "mundo" * "lindo" ;
                        E4e4 = 1265.425634 ;
                            """);

    }// GEN-LAST:event_jButton1ActionPerformed

    private void ensambladorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarVentanaEnsamblador();
    }

    private void mostrarVentanaEnsamblador() {
        JFrame frame = new JFrame("Convertir a Ensamblador");
        JTextArea inputTextArea = new JTextArea(10, 30);
        JButton convertButton = new JButton("Convertir");
        JRadioButton originalCodeRadioButton = new JRadioButton("Código Original");
        JRadioButton optimizedCodeRadioButton = new JRadioButton("Código Optimizado");

        ButtonGroup group = new ButtonGroup();
        group.add(originalCodeRadioButton);
        group.add(optimizedCodeRadioButton);

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(inputTextArea));
        panel.add(originalCodeRadioButton);
        panel.add(optimizedCodeRadioButton);
        panel.add(convertButton);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        convertButton.addActionListener(evt -> {
            String code = inputTextArea.getText();
            boolean isOptimized = optimizedCodeRadioButton.isSelected();

            // Llamar a la clase Ensamblador para convertir el código
            Ensamblador ensamblador = new Ensamblador();
            String assemblyCode = ensamblador.convertirACodigoEnsamblador(code, isOptimized);

            // Mostrar el código ensamblador en un cuadro de diálogo
            JFrame outputFrame = new JFrame("Código Ensamblador");
            JTextArea outputTextArea = new JTextArea(assemblyCode);
            outputTextArea.setEditable(false);
            outputFrame.add(new JScrollPane(outputTextArea));
            outputFrame.setSize(600, 400);
            outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            outputFrame.setVisible(true);
        });
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // Se generan los cuádruplos con el texto del área de texto y la variable de
        // optimización
        Triplos.GenerarTriplosNOPT(DHL.getText(), optimizar);
    }// GEN-LAST:event_jButton2ActionPerformed

    private boolean optimizar = false;

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        // Se obtiene el texto de entrada
        String codigoOriginal = DHL.getText();

        // Se optimiza el código
        String codigoOptimizado = Optimizar.optimizarCodigo(codigoOriginal);

        // Se muestra el código optimizado en una ventana
        mostrarCodigoOptimizadoEnVentana(codigoOptimizado);

        // Se establece la variable de optimización en true
        optimizar = true;
    }

    private void mostrarCodigoOptimizadoEnVentana(String codigoOptimizado) {
        JFrame frame = new JFrame("Código Optimizado");
        JTextArea textArea = new JTextArea(codigoOptimizado);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Compilar;
    private javax.swing.JTextArea DHL;
    private javax.swing.JTable Visual2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tdlDatos1;
    // End of variables declaration//GEN-END:variables
}
