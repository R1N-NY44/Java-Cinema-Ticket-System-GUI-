/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cinemaxxii.view.Detail;

import cinemaxxii.Database;
import cinemaxxii.display.DisplayFrame;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Yoga
 */
public class CheckOutWindow extends javax.swing.JFrame {

    //Checkout Window Manager
    CheckOutBackground showBackground = new CheckOutBackground();
    private final Database c = new Database();
    private final DisplayFrame displayFrame;
    
    private String movieId, movieTitle, theather, showtime, showdate;
    private ArrayList<Integer> selectedSeats;
    int seatPrice;
    
    /**
     * Creates new form CheckOutWindow
     */
    public CheckOutWindow(DisplayFrame displayFrame, String movieId, String movieTitle, String theather, String showtime, String showdate, ArrayList<Integer> selectedSeats, int seatPrice) {
        initComponents();
        
        this.displayFrame = displayFrame;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.theather = theather;
        this.showtime = showtime;
        this.showdate = showdate;
        this.selectedSeats = selectedSeats;
        this.seatPrice = seatPrice;
        
        System.out.println("======[CheckOut]======");
        System.out.println("Movie ID : " + movieId + "\nMovie Title : " + movieTitle + "\nTheather : " + theather + "\nShow Time : " + showtime + "\nShow Date : " + showdate + "\nSeat Price : " + seatPrice);
        System.out.println("Seat : " + selectedSeats);
        System.out.println("======[CheckOut]======");
        
        printTitle.setText(movieTitle);
        printSeat.setText(": " + String.valueOf(selectedSeats));
        printTheather.setText(": " + theather);
        printTime.setText(": " + showtime);
        printDate.setText(": " + showdate);
        printPrice.setText(": " + String.valueOf(seatPrice)); 
        printTotalPrice.setText("Total : " + String.valueOf(seatPrice * selectedSeats.size()));
        
        showBackground.dispose(); //hanlde under decorated
        showBackground.setUndecorated(true); //make it more clear looks
        showBackground.setOpacity(0.6f); //window opacity 
        showBackground.setExtendedState(JFrame.MAXIMIZED_BOTH); //Full Screen
        //checkOutShow.setAlwaysOnTop(true); //make the frame always on top
        showBackground.setVisible(true); //make it visible
        
    }
    
    private void databaseSeat() {
        try (var conn = c.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO seat (MovID, SeatIndex, Time, ShowDate) VALUES (?, ?, ?, ?)")) {

            // Iterate over selected seats and insert them into the database
            for (Integer seat : selectedSeats) {
                ps.setString(1, movieId);
                ps.setInt(2, seat);
                ps.setString(3, showtime);
                ps.setString(4, showdate);
                ps.addBatch();  // Add the batch for batch processing
            }

            // Execute the batch insert
            ps.executeBatch();

            System.out.println("Selected seats have been inserted into the database.");

        } catch (SQLException e) {
            // Handle or log the exception appropriately
            e.printStackTrace();
        }
    }
    
    private void databaseTransaction() {
        try (var conn = c.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO transaction (UserEmail, MovTitle, Theather, ShowTime, SeatIndex, Price, TransactionDate) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            // Iterate over selected seats and insert them into the database
            ps.setString(1, Email.getText());
            ps.setString(2, movieTitle);
            ps.setString(3, theather);
            ps.setString(4, showtime);

            // Convert ArrayList<Integer> to a single string
            ps.setString(5, selectedSeats.toString());
            ps.setInt(6, seatPrice * selectedSeats.size());
            ps.setString(7, showdate);

            // Execute the query
            int rowsAffected = ps.executeUpdate();

            // Check if the query was successful
            if (rowsAffected > 0) {
                System.out.println("Transaction successfully inserted into the database.");
            } else {
                System.out.println("Failed to insert transaction into the database.");
            }

        } catch (SQLException e) {
            // Handle or log the exception appropriately
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        HeaderTitle = new javax.swing.JPanel();
        printTitle = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        Confirm = new javax.swing.JButton();
        Email = new javax.swing.JTextField();
        printTotalPrice = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        printTheather = new javax.swing.JLabel();
        printTime = new javax.swing.JLabel();
        printDate = new javax.swing.JLabel();
        printPrice = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        printSeat = new javax.swing.JTextArea();
        IMG_Banner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(935, 672));
        setSize(new java.awt.Dimension(935, 925));

        Base.setBackground(new java.awt.Color(53, 53, 53));
        Base.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 92, 71), 3));
        Base.setMinimumSize(new java.awt.Dimension(935, 672));
        Base.setPreferredSize(new java.awt.Dimension(935, 925));

        HeaderTitle.setBackground(new java.awt.Color(33, 33, 33));
        HeaderTitle.setPreferredSize(new java.awt.Dimension(935, 94));

        printTitle.setBackground(new java.awt.Color(153, 153, 153));
        printTitle.setFont(new java.awt.Font("Castellar", 1, 46)); // NOI18N
        printTitle.setForeground(new java.awt.Color(204, 204, 204));
        printTitle.setText("Movie Title");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderTitleLayout.setVerticalGroup(
            HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderTitleLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(printTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(53, 53, 53));

        ExitButton.setBackground(new java.awt.Color(51, 51, 51));
        ExitButton.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(204, 204, 204));
        ExitButton.setText("Cancel");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        Confirm.setBackground(new java.awt.Color(176, 147, 106));
        Confirm.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        Confirm.setForeground(new java.awt.Color(255, 255, 255));
        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        Email.setFont(new java.awt.Font("Cormorant Infant", 0, 36)); // NOI18N
        Email.setText("Email");

        printTotalPrice.setFont(new java.awt.Font("Cormorant Infant", 1, 42)); // NOI18N
        printTotalPrice.setForeground(new java.awt.Color(240, 240, 240));
        printTotalPrice.setText("Total Price");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ExitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(Confirm))
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printTotalPrice))
                .addGap(62, 62, 62))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Confirm, ExitButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(printTotalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton)
                    .addComponent(Confirm))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Confirm, ExitButton});

        jPanel3.setBackground(new java.awt.Color(53, 53, 53));

        jLabel2.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Theather");

        jLabel3.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Show Time");

        jLabel4.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Show Date");

        jLabel5.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Seat Price");

        printTheather.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        printTheather.setForeground(new java.awt.Color(240, 240, 240));
        printTheather.setText("Theather");

        printTime.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        printTime.setForeground(new java.awt.Color(240, 240, 240));
        printTime.setText("Show Time");

        printDate.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        printDate.setForeground(new java.awt.Color(240, 240, 240));
        printDate.setText("Show Date");

        printPrice.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        printPrice.setForeground(new java.awt.Color(240, 240, 240));
        printPrice.setText("Seat Price");

        jLabel6.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Selected Seat");

        printSeat.setEditable(false);
        printSeat.setBackground(new java.awt.Color(53, 53, 53));
        printSeat.setColumns(20);
        printSeat.setFont(new java.awt.Font("Cormorant Infant", 1, 36)); // NOI18N
        printSeat.setForeground(new java.awt.Color(255, 255, 255));
        printSeat.setLineWrap(true);
        printSeat.setRows(5);
        printSeat.setWrapStyleWord(true);
        printSeat.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel6))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(printPrice)
                            .addComponent(printDate)
                            .addComponent(printTime)
                            .addComponent(printTheather))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(printSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(printTheather)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printPrice))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(printSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IMG_Banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Suzume no Tojimari_Large.jpg"))); // NOI18N

        javax.swing.GroupLayout BaseLayout = new javax.swing.GroupLayout(Base);
        Base.setLayout(BaseLayout);
        BaseLayout.setHorizontalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
            .addGroup(BaseLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BaseLayout.createSequentialGroup()
                        .addComponent(IMG_Banner, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        BaseLayout.setVerticalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BaseLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(HeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IMG_Banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:        
        showBackground.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        // TODO add your handling code here:
        //String emailText = Email.getText();
    
        if (Email.getText().endsWith("@gmail.com")) {
            int confirmDialogResult = JOptionPane.showConfirmDialog(this, "\"" + Email.getText() + "\" Alamat Email sudah benar ?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmDialogResult == JOptionPane.YES_OPTION) {
                databaseSeat();
                databaseTransaction();

                // Tampilkan pesan informasi setelah berhasil menyimpan data
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan.", "Information", JOptionPane.INFORMATION_MESSAGE);
                
                showBackground.setVisible(false);
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Periksa kembali alamat Email!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_ConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(CheckOutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CheckOutWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JButton Confirm;
    private javax.swing.JTextField Email;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel HeaderTitle;
    private javax.swing.JLabel IMG_Banner;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel printDate;
    private javax.swing.JLabel printPrice;
    private javax.swing.JTextArea printSeat;
    private javax.swing.JLabel printTheather;
    private javax.swing.JLabel printTime;
    private javax.swing.JLabel printTitle;
    private javax.swing.JLabel printTotalPrice;
    // End of variables declaration//GEN-END:variables
}
