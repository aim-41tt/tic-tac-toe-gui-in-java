package desktop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import game.Pole;


public class Panel  extends JPanel{
	
	private Image fon, image_x, image_o, vin_o, vin_x;
	private Pole PoleGame;
	private JButton btnRestartGame;

	
	public Panel() {
		setLayout(null);
		repaint();
		loadImage();
		
		PoleGame = new Pole();
		this.addMouseListener(new Mymous1());
		addMouseMotionListener(new Mymous2());
		
		
		btnRestartGame = new JButton();
		btnRestartGame.setBounds(20, 180, 120, 40);
		btnRestartGame.setText("Restart");
		btnRestartGame.setFont(new Font("serif",0,20));
		btnRestartGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PoleGame.resetPole();
				repaint();
			}
		});
		add(btnRestartGame);
	}
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		gr.drawImage(fon,0,0,900,600,null);
		gr.setFont(new Font("serf",3,40));
		gr.setColor(Color.yellow);
		
		
		
		for(int i=0;i<PoleGame.pole.length;i++){
			for(int j=0;j<PoleGame.pole[0].length;j++){
				int imgPx = 165;
				if(PoleGame.pole[i][j] != ' '){
				if(PoleGame.pole[i][j] == 'X'){
					gr.drawImage(image_x, 200+j*imgPx, 50+i*imgPx, imgPx, imgPx,null);
					
				}else if(PoleGame.pole[i][j]=='O'){
					gr.drawImage(image_o, 200+j*imgPx, 50+i*imgPx, imgPx, imgPx,null);
				}}
				}}
			
		

		gr.setColor(Color.blue);
		switch (PoleGame.pravVin()) {
		case 0:{
			gr.drawLine(200, 130, 700, 130);
			vinDesktop(gr, PoleGame.getznak());
			break;
		}
		
		case 1:{
			gr.drawLine(200, 290, 700, 290);
			vinDesktop(gr, PoleGame.getznak());
			break;
		}

		case 2:{
			gr.drawLine(200, 450, 700, 450 );
			vinDesktop(gr, PoleGame.getznak());
			break;
		}

		case 3:{
			gr.drawLine(280, 50 , 280, 500);
			vinDesktop(gr, PoleGame.getznak());
			break;
		}

		case 4:{
			gr.drawLine(440, 50 , 440, 500);
			vinDesktop(gr, PoleGame.getznak());
			break;
		}
		case 5:{
			gr.drawLine(600, 50 , 600, 500);
			vinDesktop(gr, PoleGame.getznak());
			break;
		}

		
		case 6:{
			gr.drawLine(200, 50 , 700, 550);
			vinDesktop(gr, PoleGame.getznak());
			break;
		}
		case 7:{
			gr.drawLine(700, 50 , 200, 550);
			vinDesktop(gr, PoleGame.getznak());
			break;
		}
		}
		
		/*
		 * удалить перед релизом
		*/
		
		 // del
		 
		 if(PoleGame.getznak()!='X')gr.drawImage(image_x, 50, 50, 100, 100,null);
			else gr.drawImage(image_o, 50, 50, 100, 100,null);
			
	}
	
	
	private void vinDesktop(Graphics gr , char znak) {
		
		if(znak == 'x') {
			gr.drawImage(vin_x, 2500,200 ,250,100,null);
		}else if(znak == 'O') {
			gr.drawImage(vin_o, 250,200 ,250,100,null);
		}
		
		
		
	}
	
	public void loadImage() {
	try {
		fon	 = ImageIO.read(new File("png/fon.png"));
		image_x = ImageIO.read(new File("png/X.png"));
		image_o = ImageIO.read(new File("png/O.png"));
		vin_x = ImageIO.read(new File("png/vin_x.png"));
		vin_o = ImageIO.read(new File("png/vin_o.png"));
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
			if(mx>200 && mx<700 && my>50 && my<550){
				int i=(mx-200)/165;
				int j=(my-50)/165;
				System.out.println(i+"  "+j);
				PoleGame.User_hod(j, i);
				repaint();		
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
		
		if(mx>200 && mx<700 && my>50 && my<550){
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
			else{
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
	
	

}
