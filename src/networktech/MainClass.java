/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networktech;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ogzkhrmn
 */
public class MainClass extends javax.swing.JFrame {

    ArrayList<ArrayList<Integer>> dynamic2D = new ArrayList<ArrayList<Integer>>();
    ArrayList<String> arraylist = new ArrayList<>();
    HashMap buttonList = new HashMap();
    int addedbutton = 0;
    int edgecount = 0;
    String clickedbefore = "Nothing";
    Double x, y;
    boolean painted = false;
    protected LinkedList<Line> lines = new LinkedList<Line>();
    protected HashMap linesSequence = new HashMap();

    //This method using for drawings. 
    @Override
    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1 + 20, line.y1 + 30, line.x2 + 20, line.y2 + 30);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("" + line.weight, (((line.x1 + 20) + (line.x2 + 20)) / 2), (((line.y1 + 30) + (line.y2 + 30)) / 2));
        }
        if (!painted) {
            repaint();
            painted = true;
        }
    }

    public MainClass() {
        initComponents();
        jPanel1.setBackground(Color.WHITE);
        jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Graphics g = jPanel1.getGraphics();
                super.mouseClicked(me);
                Point po = me.getPoint(); //Finding clicked position for adding new button.
                //Adding new item to our square matrix
                for (int i = 0; i < addedbutton; i++) {
                    dynamic2D.get(i).add(35555);
                }
                RoundButton jb = new RoundButton("" + (++addedbutton));
                dynamic2D.add(new ArrayList<Integer>());
                for (int i = 0; i < addedbutton; i++) {
                    dynamic2D.get(addedbutton - 1).add(35555);
                }
                jb.setVisible(true);
                x = po.getX();
                y = po.getY();
                buttonList.put(jb.getLabel(), new MyButtons(x.intValue(), y.intValue(), jb.getLabel(), false, jb));
                jb.setBackground(Color.LIGHT_GRAY);
                jb.setBounds(x.intValue(), y.intValue(), 40, 40);
                jb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.

                        //if never clicked a button, we are setting clicked for this button
                        if (jb.getBackground() == Color.CYAN) {
                            jb.setBackground(Color.LIGHT_GRAY);
                            clickedbefore = "Nothing";
                            jPanel1.repaint();
                            painted = false;
                            paint(g);
                        } else if ("Nothing".equals(clickedbefore)) {   //if we click same button, we are setting unclicked.
                            clickedbefore = jb.getLabel();
                            jb.setBackground(Color.cyan);
                            jPanel1.repaint();
                            painted = false;
                            paint(g);
                        } else {
                            MyButtons mb = (MyButtons) buttonList.get(clickedbefore); //if we click new button and we can find 
                            //clicked different button we are drawing a connection between the buttons.
                            MyButtons mb2 = (MyButtons) buttonList.get(jb.getLabel());
                            jb.setBackground(Color.LIGHT_GRAY);
                            RoundButton rv2 = mb.getRb();
                            rv2.setBackground(Color.LIGHT_GRAY);
                            String message = JOptionPane.showInputDialog(null, "please ınput the weight");
                            dynamic2D.get(Integer.parseInt(mb.getId()) - 1).set(Integer.parseInt(mb2.getId()) - 1, Integer.parseInt(message));
                            dynamic2D.get(Integer.parseInt(mb2.getId()) - 1).set(Integer.parseInt(mb.getId()) - 1, Integer.parseInt(message));
                            lines.add(new Line(mb.getX(), mb.getY(), mb2.getX(), mb2.getY(), Integer.parseInt(message), Color.black));
                            linesSequence.put(clickedbefore + "," + jb.getLabel(), edgecount++);
                            clickedbefore = "Nothing";
                            jPanel1.repaint();
                            painted = false;
                            paint(g);
                        }
                    }

                });
                jPanel1.add("" + addedbutton, jb);
                jPanel1.repaint();
                painted = false;
                RoundButton rbm;
                for (Line line : lines) {
                    line.setColor(Color.BLACK);
                }
                for (int i = 1; i <= addedbutton; i++) {
                    MyButtons mbm = (MyButtons) buttonList.get("" + i);
                    rbm = mbm.getRb();
                    rbm.setBackground(Color.LIGHT_GRAY);
                }
                paint(g);
            }

        });
        jPanel1.add(new JButton("asdasd"));
        jPanel1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Find MST");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Find Sink Trees");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(572, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Graphics g = jPanel1.getGraphics();
        // in this method we are calculating MST for our graph.
        MST mst = new MST(dynamic2D, dynamic2D.get(0).size());
        arraylist = mst.findMST();
        int line;
        int i = 0;
        Line findline;
        while (i < arraylist.size()) {
            if (linesSequence.get(arraylist.get(i)) != null) {
                line = (Integer) linesSequence.get(arraylist.get(i));
                findline = lines.get(line);
                findline.setColor(Color.ORANGE);
                lines.set(line, findline);
                if ((i / 2) == 0) {
                    i++;
                }
            }
            i++;
        }

        RoundButton mybutButton;
        MyButtons myb;
        for (i = 1; i <= buttonList.size(); i++) {
            myb = (MyButtons) buttonList.get("" + i);
            mybutButton = myb.getRb();
            mybutButton.setBackground(Color.ORANGE);
        }
        painted = false;
        paint(g);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:z

        int target = Integer.parseInt(JOptionPane.showInputDialog("Please insert the target"));
        Graphics g = jPanel1.getGraphics();
        // in this method we are calculating MST for our graph.
        MST mst = new MST(dynamic2D, dynamic2D.get(0).size());
        arraylist = mst.findMST();
        painted = false;
        boolean finished = false;
        RoundButton rbm;
        for (Line line : lines) {
            line.setColor(Color.BLACK);
        }
        for (int i = 1; i <= addedbutton; i++) {
            MyButtons mbm = (MyButtons) buttonList.get("" + i);
            rbm = mbm.getRb();
            rbm.setBackground(Color.LIGHT_GRAY);
        }
        int line;
        int i = 0;
        Line findline;
        String[] parts;
        int part1, part2;
        while (i < arraylist.size() && !finished) {
            if (linesSequence.get(arraylist.get(i)) != null) {
                line = (Integer) linesSequence.get(arraylist.get(i));
                parts = arraylist.get(i).split(",");
                part1 = Integer.parseInt(parts[0]); // 004
                part2 = Integer.parseInt(parts[1]); // 034556
                findline = lines.get(line);
                findline.setColor(Color.ORANGE);
                lines.set(line, findline);
                if (part1==target||part2==target) {
                    finished = true;
                }
                MyButtons mbm = (MyButtons) buttonList.get("" + part1);
            rbm = mbm.getRb();
            rbm.setBackground(Color.ORANGE);
            mbm = (MyButtons) buttonList.get("" + part2);
            rbm = mbm.getRb();
            rbm.setBackground(Color.ORANGE);
                if ((i / 2) == 0) {
                    i++;
                }
            }
            i++;
        }
        paint(g);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
