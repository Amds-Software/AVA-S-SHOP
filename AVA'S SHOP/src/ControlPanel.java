import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class ControlPanel extends JFrame implements MouseListener, ActionListener
{
    int totalecash = 0, totaleclients = 0;
    Set<String> totprod, totcat, totstaff, totlavori;
    Color pistacchioGreen, darkestgreen, pioppogreen;
    JPanel motherpanel, magazzino, negozio, movimenti, clienti;
    JLabel titolomagazzino, titolonegozio, titolomovimenti, titoloclienti, title;
    JLabel bodymagazzino, bodynegozio;
    JTextArea bodymovimenti, bodyclienti;
    JLabel totalemovimenti, totaleclienti;
    JButton espandimagazzino, espandinegozio, indietro;
    JTextArea prodotti, categorieprodotti, staff, categoriastaff;
    Font titlefont, subtitles, minortitles;
    ControlPanel() throws IOException
    {
        totprod = new LinkedHashSet<>();
        totcat = new LinkedHashSet<>();
        totstaff = new LinkedHashSet<>();
        totlavori = new LinkedHashSet<>();

        titlefont = new Font("Segoe UI Bold", Font.BOLD, 45);
        subtitles = new Font("Segoe UI Bold", Font.BOLD, 14);
        minortitles = new Font("Segoe UI Bold", Font.BOLD, 14);

        pistacchioGreen = new Color(181,200,177);
        darkestgreen = new Color(4, 80, 53);
        pioppogreen = new Color(57, 112, 92);

        motherpanel = new JPanel();
        magazzino = new JPanel();
        negozio = new JPanel();
        movimenti = new JPanel();
        clienti = new JPanel();

        titolomagazzino = new JLabel("MAGAZZINO");
        titolonegozio = new JLabel("NEGOZIO");
        titolomovimenti = new JLabel("MOVIMENTI");
        titoloclienti = new JLabel("CLIENTI");

        title = new JLabel();

        bodymagazzino = new JLabel();
        bodynegozio = new JLabel();
        bodymovimenti = new JTextArea();
        bodyclienti = new JTextArea();

        totaleclienti = new JLabel();
        totalemovimenti = new JLabel();

        espandimagazzino = new JButton();
        espandinegozio = new JButton();
        indietro = new JButton("←");

        prodotti = new JTextArea();
        categorieprodotti = new JTextArea();
        staff = new JTextArea();
        categoriastaff = new JTextArea();

        motherpanel.setLayout(null);
        motherpanel.setBounds(0,0,910,650);
        motherpanel.setBackground(null);

        this.setTitle("PANNELLO DI CONTROLLO");
        this.setSize(910, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(pistacchioGreen);
        this.setResizable(false);

        BufferedReader reader = new BufferedReader(new FileReader("Prodotti.txt"));

        String line;

        while ((line = reader.readLine()) != null)
        {
            String[] array = line.split(",");
            totprod.add(array[0]);
            totcat.add(array[1]);
        }

        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader("Staff.txt"));

        String line1;

        while ((line1 = reader1.readLine()) != null)
        {
            String[] array1 = line1.split(",");
            totstaff.add(array1[0]);
            totlavori.add(array1[1]);
        }

        reader1.close();

        titlesetup();
        setupmagazzino();
        setupnegozio();
        setupmovimenti();
        setupclienti();

        motherpanel.add(title);
        motherpanel.add(magazzino);
        motherpanel.add(negozio);
        motherpanel.add(movimenti);
        motherpanel.add(clienti);

        this.add(motherpanel);
        this.setVisible(true);
    }
    public void titlesetup()
    {
        title.setText("PANNELLO DI CONTROLLO");
        title.setFont(titlefont);
        title.setBounds(50,30,710,60);
        title.setForeground(darkestgreen);
    }
    public void setupmagazzino()
    {
        magazzino.setLayout(null);
        magazzino.setBounds(47,150,240,160);
        magazzino.setBackground(null);

        titolomagazzino.setBounds(0,0,240, 50);
        titolomagazzino.setBackground(darkestgreen);
        titolomagazzino.setForeground(pistacchioGreen);
        titolomagazzino.setVerticalAlignment(JLabel.CENTER);
        titolomagazzino.setHorizontalAlignment(JLabel.CENTER);
        titolomagazzino.setFont(subtitles);
        titolomagazzino.setOpaque(true);

        bodymagazzino.setBounds(0,50,240,110);
        bodymagazzino.setLayout(null);
        bodymagazzino.setBackground(pioppogreen);
        bodymagazzino.setOpaque(true);

        prodotti.setText("NUMERO PRODOTTI:  " + totprod.size());
        prodotti.setBounds(15,10,180,20);
        prodotti.setFont(minortitles);
        prodotti.setEditable(false);
        prodotti.setBackground(null);
        prodotti.setForeground(pistacchioGreen);
        prodotti.setOpaque(true);

        categorieprodotti.setText("NUMERO CATEGORIE:  " + totcat.size());
        categorieprodotti.setBounds(15,40,180,20);
        categorieprodotti.setFont(minortitles);
        categorieprodotti.setEditable(false);
        categorieprodotti.setBackground(null);
        categorieprodotti.setForeground(pistacchioGreen);
        categorieprodotti.setOpaque(true);

        espandimagazzino.setBounds(70,70,100,30);
        espandimagazzino.setBorder(null);
        espandimagazzino.setBackground(darkestgreen);
        espandimagazzino.setText("ESPANDI");
        espandimagazzino.setHorizontalAlignment(JButton.CENTER);
        espandimagazzino.setVerticalAlignment(JButton.CENTER);
        espandimagazzino.setForeground(pistacchioGreen);
        espandimagazzino.setFont(minortitles);
        espandimagazzino.addMouseListener(this);
        espandimagazzino.addActionListener(this);
        espandimagazzino.setFocusable(false);

        bodymagazzino.add(prodotti);
        bodymagazzino.add(categorieprodotti);
        bodymagazzino.add(espandimagazzino);

        magazzino.add(titolomagazzino);
        magazzino.add(bodymagazzino);
    }
    public void setupnegozio()
    {
        negozio.setLayout(null);
        negozio.setBounds(47,370,240,160);
        negozio.setBackground(null);

        titolonegozio.setBounds(0,0,240, 50);
        titolonegozio.setBackground(darkestgreen);
        titolonegozio.setForeground(pistacchioGreen);
        titolonegozio.setVerticalAlignment(JLabel.CENTER);
        titolonegozio.setHorizontalAlignment(JLabel.CENTER);
        titolonegozio.setFont(subtitles);
        titolonegozio.setOpaque(true);

        bodynegozio.setBounds(0,50,240,110);
        bodynegozio.setLayout(null);
        bodynegozio.setBackground(pioppogreen);
        bodynegozio.setOpaque(true);

        staff.setText("NUMERO STAFF:  " + totstaff.size());
        staff.setBounds(15,10,180,20);
        staff.setFont(minortitles);
        staff.setEditable(false);
        staff.setBackground(null);
        staff.setForeground(pistacchioGreen);
        staff.setOpaque(true);

        categoriastaff.setText("NUMERO CATEGORIE:  " + totlavori.size());
        categoriastaff.setBounds(15,40,180,20);
        categoriastaff.setFont(minortitles);
        categoriastaff.setEditable(false);
        categoriastaff.setBackground(null);
        categoriastaff.setForeground(pistacchioGreen);
        categoriastaff.setOpaque(true);

        espandinegozio.setBounds(70,70,100,30);
        espandinegozio.setBorder(null);
        espandinegozio.setBackground(darkestgreen);
        espandinegozio.setText("ESPANDI");
        espandinegozio.setHorizontalAlignment(JButton.CENTER);
        espandinegozio.setVerticalAlignment(JButton.CENTER);
        espandinegozio.setForeground(pistacchioGreen);
        espandinegozio.setFont(minortitles);
        espandinegozio.addMouseListener(this);
        espandinegozio.addActionListener(this);
        espandinegozio.setFocusable(false);

        bodynegozio.add(staff);
        bodynegozio.add(categoriastaff);
        bodynegozio.add(espandinegozio);

        negozio.add(titolonegozio);
        negozio.add(bodynegozio);
    }
    public void setupmovimenti() throws IOException
    {
        movimenti.setLayout(null);
        movimenti.setBounds(335,150,240,380);
        movimenti.setBackground(null);
        movimenti.setOpaque(true);

        titolomovimenti.setBounds(0,0,240, 50);
        titolomovimenti.setBackground(darkestgreen);
        titolomovimenti.setForeground(pistacchioGreen);
        titolomovimenti.setVerticalAlignment(JLabel.CENTER);
        titolomovimenti.setHorizontalAlignment(JLabel.CENTER);
        titolomovimenti.setFont(subtitles);
        titolomovimenti.setOpaque(true);

        bodymovimenti.setBounds(0,50,240,280);
        bodymovimenti.setLayout(null);
        bodymovimenti.setBackground(pioppogreen);
        bodymovimenti.setForeground(pistacchioGreen);
        bodymovimenti.setFont(minortitles);
        bodymovimenti.setEditable(false);
        bodymovimenti.setOpaque(true);

        BufferedReader reader2 = new BufferedReader(new FileReader("Movimenti.txt"));

        String line2;

        while ((line2 = reader2.readLine()) != null)
        {
            bodymovimenti.append("    ●  " + line2 + "\n");
            totalecash += Integer.parseInt(line2);
        }

        reader2.close();

        totalemovimenti.setBounds(0,330,240, 50);
        totalemovimenti.setBackground(darkestgreen);
        totalemovimenti.setForeground(pistacchioGreen);
        totalemovimenti.setVerticalAlignment(JLabel.CENTER);
        totalemovimenti.setHorizontalAlignment(JLabel.CENTER);
        totalemovimenti.setFont(subtitles);
        totalemovimenti.setText("TOTALE:  €" + totalecash);
        totalemovimenti.setOpaque(true);

        movimenti.add(titolomovimenti);
        movimenti.add(bodymovimenti);
        movimenti.add(totalemovimenti);
    }
    public void setupclienti() throws IOException
    {
        clienti.setLayout(null);
        clienti.setBounds(620,150,240,380);
        clienti.setBackground(null);
        clienti.setOpaque(true);

        titoloclienti.setBounds(0,0,240, 50);
        titoloclienti.setBackground(darkestgreen);
        titoloclienti.setForeground(pistacchioGreen);
        titoloclienti.setVerticalAlignment(JLabel.CENTER);
        titoloclienti.setHorizontalAlignment(JLabel.CENTER);
        titoloclienti.setFont(subtitles);
        titoloclienti.setOpaque(true);

        bodyclienti.setBounds(0,50,240,280);
        bodyclienti.setLayout(null);
        bodyclienti.setBackground(pioppogreen);
        bodyclienti.setForeground(pistacchioGreen);
        bodyclienti.setFont(minortitles);
        bodyclienti.setEditable(false);
        bodyclienti.setOpaque(true);

        BufferedReader reader3 = new BufferedReader(new FileReader("credentials.txt"));
        String line;

        while(reader3.ready())
        {
            line = reader3.readLine();
            String[] arr = line.split(",");
            if(arr[2].equals("0"))
            {
                bodyclienti.append("    ●  " + arr[0] + "\n");
                totaleclients++;
            }
        }

        reader3.close();

        totaleclienti.setBounds(0,330,240, 50);
        totaleclienti.setBackground(darkestgreen);
        totaleclienti.setForeground(pistacchioGreen);
        totaleclienti.setVerticalAlignment(JLabel.CENTER);
        totaleclienti.setHorizontalAlignment(JLabel.CENTER);
        totaleclienti.setFont(subtitles);
        totaleclienti.setText("TOTALE:  " + totaleclients);
        totaleclienti.setOpaque(true);

        clienti.add(titoloclienti);
        clienti.add(bodyclienti);
        clienti.add(totaleclienti);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == espandimagazzino)
        {
            this.dispose();
            try
            {
                new GestioneMagazzino();
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == espandinegozio)
        {
            this.dispose();
            try
            {
                new GestioneNegozio();
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getSource() == espandimagazzino) espandimagazzino.setBackground(new Color(2,60,40));
        if(e.getSource() == espandinegozio) espandinegozio.setBackground(new Color(2,60,40));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource() == espandimagazzino) espandimagazzino.setBackground(darkestgreen);
        if(e.getSource() == espandinegozio) espandinegozio.setBackground(darkestgreen);
    }
}