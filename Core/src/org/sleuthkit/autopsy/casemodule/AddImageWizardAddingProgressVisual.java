/*
 * Autopsy Forensic Browser
 *
 * Copyright 2012 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import org.openide.WizardDescriptor;

/**
 * visual component to display progress bar and status updates while adding an
 * image in the wizard
 */
 public class AddImageWizardAddingProgressVisual extends javax.swing.JPanel {

    private static final String ADDING_DATA_SOURCE_COMPLETE = "Adding Data Source - Complete";
    private String errorLog = "";
    private boolean hasCriticalErrors = false;

    /**
     * Returns the name of the this panel. This name will be shown on the left
     * panel of the "Add Image" wizard panel.
     *
     * @return name the name of this panel
     */
    @Override
    public String getName() {
        return "Add Data Source";
    }

    /**
     * hide the progress components and show the "done" components
     */
    protected void setStateFinished() {
        inProgressPanel.setVisible(false);
        titleLabel.setText(ADDING_DATA_SOURCE_COMPLETE);
        donePanel.setVisible(true);
        //force repaint just in case
        validate();
        repaint();
    }

    /**
     * Creates new form AddImageLoadingPanel
     */
    public AddImageWizardAddingProgressVisual() {
        initComponents();
        customizeComponents();

    }

    private void customizeComponents() {
        //done and log button are both hidden to start
        donePanel.setVisible(false);
        viewLogButton.setVisible(false);
        //match visual background of panel
        this.progressTextArea.setBackground(this.getBackground());

    }

    public JProgressBar getProgressBar() {
        return this.progressBar;
    }

    /**
     * update the progress bar and label text and color.
     *
     * @param text  the text to be shown
     * @param value the current value of the progress bar
     * @param color the color of the progress bar text
     */
    public void setProgressBarTextAndColor(String text, int value, Color color) {
        progressLabel.setText(text);
        progressLabel.setForeground(color);
        progressBar.setValue(value);
    }

    /**
     * Updates the currently processing directory
     *
     * @param msg the text to update with
     */
    public void setProgressMsgText(String msg) {
        this.progressTextArea.setText(msg);
    }

    /**
     * reconfigure the components to indicate error(s) and show "view log
     * button"
     *
     *
     * @param errors   a string containing a description of the error(s)
     * @param critical true to indicate the error(s) are critical
     */
    public void showErrors(final String errors, boolean critical) {
        hasCriticalErrors |= critical;

        //progressBar.setValue(100); //always invoked when process completed
        if (hasCriticalErrors) {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("*Failed to add data source (critical errors encountered). Click below to view the log.");
        } else {
            statusLabel.setForeground(Color.BLACK);
            statusLabel.setText("*Data Source added (non-critical errors encountered). Click below to view the log.");
        }

        errorLog += errors + "\n";
        viewLogButton.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingPanel = new javax.swing.JPanel();
        donePanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        viewLogButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        inProgressPanel = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        progressLabel = new javax.swing.JLabel();
        progressTextArea = new javax.swing.JTextArea();
        subTitle1Label = new javax.swing.JLabel();

        javax.swing.GroupLayout loadingPanelLayout = new javax.swing.GroupLayout(loadingPanel);
        loadingPanel.setLayout(loadingPanelLayout);
        loadingPanelLayout.setHorizontalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        loadingPanelLayout.setVerticalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(statusLabel, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.statusLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(viewLogButton, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.viewLogButton.text")); // NOI18N
        viewLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout donePanelLayout = new javax.swing.GroupLayout(donePanel);
        donePanel.setLayout(donePanelLayout);
        donePanelLayout.setHorizontalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewLogButton)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        donePanelLayout.setVerticalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewLogButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(titleLabel, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.titleLabel.text")); // NOI18N

        progressBar.setIndeterminate(true);

        org.openide.awt.Mnemonics.setLocalizedText(progressLabel, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.progressLabel.text")); // NOI18N
        progressLabel.setPreferredSize(null);

        progressTextArea.setEditable(false);
        progressTextArea.setBackground(new java.awt.Color(240, 240, 240));
        progressTextArea.setLineWrap(true);
        progressTextArea.setRows(5);
        progressTextArea.setWrapStyleWord(true);
        progressTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.progressTextArea.border.title"))); // NOI18N
        progressTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        progressTextArea.setFocusable(false);

        org.openide.awt.Mnemonics.setLocalizedText(subTitle1Label, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.subTitle1Label.text")); // NOI18N

        javax.swing.GroupLayout inProgressPanelLayout = new javax.swing.GroupLayout(inProgressPanel);
        inProgressPanel.setLayout(inProgressPanelLayout);
        inProgressPanelLayout.setHorizontalGroup(
            inProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inProgressPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(inProgressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(progressTextArea)
                    .addComponent(progressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTitle1Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        inProgressPanelLayout.setVerticalGroup(
            inProgressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inProgressPanelLayout.createSequentialGroup()
                .addComponent(subTitle1Label)
                .addGap(19, 19, 19)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progressTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(inProgressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inProgressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLogButtonActionPerformed
        //show error dialog
        AddImageErrorsDialog dialog = new AddImageErrorsDialog(null, true);
        dialog.appendErrors(errorLog);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_viewLogButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel donePanel;
    protected javax.swing.JPanel inProgressPanel;
    private javax.swing.JPanel loadingPanel;
    private javax.swing.JProgressBar progressBar;
    protected javax.swing.JLabel progressLabel;
    protected javax.swing.JTextArea progressTextArea;
    protected javax.swing.JLabel statusLabel;
    protected javax.swing.JLabel subTitle1Label;
    protected javax.swing.JLabel titleLabel;
    protected javax.swing.JButton viewLogButton;
    // End of variables declaration//GEN-END:variables
}
