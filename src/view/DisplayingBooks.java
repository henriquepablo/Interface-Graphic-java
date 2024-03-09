package view;

import java.awt.Label;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.Book;
import model.dao.BookDao;
import model.dao.FactoryDao;

public class DisplayingBooks extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Label idBook = new Label("ID");
	private Label nameBooks = new Label("Nome do livro");
	private Label nameAuthor = new Label("Nome do autor");
	private JTextArea DescriptionBook = new JTextArea();
	private JButton editBook = new JButton("Editar livro");
	private JButton deleteBook = new JButton("Apagar ");
	private JButton displayDescriptionyBook = new JButton("Descrição");
	private JButton registerBook = new JButton("Cadastrar");

	public DisplayingBooks() {
		init();
		configurateComponents();
		addCompenentsInScreen();
		
		BookDao dao = FactoryDao.createBookDao();
		List<Book> list = dao.findAll();
		System.out.println(list);

	}
	
	private void init() {
		configurateScreen();
	}

	private void configurateScreen() {
		setLayout(null);
		setTitle("Exibir Livros");
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void configurateComponents() {
		idBook.setBounds(20, 15, 15, 15);
		nameBooks.setBounds(60, 15, 80, 15);
		nameAuthor.setBounds(175, 15, 85, 15);
		DescriptionBook.setBounds(20, 40, 240, 180);
		DescriptionBook.setLineWrap(true);
		editBook.setBounds(20, 240, 100, 30);
		deleteBook.setBounds(160, 240, 100, 30);
		displayDescriptionyBook.setBounds(20, 280, 100, 30);
		registerBook.setBounds(160, 280, 100, 30);
	}
	
	private void addCompenentsInScreen() {
		getContentPane().add(DescriptionBook);
		getContentPane().add(idBook);
		getContentPane().add(nameBooks);
		getContentPane().add(nameAuthor);
		getContentPane().add(editBook);
		getContentPane().add(deleteBook);
		getContentPane().add(displayDescriptionyBook);
		getContentPane().add(registerBook);
	}
}
