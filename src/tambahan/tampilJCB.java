package tambahan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tampilJCB {
    private Connection con;

    public tampilJCB(Connection con) {
        this.con = con;
    }

    public void populateUserComboBox(JComboBox<String> userComboBox) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        userComboBox.setModel(model);
        
        try {
            String mysql = "select email from user";
            PreparedStatement pst = con.prepareStatement(mysql);
            ResultSet rst = pst.executeQuery();
            
            if (!rst.isBeforeFirst()) {
                model.addElement("-");
            } else {
                while (rst.next()) {
                    model.addElement(rst.getString("email"));
                }
            }
            
            rst.close();
            pst.close();
        } catch (Exception ex) {
            Logger.getLogger(tampilJCB.class.getName()).log(Level.SEVERE, null, ex);
            model.addElement("-");
        }
    }
    
    public void populateItemComboBox(JComboBox<String> itemComboBox) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        itemComboBox.setModel(model);
        
        try {
            String mysql = "select idim, namaim from item";
            PreparedStatement pst = con.prepareStatement(mysql);
            ResultSet rst = pst.executeQuery();
            
            if (!rst.isBeforeFirst()) {
                model.addElement("-");
            } else {
                while (rst.next()) {
                    String itemEntry = rst.getString("idim") + " - " + rst.getString("namaim");
                    model.addElement(itemEntry);
                }
            }
            
            rst.close();
            pst.close();
        } catch (Exception ex) {
            Logger.getLogger(tampilJCB.class.getName()).log(Level.SEVERE, null, ex);
            model.addElement("-");
        }
    }
}
