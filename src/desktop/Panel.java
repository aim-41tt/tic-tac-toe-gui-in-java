package desktop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.Pole;


public class Panel  extends JPanel{
	
	private Image fon,x,o;
	private Pole PoleGame;

	
	public Panel() {
		setLayout(null);
		repaint();
		loadImage();
		PoleGame = new Pole();
		this.addMouseListener(new Mymous1());
		addMouseMotionListener(new Mymous2());
		
		

	}
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		gr.drawImage(fon,0,0,900,600,null);
		gr.setFont(new Font("serf",3,40));
		gr.setColor(Color.yellow);
		
		if(PoleGame.getznak()!='X')gr.drawImage(x, 50, 50, 100, 100,null);
		else gr.drawImage(o, 50, 50, 100, 100,null);
		
		switch (PoleGame.pravVin()) {
		case 0:{
			JOptionPane.showMessageDialog(null,"выйграл: "+PoleGame.getznak());
			break;
		}
		
		case 1:{

			JOptionPane.showMessageDialog(null,"выйграл: "+PoleGame.getznak());
			break;
		}

		case 2:{
			
			 gr.drawLine(200, 50, 700, 80);
			break;
		}

		case 3:{
			
			break;
		}

		case 4:{
			
			break;
		}
		case 5:{
			
			break;
		}

		case 6:{
			
			break;
		}
		case 7:{
			
			break;
		}
		}
		
		for(int i=0;i<PoleGame.pole.length;i++){
		for(int j=0;j<PoleGame.pole[0].length;j++){
		
			if(PoleGame.pole[i][j] != ' '){
			if(PoleGame.pole[i][j] == 'X'){
				gr.drawImage(x, 210+j*160, 50+i*160, 160, 160,null);
				
			}else if(PoleGame.pole[i][j]=='O'){
				gr.drawImage(o, 210+j*160, 50+i*160, 160, 160,null);
			}}
			}}
		
		
		
		 gr.drawRect(200, 50, 500, 500);
	}
	
	public void loadImage() {
	try {
		fon	 = ImageIO.read(new File("png/fon.png"));
		x = ImageIO.read(new File("png/X.png"));
		o = ImageIO.read(new File("png/O.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	private int mx,my;
	public class Mymous1 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
 	    }
		@Override
		public void mousePressed(MouseEvent e) {
			
			
			//1 cliced LCM 1 
			if(e.getButton()==1 && e.getClickCount()==1){
				//opr x y 
			mx=e.getX();
			my=e.getY();
			System.out.println(my+"  "+mx);
			if(mx>200 && mx<700 && my>50 && my<500){
				int i=(mx-200)/165;
				int j=(my-50)/165;
				System.out.println(i+"  "+j);
				PoleGame.User_hod(j, i);
				repaint();
				/*
				 * 200, 50, 500, 500
				 *  x	y	отступ:
				 */					
				}
			}
			
			}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}	
	}
	
	public class Mymous2  implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
	
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		
		if(mx>200 && mx<700 && my>50 && my<500){
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
			else{
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}

}
