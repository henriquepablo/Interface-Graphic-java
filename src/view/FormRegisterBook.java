package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormRegisterBook extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel jNameBook = new JLabel("Nome do livro");
	private JTextField jTextNameBook = new JTextField(); 
	private JLabel jNameAuthor = new JLabel("Nome do autor");
	private JTextField jTextNameAuthor = new JTextField();
	private JLabel jDescriptionBook = new JLabel("Descrição do livro");
	private JTextArea jTextDescriptionBook = new JTextArea();
	
	
	public FormRegisterBook() {
		init();
		configurateComponents();
		addCompenentsInScreen();
	}
	
	private void init() {
		configurateScreen();
	}
	
	private void configurateScreen() {
		setLayout(null);
		setTitle("Cadastrar Livro");
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void configurateComponents() {
		jNameBook.setBounds(20, 20, 80, 20);
		jTextNameBook.setBounds(20, 40, 240, 25);
		jNameAuthor.setBounds(20, 75, 100, 20);
		jTextNameAuthor.setBounds(20, 95, 240, 25);
		jDescriptionBook.setBounds(20, 130, 120, 20);
		jTextDescriptionBook.setBounds(20, 153, 240, 100);
		jTextDescriptionBook.setLineWrap(true);
	}
	
	private void addCompenentsInScreen() {
		getContentPane().add(jNameBook);
		getContentPane().add(jTextNameBook);
		getContentPane().add(jNameAuthor);
		getContentPane().add(jTextNameAuthor);
		getContentPane().add(jDescriptionBook);
		getContentPane().add(jTextDescriptionBook);
	}
}
