package pebb;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.io.File; 
import java.io.IOException; 
import javax.imageio.ImageIO; 

public class PEBB extends JFrame{ 
	int a=80, b, c=6, s=1; 
	String d, k; 
	Double v; 
	PEBB(){ 
		setContentPane(new BgPanel()); 
		Container panel = getContentPane(); 
		panel.setLayout(null); 
	
		JLabel l1 = new JLabel("ПИ-218"); 
		l1.setSize(250, 35); 
		l1.setLocation(10,20); 
		panel.add(l1); 

		JLabel l2 = new JLabel("Бураканов"); 
		l2.setSize(600, 35); 
		l2.setLocation(630,20); 
		panel.add(l2); 
		
		JLabel l21 = new JLabel("Бикбулатов"); 
		l21.setSize(600, 35); 
		l21.setLocation(630,35); 
		panel.add(l21); 
		
		JLabel l22 = new JLabel("Елисеева Lera15020@mail.ru"); 
		l22.setSize(600, 35); 
		l22.setLocation(630,50); 
		panel.add(l22); 
		
		JLabel l23 = new JLabel("Печенкина"); 
		l23.setSize(600, 35); 
		l23.setLocation(630,65); 
		panel.add(l23); 

		JLabel l3 = new JLabel(""); 
		l3.setSize(250, 35); 
		l3.setLocation(130,50); 
		panel.add(l3); 
		
		JLabel l4 = new JLabel("http://asu.ugatu.ac.ru/"); 
		l4.setSize(250, 35); 
		l4.setLocation(450,20); 
		panel.add(l4); 
		
		JLabel l5 = new JLabel("ФГБОУ ВО"); 
		l5.setSize(70, 35); 
		l5.setLocation(10,0); 
		panel.add(l5); 
		
		JLabel l6 = new JLabel("Уфимский государственный авиационный технический университет"); 
		l6.setSize(450, 35); 
		l6.setLocation(80,0); 
		panel.add(l6); 
		
		JLabel l7 = new JLabel("Курсовая работа. 7 вариант. Расчет расхода топлива."); 
		l7.setSize(450, 35); 
		l7.setLocation(130,90); 
		panel.add(l7); 
		l7.setVisible(false); 
		
		JLabel l8 = new JLabel("Руководитель: Казанцев"); 
		l8.setSize(450, 35); 
		l8.setLocation(450,50); 
		panel.add(l8); 
		
		JLabel l9 = new JLabel("Кнопка информации добавлена"); 
		l9.setSize(450, 35); 
		l9.setLocation(10,275); 
		panel.add(l9); 
		
		JTextField t1 = new JTextField(""); 
		t1.setSize(110,35);
		t1.setLocation(10,50); 
		panel.add(t1); 

		JButton button3 = new JButton("Вывод в м"); 
		button3.setSize(110, 35); 
		button3.setLocation(10,170); 
		button3.setForeground(new Color(0,0,0)); 
		button3.addActionListener(new ActionListener(){ 
			@Override 
			public void actionPerformed(ActionEvent arg0){ 
				k = button3.getText(); 
				if (k=="Вывод в см") {
					button3.setText("Вывод в м");
					s = 1;
				}else {
					button3.setText("Вывод в см"); 
					s = 0;
				}
			} 
		}); 
		panel.add(button3); 
		
		JButton button = new JButton("Рассчитать"); 
		button.setSize(110, 35); 
		button.setLocation(10,90); 
		button.setForeground(new Color(0,0,0)); 
		button.addActionListener(new ActionListener(){ 
			@Override 
			public void actionPerformed(ActionEvent arg0){ 
				if (s==1) {
					d = t1.getText(); 
					b = Integer.parseInt(d); 
					v = 80*0.01*6*b*0.01; 
					d = "Ответ: " + v + " м^3"; 
					l3.setText(d);
				}else {
					d = t1.getText(); 
					b = Integer.parseInt(d); 
					v = 80*0.01*6*b*0.01*1000000; 
					d = "Ответ: " + v + " см^3"; 
					l3.setText(d);
				}
			} 
		}); 
		panel.add(button); 
		
		ImageIcon imgIco21 = new ImageIcon("src\\mnem.jpg");
        Image image2 = imgIco21.getImage();
        Image newimg2 = image2.getScaledInstance(450, 200,  java.awt.Image.SCALE_SMOOTH);
        imgIco21 = new ImageIcon(newimg2);
        JLabel img2 = new JLabel(imgIco21);
        img2.setSize(450,200);
        img2.setLocation(130,90);
		panel.add(img2);
		img2.setVisible(false);
		
		JButton button2 = new JButton("Мнемосхема");
        button2.setSize(110, 35);
        button2.setLocation(10,130);
        button2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) { 
        		img2.setVisible(true);
        		l7.setVisible(false); 	
        	}
        });
        panel.add(button2);
        
        JButton button4 = new JButton("Курсовая"); 
        button4.setSize(110, 35); 
        button4.setLocation(10,210); 
        button4.addActionListener(new ActionListener() { 
        	@Override 
        	public void actionPerformed(ActionEvent e) { 
        		img2.setVisible(false); 
        		l7.setVisible(true); 
        	} 
        }); 
        panel.add(button4); 
        
        JButton button5 = new JButton("Информация"); 
        button5.setSize(110, 35); 
        button5.setLocation(10,250); 
        button5.addActionListener(new ActionListener() { 
        	@Override 
        	public void actionPerformed(ActionEvent e) { 
        		secondClass.Information();
        	} 
        }); 
        panel.add(button5);
		
		setSize(926, 342); 
		setVisible(true); 
	} 
	public static void main(String[] args){ 
		new PEBB(); 
		BgPanel m = new BgPanel(); 
	} 
} 
class BgPanel extends JPanel { 
	protected void paintComponent(Graphics g) { 
			Image image = null; try { 
					image = ImageIO.read(new File("src\\logo.jpg")); 
			} 
			catch (IOException e) { 
				e.printStackTrace(); 
			} 
			super.paintComponent(g); 
			g.drawImage(image, 0, 0, null); 
	} 
}


