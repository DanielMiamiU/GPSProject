import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class User {

	private static char start = 'A';
	private static char end = 'A';
	private static int route = 1;
	
	private static String fromText = "From: ";
	private static String toText = "To: ";
	private static String howText = "Which Path: ";
	
	public static void main(String[] args) {
		JFrame gps = new JFrame();
		gps.setSize(585, 505);
		gps.setDefaultCloseOperation(3);
		gps.setLayout(new BorderLayout());
		
		JPanel list = new JPanel();
		list.setLayout(new GridLayout(5,4));
		Graph g = new Graph("MapInformation-1.txt");
		JMenuBar jmbf = new JMenuBar();
		JMenuBar jmbt = new JMenuBar();
		JMenuBar jmbh = new JMenuBar();
		
		JTextField fr = new JTextField(fromText);
		JTextField t = new JTextField(toText);
		JTextField h = new JTextField(howText);
		
		JMenu from = new JMenu("Current Address");
		JMenu to = new JMenu("To Address");
		for (char i = 'A'; i < 'U'; i++) {
			JLabel add = new JLabel(g.vCheck.get(i).toString());
			
			JMenuItem to1 = new JMenuItem(g.vCheck.get(i).toString());
			to1.setMnemonic(KeyEvent.VK_N);
			to1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					end = to1.getText().charAt(0);
					t.setText(toText + to1.getText());
				}
				
			});
			
			JMenuItem from1 = new JMenuItem(g.vCheck.get(i).toString());
			from1.setMnemonic(KeyEvent.VK_N);
			from1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					start = from1.getText().charAt(0);
					
					fr.setText(fromText + from1.getText());
				}
				
			});
			
			list.add(add);
			to.add(to1);
			from.add(from1);
		}
		gps.add(list, BorderLayout.NORTH);
		
		 
		
		JPanel mid = new JPanel();
		mid.setLayout(new GridLayout(2,3));
		
		JMenu how = new JMenu("Which Way?");
		JMenuItem time = new JMenuItem("Time");
		time.setMnemonic(KeyEvent.VK_N);
		time.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				route = 1;
				h.setText(howText + "Best Time");
			}
			
		});
		
		JMenuItem dis = new JMenuItem("Distance");
		dis.setMnemonic(KeyEvent.VK_N);
		dis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				route = 2;
				h.setText(howText + "Shortest Distance");
			}
			
		});
		
		JMenuItem pol = new JMenuItem("Number of Police");
		pol.setMnemonic(KeyEvent.VK_N);
		pol.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				route = 3;
				h.setText(howText + "Least Police");
			}
			
		});
		
		how.add(time);
		how.add(dis);
		how.add(pol);
		
		jmbf.add(from);
		mid.add(jmbf);
		
		jmbt.add(to);
		mid.add(jmbt);
		
		jmbh.add(how);
		mid.add(jmbh);
		
		mid.add(fr);
		mid.add(t);
		mid.add(h);
		
		gps.add(mid, BorderLayout.CENTER);
		
		JPanel bot = new JPanel();
		bot.setLayout(new BorderLayout());
		JButton calc = new JButton("Calculate");
		bot.add(calc, BorderLayout.NORTH);
		
		JTextField finish = new JTextField();
		bot.add(finish, BorderLayout.SOUTH);
		
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Path p = Dijkstras.shortestPath(route, start, end);
				if (p == null) {
					finish.setText("Invalid path, cannot go from " + start + " To " + end);
				} else {
					finish.setText("Shortest Path: " + p.name + ", Shortest Cost: " + p.cost);
				}
			}
			
		});
		
		
		gps.add(bot, BorderLayout.SOUTH);
		
		gps.setVisible(true);
		
	}
}
