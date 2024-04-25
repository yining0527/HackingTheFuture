/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.StyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


/**
 *
 * @author Asus
 */
public class Words extends javax.swing.JFrame {
//    private String[]words;
    private StringBuilder currentText;
    private int currentIndex;
    private Timer timer;
    private int elapsedTimeInSeconds;
    private List<String> words;
    private javax.swing.text.Caret caret;
    private int totalTypedChars;
    private int totalCorrectChars;
    private int totalMistakes;
    private double wpm;
    private double accuracy;
    private String ColumnSql;
    private String AccColumnSql;
    private String testType;
    private String username;
    private javax.swing.JLabel jLabelAccuracy;
    private javax.swing.JLabel jLabelWPM;
    private List <Integer> wpmData = new ArrayList<>();
    private List <Integer> accData = new ArrayList<>();
    
    Connection con = null;
    PreparedStatement pst = null; 

    
    /**
     * Creates new form Words
     */
    public Words() {
        initComponents();
        initialiseGame();
        setPreferredSize(new Dimension(850,550));
        setResizable(true);

    
        
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
        jLabel1 = new javax.swing.JLabel();
        TenWords = new javax.swing.JButton();
        fiftyWords = new javax.swing.JButton();
        oneHundredWords = new javax.swing.JButton();
        twentyFiveWords = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabelTimer = new javax.swing.JLabel();
        MENU = new javax.swing.JButton();
        GAMEMODE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GAME MODE : WORDS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 40, 590, 50);

        TenWords.setFont(new java.awt.Font("Segoe Print", 1, 11)); // NOI18N
        TenWords.setForeground(new java.awt.Color(0, 102, 102));
        TenWords.setText("10 words");
        TenWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenWordsActionPerformed(evt);
            }
        });
        jPanel1.add(TenWords);
        TenWords.setBounds(50, 120, 87, 26);

        fiftyWords.setFont(new java.awt.Font("Segoe Print", 1, 11)); // NOI18N
        fiftyWords.setForeground(new java.awt.Color(0, 102, 102));
        fiftyWords.setText("50 words");
        fiftyWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyWordsActionPerformed(evt);
            }
        });
        jPanel1.add(fiftyWords);
        fiftyWords.setBounds(250, 120, 90, 26);

        oneHundredWords.setFont(new java.awt.Font("Segoe Print", 1, 11)); // NOI18N
        oneHundredWords.setForeground(new java.awt.Color(0, 102, 102));
        oneHundredWords.setText("100 words");
        oneHundredWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneHundredWordsActionPerformed(evt);
            }
        });
        jPanel1.add(oneHundredWords);
        oneHundredWords.setBounds(350, 120, 100, 26);

        twentyFiveWords.setFont(new java.awt.Font("Segoe Print", 1, 11)); // NOI18N
        twentyFiveWords.setForeground(new java.awt.Color(0, 102, 102));
        twentyFiveWords.setText("25 words");
        twentyFiveWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twentyFiveWordsActionPerformed(evt);
            }
        });
        jPanel1.add(twentyFiveWords);
        twentyFiveWords.setBounds(150, 120, 90, 26);

        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jTextPane2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(40, 160, 730, 330);

        jLabelTimer.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTimer.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelTimer);
        jLabelTimer.setBounds(560, 120, 270, 20);

        MENU.setText("Menu");
        MENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENUActionPerformed(evt);
            }
        });
        jPanel1.add(MENU);
        MENU.setBounds(670, 40, 100, 22);

        GAMEMODE.setText("Game Mode");
        GAMEMODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GAMEMODEActionPerformed(evt);
            }
        });
        jPanel1.add(GAMEMODE);
        GAMEMODE.setBounds(670, 70, 100, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 840, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void startTimer(){
        elapsedTimeInSeconds = 0;
        timer.start();
    }
    private void stopTimer(){
        timer.stop();
    }
    
    public double getACC(){
        return accuracy;
    }
    
    public double getWPM(){
        return wpm;  
    }
    
    public int getTime(){
        return elapsedTimeInSeconds;    
    }
    
    public int getCorrectChars(){
        return totalCorrectChars;
    }
    
    public int getTotalChars(){
        return totalTypedChars;
    }
    
    public int getMistakeChars(){
        return totalMistakes;
    }
    
    public String getTestType(){
        return testType;
    }
    
    public List<Integer> getEverySecondWPM(){
        return wpmData;
    }
    
     public List<Integer> getEverySecondACC(){
        return accData;
    }
     
    private void collectResult() {
        double accuracy = getACC();
        double wpm = getWPM();
        int timeElapsed = getTime();
        int correctChars = getCorrectChars();
        int totalChars = getTotalChars();
        int mistakeChars = getMistakeChars();
        String testType = getTestType();
        List<Integer> everySecondWPM = getEverySecondWPM();
        List<Integer> everySecondACC = getEverySecondACC();
        
        displayResultsInResultFrame(accuracy, wpm, timeElapsed, correctChars, totalChars, 
                mistakeChars, testType, everySecondWPM, everySecondACC);
        updateScoreSql();
        last10rounds();
        
    }
    
    
    private void displayResultsInResultFrame(double accuracy, double wpm, int timeElapsed, 
            int correctChars, int totalChars, int mistakeChars, String testType, List<Integer> everySecondWPM,List<Integer> everySecondACC) {
        // Create a Result frame instance
        String transferUsername = username;
        Result resultFrame = new Result();
        

        // Pass the gathered data to the Result frame for display
        resultFrame.displayResults(accuracy, wpm, timeElapsed, correctChars, totalChars, mistakeChars, testType, 
                everySecondWPM,everySecondACC);
        resultFrame.setUsername(transferUsername);
        resultFrame.callChartPanel();
        // Show the Result frame
        resultFrame.setVisible(true);
        resultFrame.pack();
        resultFrame.setLocationRelativeTo(null);

        // Close the Words frame or do other necessary operations
        this.dispose(); // Close the Words frame
    }
     
    public void setUsername(String transferUsername){
        username = transferUsername;
    }
    
    private void last10rounds(){
        
        System.out.println(username);
        int totalRounds = 0;
        int totalwpm = 0;
        int totalacc = 0;
        int columnRounds;
        int columnwpm;
        String last10wpm = null;
        String last10acc;
        int wpmint = (int) wpm;
        int accuracyint = (int) accuracy;
        
         try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration", "root", "");

                // Retrieve initial data
                String query = "SELECT totalround, totalwpm, totalacc FROM playerprofile WHERE username = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, username); // Replace "desired_username" with the actual username

                ResultSet resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    totalRounds = resultSet.getInt("totalround");
                    totalwpm = resultSet.getInt("totalwpm");
                    totalacc = resultSet.getInt("totalacc");
                }
                System.out.println(totalRounds);
                // Close the previous ResultSet and PreparedStatement
                resultSet.close();
                pst.close();

                // Update calculations
                totalRounds += 1;
                totalwpm += wpmint;
                totalacc += accuracyint;
                columnRounds = totalRounds % 10;
                
                System.out.println(last10wpm);
                if (columnRounds == 0) {
                    columnwpm = 10;
                    last10wpm = "round" + columnwpm;
                    last10acc = "round" + columnwpm + "acc";
                } else {
                    last10wpm = "round" + columnRounds;
                    last10acc = "round" + columnRounds + "acc";
                }
                System.out.println(last10wpm);
                System.out.println(last10acc);
                
                // Update database with new values
                
                String updateQuery = "UPDATE `playerprofile` SET `totalround` = ?, `totalwpm` = ?, `totalacc` = ?, `" + last10wpm 
                        + "` = ?, `" + last10acc + "` = ? WHERE `username` = ?";
                try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                    updatePst.setInt(1, totalRounds);
                    updatePst.setInt(2, totalwpm);
                    updatePst.setInt(3, totalacc);
                    updatePst.setInt(4, wpmint);
                    updatePst.setInt(5, accuracyint);
                    updatePst.setString(6, username);

                    updatePst.executeUpdate();
                }

                con.close(); // Close the connection

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exceptions
    }
}
    
    private void updateScoreSql(){
        System.out.println(username);
    int wpmint = (int) wpm;
    int accuracyint = (int) accuracy;
     try{ 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration", "root", "");
            String query = "SELECT `" + ColumnSql + "` FROM `wordscore` WHERE `username` = ?";

            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, username); // Assuming 'username' holds the user's name

                ResultSet rs = pst.executeQuery();
               
                if (rs.next()) {
                    int currentScore = rs.getInt(ColumnSql);

                    if (wpm > currentScore) {
                        // If the new score is higher, update the database
                      String updateQuery = "UPDATE `wordscore` SET `" + ColumnSql + "` = ?, `" + AccColumnSql + "` = ? WHERE `username` = ?";
                        try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                            updatePst.setInt(1, wpmint);
                            updatePst.setDouble(2, accuracyint);
                            updatePst.setString(3, username);// Assuming 'username' holds the user's name

                            updatePst.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Congratulation You Break Your High Score");
                            
                        } catch (SQLException e) {
                            e.printStackTrace();
                            // Handle SQL exception
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle SQL exception
            }
            }catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex);
            }
        
    }
    
    
    private void updateTimerDisplay(){
        int totalCharacters = currentText.length(); // Total characters in the target text
    int typedCharacters = currentIndex;

    wpm = 0.0;
    accuracy = 0.0;
    if (elapsedTimeInSeconds > 0) {
        // Calculate words per minute
        wpm = (totalCorrectChars / 5.0) / (elapsedTimeInSeconds / 60.0);
    }

    if (typedCharacters > 0) {
        // Calculate accuracy
        accuracy = (totalCorrectChars * 100.0) / totalTypedChars;
    }

    jLabelTimer.setText("Timer: " + elapsedTimeInSeconds + "s | WPM: " + String.format("%.2f", wpm)+" | Accuracy: " 
            + String.format("%.2f%%", accuracy) );
    
    
     
}
    
    private void twentyFiveWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twentyFiveWordsActionPerformed
        testType = "words 25 English";
        ColumnSql = "25words";
        AccColumnSql = "25accwords";
        wpmData = new ArrayList<>();
        accData = new ArrayList<>();
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 32));
        updateTextArea(25);
        jTextPane2.requestFocusInWindow();
         
        
        
    }//GEN-LAST:event_twentyFiveWordsActionPerformed

    private void oneHundredWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneHundredWordsActionPerformed
        testType = "words 100 English";
        ColumnSql = "100words";
        AccColumnSql = "100accwords";
        wpmData = new ArrayList<>();
        accData = new ArrayList<>();
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 20));
        updateTextArea(100);
         jTextPane2.requestFocusInWindow();
        
    }//GEN-LAST:event_oneHundredWordsActionPerformed

    private void fiftyWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyWordsActionPerformed
        testType = "words 50 English";
        ColumnSql = "50words";
        AccColumnSql = "50accwords";
        wpmData = new ArrayList<>();
        accData = new ArrayList<>();
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 26));
        updateTextArea(50);
         jTextPane2.requestFocusInWindow();

    }//GEN-LAST:event_fiftyWordsActionPerformed

    private void TenWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenWordsActionPerformed
        testType = "words 10 English";
        ColumnSql = "10words";
        AccColumnSql = "10accwords";
        wpmData = new ArrayList<>();
        accData = new ArrayList<>();
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 36));
        updateTextArea(10);
         jTextPane2.requestFocusInWindow();

    
        
    }//GEN-LAST:event_TenWordsActionPerformed

    private void MENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENUActionPerformed
        // TODO add your handling code here:
       String transferUsername = username;
        MainPage MainPageFrame = new MainPage();
        MainPageFrame.setUsername(transferUsername);
        MainPageFrame.pack();
        MainPageFrame.setVisible(true);
        MainPageFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MENUActionPerformed

    private void GAMEMODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GAMEMODEActionPerformed
        // TODO add your handling code here:
        String transferUsername = username;
        
        GameModes GameModesFrame = new GameModes();
        GameModesFrame.setUsername(transferUsername);
        GameModesFrame.setVisible(true);
        GameModesFrame.pack();
        GameModesFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_GAMEMODEActionPerformed
    private void storecurrentwpm(){
         double wpm = (totalCorrectChars / 5.0) / (elapsedTimeInSeconds / 60.0);
         wpmData.add((int)wpm);
         double acc = (totalCorrectChars * 100.0) / totalTypedChars;
         accData.add((int)acc);
    
    }
    
    private void initialiseGame(){
        

        words = new ArrayList<>();

        // Replace "words.txt" with the name of your text file
        String fileName = "wordsList.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] lineWords = line.split("\\s+"); // Split words by space
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        currentText = new StringBuilder();
        currentIndex = 0;
        
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                elapsedTimeInSeconds++;
                updateTimerDisplay();
                storecurrentwpm();
            }
        });
        
             
                
        jTextPane2.addKeyListener(new KeyListener() {
    @Override
    public void keyTyped(KeyEvent e) {
        char typedChar = e.getKeyChar();

        if (typedChar == KeyEvent.VK_SPACE) {
            handleSpaceBar();
        } else if (typedChar != KeyEvent.VK_BACK_SPACE) {
            // Only handle regular key if it's not a space
            if (currentText.charAt(currentIndex) != ' ') {
                handleRegularKey(typedChar);
            }
        }

        if (currentIndex == currentText.length()) {
            stopTimer();
            collectResult();
        }
    }
            
            @Override
            public void keyPressed(KeyEvent e){
    int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_BACK_SPACE){
        handleBackspace();
    }
}
            
            private void handleBackspace(){
                if(currentIndex > 0){
                    currentIndex--;
                    
                    StyledDocument doc = jTextPane2.getStyledDocument();
                    Style style = jTextPane2.addStyle("Style",null);
                    
                    
                    doc.setCharacterAttributes(currentIndex, 1, style, true);
                    
//                    StyleConstants.setBackground(style, Color.BLACK);
//                    StyleConstants.setForeground(style, Color.WHITE);
                    
                    caret.setDot(currentIndex);
                    doc.setCharacterAttributes(currentIndex, 1, style, true);
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                
        }
            
    });
        currentText = new StringBuilder();
        currentIndex = 0;

        jTextPane2.setText(currentText.toString());

        jTextPane2.setEditable(false);
        
        StyledDocument doc = jTextPane2.getStyledDocument();
        Style style = jTextPane2.addStyle("Style", null);
//        StyleConstants.setBackground(style, Color.BLACK);
        doc.setCharacterAttributes(0, doc.getLength(), style, false);
        jTextPane2.requestFocus();
    }
    
    private void handleKeyTyped(KeyEvent e){
        char typedChar = e.getKeyChar();
        
        if(typedChar == KeyEvent.VK_SPACE){
            handleSpaceBar();
            
        }else{
            handleRegularKey(typedChar);
        }
        
        updateTimerDisplay();
    }
    
    private void handleRegularKey(char typedChar){
        if(currentIndex < currentText.length()){
        char nextChar = currentText.charAt(currentIndex);

        StyledDocument doc = jTextPane2.getStyledDocument();
        Style style = jTextPane2.addStyle("Style", null);

            if(currentIndex == 0){
                startTimer();}

            if(typedChar == nextChar){
            StyleConstants.setForeground(style, Color.GREEN);
            doc.setCharacterAttributes(currentIndex, 1, style, false);
            currentIndex++;
            
            totalTypedChars++;
              totalCorrectChars++;

            
            }else{
            StyleConstants.setForeground(style, Color.RED);
            doc.setCharacterAttributes(currentIndex, 1, style, false);
            currentIndex++;

            totalTypedChars++;
            totalMistakes++;
        }

        caret.setDot(currentIndex);
        updateTimerDisplay();
    }
}
    
    
    
    private void handleSpaceBar(){
     StyledDocument doc = jTextPane2.getStyledDocument();
    Style style = jTextPane2.addStyle("Style", null);
//      StyleConstants.setForeground(style, Color.WHITE);

    currentIndex = getNextWordEndIndex(currentIndex);
    caret.setDot(currentIndex);
    doc.setCharacterAttributes(0, doc.getLength(), style, false);
}
    
    private int getNextWordEndIndex(int startIndex){
       StyledDocument doc = jTextPane2.getStyledDocument();
    Style style = jTextPane2.addStyle("Style", null);
    int spaceIndex = currentText.indexOf(" ", startIndex);

    if (spaceIndex != -1) {
        int endOfWord = spaceIndex;
        int start = startIndex;

        while (start < endOfWord) {
            StyleConstants.setForeground(style, Color.RED);
            doc.setCharacterAttributes(start, 1, style, false);
            
            start++;
        }
    }

    return spaceIndex == -1 ? currentText.length() : spaceIndex + 1;
}
    
    private String getNextWord(){
        int spaceIndex = currentText.indexOf(" ", currentIndex);
        if(spaceIndex == -1){
            return currentText.substring(currentIndex);
        }else{
            return currentText.substring(currentIndex,spaceIndex);
        }
    }
    
    private void updateTextArea(int numberOfWords){
        
    totalTypedChars = 0;
    totalCorrectChars = 0;
    totalMistakes = 0;
    stopTimer();    
    
    Random random = new Random();
    StringBuilder result = new StringBuilder();

    for(int i = 0; i < numberOfWords; i++){
        int randomIndex = random.nextInt(words.size());
        String selectedWord = words.get(randomIndex);
        result.append(selectedWord).append(" ");

    }

    currentText = new StringBuilder(result.toString().trim());
    currentIndex = 0;

    jTextPane2.setText(currentText.toString());
    StyledDocument doc = jTextPane2.getStyledDocument();
    Style style = jTextPane2.addStyle("Style", null);
//    StyleConstants.setBackground(style, Color.BLACK);
    doc.setCharacterAttributes(0, doc.getLength(), style, true);
    
    jTextPane2.setCaretPosition(currentIndex);
    caret = jTextPane2.getCaret();
    caret.setVisible(true);
    
    
     
    
    
    
}

    
    
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
            java.util.logging.Logger.getLogger(Words.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Words.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Words.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Words.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Words WordsFrame = new Words();
                WordsFrame.pack(); // Pack the frame before displaying it
                WordsFrame.setVisible(true);
                WordsFrame.setLocationRelativeTo(null);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GAMEMODE;
    private javax.swing.JButton MENU;
    private javax.swing.JButton TenWords;
    private javax.swing.JButton fiftyWords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTimer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton oneHundredWords;
    private javax.swing.JButton twentyFiveWords;
    // End of variables declaration//GEN-END:variables
}
