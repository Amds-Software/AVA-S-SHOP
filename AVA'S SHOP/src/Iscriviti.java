import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Iscriviti extends JFrame implements MouseListener
{
    int type;
    Color pistacchioGreen, darkestgreen, abetegreen;
    JLabel title, head;
    JButton confirm, back;
    JPanel compilazione, motherpanel;
    Font titlefont, admin_client, field, user_password;
    JTextArea userid, password;
    JTextField userfield;
    JPasswordField passwordfield;
    Border border;
    Iscriviti(int type)
    {
        border = BorderFactory.createLineBorder(pistacchioGreen, 2);

        userfield = new JTextField();
        passwordfield = new JPasswordField();

        pistacchioGreen = new Color(181,200,177);
        darkestgreen = new Color(4, 80, 53);
        abetegreen = new Color(9, 102, 69);

        title= new JLabel();
        head = new JLabel();

        confirm = new JButton("CONFERMA");
        back = new JButton("INDIETRO");

        compilazione = new JPanel();
        motherpanel = new JPanel();

        titlefont = new Font("Segoe UI Bold", Font.BOLD, 45);
        admin_client = new Font("Segoe UI Bold", Font.BOLD, 19);
        user_password = new Font("Segoe UI Bold", Font.BOLD, 24);
        field = new Font("Segoe UI Bold", Font.BOLD, 20);

        userid = new JTextArea("USER-ID");
        password = new JTextArea("PASSWORD");

        this.setTitle("ISCRIVITI");
        this.setSize(910,650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(pistacchioGreen);
        this.setResizable(false);

        this.type = type;
        if(type == 1) head.setText("ADMIN");
        else head.setText("CLIENTE");

        userfield.setBounds(200,78,200,30);
        userfield.setBackground(Color.red);
        userfield.setOpaque(true);
        userfield.setFont(field);
        userfield.setBackground(null);
        userfield.setForeground(pistacchioGreen);
        userfield.setBorder(border);
        userfield.setCaretColor(pistacchioGreen);

        passwordfield.setBounds(200,158,200,30);
        passwordfield.setBackground(Color.red);
        passwordfield.setOpaque(true);
        passwordfield.setFont(field);
        passwordfield.setBackground(null);
        passwordfield.setForeground(pistacchioGreen);
        passwordfield.setBorder(border);
        passwordfield.setCaretColor(pistacchioGreen);

        userid.setBounds(65,80,80,30);
        userid.setForeground(pistacchioGreen);
        userid.setEditable(false);
        userid.setFont(admin_client);
        userid.setBackground(null);

        password.setBounds(65,160,110,30);
        password.setForeground(pistacchioGreen);
        password.setEditable(false);
        password.setFont(admin_client);
        password.setBackground(null);

        compilazione.setLayout(null);
        compilazione.setBounds(200, 210, 500, 270);
        compilazione.setBackground(abetegreen);
        compilazione.setOpaque(true);

        compilazione.add(userid);
        compilazione.add(password);
        compilazione.add(passwordfield);
        compilazione.add(userfield);

        head.setBounds(200,150,500,55);
        head.setFont(admin_client);
        head.setForeground(darkestgreen);
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setVerticalAlignment(JLabel.CENTER);
        head.setBackground(darkestgreen);
        head.setForeground(pistacchioGreen);
        head.setOpaque(true);

        confirm.setBounds(200,485,245,55);
        confirm.setFont(admin_client);
        confirm.setForeground(darkestgreen);
        confirm.setHorizontalAlignment(JLabel.CENTER);
        confirm.setVerticalAlignment(JLabel.CENTER);
        confirm.setBackground(darkestgreen);
        confirm.setForeground(pistacchioGreen);
        confirm.setFocusable(false);
        confirm.setBorder(null);
        confirm.setOpaque(true);
        confirm.addMouseListener(this);

        back.setBounds(450,485,250,55);
        back.setFont(admin_client);
        back.setForeground(darkestgreen);
        back.setHorizontalAlignment(JLabel.CENTER);
        back.setVerticalAlignment(JLabel.CENTER);
        back.setBackground(darkestgreen);
        back.setForeground(pistacchioGreen);
        back.setFocusable(false);
        back.setBorder(null);
        back.setOpaque(true);
        back.addMouseListener(this);

        motherpanel.setBounds(0,0,910,650);
        motherpanel.setLayout(null);
        motherpanel.setBackground(null);

        motherpanel.add(head);
        motherpanel.add(title);
        motherpanel.add(confirm);
        motherpanel.add(back);
        motherpanel.add(compilazione);

        titlesetup();

        this.add(motherpanel);
        this.setVisible(true);
    }
    public void titlesetup()
    {
        title.setText("ISCRIVITI");
        title.setFont(titlefont);
        title.setBounds(50,30,245,60);
        title.setForeground(darkestgreen);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}


    @Override
    public void mousePressed(MouseEvent e)
    {
        this.dispose();
        if(e.getSource() == back) new WelcomePage();
        if(e.getSource() == confirm)
        {
            try
            {
                if(userfield.getText().equals("") || passwordfield.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Parametri non validi", "Account Management", JOptionPane.ERROR_MESSAGE);
                else
                {
                    FileWriter file = new FileWriter("credentials.txt", true);

                    BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));

                    String line;

                    boolean presente = false;

                    String credential = userfield.getText() + "," + passwordfield.getText() + "," + type;

                    while(reader.ready())
                    {
                        line = reader.readLine();
                        String[] arr = line.split(",");
                        if(arr[0].equals(userfield.getText()))
                        {
                            presente = true;
                            JOptionPane.showMessageDialog(null, "USER-ID già utilizzato", "Account Management", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }

                    if(!presente)
                    {
                        file.append(credential).append("\n");

                        JOptionPane.showMessageDialog(null, "Account creato con successo", "Account Management", JOptionPane.INFORMATION_MESSAGE);
                    }

                    file.close();
                }
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
            new WelcomePage();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getSource() == back) back.setBackground(new Color(2,60,40));
        if(e.getSource() == confirm) confirm.setBackground(new Color(2,60,40));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource() == back) back.setBackground(darkestgreen);
        if(e.getSource() == confirm) confirm.setBackground(darkestgreen);
    }
}