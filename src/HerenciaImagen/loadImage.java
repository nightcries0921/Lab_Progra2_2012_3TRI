/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * loadImage.java
 *
 * Created on 02-10-2012, 07:29:45 AM
 */
package HerenciaImagen;

import javax.swing.JLabel;

/**
 *
 * @author NIGHTMARE
 */
public class loadImage extends javax.swing.JFrame {

    /** Creates new form loadImage */
    public loadImage(int x,int y,Imagen i,String n) {
        initComponents();
        this.setResizable(false);
        this.setBounds(x, y, i.ancho,i.alto);
        this.setTitle(n+" - "+i.getTamanio());
        JLabel label=new JLabel();        
        label.setBounds(0, 0, i.ancho,i.alto);
        label.setIcon(i.cargarImagen());
        this.getContentPane().add(label);
        this.setVisible(true);
                
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-338)/2, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
