import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NuovoStaff extends JFrame implements MouseListener
{
    Color pistacchioGreen, darkestgreen, pioppogreen;
    Font titlefont, subtitles, minortitles;
    JPanel motherpanel, sonpanel;
    JLabel title, minortitle, body;
    JTextArea nome, categoria, prezzo;
    JTextField nomef, categoriaf, prezzof;
    JButton conferma, indietro;
    Border border;
    NuovoStaff()
    {
        border = BorderFactory.createLineBorder(pistacchioGreen, 2);

        pistacchioGreen = new Color(181,200,177);
        darkestgreen = new Color(4, 80, 53);
        pioppogreen = new Color(57, 112, 92);

        titlefont = new Font("Segoe UI Bold", Font.BOLD, 45);
        subtitles = new Font("Segoe UI Bold", Font.BOLD, 19);
        minortitles = new Font("Segoe UI Bold", Font.BOLD, 15);

        motherpanel = new JPanel();
        sonpanel = new JPanel();

        title = new JLabel();
        minortitle = new JLabel();
        body = new JLabel();

        conferma = new JButton("CONFERMA");
        indietro = new JButton("INDIETRO");

        nome = new JTextArea("NOME: ");
        categoria = new JTextArea("CATEGORIA: ");
        prezzo = new JTextArea("CONTRATTO: ");

        nomef = new JTextField();
        categoriaf = new JTextField();
        prezzof = new JTextField();

        motherpanel.setBounds(0,0,910,650);
        motherpanel.setLayout(null);
        motherpanel.setBackground(null);

        sonpanel.setBounds(240,160,430,360);
        sonpanel.setLayout(null);
        sonpanel.setBackground(null);

        body.setBounds(0,60, 430,240);
        body.setBackground(pioppogreen);
        body.setOpaque(true);

        nome.setBounds(50,37,100,30);
        nome.setFont(subtitles);
        nome.setEditable(false);
        nome.setForeground(pistacchioGreen);
        nome.setCaretColor(pistacchioGreen);
        nome.setBackground(null);

        nomef.setBounds(180,37,200,30);
        nomef.setFont(minortitles);
        nomef.setEditable(true);
        nomef.setForeground(pistacchioGreen);
        nomef.setCaretColor(pistacchioGreen);
        nomef.setBackground(null);
        nomef.setBorder(border);

        categoria.setBounds(50,104,120,30);
        categoria.setFont(subtitles);
        categoria.setEditable(false);
        categoria.setForeground(pistacchioGreen);
        categoria.setCaretColor(pistacchioGreen);
        categoria.setBackground(null);

        categoriaf.setBounds(180,104,200,30);
        categoriaf.setFont(minortitles);
        categoriaf.setEditable(true);
        categoriaf.setForeground(pistacchioGreen);
        categoriaf.setCaretColor(pistacchioGreen);
        categoriaf.setBackground(null);
        categoriaf.setBorder(border);

        prezzo.setBounds(50,171,120,30);
        prezzo.setFont(subtitles);
        prezzo.setEditable(false);
        prezzo.setForeground(pistacchioGreen);
        prezzo.setCaretColor(pistacchioGreen);
        prezzo.setBackground(null);

        prezzof.setBounds(180,171,200,30);
        prezzof.setFont(minortitles);
        prezzof.setEditable(true);
        prezzof.setForeground(pistacchioGreen);
        prezzof.setCaretColor(pistacchioGreen);
        prezzof.setBackground(null);
        prezzof.setBorder(border);

        conferma.setBounds(0, 305, 211, 55);
        conferma.setBorder(null);
        conferma.setBackground(darkestgreen);
        conferma.setForeground(pistacchioGreen);
        conferma.setFont(subtitles);
        conferma.addMouseListener(this);
        conferma.setFocusable(false);

        indietro.setBounds(217, 305, 213, 55);
        indietro.setBorder(null);
        indietro.setBackground(darkestgreen);
        indietro.setForeground(pistacchioGreen);
        indietro.setFont(subtitles);
        indietro.addMouseListener(this);
        indietro.setFocusable(false);

        minortitle.setBounds(0,0,430,55);
        minortitle.setBackground(darkestgreen);
        minortitle.setForeground(pistacchioGreen);
        minortitle.setText("NUOVO STAFF");
        minortitle.setHorizontalAlignment(JLabel.CENTER);
        minortitle.setVerticalAlignment(JLabel.CENTER);
        minortitle.setOpaque(true);
        minortitle.setFont(subtitles);

        titlesetup();

        this.setTitle("NUOVO STAFF");
        this.setSize(910, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(pistacchioGreen);
        this.setResizable(false);

        body.add(nome);
        body.add(nomef);
        body.add(categoria);
        body.add(categoriaf);
        body.add(prezzo);
        body.add(prezzof);

        sonpanel.add(minortitle);
        sonpanel.add(body);
        sonpanel.add(conferma);
        sonpanel.add(indietro);

        motherpanel.add(title);
        motherpanel.add(sonpanel);

        this.add(motherpanel);

        this.setVisible(true);
    }
    public void titlesetup()
    {
        title.setText("AGGIUNGI STAFF");
        title.setFont(titlefont);
        title.setBounds(50,30,590,60);
        title.setForeground(darkestgreen);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getSource() == indietro)
        {
            try
            {
                this.dispose();
                new GestioneNegozio();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == conferma)
        {
            BufferedReader reader;
            try
            {
                if (nomef.getText().equals("") || categoriaf.getText().equals("") || prezzof.getText().equals("") || !isnumero(prezzof))
                {
                    JOptionPane.showMessageDialog(null, "Campi inseriti non validi", "Staff Management", JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    reader = new BufferedReader(new FileReader("Staff.txt"));
                    String line;
                    boolean trovatostaff = false;

                    while ((line = reader.readLine()) != null)
                    {
                        String[] array = line.split(",");
                        if (array[0].equals(nomef.getText()) && array[1].equals(categoriaf.getText())) trovatostaff = true;
                    }
                    if (trovatostaff)
                    {
                        JOptionPane.showMessageDialog(null, "staff già esistente", "Staff Management", JOptionPane.PLAIN_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "staff aggiunto correttamente", "Staff Management", JOptionPane.PLAIN_MESSAGE);

                        FileWriter writer = new FileWriter("Staff.txt", true);
                        writer.write(nomef.getText().toUpperCase() + "," + categoriaf.getText().toUpperCase() + "," + prezzof.getText().toUpperCase() + "," + GestioneNegozio.numerostaff() + "\n");
                        writer.close();

                        FileWriter writer1 = new FileWriter("Movimenti.txt", true);
                        writer1.write("-" + prezzof.getText() + "\n");
                        writer1.close();

                        this.dispose();
                        new GestioneNegozio();
                    }
                }
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }
    public boolean isnumero(JTextField textArea)
    {
        try
        {
            Double.parseDouble(textArea.getText().trim());
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getSource() == conferma) conferma.setBackground(new Color(2,60,40));
        if(e.getSource() == indietro) indietro.setBackground(new Color(2,60,40));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource() == conferma) conferma.setBackground(darkestgreen);
        if(e.getSource() == indietro) indietro.setBackground(darkestgreen);
    }
}