/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Jayed
 */
public class Add extends javax.swing.JFrame {
    private File file;
    JSONParser parser = new JSONParser();
    /**
     * Creates new form AddJson
     */
    public Add(File file) {
        initComponents();
        this.setTitle("Add new medicine");
        this.file = file;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        medName = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        pills = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Medicine Name: ");

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel2.setText("Time:");

        jLabel3.setText("Quantity:");

        medName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medNameActionPerformed(evt);
            }
        });

        backButton.setText("< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(medName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(time, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pills, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(medName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(backButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        BasicConsole bj = new BasicConsole(file);
        bj.setVisible(true);
        bj.showData();
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void medNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medNameActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        boolean valid = true;
        String medicineName = medName.getText();
        String newTime = time.getText();
        String pillString = pills.getText();
        
        if(medicineName.isEmpty() || newTime.isEmpty() || pillString.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fileds can not be empty");
            Add add = new Add(file);
            dispose();
            add.setVisible(true);
        }
        
        if(Integer.parseInt(newTime) >= 2400) {
            JOptionPane.showMessageDialog(this, "Invalid Time Input");
            valid = false;
        }
        
        
        if(pillString.isEmpty()){
            valid = false;
        }
        try {
            int newPill = Integer.parseInt(pillString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity Input");
            valid = false;
        }
        
        if(!valid) {
            BasicConsole bc = new BasicConsole(file);
            dispose();
            bc.setVisible(true);
            bc.showData();
        } else {
            try {                                           
                // TODO add your handling code here:
                Object obj = parser.parse(new FileReader(file));
                JSONObject jsonObject = (JSONObject) obj;

                org.json.JSONObject jsonObject1 = new org.json.JSONObject(jsonObject);


                //JOptionPane.showMessageDialog(this, "jjj");
                //BufferedReader br = null;
                BufferedWriter bw = null;

                try {
                    bw = new BufferedWriter (new FileWriter(file));


                    bw.write("{");
                    //JOptionPane.showMessageDialog(this, "f");
                    Iterator<String> keysTemp = jsonObject1.keys();
                    boolean exists = false;
                    boolean duplicateData = false;
                    while( keysTemp.hasNext() ) {
                        String medicine = (String)keysTemp.next();
                        if(medicine.equals(medName.getText())) {
                            exists = true;

                            org.json.JSONArray jsonArray = jsonObject1.getJSONArray(medicine);

                            for (int p = 0; p < jsonArray.length(); p++) {
                                org.json.JSONObject object = jsonArray.optJSONObject(p);
                                Iterator<String> iterator = object.keys();

                                while(iterator.hasNext()) {
                                    String currentKey = iterator.next();
                                    if(currentKey.equals(newTime)) {
                                        duplicateData = true;
                                    }
                                }
                            }
                        }
                    }

                    JSONObject mainObj = new JSONObject();

                    Iterator<String> keys = jsonObject1.keys();
                    while( keys.hasNext() ){
                    boolean found = false;
                    String line = "";
                    String name= "";
                    String key = (String)keys.next(); // First key in your the object

                    if(key.equals(medName.getText())){
                        name = medName.getText();
                        found = true;
                    } else {
                        name = key;
                    }
                    //JOptionPane.showMessageDialog(this, key);

                    org.json.JSONArray jsonArray = jsonObject1.getJSONArray(key);
                    JSONObject timePill = new JSONObject();
                    JSONObject timePill2 = new JSONObject();

                    for (int p = 0; p < jsonArray.length(); p++) {
                        org.json.JSONObject object = jsonArray.optJSONObject(p);
                        Iterator<String> iterator = object.keys();

                        while(iterator.hasNext()) {
                            //x= true;
                            String currentKey = iterator.next();

                            if(duplicateData && found){
                                JOptionPane.showMessageDialog(this, "Data exists!!!");
                                String amount = (String)object.get(currentKey);
                                timePill.put(currentKey, amount);
                                System.out.println(currentKey+"  true, true");
                                found = false;

                            }else if(found && !duplicateData){
                                timePill2.put(newTime, pillString);
                                String amount = (String)object.get(currentKey);
                                timePill.put(currentKey, amount);
                                System.out.println(currentKey+"  true, false");
                                found = false;

                            }else {
                                String amount = (String)object.get(currentKey);
                                timePill.put(currentKey, amount);
                            }
                        }
                    }

                    JSONArray timePillList = new JSONArray();
                    timePillList.add(timePill);
                    timePillList.add(timePill2);
                    //System.out.println("array: "+timePillList);
                    mainObj.put("\""+name+"\"", timePillList);
                    //System.out.println(mainObj.put("\""+key+"\"", timePillList));
                    line += "\""+name+"\""+":"+timePillList+",";
                    //System.out.println(line);
                    bw.write(line);

                }


                    if(!exists) {
                        String newMed = medName.getText();
                        JSONObject newTimePill = new JSONObject();
                        newTimePill.put(newTime, pillString);
                        newTimePill.put("quantity", "0");
                        JSONArray newTimePillList = new JSONArray();
                        newTimePillList.add(newTimePill);
                        mainObj.put("\""+newMed+"\"", newTimePillList);
                        String newLine = "\""+newMed+"\""+newTimePillList;
                        bw.write(newLine);
                    }

                    bw.write("}");
                } catch (IOException | HeadlessException | JSONException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(bw != null) {
                            bw.close();
                        }
                    } catch (Exception e) {
                        //
                    }
                }

                BasicConsole bj = new BasicConsole(file);
                dispose();
                bj.setVisible(true);
                bj.showData();
            } catch (IOException ex) {
                Logger.getLogger(EditStorage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(EditStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Add().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField medName;
    private javax.swing.JTextField pills;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}