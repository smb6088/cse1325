package gui;


import java.awt.*;
import javax.swing.*;
import product.*;
import emporium.*;

public class MainWin extends JFrame 
{
    public MainWin()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);


        //menu

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");
        JMenu view = new JMenu("View");
        JMenuItem icecreamview = new JMenuItem("Ice Cream Flavor");
        JMenuItem mixinview = new JMenuItem("Mix In Flavor");
        JMenuItem scoopview = new JMenuItem("Scoop");
        JMenu create = new JMenu("Create");
        JMenuItem icecreamcreate = new JMenuItem("Ice Cream Flavor");
        JMenuItem mixincreate = new JMenuItem("Mix In Flavor");
        JMenuItem scoopcreate = new JMenuItem("Scoop");
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event-> onQuitClick());
        icecreamview.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        mixinview.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        scoopview.addActionListener(event -> view(Screen.SCOOPS));
        icecreamcreate.addActionListener(event -> onCreateIceCreamFlavorClick());
        mixincreate.addActionListener(event -> onCreateMixInFlavorClick());
        scoopcreate.addActionListener(event -> onCreateScoopClick());
        about.addActionListener(event -> onAboutClick());

        file.add(quit);
        view.add(icecreamview);
        view.add(mixinview);
        view.add(scoopview);
        create.add(icecreamcreate);
        create.add(mixincreate);
        create.add(scoopcreate);
        help.add(about);

        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        setJMenuBar(menubar);
        emporium =  new Emporium();
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);
        setVisible(true);
    }

    public void onQuitClick()
    {
        System.exit(0);
    }

    public void onCreateIceCreamFlavorClick()
    {
        String name = JOptionPane.showInputDialog(this,
            "Name?");
        String description = JOptionPane.showInputDialog(this,
            "Description?");
        int price = Integer.parseInt(JOptionPane.showInputDialog(this,
            "Price?"));
        int cost = Integer.parseInt(JOptionPane.showInputDialog(this,
            "Cost?"));

        IceCreamFlavor addicecream = new IceCreamFlavor(name, description, cost, price);
        emporium.addIceCreamFlavor(addicecream);
    }

    public void onCreateMixInFlavorClick()
    {
        String name = JOptionPane.showInputDialog(this,"Name?");
        String description = JOptionPane.showInputDialog(this,"Description?");
        int price = Integer.parseInt(JOptionPane.showInputDialog(this,"Price?"));
        int cost = Integer.parseInt(JOptionPane.showInputDialog(this,"Cost?"));

        MixInFlavor mixinadd = new MixInFlavor(name, description, cost, price);
        emporium.addMixInFlavor(mixinadd);
         //JList b= new JList(emporium.iceCreamFlavors());


    }

    public void onAboutClick()
    {
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Ice cream");
        
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Ice Cream</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 1.00</p>"
          + "<p> fake Copyright 2022-2100 by Siddahrt M. Bhagavagar</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
    }

    public void view(Screen screen)
    {
          display.setIcon(null);  // remove the splash image if present
        display.setHorizontalAlignment(JLabel.LEFT);
        display.setVerticalAlignment(JLabel.TOP);
        if(Screen.ICE_CREAM_FLAVORS == screen)
        {
            display.setText("<html>" +"<p>ICE_CREAM_FLAVORS</p>" + emporium.iceCreamFlavors()
                              + "</html>");
        }
        else if(Screen.MIX_IN_FLAVORS == screen)
        {
            display.setText("<html>" + "<p>MIX_IN_FLAVORS</p>"+ emporium.mixInFlavors()
                              + "</html>");
        }
        else
        {
            display.setText("<html>" + "<p>SCOOPS</p>"+emporium.scoops()
                              + "</html>");
        }
        
    }

    public void onCreateScoopClick(){

    }
    private enum Screen {
    ICE_CREAM_FLAVORS,
    MIX_IN_FLAVORS,
    SCOOPS;
    }

    private JLabel display;
    public Emporium emporium; 

}