/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mesentllc.utilities.systemparameterutility.screens;

public class SplashScreen extends javax.swing.JFrame {
	private SysParamMigration sysParamMigration;
	private SysParamTool sysParamTool;
	private SysParamInstall sysParamInstall;
	private SysParamMassDelete sysParamMassDelete;
	private SysParamCheck sysParamCheck;
	
	public SplashScreen() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAppName = new javax.swing.JLabel();
        btnMigrate = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnInstall = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCompare = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Parameter Utility");
        setName("frmSplash"); // NOI18N

        lblAppName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAppName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppName.setText("System Parameter Utility");

        btnMigrate.setText("Migrate");
        btnMigrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMigrateActionPerformed(evt);
            }
        });

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnInstall.setText("Install");
        btnInstall.setToolTipText("");
        btnInstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstallActionPerformed(evt);
            }
        });

        btnDelete.setText("Mass Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCompare.setText("Compare");
        btnCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAppName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMigrate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcess)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInstall)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCompare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addGap(0, 9, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAppName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMigrate)
                    .addComponent(btnProcess)
                    .addComponent(btnExit)
                    .addComponent(btnInstall)
                    .addComponent(btnDelete)
                    .addComponent(btnCompare))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMigrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMigrateActionPerformed
		if (sysParamMigration == null) {
			sysParamMigration = new SysParamMigration(this);
		}
		sysParamMigration.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_btnMigrateActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
		if (sysParamTool == null) {
			sysParamTool = new SysParamTool(this);
		}
		sysParamTool.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
		System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnInstallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstallActionPerformed
        if (sysParamInstall == null) {
			sysParamInstall = new SysParamInstall(this);
		}
        sysParamInstall.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_btnInstallActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (sysParamMassDelete == null) {
			sysParamMassDelete = new SysParamMassDelete(this);
		}
        sysParamMassDelete.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompareActionPerformed
        if (sysParamCheck == null) {
			sysParamCheck = new SysParamCheck(this);
		}
		sysParamCheck.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_btnCompareActionPerformed

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
			java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SplashScreen().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompare;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInstall;
    private javax.swing.JButton btnMigrate;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel lblAppName;
    // End of variables declaration//GEN-END:variables
}
