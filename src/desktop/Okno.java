package desktop;

import java.awt.Container;

import javax.swing.JFrame;

public class Okno extends JFrame{

	public Okno() {
	this.setBounds(0,0,900,600);         
	setTitle("my play\"x and O\"");
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	//���� ������ ��� ����
	Panel pan=new Panel();
	Container cont=getContentPane();
	cont.add(pan);
	setVisible(true);
	}
}
