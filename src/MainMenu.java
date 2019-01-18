/**This is the Main Menu Panel.
 * @author Kostas Oikonomou
 * @version 2
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.EventListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;

public class MainMenu extends JPanel{

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JComboBox box1;
    private JComboBox box2;
    private JComboBox box3;
    private JLabel l2;
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JLabel p4;
    private JLabel p5;
    private JTextField name;
    private JLabel d1;
    private JLabel d2;
    private JLabel d3;
    private JLabel b1;
    private JLabel b2;
    private JLabel b3;
    private JLabel b4;
    private JLabel b5;
    private JLabel desc;
    private JLabel t1;
    private JLabel t2;
    private JLabel t3;


    public MainMenu() {

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.setVisible(true);

        Locale locale;
        ResourceBundle messages;

        locale = Locale.getDefault();
        messages = ResourceBundle.getBundle("MessageBundle",locale);

       String lel1 = messages.getString("goldfish");
       String lel2 = messages.getString("kangaroo");
       String lel3 = messages.getString("elephant");
       String lel4 = messages.getString("name");

        d1 = new JLabel();

        d2 = new JLabel();

        d3 = new JLabel();

        String[] AIPlayers = {"0", "1", "2", "3"};

        String[] players = {"1", "2", "4"};

        String[] dif = {lel1,lel2,lel3};

        name = new JTextField(lel4);

        box1 = new JComboBox(AIPlayers);

        box2 = new JComboBox(players);

        box3 = new JComboBox(dif);

        GridBagConstraints c = new GridBagConstraints();

        b1 = new JLabel();

        b2 = new JLabel();

        b3 = new JLabel();

        b4 = new JLabel();

        b5 = new JLabel();

        button1 = new JButton();
        button1.add(b1);

        button2 = new JButton();
        button2.add(b2);

        button3 = new JButton();
        button3.add(b3);

        button4 = new JButton();
        button4.add(b4);

        button5 = new JButton();
        button5.add(b5);

        p1 = new JLabel();

        p2 = new JLabel();

        p3 = new JLabel();

        p4 = new JLabel();

        p5 = new JLabel();

        desc = new JLabel();

        l2 = new JLabel();

        t1 = new JLabel();

        t2 = new JLabel();

        t3 = new JLabel();

        l2.setFont(new Font("idk", Font.BOLD, 20));
        desc.setFont(new Font("idk", Font.BOLD, 15));
        p1.setFont(new Font("idk", Font.BOLD, 12));
        p2.setFont(new Font("idk", Font.BOLD, 12));
        p3.setFont(new Font("idk", Font.BOLD, 12));
        p4.setFont(new Font("idk", Font.BOLD, 12));
        p5.setFont(new Font("idk", Font.BOLD, 12));
        d1.setFont(new Font("idk", Font.BOLD, 12));
        d2.setFont(new Font("idk", Font.BOLD, 12));
        d3.setFont(new Font("idk", Font.BOLD, 12));
        t1.setFont(new Font("idk", Font.BOLD, 12));
        t2.setFont(new Font("idk", Font.BOLD, 12));
        t3.setFont(new Font("idk", Font.BOLD, 12));


        c.insets = new Insets(10, 0, 0, 10);

        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 2;
        c.gridy = 0;
        this.add(button1, c);

        c.gridx = 2;
        c.gridy = 1;
        this.add(button2, c);

        c.gridx = 2;
        c.gridy = 2;
        this.add(button3, c);

        c.gridx = 2;
        c.gridy = 3;
        this.add(button4, c);

        c.gridx = 2;
        c.gridy = 4;
        this.add(new JLabel(""), c);

        c.gridx = 2;
        c.gridy = 5;
        this.add(new JLabel(""), c);

        c.gridx = 2;
        c.gridy = 6;
        this.add(button5, c);

        c.gridx = 4;
        c.gridy = 0;
        this.add(t1, c);

        c.gridx = 4;
        c.gridy = 1;
        this.add(box2, c);

        c.gridx = 4;
        c.gridy = 2;
        this.add(t2, c);

        c.gridx = 4;
        c.gridy = 3;
        this.add(box1, c);

        c.gridx = 4;
        c.gridy = 4;
        this.add(t3, c);

        c.gridx = 4;
        c.gridy = 5;
        this.add(box3, c);

        c.gridx = 0;
        c.gridy = 0;
        this.add(l2, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(desc, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(p1, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add(p2, c);

        c.gridx = 0;
        c.gridy = 4;
        this.add(p3, c);

        c.gridx = 0;
        c.gridy = 5;
        this.add(p4, c);

        c.gridx = 0;
        c.gridy = 6;
        this.add(p5, c);

        c.gridx = 0;
        c.gridy = 7;
        this.add(name, c);

    }

    /**These are the getters.
     */

    public JButton getButton1(){return button1;}

    public JButton getButton2(){return button2;}

    public JButton getButton3(){return button3;}

    public JButton getButton4(){return button4;}

    public JButton getButton5(){return button5;}

    public JComboBox getBox1(){return box1;}

    public JComboBox getBox2(){return box2;}

    public JComboBox getBox3(){return box3;}

    public JTextField getPlayerName() {return name;}

    public JLabel getP1() {return p1;}

    public JLabel getP2() {return p2;}

    public JLabel getP3() {return p3;}

    public JLabel getP4() {return p4;}

    public JLabel getP5() {return p5;}

    public JLabel getB1() {return b1;}

    public JLabel getB2() {return b2;}

    public JLabel getB3() {return b3;}

    public JLabel getB4() {return b4;}

    public JLabel getB5() {return b5;}

    public JLabel getD1() {return d1;}

    public JLabel getD2() {return d2;}

    public JLabel getD3() {return d3;}

    public JLabel getT1() {return t1;}

    public JLabel getT2() {return t2;}

    public JLabel getT3() {return t3;}

    public JLabel getL2() {return l2;}

    public JLabel getDesc(){return desc;}
}
