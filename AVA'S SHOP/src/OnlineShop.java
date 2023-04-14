import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class OnlineShop extends JFrame implements MouseListener
{
    int contfrecce1 = 0, contfrecce2 = 0, contpiumeno = 1, contfile = 0, contfrecce3 = 0, numeroprodotti = 0, totale = 0, tempcont = 0;
    Color pistacchioGreen, darkestgreen, pioppogreen;
    Font titlefont, minortitles;
    JPanel motherpanel, pan1, pan2, pan3, pan4, pan5, sub1, sub2, sub3;
    JButton avanti1, indietro1, avanti2, indietro2, avanti3, indietro3, conferma1, conferma2, totalespesa, back, piu, meno;
    JLabel tit1, tit2, tit3, tit4, tit5, tit6, subtit1, subtit2, subtit3, titolo, totaleprodotti;
    JLabel body1, body2, body3;
    JTextArea body4, body5, body6, body7;
    JTextArea nome, categoria, prezzo, nome1, prezzo1, quantita, numeroeliminacarrello;
    JTextField qta;
    Border border;
    Set<String> setprodotti, setcategorie;
    ArrayList<String> arrayprodotti, arraycategorie, arrayprezzi;
    OnlineShop() throws IOException
    {
        setprodotti = new LinkedHashSet<>();
        setcategorie = new LinkedHashSet<>();

        arrayprodotti = new ArrayList<>();
        arraycategorie = new ArrayList<>();
        arrayprezzi = new ArrayList<>();

        border = BorderFactory.createLineBorder(pistacchioGreen, 2);

        pistacchioGreen = new Color(181,200,177);
        darkestgreen = new Color(4, 80, 53);
        pioppogreen = new Color(57, 112, 92);

        titlefont = new Font("Segoe UI Bold", Font.BOLD, 45);
        minortitles = new Font("Segoe UI Bold", Font.BOLD, 14);

        motherpanel = new JPanel();

        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        pan4 = new JPanel();
        pan5 = new JPanel();
        sub1 = new JPanel();
        sub2 = new JPanel();
        sub3 = new JPanel();

        avanti1 = new JButton("▶");
        avanti2 = new JButton("▶");
        avanti3 = new JButton("▶");
        indietro1 = new JButton("◀");
        indietro2 = new JButton("◀");
        indietro3 = new JButton("◀");
        conferma1 = new JButton("AGGIUNGI");
        conferma2 = new JButton("RIMUOVI");
        totalespesa = new JButton("TOTALE:  XX");
        back = new JButton("INDIETRO ↩");
        piu = new JButton("▲");
        meno = new JButton("▼");

        titolo = new JLabel();
        tit1 = new JLabel();
        tit2 = new JLabel();
        tit3 = new JLabel();
        tit4 = new JLabel();
        tit5 = new JLabel();
        tit6 = new JLabel();
        subtit1 = new JLabel();
        subtit2 = new JLabel();
        subtit3 = new JLabel();
        totaleprodotti = new JLabel();

        body1 = new JLabel();
        body2 = new JLabel();
        body3 = new JLabel();

        body4 = new JTextArea();
        body5 = new JTextArea();
        body6 = new JTextArea();
        body7 = new JTextArea();

        nome = new JTextArea();
        categoria = new JTextArea();
        prezzo = new JTextArea();
        nome1 = new JTextArea();
        prezzo1 = new JTextArea();
        quantita = new JTextArea();
        numeroeliminacarrello = new JTextArea();

        qta = new JTextField();

        motherpanel.setLayout(null);
        motherpanel.setBounds(0,0,910,650);
        motherpanel.setBackground(null);
        motherpanel.setOpaque(true);

        this.setTitle("NEGOZIO ONLINE");
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
            String[] arr = line.split(",");
            setprodotti.add(arr[0]);
            setcategorie.add(arr[1]);
            arrayprezzi.add(arr[2]);
        }
        arrayprodotti.addAll(setprodotti);
        arraycategorie.addAll(setcategorie);

        for(String name : arrayprodotti)
        {
            body4.append("    ●  " + name + "\n");
            numeroprodotti++;
        }

        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader("Carrello.txt"));

        while (reader1.readLine() != null)
        {
            contfile++;
        }

        reader1.close();

        titlesetup();
        setup1();
        setup2();
        setup3();
        setup4(numeroprodotti);
        setup5();

        motherpanel.add(pan1);
        motherpanel.add(pan2);
        motherpanel.add(pan3);
        motherpanel.add(pan4);
        motherpanel.add(pan5);
        motherpanel.add(titolo);

        this.add(motherpanel);

        this.setVisible(true);
    }
    public void titlesetup()
    {
        titolo.setText("NEGOZIO ONLINE");
        titolo.setFont(titlefont);
        titolo.setBounds(50,30,625,60);
        titolo.setForeground(darkestgreen);
    }
    public void setup1() throws IOException
    {
        String[] arr;
        pan1.setLayout(null);
        pan1.setBounds(40,105,260,130);
        pan1.setBackground(null);

        tit1.setBounds(0,0,260,50);
        tit1.setBackground(darkestgreen);
        tit1.setForeground(pistacchioGreen);
        tit1.setFont(minortitles);
        tit1.setHorizontalAlignment(JLabel.CENTER);
        tit1.setVerticalAlignment(JLabel.CENTER);
        tit1.setOpaque(true);

        indietro1.setBounds(0,0,50,50);
        indietro1.setBackground(null);                                          
        indietro1.setForeground(pistacchioGreen);
        indietro1.setFocusable(false);
        indietro1.setBorder(null);
        indietro1.addMouseListener(this);

        avanti1.setBounds(210,0,50,50);
        avanti1.setBackground(null);
        avanti1.setForeground(pistacchioGreen);
        avanti1.setFocusable(false);
        avanti1.setBorder(null);
        avanti1.addMouseListener(this);

        body1.setBounds(0,50,260,80);
        body1.setBackground(pioppogreen);
        body1.setOpaque(true);
        body1.setLayout(null);

        BufferedReader reader = new BufferedReader(new FileReader("Prodotti.txt"));
        String line = reader.readLine();
        if(line != null)
        {
            arr = line.split(",");
            nome.setText(" NOME:  " + arr[0]);
            prezzo.setText(" PREZZO:  €" + arr[2]);
            categoria.setText(" CATEGORIA:  " + arr[1]);
        }else
        {
            nome.setText(" NOME:  ");
            prezzo.setText(" PREZZO:  €");
            categoria.setText(" CATEGORIA:  ");
        }


        tit1.setText("PRODOTTO:  " + 0);

        nome.setBounds(10,5,240, 20);

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

        tit1.add(indietro1);
        tit1.add(avanti1);

        body1.add(nome);
        body1.add(prezzo);
        body1.add(categoria);

        pan1.add(tit1);
        pan1.add(body1);

        reader.close();
    }
    public void setup2() throws IOException
    {
        String[] arr;

        pan2.setBounds(40,250,260,180);
        pan2.setLayout(null);
        pan2.setBackground(null);

        tit2.setBounds(0,0,260,50);
        tit2.setBackground(darkestgreen);
        tit2.setForeground(pistacchioGreen);
        tit2.setFont(minortitles);
        tit2.setHorizontalAlignment(JLabel.CENTER);
        tit2.setVerticalAlignment(JLabel.CENTER);
        tit2.setOpaque(true);

        indietro2.setBounds(0,0,50,50);
        indietro2.setBackground(null);
        indietro2.setForeground(pistacchioGreen);
        indietro2.setFocusable(false);
        indietro2.setBorder(null);
        indietro2.addMouseListener(this);

        avanti2.setBounds(210,0,50,50);
        avanti2.setBackground(null);
        avanti2.setForeground(pistacchioGreen);
        avanti2.setFocusable(false);
        avanti2.setBorder(null);
        avanti2.addMouseListener(this);

        tit2.add(avanti2);
        tit2.add(indietro2);

        body2.setBounds(0,50,260,130);
        body2.setBackground(pioppogreen);
        body2.setOpaque(true);
        body2.setLayout(null);

        BufferedReader reader = new BufferedReader(new FileReader("Prodotti.txt"));
        String line = reader.readLine();
        if(line != null)
        {
            arr = line.split(",");
            nome1.setText(" NOME:  " + arr[0]);
            int valore = Integer.parseInt(arr[2]) * Integer.parseInt(qta.getText());
            prezzo1.setText(" TOTALE:  €" + valore);
        }else
        {
            nome1.setText(" NOME:  ");
            prezzo1.setText(" TOTALE:  €");
        }


        tit2.setText("PRODOTTO:  " + 0);

        nome1.setBounds(10,5,240, 20);

        nome1.setEditable(false);
        nome1.setBackground(null);
        nome1.setForeground(pistacchioGreen);
        nome1.setBorder(null);
        nome1.setFont(minortitles);

        quantita.setBounds(10,35,100, 20);
        quantita.setText(" QUANTITA':");
        quantita.setEditable(false);
        quantita.setBackground(null);
        quantita.setForeground(pistacchioGreen);
        quantita.setBorder(null);
        quantita.setFont(minortitles);

        qta.setBounds(110, 33, 25, 25);
        qta.setBorder(null);
        qta.setBackground(null);
        qta.setForeground(pistacchioGreen);
        qta.setCaretColor(pistacchioGreen);
        qta.setFont(minortitles);
        qta.setHorizontalAlignment(JTextField.CENTER);
        qta.setText("1");
        qta.setEditable(false);

        piu.setBounds(140,29,15,15);
        piu.setBackground(null);
        piu.setForeground(pistacchioGreen);
        piu.setFocusable(false);
        piu.setBorder(null);
        piu.addMouseListener(this);

        meno.setBounds(140,46,15,15);
        meno.setBackground(null);
        meno.setForeground(pistacchioGreen);
        meno.setFocusable(false);
        meno.setBorder(null);
        meno.addMouseListener(this);



        prezzo1.setBounds(10,65,180, 20);

        prezzo1.setEditable(false);
        prezzo1.setBackground(null);
        prezzo1.setForeground(pistacchioGreen);
        prezzo1.setBorder(null);
        prezzo1.setFont(minortitles);

        conferma1.setBounds(80,90,100,30);
        conferma1.setBorder(null);
        conferma1.setBackground(darkestgreen);
        conferma1.setHorizontalAlignment(JButton.CENTER);
        conferma1.setVerticalAlignment(JButton.CENTER);
        conferma1.setForeground(pistacchioGreen);
        conferma1.setFont(minortitles);
        conferma1.setFocusable(false);
        conferma1.addMouseListener(this);

        body2.add(nome1);
        body2.add(quantita);
        body2.add(qta);
        body2.add(prezzo1);
        body2.add(piu);
        body2.add(meno);
        body2.add(conferma1);

        pan2.add(tit2);
        pan2.add(body2);

        reader.close();
    }
    public void setup3() throws IOException
    {
        pan3.setBounds(40,445,260,130);
        pan3.setLayout(null);
        pan3.setBackground(null);

        tit3.setBounds(0,0,260,50);
        tit3.setBackground(darkestgreen);
        tit3.setForeground(pistacchioGreen);
        tit3.setFont(minortitles);
        tit3.setHorizontalAlignment(JLabel.CENTER);
        tit3.setVerticalAlignment(JLabel.CENTER);
        tit3.setOpaque(true);
        tit3.setText("PRODOTTO:  " + contfrecce3);

        indietro3.setBounds(0,0,50,50);
        indietro3.setBackground(null);
        indietro3.setForeground(pistacchioGreen);
        indietro3.setFocusable(false);
        indietro3.setBorder(null);
        indietro3.addMouseListener(this);

        avanti3.setBounds(210,0,50,50);
        avanti3.setBackground(null);
        avanti3.setForeground(pistacchioGreen);
        avanti3.setFocusable(false);
        avanti3.setBorder(null);
        avanti3.addMouseListener(this);

        BufferedReader reader = new BufferedReader(new FileReader("Carrello.txt"));

        String line = reader.readLine();

        if(line != null)
        {
            String[] vett = line.split(",");
            numeroeliminacarrello.setText(" PRODOTTO:  " + vett[0]);
        }else numeroeliminacarrello.setText(" PRODOTTO:  ");

        reader.close();

        numeroeliminacarrello.setBounds(10,10,240,20);
        numeroeliminacarrello.setBackground(null);
        numeroeliminacarrello.setForeground(pistacchioGreen);
        numeroeliminacarrello.setBorder(null);
        numeroeliminacarrello.setFont(minortitles);

        conferma2.setBounds(80,40,100,30);
        conferma2.setBorder(null);
        conferma2.setBackground(darkestgreen);
        conferma2.setHorizontalAlignment(JButton.CENTER);
        conferma2.setVerticalAlignment(JButton.CENTER);
        conferma2.setForeground(pistacchioGreen);
        conferma2.setFont(minortitles);
        conferma2.setFocusable(false);
        conferma2.addMouseListener(this);

        body3.setBounds(0,50,260,80);
        body3.setBackground(pioppogreen);
        body3.setOpaque(true);
        body3.setLayout(null);

        tit3.add(avanti3);
        tit3.add(indietro3);

        body3.add(numeroeliminacarrello);
        body3.add(conferma2);

        pan3.add(tit3);
        pan3.add(body3);
    }
    public void setup4(int numeroprodotti)
    {
        pan4.setLayout(null);
        pan4.setBounds(320,105,230,470);
        pan4.setBackground(Color.red);

        tit4.setBounds(0,0,230,50);
        tit4.setBackground(darkestgreen);
        tit4.setForeground(pistacchioGreen);
        tit4.setFont(minortitles);
        tit4.setHorizontalAlignment(JLabel.CENTER);
        tit4.setVerticalAlignment(JLabel.CENTER);
        tit4.setText("PRODOTTI");
        tit4.setOpaque(true);

        body4.setBounds(0,50,230,370);
        body4.setBackground(pioppogreen);
        body4.setEditable(false);
        body4.setForeground(pistacchioGreen);
        body4.setFont(minortitles);
        body4.setOpaque(true);
        body4.setLayout(null);

        totaleprodotti.setBounds(0,420,230,50);
        totaleprodotti.setBackground(darkestgreen);
        totaleprodotti.setForeground(pistacchioGreen);
        totaleprodotti.setFont(minortitles);
        totaleprodotti.setHorizontalAlignment(JLabel.CENTER);
        totaleprodotti.setVerticalAlignment(JLabel.CENTER);
        totaleprodotti.setText("TOTALE:  " + numeroprodotti);
        totaleprodotti.setOpaque(true);

        pan4.add(tit4);
        pan4.add(body4);
        pan4.add(totaleprodotti);
    }
    public void setup5() throws IOException
    {
        pan5.setBounds(570, 105, 300, 470);
        pan5.setLayout(null);
        pan5.setBackground(null);

        tit5.setBounds(0,0,300,50);
        tit5.setBackground(darkestgreen);
        tit5.setForeground(pistacchioGreen);
        tit5.setFont(minortitles);
        tit5.setHorizontalAlignment(JLabel.CENTER);
        tit5.setVerticalAlignment(JLabel.CENTER);
        tit5.setText("CARRELLO");
        tit5.setOpaque(true);

        subtit1.setBounds(0,52,181,30);
        subtit1.setBackground(darkestgreen);
        subtit1.setForeground(pistacchioGreen);
        subtit1.setFont(minortitles);
        subtit1.setHorizontalAlignment(JLabel.CENTER);
        subtit1.setVerticalAlignment(JLabel.CENTER);
        subtit1.setText("PRODOTTO");
        subtit1.setOpaque(true);

        body5.setBounds(0,82,181,338);
        body5.setBackground(pioppogreen);
        body5.setForeground(pistacchioGreen);
        body5.setFont(minortitles);
        body5.setCaretColor(pistacchioGreen);
        body5.setEditable(false);
        body5.setOpaque(true);

        subtit2.setBounds(183,52,50,30);
        subtit2.setBackground(darkestgreen);
        subtit2.setForeground(pistacchioGreen);
        subtit2.setFont(minortitles);
        subtit2.setHorizontalAlignment(JLabel.CENTER);
        subtit2.setVerticalAlignment(JLabel.CENTER);
        subtit2.setText("QTA'");
        subtit2.setOpaque(true);

        body6.setBounds(183,82,50,338);
        body6.setBackground(pioppogreen);
        body6.setForeground(pistacchioGreen);
        body6.setCaretColor(pistacchioGreen);
        body6.setEditable(false);
        body6.setFont(minortitles);
        body6.setOpaque(true);

        subtit3.setBounds(235,52,65,30);
        subtit3.setBackground(darkestgreen);
        subtit3.setForeground(pistacchioGreen);
        subtit3.setFont(minortitles);
        subtit3.setHorizontalAlignment(JLabel.CENTER);
        subtit3.setVerticalAlignment(JLabel.CENTER);
        subtit3.setText("TOT");
        subtit3.setOpaque(true);

        body7.setBounds(235,82,65,338);
        body7.setBackground(pioppogreen);
        body7.setForeground(pistacchioGreen);
        body7.setCaretColor(pistacchioGreen);
        body7.setEditable(false);
        body7.setFont(minortitles);
        body7.setOpaque(true);

        totalespesa.setBounds(0,420,300,50);
        totalespesa.setBackground(darkestgreen);
        totalespesa.setForeground(pistacchioGreen);
        totalespesa.setFocusable(false);
        totalespesa.setBorder(null);
        totalespesa.setFont(minortitles);
        totalespesa.setHorizontalAlignment(JLabel.CENTER);
        totalespesa.setVerticalAlignment(JLabel.CENTER);
        totalespesa.setOpaque(true);
        totalespesa.addMouseListener(this);

        BufferedReader reader = new BufferedReader(new FileReader("Carrello.txt"));

        String line;

        while ((line = reader.readLine()) != null)
        {
            String[] arr = line.split(",");

            body5.append("   ●  " + arr[0] + "\n");
            body6.append(arr[1] + "\n");
            body7.append(arr[2] + "\n");
        }

        reader.close();

        String[] array = body7.getText().split("\n");

        totale = 0;

        if(array.length != 1)
        {
            for (String s : array)
            {
                totale += Integer.parseInt(s);
            }
        }

        totalespesa.setText("TOTALE:  €" + totale);

        pan5.add(tit5);
        pan5.add(subtit1);
        pan5.add(body5);
        pan5.add(subtit2);
        pan5.add(body6);
        pan5.add(subtit3);
        pan5.add(body7);
        pan5.add(totalespesa);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getSource() == avanti1 && contfrecce1 < arrayprodotti.size() -1)
        {
            contfrecce1++;

            if(contfrecce1 < arrayprodotti.size())
            {
                tit1.setText("PRODOTTO:  " + contfrecce1);
                nome.setText(" NOME:  " + arrayprodotti.get(contfrecce1));
                prezzo.setText(" PREZZO:  €" + arrayprezzi.get(contfrecce1));

                BufferedReader reader;

                try
                {
                    reader = new BufferedReader(new FileReader("Prodotti.txt"));
                    String cate = "";
                    while (reader.ready())
                    {
                        String line = reader.readLine();
                        String[] arr = line.split(",");
                        if(arr[0].equalsIgnoreCase(arrayprodotti.get(contfrecce1)))
                        {
                            cate = arr[1];
                            break;
                        }
                    }
                    categoria.setText(" CATEGORIA:  " + cate);
                    reader.close();
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        if(e.getSource() == indietro1 && contfrecce1 != 0)
        {
            contfrecce1--;

            tit1.setText("PRODOTTO:  " + contfrecce1);
            nome.setText(" NOME:  " + arrayprodotti.get(contfrecce1));
            prezzo.setText(" PREZZO:  €" + arrayprezzi.get(contfrecce1));

            BufferedReader reader;

            try
            {
                reader = new BufferedReader(new FileReader("Prodotti.txt"));
                String cate = "";
                while (reader.ready())
                {
                    String line = reader.readLine();
                    String[] arr = line.split(",");
                    if(arr[0].equalsIgnoreCase(arrayprodotti.get(contfrecce1)))
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
        if(e.getSource() == avanti2 && contfrecce2 < arrayprodotti.size() -1)
        {
            contfrecce2++;
            contpiumeno = 1;

            if(contfrecce2 < arrayprodotti.size())
            {
                qta.setText(String.valueOf(1));

                tit2.setText("PRODOTTO:  " + contfrecce2);
                nome1.setText(" NOME:  " + arrayprodotti.get(contfrecce2));
                prezzo1.setText(" TOTALE:  €" + arrayprezzi.get(contfrecce2));
            }
        }
        if(e.getSource() == indietro2 && contfrecce2 != 0)
        {
            contfrecce2--;
            contpiumeno = 1;

            qta.setText(String.valueOf(1));

            tit2.setText("PRODOTTO:  " + contfrecce2);
            nome1.setText(" NOME:  " + arrayprodotti.get(contfrecce2));
            prezzo1.setText(" TOTALE:  €" + arrayprezzi.get(contfrecce2));
        }
        if(e.getSource() == piu)
        {
            contpiumeno++;

            qta.setText(String.valueOf(contpiumeno));

            int num1 = Integer.parseInt(arrayprezzi.get(contfrecce2));
            int num2 = Integer.parseInt(qta.getText());

            int tot = num1 * num2;

            prezzo1.setText(" TOTALE:  €" + tot);
        }
        if(e.getSource() == meno)
        {
            contpiumeno--;

            qta.setText(String.valueOf(contpiumeno));

            int num1 = Integer.parseInt(arrayprezzi.get(contfrecce2));
            int num2 = Integer.parseInt(qta.getText());

            prezzo1.setText(" TOTALE:  €" + num1 * num2);
        }
        if(e.getSource() == conferma1)
        {
            if(tempcont == 0)
            {
                String[] a = nome1.getText().split(": {2}");
                numeroeliminacarrello.setText(" PRODOTTO:  " + a[1]);
            }
            tempcont++;
            try
            {
                totale = 0;

                FileWriter writer = new FileWriter("Carrello.txt", true);

                String[] temp = nome1.getText().split(": {2}");
                String[] temp1 = prezzo1.getText().split("€");

                writer.write(temp[1] + "," + qta.getText() + "," + temp1[1] + "," + contfile + "\n");

                contfile++;

                body5.append("   ●  " + temp[1] + "\n");
                body6.append(qta.getText() + "\n");
                body7.append(temp1[1] + "\n");

                String[] array = body7.getText().split("\n");

                for (String s : array) totale += Integer.parseInt(s);

                totalespesa.setText("TOTALE:  €" + totale);

                writer.close();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == avanti3 && contfrecce3 <= contfile)
        {
            contfrecce3++;

            if(contfrecce3 < contfile)
            {
                try
                {
                    tit3.setText("PRODOTTO:  " + contfrecce3);

                    BufferedReader reader = new BufferedReader(new FileReader("Carrello.txt"));

                    String line;

                    int i = 0;

                    while ((line = reader.readLine()) != null)
                    {
                        i++;

                        if (i <= contfrecce3) continue;

                        String[] vett = line.split(",");
                        numeroeliminacarrello.setText(" PRODOTTO:  " + vett[0]);
                        break;
                    }
                } catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            } else contfrecce3--;
        }
        if(e.getSource() == indietro3 && contfrecce3 != 0)
        {
            try
            {
                contfrecce3--;
                tit3.setText("PRODOTTO:  " + contfrecce3);

                BufferedReader reader = new BufferedReader(new FileReader("Carrello.txt"));

                String line;

                int i = 0;

                while ((line = reader.readLine()) != null)
                {
                    i++;

                    if(i <= contfrecce3) continue;

                    String[] vett = line.split(",");
                    numeroeliminacarrello.setText(" PRODOTTO:  " + vett[0]);
                    break;
                }
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == conferma2)
        {
            contfile--;

            rimuoviriga(contfrecce3);
            try
            {
                this.dispose();
                new OnlineShop();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == totalespesa)
        {
            contfile = 0;

            FileWriter writer;
            String text = totalespesa.getText();
            String[] txt = text.split(": {2}€");

            try
            {
                writer = new FileWriter("Movimenti.txt", true);
                writer.write("+" + txt[1] + "\n");
                writer.close();


                FileWriter writer1 = new FileWriter("Carrello.txt", false);
                writer1.write("");
                writer1.close();

                this.dispose();
                new OnlineShop();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }
    public void rimuoviriga(int numeroriga)
    {
        try
        {
            int cont = -1;

            FileWriter writer = new FileWriter("Temp_carrello.txt");
            BufferedReader reader = new BufferedReader(new FileReader("Carrello.txt"));

            String line;

            writer.write("");

            while ((line = reader.readLine()) != null)
            {
                cont++;
                if(cont != numeroriga) writer.append(line).append("\n");
            }

            writer.close();
            reader.close();

            FileWriter writer1 = new FileWriter("Carrello.txt");
            BufferedReader reader1 = new BufferedReader(new FileReader("Temp_carrello.txt"));

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
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) //JButton avanti1, indietro1, avanti2, indietro2, avanti3, indietro3, conferma1, conferma2, totalespesa, back, piu, meno;
    {
        if(e.getSource() == avanti1) avanti1.setBackground(new Color(2,60,40));
        if(e.getSource() == indietro1) indietro1.setBackground(new Color(2,60,40));
        if(e.getSource() == avanti2) avanti2.setBackground(new Color(2,60,40));
        if(e.getSource() == indietro2) indietro2.setBackground(new Color(2,60,40));
        if(e.getSource() == avanti3) avanti3.setBackground(new Color(2,60,40));
        if(e.getSource() == indietro3) indietro3.setBackground(new Color(2,60,40));
        if(e.getSource() == conferma1) conferma1.setBackground(new Color(2,60,40));
        if(e.getSource() == conferma2) conferma2.setBackground(new Color(2,60,40));
        if(e.getSource() == totalespesa) totalespesa.setBackground(new Color(2,60,40));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource() == avanti1) avanti1.setBackground(darkestgreen);
        if(e.getSource() == indietro1) indietro1.setBackground(darkestgreen);
        if(e.getSource() == avanti2) avanti2.setBackground(darkestgreen);
        if(e.getSource() == indietro2) indietro2.setBackground(darkestgreen);
        if(e.getSource() == avanti3) avanti3.setBackground(darkestgreen);
        if(e.getSource() == indietro3) indietro3.setBackground(darkestgreen);
        if(e.getSource() == conferma1) conferma1.setBackground(darkestgreen);
        if(e.getSource() == conferma2) conferma2.setBackground(darkestgreen);
        if(e.getSource() == totalespesa) totalespesa.setBackground(darkestgreen);
    }
}
