package com.mesentllc.utilities.systemparameterutility.screens;

import com.mesentllc.utilities.systemparameterutility.SystemParameterUtilities;
import com.mesentllc.utilities.systemparameterutility.enums.PFEnvironment;
import com.mesentllc.utilities.systemparameterutility.enums.PFSystem;
import com.mesentllc.utilities.systemparameterutility.types.SystemParameter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.pool.OracleDataSource;

public class SysParamMassDelete extends JFrame {
    private final String[][] sOracleURL = new String[2][5];
	private final String[][] sUser = new String[2][5];
	private final String[][] sPwd = new String[2][5];
    private final JFrame splashScr;
    
	public SysParamMassDelete(JFrame splashScr) {
        loadAuthorization();
		initComponents();
   		cbxSystem.setSelectedIndex(1);
        loadTable();
        this.splashScr = splashScr;
	}

	/**
	 * This
	 * method
	 * is
	 * called
	 * from
	 * within
	 * the
	 * constructor
	 * to
	 * initialize
	 * the
	 * form.
	 * WARNING:
	 * Do
	 * NOT
	 * modify
	 * this
	 * code.
	 * The
	 * content
	 * of
	 * this
	 * method
	 * is
	 * always
	 * regenerated
	 * by
	 * the
	 * Form
	 * Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAppName = new javax.swing.JLabel();
        lblLeftEnv = new javax.swing.JLabel();
        cbxEnv = new javax.swing.JComboBox();
        lblSystem = new javax.swing.JLabel();
        cbxSystem = new javax.swing.JComboBox();
        lblLeftUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblLeftPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSysParam = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Parameter Migration");

        lblAppName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAppName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppName.setText("System Parameter Mass Delete Utility");

        lblLeftEnv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLeftEnv.setText("Environment 1:");

        cbxEnv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L0", "L2", "L3", "L4", "PRD" }));
        cbxEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvActionPerformed(evt);
            }
        });

        lblSystem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSystem.setText("System:");

        cbxSystem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EVS", "RODeS" }));
        cbxSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSystemActionPerformed(evt);
            }
        });

        lblLeftUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLeftUser.setText("Username:");

        txtUser.setText("SPEVCC_APP");
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });

        lblLeftPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLeftPassword.setText("Password:");

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblSysParam.setAutoCreateRowSorter(true);
        tblSysParam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Category", "SubCategory", "Delete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSysParam.setColumnSelectionAllowed(true);
        tblSysParam.setName(""); // NOI18N
        tblSysParam.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSysParam);
        tblSysParam.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAppName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLeftEnv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLeftUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLeftPassword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(139, 492, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSystem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAppName)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSystem)
                    .addComponent(cbxSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeftEnv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeftUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeftPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblAppName.getAccessibleContext().setAccessibleName("lblAppName");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadAuthorization() {
        for (int outer = 0; outer < 2; outer++) {
            for (int inner = 0; inner < 5; inner++) {
                sOracleURL[outer][inner] = SystemParameterUtilities.ORACLE_URL[outer][inner];
                sUser[outer][inner] = SystemParameterUtilities.ORACLE_USER[outer][inner];
                sPwd[outer][inner] = SystemParameterUtilities.ORACLE_PWD[outer][inner];
            }
        }
    }
    
	private String getOracleUrl(int application, int arrayIndex) {
        String[] urlPrePost = {"jdbc:oracle:thin:@ldap://oidprd.gss.ground.fedex.com:389/",
							   ",cn=OracleContext,dc=ground,dc=fedex,dc=com"};
		return urlPrePost[0] + sOracleURL[application][arrayIndex] + urlPrePost[1];
	}

    private void clearTable() {
        DefaultTableModel tableModel = (DefaultTableModel)tblSysParam.getModel();
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }
    }

    private void loadTable() {
        Set<SystemParameter> systemParameterSet;

        clearTable();
		String user = txtUser.getText().trim();
		String pwd = new String(txtPassword.getPassword()).trim();
		if ((user.length() < 1) || (pwd.length() < 1)) {
			JOptionPane.showMessageDialog(this, "Username and password needs to populated.");
			return;
		}
        systemParameterSet = retrieveSystemParameters();
        DefaultTableModel tableModel = (DefaultTableModel)tblSysParam.getModel();
        for (SystemParameter sp : systemParameterSet) {
            if (sp.getName().trim().length() > 0) {
                tableModel.addRow(new Object[] {sp.getName(), sp.getCategory(), sp.getSubCategory(), false});
            }
        }
    }
    
    private Set<SystemParameter> retrieveSystemParameters() {
		OracleDataSource odsSource;
		Connection connectionSource;
		Statement statementSource;
		ResultSet rsSource;
		String sSQLSource;
		Set<SystemParameter> returnSet = new TreeSet<SystemParameter>();
        String user;
        String pwd;
        String url;
        
        user = txtUser.getText().trim();
        pwd = new String(txtPassword.getPassword()).trim();
        url = getOracleUrl(cbxSystem.getSelectedIndex(),cbxEnv.getSelectedIndex());
		try {
			odsSource = new OracleDataSource();
			odsSource.setUser(user);
			odsSource.setPassword(pwd);
			odsSource.setURL(url);
			connectionSource = odsSource.getConnection();
			statementSource = connectionSource.createStatement();
			sSQLSource = "SELECT PARM_CTG, PARM_SUBCTG, PARM_NM FROM FXSP_SYSTEM_PARAMETERS";
			rsSource = statementSource.executeQuery(sSQLSource);
		 	while (rsSource.next()) {
                if (!"MARKEDFORDELETION".equals(rsSource.getString("PARM_CTG"))) {
                    SystemParameter sp = new SystemParameter();
                    sp.setName(rsSource.getString("PARM_NM"));
                    sp.setCategory(rsSource.getString("PARM_CTG"));
                    sp.setSubCategory(rsSource.getString("PARM_SUBCTG"));
                    returnSet.add(sp);
                }
			}
			rsSource.close();
			statementSource.close();
			connectionSource.close();
		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(this, "Error reading System Parameter Table.");
		}
		return returnSet;
	}

    private void cbxEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvActionPerformed
        txtUser.setText(sUser[cbxSystem.getSelectedIndex()][cbxEnv.getSelectedIndex()]);
        txtPassword.setText(sPwd[cbxSystem.getSelectedIndex()][cbxEnv.getSelectedIndex()]);
        loadTable();
    }//GEN-LAST:event_cbxEnvActionPerformed

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        sUser[cbxSystem.getSelectedIndex()][cbxEnv.getSelectedIndex()] = txtUser.getText().trim();
    }//GEN-LAST:event_txtUserFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        sPwd[cbxSystem.getSelectedIndex()][cbxEnv.getSelectedIndex()] = new String(txtPassword.getPassword()).trim();
    }//GEN-LAST:event_txtPasswordFocusLost

    private void cbxSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSystemActionPerformed
        txtUser.setText(sUser[cbxSystem.getSelectedIndex()][cbxEnv.getSelectedIndex()]);
        txtPassword.setText(sPwd[cbxSystem.getSelectedIndex()][cbxEnv.getSelectedIndex()]);
        loadTable();
    }//GEN-LAST:event_cbxSystemActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Set<SystemParameter> selected = new HashSet<SystemParameter>();
        DefaultTableModel tableModel = (DefaultTableModel)tblSysParam.getModel();
        
        for (int pointer = 0; pointer < tableModel.getRowCount(); pointer++) {
            if ((Boolean)tableModel.getValueAt(pointer, 3)) {
                SystemParameter sp = new SystemParameter();
                sp.setName((String)tableModel.getValueAt(pointer, 0));
                sp.setCategory((String)tableModel.getValueAt(pointer, 1));
                sp.setSubCategory((String)tableModel.getValueAt(pointer, 2));
                selected.add(sp);
            }
        }
        if (selected.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select parameters to migrate.");
            return;
        }
        else {
            if (JOptionPane.showConfirmDialog(this, "Are you sure you wish to delete " + selected.size() + " record(s)?") == 
                JOptionPane.YES_OPTION) {
            } else {
                return;
            }
        }
        for (SystemParameter item : selected) {
            try {
                SystemParameter systemParameter = 
                    SystemParameterUtilities.retrieveSystemParameter(PFSystem.valueOf((String)cbxSystem.getSelectedItem()), 
                                                                     PFEnvironment.valueOf((String)cbxEnv.getSelectedItem()), 
                                                                     txtUser.getText(), new String(txtPassword.getPassword()), 
                                                                     item.getCategory(), item.getSubCategory(), item.getName());
                SystemParameterUtilities.delete(PFSystem.valueOf((String)cbxSystem.getSelectedItem()), 
                                                PFEnvironment.valueOf((String)cbxEnv.getSelectedItem()), txtUser.getText(), 
                                                new String(txtPassword.getPassword()), systemParameter);
            }
            catch (SQLException sqle) {
                JOptionPane.showMessageDialog(this, sqle);
            }
        }
        loadTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        splashScr.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox cbxEnv;
    private javax.swing.JComboBox cbxSystem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAppName;
    private javax.swing.JLabel lblLeftEnv;
    private javax.swing.JLabel lblLeftPassword;
    private javax.swing.JLabel lblLeftUser;
    private javax.swing.JLabel lblSystem;
    private javax.swing.JTable tblSysParam;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
