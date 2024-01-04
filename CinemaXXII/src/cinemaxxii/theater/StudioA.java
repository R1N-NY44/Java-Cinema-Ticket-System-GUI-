/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cinemaxxii.theater;

import cinemaxxii.Database;
import cinemaxxii.Studio;
import cinemaxxii.display.DisplayFrame;
import cinemaxxii.view.Detail.CheckOutWindow;
import cinemaxxii.view.Detail.CheckOutBackground;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Yoga
 */
public class StudioA extends javax.swing.JPanel implements Studio{

    private final DisplayFrame displayFrame;
    
    private final Database c = new Database();
    private String StudioName = "StudioA";
    private int StudioPrice = 32000;
    private int StudioSeat = 18;
    //private int ;
    private String movieId, title, theather, showTime, showDate;
    
    
    private ArrayList<Integer> selectedSeats = new ArrayList<>();
    /**
     * Creates new form StudioA
     */
    
    public StudioA(DisplayFrame displayFrame, String movieId, String movieTitle, String theather, String showtime, String showdate) {
        initComponents();

        // Assign value to each variable
        this.displayFrame = displayFrame;
        this.movieId = movieId;
        this.title = movieTitle;
        this.theather = theather;
        this.showTime = showtime;
        this.showDate = showdate;

        // Initialize seat buttons
        initializeSeatButtons();

        // Set Studio Title
        StudioTitle.setText("Studio A (" + showTime + ")");

        // Print studio info
        System.out.println("======[Studio A]======");
        System.out.println("Mov ID: " + movieId);
        System.out.println("Title: " + title);
        System.out.println("Theather : " + theather);
        System.out.println("Show Date: " + showDate);
        System.out.println("Show Time: " + showTime);
        System.out.println("======[Studio A]======");
    }

    //get current seat data from database
    private ArrayList<Integer> getBookedSeatsFromDatabase() {
        ArrayList<Integer> bookedSeats = new ArrayList<>();

        try (var conn = c.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM seat WHERE `MovID` = ? AND `Time` = ? AND `ShowDate` = ?")) {

            ps.setString(1, movieId);
            ps.setString(2, showTime);
            ps.setString(3, showDate);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int seatNumber = rs.getInt("SeatIndex");
                    bookedSeats.add(seatNumber);
                }
            }

        } catch (SQLException e) {
            // Handle or log the exception appropriately
            e.printStackTrace();
        }

        // Iterate over booked seats and update the corresponding buttons
        bookedSeats.forEach(seat -> {
            JButton seatButton = getSeatButton(seat);
            if (seatButton != null) {
                seatButton.setBackground(new java.awt.Color(51,51,51));
                seatButton.setForeground(new java.awt.Color(152,152,152));
            }
        });

        return bookedSeats;
    }


    //button event listener (action for each button)
    private void initializeSeatButtons() {
        ArrayList<Integer> bookedSeats = getBookedSeatsFromDatabase();

        for (var i = 1; i <= getStudioCapacity(); i++) {
            JButton seatButton = getSeatButton(i);
            final int seatNumber = i;

            seatButton.addActionListener(evt -> toggleSeat(seatNumber, seatButton, bookedSeats));
        }
    }
    
    //toggle Button handling (cuz checked button so sucks :v)
    private void toggleSeat(int seatNumber, JButton seatButton, ArrayList<Integer> bookedSeats) {
        if (selectedSeats.contains(seatNumber)) {
            // Kursi sudah dipilih, hapus dari selectedSeats dan ubah warna tombol
            selectedSeats.remove(Integer.valueOf(seatNumber));
            seatButton.setBackground(new java.awt.Color(204,204,204));  // Warna default
            toggleConfirm();
        } else if (bookedSeats.contains(seatNumber)) {
            // Kursi sudah dipesan, tidak dapat dipilih
            System.out.println("Seat " + seatNumber + " is already booked.");
            // Tambahkan logika lain yang diperlukan jika kursi sudah dipesan
        } else {
            // Kursi belum dipilih dan belum dipesan, tambahkan ke selectedSeats dan ubah warna tombol
            selectedSeats.add(seatNumber);
            seatButton.setBackground(new java.awt.Color(176, 147, 106));  // Warna yang diinginkan
            toggleConfirm();
        }
        // Tambahkan logika lain yang mungkin Anda perlukan setelah mengubah selectedSeats
        System.out.println("Selected Seats: " + selectedSeats);
    }
    
    private void toggleConfirm(){
        if (selectedSeats.size() > 0){
            Confirmation.setBackground(new java.awt.Color(176,147,106));
            Confirmation.setForeground(new java.awt.Color(255,255,255));
        } else {
            Confirmation.setBackground(new java.awt.Color(21,21,21));
            Confirmation.setForeground(new java.awt.Color(204,204,204));
        }
    }
    
    //give an return based on database record
    private JButton getSeatButton(int seatName) {
        switch (seatName) {
            case 1: return Seat1;
            case 2: return Seat2;
            case 3: return Seat3;
            case 4: return Seat4;
            case 5: return Seat5;
            case 6: return Seat6;
            case 7: return Seat7;
            case 8: return Seat8;
            case 9: return Seat9;
            case 10: return Seat10;
            case 11: return Seat11;
            case 12: return Seat12;
            case 13: return Seat13;
            case 14: return Seat14;
            case 15: return Seat15;
            case 16: return Seat16;
            case 17: return Seat17;
            case 18: return Seat18;
            default: throw new IllegalArgumentException("Invalid seat number: " + seatName);
        }
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

    //method to add to seat table (beta test)
    private void insertSelectedSeatsToDatabase() {
        try (var conn = c.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO seat (MovID, SeatIndex, Time, ShowDate) VALUES (?, ?, ?, ?)")) {

            // Iterate over selected seats and insert them into the database
            for (Integer seat : selectedSeats) {
                ps.setString(1, movieId);
                ps.setInt(2, seat);
                ps.setString(3, showTime);
                ps.setString(4, showDate);
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

    
    
//    private void toggleSeat(int seatNumber, javax.swing.JButton seatButton) {
//        if (selectedSeats.contains(seatNumber)) {
//            // Kursi sudah dipilih, hapus dari selectedSeats dan ubah warna tombol
//            selectedSeats.remove(Integer.valueOf(seatNumber));
//            seatButton.setBackground(new java.awt.Color(102,102,102));  // Warna default
//        } else {
//            // Kursi belum dipilih, tambahkan ke selectedSeats dan ubah warna tombol
//            selectedSeats.add(seatNumber);
//            seatButton.setBackground(new java.awt.Color(176,147,106));  // Warna yang diinginkan
//        }
//        // Tambahkan logika lain yang mungkin Anda perlukan setelah mengubah selectedSeats
//        System.out.println("Selected Seats: " + selectedSeats);
//    }

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
        StudioTitle = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        Seat1 = new javax.swing.JButton();
        Seat2 = new javax.swing.JButton();
        Seat3 = new javax.swing.JButton();
        Seat4 = new javax.swing.JButton();
        Seat5 = new javax.swing.JButton();
        Seat6 = new javax.swing.JButton();
        Seat7 = new javax.swing.JButton();
        Seat8 = new javax.swing.JButton();
        Seat9 = new javax.swing.JButton();
        Seat10 = new javax.swing.JButton();
        Seat11 = new javax.swing.JButton();
        Seat12 = new javax.swing.JButton();
        Seat13 = new javax.swing.JButton();
        Seat14 = new javax.swing.JButton();
        Seat15 = new javax.swing.JButton();
        Seat16 = new javax.swing.JButton();
        Seat17 = new javax.swing.JButton();
        Seat18 = new javax.swing.JButton();
        Confirmation = new javax.swing.JButton();

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

        StudioTitle.setBackground(new java.awt.Color(153, 153, 153));
        StudioTitle.setFont(new java.awt.Font("Castellar", 1, 32)); // NOI18N
        StudioTitle.setForeground(new java.awt.Color(204, 204, 204));
        StudioTitle.setText("Studio A (06.00)");

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
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(StudioTitle)
                .addContainerGap(57, Short.MAX_VALUE))
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
                .addComponent(StudioTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel4.setBackground(new java.awt.Color(40, 40, 40));

        Seat1.setBackground(new java.awt.Color(204, 204, 204));
        Seat1.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat1.setForeground(new java.awt.Color(51, 51, 51));
        Seat1.setText("1");
        Seat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat1ActionPerformed(evt);
            }
        });

        Seat2.setBackground(new java.awt.Color(204, 204, 204));
        Seat2.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat2.setForeground(new java.awt.Color(51, 51, 51));
        Seat2.setText("2");
        Seat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat2ActionPerformed(evt);
            }
        });

        Seat3.setBackground(new java.awt.Color(204, 204, 204));
        Seat3.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat3.setForeground(new java.awt.Color(51, 51, 51));
        Seat3.setText("3");
        Seat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat3ActionPerformed(evt);
            }
        });

        Seat4.setBackground(new java.awt.Color(204, 204, 204));
        Seat4.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat4.setForeground(new java.awt.Color(51, 51, 51));
        Seat4.setText("4");
        Seat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat4ActionPerformed(evt);
            }
        });

        Seat5.setBackground(new java.awt.Color(204, 204, 204));
        Seat5.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat5.setForeground(new java.awt.Color(51, 51, 51));
        Seat5.setText("5");
        Seat5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat5ActionPerformed(evt);
            }
        });

        Seat6.setBackground(new java.awt.Color(204, 204, 204));
        Seat6.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat6.setForeground(new java.awt.Color(51, 51, 51));
        Seat6.setText("6");
        Seat6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat6ActionPerformed(evt);
            }
        });

        Seat7.setBackground(new java.awt.Color(204, 204, 204));
        Seat7.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat7.setForeground(new java.awt.Color(51, 51, 51));
        Seat7.setText("7");
        Seat7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat7ActionPerformed(evt);
            }
        });

        Seat8.setBackground(new java.awt.Color(204, 204, 204));
        Seat8.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat8.setForeground(new java.awt.Color(51, 51, 51));
        Seat8.setText("8");
        Seat8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat8ActionPerformed(evt);
            }
        });

        Seat9.setBackground(new java.awt.Color(204, 204, 204));
        Seat9.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat9.setForeground(new java.awt.Color(51, 51, 51));
        Seat9.setText("9");
        Seat9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat9ActionPerformed(evt);
            }
        });

        Seat10.setBackground(new java.awt.Color(204, 204, 204));
        Seat10.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat10.setForeground(new java.awt.Color(51, 51, 51));
        Seat10.setText("10");
        Seat10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat10ActionPerformed(evt);
            }
        });

        Seat11.setBackground(new java.awt.Color(204, 204, 204));
        Seat11.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat11.setForeground(new java.awt.Color(51, 51, 51));
        Seat11.setText("11");
        Seat11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat11ActionPerformed(evt);
            }
        });

        Seat12.setBackground(new java.awt.Color(204, 204, 204));
        Seat12.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat12.setForeground(new java.awt.Color(51, 51, 51));
        Seat12.setText("12");
        Seat12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat12ActionPerformed(evt);
            }
        });

        Seat13.setBackground(new java.awt.Color(204, 204, 204));
        Seat13.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat13.setForeground(new java.awt.Color(51, 51, 51));
        Seat13.setText("13");
        Seat13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat13ActionPerformed(evt);
            }
        });

        Seat14.setBackground(new java.awt.Color(204, 204, 204));
        Seat14.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat14.setForeground(new java.awt.Color(51, 51, 51));
        Seat14.setText("14");
        Seat14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat14ActionPerformed(evt);
            }
        });

        Seat15.setBackground(new java.awt.Color(204, 204, 204));
        Seat15.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat15.setForeground(new java.awt.Color(51, 51, 51));
        Seat15.setText("15");
        Seat15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat15ActionPerformed(evt);
            }
        });

        Seat16.setBackground(new java.awt.Color(204, 204, 204));
        Seat16.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat16.setForeground(new java.awt.Color(51, 51, 51));
        Seat16.setText("16");
        Seat16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat16ActionPerformed(evt);
            }
        });

        Seat17.setBackground(new java.awt.Color(204, 204, 204));
        Seat17.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat17.setForeground(new java.awt.Color(51, 51, 51));
        Seat17.setText("17");
        Seat17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat17ActionPerformed(evt);
            }
        });

        Seat18.setBackground(new java.awt.Color(204, 204, 204));
        Seat18.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Seat18.setForeground(new java.awt.Color(51, 51, 51));
        Seat18.setText("18");
        Seat18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seat18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Seat14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Seat15, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Seat16, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Seat17, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Seat18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Seat9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(Seat10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(Seat11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(Seat12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Seat13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(Seat5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(Seat6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(108, 108, 108)
                                    .addComponent(Seat7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(Seat8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(Seat1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(Seat2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(108, 108, 108)
                                    .addComponent(Seat3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(Seat4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seat1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seat5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seat9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seat14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seat18, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Confirmation.setBackground(new java.awt.Color(21, 21, 21));
        Confirmation.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        Confirmation.setForeground(new java.awt.Color(204, 204, 204));
        Confirmation.setText("confirm");
        Confirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(Confirmation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jSeparator3, jSeparator4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(HeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Confirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    

    
    private void Seat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat1ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat1ActionPerformed

    private void Seat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat2ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat2ActionPerformed

    private void Seat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat3ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat3ActionPerformed

    private void Seat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat4ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat4ActionPerformed

    private void Seat5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat5ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat5ActionPerformed

    private void Seat6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat6ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat6ActionPerformed

    private void Seat7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat7ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat7ActionPerformed

    private void Seat8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat8ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat8ActionPerformed

    private void Seat9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat9ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat9ActionPerformed

    private void Seat10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat10ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat10ActionPerformed

    private void Seat11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat11ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat11ActionPerformed

    private void Seat12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat12ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat12ActionPerformed

    private void Seat13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat13ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat13ActionPerformed

    private void Seat14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat14ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat14ActionPerformed

    private void Seat15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat15ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat15ActionPerformed

    private void Seat16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat16ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat16ActionPerformed

    private void Seat17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat17ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat17ActionPerformed

    private void Seat18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seat18ActionPerformed
        //handling on initializeSeatButtons();
    }//GEN-LAST:event_Seat18ActionPerformed

    private void ConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmationActionPerformed

        if (selectedSeats.size() > 0){
            CheckOutWindow CheckOut = new CheckOutWindow(displayFrame, movieId, title, theather, showTime, showDate, selectedSeats, StudioPrice);
            CheckOut.dispose();
            CheckOut.setUndecorated(true);
            CheckOut.setAlwaysOnTop(true);
            CheckOut.setLocationRelativeTo(null);
            CheckOut.setVisible(true);
        }
    }//GEN-LAST:event_ConfirmationActionPerformed
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmation;
    private javax.swing.JPanel HeaderTitle;
    private javax.swing.JButton Seat1;
    private javax.swing.JButton Seat10;
    private javax.swing.JButton Seat11;
    private javax.swing.JButton Seat12;
    private javax.swing.JButton Seat13;
    private javax.swing.JButton Seat14;
    private javax.swing.JButton Seat15;
    private javax.swing.JButton Seat16;
    private javax.swing.JButton Seat17;
    private javax.swing.JButton Seat18;
    private javax.swing.JButton Seat2;
    private javax.swing.JButton Seat3;
    private javax.swing.JButton Seat4;
    private javax.swing.JButton Seat5;
    private javax.swing.JButton Seat6;
    private javax.swing.JButton Seat7;
    private javax.swing.JButton Seat8;
    private javax.swing.JButton Seat9;
    private javax.swing.JLabel StudioTitle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
