package streaming_platform;

public class UserSubscriptionManager extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserSubscriptionManager.class.getName());

    String url = "jdbc:mysql://localhost:3306/streaming_platform";
    String dbUser = "root"; 
    String dbPassword = "YourNewPassword123!"; 

    public UserSubscriptionManager() {
        initComponents();
        setTitle("User Subscription Manager");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        
        txtSubscriptionId = new javax.swing.JTextField();
        txtUserId = new javax.swing.JTextField();
        txtPlanId = new javax.swing.JTextField();
        dateStart = new com.toedter.calendar.JDateChooser();
        dateEnd = new com.toedter.calendar.JDateChooser();
        cmbStatus = new javax.swing.JComboBox<>();
        
        btnSave = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Subscription ID");
        jLabel2.setText("User ID");
        jLabel3.setText("Plan ID");
        jLabel4.setText("Start Date");
        jLabel5.setText("End Date");
        jLabel6.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Expired", "Cancelled" }));

        btnSave.setText("Save");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnBack.setText("Back To Menu");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubscriptionId)
                            .addComponent(txtUserId)
                            .addComponent(txtPlanId)
                            .addComponent(dateStart, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(dateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSubscriptionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPlanId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnSearch)
                    .addComponent(btnDelete)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String userIdStr = txtUserId.getText();
        String planIdStr = txtPlanId.getText();
        java.util.Date startDate = dateStart.getDate();
        java.util.Date endDate = dateEnd.getDate();
        String status = cmbStatus.getSelectedItem().toString();

        if (userIdStr.trim().isEmpty() || planIdStr.trim().isEmpty() || startDate == null || endDate == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "User ID, Plan ID, and both dates are required.");
            return;
        }

        String query = "INSERT INTO User_Subscription (user_id, plan_id, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";

        try (java.sql.Connection con = java.sql.DriverManager.getConnection(url, dbUser, dbPassword);
             java.sql.PreparedStatement pst = con.prepareStatement(query)) {
            
            pst.setInt(1, Integer.parseInt(userIdStr));
            pst.setInt(2, Integer.parseInt(planIdStr));
            pst.setDate(3, new java.sql.Date(startDate.getTime()));
            pst.setDate(4, new java.sql.Date(endDate.getTime()));
            pst.setString(5, status);
            
            pst.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Subscription Saved Successfully!");
            
            txtUserId.setText("");
            txtPlanId.setText("");
            dateStart.setDate(null);
            dateEnd.setDate(null);
            cmbStatus.setSelectedIndex(0);
            
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Database Error: Ensure User ID and Plan ID exist.\n" + ex.getMessage());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "IDs must be valid numbers.");
        }
    }                                       

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String subIdStr = txtSubscriptionId.getText();
        
        if (subIdStr.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a Subscription ID to search.");
            return;
        }

        String query = "SELECT user_id, plan_id, start_date, end_date, status FROM User_Subscription WHERE subscription_id = ?";

        try (java.sql.Connection con = java.sql.DriverManager.getConnection(url, dbUser, dbPassword);
             java.sql.PreparedStatement pst = con.prepareStatement(query)) {
            
            pst.setInt(1, Integer.parseInt(subIdStr));
            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtUserId.setText(String.valueOf(rs.getInt("user_id")));
                txtPlanId.setText(String.valueOf(rs.getInt("plan_id")));
                dateStart.setDate(rs.getDate("start_date"));
                dateEnd.setDate(rs.getDate("end_date"));
                cmbStatus.setSelectedItem(rs.getString("status"));
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Subscription ID not found.");
            }
            
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Subscription ID must be a number.");
        }
    }                                         

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String subIdStr = txtSubscriptionId.getText();
        
        if (subIdStr.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the Subscription ID to delete.");
            return;
        }

        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this subscription?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            String query = "DELETE FROM User_Subscription WHERE subscription_id = ?";

            try (java.sql.Connection con = java.sql.DriverManager.getConnection(url, dbUser, dbPassword);
                 java.sql.PreparedStatement pst = con.prepareStatement(query)) {
                
                pst.setInt(1, Integer.parseInt(subIdStr));
                
                if (pst.executeUpdate() > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Subscription Deleted!");
                    txtSubscriptionId.setText("");
                    txtUserId.setText("");
                    txtPlanId.setText("");
                    dateStart.setDate(null);
                    dateEnd.setDate(null);
                    cmbStatus.setSelectedIndex(0);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Subscription ID not found.");
                }
                
            } catch (java.sql.SQLException ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
            }
        }
    }                                         

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        new Menu().setVisible(true);
        this.dispose();
    }                                       

    public static void Main() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new UserSubscriptionManager().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbStatus;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtPlanId;
    private javax.swing.JTextField txtSubscriptionId;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration                   
}