package gui;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.BorderLayout;
import java.awt.Font;

import java.io.File;
import java.io.IOException;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;
import product.Serving;
import product.Container;
import product.Order;

import emporium.Emporium;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainWin extends JFrame {

    private final String NAME = "MICE";
    private final String EXTENSION = "mice";
    private final String VERSION = "0.3";
    private final String FILE_VERSION = "1.0";
    //private final String MAGIC_COOKIE = "Mïċ";

    public MainWin() {
        super("Mavs Ice Cream Emporium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 800);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file         = new JMenu("File");
        JMenuItem open         = new JMenuItem("Open");
                  save         = new JMenuItem("Save");
                  saveAs       = new JMenuItem("Save As");
        JMenuItem quit         = new JMenuItem("Quit");
        JMenu     view         = new JMenu("View");
        JMenuItem viewICF      = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMIF      = new JMenuItem("Mix In Flavor");
        //JMenuItem viewScoop    = new JMenuItem("Scoop");
        JMenu     create       = new JMenu("Create");
        JMenuItem createICF    = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMIF    = new JMenuItem("Mix In Flavor");
        JMenuItem createorder  = new JMenuItem("Order");
        JMenuItem createcontainer = new JMenuItem("Container");
        JMenu     help         = new JMenu("Help");
        JMenuItem about        = new JMenuItem("About");
        
        open       .addActionListener(event -> onOpenClick());
        save       .addActionListener(event -> onSaveClick());
        saveAs     .addActionListener(event -> onSaveAsClick());
        quit       .addActionListener(event -> onQuitClick());
        viewICF    .addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMIF    .addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        createICF  .addActionListener(event -> onCreateIceCreamFlavorClick());
        createMIF  .addActionListener(event -> onCreateMixInFlavorClick());
        createorder.addActionListener(event -> onCreateOrderClick());
        createcontainer.addActionListener(event -> onCreateContainerClick());
        about      .addActionListener(event -> onAboutClick());

        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(quit);
        view.add(viewICF);
        view.add(viewMIF);
        create.add(createICF);
        create.add(createMIF);
        create.add(createorder);
        create.add(createcontainer);
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Mice Controls");

       // Add a New Emporium icon
        saveButton  = new JButton(new ImageIcon("gui/save.png"));
          saveButton.setActionCommand("Save data to default file");
          saveButton.setToolTipText("Save data to default file");
          saveButton.setEnabled(false);
          saveButton.addActionListener(event -> onSaveClick());
          toolbar.add(saveButton);
        
        saveAsButton  = new JButton(new ImageIcon("gui/save_as.png"));
          saveAsButton.setActionCommand("Save data to selected file");
          saveAsButton.setToolTipText("Save data to selected file");
          saveAsButton.addActionListener(event -> onSaveAsClick());
          toolbar.add(saveAsButton);
        
        JButton openButton  = new JButton(new ImageIcon("gui/open.png"));
          openButton.setActionCommand("Load data from selected file");
          openButton.setToolTipText("Load data from selected file");
          openButton.addActionListener(event -> onOpenClick());
          toolbar.add(openButton);
        
        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));


        // Create the product buttons using the icons provided
        JButton createContainerButton  = new JButton(new ImageIcon("gui/createScoopButton.png"));
          createContainerButton.setActionCommand("New Container");
          createContainerButton.setToolTipText("New Container");
          toolbar.add(createContainerButton);
          createContainerButton.addActionListener(event -> onCreateContainerClick());

        JButton createIceCreamFlavorButton  = new JButton(new ImageIcon("gui/createIceCreamFlavorButton.png"));
          createIceCreamFlavorButton.setActionCommand("New ice cream flavor");
          createIceCreamFlavorButton.setToolTipText("Create new ice cream flavor");
          toolbar.add(createIceCreamFlavorButton);
          createIceCreamFlavorButton.addActionListener(event -> onCreateIceCreamFlavorClick());

        JButton createMixInFlavorButton  = new JButton(new ImageIcon("gui/createMixInFlavorButton.png"));
          createMixInFlavorButton.setActionCommand("New mix in flavor");
          createMixInFlavorButton.setToolTipText("New mix in flavor");
          toolbar.add(createMixInFlavorButton);
          createMixInFlavorButton.addActionListener(event -> onCreateMixInFlavorClick());

        JButton createOrderButton  = new JButton(new ImageIcon("gui/createScoopButton.png"));
          createOrderButton.setActionCommand("New order");
          createOrderButton.setToolTipText("New Order");
          toolbar.add(createOrderButton);
          createOrderButton.addActionListener(event -> onCreateOrderClick());

        toolbar.add(Box.createHorizontalStrut(25));
        
        JButton viewContainerButton  = new JButton(new ImageIcon("gui/viewScoopsButton.png"));
          viewContainerButton.setActionCommand("View Containers");
          viewContainerButton.setToolTipText("View Containers");
          toolbar.add(viewContainerButton);
          viewContainerButton.addActionListener(event -> view(Screen.CONTAINER));

        JButton viewIceCreamFlavorsButton  = new JButton(new ImageIcon("gui/viewIceCreamFlavorsButton.png"));
          viewIceCreamFlavorsButton.setActionCommand("View ice cream flavors");
          viewIceCreamFlavorsButton.setToolTipText("View ice cream flavors");
          toolbar.add(viewIceCreamFlavorsButton);
          viewIceCreamFlavorsButton.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));

        JButton viewMixInFlavorsButton  = new JButton(new ImageIcon("gui/viewMixInFlavorsButton.png"));
          viewMixInFlavorsButton.setActionCommand("View mix in flavors");
          viewMixInFlavorsButton.setToolTipText("View mix in flavors");
          toolbar.add(viewMixInFlavorsButton);
          viewMixInFlavorsButton.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));

        JButton viewOrderButton  = new JButton(new ImageIcon("gui/viewScoopsButton.png"));
          viewOrderButton.setActionCommand("View Orders");
          viewOrderButton.setToolTipText("View Orders");
          toolbar.add(viewOrderButton);
          viewOrderButton.addActionListener(event -> view(Screen.ORDERS));

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        // /////////////////////////// ////////////////////////////////////////////
        // M A I N   D I S P L A Y
        // Provide a text entry box to show data
        display = new JLabel();
        display.setVerticalAlignment(JLabel.TOP);
        display.setFont(new Font("Courier New", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        // msg = new JLabel();
        // add(msg, BorderLayout.PAGE_END);
        
        // Make everything in the JFrame visible
        setVisible(true);
        
        // Start a new emporium
        emporium = new Emporium();
        filename = new File("untitled." + EXTENSION);
        setDirty(false);     // disables Save when no new data exists
        // disables new Scoop when no ice cream flavors exist
        view(Screen.ICE_CREAM_FLAVORS);   
    }
    
    // Listeners
    protected void onQuitClick() {System.exit(0);}   // Exit the game
    

    protected void onCreateIceCreamFlavorClick() {
        try {
            JLabel name = new JLabel("<HTML><br/>Name</HTML>");
            JTextField names = new JTextField(20);

            JLabel description = new JLabel("<HTML><br/>Description</HTML>");
            JTextField descriptions = new JTextField(20);

            JLabel num = new JLabel("<HTML><br/>Cost</HTML>");
            SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
            JSpinner nums = new JSpinner(range);

            JLabel num2 = new JLabel("<HTML><br/>Price</HTML>");
            SpinnerModel range2 = new SpinnerNumberModel(0, 0, 100, 1);
            JSpinner nums2 = new JSpinner(range2);

            Object[] objects = { 
                name,   names, 
                description, descriptions, 
                num,    nums,
                num2, nums2};

            int button = JOptionPane.showConfirmDialog( // Show the dialog
                this,
                objects,
                "New Ice Cream Flavor",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null);

            if(button == JOptionPane.OK_OPTION){
                int maxu = (Integer) nums.getValue();
                int maxu2 = (Integer) nums2.getValue();
                emporium.addIceCreamFlavor(new IceCreamFlavor(names.getText(), descriptions.getText(), maxu, maxu2));
            }
        }catch(Exception e) {
            System.err.println("onCreateIceCreamFlavorClick exception: " + e);
        }
        try {
            setDirty(true);
            view(Screen.ICE_CREAM_FLAVORS);         
        } catch(Exception e) {
            System.err.println("onCreateIceCreamFlavorClick exception: " + e);
        }

    }
    protected void onCreateMixInFlavorClick() {
        try {
            JLabel name = new JLabel("<HTML><br/>Name</HTML>");
            JTextField names = new JTextField(20);

            JLabel description = new JLabel("<HTML><br/>Description</HTML>");
            JTextField descriptions = new JTextField(20);

            JLabel num = new JLabel("<HTML><br/>Cost</HTML>");
            SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
            JSpinner nums = new JSpinner(range);

            JLabel num2 = new JLabel("<HTML><br/>Price</HTML>");
            SpinnerModel range2 = new SpinnerNumberModel(0, 0, 100, 1);
            JSpinner nums2 = new JSpinner(range2);

            Object[] objects = { 
                name,   names, 
                description, descriptions, 
                num,    nums,
                num2, nums2};

            int button = JOptionPane.showConfirmDialog( // Show the dialog
                this,
                objects,
                "New Mix In Flavor",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null);

            if(button == JOptionPane.OK_OPTION){
                int maxu = (Integer) nums.getValue();
                int maxu2 = (Integer) nums2.getValue();
                emporium.addMixInFlavor(new MixInFlavor(names.getText(), descriptions.getText(), maxu, maxu2));
            }
            setDirty(true);
            view(Screen.MIX_IN_FLAVORS);
        }catch(Exception e) {
            System.err.println("onCreateMixInFlavorClick exception: " + e);
        }
    }
    protected void onCreateContainerClick(){
        try {
            JLabel name = new JLabel("<HTML><br/>Name</HTML>");
            JTextField names = new JTextField(20);

            JLabel description = new JLabel("<HTML><br/>Description</HTML>");
            JTextField descriptions = new JTextField(20);

            JLabel num = new JLabel("<HTML><br/>MaxScoops</HTML>");
            SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
            JSpinner nums = new JSpinner(range);

            Object[] objects = { 
                name,   names, 
                description, descriptions, 
                num,    nums};

            int button = JOptionPane.showConfirmDialog( // Show the dialog
                this,
                objects,
                "New Container",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null);

            if(button == JOptionPane.OK_OPTION){
                int maxu = (Integer) nums.getValue();
                emporium.addContainer(new Container(names.getText(), descriptions.getText(), maxu));
            }
            setDirty(true);
            view(Screen.CONTAINER);
        }catch(Exception e) {
            System.err.println("onCreateMixInFlavorClick exception: " + e);
        }
    }
    protected Scoop onCreateScoopClick() {
            IceCreamFlavor icf = (IceCreamFlavor) JOptionPane.showInputDialog(this, "Ice Cream Flavor?", "New Scoop", JOptionPane.QUESTION_MESSAGE, null, emporium.iceCreamFlavors(), null);
            if(icf != null) {
                Scoop scoop = new Scoop(icf);
                if(emporium.mixInFlavors().length > 0) {
                    String prompt = "<html>" + scoop + "<br/>Add a mix in?</html>";
                    while(true) 
                    {

                        JLabel type = new JLabel("Mix In Flavors");

                        Object[] diffmixin = emporium.mixInFlavors();
                        JComboBox<Object> types = new JComboBox<>(diffmixin);

                        JLabel amount = new JLabel(" Amount ");
                        DefaultComboBoxModel<MixInAmount> cModel = new DefaultComboBoxModel<>(MixInAmount.values());
                        JComboBox<MixInAmount> amounts = new JComboBox<>(cModel);
                        //JComboBox amounts = new JComboBox<String>(comboBox);


                        Object[] objects = { 
                            type,   types, 
                            amount, amounts};

                        int button = JOptionPane.showConfirmDialog( // Show the dialog
                            this,
                            objects,
                            "New Mix In",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null);

                        if(button == JOptionPane.OK_OPTION){
                            MixInFlavor temp = (MixInFlavor) types.getSelectedItem();
                            MixInAmount temp2 = (MixInAmount) amounts.getSelectedItem();
                        scoop.addMixIn(new MixIn(temp, temp2 ));
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                return scoop;       
            } 
        return null; 
    }

    protected Serving onCreateServingClick(){
         try {
            Container con = (Container) JOptionPane.showInputDialog(this, "container", "Create a new container", JOptionPane.QUESTION_MESSAGE, null, emporium.containers(), null);
            if(con != null) {
                Serving serve = new Serving(con);
                while(true)
                {
                    Scoop temp = onCreateScoopClick();
                    if(temp != null) 
                    {
                        serve.addScoop(temp);
                    }
                    else
                    {
                        break;
                    }
                }
                if(emporium.mixInFlavors().length > 0) {
                    String prompt = "<html>" + "<br/>Add a new Topping </html>";
                    while(true) {
                        MixInFlavor mif = (MixInFlavor) JOptionPane.showInputDialog(this, prompt, "Add Topping", JOptionPane.QUESTION_MESSAGE, null, emporium.mixInFlavors(), null);
                        if(mif == null) break;
                        MixInAmount mia = (MixInAmount) JOptionPane.showInputDialog(this, prompt, "Add Topping amount", JOptionPane.QUESTION_MESSAGE, null, MixInAmount.values(), MixInAmount.Normal);
                        serve.addTopping(new MixIn(mif, mia));
                        prompt = "<html>" + "<br/>Add another Topping? </html>";
                    }
                }
                return serve;          
            } 
        } catch(Exception e) {
            System.err.println("onCreateScoopClick exception: " + e);
        }
        return null; 
    }
    protected void onCreateOrderClick(){
        Order ord = new Order();
        while(true)
        {   
            Serving temp = onCreateServingClick();
            if(temp != null) 
            {
                ord.addServing(temp); 
            }
            else
            {
                break;
            }
        }
        emporium.addOrder(ord);
    }
    
    // File I/O Methods
    
   protected void onOpenClick() { 
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
        fc.addChoosableFileFilter(miceFiles);         // Add "Mice file" filter
        fc.setFileFilter(miceFiles);                  // Show Mice files only by default
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                //if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a MICE file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible MICE file format");
                
                emporium = new Emporium(br);                   // Open a new emporium
                //view(Screen.SCOOPS);                           // Update the user interface
                
                setDirty(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to load " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            //bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            emporium.save(bw);
            setDirty(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to write " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }

    protected void onSaveAsClick() {
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
        fc.addChoosableFileFilter(miceFiles);         // Add "MICE file" filter
        fc.setFileFilter(miceFiles);                  // Show MICE files only by default
        
        int result = fc.showSaveDialog(this);         // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) {  // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();          // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith("." + EXTENSION))  // Ensure it ends with ".mice"
                filename = new File(filename.getAbsolutePath() + "." + EXTENSION);
            onSaveClick();                           // Delegate to Save method
        }
    }

    
    // About and miscellaneous
    
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog(this, "Mavs Ice Cream Emporium");
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
/*              
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
*/
        Canvas logo = new Canvas("gui/logo.png", "gui/spiropic.txt");
        logo.setAlignmentX(Canvas.LEFT_ALIGNMENT);
        about.add(logo);
        
        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("<html>"
          + "<br/><p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        text.add(title);

        JLabel subTitle = new JLabel("<html>"
          + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        text.add(subTitle);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Version 0.4</p>"
          + "<p>Copyright 2022 by Siddhart M Bhagvagar</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "Logo by Schmidsi, per the Pixabay License"
          + "<p><font size=-2>https://pixabay.com/en/ice-ice-cream-cone-ice-ball-pink-1429596/</font></p>"
          + "<p>Ice cream icons created by Freepik - Flaticon</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/</font></p>"
          + "<p>File icons created by Pixel perfect - Flaticon</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/direct-download</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/file-upload</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/ui</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/</font></p>"
          + "<br/></html>", JLabel.CENTER);
        text.add(artists);
        about.add(text);
        
        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(panel);
        
        about.add(Box.createVerticalStrut(10));
        
        about.pack();
        about.setVisible(true);
     }
     
    private enum Screen {CONTAINER, ICE_CREAM_FLAVORS, MIX_IN_FLAVORS, ORDERS}
    private void view(Screen screen) {
        String title = "";
        StringBuilder s = new StringBuilder();
        switch(screen) {
            case CONTAINER: 
                 title = "Containers";
                 for(var t : emporium.containers()) s.append(t.toString() + "<br/>");
                 break;
             case ICE_CREAM_FLAVORS: 
                 title = "Ice Cream Flavors";
                 for(var t : emporium.iceCreamFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case MIX_IN_FLAVORS: 
                 title = "Mix In Flavors";
                 for(var t : emporium.mixInFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case ORDERS: 
                 title = "Orders";
                 for(var t : emporium.orders()) s.append(t.toString() + "<br/>");
                 break;
             default:
                 display.setText("PANIC: Invalid Displays type: " + display);
        }
        display.setText("<html><font size=+4>" + title + "<br/></font><font size=+2>" + s.toString() + "</font></html>");
    }
     
    private void setDirty(boolean isDirty) {
        save.setEnabled(isDirty);
        saveAs.setEnabled(isDirty);
        saveButton.setEnabled(isDirty);
        saveAsButton.setEnabled(isDirty);
    };
    
    private Emporium emporium;
    private File filename;

    private JLabel display;                 // Main data display

    private JMenuItem save;
    private JMenuItem saveAs;
    private JButton saveButton;
    private JButton saveAsButton;

    private JMenuItem createScoop;  // defined here so we can disable and enable it
    private JButton createScoopButton;

    // private JLabel msg;                     // Status message display
}
