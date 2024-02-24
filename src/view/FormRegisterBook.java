package view;

import javax.swing.JFrame;

public class FormRegisterBook extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public FormRegisterBook() {
		init();
	}
	
	public void init() {
		configurateScreen();
	}
	
	public void configurateScreen() {
		setLayout(null);
		setTitle("Cadastrar Livro");
		setSize(300, 300);
		setLocationRelativeTo(null);
	}
}
