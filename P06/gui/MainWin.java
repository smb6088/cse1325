package gui;

import java.util.*;
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
        this.emporium = new Emporium();

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
        
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);
        setVisible(true);
        //scoopcreate.setEnabled(false);

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
        String sprice = JOptionPane.showInputDialog(this,
            "Price?");
        int price = Integer.parseInt(sprice);

        String scost = JOptionPane.showInputDialog(this,
            "Cost?");
        int cost = Integer.parseInt(scost);

        IceCreamFlavor addicecream = new IceCreamFlavor(name, description, cost, price);
        emporium.addIceCreamFlavor(addicecream);
        view(Screen.ICE_CREAM_FLAVORS);
    }

    public void onCreateMixInFlavorClick()
    {
        String name = JOptionPane.showInputDialog(this,
            "Name?");
        String description = JOptionPane.showInputDialog(this,"Description?");
        int price = Integer.parseInt(JOptionPane.showInputDialog(this,"Price?"));
        int cost = Integer.parseInt(JOptionPane.showInputDialog(this,"Cost?"));

        MixInFlavor mixinadd = new MixInFlavor(name, description, cost, price);
        emporium.addMixInFlavor(mixinadd);
        view(Screen.MIX_IN_FLAVORS);


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
            Object[] arr = emporium.iceCreamFlavors();
            display.setText("<html>" +"<p>ICE_CREAM_FLAVORS</p>" + Arrays.toString(arr).replace("[","").replace("]", "").replaceAll(",", "<br/>")
                + "</html>");
        }
        else if(Screen.MIX_IN_FLAVORS == screen)
        {
           Object[] arr = emporium.mixInFlavors();
            display.setText("<html>" +"<p>MIX_IN_FLAVORS</p>" + Arrays.toString(arr).replace("[","").replace("]", "").replaceAll(",", "<br/>")
                + "</html>");
           }
        else if(Screen.SCOOPS == screen)
        {
            Object[] arr = emporium.scooop();
            display.setText("<html>" +"<p>SCOOPS</p>" + Arrays.toString(arr).replace("[","").replace("]", "").replaceAll(" ", " ")
                + "</html>");
        }
        
    }

    public void onCreateScoopClick(){

        Object[] arr = emporium.iceCreamFlavors();
        ImageIcon icon = new ImageIcon("P06/gui/Untitled_Artwork.jpg");
        Object name = (Object) JOptionPane.showInputDialog(this,
           "Selecte Ice Cream Flavor",
           "Creating a Scoop",
           JOptionPane.OK_CANCEL_OPTION,
           icon,
           arr,
           arr[0]);
        IceCreamFlavor ice = (IceCreamFlavor) name;
        if(ice == null)
        {
            System.err.println("Ice Cream not selected");
        }
        Scoop cop = new Scoop(ice);
        int i =0;
        Object[] temp = emporium.mixInFlavors();
    do
    {
        Object[] arr2 = emporium.mixInFlavors();
        ImageIcon icon2 = new ImageIcon("P06/gui/Untitled_Artwork.jpg");
        Object mix = (Object) JOptionPane.showInputDialog(this,
           "Selecte Mix Cream Flavor",
           "Creating a Scoop",
           JOptionPane.OK_CANCEL_OPTION,
           icon2,
           arr2,
           arr2[0]);

            MixInFlavor mixu = (MixInFlavor) mix;
            

        Object[] arr3 = MixInAmount.values();
        ImageIcon icon3 = new ImageIcon("P06/gui/Untitled_Artwork.jpg");
        Object amount = (Object) JOptionPane.showInputDialog(this,
           "Selecte Ice Cream Flavor",
           "Creating a Scoop",
           JOptionPane.OK_CANCEL_OPTION,
           icon3,
           arr3,
           arr3[0]);
            MixInAmount mout = (MixInAmount) amount;
        MixIn enmix = new MixIn(mixu,mout);

        i++;

        cop.addMixIn(enmix);
    }
    while(i < temp.length);
        emporium.addScoop(cop);
        view(Screen.SCOOPS);


    }
    private enum Screen {
    ICE_CREAM_FLAVORS,
    MIX_IN_FLAVORS,
    SCOOPS;
    }

    private JLabel display;
    public Emporium emporium; 

}