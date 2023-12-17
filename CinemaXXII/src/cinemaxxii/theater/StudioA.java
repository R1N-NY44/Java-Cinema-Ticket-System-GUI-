/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cinemaxxii.theater;

import cinemaxxii.Studio;
import java.util.ArrayList;

/**
 *
 * @author Yoga
 */
public class StudioA extends javax.swing.JPanel implements Studio{

    private String StudioName;
    private int StudioSeat;
    private int StudioPrice;
    private ArrayList<Integer> selectedSeats = new ArrayList<>();
    /**
     * Creates new form StudioA
     */
    public StudioA(String time) {
        initComponents();
        
        System.out.println("current "+time);
    }

    @Override
    public void setStudioName(String studioName) {
        this.StudioName = studioName;
    }

    @Override
    public String getStudioName() {
        return this.StudioName;
    }

    @Override
    public void setStudioCapacity(int seat) {
        this.StudioSeat = seat;
    }

    @Override
    public int getStudioCapacity() {
        return this.StudioSeat;
    }

    @Override
    public void setStudioPrice(int studioPrice) {
        this.StudioPrice = studioPrice;
    }

    @Override
    public int getStudioPrice() {
        return this.StudioPrice;
    }

    public ArrayList<Integer> getSelectedSeats() {
        return selectedSeats;
    }
    
    private void toggleSeat(int seatNumber, javax.swing.JButton seatButton) {
        if (selectedSeats.contains(seatNumber)) {
            // Kursi sudah dipilih, hapus dari selectedSeats dan ubah warna tombol
            selectedSeats.remove(Integer.valueOf(seatNumber));
            seatButton.setBackground(new java.awt.Color(240, 240, 240));  // Warna default
        } else {
            // Kursi belum dipilih, tambahkan ke selectedSeats dan ubah warna tombol
            selectedSeats.add(seatNumber);
            seatButton.setBackground(new java.awt.Color(102, 102, 102));  // Warna yang diinginkan
        }
        // Tambahkan logika lain yang mungkin Anda perlukan setelah mengubah selectedSeats
        System.out.println("Selected Seats: " + selectedSeats);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderTitle = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        beta1 = new javax.swing.JButton();
        beta2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(40, 40, 40));
        setForeground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(424, 572));
        setPreferredSize(new java.awt.Dimension(424, 572));

        HeaderTitle.setBackground(new java.awt.Color(33, 33, 33));

        jSeparator5.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator5.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 92, 71), 2));
        jSeparator5.setPreferredSize(new java.awt.Dimension(3, 3));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Castellar", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Studio A");

        jSeparator2.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator2.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 92, 71), 2));
        jSeparator2.setPreferredSize(new java.awt.Dimension(3, 3));

        javax.swing.GroupLayout HeaderTitleLayout = new javax.swing.GroupLayout(HeaderTitle);
        HeaderTitle.setLayout(HeaderTitleLayout);
        HeaderTitleLayout.setHorizontalGroup(
            HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderTitleLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderTitleLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        HeaderTitleLayout.setVerticalGroup(
            HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderTitleLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        jSeparator4.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator4.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 147, 106)));
        jSeparator4.setPreferredSize(new java.awt.Dimension(3, 2));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Castellar", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Screen Area");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSeparator3.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator3.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 147, 106)));
        jSeparator3.setPreferredSize(new java.awt.Dimension(3, 2));

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        beta1.setText("Test1");
        beta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beta1ActionPerformed(evt);
            }
        });

        beta2.setText("Test2");
        beta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beta2ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(beta2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(33, 33, 33)
                        .addComponent(beta1)))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jSeparator3, jSeparator4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(HeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(217, 217, 217)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(beta1))
                .addGap(18, 18, 18)
                .addComponent(beta2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        for (Integer seat : selectedSeats) {
                System.out.println("Email, Kursi " + seat);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void beta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beta1ActionPerformed
        // TODO add your handling code here:
        toggleSeat(1, beta1);
    }//GEN-LAST:event_beta1ActionPerformed

    private void beta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beta2ActionPerformed
        // TODO add your handling code here:
        toggleSeat(2, beta2);   
    }//GEN-LAST:event_beta2ActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderTitle;
    private javax.swing.JButton beta1;
    private javax.swing.JButton beta2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
