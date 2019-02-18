package com.mesentllc.utilities.systemparameterutility.screens;

import com.mesentllc.utilities.systemparameterutility.SystemParameterUtilities;
import com.mesentllc.utilities.systemparameterutility.enums.PFEnvironment;
import com.mesentllc.utilities.systemparameterutility.enums.PFSystem;
import com.mesentllc.utilities.systemparameterutility.types.SystemParameter;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SysParamMigration extends JFrame {
    private final String[][] sOracleURL = new String[2][5];
	private final String[][] sLeftUser = new String[2][5];
	private final String[][] sLeftPwd = new String[2][5];
	private final String[][] sRightUser = new String[2][5];
	private final String[][] sRightPwd = new String[2][5];
    private final JFrame splashScr;

	public SysParamMigration(JFrame splashScr) {
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
        lblRightEnv = new javax.swing.JLabel();
        cbxLeftEnv = new javax.swing.JComboBox();
        cbxRightEnv = new javax.swing.JComboBox();
        lblSystem = new javax.swing.JLabel();
        cbxSystem = new javax.swing.JComboBox();
        lblLeftUser = new javax.swing.JLabel();
        txtLeftUser = new javax.swing.JTextField();
        lblLeftPassword = new javax.swing.JLabel();
        txtLeftPassword = new javax.swing.JPasswordField();
        lblRightUser = new javax.swing.JLabel();
        txtRightUser = new javax.swing.JTextField();
        lblRightPassword = new javax.swing.JLabel();
        txtRightPassword = new javax.swing.JPasswordField();
        btnMigrate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSysParam = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        cbxFile = new javax.swing.JCheckBox();
        txtFilename = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Parameter Migration");

        lblAppName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAppName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppName.setText("System Parameter Migration Utility");

        lblLeftEnv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLeftEnv.setText("Environment 1:");

        lblRightEnv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRightEnv.setText("Environment 2:");

        cbxLeftEnv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L0", "L2", "L3", "L4", "PRD" }));
        cbxLeftEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLeftEnvActionPerformed(evt);
            }
        });

        cbxRightEnv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L0", "L2", "L3", "L4", "PRD" }));
        cbxRightEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRightEnvActionPerformed(evt);
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

        txtLeftUser.setText("SPEVCC_APP");
        txtLeftUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLeftUserFocusLost(evt);
            }
        });

        lblLeftPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLeftPassword.setText("Password:");

        txtLeftPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLeftPasswordFocusLost(evt);
            }
        });

        lblRightUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRightUser.setText("Username:");

        txtRightUser.setText("SPEVCC_APP");
        txtRightUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRightUserFocusLost(evt);
            }
        });

        lblRightPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRightPassword.setText("Password:");

        txtRightPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRightPasswordFocusLost(evt);
            }
        });

        btnMigrate.setText("Migrate");
        btnMigrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMigrateActionPerformed(evt);
            }
        });

        tblSysParam.setAutoCreateRowSorter(true);
        tblSysParam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Category", "SubCategory", "Migrate"
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
        tblSysParam.getColumnModel().getColumn(0).setHeaderValue("Name");
        tblSysParam.getColumnModel().getColumn(1).setHeaderValue("Category");
        tblSysParam.getColumnModel().getColumn(2).setHeaderValue("SubCategory");
        tblSysParam.getColumnModel().getColumn(3).setHeaderValue("Migrate");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cbxFile.setText("Send to File");

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
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
                                .addComponent(cbxLeftEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLeftUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLeftUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLeftPassword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLeftPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 192, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblRightEnv)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxRightEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblRightUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRightUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(135, 135, 135))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRightPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRightPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLoad))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSystem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMigrate)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRightEnv)
                            .addComponent(cbxRightEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLeftEnv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxLeftEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLeftUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLeftUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRightUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRightUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeftPassword)
                    .addComponent(txtLeftPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRightPassword)
                    .addComponent(txtRightPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMigrate)
                    .addComponent(btnBack)
                    .addComponent(cbxFile)
                    .addComponent(txtFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblAppName.getAccessibleContext().setAccessibleName("lblAppName");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadAuthorization() {
        for (int outer = 0; outer < 2; outer++) {
            for (int inner = 0; inner < 5; inner++) {
                sOracleURL[outer][inner] = SystemParameterUtilities.ORACLE_URL[outer][inner];
                sLeftUser[outer][inner] = SystemParameterUtilities.ORACLE_USER[outer][inner];
                sRightUser[outer][inner] = SystemParameterUtilities.ORACLE_USER[outer][inner];
                sLeftPwd[outer][inner] = SystemParameterUtilities.ORACLE_PWD[outer][inner];
                sRightPwd[outer][inner] = SystemParameterUtilities.ORACLE_PWD[outer][inner];
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
        clearTable();
        if (cbxLeftEnv.getSelectedIndex() == cbxRightEnv.getSelectedIndex()) {
            return;
        }
        Set<SystemParameter> systemParameterLeftSet;
		Set<SystemParameter> systemParameterRightSet;
		Set<SystemParameter> missingSystemParameterSet;

		String user = txtLeftUser.getText().trim();
		String pwd = new String(txtLeftPassword.getPassword()).trim();
		if ((user.length() < 1) || (pwd.length() < 1)) {
			JOptionPane.showMessageDialog(this, "Username and password needs to populated.");
			return;
		}
		user = txtRightUser.getText().trim();
		pwd = new String(txtRightPassword.getPassword()).trim();
		if ((user.length() < 1) || (pwd.length() < 1)) {
			JOptionPane.showMessageDialog(this, "Username and password needs to populated.");
			return;
		}
        systemParameterLeftSet = retrieveSystemParameters(true);
        systemParameterRightSet = retrieveSystemParameters(false);
		missingSystemParameterSet = getMissing(systemParameterRightSet, systemParameterLeftSet);
        DefaultTableModel tableModel = (DefaultTableModel)tblSysParam.getModel();
        for (SystemParameter sp : missingSystemParameterSet) {
            if (sp.getName().trim().length() > 0) {
                tableModel.addRow(new Object[] {sp.getName(), sp.getCategory(), sp.getSubCategory(), false});
            }
        }
    }

    private Set<SystemParameter> retrieveSystemParameters(boolean isLeft) {
		OracleDataSource odsSource;
		Connection connectionSource;
		Statement statementSource;
		ResultSet rsSource;
		String sSQLSource;
		Set<SystemParameter> returnSet = new TreeSet<SystemParameter>();
        String user;
        String pwd;
        String url;

        if (isLeft) {
            user = txtLeftUser.getText().trim();
            pwd = new String(txtLeftPassword.getPassword()).trim();
            url = getOracleUrl(cbxSystem.getSelectedIndex(),cbxLeftEnv.getSelectedIndex());
        }
        else {
            user = txtRightUser.getText().trim();
            pwd = new String(txtRightPassword.getPassword()).trim();
            url = getOracleUrl(cbxSystem.getSelectedIndex(),cbxRightEnv.getSelectedIndex());
        }
		try {
			odsSource = new OracleDataSource();
			odsSource.setUser(user);
			odsSource.setPassword(pwd);
			odsSource.setURL(url);
			connectionSource = odsSource.getConnection();
			statementSource = connectionSource.createStatement();
            try {
                sSQLSource = "SELECT PARM_CTG, PARM_SUBCTG, PARM_NM FROM SPRODS_SCHEMA.FXSP_SYSTEM_PARAMETERS";
                rsSource = statementSource.executeQuery(sSQLSource);
            }
            catch (SQLException e) {
                sSQLSource = "SELECT PARM_CTG, PARM_SUBCTG, PARM_NM FROM FXSP_SYSTEM_PARAMETERS";
                rsSource = statementSource.executeQuery(sSQLSource);
            }
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

	private Set<SystemParameter> getMissing(Collection<SystemParameter> subset, Collection<SystemParameter> base) {
		Set<SystemParameter> returnSet = new TreeSet<SystemParameter>();

		for (SystemParameter sp : base) {
			if (!subset.contains(sp)) {
				returnSet.add(sp);
			}
		}
		return returnSet;
	}

    private void cbxLeftEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLeftEnvActionPerformed
        txtLeftUser.setText(sLeftUser[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()]);
        txtLeftPassword.setText(sLeftPwd[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()]);
    }//GEN-LAST:event_cbxLeftEnvActionPerformed

    private void cbxRightEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRightEnvActionPerformed
        txtRightUser.setText(sRightUser[cbxSystem.getSelectedIndex()][cbxRightEnv.getSelectedIndex()]);
        txtRightPassword.setText(sRightPwd[cbxSystem.getSelectedIndex()][cbxRightEnv.getSelectedIndex()]);
    }//GEN-LAST:event_cbxRightEnvActionPerformed

    private void txtLeftUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLeftUserFocusLost
        sLeftUser[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()] = txtLeftUser.getText().trim();
    }//GEN-LAST:event_txtLeftUserFocusLost

    private void txtLeftPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLeftPasswordFocusLost
        sLeftPwd[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()] = new String(txtLeftPassword.getPassword()).trim();
    }//GEN-LAST:event_txtLeftPasswordFocusLost

    private void txtRightUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRightUserFocusLost
        sRightUser[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()] = txtRightUser.getText().trim();
    }//GEN-LAST:event_txtRightUserFocusLost

    private void txtRightPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRightPasswordFocusLost
        sRightPwd[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()] = new String(txtRightPassword.getPassword()).trim();
    }//GEN-LAST:event_txtRightPasswordFocusLost

    private void cbxSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSystemActionPerformed
        txtLeftUser.setText(sLeftUser[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()]);
        txtLeftPassword.setText(sLeftPwd[cbxSystem.getSelectedIndex()][cbxLeftEnv.getSelectedIndex()]);
        txtRightUser.setText(sLeftUser[cbxSystem.getSelectedIndex()][cbxRightEnv.getSelectedIndex()]);
        txtRightPassword.setText(sLeftPwd[cbxSystem.getSelectedIndex()][cbxRightEnv.getSelectedIndex()]);
    }//GEN-LAST:event_cbxSystemActionPerformed

    private void btnMigrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMigrateActionPerformed
        Set<SystemParameter> selected = new HashSet<SystemParameter>();
        DefaultTableModel tableModel = (DefaultTableModel)tblSysParam.getModel();
        StringBuilder sb = new StringBuilder();

        for (int pointer = 0; pointer < tableModel.getRowCount(); pointer++) {
            if ((Boolean)tableModel.getValueAt(pointer, 3)) {
                SystemParameter sp = new SystemParameter();
                sp.setName((String)tableModel.getValueAt(pointer, 0));
                sp.setCategory((String)tableModel.getValueAt(pointer, 1));
                sp.setSubCategory((String)tableModel.getValueAt(pointer, 2));
                selected.add(sp);
            }
        }
        if (cbxFile.isSelected() && (txtFilename.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Please enter a filename to send results to.");
            return;
        }
        if (selected.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select parameters to migrate.");
        }
        else {
            for (SystemParameter item : selected) {
                try {
                    SystemParameter systemParameter =
                        SystemParameterUtilities.retrieveSystemParameter(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
                                                                         PFEnvironment.valueOf((String)cbxLeftEnv.getSelectedItem()),
                                                                         txtLeftUser.getText(), new String(txtLeftPassword.getPassword()),
                                                                         item.getCategory(), item.getSubCategory(), item.getName());
                    if (cbxFile.isSelected()) {
                        sb.append(systemParameter.getCategory()).append("\t").append(systemParameter.getSubCategory()).append("\t")
                          .append(systemParameter.getName()).append("\t").append(systemParameter.getValue())
                          .append("\t").append(systemParameter.getType()).append("\t").append(systemParameter.getCache())
                          .append("\t").append(systemParameter.getComment()).append("\r\n");
                    }
                    else {
                        SystemParameterUtilities.create(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
                                                        PFEnvironment.valueOf((String)cbxRightEnv.getSelectedItem()), systemParameter);
                    }
                }
                catch (SQLException sqle) {
                    JOptionPane.showMessageDialog(this, sqle);
                }
            }
            if (cbxFile.isSelected()) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(txtFilename.getText().trim()));
                    bw.write(sb.toString());
                    bw.close();
                }
                catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, ioe);
                }
            }
            else {
                loadTable();
            }
        }
    }//GEN-LAST:event_btnMigrateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       this.setVisible(false);
       splashScr.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        loadTable();
    }//GEN-LAST:event_btnLoadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMigrate;
    private javax.swing.JCheckBox cbxFile;
    private javax.swing.JComboBox cbxLeftEnv;
    private javax.swing.JComboBox cbxRightEnv;
    private javax.swing.JComboBox cbxSystem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAppName;
    private javax.swing.JLabel lblLeftEnv;
    private javax.swing.JLabel lblLeftPassword;
    private javax.swing.JLabel lblLeftUser;
    private javax.swing.JLabel lblRightEnv;
    private javax.swing.JLabel lblRightPassword;
    private javax.swing.JLabel lblRightUser;
    private javax.swing.JLabel lblSystem;
    private javax.swing.JTable tblSysParam;
    private javax.swing.JTextField txtFilename;
    private javax.swing.JPasswordField txtLeftPassword;
    private javax.swing.JTextField txtLeftUser;
    private javax.swing.JPasswordField txtRightPassword;
    private javax.swing.JTextField txtRightUser;
    // End of variables declaration//GEN-END:variables
}
