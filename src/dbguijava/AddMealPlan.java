package dbguijava;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMealPlan extends javax.swing.JFrame {

    Date now = new Date();
    Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;

    public AddMealPlan() {
        initComponents();
        getinfo();

    }

    public void sendinfo() {

        
        //intializing
        //breakfast                                         //LUNCH                                         //DINNER
        String b1 = B1_.getSelectedObjects().toString();
        String L1 = L1_.getSelectedObjects().toString();
        String D1 = D1_.getSelectedObjects().toString();
        String b2 = B2_.getSelectedObjects().toString();
        String L2 = L2_.getSelectedObjects().toString();
        String D2 = D2_.getSelectedObjects().toString();
        String b3 = B3_.getSelectedObjects().toString();
        String L3 = L3_.getSelectedObjects().toString();
        String D3 = D3_.getSelectedObjects().toString();
        String b4 = B4_.getSelectedObjects().toString();
        String L4 = L4_.getSelectedObjects().toString();
        String D4 = D4_.getSelectedObjects().toString();
        String b5 = B5_.getSelectedObjects().toString();
        String L5 = L5_.getSelectedObjects().toString();
        String D5 = D5_.getSelectedObjects().toString();
        String b6 = B6_.getSelectedObjects().toString();
        String L6 = L6_.getSelectedObjects().toString();
        String D6 = D6_.getSelectedObjects().toString();
        String b7 = B7_.getSelectedObjects().toString();
        String L7 = L7_.getSelectedObjects().toString();
        String D7 = D7_.getSelectedObjects().toString();

        
        String[] Mealtime = {"Breakfast", "Lunch", "Dinner"};//meal times 
        String[] Whatmeal = {b1, b2, b3, b4, b5, b6, b7, L1, L2, L3, L4, L5, L6, L7, D1, D2, D3, D4, D5, D6, D7};//info from the combo box

        //gets the day and then and once in the for loop it will increase by one to represent the week       
        String Ddate = Date.getText();//gets date from text box
        String day = Ddate.substring(3, 5);//gets the day
        int int_day = Integer.parseInt(day); //change string  into int

        
        int m = 0;
        //first for loop repeats 3 times(breakfast, lunch and dinner)
        for (int i = 0; i < Mealtime.length; i++) {
            String PickMealTime = Mealtime[i]; // choose the info from the array which represents the meal time (breakfast, lunch and dinner)
            for (int j = m; j < m + 7; j++) { //second forloop used to assign the correct jumbobox(meal) to the correct meal time and date.
                conn = ConnectDB.setupConnection();

                String d = Integer.toString(int_day);//change into string
                String dd = Ddate.substring(0, 3) + d + Ddate.substring(5, Ddate.length()); //corrects the date but inserting the new day
                String pickWhatmeal = Whatmeal[j];//pulls the info from the array, the information in the array is the info from the combo boxes
                try {                   
                    Statement st = conn.createStatement();
                    String sqlQuery = "INSERT INTO partOf (planDate,mealTime,recipeName) VALUES ('" + dd + "','" + PickMealTime + "','" + pickWhatmeal + "')";
                    pst = (OraclePreparedStatement) conn.prepareStatement(sqlQuery);
                    int k = pst.executeUpdate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {
                    ConnectDB.close(pst);
                    ConnectDB.close(rs);
                    ConnectDB.close(conn);
                }
                int_day++; //go to next day
            }
            int_day -= 7;//resets date back to starting date, so that we can assign lunch of the week with the correct date
            m += 7;// jumps 7 steps in to the array
        }
    }

    public void getinfo() {
        conn = ConnectDB.setupConnection();
        try {
            String sql = "SELECT recipeName FROM recipes";
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            rs = (OracleResultSet) pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("recipeName");
                //B1= BREAKFAST BOX 1 L1= LUNCH BOX D1=DINNER BOX
                B1_.addItem(name);
                L1_.addItem(name);
                D1_.addItem(name);
                B2_.addItem(name);
                L2_.addItem(name);
                D2_.addItem(name);
                B3_.addItem(name);
                L3_.addItem(name);
                D3_.addItem(name);
                B4_.addItem(name);
                L4_.addItem(name);
                D4_.addItem(name);
                B5_.addItem(name);
                L5_.addItem(name);
                D5_.addItem(name);
                B6_.addItem(name);
                L6_.addItem(name);
                D6_.addItem(name);
                B7_.addItem(name);
                L7_.addItem(name);
                D7_.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDB.close(pst);
            ConnectDB.close(rs);
            ConnectDB.close(conn);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        L2_ = new javax.swing.JComboBox<>();
        D5_ = new javax.swing.JComboBox<>();
        B2_ = new javax.swing.JComboBox<>();
        L6_ = new javax.swing.JComboBox<>();
        D2_ = new javax.swing.JComboBox<>();
        B6_ = new javax.swing.JComboBox<>();
        L3_ = new javax.swing.JComboBox<>();
        D6_ = new javax.swing.JComboBox<>();
        B3_ = new javax.swing.JComboBox<>();
        L7_ = new javax.swing.JComboBox<>();
        D3_ = new javax.swing.JComboBox<>();
        B7_ = new javax.swing.JComboBox<>();
        L4_ = new javax.swing.JComboBox<>();
        D7_ = new javax.swing.JComboBox<>();
        B4_ = new javax.swing.JComboBox<>();
        L1_ = new javax.swing.JComboBox<>();
        D4_ = new javax.swing.JComboBox<>();
        B1_ = new javax.swing.JComboBox<>();
        L5_ = new javax.swing.JComboBox<>();
        D1_ = new javax.swing.JComboBox<>();
        B5_ = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Date = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        D2_.setMaximumRowCount(10);

        B3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3_ActionPerformed(evt);
            }
        });

        D7_.setToolTipText("");

        L1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L1_ActionPerformed(evt);
            }
        });

        B1_.setToolTipText("");
        B1_.setName(""); // NOI18N
        B1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1_ActionPerformed(evt);
            }
        });

        jLabel1.setText("BreakFast");

        jLabel2.setText("Lunch");

        jLabel3.setText("Dinner");

        jButton1.setText("Send Info");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Date.setText("MM/DD/YYY");

        jLabel4.setText("Starting Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(B7_, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(L7_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(D7_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(B6_, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(L6_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(D6_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B5_, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(L5_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(D5_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(B4_, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(L4_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(D4_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(B3_, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(L3_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(D3_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(B2_, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(L2_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(D2_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(B1_, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(L1_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(D1_, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButton1)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B1_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L1_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D1_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B2_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D2_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B3_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L3_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D3_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B4_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D4_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B5_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L5_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D5_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B6_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L6_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D6_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B7_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L7_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D7_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        B1_.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1_ActionPerformed

    }//GEN-LAST:event_B1_ActionPerformed

    private void L1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L1_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1_ActionPerformed

    private void B3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B3_ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        sendinfo();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddMealPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMealPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMealPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMealPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMealPlan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> B1_;
    private javax.swing.JComboBox<String> B2_;
    private javax.swing.JComboBox<String> B3_;
    private javax.swing.JComboBox<String> B4_;
    private javax.swing.JComboBox<String> B5_;
    private javax.swing.JComboBox<String> B6_;
    private javax.swing.JComboBox<String> B7_;
    private javax.swing.JComboBox<String> D1_;
    private javax.swing.JComboBox<String> D2_;
    private javax.swing.JComboBox<String> D3_;
    private javax.swing.JComboBox<String> D4_;
    private javax.swing.JComboBox<String> D5_;
    private javax.swing.JComboBox<String> D6_;
    private javax.swing.JComboBox<String> D7_;
    private javax.swing.JTextField Date;
    private javax.swing.JComboBox<String> L1_;
    private javax.swing.JComboBox<String> L2_;
    private javax.swing.JComboBox<String> L3_;
    private javax.swing.JComboBox<String> L4_;
    private javax.swing.JComboBox<String> L5_;
    private javax.swing.JComboBox<String> L6_;
    private javax.swing.JComboBox<String> L7_;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
