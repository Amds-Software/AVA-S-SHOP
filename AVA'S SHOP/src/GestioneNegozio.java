import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class GestioneNegozio extends JFrame implements MouseListener, ActionListener
{
    static int totstaff = 0;
    static int totcategorie = 0;
    int cont1 = 0, cont2 = 0, cont3 = 0;
    String line;
    Set<String> categorie;
    Set<String> staffs;
    ArrayList<String> categoriaarraylist, staffarraylist, prezziarraylist;
    Color pistacchioGreen, darkestgreen, pioppogreen;
    JPanel motherpanel;
    JPanel vedistaff, eliminastaff, eliminacategoria, listastaff, listacategorie;
    JLabel body1, body2, body3;
    JLabel titolo, titololista, titoloeliminastaff, titoloeliminacategoria, titololistastaff, titololistacategorie;
    JLabel totalestaff, totalecategorie;
    JTextArea nome, prezzo, categoria;
    JTextArea nomeeliminastaff, nomeeliminacategoria, body4, body5;
    JButton avanti1, indietro, avanti2, indietro2, conferma1, avanti3, indietro3, conferma2, aggiungistaff, back;
    Font titlefont, subtitles, minortitles;
    GestioneNegozio() throws IOException
    {
        titlefont = new Font("Segoe UI Bold", Font.BOLD, 45);
        subtitles = new Font("Segoe UI Bold", Font.BOLD, 14);
        minortitles = new Font("Segoe UI Bold", Font.BOLD, 14);

        pistacchioGreen = new Color(181,200,177);
        darkestgreen = new Color(4, 80, 53);
        pioppogreen = new Color(57, 112, 92);

        motherpanel = new JPanel();

        vedistaff = new JPanel();
        eliminastaff = new JPanel();
        eliminacategoria = new JPanel();
        listastaff = new JPanel();
        listacategorie = new JPanel();

        staffs = new LinkedHashSet<>();
        categorie = new LinkedHashSet<>();

        titololista = new JLabel("STAFF:  XX");
        titoloeliminastaff = new JLabel("ELIMINA STAFF");
        titoloeliminacategoria = new JLabel("ELIMINA CATEGORIA");
        titololistastaff = new JLabel("STAFF");
        titololistacategorie = new JLabel("CATEGORIE");

        totalestaff = new JLabel("TOTALE:  XX");
        totalecategorie = new JLabel("TOTALE:  XX");

        titolo = new JLabel();

        body1 = new JLabel();
        body2 = new JLabel();
        body3 = new JLabel();

        nome = new JTextArea();
        prezzo = new JTextArea();
        categoria = new JTextArea();
        nomeeliminastaff = new JTextArea();
        nomeeliminacategoria = new JTextArea();
        body4 = new JTextArea();
        body5 = new JTextArea();

        avanti1 = new JButton("▶");
        indietro = new JButton("◀");
        avanti2 = new JButton("▶");
        indietro2 = new JButton("◀");
        avanti3 = new JButton("▶");
        indietro3 = new JButton("◀");
        conferma1 = new JButton("ELIMINA");
        conferma2 = new JButton("ELIMINA");
        aggiungistaff = new JButton("➕");
        back = new JButton("INDIETRO ↩");

        prezziarraylist = new ArrayList<>();

        motherpanel.setLayout(null);
        motherpanel.setBounds(0,0,910,650);
        motherpanel.setBackground(null);
        motherpanel.setOpaque(true);

        this.setTitle("GESTIONE NEGOZIO");
        this.setSize(910, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(pistacchioGreen);
        this.setResizable(false);

        titlesetup();
        listasettings();
        eliminastaffsetup();
        eliminacategoriasetup();
        listastaffsetup();
        listacategoriesetup();

        back.setBounds(730,40,120,45);
        back.setBorder(null);
        back.setBackground(darkestgreen);
        back.setForeground(pistacchioGreen);
        back.setFocusable(false);
        back.addMouseListener(this);

        motherpanel.add(titolo);
        motherpanel.add(back);
        motherpanel.add(vedistaff);
        motherpanel.add(eliminastaff);
        motherpanel.add(eliminacategoria);
        motherpanel.add(listastaff);
        motherpanel.add(listacategorie);

        this.add(motherpanel);
        this.setVisible(true);
    }
    public void titlesetup()
    {
        titolo.setText("GESTIONE NEGOZIO");
        titolo.setFont(titlefont);
        titolo.setBounds(50,30,625,60);
        titolo.setForeground(darkestgreen);
    }
    public void listasettings() throws IOException
    {
        String[] arr;

        vedistaff.setLayout(null);
        vedistaff.setBounds(50,115,260,130);
        vedistaff.setBackground(null);

        titololista.setBounds(0,0,260,50);
        titololista.setBackground(darkestgreen);
        titololista.setForeground(pistacchioGreen);
        titololista.setFont(subtitles);
        titololista.setHorizontalAlignment(JLabel.CENTER);
        titololista.setVerticalAlignment(JLabel.CENTER);
        titololista.setOpaque(true);

        indietro.setBounds(0,0,50,50);
        indietro.setBackground(null);
        indietro.setForeground(pistacchioGreen);
        indietro.setFocusable(false);
        indietro.setBorder(null);
        indietro.addActionListener(this);
        indietro.addMouseListener(this);

        avanti1.setBounds(210,0,50,50);
        avanti1.setBackground(null);
        avanti1.setForeground(pistacchioGreen);
        avanti1.setFocusable(false);
        avanti1.setBorder(null);
        avanti1.addActionListener(this);
        avanti1.addMouseListener(this);

        body1.setBounds(0,50,260,80);
        body1.setBackground(pioppogreen);
        body1.setOpaque(true);
        body1.setLayout(null);

        BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"));
        String line = reader.readLine();

        if(line != null)
        {
            arr = line.split(",");
            nome.setText(" NOME:  " + arr[0]);
            prezzo.setText(" CONTRATTO:  " + arr[2]);
            categoria.setText(" CATEGORIA:  " + arr[1]);
        } else
        {
            nome.setText(" NOME:  ");
            prezzo.setText(" CONTRATTO:  ");
            categoria.setText(" CATEGORIA:  ");
        }

        titololista.setText("STAFF:  " + 0);

        nome.setBounds(10,5,230, 20);

        nome.setEditable(false);
        nome.setBackground(null);
        nome.setForeground(pistacchioGreen);
        nome.setBorder(null);
        nome.setFont(minortitles);

        prezzo.setBounds(10,25,230, 20);

        prezzo.setEditable(false);
        prezzo.setBackground(null);
        prezzo.setForeground(pistacchioGreen);
        prezzo.setBorder(null);
        prezzo.setFont(minortitles);

        categoria.setBounds(10,45,230, 20);

        categoria.setEditable(false);
        categoria.setBackground(null);
        categoria.setForeground(pistacchioGreen);
        categoria.setBorder(null);
        categoria.setFont(minortitles);

        titololista.add(indietro);
        titololista.add(avanti1);

        body1.add(nome);
        body1.add(prezzo);
        body1.add(categoria);

        vedistaff.add(titololista);
        vedistaff.add(body1);
    }
    public void eliminastaffsetup() throws IOException
    {
        String[] arr;
        eliminastaff.setLayout(null);
        eliminastaff.setBounds(50,270,260,135);

        BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"));

        String line = reader.readLine();

        if(line != null)
        {
            arr = line.split(",");
            nomeeliminastaff.setText(" NOME:  " + arr[0]);
        } else nomeeliminastaff.setText(" NOME:  ");

        titoloeliminastaff.setText(" STAFF:  " + 0);

        titoloeliminastaff.setBounds(0,0,260,50);
        titoloeliminastaff.setBackground(darkestgreen);
        titoloeliminastaff.setForeground(pistacchioGreen);
        titoloeliminastaff.setFont(subtitles);
        titoloeliminastaff.setHorizontalAlignment(JLabel.CENTER);
        titoloeliminastaff.setVerticalAlignment(JLabel.CENTER);
        titoloeliminastaff.setOpaque(true);

        indietro2.setBounds(0,0,50,50);
        indietro2.setBackground(null);
        indietro2.setForeground(pistacchioGreen);
        indietro2.setFocusable(false);
        indietro2.setBorder(null);
        indietro2.addActionListener(this);
        indietro2.addMouseListener(this);

        avanti2.setBounds(210,0,50,50);
        avanti2.setBackground(null);
        avanti2.setForeground(pistacchioGreen);
        avanti2.setFocusable(false);
        avanti2.setBorder(null);
        avanti2.addActionListener(this);
        avanti2.addMouseListener(this);

        body2.setBounds(0,50,260,85);
        body2.setBackground(pioppogreen);
        body2.setOpaque(true);
        body2.setLayout(null);

        conferma1.setBounds(80,40,100,35);
        conferma1.setBorder(null);
        conferma1.setBackground(darkestgreen);
        conferma1.setHorizontalAlignment(JButton.CENTER);
        conferma1.setVerticalAlignment(JButton.CENTER);
        conferma1.setForeground(pistacchioGreen);
        conferma1.setFont(minortitles);
        conferma1.setFocusable(false);
        conferma1.addActionListener(this);
        conferma1.addMouseListener(this);

        nomeeliminastaff.setBounds(10,10,230, 20);
        nomeeliminastaff.setEditable(false);
        nomeeliminastaff.setBackground(null);
        nomeeliminastaff.setForeground(pistacchioGreen);
        nomeeliminastaff.setBorder(null);
        nomeeliminastaff.setFont(minortitles);

        body2.add(conferma1);
        body2.add(nomeeliminastaff);

        titoloeliminastaff.add(indietro2);
        titoloeliminastaff.add(avanti2);

        eliminastaff.add(titoloeliminastaff);
        eliminastaff.add(body2);
    }
    public void eliminacategoriasetup() throws IOException
    {
        String[] arr;

        eliminacategoria.setLayout(null);
        eliminacategoria.setBounds(50,430,260,135);

        BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"));

        String line = reader.readLine();

        if(line != null)
        {
            arr = line.split(",");
            nomeeliminacategoria.setText(" NOME:  " + arr[1]);
        } else nomeeliminacategoria.setText(" NOME:  ");

        titoloeliminacategoria.setText(" CATEGORIA:  " + 0);

        titoloeliminacategoria.setBounds(0,0,260,50);
        titoloeliminacategoria.setBackground(darkestgreen);
        titoloeliminacategoria.setForeground(pistacchioGreen);
        titoloeliminacategoria.setFont(subtitles);
        titoloeliminacategoria.setHorizontalAlignment(JLabel.CENTER);
        titoloeliminacategoria.setVerticalAlignment(JLabel.CENTER);
        titoloeliminacategoria.setOpaque(true);

        indietro3.setBounds(0,0,50,50);
        indietro3.setBackground(null);
        indietro3.setForeground(pistacchioGreen);
        indietro3.setFocusable(false);
        indietro3.setBorder(null);
        indietro3.addActionListener(this);
        indietro3.addMouseListener(this);

        avanti3.setBounds(210,0,50,50);
        avanti3.setBackground(null);
        avanti3.setForeground(pistacchioGreen);
        avanti3.setFocusable(false);
        avanti3.setBorder(null);
        avanti3.addActionListener(this);
        avanti3.addMouseListener(this);

        body3.setBounds(0,50,260,85);
        body3.setBackground(pioppogreen);
        body3.setOpaque(true);
        body3.setLayout(null);

        conferma2.setBounds(80,40,100,35);
        conferma2.setBorder(null);
        conferma2.setBackground(darkestgreen);
        conferma2.setHorizontalAlignment(JButton.CENTER);
        conferma2.setVerticalAlignment(JButton.CENTER);
        conferma2.setForeground(pistacchioGreen);
        conferma2.setFont(minortitles);
        conferma2.setFocusable(false);
        conferma2.addActionListener(this);
        conferma2.addMouseListener(this);

        nomeeliminacategoria.setBounds(10,10,230, 20);

        nomeeliminacategoria.setEditable(false);
        nomeeliminacategoria.setBackground(null);
        nomeeliminacategoria.setForeground(pistacchioGreen);
        nomeeliminacategoria.setBorder(null);
        nomeeliminacategoria.setFont(minortitles);

        body3.add(conferma2);
        body3.add(nomeeliminacategoria);

        titoloeliminacategoria.add(indietro3);
        titoloeliminacategoria.add(avanti3);

        eliminacategoria.add(titoloeliminacategoria);
        eliminacategoria.add(body3);
    }
    public void listastaffsetup() throws IOException
    {
        listastaff.setLayout(null);
        listastaff.setBounds(350,115,230,450);

        titololistastaff.setBounds(0,0,230,50);
        titololistastaff.setBackground(darkestgreen);
        titololistastaff.setForeground(pistacchioGreen);
        titololistastaff.setFont(subtitles);
        titololistastaff.setHorizontalAlignment(JLabel.CENTER);
        titololistastaff.setVerticalAlignment(JLabel.CENTER);
        titololistastaff.setOpaque(true);

        aggiungistaff.setBounds(180,0,50,50);
        aggiungistaff.setBackground(null);
        aggiungistaff.setForeground(pistacchioGreen);
        aggiungistaff.setFocusable(false);
        aggiungistaff.setBorder(null);
        aggiungistaff.addActionListener(this);
        aggiungistaff.addMouseListener(this);

        body4.setBounds(0,50,230,350);
        body4.setBackground(pioppogreen);
        body4.setEditable(false);
        body4.setForeground(pistacchioGreen);
        body4.setFont(minortitles);
        body4.setOpaque(true);
        body4.setLayout(null);

        staffarraylist = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"));

        while(reader.ready())
        {
            line = reader.readLine();
            String[] arr = line.split(",");
            staffs.add(arr[0]);
        }
        for(String name : staffs)
        {
            body4.append("    ●  " + name + "\n");
            staffarraylist.add(name);
        }

        totstaff = staffs.size();

        totalestaff.setBounds(0,400,230,50);
        totalestaff.setBackground(darkestgreen);
        totalestaff.setForeground(pistacchioGreen);
        totalestaff.setFont(subtitles);
        totalestaff.setHorizontalAlignment(JLabel.CENTER);
        totalestaff.setVerticalAlignment(JLabel.CENTER);
        totalestaff.setText("TOTALE:  " + totstaff);
        totalestaff.setOpaque(true);

        titololistastaff.add(aggiungistaff);

        listastaff.add(titololistastaff);
        listastaff.add(body4);
        listastaff.add(totalestaff);
    }
    public void listacategoriesetup() throws IOException
    {
        listacategorie.setLayout(null);
        listacategorie.setBounds(620,115,230,450);

        titololistacategorie.setBounds(0,0,230,50);
        titololistacategorie.setBackground(darkestgreen);
        titololistacategorie.setForeground(pistacchioGreen);
        titololistacategorie.setFont(subtitles);
        titololistacategorie.setHorizontalAlignment(JLabel.CENTER);
        titololistacategorie.setVerticalAlignment(JLabel.CENTER);
        titololistacategorie.setOpaque(true);

        body5.setBounds(0,50,230,350);
        body5.setBackground(pioppogreen);
        body5.setOpaque(true);
        body5.setEditable(false);
        body5.setForeground(pistacchioGreen);
        body5.setFont(minortitles);
        body5.setLayout(null);

        categoriaarraylist = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"));

        while(reader.ready())
        {
            line = reader.readLine();
            String[] arr = line.split(",");
            categorie.add(arr[1]);
            prezziarraylist.add(arr[2]);
        }
        for(String name : categorie)
        {
            body5.append("    ●  " + name + "\n");
            categoriaarraylist.add(name);
        }

        totcategorie = categorie.size();

        totalecategorie.setBounds(0,400,230,50);
        totalecategorie.setBackground(darkestgreen);
        totalecategorie.setForeground(pistacchioGreen);
        totalecategorie.setFont(subtitles);
        totalecategorie.setHorizontalAlignment(JLabel.CENTER);
        totalecategorie.setVerticalAlignment(JLabel.CENTER);
        totalecategorie.setText("TOTALE:  " + totcategorie);
        totalecategorie.setOpaque(true);


        listacategorie.add(titololistacategorie);
        listacategorie.add(body5);
        listacategorie.add(totalecategorie);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}
    public void rimuovirighe()
    {
        try
        {
            String[] arr = nomeeliminacategoria.getText().split("\\s+");

            categoriaarraylist.remove(nomeeliminastaff.getText());
            categorie.remove(nomeeliminastaff.getText());

            FileWriter writer = new FileWriter("Temp_staff.txt");
            BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"));

            String line;

            writer.write("");

            while ((line = reader.readLine()) != null)
            {
                String[] array = line.split(",");
                if(!array[1].equals(arr[2])) writer.append(line).append("\n");
            }

            writer.close();
            reader.close();

            FileWriter writer1 = new FileWriter("Staff.txt");
            BufferedReader reader1 = new BufferedReader(new FileReader("Temp_staff.txt"));

            String line1;

            writer1.write("");

            while ((line1 = reader1.readLine()) != null) writer1.append(line1).append("\n");

            writer1.close();
            reader1.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void rimuoviriga(int numeroriga)
    {
        try
        {
            staffarraylist.remove(nomeeliminastaff.getText());
            staffs.remove(nomeeliminastaff.getText());

            int cont = -1;

            FileWriter writer = new FileWriter("Temp_staff.txt");
            BufferedReader reader = new BufferedReader(new FileReader("Staff.txt"));

            String line;

            writer.write("");

            while ((line = reader.readLine()) != null)
            {
                cont++;
                if(cont != numeroriga) writer.append(line).append("\n");
            }

            writer.close();
            reader.close();

            FileWriter writer1 = new FileWriter("Staff.txt");
            BufferedReader reader1 = new BufferedReader(new FileReader("Temp_staff.txt"));

            String line1;

            writer1.write("");

            while ((line1 = reader1.readLine()) != null) writer1.append(line1).append("\n");

            writer1.close();
            reader1.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getSource() == avanti1 && cont1 < staffarraylist.size() -1)
        {
            cont1++;

            if(cont1 < staffarraylist.size())
            {
                titololista.setText(" STAFF:  " + cont1);
                nome.setText(" NOME:  " + staffarraylist.get(cont1));
                prezzo.setText(" CONTRATTO:  " + prezziarraylist.get(cont1));

                BufferedReader reader;

                try
                {
                    reader = new BufferedReader(new FileReader("Staff.txt"));
                    String cate = "";
                    while (reader.ready())
                    {
                        String line = reader.readLine();
                        String[] arr = line.split(",");
                        if(arr[0].equalsIgnoreCase(staffarraylist.get(cont1)))
                        {
                            cate = arr[1];
                            break;
                        }
                    }
                    categoria.setText(" CATEGORIA:  " + cate);
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        if(e.getSource() == indietro && cont1 != 0)
        {
            cont1--;

            titololista.setText(" STAFF:  " + cont1);
            nome.setText(" NOME:  " + staffarraylist.get(cont1));
            prezzo.setText(" CONTRATTO:  " + prezziarraylist.get(cont1));

            BufferedReader reader;

            try
            {
                reader = new BufferedReader(new FileReader("Staff.txt"));
                String cate = "";
                while (reader.ready())
                {
                    String line = reader.readLine();
                    String[] arr = line.split(",");
                    if(arr[0].equalsIgnoreCase(staffarraylist.get(cont1)))
                    {
                        cate = arr[1];
                        break;
                    }
                }
                categoria.setText(" CATEGORIA:  " + cate);
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource() == avanti2 && cont2 < staffarraylist.size() -1)
        {
            cont2++;

            if(cont2 < staffarraylist.size())
            {
                titoloeliminastaff.setText(" STAFF:  " + cont2);
                nomeeliminastaff.setText(" NOME:  " + staffarraylist.get(cont2));
            }
        }
        if(e.getSource() == indietro2 && cont2 != 0)
        {
            cont2--;

            titoloeliminastaff.setText(" STAFF:  " + cont2);
            nomeeliminastaff.setText(" NOME:  " + staffarraylist.get(cont2));
        }

        if(e.getSource() == avanti3 && cont3 < categoriaarraylist.size() -1)
        {
            cont3++;

            if(cont3 < categoriaarraylist.size())
            {
                titoloeliminacategoria.setText(" CATEGORIA:  " + cont3);
                nomeeliminacategoria.setText(" NOME:  " + categoriaarraylist.get(cont3));
            }
        }
        if(e.getSource() == indietro3 && cont3 != 0)
        {
            cont3--;

            titoloeliminacategoria.setText(" CATEGORIA:  " + cont3);
            nomeeliminacategoria.setText(" NOME:  " + categoriaarraylist.get(cont3));
        }
        if(e.getSource() == conferma1)
        {
            rimuoviriga(cont2);
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
        if(e.getSource() == conferma2)
        {
            rimuovirighe();
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
        if(e.getSource() == aggiungistaff)
        {
            this.dispose();
            new NuovoStaff();
        }
        if(e.getSource() == back)
        {
            rimuovirighe();
            try
            {
                this.dispose();
                new ControlPanel();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(e.getSource() == avanti1) avanti1.setBackground(new Color(2,60,40));
        if(e.getSource() == avanti2) avanti2.setBackground(new Color(2,60,40));
        if(e.getSource() == avanti3) avanti3.setBackground(new Color(2,60,40));
        if(e.getSource() == indietro) indietro.setBackground(new Color(2,60,40));
        if(e.getSource() == indietro2) indietro2.setBackground(new Color(2,60,40));
        if(e.getSource() == indietro3) indietro3.setBackground(new Color(2,60,40));
        if(e.getSource() == conferma1) conferma1.setBackground(new Color(2,60,40));
        if(e.getSource() == conferma2) conferma2.setBackground(new Color(2,60,40));
        if(e.getSource() == aggiungistaff) aggiungistaff.setBackground(new Color(2,60,40));
        if(e.getSource() == back) back.setBackground(new Color(2,60,40));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource() == avanti1) avanti1.setBackground(darkestgreen);
        if(e.getSource() == avanti2) avanti2.setBackground(darkestgreen);
        if(e.getSource() == avanti3) avanti3.setBackground(darkestgreen);
        if(e.getSource() == indietro) indietro.setBackground(darkestgreen);
        if(e.getSource() == indietro2) indietro2.setBackground(darkestgreen);
        if(e.getSource() == indietro3) indietro3.setBackground(darkestgreen);
        if(e.getSource() == conferma1) conferma1.setBackground(darkestgreen);
        if(e.getSource() == conferma2) conferma2.setBackground(darkestgreen);
        if(e.getSource() == aggiungistaff) aggiungistaff.setBackground(darkestgreen);
        if(e.getSource() == back) back.setBackground(darkestgreen);
    }

    public static int numerostaff()
    {
        return totstaff;
    }
}