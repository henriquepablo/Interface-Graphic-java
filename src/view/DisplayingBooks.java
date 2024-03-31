package view;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private BookDao dao = FactoryDao.createBookDao();

	public DisplayingBooks() {
		init();
		configurateComponents();
		addCompenentsInScreen();
		writeBookInScreen();
		searchBookById();
		backToMainScreen();
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
		DescriptionBook.setEditable(false);
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
	
	private void writeBookInScreen() {
		for (Book book: dao.findAll()) {
			DescriptionBook.append(String.valueOf(book.getId()).concat("          ") 
			+ book.getNameBook().concat("          ") 
			+ book.getNameAuthor() + "\n");
			
		}
	}
	
	private void searchBookById() {
		editBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new SearchBook("edit");
				
				dispose();
				
			}
		});
	}
	
	private void backToMainScreen() {
		registerBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FormRegisterBook();
				
				dispose();
				
			}
		});
	}
}
