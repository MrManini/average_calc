package main;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import calc.calc;

public class JFrameCalc extends javax.swing.JFrame {
    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
    DecimalFormat decimalFormat = new DecimalFormat("0.00",decimalFormatSymbols);
    private final ArrayList<JTextField> gradeFields;
    private final ArrayList<JLabel> labels;
    private final ArrayList<JTextField> percentFields;
    private final ArrayList<JCheckBox> checks;
    
    public JFrameCalc() {
        initComponents();
        mySettings();
        gradeFields = new ArrayList<>();
        gradeFields.add(TFgrade1);
        gradeFields.add(TFgrade2);
        gradeFields.add(TFgrade3);
        gradeFields.add(TFgrade4);
        gradeFields.add(TFgrade5);
        gradeFields.add(TFgrade6);
        
        labels = new ArrayList<>();
        labels.add(lblNota1);
        labels.add(lblNota2);
        labels.add(lblNota3);
        labels.add(lblNota4);
        labels.add(lblNota5);
        labels.add(lblNota6);
        
        percentFields = new ArrayList<>();
        percentFields.add(TFpercent1);
        percentFields.add(TFpercent2);
        percentFields.add(TFpercent3);
        percentFields.add(TFpercent4);
        percentFields.add(TFpercent5);
        percentFields.add(TFpercent6);
        
        checks = new ArrayList<>();
        checks.add(check1);
        checks.add(check2);
        checks.add(check3);
        checks.add(check4);
        checks.add(check5);
        checks.add(check6);
        
        
        pack();
        
    }
    public void mySettings(){
        lblNOTAS.setVisible(false);
        lblNota1.setVisible(false);
        lblNota2.setVisible(false);
        lblNota3.setVisible(false);
        lblNota4.setVisible(false);
        lblNota5.setVisible(false);
        lblNota6.setVisible(false);
        
        lblPercent.setVisible(false);
        TFpercent1.setVisible(false);
        TFpercent2.setVisible(false);
        TFpercent3.setVisible(false);
        TFpercent4.setVisible(false);
        TFpercent5.setVisible(false);
        TFpercent6.setVisible(false);
        
        lblValue.setVisible(false);
        TFgrade1.setVisible(false);
        TFgrade2.setVisible(false);
        TFgrade3.setVisible(false);
        TFgrade4.setVisible(false);
        TFgrade5.setVisible(false);
        TFgrade6.setVisible(false);
        
        check1.setVisible(false);
        check2.setVisible(false);
        check3.setVisible(false);
        check4.setVisible(false);
        check5.setVisible(false);
        check6.setVisible(false);
        
        
        jSeparator1.setVisible(false);
        lblFinal.setVisible(false);
        TFaverage.setVisible(false);
        
    }
    private void showDefault(){
        lblNOTAS.setVisible(true);
        lblPercent.setVisible(true);
        lblValue.setVisible(true);
        jSeparator1.setVisible(true);
        lblFinal.setVisible(true);
        TFaverage.setVisible(true);
    }
    private void turnOffFinal(){
        int num = Integer.parseInt(TFnumOfGrades.getText());
        boolean allOn = true;
        for (int i = 0; i < num; i++){
            JCheckBox check = checks.get(i);
            if (!check.isSelected()){
                allOn = false;
                break;
            }
        }
        TFaverage.setEditable(!allOn);
    }
    private void setPercentages(int num){
        switch (num){
            case 1 -> TFpercent1.setText("100");
            case 2 -> {
                TFpercent1.setText("50");
                TFpercent2.setText("50");
            }
            case 3 -> {
                TFpercent1.setText("30");
                TFpercent2.setText("30");
                TFpercent3.setText("40");
            }
            case 4 -> {
                TFpercent1.setText("25");
                TFpercent2.setText("25");
                TFpercent3.setText("25");
                TFpercent4.setText("25");
            }
            case 5 -> {
                TFpercent1.setText("20");
                TFpercent2.setText("20");
                TFpercent3.setText("20");
                TFpercent4.setText("20");
                TFpercent5.setText("20");
            }
            case 6 -> {
                TFpercent1.setText("20");
                TFpercent2.setText("20");
                TFpercent3.setText("20");
                TFpercent4.setText("20");
                TFpercent5.setText("10");
                TFpercent6.setText("10");
            }                
        }
    }
    private double[] percentList(int num){
        double[] pcnt = new double[num];
        for (int i = 0; i < num; i++){
            JTextField percentage = percentFields.get(i);
            pcnt[i] = Double.parseDouble(percentage.getText());
        }
        return pcnt;
    }
    private double[] gradeList(int num){
        double[] grades = new double[num];
        for (int i = 0; i < num; i++){
            JTextField TF = gradeFields.get(i);
            grades[i] = Double.parseDouble(TF.getText());
        }
        return grades;      
    }
    private boolean[] editList(int num){
        boolean[] editable = new boolean[num];
        for (int i = 0; i < num; i++){
            JCheckBox check = checks.get(i);
            editable[i] = check.isSelected();
        }
        return editable;      
    }
    
    private void showCalculations(){
        int num = Integer.parseInt(TFnumOfGrades.getText());
        boolean edit = TFaverage.isEditable();
        double average = Double.parseDouble(TFaverage.getText());
        double result = calc.calc(edit, average, editList(num), gradeList(num), percentList(num));
        String resultFormat = decimalFormat.format(result);
        if (!edit){
            TFaverage.setText(resultFormat);
        }else{
            boolean[] checkEdits = editList(num);
            for (int i = 0; i < num; i++){
                if (checkEdits[i] == false){
                    JTextField grade = gradeFields.get(i);
                    grade.setText(resultFormat);
                }      
            }
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNota10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFnumOfGrades = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        lblNota1 = new javax.swing.JLabel();
        TFpercent1 = new javax.swing.JTextField();
        TFgrade1 = new javax.swing.JTextField();
        lblNota2 = new javax.swing.JLabel();
        TFpercent2 = new javax.swing.JTextField();
        TFgrade2 = new javax.swing.JTextField();
        lblNota3 = new javax.swing.JLabel();
        TFpercent3 = new javax.swing.JTextField();
        TFgrade3 = new javax.swing.JTextField();
        lblNota4 = new javax.swing.JLabel();
        TFpercent4 = new javax.swing.JTextField();
        TFgrade4 = new javax.swing.JTextField();
        lblNota5 = new javax.swing.JLabel();
        TFpercent5 = new javax.swing.JTextField();
        TFgrade5 = new javax.swing.JTextField();
        lblNota6 = new javax.swing.JLabel();
        TFpercent6 = new javax.swing.JTextField();
        TFgrade6 = new javax.swing.JTextField();
        lblFinal = new javax.swing.JLabel();
        TFaverage = new javax.swing.JTextField();
        lblNOTAS = new javax.swing.JLabel();
        lblPercent = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        check1 = new javax.swing.JCheckBox();
        check2 = new javax.swing.JCheckBox();
        check3 = new javax.swing.JCheckBox();
        check4 = new javax.swing.JCheckBox();
        check5 = new javax.swing.JCheckBox();
        check6 = new javax.swing.JCheckBox();

        lblNota10.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        lblNota10.setForeground(new java.awt.Color(102, 102, 102));
        lblNota10.setText("(%)");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 12, 98));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 56, 57));
        jLabel1.setText("Calculadora");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Número de notas:");

        TFnumOfGrades.setBackground(new java.awt.Color(255, 255, 255));
        TFnumOfGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFnumOfGradesActionPerformed(evt);
            }
        });

        btnOK.setBackground(new java.awt.Color(255, 255, 255));
        btnOK.setForeground(new java.awt.Color(51, 51, 51));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        lblNota1.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblNota1.setForeground(new java.awt.Color(102, 102, 102));
        lblNota1.setText("Nota 1:");

        TFpercent1.setBackground(new java.awt.Color(255, 255, 255));
        TFpercent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpercent1ActionPerformed(evt);
            }
        });

        TFgrade1.setEditable(false);
        TFgrade1.setBackground(new java.awt.Color(255, 255, 255));
        TFgrade1.setText("0");
        TFgrade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFgrade1ActionPerformed(evt);
            }
        });

        lblNota2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblNota2.setForeground(new java.awt.Color(102, 102, 102));
        lblNota2.setText("Nota 2:");

        TFpercent2.setBackground(new java.awt.Color(255, 255, 255));
        TFpercent2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpercent2ActionPerformed(evt);
            }
        });

        TFgrade2.setEditable(false);
        TFgrade2.setBackground(new java.awt.Color(255, 255, 255));
        TFgrade2.setText("0");
        TFgrade2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFgrade2ActionPerformed(evt);
            }
        });

        lblNota3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblNota3.setForeground(new java.awt.Color(102, 102, 102));
        lblNota3.setText("Nota 3:");

        TFpercent3.setBackground(new java.awt.Color(255, 255, 255));
        TFpercent3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpercent3ActionPerformed(evt);
            }
        });

        TFgrade3.setEditable(false);
        TFgrade3.setBackground(new java.awt.Color(255, 255, 255));
        TFgrade3.setText("0");
        TFgrade3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFgrade3ActionPerformed(evt);
            }
        });

        lblNota4.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblNota4.setForeground(new java.awt.Color(102, 102, 102));
        lblNota4.setText("Nota 4:");

        TFpercent4.setBackground(new java.awt.Color(255, 255, 255));
        TFpercent4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpercent4ActionPerformed(evt);
            }
        });

        TFgrade4.setEditable(false);
        TFgrade4.setBackground(new java.awt.Color(255, 255, 255));
        TFgrade4.setText("0");
        TFgrade4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFgrade4ActionPerformed(evt);
            }
        });

        lblNota5.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblNota5.setForeground(new java.awt.Color(102, 102, 102));
        lblNota5.setText("Nota 5:");

        TFpercent5.setBackground(new java.awt.Color(255, 255, 255));
        TFpercent5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpercent5ActionPerformed(evt);
            }
        });

        TFgrade5.setEditable(false);
        TFgrade5.setBackground(new java.awt.Color(255, 255, 255));
        TFgrade5.setText("0");
        TFgrade5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFgrade5ActionPerformed(evt);
            }
        });

        lblNota6.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblNota6.setForeground(new java.awt.Color(102, 102, 102));
        lblNota6.setText("Nota 6:");

        TFpercent6.setBackground(new java.awt.Color(255, 255, 255));
        TFpercent6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpercent6ActionPerformed(evt);
            }
        });

        TFgrade6.setEditable(false);
        TFgrade6.setBackground(new java.awt.Color(255, 255, 255));
        TFgrade6.setText("0");
        TFgrade6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFgrade6ActionPerformed(evt);
            }
        });

        lblFinal.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblFinal.setForeground(new java.awt.Color(102, 102, 102));
        lblFinal.setText("Promedio final:");

        TFaverage.setBackground(new java.awt.Color(255, 255, 255));
        TFaverage.setText("0");
        TFaverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFaverageActionPerformed(evt);
            }
        });

        lblNOTAS.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        lblNOTAS.setForeground(new java.awt.Color(102, 102, 102));
        lblNOTAS.setText("NOTAS");

        lblPercent.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        lblPercent.setForeground(new java.awt.Color(102, 102, 102));
        lblPercent.setText("(%)");

        lblValue.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        lblValue.setForeground(new java.awt.Color(102, 102, 102));
        lblValue.setText("VALOR");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 100));

        check1.setForeground(new java.awt.Color(102, 102, 102));
        check1.setText("Editar");
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        check2.setForeground(new java.awt.Color(102, 102, 102));
        check2.setText("Editar");
        check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check2ActionPerformed(evt);
            }
        });

        check3.setForeground(new java.awt.Color(102, 102, 102));
        check3.setText("Editar");
        check3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check3ActionPerformed(evt);
            }
        });

        check4.setForeground(new java.awt.Color(102, 102, 102));
        check4.setText("Editar");
        check4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check4ActionPerformed(evt);
            }
        });

        check5.setForeground(new java.awt.Color(102, 102, 102));
        check5.setText("Editar");
        check5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check5ActionPerformed(evt);
            }
        });

        check6.setForeground(new java.awt.Color(102, 102, 102));
        check6.setText("Editar");
        check6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNota5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFpercent5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TFgrade5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(check5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNota4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFpercent4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TFgrade4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(check4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNota3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFpercent3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TFgrade3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(check3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNota2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFpercent2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TFgrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(check2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFnumOfGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblNota6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TFpercent6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(TFgrade6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(check6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TFaverage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TFpercent1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblNOTAS, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValue, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(TFgrade1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(check1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TFnumOfGrades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNOTAS)
                    .addComponent(lblPercent)
                    .addComponent(lblValue))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFpercent1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFgrade1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNota1)
                        .addComponent(check1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFpercent2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFgrade2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNota2)
                        .addComponent(check2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFgrade3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNota3)
                        .addComponent(TFpercent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(check3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNota4)
                    .addComponent(TFpercent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFgrade4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFgrade5)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNota5)
                        .addComponent(TFpercent5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(check5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFgrade6)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNota6)
                        .addComponent(TFpercent6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(check6)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinal)
                    .addComponent(TFaverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFgrade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFgrade1ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFgrade1ActionPerformed

    private void TFpercent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpercent1ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFpercent1ActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        int numOfGrades = Integer.parseInt(TFnumOfGrades.getText());
        showDefault();
        for (int i = 0; i < 6; i++) {
            JTextField textField = gradeFields.get(i);
            textField.setVisible(i < numOfGrades);
            JLabel label = labels.get(i);
            label.setVisible(i < numOfGrades);
            JCheckBox check = checks.get(i);
            check.setVisible(i < numOfGrades);
            JTextField percent = percentFields.get(i);
            percent.setVisible(i < numOfGrades);
        }
        setPercentages(numOfGrades);
        pack();
    }//GEN-LAST:event_btnOKActionPerformed
    
    
    
    private void TFnumOfGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFnumOfGradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFnumOfGradesActionPerformed

    private void TFpercent2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpercent2ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFpercent2ActionPerformed

    private void TFgrade2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFgrade2ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFgrade2ActionPerformed

    private void TFpercent3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpercent3ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFpercent3ActionPerformed

    private void TFgrade3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFgrade3ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFgrade3ActionPerformed

    private void TFpercent4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpercent4ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFpercent4ActionPerformed

    private void TFgrade4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFgrade4ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFgrade4ActionPerformed

    private void TFpercent5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpercent5ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFpercent5ActionPerformed

    private void TFgrade5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFgrade5ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFgrade5ActionPerformed

    private void TFpercent6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpercent6ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFpercent6ActionPerformed

    private void TFgrade6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFgrade6ActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFgrade6ActionPerformed

    private void TFaverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFaverageActionPerformed
        showCalculations();
    }//GEN-LAST:event_TFaverageActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        if (check1.isSelected()){
            TFgrade1.setEditable(true);
        }else{
            TFgrade1.setEditable(false);
        }
        turnOffFinal();
    }//GEN-LAST:event_check1ActionPerformed

    private void check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check2ActionPerformed
        if (check2.isSelected()){
            TFgrade2.setEditable(true);
        }else{
            TFgrade2.setEditable(false);
        }
        turnOffFinal();
    }//GEN-LAST:event_check2ActionPerformed

    private void check3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check3ActionPerformed
        if (check3.isSelected()){
            TFgrade3.setEditable(true);
        }else{
            TFgrade3.setEditable(false);
        }
        turnOffFinal();
    }//GEN-LAST:event_check3ActionPerformed

    private void check4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check4ActionPerformed
        if (check4.isSelected()){
            TFgrade4.setEditable(true);
        }else{
            TFgrade4.setEditable(false);
        }
        turnOffFinal();
    }//GEN-LAST:event_check4ActionPerformed

    private void check5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check5ActionPerformed
        if (check5.isSelected()){
            TFgrade5.setEditable(true);
        }else{
            TFgrade5.setEditable(false);
        }
        turnOffFinal();
    }//GEN-LAST:event_check5ActionPerformed

    private void check6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check6ActionPerformed
        if (check6.isSelected()){
            TFgrade6.setEditable(true);
        }else{
            TFgrade6.setEditable(false);
        }
        turnOffFinal();
    }//GEN-LAST:event_check6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameCalc().setVisible(true);
            }
        });
    }
                
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFaverage;
    private javax.swing.JTextField TFgrade1;
    private javax.swing.JTextField TFgrade2;
    private javax.swing.JTextField TFgrade3;
    private javax.swing.JTextField TFgrade4;
    private javax.swing.JTextField TFgrade5;
    private javax.swing.JTextField TFgrade6;
    private javax.swing.JTextField TFnumOfGrades;
    private javax.swing.JTextField TFpercent1;
    private javax.swing.JTextField TFpercent2;
    private javax.swing.JTextField TFpercent3;
    private javax.swing.JTextField TFpercent4;
    private javax.swing.JTextField TFpercent5;
    private javax.swing.JTextField TFpercent6;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    private javax.swing.JCheckBox check4;
    private javax.swing.JCheckBox check5;
    private javax.swing.JCheckBox check6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblNOTAS;
    private javax.swing.JLabel lblNota1;
    private javax.swing.JLabel lblNota10;
    private javax.swing.JLabel lblNota2;
    private javax.swing.JLabel lblNota3;
    private javax.swing.JLabel lblNota4;
    private javax.swing.JLabel lblNota5;
    private javax.swing.JLabel lblNota6;
    private javax.swing.JLabel lblPercent;
    private javax.swing.JLabel lblValue;
    // End of variables declaration//GEN-END:variables
}
