package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Book;
import model.dao.BookDao;
import model.dao.FactoryDao;

public class FormRegisterBook extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel jNameBook = new JLabel("Nome do livro");
	private JTextField jTextNameBook = new JTextField(); 
	private JLabel jNameAuthor = new JLabel("Nome do autor");
	private JTextField jTextNameAuthor = new JTextField();
	private JLabel jDescriptionBook = new JLabel("Descrição do livro");
	private JTextArea jTextDescriptionBook = new JTextArea();
	private JButton consultBooks = new JButton("Mostar livros");
	private JButton saveBook = new JButton("Salvar");
	
	
	public FormRegisterBook() {
		init();
		configurateComponents();
		addCompenentsInScreen();
		consultAllBooks();
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
		consultBooks.setBounds(20, 275, 110, 30);
		saveBook.setBounds(160, 275, 100, 30);
	}
	
	private void addCompenentsInScreen() {
		getContentPane().add(jNameBook);
		getContentPane().add(jTextNameBook);
		getContentPane().add(jNameAuthor);
		getContentPane().add(jTextNameAuthor);
		getContentPane().add(jDescriptionBook);
		getContentPane().add(jTextDescriptionBook);
		getContentPane().add(consultBooks);
		getContentPane().add(saveBook); 
	}
	
	private void consultAllBooks() {
		consultBooks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BookDao dao = FactoryDao.createBookDao();
				
				List<Book> list = dao.findAll();
				System.out.println(list);
				
			}
		});
	}
}
