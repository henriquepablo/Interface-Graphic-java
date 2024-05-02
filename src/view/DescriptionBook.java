package view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DescriptionBook extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTextArea Description = new JTextArea();
	private Integer id;
	
	public DescriptionBook(Integer id) {
		this.id = id;
		init();
	}
	
	private void init() {
		configurateScreen();
		configurateComponents();
		addComponentsInScreen();
	}
	
	private void configurateScreen() {
		setLayout(null);
		setSize(300, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void configurateComponents() {
		Description.setBounds(0, 0, 300, 180);
		Description.setLineWrap(true);
		Description.setEditable(false);
		System.out.println(id);
	}
	
	private void addComponentsInScreen() {
		getContentPane().add(Description);
	}
}
