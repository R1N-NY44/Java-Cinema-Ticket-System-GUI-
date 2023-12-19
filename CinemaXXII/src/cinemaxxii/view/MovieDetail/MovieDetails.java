/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cinemaxxii.view.MovieDetail;

import cinemaxxii.Database;
import cinemaxxii.Movie;
import cinemaxxii.Studio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import cinemaxxii.display.DisplayFrame;
import cinemaxxii.theater.StudioA;
import cinemaxxii.theater.StudioB;
import cinemaxxii.view.Home.HomeDisplay;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.sql.ResultSet;

/**
 *
 * @author Yoga
 */
public class MovieDetails extends javax.swing.JPanel {

    private final DisplayFrame displayFrame;
    private final Database k = new Database();
    private int movieId;
    
    /**
     * Creates new form MovieDetails
     */
    // String timeDefault = "06.00";
    public MovieDetails(DisplayFrame displayFrame, int getId) {
        initComponents();
        this.displayFrame = displayFrame;
        this.movieId = getId;
        
        displayMovies(getId, "06.00");
        Time1.setForeground(new java.awt.Color(200, 152, 84));
    }
    
    //Change The Mini Theater (Seat and etc)
    public class MiniTheater {
        private javax.swing.JPanel panel;

        public MiniTheater(javax.swing.JPanel panel) {
            this.panel = panel;
        }
    }
    
    
    public Movie displayMovies(int movieId, String timeDefault) {
        try (Connection conn = k.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM movie WHERE `MovieId` = ?;")) {
    
            ps.setInt(1, movieId);
    
            try (ResultSet rs = ps.executeQuery()) {
                ArrayList<Movie> movies = new ArrayList<>();
    
                while (rs.next()) {
                    int id = rs.getInt("MovieId");
                    String title = rs.getString("Title");
                    String cover = rs.getString("Cover");
                    String banner = rs.getString("Banner");
                    String synopsis = rs.getString("Synopsis");
                    String genre = rs.getString("Genre");
                    String director = rs.getString("Director");
                    String duration = rs.getString("Duration");
                    String showDate = rs.getString("Show Date");
                    String theater = rs.getString("Theater");
    
                    Movie movie = new Movie(id, title, cover, banner, synopsis, genre, director, duration, showDate, theater);
                    movies.add(movie);
                }
    
                if (!movies.isEmpty()) {
                    Movie movie = movies.get(0);
    
                    IMG_Banner.setIcon(new javax.swing.ImageIcon(new java.net.URL(movie.getBanner())));
                    MovieTitle.setText(movie.getTitle() + "  ");
                    Synopsis.setText(movie.getSynopsis());
                    Director.setText(": " + movie.getDirector());
                    Genre.setText(": " + movie.getGenre());
                    Duration.setText(": " + movie.getDuration());
                    System.out.println(movie.getMovieId());
    
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
    
                    try {
                        Date date = inputFormat.parse(movie.getShowDate());
                        String formattedDate = outputFormat.format(date);
                        Date.setText(formattedDate);  // Output: 17 Desember 2023
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
    
                    if (movie.getTheater().equals("StudioA")) {
                        StudioPanel.removeAll();
                        StudioA Studio = new StudioA(movie.getMovieId(), movie.getTitle(), timeDefault, movie.getShowDate());
                        StudioPanel.add(Studio);
                        StudioPanel.revalidate();
                        StudioPanel.repaint();
                    } else if (movie.getTheater().equals("StudioB")) {
                        StudioPanel.removeAll();
                        StudioB Studio = new StudioB();
                        StudioPanel.add(Studio);
                        StudioPanel.revalidate();
                        StudioPanel.repaint();
                    } else {
                        // Default jika tidak cocok dengan StudioA atau StudioB
                    }
    
                    //untuk melempar nilai theater keluar dari class
                    return movie;
                }
            }
    
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    
        return null; // Return null jika tidak ada data atau terjadi kesalahan
    }
    
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        HeaderTitle = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        IMG_Banner = new javax.swing.JLabel();
        MovieTitle = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Description = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        Synopsis = new javax.swing.JTextArea();
        TicketPanel = new javax.swing.JPanel();
        TimePanel = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        StudioPanel = new javax.swing.JPanel();
        Time1 = new javax.swing.JButton();
        Time2 = new javax.swing.JButton();
        Time3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Duration = new javax.swing.JLabel();
        Genre = new javax.swing.JLabel();
        Director = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));
        setMinimumSize(new java.awt.Dimension(0, 3));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Header.setBackground(new java.awt.Color(33, 33, 33));

        backButton.setBackground(new java.awt.Color(107, 92, 71));
        backButton.setFont(new java.awt.Font("Castellar", 0, 36)); // NOI18N
        backButton.setForeground(new java.awt.Color(204, 204, 204));
        backButton.setText("Back");
        backButton.setActionCommand("[️Back");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator1.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 92, 71), 2));

        jLabel2.setFont(new java.awt.Font("Castellar", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cinema X.X.X");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 580, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(767, 767, 767))
            .addComponent(jSeparator1)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        HeaderTitle.setBackground(new java.awt.Color(33, 33, 33));

        jSeparator2.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator2.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 92, 71), 2));
        jSeparator2.setPreferredSize(new java.awt.Dimension(3, 3));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Castellar", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Movie Details");

        javax.swing.GroupLayout HeaderTitleLayout = new javax.swing.GroupLayout(HeaderTitle);
        HeaderTitle.setLayout(HeaderTitleLayout);
        HeaderTitleLayout.setHorizontalGroup(
            HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderTitleLayout.setVerticalGroup(
            HeaderTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        IMG_Banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Suzume no Tojimari_Large.jpg"))); // NOI18N

        MovieTitle.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 60)); // NOI18N
        MovieTitle.setForeground(new java.awt.Color(255, 255, 255));
        MovieTitle.setText("Movie Title");
        MovieTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jSeparator3.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator3.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 147, 106), 10));
        jSeparator3.setMinimumSize(new java.awt.Dimension(50, 0));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 3));

        Description.setBackground(new java.awt.Color(43, 43, 43));

        jSeparator4.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator4.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 147, 106), 3));
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 3));

        Synopsis.setEditable(false);
        Synopsis.setBackground(new java.awt.Color(43, 43, 43));
        Synopsis.setColumns(20);
        Synopsis.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 22)); // NOI18N
        Synopsis.setForeground(new java.awt.Color(255, 255, 255));
        Synopsis.setLineWrap(true);
        Synopsis.setRows(5);
        Synopsis.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vitae proin sagittis nisl rhoncus mattis rhoncus urna neque viverra. Ipsum suspendisse ultrices gravida dictum fusce ut placerat orci nulla. Porttitor rhoncus dolor purus non enim praesent elementum facilisis. Porttitor leo a diam sollicitudin tempor id eu. Aliquam etiam erat velit scelerisque in dictum non. Amet dictum sit amet justo donec enim diam vulputate. Proin fermentum leo vel orci porta non pulvinar. Faucibus purus in massa tempor nec feugiat nisl pretium fusce. Fusce ut placerat orci nulla pellentesque. Ac tortor dignissim convallis aenean et tortor. Consequat id porta nibh venenatis cras sed.\n\nFacilisis magna etiam tempor orci eu lobortis elementum nibh. Fusce id velit ut tortor pretium viverra. Faucibus purus in massa tempor nec feugiat nisl pretium. Malesuada bibendum arcu vitae elementum curabitur. Amet volutpat consequat mauris nunc congue nisi. Feugiat vivamus at augue eget arcu dictum varius. ");
        Synopsis.setWrapStyleWord(true);
        Synopsis.setBorder(null);

        javax.swing.GroupLayout DescriptionLayout = new javax.swing.GroupLayout(Description);
        Description.setLayout(DescriptionLayout);
        DescriptionLayout.setHorizontalGroup(
            DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DescriptionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Synopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DescriptionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        DescriptionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Synopsis, jSeparator4});

        DescriptionLayout.setVerticalGroup(
            DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
            .addGroup(DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DescriptionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Synopsis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
            .addGroup(DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DescriptionLayout.createSequentialGroup()
                    .addContainerGap(413, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        TicketPanel.setBackground(new java.awt.Color(40, 40, 40));
        TicketPanel.setPreferredSize(new java.awt.Dimension(424, 800));

        TimePanel.setBackground(new java.awt.Color(33, 33, 33));

        jSeparator5.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator5.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 92, 71), 2));
        jSeparator5.setPreferredSize(new java.awt.Dimension(3, 3));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Castellar", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Show Time");

        jSeparator6.setBackground(new java.awt.Color(107, 92, 71));
        jSeparator6.setForeground(new java.awt.Color(107, 92, 71));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 92, 71), 2));
        jSeparator6.setPreferredSize(new java.awt.Dimension(3, 3));

        javax.swing.GroupLayout TimePanelLayout = new javax.swing.GroupLayout(TimePanel);
        TimePanel.setLayout(TimePanelLayout);
        TimePanelLayout.setHorizontalGroup(
            TimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TimePanelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(TimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TimePanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        TimePanelLayout.setVerticalGroup(
            TimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(TimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TimePanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE)))
        );

        StudioPanel.setLayout(new java.awt.BorderLayout());

        Time1.setBackground(new java.awt.Color(40, 40, 40));
        Time1.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Time1.setForeground(new java.awt.Color(204, 204, 204));
        Time1.setText("06.00");
        Time1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Time1ActionPerformed(evt);
            }
        });

        Time2.setBackground(new java.awt.Color(40, 40, 40));
        Time2.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Time2.setForeground(new java.awt.Color(204, 204, 204));
        Time2.setText("18.00");
        Time2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Time2ActionPerformed(evt);
            }
        });

        Time3.setBackground(new java.awt.Color(40, 40, 40));
        Time3.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 24)); // NOI18N
        Time3.setForeground(new java.awt.Color(204, 204, 204));
        Time3.setText("09.00");
        Time3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Time3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TicketPanelLayout = new javax.swing.GroupLayout(TicketPanel);
        TicketPanel.setLayout(TicketPanelLayout);
        TicketPanelLayout.setHorizontalGroup(
            TicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicketPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(TicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(StudioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
            .addGroup(TicketPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(Time1)
                .addGap(35, 35, 35)
                .addComponent(Time3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Time2)
                .addGap(84, 84, 84))
        );

        TicketPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {StudioPanel, TimePanel});

        TicketPanelLayout.setVerticalGroup(
            TicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(TimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Time1)
                    .addComponent(Time2)
                    .addComponent(Time3))
                .addGap(58, 58, 58)
                .addComponent(StudioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel3.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Details  ");

        Date.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 32)); // NOI18N
        Date.setForeground(new java.awt.Color(204, 204, 204));
        Date.setText("12 January");

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 147, 106), 2));
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 3));

        jLabel5.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Director");

        jLabel6.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Genre");

        jLabel7.setFont(new java.awt.Font("Cormorant Infant Medium", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Duration");

        Duration.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 22)); // NOI18N
        Duration.setForeground(new java.awt.Color(255, 255, 255));
        Duration.setText(": 12 Years 10 minute");

        Genre.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 22)); // NOI18N
        Genre.setForeground(new java.awt.Color(255, 255, 255));
        Genre.setText(": Helikopter");

        Director.setFont(new java.awt.Font("Cormorant Infant Medium", 0, 22)); // NOI18N
        Director.setForeground(new java.awt.Color(255, 255, 255));
        Director.setText(": Andrew Muschle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Date)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Director)
                            .addComponent(Genre)
                            .addComponent(Duration)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IMG_Banner, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MovieTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(TicketPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {MovieTitle, jSeparator3});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jSeparator7});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Date)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IMG_Banner, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(Director))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(Genre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(Duration)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MovieTitle)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TicketPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(159, 159, 159))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        JPanel homePanel = new HomeDisplay(displayFrame);  // Gantilah dengan panel yang baru
        displayFrame.changeDisplayPanel(homePanel);
    }//GEN-LAST:event_backButtonActionPerformed


    private void Time1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Time1ActionPerformed
        // TODO add your handling code here:
        Time1.setForeground(new java.awt.Color(200, 152, 84));
        Time2.setForeground(new java.awt.Color(204, 204, 204));
        String setTime = "06.00";

        // Memanggil metode displayMovies untuk mendapatkan nilai movie
        Movie movie = displayMovies(movieId, setTime);
        System.out.println("======[Adjust]======");
        System.out.println("Studio Name : " + movie.getTheater() + ", Set Time : " + setTime);
        System.out.println("======[Adjust]======");

        // Mengecek apakah nilai movie tidak null
        if (movie != null) {
            // Membuat objek Studio sesuai dengan nilai theater
            Studio studio;
            if (movie.getTheater().equals("StudioA")) {
                StudioPanel.removeAll();
                StudioA Studio = new StudioA(movie.getMovieId(), movie.getTitle(), setTime, movie.getShowDate());
                StudioPanel.add(Studio);
                StudioPanel.revalidate();
                StudioPanel.repaint();
            } else if (movie.getTheater().equals("StudioB")) {
                studio = new StudioB();  // Gantilah timeDefault dengan nilai yang sesuai
            } else {
                // Jika tidak cocok dengan StudioA atau StudioB, Anda bisa memberikan nilai default atau menangani dengan cara lain
                // studio = new StudioDefault();
            }

            // Menambahkan objek Studio ke StudioPanel

        } else {
            System.out.println("Tidak dapat menampilkan data film.");
        }
    }//GEN-LAST:event_Time1ActionPerformed

    private void Time2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Time2ActionPerformed
        // TODO add your handling code here:
        Time1.setForeground(new java.awt.Color(204,204,204));
        Time2.setForeground(new java.awt.Color(200, 152, 84));
        String setTime = "18.00";

        // Memanggil metode displayMovies untuk mendapatkan nilai movie
        Movie movie = displayMovies(movieId, setTime);
        System.out.println("======[Adjust]======");
        System.out.println("Studio Name : " + movie.getTheater() + ", Set Time : " + setTime);
        System.out.println("======[Adjust]======");

        // Mengecek apakah nilai movie tidak null
        if (movie != null) {
            // Membuat objek Studio sesuai dengan nilai theater
            Studio studio;
            if (movie.getTheater().equals("StudioA")) {
                StudioPanel.removeAll();
                StudioA Studio = new StudioA(movie.getMovieId(), movie.getTitle(), setTime, movie.getShowDate());
                StudioPanel.add(Studio);
                StudioPanel.revalidate();
                StudioPanel.repaint();
            } else if (movie.getTheater().equals("StudioB")) {
                studio = new StudioB();  // Gantilah timeDefault dengan nilai yang sesuai
            } else {
                // Jika tidak cocok dengan StudioA atau StudioB, Anda bisa memberikan nilai default atau menangani dengan cara lain
                // studio = new StudioDefault();
            }

            // Menambahkan objek Studio ke StudioPanel

        } else {
            System.out.println("Tidak dapat menampilkan data film.");
        }
    }//GEN-LAST:event_Time2ActionPerformed

    private void Time3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Time3ActionPerformed
        // TODO add your handling code here:
        Time1.setForeground(new java.awt.Color(200, 152, 84));
        Time2.setForeground(new java.awt.Color(204, 204, 204));
        String setTime = "09.00";

        // Memanggil metode displayMovies untuk mendapatkan nilai movie
        Movie movie = displayMovies(movieId, setTime);
        System.out.println("======[Adjust]======");
        System.out.println("Studio Name : " + movie.getTheater() + ", Set Time : " + setTime);
        System.out.println("======[Adjust]======");

        // Mengecek apakah nilai movie tidak null
        if (movie != null) {
            // Membuat objek Studio sesuai dengan nilai theater
            Studio studio;
            if (movie.getTheater().equals("StudioA")) {
                StudioPanel.removeAll();
                StudioA Studio = new StudioA(movie.getMovieId(), movie.getTitle(), setTime, movie.getShowDate());
                StudioPanel.add(Studio);
                StudioPanel.revalidate();
                StudioPanel.repaint();
            } else if (movie.getTheater().equals("StudioB")) {
                studio = new StudioB();  // Gantilah timeDefault dengan nilai yang sesuai
            } else {
                // Jika tidak cocok dengan StudioA atau StudioB, Anda bisa memberikan nilai default atau menangani dengan cara lain
                // studio = new StudioDefault();
            }

            // Menambahkan objek Studio ke StudioPanel

        } else {
            System.out.println("Tidak dapat menampilkan data film.");
        }
    }//GEN-LAST:event_Time3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JPanel Description;
    private javax.swing.JLabel Director;
    private javax.swing.JLabel Duration;
    private javax.swing.JLabel Genre;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel HeaderTitle;
    private javax.swing.JLabel IMG_Banner;
    private javax.swing.JLabel MovieTitle;
    private javax.swing.JPanel StudioPanel;
    private javax.swing.JTextArea Synopsis;
    private javax.swing.JPanel TicketPanel;
    private javax.swing.JButton Time1;
    private javax.swing.JButton Time2;
    private javax.swing.JButton Time3;
    private javax.swing.JPanel TimePanel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
