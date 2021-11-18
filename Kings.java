import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;

public class Kings extends JFrame{
  
  private JButton drawBtn = new JButton("Draw");
  private JButton replayBtn = new JButton("Replay");
  private JPanel btnWindow = new JPanel();
  private JPanel imageWindow = new JPanel();
  private JPanel textWindow = new JPanel();
  int turn = 1;
  int avg1 = new Random().nextInt(40 - 10 + 1) + 10;
  int avg2 = new Random().nextInt(40 - 10 + 1) + 10;
  int finalTurn = (avg1 + avg2) / 2;
  JLabel deckImage = new JLabel(new ImageIcon("Images/deck.png"));
  int cardNum;
  ArrayList<String> deck = new ArrayList<String>();
  boolean firstMove = true;
  JLabel text = new JLabel("You are playing King's!");
  JLabel cardImage = new JLabel();
  
  public Kings() {
    createDeck();
    javax.swing.Timer timer = new javax.swing.Timer(8000, new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        invalidate();
        btnWindow.add(replayBtn);
        btnWindow.revalidate();
        btnWindow.repaint();
      }
    });
    btnWindow.add(drawBtn);
    add(btnWindow, BorderLayout.SOUTH);
    drawBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        turn++;
        if(firstMove) {
          imageWindow.remove(deckImage);
          imageWindow.revalidate();
          imageWindow.repaint();
          firstMove = false;
        }
        else {
          imageWindow.remove(cardImage);
          imageWindow.revalidate();
          imageWindow.repaint();
        }
        int cardIndex = new Random().nextInt(deck.size());
        String fileName = "Images/" + deck.get(cardIndex);
        cardImage = new JLabel(new ImageIcon(fileName));
        imageWindow.add(cardImage, BorderLayout.CENTER);
        text.setText(getRule(fileName));
        playSound("C:/Users/Jacob/Desktop/School/Job Search/Code Sample/Kings/Images/cardFlip.wav");
        deck.remove(cardIndex);
        System.out.println(turn);
        System.out.println(finalTurn + "\n");
        if(turn >= finalTurn) {
          btnWindow.remove(drawBtn);
          imageWindow.removeAll();
          text.setText("");
          imageWindow.revalidate();
          imageWindow.repaint();
          JLabel losingGif = new JLabel(new ImageIcon("Images/lost.gif"));
          imageWindow.add(losingGif, BorderLayout.NORTH);
          music();
          imageWindow.revalidate();
          imageWindow.repaint();
          timer.start();
        }
      }
    });
    replayBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        timer.stop();
        turn = 1;
        avg1 = new Random().nextInt(40 - 10 + 1) + 10;
        avg2 = new Random().nextInt(40 - 10 + 1) + 10;
        finalTurn = (avg1 + avg2) / 2;
        firstMove = true;
        createDeck();
        btnWindow.remove(replayBtn);
        imageWindow.removeAll();
        text.setText("You are playing King's!");
        imageWindow.revalidate();
        imageWindow.repaint();
        imageWindow.add(deckImage);
        imageWindow.revalidate();
        imageWindow.repaint();
        btnWindow.add(drawBtn);
        btnWindow.revalidate();
        btnWindow.repaint();
        playSound("Images/cardShuffle.wav");
      }
    });
    imageWindow.add(deckImage);
    add(imageWindow, BorderLayout.CENTER);
    text.setFont(new Font("Serif", Font.PLAIN, 40));
    textWindow.add(text);
    add(textWindow, BorderLayout.NORTH);
    setSize(400, 400);
    setResizable(false);
    setTitle("Kings");
    getContentPane().setBackground(Color.WHITE);
    btnWindow.setBackground(Color.WHITE);
    imageWindow.setBackground(Color.WHITE);
    textWindow.setBackground(Color.WHITE);
    setVisible(true);
    delay(1);
    playSound("Images/cardShuffle.wav");
  }
  
  private void createDeck() {
    deck.add("c1.png");
    deck.add("c2.png");
    deck.add("c3.png");
    deck.add("c4.png");
    deck.add("c5.png");
    deck.add("c6.png");
    deck.add("c7.png");
    deck.add("c8.png");
    deck.add("c9.png");
    deck.add("c10.png");
    deck.add("cj.png");
    deck.add("cq.png");
    deck.add("ck.png");
    deck.add("d1.png");
    deck.add("d2.png");
    deck.add("d3.png");
    deck.add("d4.png");
    deck.add("d5.png");
    deck.add("d6.png");
    deck.add("d7.png");
    deck.add("d8.png");
    deck.add("d9.png");
    deck.add("d10.png");
    deck.add("dj.png");
    deck.add("dq.png");
    deck.add("dk.png");
    deck.add("h1.png");
    deck.add("h2.png");
    deck.add("h3.png");
    deck.add("h4.png");
    deck.add("h5.png");
    deck.add("h6.png");
    deck.add("h7.png");
    deck.add("h8.png");
    deck.add("h9.png");
    deck.add("h10.png");
    deck.add("hj.png");
    deck.add("hq.png");
    deck.add("hk.png");
    deck.add("s1.png");
    deck.add("s2.png");
    deck.add("s3.png");
    deck.add("s4.png");
    deck.add("s5.png");
    deck.add("s6.png");
    deck.add("s7.png");
    deck.add("s8.png");
    deck.add("s9.png");
    deck.add("s10.png");
    deck.add("sj.png");
    deck.add("sq.png");
    deck.add("sk.png");
  }
  
  private void music() {
    String filename = "Images/discoMusic.wav";
    try
    {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
        clip.start();
    }
    catch (Exception exc)
    {
        exc.printStackTrace(System.out);
    }
  }
  
  public static void delay(int seconds){
    Date start = new Date();
    Date end = new Date();
    while(end.getTime() - start.getTime() < seconds * 1000){
        end = new Date();
    }
}
  
  private String getRule(String fileName) {
    String location = "Images/";
    if( fileName.equals(location + "c1.png") || fileName.equals(location + "d1.png") || fileName.equals(location + "h1.png") || fileName.equals(location + "s1.png") )
      return "WATERFALL!";
    if( fileName.equals(location + "c2.png") || fileName.equals(location + "d2.png") || fileName.equals(location + "h2.png") || fileName.equals(location + "s2.png") )
      return "YOU";
    if( fileName.equals(location + "c3.png") || fileName.equals(location + "d3.png") || fileName.equals(location + "h3.png") || fileName.equals(location + "s3.png") )
      return "ME";
    if( fileName.equals(location + "c4.png") || fileName.equals(location + "d4.png") || fileName.equals(location + "h4.png") || fileName.equals(location + "s4.png") )
      return "FLOOR";
    if( fileName.equals(location + "c5.png") || fileName.equals(location + "d5.png") || fileName.equals(location + "h5.png") || fileName.equals(location + "s5.png") )
      return "GUYS";
    if( fileName.equals(location + "c6.png") || fileName.equals(location + "d6.png") || fileName.equals(location + "h6.png") || fileName.equals(location + "s6.png") )
      return "CHICKS";
    if( fileName.equals(location + "c7.png") || fileName.equals(location + "d7.png") || fileName.equals(location + "h7.png") || fileName.equals(location + "s7.png") )
      return "HEAVEN";
    if( fileName.equals(location + "c8.png") || fileName.equals(location + "d8.png") || fileName.equals(location + "h8.png") || fileName.equals(location + "s8.png") )
      return "PICK A DATE";
    if( fileName.equals(location + "c9.png") || fileName.equals(location + "d9.png") || fileName.equals(location + "h9.png") || fileName.equals(location + "s9.png") )
      return "RHYME";
    if( fileName.equals(location + "c10.png") || fileName.equals(location + "d10.png") || fileName.equals(location + "h10.png") || fileName.equals(location + "s10.png") )
      return "CATEGORIES";
    if( fileName.equals(location + "cj.png") || fileName.equals(location + "dj.png") || fileName.equals(location + "hj.png") || fileName.equals(location + "sj.png") )
      return "NEVER HAVE I EVER";
    if( fileName.equals(location + "cq.png") || fileName.equals(location + "dq.png") || fileName.equals(location + "hq.png") || fileName.equals(location + "sq.png") )
      return "QUESTION MASTER";
    else
      return "MAKE A RULE";
  }
  
  public void playSound(String soundName)
 {
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
   }
   catch(Exception error)
   {
     System.out.println("Error with playing sound.");
     error.printStackTrace( );
   }
 }
  
  public static void main(String[] args) {
    new Kings();
  }
}

  