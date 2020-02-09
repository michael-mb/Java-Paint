package com.javaPaint.main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	// Menu Element
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu mFile = new JMenu("File");
	private JMenuItem mErase = new JMenuItem("Erase");
	private JMenuItem mQuit = new JMenuItem("Quit");
	
	private JMenu mEdit = new JMenu("Edit");
	
	private JMenu mPointer = new JMenu("Pointer shape");
	 private JRadioButtonMenuItem mCircle = new JRadioButtonMenuItem("Circle");
	 private JRadioButtonMenuItem mSquare = new JRadioButtonMenuItem("Square");
	 
	private JMenu mPointerColor = new JMenu("pointer color");
	 private JRadioButtonMenuItem mRed = new JRadioButtonMenuItem("Red");
	 private JRadioButtonMenuItem mBlue = new JRadioButtonMenuItem("Blue");
	 private JRadioButtonMenuItem mGreen = new JRadioButtonMenuItem("Green");
	
	 // Toolbar Element
	 private Color fondBouton = Color.white;
	 private JToolBar toolBar = new JToolBar(); 
	 private JButton   
	 				BSquare = new JButton(new ImageIcon("images/carre.jpg")),
	 				BCircle = new JButton(new ImageIcon("images/rond.jpg")),
	 				BRedSquare = new JButton(new ImageIcon("images/carrerouge.jpg")),
	 				BGreenSquare = new JButton(new ImageIcon("images/carrevert.jpg")),
	 				BBlueSquare = new JButton(new ImageIcon("images/carrebleu.jpg"));
	 
	 JPanel conteneur = new JPanel();
	 
	 Panel panel = new Panel();
	 
	public Window(){
		initFenetre();
		initMenu();
		initToolbar();
		
		initListener();
		this.setVisible(true);

	}
	
	public void initFenetre() {
		this.setTitle(" JAVA PAINT!");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		
		conteneur.setLayout(new BorderLayout());
		conteneur.add(panel,BorderLayout.CENTER);
		this.setContentPane(conteneur);
	}
	
	public void initMenu() {
		mErase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		mQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		mFile.add(mErase);
		mFile.add(mQuit);
		
		ButtonGroup formeBg = new ButtonGroup();
		formeBg.add(mCircle);
		formeBg.add(mSquare);
		
		mPointer.add(mCircle);
		mPointer.add(mSquare);
		
		ButtonGroup couleurBg = new ButtonGroup();
		couleurBg.add(mRed);
		couleurBg.add(mBlue);
		couleurBg.add(mGreen);
		
		mPointerColor.add(mRed);
		mPointerColor.add(mBlue);
		mPointerColor.add(mGreen);
		
		mEdit.add(mPointer);
		mEdit.add(mPointerColor);
		
		menuBar.add(mFile);
		menuBar.add(mEdit);
		
		this.setJMenuBar(menuBar);
	}
	
	public void initToolbar() {
		
		// Background Color 
		BSquare.setBackground(fondBouton);
		BCircle.setBackground(fondBouton);
		BRedSquare.setBackground(fondBouton);
		BGreenSquare.setBackground(fondBouton);
		BBlueSquare.setBackground(fondBouton);
		
		
		toolBar.add(BSquare);
		toolBar.add(BCircle);
		toolBar.addSeparator();
		
		toolBar.add(BRedSquare);
		toolBar.add(BGreenSquare);
		toolBar.add(BBlueSquare);
		
		conteneur.add(toolBar, BorderLayout.NORTH); 
		
	}
	
	public void initListener() {
		
		SelectForm selectForm = new SelectForm();
		SelectColor selectColor = new SelectColor();
		EraseAll eraseAll = new EraseAll();
		
		mQuit.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent event){
		          System.exit(0);
		        }
		      });
		
		mCircle.addActionListener(selectForm);
		mSquare.addActionListener(selectForm);
		BCircle.addActionListener(selectForm);
		BSquare.addActionListener(selectForm);
		
		mRed.addActionListener(selectColor);
		mGreen.addActionListener(selectColor);
		mBlue.addActionListener(selectColor);
		
		BRedSquare.addActionListener(selectColor);
		BGreenSquare.addActionListener(selectColor);
		BBlueSquare.addActionListener(selectColor);
		
		mErase.addActionListener(eraseAll);
		
	}
	
	  class SelectForm implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 if(e.getSource().getClass().getName().equals("javax.swing.JRadioButtonMenuItem"))
				 {
					 panel.setForm(((JRadioButtonMenuItem)e.getSource()).getText()); 
				 }		 
				 else{  
				    	
				        if(e.getSource() == BSquare){
				          mSquare.doClick();
				        }
				        else{
				          mCircle.doClick();
				        }
				      }
				 		
				}
		  }
	  
	  
	  class SelectColor implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 if(e.getSource().getClass().getName().equals("javax.swing.JRadioButtonMenuItem"))
				 {
				 
					 String str = ((JRadioButtonMenuItem)e.getSource()).getText(); 
				     if(str.equals("Red")){
				    	 panel.setColor(Color.red); 
				     }
				     else if(str.equals("Green")){
				    	 panel.setColor(Color.green);
				     }
				     else{
				    	 panel.setColor(Color.blue);
				     }
				    
				 }		 
				 else{  
				    	
				        if(e.getSource() == BRedSquare){
				        	mRed.doClick();
				        }
				        else if(e.getSource() == BGreenSquare){
				        	mGreen.doClick();
				        }
				        else{
				        	mBlue.doClick();
				        }
				      }
				 		
				}
		  }
	
	  class EraseAll implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.eraseAll();
			}
		  }

	
	
}
