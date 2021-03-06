/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * View_Users.java
 *
 * Created on 10-ago-2012, 7:37:36
 */
package GenerarObjetos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class View_Users extends javax.swing.JFrame {
    Container contenedorPrincipal;
    Container contenedores[][];
    Object objetos[][];
    Users usuarios[];
    int cant;
    int selectedUser;
    JScrollPane scroll=new JScrollPane();
    public View_Users(Users us[],int cant) {
        initComponents();
        this.usuarios=us;
        this.cant=cant;
        iniciar();
        crearObjetos();
        addListeners();
        selectedUser=0;
        if(cant!=0)
            this.setSelectedUser(0);
        openFormed();
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
        setBounds((screenSize.width-760)/2, (screenSize.height-579)/2, 760, 579);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciar() {
        this.contenedorPrincipal=new Container();
        this.contenedores=new Container[this.cant][2];
        this.objetos=new Object[this.cant][4];
    }

    private void crearObjetos() {
        this.contenedorPrincipal.setSize(220, 400);
        this.contenedorPrincipal.setLayout(new BoxLayout(this.contenedorPrincipal,BoxLayout.PAGE_AXIS));
        for(int i=0;i<this.cant;i++){
            this.contenedores[i][0]=new Container();
            this.contenedores[i][0].setLayout(new BoxLayout(this.contenedores[i][0],BoxLayout.LINE_AXIS));
            this.contenedores[i][0].setSize(200, 100);
            this.contenedores[i][1]=new Container();
            this.contenedores[i][1].setLayout(new BoxLayout(this.contenedores[i][1],BoxLayout.Y_AXIS));
            this.contenedores[i][1].setSize(120,100);
            this.objetos[i][0] = new JLabel();
            colocarImagen(i);
            this.objetos[i][1]=new JLabel(this.usuarios[i].nombre);
            this.objetos[i][2]=new JLabel(this.usuarios[i].direccion);
            this.objetos[i][3]=new JLabel((this.usuarios[i].Sexo=='M'?"Masculino":"Femenino"));
            administrarContenedores(i);
        }
        scroll.setViewportView(this.contenedorPrincipal);
        scroll.setBounds(10, 10, 220, 400);
        this.getContentPane().add(scroll);
    }

    private void colocarImagen(int i) {
        ImageIcon image=new ImageIcon(this.usuarios[i].path);
        ImageIcon imagen=new ImageIcon(image.getImage().getScaledInstance(80,100,Image.SCALE_DEFAULT));
        ((JLabel)this.objetos[i][0]).setIcon(imagen);
        ((JLabel)this.objetos[i][0]).setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void administrarContenedores(int i) {
        this.contenedorPrincipal.add(this.contenedores[i][0]);
        this.contenedorPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
        this.contenedores[i][0].add(((JLabel)this.objetos[i][0]));
        this.contenedores[i][0].add(Box.createRigidArea(new Dimension(20,0)));
        this.contenedores[i][0].add(this.contenedores[i][1]);
        this.contenedores[i][1].add(((JLabel)this.objetos[i][1]));
        this.contenedores[i][1].add(((JLabel)this.objetos[i][2]));
        this.contenedores[i][1].add(((JLabel)this.objetos[i][3]));
    }

    private void setSelectedUser(int i) {
        ((JLabel)this.objetos[this.selectedUser][0]).setBorder(BorderFactory.createLineBorder(Color.BLACK.RED));
        this.selectedUser=i;
        ((JLabel)this.objetos[i][0]).setBorder(BorderFactory.createLineBorder(Color.RED,10));
    }
    private void addListeners() {
        for(int i=0;i<this.cant;i++){
            final int vali=i;
            this.contenedores[i][0].addMouseListener(new MouseAdapter(){
                
                @Override
                public void mouseClicked(MouseEvent e){
                    setSelectedUser(vali);
                }
            });
        }
        this.scroll.addMouseWheelListener(new MouseAdapter(){
            @Override
            public void mouseWheelMoved(MouseWheelEvent e){
                int temp=scroll.getVerticalScrollBar().getValue();
                scroll.getVerticalScrollBar().setValue(temp+(e.getWheelRotation()*5));
            }
        });
        this.scroll.addKeyListener(new KeyAdapter (){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    int temp=scroll.getVerticalScrollBar().getValue();
                    scroll.getVerticalScrollBar().setValue(temp-5);
                }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    int temp=scroll.getVerticalScrollBar().getValue();
                    scroll.getVerticalScrollBar().setValue(temp+5);
                }
            }
        });
        
        this.scroll.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e){
                scroll.requestFocus();
            }
        });
        final JFrame form=this;
        this.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e){
                form.requestFocus();
            }
        });
    }

    private void openFormed() {
        TablaDibujado table=new TablaDibujado();
        this.add(table, BorderLayout.CENTER);
    }

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
