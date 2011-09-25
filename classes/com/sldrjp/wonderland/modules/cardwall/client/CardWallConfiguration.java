/*
 * Copyright 2010, 2011  Service de logiciel et developpement R.J. Potter (Robert J Potter)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CardWallConfiguration.java
 *
 * Created on 13-Mar-2011, 3:58:21 PM
 */

package com.sldrjp.wonderland.modules.cardwall.client;

import com.sldrjp.wonderland.modules.cardwall.common.cell.CardWallCellClientState;
import com.sldrjp.wonderland.modules.cardwall.common.cell.CardWallSectionCellClientState;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * @author Bob
 */
public class CardWallConfiguration extends javax.swing.JDialog {
    CardWallCellClientState state = null;
    CardWallCellClientState newState = null;
    boolean rowError = false;
    boolean sectionError = false;
    boolean columnError = false;

    int numberOfRows;
    int numberOfColumns;
    int numberOfSections;

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(
            "com/sldrjp/wonderland/modules/cardwall/client/resources/Bundle");


    /**
     * Creates new form CardWallConfiguration
     */
    private static final Logger logger = Logger.getLogger(CardWallConfiguration.class.getName());

    public CardWallConfiguration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setCardWallState(CardWallCellClientState state) {
        this.state = state;
        numberOfRows = state.getNumberOfRows();
        numberOfRowsText.setText(Integer.toString(numberOfRows));
        numberOfColumns = state.getNumberOfColumns();
        numberOfColumnsText.setText(Integer.toString(numberOfColumns));
        List<CardWallSectionCellClientState> sectionStates = state.getSectionStates();
        numberOfSections = sectionStates.size();
        numberOfSectionsText.setText(Integer.toString(numberOfSections));


        DefaultTableModel model = (DefaultTableModel) sectionTable.getModel();
        model.addColumn(BUNDLE.getString("configuration.column.section"));
        model.addColumn(BUNDLE.getString("configuration.column.title"));
        model.addColumn(BUNDLE.getString("configuration.column.columns"));
        model.addColumn(BUNDLE.getString("configuration.column.canDelete"));

        int i = 0;
        for (CardWallSectionCellClientState sectionState : sectionStates) {
            String row[] = new String[4];
            row[0] = Integer.toString(i);
            row[1] = sectionState.getSectionTitle();
            row[2] = Integer.toString(sectionState.getEndColumn() - sectionState.getStartColumn() + 1);
            row[3] = sectionState.isCanDelete() ? BUNDLE.getString("general.yes") : BUNDLE.getString("general.no");

            model.addRow(row);
            i++;
        }


    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelNumberOfRows = new javax.swing.JLabel();
        labelNumberOfColumns = new javax.swing.JLabel();
        labelNumberOfSections = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sectionTable = new javax.swing.JTable();
        numberOfColumnsText = new javax.swing.JTextField();
        numberOfColumnsText.setPreferredSize(new Dimension(50, 20));
        numberOfColumnsText.addFocusListener(new java.awt.event.FocusListener() {
            public void focusGained(FocusEvent e) {
                // do nothing
            }

            public void focusLost(FocusEvent e) {
                numberOfColumnsTextFocusLost(e);
            }
        });
        numberOfRowsText = new javax.swing.JTextField();
        numberOfRowsText.setPreferredSize(new Dimension(50, 20));

        numberOfRowsText.addFocusListener(new java.awt.event.FocusListener() {
            public void focusGained(FocusEvent e) {
                // do nothing
            }

            public void focusLost(FocusEvent e) {
                numberOfRowsTextFocusLost(e);
            }
        });

        jRadioButton2 = new javax.swing.JRadioButton();
        numberOfSectionsText = new javax.swing.JTextField();
        numberOfSectionsText.setPreferredSize(new Dimension(50, 20));
        numberOfSectionsText.addFocusListener(new java.awt.event.FocusListener() {
            public void focusGained(FocusEvent e) {
                // do nothing
            }

            public void focusLost(FocusEvent e) {
                numberOfSectionsTextFocusLost(e);
            }
        });
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();

        jCheckBox2.setText("jCheckBox2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText(BUNDLE.getString("general.ok"));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(BUNDLE.getString("general.cancel"));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        labelNumberOfRows.setText(BUNDLE.getString("configuration.label.numberOfRows"));
        labelNumberOfColumns.setText(BUNDLE.getString("configuration.label.numberOfColumns"));
        labelNumberOfSections.setText(BUNDLE.getString("configuration.label.numberOfSections"));

        sectionTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ));
        jScrollPane1.setViewportView(sectionTable);

        numberOfColumnsText.setText("");
        numberOfRowsText.setText("");

        jRadioButton2.setText(BUNDLE.getString("configuration.label.noteModel"));

        numberOfSectionsText.setText("");

        jLabel4.setText(BUNDLE.getString("configuration.label.cardStyle"));


        jRadioButton1.setText(BUNDLE.getString("configuration.label.agileModel"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jRadioButton1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jRadioButton2))))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelNumberOfSections)
                                                        .addComponent(labelNumberOfColumns)
                                                        .addComponent(labelNumberOfRows))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(numberOfColumnsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(numberOfSectionsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(numberOfRowsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(numberOfRowsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelNumberOfRows)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNumberOfColumns)
                                                        .addComponent(numberOfColumnsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNumberOfSections)
                                                        .addComponent(numberOfSectionsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2))
                                .addGap(42, 42, 42))
        );

        jLabel4.setVisible(false);
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(okButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        CardWallConfigurationHelper helper = new CardWallConfigurationHelper(state);

        try {
            if (testNewModel(helper)) {
                if (helper.isChanged()) {
                    newState = helper.getNewState();
                    layoutChangesMade = true;
                } else if (helper.isSectionTitleChanged()) {
                    titles = helper.getTitles();
                    titleChangesMade = true;
                }
                setVisible(false);
            }
        } catch (CardWallDialogDataException e) {
            JOptionPane.showMessageDialog(this, "error");
        }






    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        layoutChangesMade = false;
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private int checkAndGetValue(String standardText, JLabel label, JTextField field) throws CardWallDialogDataException {
        int value;
        try {
            value = Integer.parseInt(field.getText());
            if (value < 1) {
                label.setText(standardText + " - " + BUNDLE.getString("configuration.label.errorGreaterThanZero"));
                label.setForeground(Color.RED);
                throw new CardWallDialogDataException(null);

            }

        } catch (Exception e) {
            label.setText(standardText + " - " + BUNDLE.getString("configuration.label.errorMustBeANumber"));
            label.setForeground(Color.RED);
            throw new CardWallDialogDataException(e);
        }
        label.setText(standardText);
        label.setForeground(Color.BLACK);
        return value;
    }

    private void setOKButtonState() {
        if (columnError || rowError || sectionError) {
            okButton.setEnabled(false);
        } else {
            try {
                okButton.setEnabled(testNewModel());
            } catch (CardWallDialogDataException e) {
               okButton.setEnabled(false);
                JOptionPane.showMessageDialog(this, e.getErrorMessage());
            }

        }
    }

    private boolean testNewModel() throws CardWallDialogDataException {
        return testNewModel(new CardWallConfigurationHelper(state));
    }

    private boolean testNewModel(CardWallConfigurationHelper helper) throws CardWallDialogDataException {

        int newNumberOfRows = -1;
        int newNumberOfColumns = -1;
        int newNumberOfSections = -1;

        try {
            // verify that the model values is consistent
            newNumberOfRows = checkAndGetValue(BUNDLE.getString("configuration.label.numberOfRows"), labelNumberOfRows, numberOfRowsText);
            newNumberOfColumns = checkAndGetValue(BUNDLE.getString("configuration.label.numberOfColumns"), labelNumberOfColumns, numberOfColumnsText);
            newNumberOfSections = checkAndGetValue(BUNDLE.getString("configuration.label.numberOfSections"), labelNumberOfSections, numberOfSectionsText);

        } catch (CardWallDialogDataException e) {
            return false;

        }

        DefaultTableModel model = (DefaultTableModel) sectionTable.getModel();
        int numberOfDataRows = model.getRowCount();
        int[] sectionOrder = new int[numberOfDataRows];
        String[] titles = new String[numberOfDataRows];
        int[] columnLayout = new int[numberOfDataRows];

        int i;

        // populate the working arrays to pass for model testing
        try {
            for (i = 0; i < numberOfDataRows; i++) {
                sectionOrder[i] = Integer.parseInt(model.getValueAt(i, 0).toString());
                titles[i] = model.getValueAt(i, 1).toString();
                columnLayout[i] = Integer.parseInt(model.getValueAt(i, 2).toString());
            }

            helper.testNewModel(newNumberOfRows, newNumberOfColumns, newNumberOfSections, sectionOrder, titles, columnLayout);
        } catch (NumberFormatException e) {

            throw new CardWallDialogDataException(CardWallDialogDataException.CARDWALL_CONFIGURATION_NON_NUMERIC);
        }
        return true;
    }


    private void numberOfColumnsTextFocusLost(FocusEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // make sure the value is valid
        try {
            checkAndGetValue(BUNDLE.getString("configuration.label.numberOfColumns"), labelNumberOfColumns, numberOfColumnsText);
            columnError = false;
        } catch (CardWallDialogDataException e) {
            columnError = true;
        }
        setOKButtonState();

    }

    private void numberOfRowsTextFocusLost(FocusEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // make sure the value is valid

        try {
            checkAndGetValue(BUNDLE.getString("configuration.label.numberOfRows"), labelNumberOfRows, numberOfRowsText);
            rowError = false;
        } catch (CardWallDialogDataException e) {
            rowError = true;
        }

        setOKButtonState();
    }

    private void numberOfSectionsTextFocusLost(FocusEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // make sure the value is valid
        try {
            checkAndGetValue(BUNDLE.getString("configuration.label.numberOfSections"), labelNumberOfSections, numberOfSectionsText);
            sectionError = false;
        } catch (CardWallDialogDataException e) {
            sectionError = true;
        }

        setOKButtonState();


    }//GEN-LAST:event_jButton1ActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CardWallConfiguration dialog = new CardWallConfiguration(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton okButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel labelNumberOfRows;
    private javax.swing.JLabel labelNumberOfColumns;
    private javax.swing.JLabel labelNumberOfSections;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sectionTable;
    private javax.swing.JTextField numberOfRowsText;
    private javax.swing.JTextField numberOfColumnsText;
    private javax.swing.JTextField numberOfSectionsText;
    // End of variables declaration//GEN-END:variables

    private boolean layoutChangesMade = false;
    private boolean titleChangesMade = false;

    public boolean isDirty() {
        return layoutChangesMade || titleChangesMade;
    }

    public CardWallCellClientState getNewState() {
        return newState;
    }

    private String[] titles;

    public String[] getTitles() {
        return titles;
    }

    ;

    public boolean isTitleChanged() {
        return titleChangesMade;  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean isLayoutChanged() {
        return layoutChangesMade;
    }
}
