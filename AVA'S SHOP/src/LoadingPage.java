import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import java.awt.*;

public class LoadingPage extends JFrame
{
    JLabel title;
    JProgressBar progressBar;
    Color pistacchioGreen, darkestgreen;
    Font titlefont, statusfont;
    Border border;
    JTextArea status;
    JPanel motherpanel;
    LoadingPage()
    {
        title = new JLabel();

        progressBar = new JProgressBar();

        pistacchioGreen = new Color(181,200,177);
        darkestgreen = new Color(4, 80, 53);

        titlefont = new Font("Segoe UI Bold", Font.BOLD, 55);
        statusfont = new Font("Segoe UI Bold", Font.BOLD, 19);

        border = BorderFactory.createLineBorder(darkestgreen, 2);

        status = new JTextArea();

        motherpanel = new JPanel();

        this.setTitle("Loading Page");
        this.setSize(910,650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(pistacchioGreen);
        this.setResizable(false);

        barsetting();
        titlesettings();
        statussettings();

        motherpanel.setBounds(0,0,910,650);
        motherpanel.setLayout(null);
        motherpanel.setBackground(null);

        motherpanel.add(title);
        motherpanel.add(progressBar);
        motherpanel.add(status);

        this.add(motherpanel);
        this.setVisible(true);

        fill();
        this.dispose();
    }
    public void fill()
    {
        int i;
        int val = 0;
        progressBar.setValue(val);
        for(i = 0; i <= 100; i++)
        {
            status.setText("Status: " + i + " %");
            progressBar.setValue(val + i);
            sleep(10);
            if(i == 86 || i == 62) sleep(1000);
        }
    }
    public void sleep(int mills)
    {
        try
        {
            Thread.sleep(mills);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void barsetting()
    {
        progressBar.setBounds(155,340,600,30);
        progressBar.setBorder(border);
        progressBar.setForeground(darkestgreen);
        progressBar.setBackground(pistacchioGreen);
        progressBar.setFocusable(false);
        progressBar.setUI(new BasicProgressBarUI()
        {
            protected Color getSelectionBackground() { return darkestgreen; }
            protected Color getSelectionForeground() { return pistacchioGreen; }
        });
    }
    public void titlesettings()
    {
        title.setText("AVA'S SHOP");
        title.setForeground(darkestgreen);
        title.setFont(titlefont);
        title.setBounds(290,245,330,60);
    }
    public void statussettings()
    {
        status.setBounds(30,550,200,50);
        status.setEditable(false);
        status.setFont(statusfont);
        status.setForeground(darkestgreen);
        status.setBackground(null);
    }
}