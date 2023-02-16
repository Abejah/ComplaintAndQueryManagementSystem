/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Students;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author chloe morris
 */
public class StudentPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form StudentPanel
     */
    public StudentPanel() {
        initComponents();
        setOpaque(false);
    }

  
    @SuppressWarnings("unchecked")
    
  @Override
  protected void paintComponent(Graphics graphics)
  {
      Graphics2D graphics2D= (Graphics2D)graphics;
      graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      graphics2D.setColor(getBackground());
      graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 15,15);
      super.paintComponent(graphics);
  }
            
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
