import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Calculatrice {

    private double resultat1=0.0, resultat2=0.0;

    private char operateur;

    private JPanel Calculatrice;
    private JLabel ecran;
    private JButton btndiv,btnmultip,btnmoins, btnplus;
    private JButton btn0, btn1,btn2,btn3, btn4,btn5, btn6, btn7,btn8, btn9;
    private JButton btnvirgule;
    private JButton btnefface;
    private JButton btnsigne;
    private JButton btnegal;
    private Font digital;

    public Calculatrice() {

        try{
       digital=Font.createFont(Font.TRUETYPE_FONT,new File("digital-7.ttf")).deriveFont(20f);
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("digital-7.ttf")));}

        catch (IOException | FontFormatException exe ){}

        ecran.setFont(digital);
        ecran.setBackground(Color.WHITE);

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"0");
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"1");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"2");
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"3");
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"4");
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"5");
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"6");
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"7");
            }
        });

        btn8.addActionListener(e -> ecran.setText(ecran.getText()+"8"));

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.setText(ecran.getText()+"9");
            }
        });

        btnplus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operateur='+';
                resultat1+=Double.parseDouble(ecran.getText());
                ecran.setText("");

            }
        });

        btnmoins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operateur='-';
                resultat1+=Double.parseDouble(ecran.getText());
                ecran.setText("");

            }
        });

        btnmultip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operateur='*';
                resultat1+=Double.parseDouble(ecran.getText());
                ecran.setText("");
            }
        });

        btndiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operateur='/';
                resultat1+=Double.parseDouble(ecran.getText());
                ecran.setText("");
            }
        });


        btnefface.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultat2=0;
                ecran.setText("");
            }
        });

        btnvirgule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(ecran.getText().equals(""))
                    ecran.setText("0.");

                else if(ecran.getText().contains("."))
                    btnvirgule.setEnabled(false);
                else ecran.setText(ecran.getText()+".");
                btnvirgule.setEnabled(true);
            }
        });

        btnsigne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ecran.setText("-"+ecran.getText());}
        });



        btnegal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (operateur) {

                    case '+':
                        resultat2 = resultat1 + Double.parseDouble(ecran.getText());
                        break;
                    case '-':
                        resultat2 = resultat1 - Double.parseDouble(ecran.getText());
                        break;
                    case '*':
                        resultat2 = resultat1 * Double.parseDouble(ecran.getText());
                        break;
                    case '/':
                        try {
                            resultat2 = resultat1 / Double.parseDouble(ecran.getText());}
                        catch (ArithmeticException ex) {
                            ecran.setText("MATH ERROR");}
                }
                        operateur = 0;
                        ecran.setText(Double.toString(resultat2));
                        resultat1 = 0;

                }
        });
        }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculatrice");
        frame.setContentPane(new Calculatrice().Calculatrice);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,500);
        frame.setResizable(false);
        frame.setLocation(650,140);

        Image ic=Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Videos\\MES DOCUMENTS\\Logo-UHBC.png");
        frame.setIconImage(ic);
        frame.setVisible(true);

    }
}