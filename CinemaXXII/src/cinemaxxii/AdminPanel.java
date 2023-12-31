/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cinemaxxii;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Yoga
 */
public class AdminPanel extends javax.swing.JFrame {

    private int idMov;
    private DefaultTableModel transactionModel;
    private final Database k = new Database();
    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
        displayTransactionDataWithSearch();
        
        DefaultTableModel model = (DefaultTableModel) movieTable.getModel();
        model.setRowCount(0);

        //Get data from database
        try (java.sql.Connection conn = k.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT `MovieId`, `Title`, `Genre`, `Director`, `Duration`, `Theater`, `Show Date`, `Show Time`, `Synopsis`, `Cover`, `Banner` FROM movie");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("MovieId");
                String title = rs.getString("Title");
                String genre = rs.getString("Genre");
                String director = rs.getString("Director");
                String duration = rs.getString("Duration");
                String theater = rs.getString("Theater");
                String showDate = rs.getString("Show Date");
                String showTime = rs.getString("Show Time");
                String synopsis = rs.getString("Synopsis");
                String cover = rs.getString("Cover");
                String banner = rs.getString("Banner");

                model.addRow(new Object[]{id, title, genre, director, duration, theater, showDate, showTime, synopsis, cover, banner});

                // Gunakan data sesuai kebutuhan Anda, misalnya, tampilkan di konsol
                System.out.println("ID: " + id + ", Title: " + title + ", Genre: " + genre + ", Director: " + director
                        + ", Duration: " + duration + ", Theater: " + theater + ", Show Date: " + showDate
                        + ", Show Time: " + showTime + ", Synopsis: " + synopsis + ", Cover: " + cover + ", Banner: " + banner);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception (tampilkan pesan kesalahan atau lakukan penanganan yang sesuai)
        }
        
        //Table Chooser
        movieTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = movieTable.getSelectedRow();
                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) movieTable.getModel();
                        // Ambil data dari baris yang dipilih
                        int id = (int) model.getValueAt(selectedRow, 0);
                        String title = (String) model.getValueAt(selectedRow, 1);
                        String genre = (String) model.getValueAt(selectedRow, 2);
                        String director = (String) model.getValueAt(selectedRow, 3);
                        String duration = (String) model.getValueAt(selectedRow, 4);
                        String theater = (String) model.getValueAt(selectedRow, 5);
                        String showDate = (String) model.getValueAt(selectedRow, 6);
                        String showTime = (String) model.getValueAt(selectedRow, 7);
                        String synopsis = (String) model.getValueAt(selectedRow, 8);
                        String cover = (String) model.getValueAt(selectedRow, 9);
                        String banner = (String) model.getValueAt(selectedRow, 10);

                        // Update komponen input dengan data yang dipilih
                        AdminPanel.this.idMov = id;
                        inputTitle.setText(title);
                        inputGenre.setText(genre);
                        inputDirector.setText(director);
                        inputDuration.setText(duration);
                        inputTheather.setSelectedItem(theater);
                        dropDownTime.setSelectedItem(showTime);
                        inputDate.setText(showDate);
                        inputSynopsis.setText(synopsis);
                        inputCoverLink.setText(cover);
                        inputBannerLink.setText(banner);

                        // Tambahan: Mungkin Anda ingin menyimpan ID atau data lainnya untuk penggunaan lebih lanjut
                        // Jangan lupa untuk mengganti tipe data sesuai dengan kolom yang sesuai di tabel
                        // Misalnya: inputId.setText(String.valueOf(id));
                    }
                }
            }
        });
        
//        DefaultTableModel transactionModel = (DefaultTableModel) transaction.getModel();
//        transactionModel.setRowCount(0);
//
//        // Get data from the database
//        try (Connection conn = k.getConnection();
//             PreparedStatement ps = conn.prepareStatement("SELECT `InvoiceID`, `UserEmail`, `MovTitle`, `Theather`, `ShowTime`, `SeatIndex`, `Price`, `TransactionDate` FROM transaction");
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                int invoiceId = rs.getInt("InvoiceID");
//                String userEmail = rs.getString("UserEmail");
//                String movTitle = rs.getString("MovTitle");
//                String theater = rs.getString("Theather");
//                String showTime = rs.getString("ShowTime");
//                String seatIndex = rs.getString("SeatIndex");
//                int price = rs.getInt("Price");
//                String transactionDate = rs.getString("TransactionDate");
//
//                transactionModel.addRow(new Object[]{invoiceId, userEmail, movTitle, theater, showTime, seatIndex, price, transactionDate});
//
//                // Gunakan data sesuai kebutuhan Anda, misalnya, tampilkan di konsol
//                System.out.println("InvoiceID: " + invoiceId + ", UserEmail: " + userEmail + ", MovTitle: " + movTitle
//                        + ", Theather: " + theater + ", ShowTime: " + showTime + ", SeatIndex: " + seatIndex
//                        + ", Price: " + price + ", TransactionDate: " + transactionDate);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle exception (tampilkan pesan kesalahan atau lakukan penanganan yang sesuai)
//        }
        
    }
    
    //==================================================================================================
    
    private void performSearch() {
        String searchText = search.getText().toLowerCase();

        // Membuat RowFilter untuk mencocokkan dengan kolom UserEmail
        RowFilter<Object, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText, 1);

        // Menerapkan RowFilter ke TableRowSorter pada tabel
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(transactionModel);
        sorter.setRowFilter(rowFilter);
        transaction.setRowSorter(sorter);
    }

    private void displayTransactionData() {
        // Mendapatkan model tabel
        transactionModel = (DefaultTableModel) transaction.getModel();
        transactionModel.setRowCount(0);

        // Get data from the database
        try (Connection conn = k.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT `InvoiceID`, `UserEmail`, `MovTitle`, `Theather`, `ShowTime`, `SeatIndex`, `Price`, `TransactionDate` FROM transaction");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int invoiceId = rs.getInt("InvoiceID");
                String userEmail = rs.getString("UserEmail");
                String movTitle = rs.getString("MovTitle");
                String theater = rs.getString("Theather");
                String showTime = rs.getString("ShowTime");
                String seatIndex = rs.getString("SeatIndex");
                int price = rs.getInt("Price");
                String transactionDate = rs.getString("TransactionDate");

                transactionModel.addRow(new Object[]{invoiceId, userEmail, movTitle, theater, showTime, seatIndex, price, transactionDate});

                // Gunakan data sesuai kebutuhan Anda, misalnya, tampilkan di konsol
                System.out.println("InvoiceID: " + invoiceId + ", UserEmail: " + userEmail + ", MovTitle: " + movTitle
                        + ", Theather: " + theater + ", ShowTime: " + showTime + ", SeatIndex: " + seatIndex
                        + ", Price: " + price + ", TransactionDate: " + transactionDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception (tampilkan pesan kesalahan atau lakukan penanganan yang sesuai)
        }
    }

    // Method baru untuk menampilkan data transaksi dengan fitur pencarian
    private void displayTransactionDataWithSearch() {
        // Panggil metode untuk menampilkan data awal
        displayTransactionData();
    }
    
    //=============================================================================================
    
    //Insert Data
    private void insertMovieData() {
        // Tampilkan konfirmasi
        int confirmDialogResult = JOptionPane.showConfirmDialog(this, "Yakin ingin menambahkan data ini?", "Confirmation", JOptionPane.YES_NO_OPTION);

        // Jika user memilih "Yes"
        if (confirmDialogResult == JOptionPane.YES_OPTION) {
            try (Connection conn = k.getConnection()) {
                // Cek apakah Show Time yang sama sudah ada pada tanggal yang sama
                if (isDuplicateShowTime(conn, inputDate.getText(), dropDownTime.getSelectedItem().toString())) {
                    // Jika ada, tampilkan pesan kesalahan
                    JOptionPane.showMessageDialog(this, "Gagal menambahkan data. Show Time yang sama sudah ada pada tanggal tersebut.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Syntax SQL untuk operasi INSERT
                String sql = "INSERT INTO movie (Title, Genre, Director, Duration, Theater, `Show Date`, `Show Time`, Synopsis, Cover, Banner) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    // Set nilai parameter berdasarkan input yang telah dimasukkan sebelumnya
                    ps.setString(1, inputTitle.getText());
                    ps.setString(2, inputGenre.getText());
                    ps.setString(3, inputDirector.getText());
                    ps.setString(4, inputDuration.getText());
                    ps.setString(5, (String) inputTheather.getSelectedItem());
                    ps.setString(6, inputDate.getText());
                    ps.setString(7, dropDownTime.getSelectedItem().toString());
                    ps.setString(8, inputSynopsis.getText());
                    ps.setString(9, inputCoverLink.getText());
                    ps.setString(10, inputBannerLink.getText());

                    // Lakukan operasi INSERT
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        // Insert berhasil
                        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Dispose frame saat ini
                        this.dispose();

                        // Update panel dengan membuat instance baru dan menampilkannya
                        AdminPanel refreshPanel = new AdminPanel();
                        refreshPanel.setVisible(true);
                        refreshPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    } else {
                        // Insert gagal
                        JOptionPane.showMessageDialog(this, "Gagal menambahkan data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception (tampilkan pesan kesalahan atau lakukan penanganan yang sesuai)
            }
        }
    }

    // Metode untuk mengecek apakah ada Show Time yang sama pada Show Date yang sama
    private boolean isDuplicateShowTime(Connection conn, String showDate, String showTime) throws SQLException {
        String sql = "SELECT COUNT(*) FROM movie WHERE `Show Date`=? AND `Show Time`=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, showDate);
            ps.setString(2, showTime);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Ambil jumlah data yang sesuai kriteria
                    int count = rs.getInt(1);
                    return count > 0; // Return true jika ada data yang sama, false jika tidak ada
                }
            }
        }
        return false; // Return false jika ada kesalahan saat menjalankan query
    }
    
    
    

    //Update Data
    private void updateMovieData() {
        // Tampilkan konfirmasi
        int confirmDialogResult = JOptionPane.showConfirmDialog(this, "Yakin ingin memperbarui data ini?", "Confirmation", JOptionPane.YES_NO_OPTION);

        // Jika user memilih "Yes"
        if (confirmDialogResult == JOptionPane.YES_OPTION) {
            try (Connection conn = k.getConnection()) {
                // Cek apakah Show Time yang sama sudah ada pada tanggal yang sama, kecuali untuk data yang sedang diupdate
                if (isDuplicateShowTimeForUpdate(conn, inputDate.getText(), dropDownTime.getSelectedItem().toString(), idMov)) {
                    // Jika ada, tampilkan pesan kesalahan
                    JOptionPane.showMessageDialog(this, "Gagal memperbarui data. Show Time yang sama sudah ada pada tanggal tersebut.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Syntax SQL untuk operasi UPDATE
                String sql = "UPDATE movie SET Title=?, Genre=?, Director=?, Duration=?, Theater=?, `Show Date`=?, `Show Time`=?, Synopsis=?, Cover=?, Banner=? WHERE MovieId=?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    // Set nilai parameter berdasarkan input yang telah dimasukkan sebelumnya
                    ps.setString(1, inputTitle.getText());
                    ps.setString(2, inputGenre.getText());
                    ps.setString(3, inputDirector.getText());
                    ps.setString(4, inputDuration.getText());
                    ps.setString(5, (String) inputTheather.getSelectedItem());
                    ps.setString(6, inputDate.getText());
                    ps.setString(7, dropDownTime.getSelectedItem().toString());
                    ps.setString(8, inputSynopsis.getText());
                    ps.setString(9, inputCoverLink.getText());
                    ps.setString(10, inputBannerLink.getText());

                    // ID yang akan dijadikan kriteria untuk pembaruan data
                    ps.setInt(11, idMov);

                    // Lakukan operasi UPDATE
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        // Update berhasil
                        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Dispose frame saat ini
                        this.dispose();

                        // Update panel dengan membuat instance baru dan menampilkannya
                        AdminPanel refreshPanel = new AdminPanel();
                        refreshPanel.setVisible(true);
                        refreshPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    } else {
                        // Update gagal
                        JOptionPane.showMessageDialog(this, "Gagal memperbarui data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception (tampilkan pesan kesalahan atau lakukan penanganan yang sesuai)
            }
        }
    }

    // Metode untuk mengecek apakah ada Show Time yang sama pada Show Date yang sama, kecuali untuk data yang sedang diupdate
    private boolean isDuplicateShowTimeForUpdate(Connection conn, String showDate, String showTime, int currentId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM movie WHERE `Show Date`=? AND `Show Time`=? AND MovieId<>?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, showDate);
            ps.setString(2, showTime);
            ps.setInt(3, currentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Ambil jumlah data yang sesuai kriteria
                    int count = rs.getInt(1);
                    return count > 0; // Return true jika ada data yang sama, false jika tidak ada
                }
            }
        }
        return false; // Return false jika ada kesalahan saat menjalankan query
    }

    
    
    
    //Delete Data
    private void deleteMovieData() {
        // Tampilkan konfirmasi
        int confirmDialogResult = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Confirmation", JOptionPane.YES_NO_OPTION);

        // Jika user memilih "Yes"
        if (confirmDialogResult == JOptionPane.YES_OPTION) {
            try (Connection conn = k.getConnection()) {
                // Syntax SQL untuk operasi DELETE
                String sql = "DELETE FROM movie WHERE MovieId=?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    // ID yang akan dijadikan kriteria untuk penghapusan data
                    ps.setInt(1, idMov);

                    // Lakukan operasi DELETE
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        // Delete berhasil
                        JOptionPane.showMessageDialog(this, "Data berhasil dihapus.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Dispose frame saat ini
                        this.dispose();

                        // Update panel dengan membuat instance baru dan menampilkannya
                        AdminPanel refreshPanel = new AdminPanel();
                        refreshPanel.setVisible(true);
                        refreshPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    } else {
                        // Delete gagal
                        JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception (tampilkan pesan kesalahan atau lakukan penanganan yang sesuai)
            }
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

        jPanel1 = new javax.swing.JPanel();
        HeaderTitle = new javax.swing.JPanel();
        printTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();
        inputTitle = new javax.swing.JTextField();
        inputGenre = new javax.swing.JTextField();
        inputDirector = new javax.swing.JTextField();
        inputDuration = new javax.swing.JTextField();
        inputBannerLink = new javax.swing.JTextField();
        inputCoverLink = new javax.swing.JTextField();
        inputDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        inputTheather = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputSynopsis = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dropDownTime = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        transaction = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(53, 53, 53));

        HeaderTitle.setBackground(new java.awt.Color(33, 33, 33));
        HeaderTitle.setPreferredSize(new java.awt.Dimension(935, 94));

        printTitle.setBackground(new java.awt.Color(153, 153, 153));
        printTitle.setFont(new java.awt.Font("Castellar", 1, 46)); // NOI18N
        printTitle.setForeground(new java.awt.Color(204, 204, 204));
        printTitle.setText("Admin Panel");

        javax.swing.GroupLayout HeaderTitleLayout = new javax.swing.GroupLayout(HeaderTitle);
        HeaderTitle.setLayout(HeaderTitleLayout);
        HeaderTitleLayout.setHorizontalGroup(
            HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderTitleLayout.createSequentialGroup()
                .addContainerGap(770, Short.MAX_VALUE)
                .addComponent(printTitle)
                .addContainerGap(771, Short.MAX_VALUE))
        );
        HeaderTitleLayout.setVerticalGroup(
            HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderTitleLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(printTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        movieTable.setFont(new java.awt.Font("Cormorant Infant", 0, 18)); // NOI18N
        movieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Movie Title", "Genre", "Director", "Duration", "Theather", "Show Date", "Show Time", "Synopsis", "Cover", "Banner"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(movieTable);
        if (movieTable.getColumnModel().getColumnCount() > 0) {
            movieTable.getColumnModel().getColumn(0).setMinWidth(25);
            movieTable.getColumnModel().getColumn(0).setMaxWidth(25);
            movieTable.getColumnModel().getColumn(1).setMinWidth(170);
            movieTable.getColumnModel().getColumn(1).setMaxWidth(170);
            movieTable.getColumnModel().getColumn(2).setMinWidth(160);
            movieTable.getColumnModel().getColumn(2).setMaxWidth(160);
            movieTable.getColumnModel().getColumn(4).setMinWidth(80);
            movieTable.getColumnModel().getColumn(4).setMaxWidth(80);
            movieTable.getColumnModel().getColumn(5).setMaxWidth(180);
            movieTable.getColumnModel().getColumn(6).setMinWidth(90);
            movieTable.getColumnModel().getColumn(6).setMaxWidth(90);
            movieTable.getColumnModel().getColumn(7).setMinWidth(50);
            movieTable.getColumnModel().getColumn(7).setMaxWidth(50);
            movieTable.getColumnModel().getColumn(8).setMinWidth(170);
            movieTable.getColumnModel().getColumn(8).setMaxWidth(170);
            movieTable.getColumnModel().getColumn(9).setPreferredWidth(3);
            movieTable.getColumnModel().getColumn(10).setPreferredWidth(3);
        }

        inputTitle.setBackground(new java.awt.Color(53, 53, 53));
        inputTitle.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        inputTitle.setForeground(new java.awt.Color(204, 204, 204));
        inputTitle.setText("Movie Title");

        inputGenre.setBackground(new java.awt.Color(53, 53, 53));
        inputGenre.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        inputGenre.setForeground(new java.awt.Color(204, 204, 204));
        inputGenre.setText("Genre");

        inputDirector.setBackground(new java.awt.Color(53, 53, 53));
        inputDirector.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        inputDirector.setForeground(new java.awt.Color(204, 204, 204));
        inputDirector.setText("Director");
        inputDirector.setPreferredSize(new java.awt.Dimension(104, 36));

        inputDuration.setBackground(new java.awt.Color(53, 53, 53));
        inputDuration.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        inputDuration.setForeground(new java.awt.Color(204, 204, 204));
        inputDuration.setText("Duration");

        inputBannerLink.setBackground(new java.awt.Color(53, 53, 53));
        inputBannerLink.setFont(new java.awt.Font("Cormorant Infant", 1, 10)); // NOI18N
        inputBannerLink.setForeground(new java.awt.Color(204, 204, 204));
        inputBannerLink.setText("CDN");

        inputCoverLink.setBackground(new java.awt.Color(53, 53, 53));
        inputCoverLink.setFont(new java.awt.Font("Cormorant Infant", 1, 10)); // NOI18N
        inputCoverLink.setForeground(new java.awt.Color(204, 204, 204));
        inputCoverLink.setText("CDN");

        inputDate.setBackground(new java.awt.Color(53, 53, 53));
        inputDate.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        inputDate.setForeground(new java.awt.Color(204, 204, 204));
        inputDate.setText("YYYY-MM-DD");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Add Movie");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 37));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Update Movie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Delete Movie");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        inputTheather.setBackground(new java.awt.Color(53, 53, 53));
        inputTheather.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        inputTheather.setForeground(new java.awt.Color(204, 204, 204));
        inputTheather.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "StudioA", "StudioB" }));

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Movie Table");

        inputSynopsis.setBackground(new java.awt.Color(53, 53, 53));
        inputSynopsis.setColumns(20);
        inputSynopsis.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        inputSynopsis.setForeground(new java.awt.Color(204, 204, 204));
        inputSynopsis.setLineWrap(true);
        inputSynopsis.setRows(5);
        inputSynopsis.setText("Synopsis");
        inputSynopsis.setWrapStyleWord(true);
        inputSynopsis.setBorder(null);
        jScrollPane2.setViewportView(inputSynopsis);

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Banner Link");

        jLabel3.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Cover Link");

        dropDownTime.setBackground(new java.awt.Color(53, 53, 53));
        dropDownTime.setFont(new java.awt.Font("Cormorant Infant", 1, 24)); // NOI18N
        dropDownTime.setForeground(new java.awt.Color(204, 204, 204));
        dropDownTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09.00", "12.00", "18.00" }));

        transaction.setFont(new java.awt.Font("Cormorant Infant", 0, 18)); // NOI18N
        transaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Email", "Movie Titles", "Theather", "Time", "Seat Index", "Total Price", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(transaction);
        if (transaction.getColumnModel().getColumnCount() > 0) {
            transaction.getColumnModel().getColumn(0).setMinWidth(25);
            transaction.getColumnModel().getColumn(0).setMaxWidth(25);
            transaction.getColumnModel().getColumn(1).setMinWidth(160);
            transaction.getColumnModel().getColumn(1).setMaxWidth(160);
            transaction.getColumnModel().getColumn(2).setMinWidth(170);
            transaction.getColumnModel().getColumn(2).setMaxWidth(170);
            transaction.getColumnModel().getColumn(3).setMaxWidth(180);
            transaction.getColumnModel().getColumn(4).setMinWidth(50);
            transaction.getColumnModel().getColumn(4).setMaxWidth(50);
            transaction.getColumnModel().getColumn(6).setMinWidth(80);
            transaction.getColumnModel().getColumn(6).setMaxWidth(80);
            transaction.getColumnModel().getColumn(7).setMinWidth(90);
            transaction.getColumnModel().getColumn(7).setMaxWidth(90);
        }

        jLabel4.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Search Ticket");

        searchButton.setBackground(new java.awt.Color(51, 51, 51));
        searchButton.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(204, 204, 204));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(51, 51, 51));
        refresh.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(204, 204, 204));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                            .addComponent(inputTitle))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(inputGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dropDownTime, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(inputTheather, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputBannerLink, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputCoverLink, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(HeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inputDirector, inputDuration, inputGenre});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(HeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTheather, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropDownTime, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputBannerLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputCoverLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(searchButton)
                    .addComponent(refresh)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(33, 33, 33))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inputDirector, inputDuration, inputGenre, inputTitle});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteMovieData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        updateMovieData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        insertMovieData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        //performSearch();
        performSearch();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        // Dispose frame saat ini
        this.dispose();
        // Update panel dengan membuat instance baru dan menampilkannya
        AdminPanel refreshPanel = new AdminPanel();
        refreshPanel.setVisible(true);
        refreshPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_refreshActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdminPanel panel = new AdminPanel();
                panel.setVisible(true);
                panel.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderTitle;
    private javax.swing.JComboBox<String> dropDownTime;
    private javax.swing.JTextField inputBannerLink;
    private javax.swing.JTextField inputCoverLink;
    private javax.swing.JTextField inputDate;
    private javax.swing.JTextField inputDirector;
    private javax.swing.JTextField inputDuration;
    private javax.swing.JTextField inputGenre;
    private javax.swing.JTextArea inputSynopsis;
    private javax.swing.JComboBox<String> inputTheather;
    private javax.swing.JTextField inputTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable movieTable;
    private javax.swing.JLabel printTitle;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField search;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable transaction;
    // End of variables declaration//GEN-END:variables
}
