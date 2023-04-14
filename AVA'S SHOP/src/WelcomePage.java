import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements MouseListener
{
    ImageIcon icon1 = new ImageIcon("2.png");
    ImageIcon icon2 = new ImageIcon("1.png");
    Font titlefont, admin_client;
    Color pistacchioGreen, darkestgreen, abetegreen;
    JLabel title, clientbody, adminbody, admin, client;
    JButton adminaccedi, adminiscriviti, clientaccedi, clientiscriviti;
    JPanel adminpanel, clientpanel, motherPanel;
    WelcomePage()
    {

        motherPanel = new JPanel();
        adminpanel = new JPanel();
        clientpanel = new JPanel();

        titlefont = new Font("Segoe UI Bold", Font.BOLD, 45);
        admin_client = new Font("Segoe UI Bold", Font.BOLD, 16);

        pistacchioGreen = new Color(181,200,177);
        darkestgreen = new Color(4, 80, 53);
        abetegreen = new Color(9, 102, 69);

        title= new JLabel();
        clientbody = new JLabel();
        adminbody = new JLabel();
        admin = new JLabel("ADMIN");
        client = new JLabel("CLIENTE");

        adminaccedi = new JButton("ACCEDI");
        adminiscriviti = new JButton("ISCRIVITI");
        clientaccedi = new JButton("ACCEDI");
        clientiscriviti = new JButton("ISCRIVITI");

        this.setTitle("Welcome Page");
        this.setSize(910,650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(pistacchioGreen);
        this.setResizable(false);

        adminpanel.setLayout(null);
        adminpanel.setBounds(175,130, 220, 420);
        adminpanel.setBackground(null);

        clientpanel.setLayout(null);
        clientpanel.setBounds(515, 130, 220, 420);
        clientpanel.setBackground(null);

        motherPanel.setBounds(0,0,910,650);
        motherPanel.setLayout(null);
        motherPanel.setBackground(null);

        motherPanel.add(title);
        motherPanel.add(adminpanel);
        motherPanel.add(clientpanel);

        adminsetup();
        clientsetup();
        titlesetup();

        this.add(motherPanel);
        this.setVisible(true);
    }
    public void adminsetup()
    {
        adminpanel.add(admin);
        adminpanel.add(adminbody);
        adminpanel.add(adminaccedi);
        adminpanel.add(adminiscriviti);

        admin.setBounds(0,0,220,55);
        admin.setFont(admin_client);
        admin.setForeground(darkestgreen);
        admin.setHorizontalAlignment(JLabel.CENTER);
        admin.setVerticalAlignment(JLabel.CENTER);
        admin.setBackground(darkestgreen);
        adminbody.setIcon(icon1);
        admin.setForeground(pistacchioGreen);
        admin.setOpaque(true);

        adminbody.setHorizontalAlignment(JLabel.CENTER);
        adminbody.setVerticalAlignment(JLabel.CENTER);
        adminbody.setBounds(0, 60, 220, 240);
        adminbody.setBackground(abetegreen);
        adminbody.setOpaque(true);

        adminaccedi.setBounds(0, 305, 220, 55);
        adminaccedi.setBorder(null);
        adminaccedi.setBackground(darkestgreen);
        adminaccedi.setForeground(pistacchioGreen);
        adminaccedi.setFocusable(false);
        adminaccedi.setFont(admin_client);
        adminaccedi.addMouseListener(this);

        adminiscriviti.setBounds(0, 365, 220, 55);
        adminiscriviti.setBorder(null);
        adminiscriviti.setBackground(darkestgreen);
        adminiscriviti.setForeground(pistacchioGreen);
        adminiscriviti.setFocusable(false);
        adminiscriviti.setFont(admin_client);
        adminiscriviti.addMouseListener(this);
    }
    public void clientsetup()
    {
        clientpanel.add(client);
        clientpanel.add(clientbody);
        clientpanel.add(clientaccedi);
        clientpanel.add(clientiscriviti);

        client.setBounds(0,0,220,55);
        client.setFont(admin_client);
        client.setForeground(darkestgreen);
        client.setHorizontalAlignment(JLabel.CENTER);
        client.setVerticalAlignment(JLabel.CENTER);
        client.setBackground(darkestgreen);
        client.setForeground(pistacchioGreen);
        client.setOpaque(true);

        clientbody.setHorizontalAlignment(JLabel.CENTER);
        clientbody.setVerticalAlignment(JLabel.CENTER);
        clientbody.setBounds(0, 60, 220, 240);
        clientbody.setBackground(abetegreen);
        clientbody.setIcon(icon2);
        clientbody.setOpaque(true);

        clientaccedi.setBounds(0, 305, 220, 55);
        clientaccedi.setBorder(null);
        clientaccedi.setBackground(darkestgreen);
        clientaccedi.setForeground(pistacchioGreen);
        clientaccedi.setFocusable(false);
        clientaccedi.setFont(admin_client);
        clientaccedi.addMouseListener(this);

        clientiscriviti.setBounds(0, 365, 220, 55);
        clientiscriviti.setBorder(null);
        clientiscriviti.setBackground(darkestgreen);
        clientiscriviti.setForeground(pistacchioGreen);
        clientiscriviti.setFocusable(false);
        clientiscriviti.setFont(admin_client);
        clientiscriviti.addMouseListener(this);
    }
    public void titlesetup()
    {
        title.setText("AVA'S SHOP");
        title.setFont(titlefont);
        title.setBounds(50,30,300,60);
        title.setForeground(darkestgreen);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        this.dispose();
        if(e.getSource() == adminaccedi) new Accedi(1);
        if(e.getSource() == adminiscriviti) new Iscriviti(1);
        if(e.getSource() == clientaccedi) new Accedi(0);
        if(e.getSource() == clientiscriviti) new Iscriviti(0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getSource() == adminaccedi) adminaccedi.setBackground(new Color(2,60,40));
        if(e.getSource() == adminiscriviti) adminiscriviti.setBackground(new Color(2,60,40));
        if(e.getSource() == clientaccedi) clientaccedi.setBackground(new Color(2,60,40));
        if(e.getSource() == clientiscriviti) clientiscriviti.setBackground(new Color(2,60,40));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource() == adminaccedi) adminaccedi.setBackground(darkestgreen);
        if(e.getSource() == adminiscriviti) adminiscriviti.setBackground(darkestgreen);
        if(e.getSource() == clientaccedi) clientaccedi.setBackground(darkestgreen);
        if(e.getSource() == clientiscriviti) clientiscriviti.setBackground(darkestgreen);
    }
}