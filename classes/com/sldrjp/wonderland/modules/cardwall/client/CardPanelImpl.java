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
 * CardPanelImpl.java
 *
 * Created on Oct 5, 2010, 8:58:11 PM
 */

package com.sldrjp.wonderland.modules.cardwall.client;

import com.sldrjp.wonderland.modules.cardwall.common.CardPosition;
import com.sldrjp.wonderland.modules.cardwall.common.CardWallException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * @author bob
 */
public class CardPanelImpl extends javax.swing.JPanel implements ActionListener, CardPanel {

    private static final Logger logger = Logger.getLogger(CardPanelImpl.class.getName());

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(
            "com/sldrjp/wonderland/modules/cardwall/client/resources/Bundle");

    /**
     * Creates new form CardPanelImpl
     */
    public CardPanelImpl() {
        initComponents();
        keyTimer = new Timer(1000, this);

    }


    private MasterPanelImpl masterPanel;
    private CardWallManager cardWallManager;
    CardPosition cardPosition = new CardPosition(0, 0);
    private Timer keyTimer;
    private Point originalPos;
    private Point lastPos;


    public void setMasterPanel(MasterPanelImpl masterPanel, CardWallManager cardWallManager) {
        this.masterPanel = masterPanel;
        this.cardWallManager = cardWallManager;
    }

    public void setCardPosition(CardPosition cardPosition) {
        this.cardPosition = cardPosition;
    }

    public void checkSendChanges() {
        cardWallManager.checkSendChanges(cardPosition, this.getBackground(), title.getText(), detail.getText(), person.getText(), points.getText());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == keyTimer) {
            checkSendChanges();
        }
    }

    public void updateCard(int colour, String titleText, String bodyText, String personText, String pointsText) {
        if (colour != 0) {
            setBackground(new Color(colour));
        }
        title.setText(titleText);
        detail.setText(bodyText);
        person.setText(personText);
        points.setText(pointsText);
    }

    public void changeColour(Color colour) {
        setBackground(colour);
        checkSendChanges();
        validate();
        repaint();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        redColour = new javax.swing.JMenuItem();
        greenColour = new javax.swing.JMenuItem();
        blueColour = new javax.swing.JMenuItem();
        yellowColour = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        copyToStickyNote = new javax.swing.JMenuItem();
        copyToCardWall = new javax.swing.JMenuItem();
        copyTo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        deleteItem = new javax.swing.JMenuItem();
        archiveItem = new javax.swing.JMenuItem();
        title = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        detail = new javax.swing.JTextPane();
        person = new javax.swing.JTextField();
        points = new javax.swing.JTextField();

        redColour.setBackground(new java.awt.Color(255, 204, 204));
        redColour.setText(BUNDLE.getString("cardPanel.menu.redColour"));
        redColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redColourActionPerformed(evt);
            }
        });
        jPopupMenu1.add(redColour);

        greenColour.setBackground(new java.awt.Color(204, 255, 204));
        greenColour.setText(BUNDLE.getString("cardPanel.menu.greenColour"));
        greenColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenColourActionPerformed(evt);
            }
        });
        jPopupMenu1.add(greenColour);

        blueColour.setBackground(new java.awt.Color(204, 204, 255));
        blueColour.setText(BUNDLE.getString("cardPanel.menu.blueColour"));
        blueColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueColourActionPerformed(evt);
            }
        });
        jPopupMenu1.add(blueColour);

        yellowColour.setBackground(new java.awt.Color(250, 245, 219));
        yellowColour.setText(BUNDLE.getString("cardPanel.menu.yellowColour"));
        yellowColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowColourActionPerformed(evt);
            }
        });
        jPopupMenu1.add(yellowColour);


        jPopupMenu1.add(jSeparator2);
        deleteItem.setText(BUNDLE.getString("cardPanel.menu.delete"));
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });

        jPopupMenu1.add(deleteItem);

        archiveItem.setText(BUNDLE.getString("cardPanel.menu.archive"));
        archiveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(archiveItem);

        jPopupMenu1.add(jSeparator1);
        copyTo.setText(BUNDLE.getString("cardPanel.menu.copyTo"));
        copyTo.setEnabled(false);
        jPopupMenu1.add(copyTo);
        copyToStickyNote.setText(BUNDLE.getString("cardPanel.menu.copyToStickyNote"));
        copyToStickyNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyToStickyNoteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(copyToStickyNote);

        copyToCardWall.setText(BUNDLE.getString("cardPanel.menu.copyToCardWall"));
        copyToCardWall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyToCardWallActionPerformed(evt);
            }
        });
        // @todo
        jPopupMenu1.add(copyToCardWall);

        setBackground(new java.awt.Color(250, 245, 219));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setComponentPopupMenu(jPopupMenu1);
        setMinimumSize(new java.awt.Dimension(170, 170));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        title.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        title.setMinimumSize(new java.awt.Dimension(10, 175));
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });
        title.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                titleControlFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                titleControlFocusLost(evt);
            }
        });

        detail.setFont(new java.awt.Font("DejaVu Sans", 0, 10));
        detail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bodyTextFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                bodyTextFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(detail);

        person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personActionPerformed(evt);
            }
        });
        person.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                personFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                personFocusLost(evt);
            }
        });

        points.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pointsFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                pointsFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(person, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(person, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleControlFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleControlFocusGained
        keyTimer.start();
    }//GEN-LAST:event_titleControlFocusGained

    private void titleControlFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleControlFocusLost
        keyTimer.stop();
        checkSendChanges();
    }//GEN-LAST:event_titleControlFocusLost

    private void bodyTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bodyTextFocusGained
        keyTimer.start();
    }//GEN-LAST:event_bodyTextFocusGained

    private void bodyTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bodyTextFocusLost
        keyTimer.stop();
        checkSendChanges();
    }//GEN-LAST:event_bodyTextFocusLost

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        logger.fine("moused pressed " + evt.getPoint());
        originalPos = evt.getPoint();
        lastPos = evt.getPoint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        if (evt.getButton() == MouseEvent.BUTTON1) {
            Point newPos = evt.getPoint();
            Point objectPosition = this.getLocation();
            Double x = objectPosition.getX() + lastPos.getX(); // - originalPos.getX();
            Double y = objectPosition.getY() + lastPos.getY(); // - originalPos.getY();
            logger.fine("mouse released new position: x - " + x + " y - " + y);
            try {
                cardWallManager.moveCard(cardPosition, x, y);
            } catch (CardWallException e) {
                // do not move the card (@todo add a dialog box or something to warn the user
            }
        }
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        lastPos = evt.getPoint();
    }//GEN-LAST:event_formMouseDragged


    private void copyToStickyNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
        cardWallManager.copyToStickNote(cardPosition);
    }//GEN-LAST:event_deleteItemActionPerformed

    private void copyToCardWallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
        cardWallManager.copyToCardWall(cardPosition);
    }//GEN-LAST:event_deleteItemActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
        cardWallManager.deleteCard(cardPosition);
    }//GEN-LAST:event_deleteItemActionPerformed

    private void archiveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
        cardWallManager.archiveCard(cardPosition);
    }//GEN-LAST:event_deleteItemActionPerformed

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed

    }//GEN-LAST:event_titleActionPerformed

    private void personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personActionPerformed

    private void redColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redColourActionPerformed
        changeColour(redColour.getBackground());
    }//GEN-LAST:event_redColourActionPerformed

    private void greenColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenColourActionPerformed
        changeColour(greenColour.getBackground());
    }//GEN-LAST:event_greenColourActionPerformed

    private void blueColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueColourActionPerformed
        changeColour(blueColour.getBackground());
    }//GEN-LAST:event_blueColourActionPerformed

    private void yellowColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowColourActionPerformed
        changeColour(yellowColour.getBackground());
    }//GEN-LAST:event_yellowColourActionPerformed

    private void personFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_personFocusGained
        keyTimer.start();
    }//GEN-LAST:event_personFocusGained

    private void personFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_personFocusLost
        keyTimer.stop();
        checkSendChanges();
    }//GEN-LAST:event_personFocusLost

    private void pointsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pointsFocusGained
        keyTimer.start();
    }//GEN-LAST:event_pointsFocusGained

    private void pointsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pointsFocusLost
        keyTimer.stop();
        checkSendChanges();
    }//GEN-LAST:event_pointsFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem blueColour;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JMenuItem archiveItem;
    private javax.swing.JTextPane detail;
    private javax.swing.JMenuItem greenColour;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField person;
    private javax.swing.JTextField points;
    private javax.swing.JMenuItem redColour;
    private javax.swing.JTextField title;
    private javax.swing.JMenuItem yellowColour;
    private javax.swing.JMenuItem copyToStickyNote;
    private javax.swing.JMenuItem copyTo;
    private javax.swing.JMenuItem copyToCardWall;
    // End of variables declaration//GEN-END:variables

}
