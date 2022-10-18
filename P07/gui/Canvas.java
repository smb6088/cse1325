package gui;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel
{
	public Canvas(){
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public Dimension getPreferredSize(){
		return new Dimension(250,200);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}