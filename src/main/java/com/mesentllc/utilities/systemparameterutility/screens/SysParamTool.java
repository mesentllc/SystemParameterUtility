/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mesentllc.utilities.systemparameterutility.screens;

import com.mesentllc.utilities.systemparameterutility.SystemParameterUtilities;
import com.mesentllc.utilities.systemparameterutility.enums.PFEnvironment;
import com.mesentllc.utilities.systemparameterutility.enums.PFSystem;
import com.mesentllc.utilities.systemparameterutility.types.SystemParameter;
import com.mesentllc.utilities.systemparameterutility.types.TypeType;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 796812
 */
public class SysParamTool extends javax.swing.JFrame {
	private static final String DEFAULT_VALUE = "********Use long value********";
	private final String[][] sOracleURL = new String[2][5];
	private final String[][] sUser = new String[2][5];
	private final String[][] sPwd = new String[2][5];
	private final JFrame splashScr;

	public SysParamTool(JFrame splashScr) {
		loadAuthorization();
		initComponents();
		cbxSystem.setSelectedIndex(1);
		resetFields();
		this.splashScr = splashScr;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAppName = new javax.swing.JLabel();
        lblSystem = new javax.swing.JLabel();
        cbxSystem = new javax.swing.JComboBox();
        lblParamName = new javax.swing.JLabel();
        txtParamName = new javax.swing.JTextField();
        lblParmCategory = new javax.swing.JLabel();
        txtParamCategory = new javax.swing.JTextField();
        lblParamEnv = new javax.swing.JLabel();
        cbxParamEnv = new javax.swing.JComboBox();
        lblParamType = new javax.swing.JLabel();
        lblParamCache = new javax.swing.JLabel();
        cbxParamCache = new javax.swing.JComboBox();
        cbxParamType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtParamSubCat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaParamValue = new javax.swing.JTextArea();
        lblParamValue = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaParamComment = new javax.swing.JTextArea();
        lblParamComment = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassoword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnBack = new javax.swing.JButton();
        lblNewCat = new javax.swing.JLabel();
        txtNewCat = new javax.swing.JTextField();
        lblNewSub = new javax.swing.JLabel();
        txtNewSub = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Parameter Tool");

        lblAppName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAppName.setText("System Parameter Tool");

        lblSystem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSystem.setText("System:");

        cbxSystem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EVS", "RODeS" }));
        cbxSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSystemActionPerformed(evt);
            }
        });

        lblParamName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParamName.setText("Name:");

        lblParmCategory.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParmCategory.setText("Category:");

        lblParamEnv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParamEnv.setText("Environment:");

        cbxParamEnv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L0", "L2", "L3", "L4", "PRD" }));
        cbxParamEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxParamEnvActionPerformed(evt);
            }
        });

        lblParamType.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParamType.setText("Type:");

        lblParamCache.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParamCache.setText("Cache:");

        cbxParamCache.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NEVER", "15MINS", "HOURLY", "DAILY", "FOREVER" }));

        cbxParamType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "STRING", "BOOLEAN", "INTEGER", "LONG", "DATETIME" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Subcategory:");

        txtaParamValue.setColumns(20);
        txtaParamValue.setLineWrap(true);
        txtaParamValue.setRows(5);
        jScrollPane1.setViewportView(txtaParamValue);

        lblParamValue.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParamValue.setText("Value:");

        txtaParamComment.setColumns(20);
        txtaParamComment.setLineWrap(true);
        txtaParamComment.setRows(5);
        jScrollPane2.setViewportView(txtaParamComment);

        lblParamComment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParamComment.setText("Comment:");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsername.setText("Username:");

        txtUsername.setText("SPRODS_APP");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });

        lblPassoword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPassoword.setText("Password:");

        txtPassword.setText("SPRODS11");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblNewCat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNewCat.setText("New Category:");

        lblNewSub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNewSub.setText("New Subcategory:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblParamValue)
                            .addComponent(lblParamComment))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnLoad)
                                .addGap(18, 18, 18)
                                .addComponent(btnCreate)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(45, 45, 45)
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExit)
                                .addGap(0, 4, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addComponent(btnReset)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblParamName)
                                    .addComponent(lblSystem))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtParamName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxSystem, javax.swing.GroupLayout.Alignment.LEADING, 0, 223, Short.MAX_VALUE)))
                            .addComponent(lblAppName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblNewCat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNewCat))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblParmCategory)
                                    .addGap(35, 35, 35)
                                    .addComponent(txtParamCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblParamEnv)
                                    .addComponent(lblParamType)
                                    .addComponent(lblParamCache)
                                    .addComponent(lblUsername)
                                    .addComponent(lblPassoword))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbxParamType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxParamEnv, javax.swing.GroupLayout.Alignment.LEADING, 0, 192, Short.MAX_VALUE)
                                    .addComponent(cbxParamCache, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUsername)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNewSub)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtParamSubCat)
                                    .addComponent(txtNewSub))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppName)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassoword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSystem)
                    .addComponent(cbxSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParamEnv)
                    .addComponent(cbxParamEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParamName)
                    .addComponent(lblParamType)
                    .addComponent(cbxParamType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParamCache)
                    .addComponent(cbxParamCache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtParamSubCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblParmCategory)
                        .addComponent(txtParamCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewCat)
                    .addComponent(txtNewCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewSub)
                    .addComponent(txtNewSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParamValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParamComment))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReset)
                        .addComponent(btnExit)
                        .addComponent(btnBack))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(btnUpdate)
                        .addComponent(btnCreate)
                        .addComponent(btnLoad)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
		displaySystemParameters();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
		System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
		resetFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
		if (authorizationSet()) {
			if (SystemParameterUtilities.delete(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
												PFEnvironment.valueOf((String)cbxParamEnv.getSelectedItem()),
												txtUsername.getText(), new String(txtPassword.getPassword()), buildSP()) == 0) {
				JOptionPane.showMessageDialog(this, "Parameter Deleted.");
			}
			else {
				JOptionPane.showMessageDialog(this, "Error deleting parameter.");
			}
		}
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
		try {
			if (SystemParameterUtilities.parameterExists(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
														 PFEnvironment.valueOf((String)cbxParamEnv.getSelectedItem()),
														 txtUsername.getText(), new String(txtPassword.getPassword()),
														 txtParamCategory.getText().trim(), txtParamSubCat.getText().trim(),
														 txtParamName.getText().trim())) {
				JOptionPane.showMessageDialog(this, "Parameter already exists!");
			}
			else {
				if (SystemParameterUtilities.create(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
													PFEnvironment.valueOf((String)cbxParamEnv.getSelectedItem()), buildSP()) == 0) {
					JOptionPane.showMessageDialog(this, "Parameter Created.");
				}
				else {
					JOptionPane.showMessageDialog(this, "Error creating parameter.");
				}
			}
		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(this, sqle.getMessage());
		}
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
		try {
			if (!SystemParameterUtilities.parameterExists(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
														  PFEnvironment.valueOf((String)cbxParamEnv.getSelectedItem()),
														  txtUsername.getText(), new String(txtPassword.getPassword()),
														  txtParamCategory.getText().trim(), txtParamSubCat.getText().trim(),
														  txtParamName.getText().trim())) {
				JOptionPane.showMessageDialog(this, "Parameter does not exist!");
			}
			else {
				if (SystemParameterUtilities.update(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
													PFEnvironment.valueOf((String)cbxParamEnv.getSelectedItem()), buildSP(),
													txtNewCat.getText().trim(), txtNewSub.getText().trim()) == 0) {
					JOptionPane.showMessageDialog(this, "Parameter Updated.");
				}
				else {
					JOptionPane.showMessageDialog(this, "Error updating parameter.");
				}
			}
		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(this, sqle.getMessage());
		}
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
		sUser[cbxSystem.getSelectedIndex()][cbxParamEnv.getSelectedIndex()] = txtUsername.getText().trim();
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
		sPwd[cbxSystem.getSelectedIndex()][cbxParamEnv.getSelectedIndex()] = new String(txtPassword.getPassword()).trim();
    }//GEN-LAST:event_txtPasswordFocusLost

    private void cbxParamEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxParamEnvActionPerformed
		txtUsername.setText(sUser[cbxSystem.getSelectedIndex()][cbxParamEnv.getSelectedIndex()]);
		txtPassword.setText(sPwd[cbxSystem.getSelectedIndex()][cbxParamEnv.getSelectedIndex()]);
		txtNewCat.setEnabled(false);
		txtNewSub.setEnabled(false);
    }//GEN-LAST:event_cbxParamEnvActionPerformed

    private void cbxSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSystemActionPerformed
		txtUsername.setText(sUser[cbxSystem.getSelectedIndex()][cbxParamEnv.getSelectedIndex()]);
		txtPassword.setText(sPwd[cbxSystem.getSelectedIndex()][cbxParamEnv.getSelectedIndex()]);
    }//GEN-LAST:event_cbxSystemActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
		this.setVisible(false);
		splashScr.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

	private void loadAuthorization() {
		for (int outer = 0; outer < 2; outer++) {
			for (int inner = 0; inner < 5; inner++) {
				sOracleURL[outer][inner] = SystemParameterUtilities.ORACLE_URL[outer][inner];
				sUser[outer][inner] = SystemParameterUtilities.ORACLE_USER[outer][inner];
				sPwd[outer][inner] = SystemParameterUtilities.ORACLE_PWD[outer][inner];
			}
		}
	}

	private void resetFields() {
		cbxSystem.setSelectedIndex(1);
		txtParamName.setText("");
		txtParamName.setEnabled(true);
		txtParamCategory.setText("");
		txtParamSubCat.setText("");
		cbxParamType.setSelectedIndex(0);
		cbxParamCache.setSelectedIndex(0);
		txtaParamComment.setText("");
		txtaParamValue.setText("");
		clearMods();
	}

	private void clearMods() {
		txtNewCat.setText("");
		txtNewCat.setEnabled(false);
		txtNewSub.setText("");
		txtNewSub.setEnabled(false);
	}

	private String removeAesthetics(String value) {
		if (value == null) {
			return value;
		}
		String[] lines = value.split("\n");
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			sb.append(line.trim());
		}
		return sb.toString();
	}

	private SystemParameter buildSP() {
		SystemParameter sp = new SystemParameter();
		sp.setCache((String)cbxParamCache.getSelectedItem());
		sp.setCategory(txtParamCategory.getText().trim());
		sp.setComment(txtaParamComment.getText().trim());
		sp.setName(txtParamName.getText().trim());
		sp.setSubCategory(txtParamSubCat.getText().trim());
		sp.setType(TypeType.valueOf((String)cbxParamType.getSelectedItem()));
		sp.setValue(removeAesthetics(txtaParamValue.getText().trim()));
//		sp.setValue(txtaParamValue.getText());
		return sp;
	}

	private boolean authorizationSet() {
		String username = txtUsername.getText().trim();
		String password = new String(txtPassword.getPassword()).trim();
		if (username.length() == 0 || password.length() == 0) {
			JOptionPane.showMessageDialog(this, "Username/Password can't be empty.");
			return false;
		}
		return true;
	}

	private void displaySystemParameters() {
		if (!authorizationSet()) {
			return;
		}
		try {
			SystemParameter sp = SystemParameterUtilities.retrieveSystemParameter(PFSystem.valueOf((String)cbxSystem.getSelectedItem()),
																				  PFEnvironment.valueOf((String)cbxParamEnv.getSelectedItem()),
																				  txtUsername.getText(), new String(txtPassword.getPassword()),
																				  txtParamCategory.getText().trim(), txtParamSubCat.getText().trim(),
																				  txtParamName.getText().trim());
			if (sp != null) {
				txtParamCategory.setText(sp.getCategory());
				txtParamSubCat.setText(sp.getSubCategory());
				cbxParamType.setSelectedItem(sp.getType());
				cbxParamCache.setSelectedItem(sp.getCache());
				txtaParamComment.setText(sp.getComment());
				if (sp.getLongValue() != null) {
					txtaParamValue.setText(sp.getLongValue());
				}
				else {
					txtaParamValue.setText(sp.getValue());
				}
				txtNewCat.setEnabled(true);
				txtNewSub.setEnabled(true);
			}
			else {
				JOptionPane.showMessageDialog(this, "Parameter doesn't exist.");
			}
		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(this, sqle.getMessage());
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxParamCache;
    private javax.swing.JComboBox cbxParamEnv;
    private javax.swing.JComboBox cbxParamType;
    private javax.swing.JComboBox cbxSystem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAppName;
    private javax.swing.JLabel lblNewCat;
    private javax.swing.JLabel lblNewSub;
    private javax.swing.JLabel lblParamCache;
    private javax.swing.JLabel lblParamComment;
    private javax.swing.JLabel lblParamEnv;
    private javax.swing.JLabel lblParamName;
    private javax.swing.JLabel lblParamType;
    private javax.swing.JLabel lblParamValue;
    private javax.swing.JLabel lblParmCategory;
    private javax.swing.JLabel lblPassoword;
    private javax.swing.JLabel lblSystem;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtNewCat;
    private javax.swing.JTextField txtNewSub;
    private javax.swing.JTextField txtParamCategory;
    private javax.swing.JTextField txtParamName;
    private javax.swing.JTextField txtParamSubCat;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextArea txtaParamComment;
    private javax.swing.JTextArea txtaParamValue;
    // End of variables declaration//GEN-END:variables
}
