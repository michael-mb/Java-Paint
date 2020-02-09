package com.javaPaint.main;
import java.awt.Color;

public class Point {

	private int xPos ;
	private int yPos ;
	private String form;
	private Color color;
	
	public Point(int xPos , int yPos , String form, Color color)
	{
		this.xPos = xPos ;
		this.yPos = yPos ;
		this.form = form ;
		this.color = color ;
	}

	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public String getForm() {
		return form;
	}
	public Color getColor() {
		return this.color;
	}

}
