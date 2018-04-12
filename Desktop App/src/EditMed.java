
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
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayed
 */
public class EditMed extends javax.swing.JFrame {
    private File file;
    JSONParser parser = new JSONParser();
    public String oldTime;
    /**
     * Creates new form EditPanel
     */
    public EditMed(File file) {
        initComponents();
        this.setTitle("Edit...");
        
        this.file = file;
    }
    
    public EditMed(File file, String time) {
        initComponents();
        this.setTitle("Edit...");
        
        this.file=file;
        oldTime = time;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medTime = new javax.swing.JLabel();
        medName = new javax.swing.JLabel();
        medQuantity = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        pills = new javax.swing.JTextField();
        editData = new javax.swing.JButton();
        back = new javax.swing.JButton();
        name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        medTime.setText("Time:");

        medName.setText("Medicine Name:");

        medQuantity.setText("Quantity:");

        pills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pillsActionPerformed(evt);
            }
        });

        editData.setText("Edit");
        editData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDataActionPerformed(evt);
            }
        });

        back.setText("< Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(medTime)
                            .addComponent(medQuantity)
                            .addComponent(medName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pills, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(time, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editData, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editData)
                    .addComponent(back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pillsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pillsActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        BasicConsole bj = new BasicConsole(file);
        dispose();
        bj.setVisible(true);
        bj.showData();
    }//GEN-LAST:event_backActionPerformed

    private void editDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDataActionPerformed
        // TODO add your handling code here:
        String newTime = time.getText();
        String newPill = pills.getText();
        try {                                           
            // TODO add your handling code here:
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            
            org.json.JSONObject jsonObject1 = new org.json.JSONObject(jsonObject);
            
            
            //JOptionPane.showMessageDialog(this, "jjj");
            BufferedReader br = null;
            BufferedWriter bw = null;
            
            try {
                bw = new BufferedWriter (new FileWriter(file));
                
                
                bw.write("{");
                //JOptionPane.showMessageDialog(this, "f");
                Iterator<String> keys = jsonObject1.keys();
                JSONObject medName = new JSONObject();
                while( keys.hasNext() ){
                    boolean found = false;
                    String line = "";
                    String key = (String)keys.next(); // First key in your the object
                    
                    if(key.equals(name.getText())){
                        found = true;
                    }
                    //JOptionPane.showMessageDialog(this, key);
                    
                    org.json.JSONArray jsonArray = jsonObject1.getJSONArray(key);
                    JSONObject timePill = new JSONObject();
                    
                    for (int p = 0; p < jsonArray.length(); p++) {
                        org.json.JSONObject object = jsonArray.optJSONObject(p);
                        Iterator<String> iterator = object.keys();
                        boolean updateDone = false;
                        while(iterator.hasNext()) {
                            //x= true;
                            String currentKey = iterator.next();
                            
                            if(found && currentKey.equals(oldTime)){
                                if(oldTime.equals(newTime) && !updateDone) {
                                    timePill.put(oldTime, newPill);
                                    updateDone = true;
                                } else if(!oldTime.equals(newTime) && !updateDone){
                                    timePill.put(newTime, newPill);
    //                                String amount = (String)object.get(currentKey);
    //                                timePill.put(currentKey, amount);
                                    updateDone = true;
                                }
                            }
                            else {
                                String amount = (String)object.get(currentKey);
                                timePill.put(currentKey, amount);
                            }
                        }
                    }
                    
                    JSONArray timePillList = new JSONArray();
                    timePillList.add(timePill);
                    //System.out.println("array: "+timePillList);
                    medName.put("\""+key+"\"", timePillList);
                    //System.out.println(medName.put("\""+key+"\"", timePillList));
                    line += "\""+key+"\""+":"+timePillList+",";
                    //System.out.println(line);
                    bw.write(line);
                    
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
    }//GEN-LAST:event_editDataActionPerformed

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
//            java.util.logging.Logger.getLogger(EditMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EditMed().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton editData;
    private javax.swing.JLabel medName;
    private javax.swing.JLabel medQuantity;
    private javax.swing.JLabel medTime;
    public javax.swing.JLabel name;
    public javax.swing.JTextField pills;
    public javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables

}
