package gui;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import product.*;
import emporium.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MainWin extends JFrame 
{
    public MainWin()
    {
        super("Mavs Ice Cream Emporium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        emporium = new Emporium();
        this.filename = filename;
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
        //scoopcreate.setEnabled(false);
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

        JToolBar toolbar = new JToolBar("Ice cream Controls");
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("gui/save-file.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        //ImageIcon t = new ImageIcon("gui/save-file.png");
        //t.getImage();
        //t.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        JButton save = new JButton(imageIcon);
        save.setActionCommand("save");
        save.setToolTipText("Save to write all the data to the current filename");
        //save.setBorder(null);
        toolbar.add(save);
        save.addActionListener(event -> onSaveClick());

        toolbar.add(Box.createHorizontalStrut(25));
        ImageIcon icon1 = new ImageIcon(new ImageIcon("gui/save-as.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton saveas = new JButton(icon1);
        saveas.setActionCommand("save-as");
        saveas.setToolTipText("Save as to change the current filename");
        //saveas.setBorder(null);
        toolbar.add(saveas);
        saveas.addActionListener(event -> onSaveAsClick());

        ImageIcon icon2 = new ImageIcon(new ImageIcon("gui/open.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        JButton open = new JButton(icon2);
        open.setActionCommand("open");
        open.setToolTipText("open the filename");
        //open.setBorder(null);
        toolbar.add(open);
        open.addActionListener(event -> onOpenClick());

        ImageIcon icon3 = new ImageIcon(new ImageIcon("gui/ice-cream.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton creamcreate  = new JButton(icon3);
        creamcreate.setActionCommand("create a ice cream flavor");
        creamcreate.setToolTipText("create a Ice Cream Flavor");
        //creamcreate.setBorder(null);
        toolbar.add(creamcreate);
        creamcreate.addActionListener(event -> onCreateIceCreamFlavorClick());

        ImageIcon icon4 = new ImageIcon(new ImageIcon("gui/sprinkles.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton mixcreate = new JButton(icon4);
        mixcreate.setActionCommand("Mix In");
        mixcreate.setToolTipText("Create Mix In Flavor");
        //mixcreate.setBorder(null);
        toolbar.add(mixcreate);
        mixcreate.addActionListener(event -> onCreateMixInFlavorClick());


        ImageIcon icon5 = new ImageIcon(new ImageIcon("gui/ice-cream-cup.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton createscop = new JButton(icon5);
        createscop.setActionCommand("Scoop");
        createscop.setToolTipText("Create Scoop");
        //createscop.setBorder(null);
        toolbar.add(createscop);
        createscop.addActionListener(event -> onCreateScoopClick());

        ImageIcon icon6 = new ImageIcon(new ImageIcon("gui/ice-cream.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton creamview = new JButton(icon6);
        creamview.setActionCommand("View Ice Cream");
        creamview.setToolTipText("View Ice Cream Flavors");
        //creamview.setBorder(null);
        toolbar.add(creamview);
        creamview.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));

        ImageIcon icon7 = new ImageIcon(new ImageIcon("gui/sprinkles.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton mixview = new JButton(icon7);
        mixview.setActionCommand("View Mix In");
        mixview.setToolTipText("View Mix In Flavors");
        //mixview.setBorder(null);
        toolbar.add(mixview);
        mixview.addActionListener(event ->view(Screen.MIX_IN_FLAVORS) );

        ImageIcon icon8 = new ImageIcon(new ImageIcon("gui/ice-cream-cup.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton viewscop = new JButton(icon8);
        viewscop.setActionCommand("View Scoop");
        viewscop.setToolTipText("View Scoop");
        //viewscop.setBorder(null);
        toolbar.add(viewscop);
        viewscop.addActionListener(event -> view(Screen.SCOOPS));

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        display.setVerticalAlignment(JLabel.TOP);
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
        //scoopcreate.setEnabled(true);
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

        
        try {
            //Canvas can = new Canvas();
            //label.setIcon(new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
            BufferedImage myPicture = ImageIO.read(new File("gui/Untitled_Artwork.jpg"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            logo.setPreferredSize(new Dimension(300, 100));
            about.add(new Canvas());
            about.add(logo);

        } catch(IOException e) {
        }
        JLabel title = new JLabel("<html>"
          + "<br/><p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(title);

        JLabel subTitle = new JLabel("<html>"
          + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(subTitle);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Version 0.3</p>"
          + "<p>Copyright 2022 by Siddharth Bhagvagar</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "Logo by Schmidsi, per the Pixabay License"
          + "<p><font size=-2>https://pixabay.com/en/ice-ice-cream-cone-ice-ball-pink-1429596/</font></p>"
          + "<br/></html>", JLabel.CENTER);
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
            Object[] arr = emporium.scoops();
            display.setText("<html>" +"<p>SCOOPS</p>" + Arrays.toString(arr).replace("[","").replace("]", "").replaceAll(" ", " ")
                + "</html>");
        }
        
    }

    public void onCreateScoopClick()
    {
        /*
        Object[] arr = emporium.iceCreamFlavors();
        ImageIcon icon = new ImageIcon("Untitled_Artwork.jpg");
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
        boolean cor = false;
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
            if(arr2 == null)
            {
                cor = true;
            }
            

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
    while(i < temp.length || cor != true);
        emporium.addScoop(cop);
        view(Screen.SCOOPS);
    */
        
        IceCreamFlavor icf = (IceCreamFlavor) JOptionPane.showInputDialog(this, 
            "Ice Cream Flavor?", "New Scoop", JOptionPane.QUESTION_MESSAGE, null, 
            emporium.iceCreamFlavors(), null);
        if(icf != null) {
            Scoop scoop = new Scoop(icf);
            if(emporium.mixInFlavors().length > 0) {
                String prompt = "<html>" + scoop + "<br/>Add a mix in?</html>";
                while(true) {
                    MixInFlavor mif = (MixInFlavor) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        emporium.mixInFlavors(), null);
                    if(mif == null) break;
                    MixInAmount mia = (MixInAmount) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        MixInAmount.values(), MixInAmount.Normal);
                    scoop.addMixIn(new MixIn(mif, mia));
                    prompt = "<html>" + scoop + "<br/>Add another mix in?</html>";
                }
            }
            emporium.addScoop(scoop);
            view(Screen.SCOOPS);

    }
    }

    public void onSaveClick()
    {   
         try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            //bw.write(MAGIC_COOKIE + '\n');
            //bw.write(FILE_VERSION + '\n');
            emporium.save(out);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    
    }

    public void onSaveAsClick()
    {   
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("mice files", "mice");
        fc.addChoosableFileFilter(miceFiles);         // Add "Nim file" filter
        fc.setFileFilter(miceFiles);                  // Show Nim files only by default
        
        int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();         // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith(".mice"))  // Ensure it ends with ".nim"
                filename = new File(filename.getAbsolutePath() + ".mice");
            onSaveClick();                       // Delegate to Save method
        }
        
    }

    public void onOpenClick()
    {   
        
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("mice files", "mice");
        fc.addChoosableFileFilter(miceFiles);         // Add "Nim file" filter
        fc.setFileFilter(miceFiles);                  // Show Nim files only by default
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                Emporium emporium = new Emporium(br);
                
                //view();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
       
    }

    private enum Screen {
    ICE_CREAM_FLAVORS,
    MIX_IN_FLAVORS,
    SCOOPS
    }

    private File filename;
    private JLabel display;
    public Emporium emporium; 

}