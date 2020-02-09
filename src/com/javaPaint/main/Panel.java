package com.javaPaint.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel implements MouseMotionListener{

	private Color formColor = Color.black;
	private int posX=50 ;
	private int posY=50;
	private static final int drawSize=30;
	Graphics g ;
	private ArrayList<Point> points;
	private String form ="CIRCLE";
	
	public Panel ()
	{
		addMouseMotionListener(this);
		points = new ArrayList<>();
	}
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
        g.setColor(Color.white);        
        g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
        if (!points.isEmpty())
        {
        	for(Point p : points)
        	{
        		draw(g , p.getxPos() , p.getyPos() , p.getForm(),p.getColor());
        	}
        }
        g.setColor(formColor);
        draw(g , posX , posY , form, formColor);
    }
    
    public void draw(Graphics g ,int  x , int  y , String forme , Color formColor)
    {
    	g.setColor(formColor);
    	if (forme.equals("CIRCLE"))
    		g.fillOval(x, y, drawSize , drawSize );
    	
    	else if (forme.equals("SQUARE"))
    		g.fillRect(x, y, drawSize , drawSize );	
    }
    
    public int getPosX()
    {
    	return posX;
    }
    public int getPosY()
    {
    	return posY;
    }

    public void setPosX(int posX)
    {
    	this.posX=posX;
    }
    public void setPosY(int posY)
    {
    	this.posY=posY;
    }
    
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int newX = e.getX()-drawSize/2;
		int newY = e.getY()-drawSize/2;
		points.add(new Point(newX,newY,form,formColor));
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int newX = e.getX()-drawSize/2;
		int newY = e.getY()-drawSize/2;
		this.setPosX(newX);
		this.setPosY(newY);
		this.repaint();
	}
	
	public void setForm(String form)
	{
		this.form = form.toUpperCase();
	}
	
	public void setColor(Color formColor)
	{
		this.formColor = formColor ;
	}
	
	public void eraseAll()
	{
		points = new ArrayList<>();
		repaint();
	}
}
