package gui;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel
{
	public Canvas(){
		setBorder(BorderFactory.createLineBorder(Color.white));
	}
	public Dimension getPreferredSize(){
		return new Dimension(400,400);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(50,50,200,150);
		g.drawRect(60,15,150,100);
		g.setColor(new Color(255, 100, 220, 128));
		g.drawRect(15,10,100,50);
		g.drawRect(10,5,50,25);
		g.drawRect(5,5,200,150);
		g.setColor(Color.getHSBColor(255, 79, 18));
		g.drawRect(20,20,200,150);
		g.setColor(Color.black);
        g.drawString("Bhagvagar, Siddharth",270,80);
		
	}
	
}